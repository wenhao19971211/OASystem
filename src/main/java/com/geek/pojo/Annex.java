package com.geek.pojo;

/**
 * 邮件附件
 */
public class Annex {
    private Integer annexId;
    private String annex;
    private EmailSend emailSend;
    private EmailReply emailReply;

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

    public EmailSend getEmailSend() {
        return emailSend;
    }

    public void setEmailSend(EmailSend emailSend) {
        this.emailSend = emailSend;
    }

    public EmailReply getEmailReply() {
        return emailReply;
    }

    public void setEmailReply(EmailReply emailReply) {
        this.emailReply = emailReply;
    }
}
