package com.software.examination.dto;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
public class UserDTO {
    private String userName;

    private String password;

    private String name;

    private String idNumber;

    private Integer permission;

    private Integer subjectNo;

    private String subjectName;

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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
