package com.org.prep.array;
import java.util.*;

public class ColorfulNumber {


    public static void main(String args[]){
        colorful(3245);
    }

    public static int colorful(int A) {



        Set<Integer> set=new HashSet<>();

        /**  int x=A;

         while(x>0){

         set.add(x%10);
         x=x/10;
         }**/
        String s=String.valueOf(A);
        int len = s.length();
        int mul=s.charAt(0)-'0';
        set.add(s.charAt(0)-'0');
        for(int i=1;i<len;i++){
            int val=s.charAt(i)-'0';
            if(set.contains(val)){
                return 0;
            }
            set.add(val);
            mul=mul*val;
            if(set.contains(mul)){
                return 0;
            }
            set.add(mul);



        }

        return 1;


    }

}
