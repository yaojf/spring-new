package com.yaojiafeng.dao.sqlite;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/7/22 上午11:08 $
 */
public class UnreportMsg {

    private Long id;
    private String business;
    private String rule;
    private String payload;

    public UnreportMsg(Long id, String business, String rule, String payload) {
        this.id = id;
        this.business = business;
        this.rule = rule;
        this.payload = payload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "UnreportMsg{" +
                "id=" + id +
                ", business='" + business + '\'' +
                ", rule='" + rule + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
