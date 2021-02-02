package com.yibing.producer;

import com.yibing.serializer.User;
import com.yibing.serializer.UserDefineSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author Administrator
 */
public class KafkaProducerUser {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "CentOS:9092,CentOS2:9092,CentOS3:9092");
        //序列化设置
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UserDefineSerializer.class.getName());
        KafkaProducer<String, User> producer = new KafkaProducer<String, User>(props);
        for (int i = 0; i < 100000; i++) {
            ProducerRecord<String, User> record = new ProducerRecord<String, User>
                    ("topic01", "key" + i, new User("张一兵", 170, "电影"));
            //发送消息给kafka
            producer.send(record);
        }
        producer.close();
    }
}
