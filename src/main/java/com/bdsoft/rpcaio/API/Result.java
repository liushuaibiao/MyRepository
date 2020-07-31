/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: Result
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/30   x
 * ...
 */
package com.bdsoft.rpcaio.API;

import java.io.Serializable;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/30
 * @see
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3086633178104602825L;
    private T data;
    private boolean success;
    private String failCode;



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", success=" + success +
                ", failCode='" + failCode + '\'' +
                '}';
    }
}

