package com.org.learnby.stack;

public class SortStack {
    public static void main (String args[]){
        Stack st=new Stack();
        st.push(7);
        st.push(1);
        st.push(2);
        st.push(9);
        st.push(3);
        st=sort(st);
        while(st.peek()>0){
            System.out.println(st.pop());
        }
    }

    private static Stack sort(Stack st) {
        Stack st1=new Stack();
        while(st.peek()>0){
            int temp=st.pop();
            if(st1.isEmpty()){
                st1.push(temp);
            }else{
                while(st1.peek()>temp && st1.peek()!=-1){
                    st.push(st1.pop());
                }
                st1.push(temp);
            }



        }
        return st1;
    }
}
