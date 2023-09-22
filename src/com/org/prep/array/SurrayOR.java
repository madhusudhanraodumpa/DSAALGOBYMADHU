package com.org.prep.array;

public class SurrayOR {
    public static void main(String args[]){
        int[] a={68545, 260786, 1, 29565, 29695, 24193, 114797, 240479, 46076, 403900, 36502, 133043, 249601, 383845, 783681, 517539, 71023, 64414, 260785, 87097, 158803, 869131, 359079, 43321, 84617, 5269, 3961, 74089, 302933, 632476, 9799, 62305, 161839, 190323, 119680, 483133, 403789, 53401, 1, 20608, 285969, 9790, 353266, 1171, 23371, 125489, 63870, 29825, 148627, 150970, 101005, 591057, 13876, 222667, 389993, 362701, 67555, 94498, 473685, 220024, 364414, 194635, 297136, 40353, 525031, 552817, 315371, 23815, 10737, 194619, 56616, 4506, 9697, 30241, 100829, 200719, 367173, 335665, 21313, 62670, 15751, 34019, 72997, 592389, 1273, 513541, 29206, 714919, 593629, 273225, 861736, 428679, 7251, 339879, 81537, 199717, 11449, 266311, 721840, 147187};
        System.out.println(solve(a));
    }
    public static int subbaryOR1(int[] a){
        int n=a.length;
        int total=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum|a[j];
                total=total+sum;
            }
        }
        return total;
    }


    public static int solve(int[] a) {
        int n=a.length;
        long total=0;
        int b[]=new int[n];
        int mod=1000000007;

        for(int i=0;i<32;i++){

            for(int j=0;j<n;j++){

                if(((a[j]>>i)&1)==1){
                    b[j]=1;
                }else{
                    b[j]=0;
                }

            }

            total=(total%mod+(subOR1(n,b)%mod*(int)Math.pow(2,i)%mod)%mod)%mod;

        }
        return (int)total%mod;

    }

    public static long subOR1(int A, int[] B) {
        long ans=0;
        long count=0;
        for(int i=0;i<A;i++){

            if(B[i]==0){

                count++;

            }else{

                ans=ans+((count*(count+1))/2);
                count=0;

            }



        }


        if(count>0){
            ans=ans+((count*(count+1))/2);
        }

        ans= (long)((long)A*(long)(A+1))/2-ans;
        return ans%1000000007;


    }

}
