package com.ino.practice8.mvc.dto;

public class Member {
    private String userId;
    private String userPwd;
    private String name;
    private int age;
    private char gender;
    private String email;

    public Member() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Member(String userId, String userPwd, String name, int age, char gender, String email) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getInfo() {
        return "User ID: " + userId + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Email: " + email;
    }
}
