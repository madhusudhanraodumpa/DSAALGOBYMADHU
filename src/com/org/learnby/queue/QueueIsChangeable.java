package com.org.learnby.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueIsChangeable {
    public static void main(String args[]) {
        QueueAdvanced q1 = new QueueAdvanced(5);

        int a[] = {5, 5, 5, 10, 10};
        for (int i : a) {
            q1.enQueue(i);
        }
        System.out.println(isChangeable(q1));
    }

    public static boolean isChangeable(QueueAdvanced q1) {
        int fivecount = 0;
        int tencount = 0;
        int icecreamprice = 5;
        while (!q1.isEmpty()) {
            int currency = q1.deQueue();
            if (currency - icecreamprice == 0) {
                fivecount = fivecount + 1;
            } else if (currency - icecreamprice == 5) {
                if(fivecount>0) {
                    fivecount--;
                    tencount++;
                }else{
                    return false;
                }

            }else{

                if(fivecount>0 && tencount>0){
                    fivecount--;
                    tencount--;
                }else if(fivecount>3){
                    fivecount=fivecount-3;
                }else{
                    return false;
                }

            }
        }

        return true;
    }

}
