/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: RemoteInvocationHandler
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/29   x
 * ...
 */
package com.bdsoft.rpcaio.remote;

import com.bdsoft.rpcaio.transporthession.Client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/29
 * @see
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private Class interfaces;
    public RemoteInvocationHandler(Class interfaces){
        this.interfaces = interfaces;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcContext rpcContext = new RpcContext();
        rpcContext.setClassName(interfaces.getName());
        rpcContext.setMothodName(method.getName());
        rpcContext.setTypes(method.getParameterTypes());
        rpcContext.setParams(args);

        return  Client.getInstance().invokerServer(rpcContext);
    }
}

