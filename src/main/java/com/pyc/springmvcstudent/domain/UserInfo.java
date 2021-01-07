//IntelliJ IDEA
//springmvcstudent
//UserInfo
//2021/1/7
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.springmvcstudent.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String stuID;
    private String name;
    private String profession;
    private String stuClass;    //年级
    private String broth;
    private String tel;
    private Boolean online;  //登陆状态
    public UserInfo(){
        super();
    }
    public UserInfo(String stuID,String name,String profession,String stuClass,String broth, String tel){
        this.stuID=stuID;
        this.name=name;
        this.profession=profession;
        this.stuClass=stuClass;
        this.broth=broth;
        this.tel=tel;
        this.online=false;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuClass() {
        return stuClass;
    }

    public String getStuID() {
        return stuID;
    }

    public Boolean getOnline() {
        return online;
    }

    public String getBroth() {
        return broth;
    }

    public String getTel() {
        return tel;
    }

    public void setBroth(String broth) {
        this.broth = broth;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
