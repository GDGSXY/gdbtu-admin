package org.springblade.common.tool;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springblade.common.entity.PagingQuery;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
public interface PageUtil {

    /**
     * 获取 {@link PagingQuery} 中的 {@link com.baomidou.mybatisplus.core.metadata.IPage}
     *
     * @param query 分页查询
     * @param <T>   实体类型
     * @return IPage
     */
    static <T> IPage<T> toPage(PagingQuery query) {
        return new Page<>(query.getCurrent(), query.getSize());
    }

}
