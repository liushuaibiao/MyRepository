/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: RpcProxyFactory
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/29   x
 * ...
 */
package com.bdsoft.rpcaio.remote;

import java.lang.reflect.Proxy;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/29
 * @see
 */
public class RpcProxyFactory<T> {
    public T factoryRemoteInvoker(Class interfaces){
        return (T)Proxy.newProxyInstance(interfaces.getClassLoader(),new Class[]{interfaces},new RemoteInvocationHandler(interfaces));
    }
}

