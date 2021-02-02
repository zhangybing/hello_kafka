package com.yibing.intercaptor;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author Administrator
 */
public class KafkaProducerIntecaptor {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "CentOS1:9092,CentOS2:9092,CentOS3:9092");
        //序列化设置
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, UserDefineIntercaptor.class.getName());
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(props);
        for (int i = 0; i <10 ; i++) {
            ProducerRecord<String,String> record = new ProducerRecord<String, String>("topic01","key"+i,"val"+i);
            //发送消息给kafka
            producer.send(record);
        }
        producer.close();
    }
}
