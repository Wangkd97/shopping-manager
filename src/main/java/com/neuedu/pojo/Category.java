package com.neuedu.pojo;

import java.util.Date;

public class Category {


    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getKind() {
        return kind;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.id
     *
     * @mbggenerated
     */
    private int kind;
    private String parentName;
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.parent_id
     *
     * @mbggenerated
     */
    private Integer parentId;

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    private Integer parent_id;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.status
     *
     * @mbggenerated
     */
    private int status;

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.sort_order
     *
     * @mbggenerated
     */
    private Integer sortOrder;

    public Integer getSort_order() {
        return sort_order;
    }

    private Integer sort_order;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_category.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.id
     *
     * @return the value of neuedu_category.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.id
     *
     * @param id the value for neuedu_category.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.parent_id
     *
     * @return the value of neuedu_category.parent_id
     *
     * @mbggenerated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.parent_id
     *
     * @param parentId the value for neuedu_category.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.name
     *
     * @return the value of neuedu_category.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.name
     *
     * @param name the value for neuedu_category.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.status
     *
     * @return the value of neuedu_category.status
     *
     * @mbggenerated
     */
    public int getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.status
     *
     * @param status the value for neuedu_category.status
     *
     * @mbggenerated
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.sort_order
     *
     * @return the value of neuedu_category.sort_order
     *
     * @mbggenerated
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.sort_order
     *
     * @param sortOrder the value for neuedu_category.sort_order
     *
     * @mbggenerated
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.create_time
     *
     * @return the value of neuedu_category.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.create_time
     *
     * @param createTime the value for neuedu_category.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_category.update_time
     *
     * @return the value of neuedu_category.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_category.update_time
     *
     * @param updateTime the value for neuedu_category.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}