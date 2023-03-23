package com.zhen777.www.lab03.linklist;

import com.zhen777.www.common.DoublePointNode;
import com.zhen777.www.common.SinglePointNode;

// 在链表中删除指定值的所有节点
public class 删除单链表中指定值的元素 {
    public static void main(String[] args) {
        SinglePointNode singlePointNode = makeNode();
        while (singlePointNode != null) {

            System.out.println(singlePointNode.data);
            singlePointNode = singlePointNode.next;
        }

        singlePointNode = makeNode();
        SinglePointNode singlePointNode1 = deleteValue(singlePointNode, 2);
        while (singlePointNode1 != null) {
            System.out.println(singlePointNode1.data);
            singlePointNode1 = singlePointNode1.next;
        }
    }

    private static SinglePointNode deleteValue(SinglePointNode singlePointNode, int i) {
        if (singlePointNode.next == null) {
            if (singlePointNode.data == i) {
                return null;
            } else {
                return singlePointNode;
            }
        }
        SinglePointNode r_node = singlePointNode;
        SinglePointNode curr = singlePointNode.next;
        SinglePointNode pre = singlePointNode;
        while (curr != null) {
            if (pre.data == i) {
                curr = curr.next;
                pre = pre.next;
                r_node = pre;
            } else {
                if (curr.data == i) {
                    pre.next = curr.next;
                    curr = curr.next;
                } else {
                    curr = curr.next;
                    pre = pre.next;
                }
            }
        }

        return r_node;
    }

    private static SinglePointNode makeNode() {
        SinglePointNode node1 = new SinglePointNode(1);
        SinglePointNode node2 = new SinglePointNode(2);
        SinglePointNode node3 = new SinglePointNode(3);
        SinglePointNode node4 = new SinglePointNode(4);
        SinglePointNode node5 = new SinglePointNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        return node1;
    }
}
