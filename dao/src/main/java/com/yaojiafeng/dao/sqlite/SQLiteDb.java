/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.dao.sqlite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.*;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/7/22 上午10:48 $
 */
public class SQLiteDb {

    private static final Logger logger = LoggerFactory.getLogger(SQLiteDb.class);

    private String dataPath = "/Users/yaojiafeng/IdeaProjects/spring-new/";

    private String dbName = "sqlite.db";

    public SQLiteDb() {
        init();
    }

    public void init() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            logger.error("can't find class org.sqlite.JDBC", e);
        }

        File dbFile = new File(dataPath);
        if (!dbFile.exists()) {
            dbFile.mkdirs();
        }
        Connection conn = null;
        try {
            String unreportMsgSql = "create table if not exists unreport_msg(\n" +
                    "  id int PRIMARY KEY,\n" +
                    "  business varchar(255) not null,\n" +
                    "  rule varchar(255) not null,\n" +
                    "  payload varchar(255) not null\n" +
                    ")";
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(unreportMsgSql);
        } catch (SQLException e) {
            throw new RuntimeException("init error", e);
        } finally {
            closeConnection(conn);
        }
    }

    public Connection getConnection() {
        try {
            StringBuilder url = new StringBuilder("jdbc:sqlite:");
            url.append(dataPath).append(dbName);
            Connection conn = DriverManager.getConnection(url.toString());
            return conn;
        } catch (Exception e) {
            logger.error("getConnection失败", e);
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                logger.error("closeConnection失败", e);
            }

        }
    }

    public void insert(UnreportMsg unreportMsg) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement p2 = conn.prepareStatement("insert into unreport_msg(id,business,rule,payload) values(?,?,?,?)");
            p2.setLong(1, unreportMsg.getId());
            p2.setString(2, unreportMsg.getBusiness());
            p2.setString(3, unreportMsg.getRule());
            p2.setString(4, unreportMsg.getPayload());
            p2.execute();
        } catch (Exception e) {
            logger.error("insert error", e);
        } finally {
            closeConnection(conn);
        }

    }

    public UnreportMsg find(Long qid) {
        UnreportMsg unreportMsg = null;
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from unreport_msg where id=?");
            pstmt.setLong(1, qid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String business = rs.getString("business");
                String rule = rs.getString("rule");
                String payload = rs.getString("payload");
                unreportMsg = new UnreportMsg(id, business, rule, payload);
            }
        } catch (Exception e) {
            logger.error("find error", e);
        } finally {
            closeConnection(conn);
        }

        return unreportMsg;
    }

    public <T> T execute(CallBack<T> callBack) {
        Connection connection = null;
        T result = null;
        try {
            connection = getConnection();
            result = callBack.doCallBack(connection);
        } catch (Exception ex) {
            logger.error("execute error", ex);
        } finally {
            closeConnection(connection);
        }

        return result;
    }

    public static void main(String[] args) {
        SQLiteDb sqLiteDb = new SQLiteDb();
//        sqLiteDb.insert(new UnreportMsg(1L, "1", "1", "1"));
//        UnreportMsg unreportMsg = sqLiteDb.find(1L);
//        System.out.println(unreportMsg);

        UnreportMsg unreportMsg = sqLiteDb.execute((connection) -> {
            UnreportMsg unreportMsg1 = null;
            PreparedStatement pstmt = connection.prepareStatement("select * from unreport_msg where id=?");
            pstmt.setLong(1, 1L);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String business = rs.getString("business");
                String rule = rs.getString("rule");
                String payload = rs.getString("payload");
                unreportMsg1 = new UnreportMsg(id, business, rule, payload);
            }
            return unreportMsg1;
        });


        System.out.println(unreportMsg);
    }
}
