package com.org.prep.array;
import java.util.*;

public class PasaclTriangle {
    public static void main(String[] args) {
            generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList() ;
        }
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<numRows;i++){
            int val=1;
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                //System.out.print(val+" ");
                list.add(val);
                int x=val*(i-j)/(j+1);
                val=x;
            }
            result.add(list);
            System.out.println();
        }
        return result ;
    }
}
