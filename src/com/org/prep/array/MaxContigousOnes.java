package com.org.prep.array;

public class MaxContigousOnes {
    public static void main(String args[]){
        String a="010100110101";
        System.out.println(solve(a));
    }


    public static int solve(String A) {
        int maxOnes=Integer.MIN_VALUE;
        int n=A.length();
        char[] ch=A.toCharArray();
        int count=0;
        for(int i=0;i<n;i++){
            if(ch[i]=='1'){
                count=count+(ch[i]-'0');
            }
        }
        if(n==count) return n;


        for(int i=0;i<n;i++){
            if(ch[i]=='0'){

                int l=0;
                for(int j=i-1;j>=0;j--){

                    if(ch[j]=='1'){
                        l++;
                    }else{
                        break;
                    }

                }

                int r=0;
                for(int j=i+1;j<n;j++){
                    if(ch[j]=='1'){
                        r++;
                    }else{
                        break;
                    }

                }

                if(count==l+r) return count;
                else{
                    maxOnes=Math.max(maxOnes,l+r+1);
                }

            }



        }


        return maxOnes;


    }
}
