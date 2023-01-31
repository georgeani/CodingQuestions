import java.util.Scanner;
import java.util.Stack;
public class CheckBrackets {

    /**
     * Question:
     * Write a Java function which, when passed a string containing a mixture of bracket characters -
     * i.e. ‘{‘, ‘}’, ‘[‘, ‘]’, ‘(‘ and ‘)’, returns true if the brackets in the string are correctly balanced, and
     * false otherwise. E.g. when called with “{[(())]()}” it should return true, but “{[(()])()}” should
     * return false. Non-bracket characters in the string should be ignored.
     *
     * The solution for the Bracket problem is interesting
     * I use a stack to keep track of the previous seen characters
     * that allows to check if a bracket that has been opened previously
     * is closed later on.
     *
     * The method is static as this allows the use of the method without creating an object. The use of an object
     * in this case would be redundant.
     *
     * It should be noted that it is assumed that brackets cannot be left incomplete inside others
     * As such, a solution where we only check if the length is odd or not would not work.
     * With the stack we can check if the bracket that closes is the correct one.
     *
     * The input is sanitized to remove any characters that could interfere, if the length is odd we return false.
     * If the string is empty we return true because it is balanced, there are no open or closed brackets.\
     * If the string passes that area the next stage is to populate the stack with the opening brackets.
     * Once there are no opening brackets, the algorithm checks if the closing ones are correct.
     * If the stack output is not the same with the String, or the stack is empty and there is one or more closing
     * characters. The output is False.
     *
     * Once the algorithm loops through the entire String. It checks if the stack is empty.
     * If the brackets are balanced then the stack should be empty.**/


    public static boolean getCheckedBrackets(String input){


        Stack<Character> openingBrackets = new Stack<>();

        input = input.replaceAll("[0-9A-Za-z]","");
        input = input.replaceAll(" +", "");
        int length = input.length();

        if (input.equals(""))
            return true;
        if (length%2!=0)
            return false;

        for(int i=0;i<length;i++){
            if (input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '(') {
                openingBrackets.add(input.charAt(i));
            }
            else {
                if (!openingBrackets.isEmpty()){
                    if (openingBrackets.peek() == '[' && input.charAt(i) == ']' ||
                            (openingBrackets.peek() == '{' && input.charAt(i)=='}') || (openingBrackets.peek() == '(' && input.charAt(i) == ')')) {
                        openingBrackets.pop();
                    }
                } else
                    return false;
            }
        }
        return openingBrackets.isEmpty();
    }

    public static void main(String[] args){
        // Using Scanner to allow for custom input to be checked
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(getCheckedBrackets(input));
    }

}
