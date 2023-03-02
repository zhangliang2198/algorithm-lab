package com.zhen777.www.lab02.linklist;

import com.zhen777.www.common.SinglePointNode;

/**
 * 连表翻转
 *
 * @author mikoozhang[zhangliang2198@outlook.com]
 * @version 1.0.0
 */
public class LinkRevert {
    public static void main(String[] args) {
        SinglePointNode singleLink = createSingleLink();
        printLink(singleLink);
        SinglePointNode newHead = revertSingleLink(singleLink);
        printLink(newHead);
    }

    //传入头指针，返回新的头指针
    private static SinglePointNode revertSingleLink(SinglePointNode head) {
        // 要返回的头指针
        SinglePointNode curr = head;
        SinglePointNode prev = head;
        SinglePointNode next = head.next;
        head.next = null;
        while (next != null) {
            prev = next;
            next = next.next;
            prev.next = curr;
            curr = prev;
        }

        return prev;
    }


    private static void printLink(SinglePointNode head) {
        SinglePointNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    private static SinglePointNode createSingleLink() {
        SinglePointNode node0 = new SinglePointNode(0);
        SinglePointNode node1 = new SinglePointNode(1);
        SinglePointNode node2 = new SinglePointNode(2);
        SinglePointNode node3 = new SinglePointNode(3);
        SinglePointNode node4 = new SinglePointNode(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        return node0;
    }

}
