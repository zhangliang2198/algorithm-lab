package com.zhen777.www.lab03.linklist;

import com.zhen777.www.common.DoublePointNode;
import com.zhen777.www.common.SinglePointNode;

// 在链表中删除指定值的所有节点
public class 删除单链表中指定值的元素 {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class LinkList {
        public Node head;

        public void append(Node node) {
            if (head == null) {
                head = node;
                return;
            }
            Node ori = head;
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
            head = ori;
        }

        public LinkList remove(int value) {
            Node ori = head;
            if (head == null) {
                return null;
            }
            while (head.data == value) {
                head = head.next;
            }

            while (head.next != null) {
                if (head.next.data == value) {
                    head.next = head.next.next;
                }
                head = head.next;
            }
            head = ori;
            return this;
        }

        public void display() {
            Node ori = head;
            StringBuilder message = new StringBuilder();
            while (head.next != null) {
                message.append(head.data).append(" -> ");
                head = head.next;
            }
            head = ori;
            message.append("null");
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        LinkList ls = new LinkList();
        ls.append(new Node(1));
        ls.append(new Node(2));
        ls.append(new Node(3));
        ls.append(new Node(4));
        ls.append(new Node(5));
        ls.append(new Node(6));

        System.out.println("原始链表");
        ls.display();
        System.out.println("原始链表删除2");
        ls.remove(2).display();

        System.out.println("原始链表删除4");
        ls.remove(4).display();
    }

}
