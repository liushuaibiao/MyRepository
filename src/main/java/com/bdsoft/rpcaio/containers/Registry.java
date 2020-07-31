/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: Registry
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/28   x
 * ...
 */
package com.bdsoft.rpcaio.containers;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/28
 * @see
 */
public class Registry {
    //存放类信息
    public static ConcurrentHashMap<String,Class> map= new ConcurrentHashMap<>();
}

