package com.example.ab;

import android.net.Uri;

public class Resturant {
    private String nameOFResturant;
    private String Latitude;
    private String Longitude;
    private String ID;
    private String UriImage;

    public Resturant() {
    }

    public Resturant(String id, String nameOFResturant, String latitude, String longitude, String uriImage ) {
        this.nameOFResturant = nameOFResturant;
        Latitude = latitude;
        Longitude = longitude;
        ID = id;
        UriImage = uriImage;

    }

    public String getNameOFResturant() {
        return nameOFResturant;
    }



    public void setNameOFResturant(String nameOFResturant) {
        this.nameOFResturant = nameOFResturant;
    }




    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }


    public String getUriImage() {
        return UriImage;
    }

    public void setUriImage(String uriImage) {
        UriImage = uriImage;
    }

}
