package com.org.learnby.searching;

public class BinarySearch {

    public static void main(String args[]){
        int a[]={0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(iterativeBinarySarch(a,0,a.length-1,0));
        System.out.println(recursiveBinarySearch(a,0,a.length-1,4));

    }
    public static int iterativeBinarySarch(int a[],int s,int e,int serachElement){
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(a[mid]==serachElement){
                ans=mid;
                break;
            }else if(a[mid]>serachElement){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;

    }
   public static int recursiveBinarySearch(int a[],int s,int e,int serachElement){
        int mid=(s+e)/2;
        if(a[mid]==serachElement){
            return mid;
        }
        if(s>e){
            return -1;
        }

        if(a[mid]>serachElement){
            return recursiveBinarySearch(a,s,mid-1,serachElement);
        }else{
            return recursiveBinarySearch(a,mid+1,e,serachElement);
        }


   }

}
