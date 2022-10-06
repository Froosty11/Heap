package com;

import java.util.NoSuchElementException;

public class LinkedList {


    public class Node {

        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }

        public int getData(){
            return this.data;
        }

    }

    public Node getNode(int data) {
        Node current = head; // current looking node- steps to next head every iteration
        Node r = null; // return node
        try{
                if(current.getData() == data){ // if you find the node.
                    return current;
                }
                else{
                    while(current.next != null && current.getData() != data){
                        current = current.next;
                    }
                    if(current.getData() == data){ // if the loop stopped due to 2nd statement
                        r = current;
                    }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
    }

    public Node head;
    public void addNode(int data){
        Node current = head;
        if(head == null){
            head = new Node(data);
        }
        else{
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(data);
        }
    }
    public void appendChain(Node node){
        Node current = this.head;
        while(current.next != null){ // find end of this chain
            current = current.next;
        }
        this.head = node;
    }
    public void addNode(Node node){
        Node current = this.head;
        if(this.head == null){
            this.head = node;
        }
        else{
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }
    public void removeNode(int data){
        Node current = head;
        if(head.getData() == data){
            head = head.next;
        }
        else{
            while(current.next != null && current != null){
                if(current.next.getData() == data){
                    current.next = current.next.next;


                }
                if(current.next == null){
                    return;
                }
                current = current.next;

            }
        }
    }
    public void removeNode(Node node){
        Node current = head;
        if(this.getNode(head.getData()) == node){
            head = null;
        }
        else{
            while(this.getNode(current.getData()) != node && current.next != null){
                current = current.next;
            }
            current.next = null;
        }
    }
    public void printList() throws NoSuchElementException{

        Node current = this.getHead();
        if(current == null){
            throw new NoSuchElementException("No object found") ;
        }
        else{
            while(current != null){
                System.out.println(current.getData());
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node current = this.getHead();
        if(current == null){
            throw new NoSuchElementException("No object found") ;
        }
        else{
            while(current != null){
                s.append("\t").append(current.getData());
                current = current.next;
            }
        }
        return s.toString();
    }

    private Node getHead(){
        return head;
    }

    public boolean isEmpty(){

        Node current = head;
        if(head == null){
            return false;
        }
        return true;
    }
    public void clearChain(){
        this.head = null;
    }
    public void addNodeAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public int chainLength(){
        Node current = head;
        int length = 0;
        if(head == null){
            return 0;
        }
        else{
            while(current != null){
                current = current.next;
                length++;
            }
            return length;
        }
    }
    public int pop(){
        Node current = head;
        Node last;
        while(current.next != null){ //stops at the 2nd to last
            current = current.next;
        }
        int data = current.data;
        last = current;
        current = head;
        while(current.next != last && current.next != null){
            current = current.next;
        }
        current.next = null;
        return data;
    }
    public void push(int data){
        this.addNode(data);
    }
}
