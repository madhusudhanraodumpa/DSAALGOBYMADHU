package com.org.prep.string;

public class ReverseString {
    public static void main(String[] args){
        System.out.println(solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv "));
    }


    public static String solve(String A) {

        int left=0;
        int right=A.length()-1;

        A=reverse(A,left,right);

        left=0;
        right=0;
        int size=0;
        while(size<A.length()){

            if(A.charAt(right)==' '){
                A=reverse(A,left,right-1);
                left=right+1;
            }
            right++;
            size++;


        }
        A=reverse(A,left,right-1);
        return A;
    }

    public static String reverse(String A,int left,int right){
        char[] ch=A.toCharArray();
        while(left<=right){
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

}
