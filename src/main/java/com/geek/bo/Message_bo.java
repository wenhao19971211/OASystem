package com.geek.bo;

import com.geek.pojo.Message;

import java.util.List;

public class Message_bo {
    private List<Message> messages;//当页数据
    private Integer count;//总共多少条

    public Message_bo() {
    }

    public Message_bo(List<Message> messages, Integer count) {
        this.messages = messages;
        this.count = count;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
