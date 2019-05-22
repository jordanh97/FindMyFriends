package com.findmyfriends.alpha.domain.device;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Device {

    private final UUID id;
    private final String userId;
    private final int status;
    private final String locationId;

    public Device(@JsonProperty("id") UUID id,
                  @JsonProperty("userId") String userId,
                  @JsonProperty("status") int status,
                  @JsonProperty("locationId") String locationId) {

        this.id = id;
        this.userId = userId;
        this.status = status;
        this.locationId = locationId;
    }

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public int getStatus() {
        return status;
    }

    public String getLocationId() {
        return locationId;
    }

}
