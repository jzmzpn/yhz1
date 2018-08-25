package com.yhz.com.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Student {
    private Integer id;

    private String name;

    private String littleName;

    private String sid;

    private String sex;

    private String birthday;

    private Integer imageId;

    private Integer classId;

    private String address;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date enterDate;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date outDate;

    private Integer guardianNum;

    private String remark;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date updateDate;

    private Boolean isDelete;

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
        this.name = name == null ? null : name.trim();
    }

    public String getLittleName() {
        return littleName;
    }

    public void setLittleName(String littleName) {
        this.littleName = littleName == null ? null : littleName.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Integer getGuardianNum() {
        return guardianNum;
    }

    public void setGuardianNum(Integer guardianNum) {
        this.guardianNum = guardianNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}