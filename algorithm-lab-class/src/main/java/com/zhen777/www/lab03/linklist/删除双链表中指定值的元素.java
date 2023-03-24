package com.zhen777.www.lab03.linklist;

// 在链表中删除指定值的所有节点
public class 删除双链表中指定值的元素 {
    public static class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class LinkList {
        public Node head;
        public Node tail;

        public void append(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;

            }
            current.next = node;
            current.next.prev = current;
            this.tail = node;
        }

        public LinkList remove(int value) {
            Node current = head;
            if (current == null) {
                return null;
            }
            while (current.data == value) {
                current = current.next;
                current.prev = null;
            }

            while (current.next != null) {
                if (current.next.data == value) {
                    if (current.next.next != null) {
                        current.next.next.prev = current;
                    } else {
                        tail = current;
                    }
                    current.next = current.next.next;
                }
                current = current.next;
            }

            return this;
        }

        public void display() {
            Node current = head;
            StringBuilder message = new StringBuilder();
            while (current != null) {
                message.append(current.data).append(" -> ");
                current = current.next;
            }

            message.append("null");
            System.out.println(message);
        }

        public void display_reverse() {
            Node current = this.tail;
            StringBuilder message = new StringBuilder();
            while (current != null) {
                message.append(current.data).append(" -> ");
                current = current.prev;
            }
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
        ls.display_reverse();
        System.out.println("原始链表删除2");
        ls.remove(2).display();
        ls.display_reverse();
        System.out.println("原始链表删除4");
        ls.remove(4).display();
        ls.display_reverse();
        System.out.println("原始链表删除1");
        ls.remove(1).display();
        ls.display_reverse();

    }

}
