package com.yaojiafeng.common.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

/**
 * Created by yaojiafeng on 2017/6/2 下午2:04.
 */
public class Mongos {

    public static void main(String[] args) {
        List<ServerAddress> seedList = new ArrayList<>();
        seedList.add(new ServerAddress("172.30.193.169", 27017));
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClient(seedList), "test");
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);

//        System.out.println(mongoTemplate.getCollectionNames());

//        System.out.println(mongoTemplate.getCollectionName(Message.class));

//        System.out.println(mongoTemplate.collectionExists(Message.class));

        BasicDBObject location = new BasicDBObject("type", "Point").append("coordinates", new double[]{104.07642, 38.6518});

        Message message = new Message("topic", location);
        Query query = new Query();
        Update update = new Update();


        /**
         * 不指定集合名，使用类名小写作为集合名
         */
//        message = mongoTemplate.findOne(query, Message.class);
//        System.out.println(message);

//        message = mongoTemplate.findOne(query, Message.class, "message");
//        System.out.println(message);

        /**
         * 查询列表
         */
//        List<Message> messages = mongoTemplate.find(query, Message.class);
//        System.out.println(messages);

        /**
         * 根据id查询
         */
//        message = mongoTemplate.findById("5931204d8a89ba2747b8b849", Message.class);
//        System.out.println(message);


        /**
         * 修改
         */
//        Criteria criteria = new Criteria();
//        criteria.and("topic").is("test");
//        query.addCriteria(criteria);
//        update.set("topic","topic");
//        mongoTemplate.findAndModify(query, update, Message.class);

        /**
         * 查找一个并删除
         */
//        message = mongoTemplate.findAndRemove(query, Message.class);
//        System.out.println(message);


        /**
         * 计数
         */
//        long count = mongoTemplate.count(query, Message.class);
//        System.out.println(count);

        /**
         * 新增
         */
//        mongoTemplate.insert(message);

        /**
         * 批量新增
         */
//        mongoTemplate.insert(Arrays.asList(message), Message.class);

        /**
         * 根据id查询，存在修改，不存在新增
         */
//        mongoTemplate.save(message);

        /**
         * 删除，根据id
         */
//        mongoTemplate.remove(message);


        /**
         * 高级操作
         */

        /**
         * 聚合
         */
//        TypedAggregation<Message> aggregation = Aggregation.newAggregation(
//                Message.class,
//                Aggregation.group("topic").count().as("totalNum"),
//                Aggregation.project("topic", "totalNum")
//                        .and("_id").previousOperation()
//        );
//        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, Message.class, Map.class);
//
//        System.out.println(results.getMappedResults());


        /**
         * geonear,必须在location列加索引 2dsphere
         */
        Point point = new Point(104.07642, 39.6518);
        NearQuery near = NearQuery.near(point).spherical(true).query(query);
        GeoResults<Message> geoResults = mongoTemplate.geoNear(near, Message.class);
        List<GeoResult<Message>> content = geoResults.getContent();
        GeoResult<Message> messageGeoResult = content.get(0);
        System.out.println(messageGeoResult.getDistance().toString());
        message = messageGeoResult.getContent();
        System.out.println(message);

    }


}
