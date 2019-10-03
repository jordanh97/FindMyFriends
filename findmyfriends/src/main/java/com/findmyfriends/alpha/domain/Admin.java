package com.findmyfriends.alpha.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

@Entity
public class Admin {

    @Id
    private String Admin;
    private String deviceID;
    private String login;
    private String location;
    private String stationType;

    public Admin(){}

    public Admin(AdminBuilder builder){

        this.Admin = builder.Admin;
        this.deviceID = builder.deviceID;
        this.login = builder.login;
        this.location = builder.location;
        this.stationType = builder.stationType;

    }


    public static class AdminBuilder{

        private String Admin;
        private String deviceID;
        private String login;
        private String location;
        private String stationType;

        public AdminBuilder(){

        }

        public AdminBuilder Admin(String Admin){
            this.Admin = Admin;
            return this;
        }

        public AdminBuilder deviceID(String deviceID){
            this.deviceID = deviceID;
            return this;
        }

        public AdminBuilder login(String login){
            this.login = login;
            return this;
        }

        public AdminBuilder location(String location){
            this.Admin = location;
            return this;
        }
        public AdminBuilder stationType(String stationType){
            this.Admin = stationType;
            return this;
        }

        public AdminBuilder copy(Admin appointment){
            this.Admin = appointment.Admin;
            this.deviceID = appointment.deviceID;
            this.login = appointment.login;
            this.location = appointment.location;
            this.stationType = appointment.stationType;
            return this;
        }


        public Admin build(){
            return new Admin(this);
        }

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
}
