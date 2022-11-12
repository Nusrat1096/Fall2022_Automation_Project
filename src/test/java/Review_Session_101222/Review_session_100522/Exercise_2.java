package Review_Session_101222.Review_session_100522;

import java.util.ArrayList;

public class Exercise_2 {
    public static void main(String[] args) {
        //declare and define an arraylist for phone numbers
        ArrayList<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("3479096051");
        phoneNumber.add("3475568861");
        phoneNumber.add("7186557082");
        phoneNumber.add("9178658701");
        phoneNumber.add("9175630761");
        for(int i=0; i< phoneNumber.size(); i++ ){
            System.out.println("My phone number is " + phoneNumber.get(i));
        }


    }//end of main
}// end of java class
