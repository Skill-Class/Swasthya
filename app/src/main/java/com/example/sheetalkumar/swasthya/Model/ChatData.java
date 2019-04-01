package com.example.sheetalkumar.swasthya.Model;

public class ChatData {
    private String chatMessage;
    private String userId;
    private String userName;
    private String timestamp;

    public ChatData(String chatMessage, String userId, String userName, String timestamp) {
        this.chatMessage = chatMessage;
        this.userId = userId;
        this.userName = userName;
        this.timestamp = timestamp;
    }

    public ChatData() {
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}


