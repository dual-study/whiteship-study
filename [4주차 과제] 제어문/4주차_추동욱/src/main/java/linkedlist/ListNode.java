package linkedlist;

import java.util.Optional;

public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue(){
        return value;
    }

    public static ListNode add(ListNode head, ListNode nodeToAdd, int position){
        return null;
    }

    public static ListNode remove(ListNode head, int positionToDelete){
        return null;
    }

    public static boolean contains(ListNode head, ListNode nodeToCheck){
        return false;
    }

    public static int size(ListNode head){
        return -1;
    }

    public static ListNode find(ListNode head, int positionToFind){
        return null;
    }
}
