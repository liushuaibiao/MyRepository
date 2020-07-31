package com.bdsoft.rpcaio.API;/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: StudentServiceApi
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/30   x
 * ...
 */

public interface StudentServiceApi {

   public Result<StudentInfo> queryStudent(StudentInfo param);
}
