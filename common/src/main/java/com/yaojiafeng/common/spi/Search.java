package com.yaojiafeng.common.spi;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/4/7 下午2:40 $
 */
import java.util.List;

public interface Search {
    List<String> search(String keyword);
}