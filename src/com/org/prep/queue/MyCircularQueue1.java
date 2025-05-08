package com.org.prep.queue;

public class MyCircularQueue1 {
    public static void main(String[] args) {
        MyCircularQueue1 myCircularQueue = new MyCircularQueue1(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        System.out.println(myCircularQueue.Rear());
    }

        private int capacity;
        private int count;
        private Node head;
        private Node last;


        public MyCircularQueue1(int k) {
            this.count=0;
            this.capacity=k;
        }

        public boolean enQueue(int value) {
            if(this.count==capacity){
                return false;
            }
            Node newNode=new Node(value);
            if(this.count==0){
                head=last=newNode;
            }else{
                last.next=newNode;
                last=newNode;
            }
            this.count +=1;
            return true;

        }

        public boolean deQueue() {
            if(this.count==0){
                return false;
            }
            head=head.next;
            this.count-=1;
            return true;
        }

        public int Front() {
            if(this.count==0){
                return -1;
            }else{
                return this.head.value;
            }
        }

        public int Rear() {
            if(this.count==0){
                return -1;
            }else{
                return this.last.value;
            }
        }

        public boolean isEmpty() {
            return (this.count==0);
        }

        public boolean isFull() {
            return (this.count==this.capacity);
        }


    }

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

