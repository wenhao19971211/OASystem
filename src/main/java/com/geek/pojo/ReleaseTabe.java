package com.geek.pojo;

import java.util.Date;

/**
 * 信息发布
 */
public class ReleaseTabe {
    private Integer releaseId;
    private String releaseTitle;
    private String releaseContent;
    private Date releaseTime;

    public ReleaseTabe() {
    }

    public ReleaseTabe(Integer releaseId, String releaseTitle, String releaseContent, Date releaseTime) {
        this.releaseId = releaseId;
        this.releaseTitle = releaseTitle;
        this.releaseContent = releaseContent;
        this.releaseTime = releaseTime;
    }

    public Integer getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    public String getReleaseTitle() {
        return releaseTitle;
    }

    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    public String getReleaseContent() {
        return releaseContent;
    }

    public void setReleaseContent(String releaseContent) {
        this.releaseContent = releaseContent;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}
