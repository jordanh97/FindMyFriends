package com.findmyfriends.alpha.domain;

public class EventHardware {
    private String Event,  EventLayoutID,  hardware,  location,  stationType;

    public EventHardware(Builder builder) {
        this.Event = builder.Event;
        this.EventLayoutID = builder.EventLayoutID;
        this.hardware = builder.hardware;
        this.location = builder.location;
        this.stationType = builder.stationType;
    }

    public EventHardware(){

    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventLayoutID() {
        return EventLayoutID;
    }

    public void setEventLayoutID(String eventLayoutID) {
        EventLayoutID = eventLayoutID;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
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
        private String Event,  EventLayoutID,  hardware,  location,  stationType;

        public Builder Event(String Event){
            this.Event = Event;
            return this;
        }

        public Builder EventLayoutID(String EventLayoutID){
            this.EventLayoutID = EventLayoutID;
            return this;
        }

        public Builder hardware(String hardware){
            this.hardware = hardware;
            return this;
        }

        public Builder location(String location){
            this.location = location;
            return this;
        }

        public Builder stationType(String stationType){
            this.stationType = stationType;
            return this;
        }

        public EventHardware.Builder copy(EventHardware eventHardware){
            this.Event = eventHardware.Event;
            this.EventLayoutID = eventHardware.EventLayoutID;
            this.hardware = eventHardware.hardware;
            this.location = eventHardware.location;
            this.stationType = eventHardware.stationType;
            return this;
        }

        public EventHardware build(){
            return new EventHardware(this);
        }
    }

    @Override
    public String toString() {
        return "EventHardware{" +
                "Event='" + Event + '\'' +
                ", EventLayoutID='" + EventLayoutID + '\'' +
                ", hardware='" + hardware + '\'' +
                ", location='" + location + '\'' +
                ", stationType='" + stationType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventHardware)) return false;

        EventHardware that = (EventHardware) o;

        if (getEvent() != null ? !getEvent().equals(that.getEvent()) : that.getEvent() != null) return false;
        if (getEventLayoutID() != null ? !getEventLayoutID().equals(that.getEventLayoutID()) : that.getEventLayoutID() != null)
            return false;
        if (getHardware() != null ? !getHardware().equals(that.getHardware()) : that.getHardware() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null)
            return false;
        return getStationType() != null ? getStationType().equals(that.getStationType()) : that.getStationType() == null;
    }

    @Override
    public int hashCode() {
        int result = getEvent() != null ? getEvent().hashCode() : 0;
        result = 31 * result + (getEventLayoutID() != null ? getEventLayoutID().hashCode() : 0);
        result = 31 * result + (getHardware() != null ? getHardware().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getStationType() != null ? getStationType().hashCode() : 0);
        return result;
    }
}
