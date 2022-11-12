package Automation_actionItems;

public class AI1_T2_whileLoop_linearArray {
    public static void main(String[] args) {
        //declare a String array variable
        String[] region ;
        // defining regions for the linear string array
        region = new String[] {"New York City" , "Long Island", "Albany", "Central NY"};
        // declare and define linear array for area code
        int[] areaCode = new int[]{212,631, 518,680};
        //initializer
        int i= 0;
        //condition for while loop
        while(i < areaCode.length){
            System.out.println("My region is "+ region[i]+ " and my area code is "+ areaCode[i]);
            //incrementation
            i++;
        }// end of while loop

    }// end of main
}// end of java class
