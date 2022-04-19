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

    private void add(ListNode nodeToAdd){
        ListNode temp = this.next;
        this.next = nodeToAdd;
        nodeToAdd.next = temp;
    }

    private void removeNextNode(){
        if(this.next != null)
            this.next = this.next.next;
    }

    public static ListNode add(ListNode head, ListNode nodeToAdd, int position){
        ListNode node = head;
        for(int i = 0; i < position -1; i++){
            if(node.next == null)
                break;
            node = node.next;
        }
        node.add(nodeToAdd);
        return head;
    }

    public static ListNode remove(ListNode head, int positionToDelete){
        ListNode node = head;
        for(int i = 0; i < positionToDelete - 1; i++){
            if(node.next == null){
                return head;
            }
            node = node.next;
        }

        node.removeNextNode();

        return head;
    }

    public static boolean contains(ListNode head, ListNode nodeToCheck){
        ListNode node = head;
        while (node != null){
            if(node.getValue() == nodeToCheck.getValue())
                return true;
            node = node.next;
        }
        return false;
    }

    public static int size(ListNode head){
        int count = 0;

        ListNode node = head;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    public static ListNode find(ListNode head, int positionToFind){
        ListNode node = head;

        for(int i = 0; i < positionToFind; i++){
            if(node.next == null){
                throw new IndexOutOfBoundsException();
            }
            node = node.next;
        }
        return node;
    }

    public static void print(ListNode head){
        ListNode node = head;
        int position = 0;
        while (node != null){
            System.out.println("position : " + position + ", value = " + node.getValue());
            node = node.next;
            position++;
        }
    }
}
