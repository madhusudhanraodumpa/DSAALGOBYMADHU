package com.org.prep.bits;

public class ExcelSheetTitle {


    public String convertToTitle(int columnNumber) {

        String ans="";
        while(columnNumber>0){

            if(columnNumber%26==0){
                ans=ans+"Z";
                columnNumber=columnNumber/26;
            }else{
                int rem=columnNumber%26;
                char ch= (char) ((char)'A'+(rem-1));
                ans=ans+ch;
                columnNumber=columnNumber/26;
            }



        }

        return ans;



    }
}
