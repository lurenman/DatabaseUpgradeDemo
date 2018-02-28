package com.example.lurenman.databaseupgradedemo.sqlitedb;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 * db.execSQL("DROP TABLE IF EXISTS t1;");删除表操作
 * 不初始化字段：字符型默认显示null 整数型默认显示0
 * 参考http://www.jb51.net/article/122846.htm
 * http://blog.csdn.net/chengkaizone/article/details/44084707
 * version1 我们创建user表 userName ,userSex,userAge 三个字段
 * version2 我们添加创建 student表
 * version3 我们准备在 student表 添加score 成绩得分字段
 * version4 我们准备在 student表 添加class 班级字段
 * version5 我们准备在student表迁移 并添加Migration字段（不在后面添加）
 */

public class SqliteUpdateOpenHelper extends SQLiteOpenHelper {
    public static final String CREATE_STUDENT = "CREATE TABLE IF NOT EXISTS student(id integer primary key autoincrement,studentName varchar(20),studentSex varchar(20) ,studentAge INTEGER,studentScore INTEGER,studentClass varchar(20))";
    public static final String ALTER_ADD_STUDENT_SCORE = "alter table student add column studentScore integer";
    public static final String ALTER_ADD_STUDENT_CLASS = "alter table student add column studentClass text";

    public SqliteUpdateOpenHelper(Context context) {
        super(context, "SqliteUpdate.db", null, 4);
    }

    public SqliteUpdateOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SqliteUpdateOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(id integer primary key autoincrement,userName varchar(20),userSex varchar(20) ,userAge INTEGER)");
        db.execSQL(CREATE_STUDENT);
    }

    /**
     * 这个是数据库更新的时候调用
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                //对于第一个版本升级到第二个版本理执行创建表的操作
                db.execSQL(CREATE_STUDENT);
            case 2:
                //对于第二个版本升级到第三个版本添加score成绩得分字段
                db.execSQL(ALTER_ADD_STUDENT_SCORE);
            case 3:
                //对于第三个版本升级到第四个版本添加class字段
                db.execSQL(ALTER_ADD_STUDENT_CLASS);
            case 4:
                //对于第四个版本升级到第五个版本数据迁移
                //1. 将表名改为临时表
                db.execSQL("ALTER TABLE student RENAME TO __temp__student");
                //2. 创建新表
                //"CREATE TABLE IF NOT EXISTS student(id integer primary key autoincrement,studentName varchar(20),studentMigration varchar(20),studentSex varchar(20) ,studentAge INTEGER,studentScore INTEGER,studentClass varchar(20))"
                db.execSQL(CREATE_STUDENT);
                //3. 导入数据　
                db.execSQL("INSERT INTO student SELECT id,studentName FROM __temp__student");
                // 4. 删除临时表　
                db.execSQL("DROP TABLE __temp__student");
            default:
                break;
        }
    }
}
