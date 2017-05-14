package com.curiositylabs.apps.smartcampus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SHADRACK NGOTHO on 2/6/2017.
 */

public class Acmp_List_DataProvider {
    public static HashMap<String, List<String>> getInfo(){
        HashMap<String, List<String>> AcmpDetails = new HashMap<String, List<String >>();

        List<String> Third_Year =new ArrayList< String>();
        Third_Year.add("Semester 1");
        Third_Year.add("Semester 2");
        AcmpDetails.put("Year 3", Third_Year);

        List<String> Second_Year =new ArrayList< String>();
        Second_Year.add("Semester 1");
        Second_Year.add("Semester 2");
        AcmpDetails.put("Year 2", Second_Year);

        List<String> First_Year =new ArrayList< String>();
        First_Year.add("Semester 1");
        First_Year.add("Semester 2");
        AcmpDetails.put("Year 1", First_Year);

        List<String> Fourth_Year =new ArrayList< String>();
        Fourth_Year.add("Semester 1");
        Fourth_Year.add("Semester 2");
        AcmpDetails.put("Year 4", Fourth_Year);

        return AcmpDetails;
    }

}
