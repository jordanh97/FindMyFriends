package com.findmyfriends.alpha.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity
public class User {

    @Override
    public String toString() {
        return "User{" +
                "User='" + User + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", login='" + login + '\'' +
                ", location='" + location + '\'' +
                ", stationType='" + stationType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(User, user.User) &&
                Objects.equals(deviceID, user.deviceID) &&
                Objects.equals(login, user.login) &&
                Objects.equals(location, user.location) &&
                Objects.equals(stationType, user.stationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(User, deviceID, login, location, stationType);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String User;

    private String  deviceID,  login,  location,  stationType;

    public User(User.Builder builder) {
        this.User = builder.User;
        this.deviceID = builder.deviceID;
        this.login = builder.login;
        this.location = builder.location;
        this.stationType = builder.stationType;
    }

    public User(){

    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public static class Builder{
        private String User,  deviceID,  login,  location,  stationType;

        public Builder() {

        }

        public User.Builder User(String User){
            this.User = User;
            return this;
        }

        public User.Builder deviceID(String deviceID){
            this.deviceID = deviceID;
            return this;
        }

        public User.Builder login(String login){
            this.login = login;
            return this;
        }

        public User.Builder location(String location){
            this.location = location;
            return this;
        }

        public User.Builder stationType(String stationType){
            this.stationType = stationType;
            return this;
        }

        public User.Builder copy(User User){
            this.User = User.User;
            this.deviceID = User.deviceID;
            this.login = User.login;
            this.location = User.location;
            this.stationType = User.stationType;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
