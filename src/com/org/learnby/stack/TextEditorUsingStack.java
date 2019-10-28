package com.org.learnby.stack;

import java.util.Scanner;
import java.util.Stack;

public class TextEditorUsingStack {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        java.util.Stack<String> st = new java.util.Stack<>();
        String currentString="";
        int input=sc.nextInt();
        for(int i=0;i<input;i++){
            int operation=sc.nextInt();
            currentString = operations(sc, st, currentString, operation);
        }

    }

    private static String operations(Scanner sc, Stack<String> st, String currentString, int operation) {
        switch (operation) {
            case 1:
                st.push(currentString);
                String inputString=sc.next();
                currentString=currentString+inputString;
                break;
            case 2:
                Integer deletedCharacters=sc.nextInt();
                st.push(currentString);
                currentString=currentString.substring(0,currentString.length()-deletedCharacters);

                break;
            case 3:
                Integer index=sc.nextInt();
                System.out.println(currentString.charAt(index-1));
                break;
            case 4:
                currentString=st.pop();
                break;
        }
        return currentString;
    }
}

