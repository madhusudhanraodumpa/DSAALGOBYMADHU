package com.org.prep.stack;

import java.util.Stack;

public class SmplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }
    public static String simplifyPath(String path) {
        String[] direc=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String directory:direc){
            if(directory.equalsIgnoreCase("..")){
                stack.pop();
            }
            if(directory.equalsIgnoreCase("/") || directory.equalsIgnoreCase(".") || directory.equalsIgnoreCase("")){
                continue;
            }else{
                stack.push(directory);
            }
        }
        StringBuilder s1=new StringBuilder("");
        for(String s:stack){
            s1.append("/"+s);
        }
        return s1.toString();

    }
}
