package com.software.examination.enity;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
public class UserDO {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户身份证号
     */
    private String idNumber;

    /**
     * 用户权限
     */
    private Integer permission;

    /**
     * 科目编号
     */
    private Integer subjectNo;

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
        return subjectNo;
    }

    public void setSubject(Integer subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
