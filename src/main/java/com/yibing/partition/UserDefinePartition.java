package com.yibing.partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author Administrator
 * <p>
 * 自定义分区策略
 */
public class UserDefinePartition implements Partitioner {
    /**
     * 返回分区号
     * @param s
     * @param o
     * @param bytes
     * @param o1
     * @param bytes1
     * @param cluster
     * @return
     */
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        return 0;
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("config");
    }
}
