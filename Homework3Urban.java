
package homework3urban;

import java.util.Scanner;

/**
 * Custom-written scanner for validating financial values.
 * @author chase
 */
public class Homework3Urban {

    public static void main(String[] args) {
        System.out.println("Enter a number in financial notation");
        Scanner in = new Scanner(System.in);
        boolean valid;
        while (in.hasNext()){
            valid = financialScanner(in);
            System.out.println(valid?" - returns true":" - returns false");
        }
    }

    public static boolean financialScanner(Scanner in){
        String origPhrase = in.next();
        int length = origPhrase.length();
        char[] phrase = new char[length + 1];
        for (int i = 0; i < length; i++) {
            phrase[i] = origPhrase.charAt(i);
        }
        phrase[length] = 0;
        int currentState = 0;
        for (int i = 0; i < length+1; i++) {
            switch (currentState) {
                case 0:
                    if (phrase[i] == '$')
                        currentState = 1;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 1:
                    if (phrase[i] == '*')
                        currentState = 1;
                    else if (phrase[i] == '0')
                        currentState = 2;
                    else if (48 < phrase[i] && phrase[i] < 58)
                        currentState = 6;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 2:
                    if (phrase[i] == '.')
                        currentState = 3;
                    else if (phrase[i] == 0) {
                        System.out.print("Is in an accepting state. Succeeds in state " + currentState);
                        return true;
                    }
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 3:
                    if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 4;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 4:
                    if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 5;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 5:
                    if (phrase[i] == 0) {
                        System.out.print("Is in an accepting state. Succeeds in state " + currentState);
                        return true;
                    }
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                case 6:
                    if (phrase[i] == '.')
                        currentState = 3;
                    else if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 7;
                    else if (phrase[i] == ',')
                        currentState = 9;
                    else if (phrase[i] == 0) {
                        System.out.print("Is in an accepting state. Succeeds in state " + currentState);
                        return true;
                    }
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 7:
                    if (phrase[i] == '.')
                        currentState = 3;
                    else if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 8;
                    else if (phrase[i] == ',')
                        currentState = 9;
                    else if (phrase[i] == 0) {
                        System.out.print("Is in an accepting state. Succeeds in state " + currentState);
                        return true;
                    }
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 8:
                    if (phrase[i] == '.')
                        currentState = 3;
                    else if (phrase[i] == ',')
                        currentState = 9;
                    else if (phrase[i] == 0) {
                        System.out.print("Is in an accepting state. Succeeds in state " + currentState);
                        return true;
                    }
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 9:
                    if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 10;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 10:
                    if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 11;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
                case 11:
                    if (47 < phrase[i] && phrase[i] < 58)
                        currentState = 8;
                    else {
                        System.out.print("Not in an accepting state. Fails in state " + currentState);
                        return false;
                    }
                    break;
            }
        }
        return false;
    }
}