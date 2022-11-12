package Automation_actionItems;

import java.util.ArrayList;

public class AI1_T1_forLoop_ArrayList {
    public static void main(String[] args) {
        //declare and define arrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        //add countries to the arraylist
        countries.add("USA");
        countries.add("Canada");
        countries.add("Pakistan");
        countries.add("Bangladesh");
        //declare and define arraylist for country code
        ArrayList<Integer> countryCode = new ArrayList<>();
        //add country codes to the arraylist
        countryCode.add(202);
        countryCode.add(305);
        countryCode.add(405);
        countryCode.add(101);
        // for loop for country code
        for (int i = 0; i < countryCode.size(); i++){
            //print statement
            System.out.println("My country is " + countries.get(i) + " and my country code is " +countryCode.get(i));
        }// end of for loop


    }// end of main
}// end of java class
