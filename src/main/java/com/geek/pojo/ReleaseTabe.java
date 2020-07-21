package com.geek.pojo;

import java.util.Date;

/**
 * 信息发布
 */
public class ReleaseTabe {
    private Integer releseId;
    private String releaseTitle;
    private String releaseContent;
    private Date releaseTime;

    public Integer getReleseId() {
        return releseId;
    }

    public void setReleseId(Integer releseId) {
        this.releseId = releseId;
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
