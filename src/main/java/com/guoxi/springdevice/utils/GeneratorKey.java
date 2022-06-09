/*
 * Copyright (c) 2021 - 2030 www.tg.com 辽宁天港数据科技有限公司
 */

package com.guoxi.springdevice.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * 物理主键获取关联字
 *
 * @author yuqs@tg-hd.com
 * @since 2021/4/26
 */
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratorKey {

  /**
   * 关键字
   * @return 关键字
   */
  String value() default "";
}
