package com.yaojiafeng.common.spi;

import java.util.List;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/4/7 下午2:42 $
 */
public class DatabaseSearch implements Search {
    @Override
    public List<String> search(String keyword) {
        System.out.println("now use database search. keyword:" + keyword);
        return null;
    }
}
