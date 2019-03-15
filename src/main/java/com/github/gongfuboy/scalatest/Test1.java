package com.github.gongfuboy.scalatest;

/**
 * Created by ZhouLiMing on 2019/3/5.
 */

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        public static void main(String[] args) {
            Map m = new HashMap();
            while (true)
                for (int i = 0; i < 10000; i++) {
                    if (!m.containsKey(new SoftReference<>(new Key(i))))
                        m.put(new SoftReference<>(new Key(i)), "asda" + i);
                }

        }
    }
}
