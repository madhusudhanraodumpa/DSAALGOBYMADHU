package com.org.prep.bits;

public class Missing2Elements {
    public static void main(String[] args){
        int a[]={1,4,5,3,7};
        int[] b=missingTwoElements(a);
        System.out.println(b[0]+" "+b[1]);
    }
    public static int[]  missingTwoElements(int[] a){

        int n=a.length;
        int res=0;
        for(int i=1;i<=n+2;i++){
            res=res^i;
        }
        for(int i=0;i<n;i++){
            res=res^a[i];
        }

        int pos=-1;

        for(int i=0;i<32;i++){

            if(((res>>i)&1)==1){
                pos=i;
                break;
            }
        }

        int set=0;
        int unset=0;

        for(int i=0;i<n;i++){
            if(((a[i]>>pos)&1)==1){
                set=set^a[i];
            }else{
                unset=unset^a[i];
            }
        }

        int[] ans=new int[2];
        if(!(set>unset)){
            ans[0]=set;
            ans[1]=unset;
        }else{
            ans[0]=unset;
            ans[1]=set;
        }
        return ans;





    }

}
