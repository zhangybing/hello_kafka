package com.yibing.serializer;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author Administrator
 * 自定义序列化
 */
public class UserDefineSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        System.out.println("configure");
    }

    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
