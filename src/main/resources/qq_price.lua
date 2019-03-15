--
-- Created by IntelliJ IDEA.
-- User: ZhouLiMing
-- Date: 2018/10/19
-- Time: 9:50
-- To change this template use File | Settings | File Templates.
--
-- 这个函数对输入关键字进行大小写进行忽略操作
-- input: xxxAAAbbbCCC测试; output: [xX][xX][xX][aA][aA][aA][bB][bB][bB][cC][cC][cC]测试
local function case_insensitive_pattern(pattern)
    -- find an optional '%' (group 1) followed by any character (group 2)
    local p = pattern:gsub("(%%?)(.)", function(percent, letter)
        if percent ~= "" or not letter:match("%a") then
            -- if the '%' matched, or `letter` is not a letter, return "as is"
            return percent .. letter
        else
            -- else, return a case-insensitive character class of the matched letter
            return string.format("[%s%s]", letter:lower(), letter:upper())
        end
    end)
    return p
end

-- json字符串反序列化成对象
local function deserialization_to_object(jsonObject)
--    删除"staffName"干扰
    return jsonObject.staffName .. " " .. jsonObject.time .. " " .. jsonObject.message
end

local redisKey = KEYS[1]
local primaryKey = case_insensitive_pattern(ARGV[1])
local result = {}
local result_index = 1
local len = redis.call('ZCARD', redisKey)
local rows = redis.call('ZREVRANGE', redisKey, 0, len)
local start = tonumber(ARGV[2])
local limit = tonumber(ARGV[3])
-- 类型筛选条件，包括1:所有,2:图片
local selectType = ARGV[4]
local count = 0

for _, value in pairs(rows) do
    -- 去除所有无用字符串干扰，比如staffName, time, message等
    local enpos = nil
    if (selectType == "1") then
        -- 修改去除图片url的影响
        local replacedString, _ = string.gsub(value, "%[CQ:image.-%]", "")
        enpos = string.find(deserialization_to_object(cjson.decode(replacedString)), primaryKey)
    elseif (selectType == "2") then
        -- 直接筛选图片的数据
        enpos = string.find(value, "%[CQ:image.-%]")
    end
    if nil ~= enpos then
        count = count + 1
        if start < count and count <= (limit + start) then
            result[result_index] = value
            result_index = result_index + 1
        end
    end
end
return {result, count}