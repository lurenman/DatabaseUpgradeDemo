package com.example.lurenman.databaseupgradedemo.activity;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lurenman.databaseupgradedemo.R;
import com.example.lurenman.databaseupgradedemo.entitys.StudentEntity;
import com.example.lurenman.databaseupgradedemo.entitys.UserEntity;
import com.example.lurenman.databaseupgradedemo.sqlitedb.SqliteUpdateDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 */

public class SqliteActivity extends BaseActivity {

    private Button bt_read;
    private TextView tv_sqlite_content;
    private SqliteUpdateDao mSqliteUpdateDao;
    private List<UserEntity> mAllUserInfoList = new ArrayList<>();
    private List<StudentEntity> mAllStudentInfoList = new ArrayList<>();

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Sqlite";
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_sqlite);
        bt_read = (Button) findViewById(R.id.bt_read);
        tv_sqlite_content = (TextView) findViewById(R.id.tv_sqlite_content);

    }

    @Override
    protected void initVariables() {
        mSqliteUpdateDao = SqliteUpdateDao.getInstance();
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        bt_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // showUserInfo();
                showStudentInfo();
            }
        });
    }

    private void showUserInfo() {
        if (mSqliteUpdateDao != null) {
            mAllUserInfoList = mSqliteUpdateDao.findAllUserInfo();
            if (!mAllUserInfoList.isEmpty()) {
                UserEntity userEntity = mAllUserInfoList.get(0);
                String userName = userEntity.getUserName();
                String userSex = userEntity.getUserSex();
                int userAge = userEntity.getUserAge();
                tv_sqlite_content.setText("userName:" + userName + "\n"
                        + "userSex:" + userSex + "\n"
                        + "userAge:" + userAge + "\n"
                );
            }
        }
    }

    private void showStudentInfo() {
        //studentScore这种int类型的没有进行插入值操作默认是0
        mAllStudentInfoList = mSqliteUpdateDao.findAllStudentInfo();
        if (!mAllStudentInfoList.isEmpty()) {
            StudentEntity studentEntity = mAllStudentInfoList.get(0);
            String studentName = studentEntity.getStudentName();
            String studentSex = studentEntity.getStudentSex();
            int studentAge = studentEntity.getStudentAge();
            int studentScore = studentEntity.getStudentScore();
            String studentClass = studentEntity.getStudentClass();
          //   String studentMigration = studentEntity.getStudentMigration();
            //+ "studentMigration:" + studentMigration + "\n"
            tv_sqlite_content.setText("studentName:" + studentName + "\n"
                    + "studentSex:" + studentSex + "\n"
                    + "studentAge:" + studentAge + "\n"
                    + "studentScore:" + studentScore + "\n"
                    + "studentClass:" + studentClass + "\n"
                  //  + "studentMigration:" + studentMigration + "\n"
            );
        }
    }

    @Override
    protected void loadData() {

    }
}
