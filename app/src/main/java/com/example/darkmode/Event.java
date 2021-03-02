package com.example.darkmode;

public class Event {
    String Date = null;
    String Event = null;
    String Time = null;
    String Place = null;

    public Event(String date, String event, String time, String place) {
        super();
        this.Date = date;
        this.Event = event;
        this.Time = time;
        this.Place = place;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }
    public String toString() {

        return  Date + " " + Event+ " " + Time +" "  + Place ;

    }
}
