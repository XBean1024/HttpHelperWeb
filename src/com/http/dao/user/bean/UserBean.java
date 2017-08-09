package com.http.dao.user.bean;

/**
 * Created by smart on 2017/8/3.
 */
public class UserBean {
    private String name;
    private String password;
    private int age;
    private String telephone;

    public UserBean(String name, String password, int age, String telephone) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }
}
