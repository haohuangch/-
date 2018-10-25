package com.chh.core.entity;


public class Account {

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password="
                + loginPwd + ", phone=" + phone + "]";
    }

    private Integer id; // 主键
    private String name; // 用户姓名
    private String loginPwd; // 密码
    private String phone; //
    private Integer privelege;
    private String loginPwdModifyTime;
    private String registTime;
    private String loginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPrivilege() {
        return privelege;
    }

    public void setPrivilege(Integer privelege) {
        this.privelege = privelege;
    }

    public String getLoginPwdModifyTime() {
        return loginPwdModifyTime;
    }

    public void setLoginPwdModifyTime(String loginPwdModifyTime) {
        this.loginPwdModifyTime = loginPwdModifyTime;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
