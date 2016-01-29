package com.yaojiafeng.dao.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by yaojiafeng on 16/1/29.
 */
@XmlRootElement
public class User {


    private long userID;

    private String userName;

    private Date birth;


    public String getUserName() {

        return userName;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }

    public Date getBirth() {

        return birth;

    }

    public void setBirth(Date birth) {

        this.birth = birth;

    }

    public long getUserID() {

        return userID;

    }

    public void setUserID(long userID) {

        this.userID = userID;

    }

}