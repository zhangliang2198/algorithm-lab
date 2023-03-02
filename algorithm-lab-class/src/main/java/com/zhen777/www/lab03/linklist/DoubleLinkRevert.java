package com.zhen777.www.lab03.linklist;

import com.zhen777.www.common.DoublePointNode;

/**
 * 连表翻转
 *
 * @author mikoozhang[zhangliang2198@outlook.com]
 * @version 1.0.0
 */
public class DoubleLinkRevert {
    public static void main(String[] args) {
        DoublePointNode dhead = createDoublePointNode();
        printLink(dhead);
        DoublePointNode newHead = revertDoubleLink(dhead);
        printLink(newHead);
    }

    //传入头指针，返回新的头指针
    private static DoublePointNode revertDoubleLink(DoublePointNode head) {
        // 要返回的头指针
        DoublePointNode prev = head;
        DoublePointNode next = head.next;
        prev.next = null;
        prev.prev = next;

        while (next != null) {
            prev = next;
            next = next.next;
            prev.next = head;
            prev.prev = next;
            head = prev;
        }

        // 重置一下头指针
        return prev;
    }


    private static void printLink(DoublePointNode head) {
        DoublePointNode curr = head;
        DoublePointNode curr1 = head;
        System.out.println();
        System.out.println("正向遍历");
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr1 = curr;
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("反向遍历");
        while (curr1 != null) {
            System.out.print(curr1.data + "->");
            curr1 = curr1.prev;
        }
        System.out.print("null");
    }

    private static DoublePointNode createDoublePointNode() {
        DoublePointNode node0 = new DoublePointNode(0);
        DoublePointNode node1 = new DoublePointNode(1);
        DoublePointNode node2 = new DoublePointNode(2);
        DoublePointNode node3 = new DoublePointNode(3);
        DoublePointNode node4 = new DoublePointNode(4);

        node0.next = node1;

        node1.prev = node0;
        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node4;

        node4.prev = node3;
        return node0;
    }

}
