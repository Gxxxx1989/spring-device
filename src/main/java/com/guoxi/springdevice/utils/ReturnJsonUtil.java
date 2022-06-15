package com.guoxi.springdevice.utils;

import com.guoxi.springdevice.constant.ReturnStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 返回工具类
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/15 11:03
 *
 */
@Data
@AllArgsConstructor
public class ReturnJsonUtil<T> {
    private int statusCode;
    private String statusMsg;
    private T data;

    public ReturnJsonUtil() {}

    public ReturnJsonUtil(ReturnStatus rs) {
        statusCode = rs.getStatusCode();
        statusMsg = rs.getStatusMsg();
    }

    public ReturnJsonUtil(int statusCode, T data) {
        this.statusCode = statusCode;
        statusMsg = ReturnStatus.getMsgByCode(statusCode);
        this.data = data;
    }

    public ReturnJsonUtil(int statusCode) {
        this.statusCode = statusCode;
        statusMsg = ReturnStatus.getMsgByCode(statusCode);
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        statusMsg = ReturnStatus.getMsgByCode(statusCode);
    }

    public void setStatus(ReturnStatus rs) {
        statusCode = rs.getStatusCode();
        statusMsg = rs.getStatusMsg();
    }

    public void setData(T data) {
        this.data = data;
    }
}