package Day3_100822;

public class T5_Return_Method_Example {
    public static void main(String[] args) {
        //the result of return method is equal to the value you started in the new variable
        int value = Reusable_class.returnTwoAddNumbers(5,2);
        //now you can set additional calculation to the value since you stored it as a variable
        System.out.println("New value is " + (value+3));

    }// end of main
}// end of java class
