/*Exercise - create my version of the String method "indexOf()"*/
/* text of exercise:
If the designers of the String class had not defined the version of indexOf that takes
a string argument, you could implement it using the other methods available in the
library. Without calling indexOf directly, implement a method myIndexOf that
behaves in exactly the same way
 */

package com.company;
import acm.program.ConsoleProgram;


public class Main extends ConsoleProgram{

    public static void main(String[] args) {
        (new com.company.Main()).start();
    }

    public void run(){

       int position = myIndexOf(insertMainString(),insertCheckString()); //called checkString instead of subString
        // to not create confusion with the method substring()
        if(position>0){
            println("Your substring was found, it starts at position "+position);
        }else println("Your substring was not found");

    }

    private String insertMainString() {
        String enteredWord;
        do {            //do while prevents the algorithm to move forward if
            // the user hits ENTER before adding any character
            enteredWord = readLine("Enter your main string here: ");
        } while (enteredWord.equals(""));
        return enteredWord;
    }

    private String insertCheckString() {
        String enteredWord;
        do {            //do while prevents the algorithm to move forward if
            // the user hits ENTER before adding any character
            enteredWord = readLine("Enter your sub string to be searched here: ");
        } while (enteredWord.equals(""));
        return enteredWord;
    }

    /**compares a string and the substring (passed as parameters). if substring is found,
     * returns the index (int), if it is not found, returns -1
     * @param mainString
     * @param checkString
     */
    private int myIndexOf(String mainString, String checkString){
        int counter=0;
        String str;
        while(whileConditionMyIndexOf(mainString,checkString, counter)){
            str=mainString.substring(counter,checkString.length()+counter);
            if(str.equals(checkString)){
                return counter;
            }
            counter++;
        }
        return -1;
    }


    /*i created a method for the while condition in myIndexOf, to increase readability*/

    private boolean whileConditionMyIndexOf(String mainString, String checkString, int counter) {
       //condition is true when the counter is lesser than the length of the
        // main string minus the length of the substring
        //as there is no point to keep comparing if the remaining portion of
        // main string is lesser than the length of the substring
        return (counter < mainString.length()) &&
                (counter < (mainString.length() - checkString.length() - 1));
    }
}
