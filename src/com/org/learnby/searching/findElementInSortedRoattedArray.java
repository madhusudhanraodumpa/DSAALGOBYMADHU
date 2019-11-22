package com.org.learnby.searching;

public class findElementInSortedRoattedArray {
    public static void main(String args[]){
        int a[]={6,7,1,2,3,4,5};
        System.out.println(findSEarchElement(a,0,a.length-1,4));
        System.out.println(findSerachElementWithOutPivot(a,0,a.length-1,4));

        //  System.out.println(pivotedBinarySearch(a,a.length,6));

    }

    private static int findSerachElementWithOutPivot(int a[],int s,int e,int serchElement){
        int mid=(s+e)/2;
        if(s>e){
            return -1;
        }
        if(a[mid]==serchElement){
            return mid;
        }
        if(a[s]<=a[mid]){
            if(a[s]<=serchElement && serchElement<=a[mid]){
               return  findSerachElementWithOutPivot(a,s,mid-1,serchElement);
            }else{
               return  findSerachElementWithOutPivot(a,mid+1,e,serchElement);
            }

        }

        if(a[e]>=a[mid] && a[e]>=serchElement){
            return findSerachElementWithOutPivot(a,mid+1,e,serchElement);

        }

        return findSerachElementWithOutPivot(a,s,mid-1,serchElement);

    }

    // using pivot element
    private static int findSEarchElement(int[] a, int s, int e, int serachElement) {
        //int mid=(s+e)/2;
        int pivotIndex=BinarySearchPivotElement.findPivotElement(a,s,e);
        if(s>e){
            return -1;
        }
        if (pivotIndex==-1){
            return BinarySearch.recursiveBinarySearch(a,s,e,serachElement);
        }
        if(a[pivotIndex]==serachElement)
            return pivotIndex;

       /* if(serachElement> =a[0]){
            return BinarySearch.recursiveBinarySearch(a,s,pivotIndex-1,serachElement);
        }else {
            return BinarySearch.recursiveBinarySearch(a,pivotIndex+1,e,serachElement);
        }*/
        if(serachElement>=a[0]){
            return BinarySearch.recursiveBinarySearch(a,0,pivotIndex-1 ,serachElement);

        }else{
            return BinarySearch.recursiveBinarySearch(a,pivotIndex+1,e,serachElement);

        }
    }


}
