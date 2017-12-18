package com.example.demo;

/**
 * Created by chenlu on 2017/11/30.
 */
public class LinkedListDemo {
    Node head = null;

    //添加结点
    public void addNode(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node node = new Node(data);
            temp.next = node;
        }
    }

    //删除指定位置的结点
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            if (i == index) {
                preNode.next = currNode.next;
                return true;
            }
            preNode = currNode;
            currNode = currNode.next;
            i++;
        }
        return false;
    }

    //返回结点的长度
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //不知道头结点的情况删除结点
    public boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        int temp = n.data;
        n.data = n.next.data;
        n.next.data = temp;
        n.next = n.next.next;
        return true;
    }

    //链表输出
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node reverseIteratively(Node head) {//遍历反转法
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return this.head;
        /****方法二*******/
//        Node temp = null;
//        Node preNode = null;
//        while(head != null){
//            temp = head;
//            head = head.next;
//            temp.next = preNode;
//            preNode=temp;
//        }
//        this.head = temp;
//        return this.head ;
    }

    public Node resetList1(Node head) {//递归倒置链表
        if (head == null || head.next == null) {
            return head;                        // 若为空链或者当前结点在尾结点，则直接返回
        } else {
            Node newHead = resetList1(head.next);   //反转后续节点head.next
            head.next.next = head;                 //将当前节点的指针域向前移
            head.next = null;                   //前一节点的指针域置空
            this.head = newHead;
            return newHead;
        }
    }

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.addNode(3);
        linkedListDemo.addNode(7);
        linkedListDemo.addNode(12);
        linkedListDemo.addNode(9);
        linkedListDemo.addNode(5);
        linkedListDemo.addNode(8);
        linkedListDemo.printList();
        //System.out.println(linkedListDemo.length());
        //System.out.println(linkedListDemo.head.data);
        linkedListDemo.deleteNode(3);
        linkedListDemo.printList();
        //System.out.println(linkedListDemo.deleteNode(new Node(12)));
        linkedListDemo.reverseIteratively(linkedListDemo.head);
        //linkedListDemo.resetList1(linkedListDemo.head);
        linkedListDemo.printList();
    }

}

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}
