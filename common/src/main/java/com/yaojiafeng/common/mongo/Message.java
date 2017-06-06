package com.yaojiafeng.common.mongo;

import com.mongodb.BasicDBObject;
import org.springframework.data.geo.Point;

/**
 * Created by yaojiafeng on 2017/6/2 下午2:53.
 */

public class Message {

    private Object id;

    private String topic;

    private BasicDBObject location;

    public Message(String topic, BasicDBObject location) {
        this.topic = topic;
        this.location = location;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public BasicDBObject getLocation() {
        return location;
    }

    public void setLocation(BasicDBObject location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", location=" + location +
                '}';
    }
}
