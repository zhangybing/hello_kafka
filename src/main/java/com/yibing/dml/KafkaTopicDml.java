package com.yibing.dml;

import org.apache.kafka.clients.admin.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author Administrator
 *
 * 注意要配置主机名映射，修改hosts文件，修改本机 host 文件（路径：C:\Windows\System32\drivers\etc
 * 192.168.233.128 CentOS1
 * 192.168.233.129 CentOS2
 * 192.168.233.130 CentOS3
 */
public class KafkaTopicDml {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建客户端
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                "CentOS1:9092,CentOS2:9092,CentOS3:9092");
        KafkaAdminClient client = (KafkaAdminClient) KafkaAdminClient.create(props);

        //创建Topic
//        CreateTopicsResult topicsResult = client.createTopics(Arrays.asList(new NewTopic("topic03",3,(short) 3)));
//        topicsResult.all().get();





        //topic删除
//        DeleteTopicsResult deleteTopicsResult = client.deleteTopics(Arrays.asList("topic01", "topic02"));
//        deleteTopicsResult.all().get();

        //查看Topic列表
        ListTopicsResult topicList = client.listTopics();
        Set<String> names = topicList.names().get();
        for (String name: names) {
            System.out.println(name);
        }

        //查看topic详情
        DescribeTopicsResult describeTopicsResult = client.describeTopics(Arrays.asList("topic03"));
        Map<String,TopicDescription>  topicDescsMap = describeTopicsResult.all().get();
        for(Map.Entry<String,TopicDescription>  enty : topicDescsMap.entrySet()){
            System.out.println(enty.getKey()+"\t"+enty.getValue());
        }

        //关闭
        client.close();
    }
}
