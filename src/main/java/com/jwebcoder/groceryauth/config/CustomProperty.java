package com.jwebcoder.groceryauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 14/10/2017.
 */

@Component
@ConfigurationProperties(prefix = "custom-property")
public class CustomProperty {

    private final Logger logger = LoggerFactory.getLogger(CustomProperty.class);

    private String photographyDetailPageSize;
    private String paginationDisplayNum;
    private String messageBoardPageSize;
    private String subReply;
    private String adminPageSize;
    private List<String> loginOnly;
    private Map<String,String>  druidConfig;
    private String visitorInfoPageSize;

    public String getPhotographyDetailPageSize() {
        return photographyDetailPageSize;
    }

    public void setPhotographyDetailPageSize(String photographyDetailPageSize) {
        this.photographyDetailPageSize = photographyDetailPageSize;
    }

    public String getPaginationDisplayNum() {
        return paginationDisplayNum;
    }

    public void setPaginationDisplayNum(String paginationDisplayNum) {
        this.paginationDisplayNum = paginationDisplayNum;
    }

    public String getMessageBoardPageSize() {
        return messageBoardPageSize;
    }

    public void setMessageBoardPageSize(String messageBoardPageSize) {
        this.messageBoardPageSize = messageBoardPageSize;
    }

    public String getSubReply() {
        return subReply;
    }

    public void setSubReply(String subReply) {
        this.subReply = subReply;
    }

    public String getAdminPageSize() {
        return adminPageSize;
    }

    public void setAdminPageSize(String adminPageSize) {
        this.adminPageSize = adminPageSize;
    }

    public List<String> getLoginOnly() {
        return loginOnly;
    }

    public void setLoginOnly(List<String> loginOnly) {
        this.loginOnly = loginOnly;
    }

    public Map<String, String> getDruidConfig() {
        return druidConfig;
    }

    public void setDruidConfig(Map<String, String> druidConfig) {
        this.druidConfig = druidConfig;
    }

    public String getVisitorInfoPageSize() {
        return visitorInfoPageSize;
    }

    public void setVisitorInfoPageSize(String visitorInfoPageSize) {
        this.visitorInfoPageSize = visitorInfoPageSize;
    }

}
