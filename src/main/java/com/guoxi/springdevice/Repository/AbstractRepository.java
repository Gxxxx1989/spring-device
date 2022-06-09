package com.guoxi.springdevice.Repository;

import com.guoxi.springdevice.common.AbstractEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */

public interface AbstractRepository<T extends AbstractEntity> extends PagingAndSortingRepository<T,String> {
}
