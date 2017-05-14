package com.curiositylabs.apps.smartcampus;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by SHADRACK NGOTHO on 2/6/2017.
 */

public class SoftwareAdapter  extends BaseExpandableListAdapter{
    private Context ctx;
    private HashMap<String, List<String>> Year_Category;
    private List<String> Year_List;

    public SoftwareAdapter(Context ctx,HashMap<String, List<String>> Year_Category,List<String> Year_List ){
        this.ctx = ctx;
        this.Year_Category = Year_Category;
        this.Year_List = Year_List;
    }

    @Override
    public int getGroupCount() {
        return Year_List.size();
    }

    @Override
    public int getChildrenCount(int arg0) {
        return Year_Category.get(Year_List.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {
        return Year_List.get(arg0);
    }

    @Override
    public Object getChild(int parent, int child) {

        return Year_Category.get(Year_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int arg0) {
        return arg0;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {
        String group_title = (String) getGroup(parent);
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.soen_academics_list,parentView, false );
        }

        TextView parent_textView = (TextView) convertView.findViewById(R.id.soen_list);
        parent_textView.setTypeface(null, Typeface.BOLD);
        parent_textView.setText(group_title);
        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean LastChild, View convertView, ViewGroup parentView) {

        String child_title = (String) getChild(parent, child);
        if (convertView==null){
            LayoutInflater inflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_soen_list, parentView, false);
        }
        TextView child_textView = (TextView) convertView.findViewById(R.id.soen_child_list);
        child_textView.setText(child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

