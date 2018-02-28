package com.example.lurenman.databaseupgradedemo;

import com.example.lurenman.databaseupgradedemo.sqlitedb.SqliteUpdateDao;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 */

public class DataUtils {
    /**
     * 初始化版本1数据
     */
    public static void initVersionOneDatas() {
        SqliteUpdateDao instance = SqliteUpdateDao.getInstance();
        instance.addUserInfo("娜美", "女", 20);
    }
    public static void initVersionTwoDatas(){
        SqliteUpdateDao instance = SqliteUpdateDao.getInstance();
        instance.addStudentInfo("小明", "男", 12);
    }
    public static void initVersionFiveDatas(){
        SqliteUpdateDao instance = SqliteUpdateDao.getInstance();
        instance.addStudentFiveInfo("小明", "男", 12,90,"三年二班");
    }
}
