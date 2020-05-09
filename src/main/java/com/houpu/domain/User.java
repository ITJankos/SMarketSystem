package com.houpu.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User extends BaseEntity implements Serializable {
    private Integer gender;
    //private Integer userRole;
    private Role role;
    private String userCode;
    private String userName;
    private String userPassword;
    private String phone;
    private String address;
    private Date birthday;
    private String photo;

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }
   /* public String getBirthday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String format1 = format.format(this.birthday);
        return format1;
    }*/

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
