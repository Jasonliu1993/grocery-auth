package com.jwebcoder.groceryauth.common.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PERSONAL_INFO")
public class PersonalInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.ID
     *
     * @mbggenerated
     */
    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.VERSION
     *
     * @mbggenerated
     */
    @Column(name = "VERSION", insertable = false, updatable = true)
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.USER_ID
     *
     * @mbggenerated
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.AVATOR
     *
     * @mbggenerated
     */
    @Column(name = "AVATOR")
    private String avator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.COMMTS
     *
     * @mbggenerated
     */
    @Column(name = "COMMTS")
    private String commts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.CUSTOM1
     *
     * @mbggenerated
     */
    @Column(name = "CUSTOM1")
    private String custom1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.CUSTOM2
     *
     * @mbggenerated
     */
    @Column(name = "CUSTOM2")
    private String custom2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.CUSTOM3
     *
     * @mbggenerated
     */
    @Column(name = "CUSTOM3")
    private String custom3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.CUSTOM4
     *
     * @mbggenerated
     */
    @Column(name = "CUSTOM4")
    private String custom4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAL_INFO.CUSTOM5
     *
     * @mbggenerated
     */
    @Column(name = "CUSTOM5")
    private String custom5;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.ID
     *
     * @return the value of PERSONAL_INFO.ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.ID
     *
     * @param id the value for PERSONAL_INFO.ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.VERSION
     *
     * @return the value of PERSONAL_INFO.VERSION
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.VERSION
     *
     * @param version the value for PERSONAL_INFO.VERSION
     * @mbggenerated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.AVATOR
     *
     * @return the value of PERSONAL_INFO.AVATOR
     * @mbggenerated
     */
    public String getAvator() {
        return avator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.AVATOR
     *
     * @param avator the value for PERSONAL_INFO.AVATOR
     * @mbggenerated
     */
    public void setAvator(String avator) {
        this.avator = avator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.COMMTS
     *
     * @return the value of PERSONAL_INFO.COMMTS
     * @mbggenerated
     */
    public String getCommts() {
        return commts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.COMMTS
     *
     * @param commts the value for PERSONAL_INFO.COMMTS
     * @mbggenerated
     */
    public void setCommts(String commts) {
        this.commts = commts == null ? null : commts.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.CUSTOM1
     *
     * @return the value of PERSONAL_INFO.CUSTOM1
     * @mbggenerated
     */
    public String getCustom1() {
        return custom1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.CUSTOM1
     *
     * @param custom1 the value for PERSONAL_INFO.CUSTOM1
     * @mbggenerated
     */
    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.CUSTOM2
     *
     * @return the value of PERSONAL_INFO.CUSTOM2
     * @mbggenerated
     */
    public String getCustom2() {
        return custom2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.CUSTOM2
     *
     * @param custom2 the value for PERSONAL_INFO.CUSTOM2
     * @mbggenerated
     */
    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.CUSTOM3
     *
     * @return the value of PERSONAL_INFO.CUSTOM3
     * @mbggenerated
     */
    public String getCustom3() {
        return custom3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.CUSTOM3
     *
     * @param custom3 the value for PERSONAL_INFO.CUSTOM3
     * @mbggenerated
     */
    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.CUSTOM4
     *
     * @return the value of PERSONAL_INFO.CUSTOM4
     * @mbggenerated
     */
    public String getCustom4() {
        return custom4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.CUSTOM4
     *
     * @param custom4 the value for PERSONAL_INFO.CUSTOM4
     * @mbggenerated
     */
    public void setCustom4(String custom4) {
        this.custom4 = custom4 == null ? null : custom4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAL_INFO.CUSTOM5
     *
     * @return the value of PERSONAL_INFO.CUSTOM5
     * @mbggenerated
     */
    public String getCustom5() {
        return custom5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAL_INFO.CUSTOM5
     *
     * @param custom5 the value for PERSONAL_INFO.CUSTOM5
     * @mbggenerated
     */
    public void setCustom5(String custom5) {
        this.custom5 = custom5 == null ? null : custom5.trim();
    }
}