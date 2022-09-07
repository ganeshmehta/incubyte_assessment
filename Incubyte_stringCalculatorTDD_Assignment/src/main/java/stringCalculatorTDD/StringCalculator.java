
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    int add(String numbers){

        //Defining the variables and datastructures required
        int finalAnswer = 0;
        boolean negFlag = false;

        //Main Code Starts Here
        // Array of string to store the elements of string as tokens in the array
        String[] tokens;
		//Checking whether the string starts with double leading slash,
        //if yes then split the string based on the given delimiter and if no then splitting the string based on ',' or '\n'
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, 3);
            tokens = numbers.split(numbers.substring(4), delimiter);
        } else {
            tokens = numbers.split( ",\n");
        }

        //Looping through all the tokens (elements of the string)
        for(int i = 0; i < tokens.length; ++i) {
			finalAnswer+=Integer.parseInt(tokens[i]);
        }

        return finalAnswer;
    }

}