/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: RpcContext
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/29   x
 * ...
 */
package com.bdsoft.rpcaio.remote;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/29
 * @see
 */
public class RpcContext  implements Serializable {
    private static final long serialVersionUID = -8581999645641203512L;

    private String ClassName;//类名
    private String mothodName;//方法名称
    private Class[] types;//类型
    private Object[] params;//参数
    //构造器
    public RpcContext() {

    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getMothodName() {
        return mothodName;
    }

    public void setMothodName(String mothodName) {
        this.mothodName = mothodName;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RpcContext{" +
                "ClassName='" + ClassName + '\'' +
                ", mothodName='" + mothodName + '\'' +
                ", types=" + Arrays.toString(types) +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}

