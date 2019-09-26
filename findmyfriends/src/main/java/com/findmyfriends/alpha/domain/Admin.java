package com.findmyfriends.alpha.domain;

import java.util.Objects;

public class Admin {
    @Override
    public String toString() {
        return "Admin{" +
                "Admin='" + Admin + '\'' +
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
        Admin admin = (Admin) o;
        return Objects.equals(Admin, admin.Admin) &&
                Objects.equals(deviceID, admin.deviceID) &&
                Objects.equals(login, admin.login) &&
                Objects.equals(location, admin.location) &&
                Objects.equals(stationType, admin.stationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Admin, deviceID, login, location, stationType);
    }

    private String Admin,  deviceID,  login,  location,  stationType;

    public Admin(Admin.Builder builder) {
        this.Admin = builder.Admin;
        this.deviceID = builder.deviceID;
        this.login = builder.login;
        this.location = builder.location;
        this.stationType = builder.stationType;
    }

    public Admin(){

    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String admin) {
        Admin = admin;
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
        private String Admin,  deviceID,  login,  location,  stationType;

        public Admin.Builder Admin(String Admin){
            this.Admin = Admin;
            return this;
        }

        public Admin.Builder deviceID(String deviceID){
            this.deviceID = deviceID;
            return this;
        }

        public Admin.Builder login(String login){
            this.login = login;
            return this;
        }

        public Admin.Builder location(String location){
            this.location = location;
            return this;
        }

        public Admin.Builder stationType(String stationType){
            this.stationType = stationType;
            return this;
        }

        public Admin.Builder copy(Admin Admin){
            this.Admin = Admin.Admin;
            this.deviceID = Admin.deviceID;
            this.login = Admin.login;
            this.location = Admin.location;
            this.stationType = Admin.stationType;
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }
    }
}
