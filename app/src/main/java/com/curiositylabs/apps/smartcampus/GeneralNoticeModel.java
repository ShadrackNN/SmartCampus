package com.curiositylabs.apps.smartcampus;

import java.util.Date;

/**
 * Created by SHADRACK NGOTHO on 5/3/2017.
 */

class GeneralNoticeModel {
    public String notice;
    public String noticeSender;
    public long noticeTime;

    public GeneralNoticeModel(String notice, String noticeSender) {
        this.notice = notice;
        this.noticeSender = noticeSender;

        // Initialize to current time
        noticeTime = new Date().getTime();

    }



    public GeneralNoticeModel(){

    }


    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNoticeSender() {
        return noticeSender;
    }

    public void setNoticeSender(String noticeSender) {
        this.noticeSender = noticeSender;
    }

    public long getNoticeTime() {
        return noticeTime;
    }


    public void setNoticeTime(long noticeTime) {
        this.noticeTime = noticeTime;
    }
}
