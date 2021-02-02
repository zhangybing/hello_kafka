package com.yibing.serializer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;
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

    /**
     * 把数据序列化为字节
     * @param s
     * @param o
     * @return
     */
    @Override
    public byte[] serialize(String s, Object o) {
        return SerializationUtils.serialize((Serializable) o);
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
