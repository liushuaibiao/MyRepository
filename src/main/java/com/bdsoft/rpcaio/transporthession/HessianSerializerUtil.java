/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: HessianSerializerUtil
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/29   x
 * ...
 */
package com.bdsoft.rpcaio.transporthession;

import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/29
 * @see
 */
public class HessianSerializerUtil {

    public static <T> byte[] serialize(T obj){
        byte[] bytes = null;
        //创建字节输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //对字节数组流进行封装
        HessianOutput hessianOutput = new HessianOutput(bos);

        try{
            hessianOutput.writeObject(obj);
            bytes = bos.toByteArray();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return bytes;
    }

    //反序列化
    public static <T> T deserializer(byte[] data) throws IOException {
        if(data==null){
            return null;
        }

        //将字节数组转换成字节输入流
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        HessianInput hessianInput = new HessianInput(bis);
        Object object = null;

        try {
            object= hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            bis.close();

        }
        return (T) object;
    }
}

