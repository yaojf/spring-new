package com.yaojiafeng.common.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/4/7 下午2:47 $
 */
public class SearchTest {
    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> searchs = s.iterator();
        while (searchs.hasNext()) {
            Search curSearch = searchs.next();
            curSearch.search("test");
        }
    }
}
