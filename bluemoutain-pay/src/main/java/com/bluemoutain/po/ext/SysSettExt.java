package com.bluemoutain.po.ext;



import com.bluemoutain.po.SystemSett;

import java.math.BigDecimal;
import java.util.Date;

public class SysSettExt extends SystemSett {

    private String user;

    private String pwd;

    private Integer role;

    private String showname;

    private String email;

    private String phone;

    private Integer age;

    private Integer sex;

    private Date cresteTime;

    private String createIp;

    private Date lastLoginTime;

    private String appkey;

    private BigDecimal balnes;

    private String zsname;

    private Integer zspaytype;

    private String zspayid;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCresteTime() {
        return cresteTime;
    }

    public void setCresteTime(Date cresteTime) {
        this.cresteTime = cresteTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public BigDecimal getBalnes() {
        return balnes;
    }

    public void setBalnes(BigDecimal balnes) {
        this.balnes = balnes;
    }

    public String getZsname() {
        return zsname;
    }

    public void setZsname(String zsname) {
        this.zsname = zsname;
    }

    public Integer getZspaytype() {
        return zspaytype;
    }

    public void setZspaytype(Integer zspaytype) {
        this.zspaytype = zspaytype;
    }

    public String getZspayid() {
        return zspayid;
    }

    public void setZspayid(String zspayid) {
        this.zspayid = zspayid;
    }
}
