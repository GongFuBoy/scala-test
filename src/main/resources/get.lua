--
-- Created by IntelliJ IDEA.
-- User: ZhouLiMing
-- Date: 2018/10/19
-- Time: 9:50
-- To change this template use File | Settings | File Templates.
--

local redisKey = KEYS[1]
local primaryKey = ARGV[1]
local result = {}
local result_index = 1
local len = redis.call('ZCARD', redisKey)
local rows = redis.call('ZREVRANGE', redisKey, 0, len)
local start = tonumber(ARGV[2])
local limit = tonumber(ARGV[3])
local count = 0

local replacedStringRe = {}

for _, value in pairs(rows) do
    local replacedString, _ = string.gsub(value, "^%[CQ:image.term=2%]$", "")
    local _, enpos = string.find(replacedString, primaryKey)
    if nil ~= enpos then
        count = count + 1
        if start < count and count <= (limit + start) then
            replacedStringRe[result_index] = replacedString
            result[result_index] = value
            result_index = result_index + 1
        end
    end
end
return {result, count, replacedStringRe}