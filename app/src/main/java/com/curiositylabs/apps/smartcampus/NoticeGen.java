package com.curiositylabs.apps.smartcampus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SHADRACK NGOTHO on 5/4/2017.
 */

public class NoticeGen extends ArrayAdapter<GeneralNoticeModel> {

    private static final String TAG = "NoticeGen";
    private List<GeneralNoticeModel> data;
    private Context context;
    public NoticeGen(Context context, int resource, List<GeneralNoticeModel> data) {
        super(context,resource,data);
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View noticeRow = convertView;
        if (noticeRow == null) {
            LayoutInflater inflator = LayoutInflater.from(context);
            noticeRow = inflator.inflate(R.layout.notice, parent, false);
        }

        TextView noticeSender = (TextView) noticeRow.findViewById(R.id.notice_sender);
        TextView noticeTime = (TextView) noticeRow.findViewById(R.id.notice_time);
        TextView noticeText = (TextView) noticeRow.findViewById(R.id.notice_text);
        GeneralNoticeModel gn = data.get(position);
        noticeSender.setText(gn.getNoticeSender());
        //noticeTime.setText((int) gn.getNoticeTime());

        noticeTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                gn.getNoticeTime()));

        noticeText.setText(gn.getNotice());

        Log.e(TAG, "getView: " + gn.toString());
        return noticeRow;
    }
}

