package com.yhz.com.model;

import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class NewsInfo {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 幼儿园ID
     */
    private Integer kindergartenId;

    /**
     * 资讯发布者
     */
    private Integer userId;

    /**
     * 资讯信息
     */
    private String news;

    /**
     * 资讯图片
     */
    private Integer imageId;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 审核时间
     */
    private Date checkTime;

    /**
     * 发布时间
     */
    private Date publicTime;

    /**
     * 备注
     */
    private String remark;
    
    /**
     * 创建时间
     */

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 资讯类别(关联字典表)
     */
    private Integer newsType;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取幼儿园ID
     *
     * @return kindergarten_id - 幼儿园ID
     */
    public Integer getKindergartenId() {
        return kindergartenId;
    }

    /**
     * 设置幼儿园ID
     *
     * @param kindergartenId 幼儿园ID
     */
    public void setKindergartenId(Integer kindergartenId) {
        this.kindergartenId = kindergartenId;
    }

    /**
     * 获取资讯发布者
     *
     * @return user_id - 资讯发布者
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置资讯发布者
     *
     * @param userId 资讯发布者
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取资讯信息
     *
     * @return news - 资讯信息
     */
    public String getNews() {
        return news;
    }

    /**
     * 设置资讯信息
     *
     * @param news 资讯信息
     */
    public void setNews(String news) {
        this.news = news;
    }

    /**
     * 获取资讯图片
     *
     * @return image_id - 资讯图片
     */
    public Integer getImageId() {
        return imageId;
    }

    /**
     * 设置资讯图片
     *
     * @param imageId 资讯图片
     */
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取上传时间
     *
     * @return upload_time - 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 设置上传时间
     *
     * @param uploadTime 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * 获取审核时间
     *
     * @return check_time - 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置审核时间
     *
     * @param checkTime 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取发布时间
     *
     * @return public_time - 发布时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getPublicTime() {
        return publicTime;
    }

    /**
     * 设置发布时间
     *
     * @param publicTime 发布时间
     */
    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取资讯类别(关联字典表)
     *
     * @return news_type - 资讯类别(关联字典表)
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * 设置资讯类别(关联字典表)
     *
     * @param newsType 资讯类别(关联字典表)
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }
}