package com.example.dell.firstcry.Objects;
public class BannerResponse {
    public String _id,user,title,description,eventDate,eventTime,venue,date,_v;
    public BannerResponse() {
    }

    public BannerResponse(String _id, String user, String title,
                               String description, String eventDate, String eventTime, String venue, String date, String _v) {
        this._id = _id;
        this.user = user;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venue = venue;
        this.date = date;
        this._v = _v;
    }
}