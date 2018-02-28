package com.example.lurenman.databaseupgradedemo.sqlitedb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lurenman.databaseupgradedemo.SMApp;
import com.example.lurenman.databaseupgradedemo.entitys.StudentEntity;
import com.example.lurenman.databaseupgradedemo.entitys.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 * 这个文件就是操作数据库用的
 * 上下文我们就用Application防止引用其他上下文导致内存泄漏
 */

public class SqliteUpdateDao {
    private SqliteUpdateOpenHelper mSqliteUpdateOpenHelper;

    public SqliteUpdateDao() {
        mSqliteUpdateOpenHelper = new SqliteUpdateOpenHelper(SMApp.mInstance);
    }

    private static class Holder {
        private static final SqliteUpdateDao INSTANCE = new SqliteUpdateDao();
    }

    public static SqliteUpdateDao getInstance() {
        return Holder.INSTANCE;
    }

    //下面进行数据库的一些操作
    public void addUserInfo(String userName, String userSex, int userAge) {
        SQLiteDatabase db = mSqliteUpdateOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("userName", userName);
            values.put("userSex", userSex);
            values.put("userAge", userAge);
            db.insert("user", null, values);
            db.close();
        }
    }

    public void addStudentInfo(String studentName, String studentSex, int studentAge) {
        SQLiteDatabase db = mSqliteUpdateOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("studentName", studentName);
            values.put("studentSex", studentSex);
            values.put("studentAge", studentAge);
            db.insert("student", null, values);
            db.close();
        }
    }
    public void addStudentFiveInfo(String studentName, String studentSex, int studentAge,int studentScore,String studentClass) {
        SQLiteDatabase db = mSqliteUpdateOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("studentName", studentName);
            values.put("studentSex", studentSex);
            values.put("studentAge", studentAge);
            values.put("studentScore", studentScore);
            values.put("studentClass", studentClass);
            db.insert("student", null, values);
            db.close();
        }
    }



    /**
     * 获取所有用户信息
     *
     * @return
     */
    public List<UserEntity> findAllUserInfo() {
        List<UserEntity> userEntityList = null;
        SQLiteDatabase db = mSqliteUpdateOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("user", null, null, null, null, null,
                    "id desc");
            userEntityList = new ArrayList<UserEntity>();
            while (cursor.moveToNext()) {
                UserEntity userEntity = new UserEntity();
                String userName = cursor.getString(cursor.getColumnIndex("userName"));
                String userSex = cursor.getString(cursor.getColumnIndex("userSex"));
                int userAge = cursor.getInt(cursor.getColumnIndex("userAge"));
                userEntity.setUserName(userName);
                userEntity.setUserSex(userSex);
                userEntity.setUserAge(userAge);
                userEntityList.add(userEntity);
            }
            cursor.close();
            db.close();
        }
        return userEntityList;
    }

    /**
     * 获取所有学生信息
     *
     * @return
     */
    public List<StudentEntity> findAllStudentInfo() {
        List<StudentEntity> studentEntityList = null;
        SQLiteDatabase db = mSqliteUpdateOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("student", null, null, null, null, null,
                    "id desc");
            studentEntityList = new ArrayList<StudentEntity>();
            while (cursor.moveToNext()) {
                StudentEntity studentEntity = new StudentEntity();
                String studentName = cursor.getString(cursor.getColumnIndex("studentName"));
                String studentSex = cursor.getString(cursor.getColumnIndex("studentSex"));
                int studentAge = cursor.getInt(cursor.getColumnIndex("studentAge"));
                int studentScore = cursor.getInt(cursor.getColumnIndex("studentScore"));//第三个版本用的
                String studentClass = cursor.getString(cursor.getColumnIndex("studentClass"));//第四个版本用的
            //    String studentMigration = cursor.getString(cursor.getColumnIndex("studentMigration"));//第五个版本用的

                studentEntity.setStudentName(studentName);
                studentEntity.setStudentSex(studentSex);
                studentEntity.setStudentAge(studentAge);
                studentEntity.setStudentClass(studentClass);
                studentEntity.setStudentScore(studentScore);
               // studentEntity.setStudentMigration(studentMigration);
                studentEntityList.add(studentEntity);
            }
            cursor.close();
            db.close();
        }
        return studentEntityList;
    }
}
