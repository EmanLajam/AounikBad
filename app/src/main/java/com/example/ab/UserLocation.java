package com.example.ab;

public class UserLocation {

    private Double Latitude;
    private Double Longitude;
    private String name;
    private String comment;
    private String Id;

    public Double getLatitude() {
        return Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public UserLocation() {
    }

    public UserLocation(String id , Double latitude, Double longitude,String name, String comment) {
        Latitude = latitude;
        Longitude = longitude;
        Id = id;
        this.name = name;
        this.comment = comment;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
