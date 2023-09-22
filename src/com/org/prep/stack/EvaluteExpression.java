package com.org.prep.stack;
import java.util.*;

public class EvaluteExpression {
    public static void main(String args[]){
        EvaluteExpression e=new EvaluteExpression();
        String a[]={"2", "2", "/"};
       System.out.println( e.evalRPN(a));
    }


    public int evalRPN(String[] A) {
        Stack<Integer> stack=new Stack<>();
        int n=A.length;
        for(int i=0;i<n;i++){
            if(A[i]=="+" || A[i]=="-" || A[i]=="*" || A[i]=="/"){

                int t1=stack.peek();
                stack.pop();

                int t2=stack.peek();
                stack.pop();
                if(A[i]=="+") stack.push(t1+t2);
                else if(A[i]=="-") stack.push(t2-t1);
                else if(A[i]=="*") stack.push(t1*t2);
                else stack.push((int)t2/t1);

            }else{
                stack.push(Integer.valueOf(A[i]));
            }
        }
        return stack.peek();
    }

}
