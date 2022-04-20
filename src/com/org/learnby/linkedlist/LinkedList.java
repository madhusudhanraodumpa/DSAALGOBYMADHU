package com.org.learnby.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LinkedList {
    private Node head = null;


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;

        }


    }

    public void insertBegging(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }


    }

    public boolean searchANumber(int data) {
        if (head == null) return false;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteFirest() {
        if (head != null) {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (head == null) return;
        Node temp = head;
        Node previous = null;
        while (temp.next != null) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
    }

    public Node oddEvenList(Node head) {

        Node odd=new Node(-1);
        Node pOdd=odd;
        Node even=new Node(-1);
        Node pEven=even;
        Node cur=head;
        while(cur!=null){
            if(cur.data%2==0){
                pEven.next=cur;
                pEven=pEven.next;

            }else{
                pOdd.next=cur;
                pOdd=pOdd.next;
            }

            cur=cur.next;

        }
        pEven.next=odd.next;
        pOdd.next=null;


        return pEven.next;
    }

    public void deleteNodeByNumber(int data) {
        Node temp = head;
        Node previous = null;
        while (temp != null) {
            if (temp.data == data) {
                if (previous != null) {
                    previous.next = temp.next;
                } else {
                    head = head.next;
                }
            } else {
                previous = temp;
            }
            temp = temp.next;
        }
        if (head != null && head.data == data) {
            head = head.next;
        }

    }

    public void deleteNodeByIndex(int index) {
        Node temp = head;
        Node previous = null;
        int n = 0;
        while (temp != null) {
            if (index == n) {
                if (previous == null) {
                    head = head.next;
                } else {
                    previous.next = temp.next;
                }
                break;
            }
            n++;
            previous = temp;
            temp = temp.next;
        }
    }

    public void reverseLonkedListTemp() {

        if (head == null) return;
        if (head.next == null) return;
        Node temp = head;
        Node current = head;
        Node previous = null;
        while (current != null) {
            temp = temp.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    public void reverseLinkedList() {
        Node temp = head;
        Node current = head;
        Node previous = null;
        while (current != null) {
            temp = temp.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    public Node reverseRecursive(Node node) {

        if (node == null) {
            return null;
        }
        if (node.next == null) {
            head = node;
            return node;
        }

        Node temp = reverseRecursive(node.next);
        temp.next = node;
        node.next = null;
        return node;
    }

    public Node reverseRecursiveTemp(Node node) {

        if (node == null) return node;
        if (node.next == null) {
            head = node;
            return node;
        }

        Node temp = reverseRecursiveTemp(node.next);
        temp.next = node;
        node.next = null;
        return node;

    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }

    public Node reverseBetween(Node head, int m, int n){
        Node dummy=new Node(-1);
        dummy.next=head;
        head=dummy;
        Node p1=null;
        Node c1=dummy;
        int count=n-m;

        while(m>0 && c1!=null){
            p1=c1;
            c1=c1.next;
            m--;
        }
        Node c2=c1;
        Node p2=p1;
        Node temp=null;

        while(count>0 && c2!=null){
            temp=c2.next;
            c2.next=p2;
            p2=c2;
            c2=temp;
            count--;


        }
        p1.next=p2;
        c1.next=c2;
        return dummy.next;
        }
    public Node rotateRight(Node head, int k) {
        if(head==null || head.next==null || k==0) return head;

        int len=1;
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        cur.next=head;
        k=k%len;
        k=len-k;
        while(k>0){
            cur=cur.next;
            k--;

        }
        head=cur.next;
        cur.next=null;
        return head;


        /** ListNode dummy=new ListNode();
         dummy.next=head;
         ListNode c1=dummy;
         ListNode c2=dummy;
         ListNode prev=dummy;
         ListNode prev1=dummy;

         while(k>0){
         c1=c1.next;
         k--;
         }
         while(c1!=null && c2!=null){
         prev=c2;
         c1=c1.next;
         c2=c2.next;

         }
         prev.next=null;
         ListNode nHead=c2;
         ListNode c3=nHead;
         while(c3.next!=null){
         c3=c3.next;
         }
         c3.next=dummy.next;



         return nHead;
         **/


    }

    public Node reverseRecursiveByP(Node node) {

        if (node == null) {
            return node;
        }
        if (node.next == null) {
            return node;
        }

        Node temp = reverseRecursiveByP(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }

    public void itterativeData() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public void recursiveData(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        recursiveData(node.next);

    }

    public int getInterSectionNode(Node node1, Node node2) {
        int count1=0;
        int count2=0;
        Node movePointer=node1;
        Node current1=node1;
        Node current2=node2;
        while(current1!=null){
            current1= current1.next;
            count1++;
        }
        while(current2!=null){
            current2= current2.next;
            count2++;
        }
        if(count1<count2){
            return getIntersection(count2-count1,node2,node1);
        }else{
            return getIntersection(count1-count2,node1,node2);
        }
    }
    private int getIntersection(int diff,Node node1,Node node2){
        while(diff>0){
            node1=node1.next;
            diff--;
        }

        while(node1!=null && node2!=null){
            if(node1.data==node2.data) return node1.data;
            node1=node1.next;
            node2=node2.next;
        }

        return -1;

    }

    public boolean isPalindrom(Node node1, Node node2) {
        Node node = checkPalindrom(node1, node2);
        if (node == null) return false;

        return true;
    }

    private Node checkPalindrom(Node node1, Node node2) {
        if (node2 == null) {
            return node1;
        }

        Node node = checkPalindrom(node1, node2.next);
        if (node == null) {
            return null;
        }
        if (node.data == node2.data) {
            if(node.next==null){
                return node;
            }
            return node.next;
        }
        return null;
    }

    public boolean isPalindromP(Node head) {
        if(head==null || head.next==null) return true;
        Node slow=head;
        Node fast=head;
        while(fast.next!=null &&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node nHead=slow.next;
        slow.next=null;

        Node cur=nHead;
        Node prev=null;
        Node temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }

        nHead=prev;

        while(head!=null && nHead!=null){
            if(head.data!=nHead.data){

                return false;

            }
            head=head.next;
            nHead=nHead.next;


        }

        return true;


    }

    public boolean detectLoop(Node node) {
        Node node1=node;
        Node node2=node;
        while(node1!=null &&node2!=null && node2.next!=null){
            node1=node1.next;
            node2=node2.next.next;

            if(node1==node2){
                return true;
            }
        }
        return false;
    }

    public void detectLoop1(Node node) {
        Node node1=node;
        Node node2=node;
        boolean loopexits=false;
        while(node1!=null &&node2!=null && node2.next!=null){
            node1=node1.next;
            node2=node2.next.next;

            if(node1==node2){
                loopexits=true;
                break;
            }
        }

     /*   if(loopexits){ int length=1;
        while(node1.next!=node2){
            length=length+1;
            node1=node1.next;
        }

        node1=head;
        node2=head;
        while(length>0){
            node1=node1.next;
            length--;
        }
        while(node1.next!=node2.next){
            node1=node1.next;
            node2=node2.next;
        }
        node1.next=null;
        }*/
     if(loopexits){
         node1=head;
         while(node1!=node2){
             node1=node1.next;
             node2=node2.next;
         }

         while(node1.next!=node2){
             node1=node1.next;
         }
         node1.next=null;

     }

    }
    public void deleteNode(int data){
        Node previous=null;
        Node tmp=head;
        if(tmp==null) return;
        while(tmp!=null){
            if(tmp.data==data){
               if(previous==null){
                   head=head.next;
               }else{
                   previous.next=tmp.next;
               }
            }else {
                previous = tmp;
            }
            tmp=tmp.next;

        }

    }


    public void removeNthFromEnd(Node node, int n) {
        Node node1 = node;
        Node node2 = node;
        for (int i = 0; i <= n; i++) {
            if (node1.next == null) {
                if (i == n - 1) {
                    head = head.next;
                    return;

                }
            }
            node1 = node1.next;

        }
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
    }


    public int[] nextGreaterNode(Node head){
        List<Integer> list=new ArrayList<>();
       Node current=head;
       while(current!=null){
           list.add(current.data);
           current=current.next;
       }

       int[] a=new int[list.size()];
       Stack<Integer> st=new Stack<>();
       for(int i=0;i<list.size();i++){
           while(!st.isEmpty() && list.get(st.peek())<list.get(i)){
               a[st.pop()]=list.get(i);
           }
           st.push(i);
       }
       for(int i:a){
           System.out.print(i+" ");
       }
       return a;
    }


    public Node addTwoNumbers(Node node1, Node node2) {
        int carry=0;
        Node head=null;
        while(node1!=null || node2!=null){
            int value=carry+node1.data+node2.data;
            carry=value/10;
            int addedNumber=value%10;
            if(head==null){
                head=new Node(addedNumber);
            }else {
                insert(addedNumber, head);
            }
            node1=node1.next;
            node2=node2.next;

        }
        if(carry!=0){
           insert(carry,head);
        }
        return head;

    }


    public void insert(int data,Node head) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;

        }


    }
















    public Node reverseNodeByKGroup(Node head,int k){

      //  System.out.println(head.data);
        Node current=head;
        int count=0;
        while(current!=null && count!=k){
            current=current.next;
            count++;
        }

        if(count==k){
            current=reverseNodeByKGroup(current,k);

            while (count>0){
                Node tmp=head.next;
                head.next=current;
                current=head;
                head=tmp;
                count--;
            }
            head=current;
        }


        this.setHead(head);
        return head;
    }

    public Node swapPairs(Node node) {
     /*   Node current = node;
        Node tmp = node;
        Node pre=node;
        while (current!=null && current.next != null) {
            tmp = tmp.next;
            pre.next=tmp;
            current.next = current.next.next;
            tmp.next = current;
            current = tmp;
            current = current.next.next;
            tmp=tmp.next.next;

        }
        return pre;

*/
     Node temp=node;
        node=node.next;
        Node front,back;
        while(temp!=null && temp.next!=null)
        {
            back=temp;
            front=temp.next;

            back.next=front.next;
            front.next=back;

            if(temp.next!=null)
                temp=temp.next;
            if(temp.next!=null)
                back.next=temp.next;
        }
        return node;
    }















    public void buubleSort(Node node) {

    }


}
