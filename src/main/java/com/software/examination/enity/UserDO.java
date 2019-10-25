package com.software.examination.enity;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
public class UserDO {
    private String userName;

    private String password;

    private String name;

    private String idNumber;

    private Integer permission;

    private Integer subject;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
