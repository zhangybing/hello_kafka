package com.yibing.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class KafkaConsumerStart {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "CentOS1:9092,CentOS2:9092,CentOS3:9092");
        //反序列化设置
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        //设置消费者组信息
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"g1");
        //创建consumer
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
        //订阅相关的topic
        consumer.subscribe(Pattern.compile("^topic.*"));
        while(true){
            ConsumerRecords<String,String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            if(!consumerRecords.isEmpty()){
                Iterator<ConsumerRecord<String,String>> record = consumerRecords.iterator();
                while(record.hasNext()){
                    ConsumerRecord<String,String> msg = record.next();
                    //主题名
                    String topic = msg.topic();
                    //分区
                    int partition = msg.partition();
                    //偏移量
                    long offsert = msg.offset();
                    String key = msg.key();
                    String val = msg.value();
                    long time = msg.timestamp();
                    System.out.println("主题名："+topic+",分区："+partition+",偏移量："+offsert+",key:"+key+",val:"+val+",time:"+time);
                }

            }
        }






    }
}
