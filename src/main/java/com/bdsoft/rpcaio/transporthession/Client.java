/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: Client
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/29   x
 * ...
 */
package com.bdsoft.rpcaio.transporthession;

import com.bdsoft.rpcaio.remote.RpcContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/29
 * @see
 */
public class Client {
    private static Client instance;
    private String host;
    private int port;

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private boolean isCOnnection(){

        if(socket!=null&&!socket.isClosed()&&socket.isBound()){
            return true;
        }

        try {
            socket= new Socket(host,port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object invokerServer(RpcContext context){
        if(isCOnnection()){
            try {
                outputStream.write(HessianSerializerUtil.serialize(context));
                byte[] res = new byte[1024];
                while (inputStream.read(res)>0){
                    return HessianSerializerUtil.deserializer(res);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Client getInstance(){
        if(instance==null){
            instance= new Client("localhost",8080);
        }

        return instance;
    }
}

