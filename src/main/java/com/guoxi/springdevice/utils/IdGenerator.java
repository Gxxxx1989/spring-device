/*
 * Copyright (c) 2021 - 2030 www.tg.com 辽宁天港数据科技有限公司
 */

package com.guoxi.springdevice.utils;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

/**
 *
 * JPA物理ID生成器
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/9 14:34
 *
 */
@Component
public class IdGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    Class<?> clazz = object.getClass();
    String generateStr = StringUtils.EMPTY;
    GeneratorKey key = clazz.getAnnotation(GeneratorKey.class);
    if (key != null) {
      generateStr = key.value();
    }
    if (StringUtils.isBlank(generateStr)) {
      Table table = clazz.getAnnotation(Table.class);
      generateStr = getTableSign(table == null ? clazz.getSimpleName() : table.name());
    }
    return getIdByGenerateKey(generateStr);
  }

  /**
   * 获取表名标记
   * @param name 表名
   * @return 标记
   */
  private static String getTableSign(String name) {
    if (StringUtils.contains(name, ENTITY_CLASS_NAME)) {
      return name.replaceAll(ENTITY_CLASS_NAME, StringUtils.EMPTY).replaceAll("[0-9a-z]", StringUtils.EMPTY);
    }
    String[] values = name.split("-");
    StringBuilder builder = new StringBuilder();
    for (String value : values) {
      builder.append(value.charAt(1));
    }
    return builder.toString().toUpperCase();
  }

  private static String getIdByGenerateKey(String generateKey) {
    String id = String.format(
        Locale.getDefault(),
        "%s-%d-%s",
        generateKey,
        System.currentTimeMillis(),
        UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY)
    );
    return id.substring(0, ID_LENGTH);
  }

  /** 类名关键字 */
  private static final String ENTITY_CLASS_NAME = "Entity";

  /** 主键默认长度 */
  private static final int ID_LENGTH = 32;

}
