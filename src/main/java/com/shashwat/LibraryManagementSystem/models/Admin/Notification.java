package com.shashwat.LibraryManagementSystem.models.Admin;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    @NotNull
    private String heading;

    private String noticeFileAddress;

    public Notification() {
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getNoticeFileAddress() {
        return noticeFileAddress;
    }

    public void setNoticeFileAddress(String noticeFileAddress) {
        this.noticeFileAddress = noticeFileAddress;
    }
}
