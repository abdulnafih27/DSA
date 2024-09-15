package LinkedList.DoublyLinkedList;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;
    private static class ListNode {
        private int data;
        private ListNode next;
        private ListNode prev; 
        public ListNode(int data) {
            this.data = data;
        }    
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    public void insertEnd(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        length++;
    }

    public void insertBeg(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            tail = newNode;
        }
        else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    public void printFor(){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.data+"-->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public void printBac(){
        ListNode curr = tail;
        while(curr != null){
            System.out.print(curr.data+"-->");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    public void delf(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        // if(head == tail){
        //     head = null;
        //     tail = null;
        // }else{
        //     head = head.next;
        //     head.prev = null;
        // }        
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }
        else{
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
    }

    public void dell(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        }
        else{
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(25);
        dll.insertEnd(26);
        dll.insertEnd(27);
        dll.insertEnd(26);
        dll.insertEnd(278);
        dll.insertBeg(22);
        dll.delf();
        dll.dell();
        dll.printFor();
        dll.printBac();
        System.out.println(dll.length());
    }
}
