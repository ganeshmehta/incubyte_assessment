import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    int add(String numbers){

        //Defining the variables and datastructures required
        int finalAnswer = 0;
        boolean negFlag = false;

        // To store the negative elements from the string
        List<Integer> negNumbers = new ArrayList();

        //Main Code Starts Here
        // Array of string to store the elements of string as tokens in the array
        String[] tokens;

        //Checking whether the string starts with double leading slash,
        //if yes then split the string based on the given delimiter and if no then splitting the string based on ',' or '\n'
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, 3);
            tokens = StringUtils.splitString(numbers.substring(4), delimiter);
        } else {
            tokens = StringUtils.splitString(numbers, ",\n");
        }

        //Traversing through all the elements
        for(int i = 0; i < tokens.length; ++i) {

            // if negative number is present in the string then we add it to the list of integers and set the value of the boolean to be true so that an exception of negative number can be raised.
            if (tokens[i].matches(".-\\d.")) {
                negNumbers.add(Integer.parseInt(tokens[i]));
                negFlag = true;
            }

            //Checking whether the token is a digit or not, if token is digit then adding it to the finalans
            if (tokens[i].matches(".\\d.") && !negFlag) {
                if (Integer.parseInt(tokens[i]) <= 1000) {
                    finalAnswer += Integer.parseInt(tokens[i]);
                }

            //Checking whether the token is alphabet
            //if toekn is aplhabet then identifying the standard occurring positions of the alphabet and then adding position in the resultant sum
            } else if (tokens[i].matches(".[a-zA-Z].") && !negFlag) {

                //Converting the current char in lowercase in order to prevent wrong calculations
                char c = tokens[i].toLowerCase().charAt(0);
                //subtract 96 from the ascii value of current char in order to get the position of the alphabet
                /* The following intuition works because
                *  the lowercase a - z starts from 97 and if we subtract 96 from we get position
                * */
                int alphabetPosition = c - 96;
                finalAnswer += alphabetPosition;
            }
        }

        //Checking whether negative element flag is set, if yes then raising exception
        if (negFlag) {
            throw new IllegalArgumentException("negatives not allowed " + negNumbers);
        }
        //End
        return finalAnswer;
    }

}