package lesson1_19_02_15;

import java.io.*;

public class Lesson1 {
    public static String readLine() {
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            return new String();
        }
    }
    
    public static String stringReverse(String str) {
        String tempStr = new String("");
        for (int i = str.length()-1; i >= 0; i--) {
            tempStr += Character.toString(str.charAt(i));
        }
        
        return tempStr;
    }
    
    public static void stringPrintReversed(String str) {
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
    
    /*public static void main(String args[]) {
        Message msg = new Message("{{{{((((()))))}}}}");
        if (msg.isValid()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        
        msg = new Message("1 2 3 word4");
        System.out.println(msg.countWords());
        
        System.out.println(msg.reverse());
    }*/
}
