package com.guoxi.springdevice.Repository;

import com.guoxi.springdevice.common.AbstractEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Repository
public interface AbstractRepository<T extends AbstractEntity> extends PagingAndSortingRepository<T,String> {
}
