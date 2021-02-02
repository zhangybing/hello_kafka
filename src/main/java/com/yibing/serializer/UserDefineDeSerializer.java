package com.yibing.serializer;

import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @author admin
 */
public class UserDefineDeSerializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        System.out.println("configure");
    }

    /**
     * 反序列化
     * @param s
     * @param bytes
     * @return
     */
    @Override
    public Object deserialize(String s, byte[] bytes) {
        return null;
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
