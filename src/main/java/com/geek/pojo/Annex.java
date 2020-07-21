package com.geek.pojo;

/**
 * 邮件附件
 */
public class Annex {
    private Integer annexId;
    private String annex;
    private Integer emailSendId;
    private Integer emailReplyId;

    public Integer getAnnexId() {
        return annexId;
    }

    public void setAnnexId(Integer annexId) {
        this.annexId = annexId;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    public Integer getEmailSendId() {
        return emailSendId;
    }

    public void setEmailSendId(Integer emailSendId) {
        this.emailSendId = emailSendId;
    }

    public Integer getEmailReplyId() {
        return emailReplyId;
    }

    public void setEmailReplyId(Integer emailReplyId) {
        this.emailReplyId = emailReplyId;
    }
}
