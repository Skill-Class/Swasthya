package com.example.sheetalkumar.swasthya.Model;

public class Users {

    private String userName;
    private String userEmailId;
    private String UserProfilePic;

    public Users(String userName, String userEmailId, String userProfilePic) {
        this.userName = userName;
        this.userEmailId = userEmailId;
        UserProfilePic = userProfilePic;
    }

    public Users() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserProfilePic() {
        return UserProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        UserProfilePic = userProfilePic;
    }
}
