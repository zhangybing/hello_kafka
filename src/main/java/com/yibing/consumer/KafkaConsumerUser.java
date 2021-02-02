package com.yibing.consumer;

import com.yibing.serializer.User;
import com.yibing.serializer.UserDefineDeSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class KafkaConsumerUser {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "CentOS:9092,CentOS2:9092,CentOS3:9092");
        //反序列化设置
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UserDefineDeSerializer.class.getName());
        //设置消费者组信息
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"g1");
        //创建consumer
        KafkaConsumer<String,User> consumer = new KafkaConsumer<String,User>(props);
        //订阅相关的topic
        consumer.subscribe(Arrays.asList("topic01"));
        while(true){
            ConsumerRecords<String,User> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            if(!consumerRecords.isEmpty()){
                Iterator<ConsumerRecord<String, User>> record = consumerRecords.iterator();
                while(record.hasNext()){
                    ConsumerRecord<String,User> msg = record.next();
                    //主题名
                    String topic = msg.topic();
                    //分区
                    int partition = msg.partition();
                    //偏移量
                    long offsert = msg.offset();
                    String key = msg.key();
                    User user = msg.value();
                    long time = msg.timestamp();
                    System.out.println("主题名："+topic+",分区："+partition+",偏移量："+offsert+",key:"+key+",val:"+user.toString());
                }

            }
        }






    }
}
