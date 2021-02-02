package com.yibing.intercaptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author admin
 */
public class UserDefineIntercaptor implements ProducerInterceptor {
    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return new ProducerRecord(producerRecord.topic(),producerRecord.key(),producerRecord.value()+"-----yibing");
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
       System.out.println("MetaData:"+recordMetadata+",Exception:"+e);
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("configure");
    }
}
