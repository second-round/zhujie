package com.example.xiao;

public class Bean {
    private String name="hyy";
    private String pass="123456";
    public String sex="女";

    public Bean() {
    }

    public Bean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    private void setPass(String pass) {
        this.pass = pass;
    }

    private String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }
}
