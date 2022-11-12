package Review_Session_101222;

public class Exercise_Split_Command {
    public static void main(String[] args) {
        // define automation string variable
        String subjectLine = "Automation_AI101";
        //split the string
        String[] splitMessageArray = subjectLine.split("_");
        //take the second string from the array then grab the number only
        String actionItemNumber = splitMessageArray[1].substring(2);
        //print out John to the console
        System.out.println("The action number item is " + actionItemNumber);


    }// end of main
}// end of java class
