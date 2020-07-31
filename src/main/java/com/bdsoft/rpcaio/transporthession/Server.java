/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: Server
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/29   x
 * ...
 */
package com.bdsoft.rpcaio.transporthession;

import com.bdsoft.rpcaio.containers.Registry;
import com.bdsoft.rpcaio.remote.RpcContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/29
 * @see
 */
public class Server {

    public void bind(int port){
        ServerSocket serverSocket= null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true){
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                byte[] request = new byte[1024];
                while (inputStream.read(request)>0){
                    RpcContext rpcContext = HessianSerializerUtil.deserializer(request);
                    Class clazz = null;
                    if(Registry.map.containsKey(rpcContext.getClassName())){
                        clazz = Registry.map.get(rpcContext.getClassName());
                    }
                    Method method = clazz.getMethod(rpcContext.getMothodName(),rpcContext.getTypes());
                    Object result = method.invoke(clazz.newInstance(),rpcContext.getParams());
                    outputStream.write(HessianSerializerUtil.serialize(result));
                    outputStream.flush();

                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

