package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
        // declare and define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //now add the values for countries array
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("Bahrain");
        countries.add("Pakistan");
        countries.add("Iceland");
        //print usa from the countries list
        System.out.println("Countries value: " + countries.get(0));
        //get me all the counts of the countries list
        System.out.println("Countries count:" + countries.size());
        //call an integer array list for streetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(222);
        streetNumber.add(101);
        streetNumber.add(866);
        System.out.println("Fist streetNumber: " + streetNumber.get(2));


    }// end of main
}// end of java class
