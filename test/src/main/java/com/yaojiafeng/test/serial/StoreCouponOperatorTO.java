package com.yaojiafeng.test.serial;

import java.io.Serializable;

/**
 * Created by yaojiafeng on 2018/12/20 3:32 PM.
 */
public class StoreCouponOperatorTO implements Serializable {

    private static final long serialVersionUID = 3635130888193534767L;

    /**
     * 优惠券ID
     */
    private Long couponId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 店铺ID
     */
    private Long storeId;

    private CouponTO couponTO;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public CouponTO getCouponTO() {
        return couponTO;
    }

    public void setCouponTO(CouponTO couponTO) {
        this.couponTO = couponTO;
    }
}
