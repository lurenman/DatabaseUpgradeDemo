package com.example.lurenman.databaseupgradedemo.entitys;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 */

public class StudentEntity {
    private String studentName;
    private String studentSex;
    private int studentAge;
    private int studentScore;//第三个版本用的
    private String studentClass;//第四个版本用的
    private String studentMigration;//第五个版本用的

    public String getStudentMigration() {
        return studentMigration;
    }

    public void setStudentMigration(String studentMigration) {
        this.studentMigration = studentMigration;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
