package com.guoxi.springdevice.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public  abstract class AbstractEntity {

    @Id
    @GeneratedValue(generator = "DEMO_ID_GENERATE")
    @GenericGenerator(name = "DEMO_ID_GENERATE", strategy = "com.guoxi.springdevice.utils.IdGenerator")
    @Column
    String id;

    /**
     * 创建时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;

    /** 版本号 */
    @Version
    int version;
}
