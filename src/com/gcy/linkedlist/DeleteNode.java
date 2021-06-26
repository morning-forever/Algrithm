package com.gcy.linkedlist;

import java.util.HashMap;

/**
 * 给定一个链表的头指针和一个节点指针，定义一个函数在O(1)内删除这个节点
 *
 *
 * 链表翻转：迭代翻转（推荐），递归翻转
 * 每 K 个1组进行翻转：startKPre,startK,endK,endKNext,
 * 每 K 个1组进行逆序翻转：先翻转，再 K 个1组，再 翻转回来即可
 *
 * 快慢指针:
 * 解决决以下两大类问题
 * 寻找/删除第 K 个结点
 * 有关链表环问题的相关解法
 * 试一下能提交不？git，台式机，新电脑,再提交一次
 * */
public class DeleteNode {

    public static void main(String args[]) throws Exception {

        int[] a = {1,2,3,4,5,6,7};
        LinkedList linkedList = new LinkedList();
        for(int i = 0 ; i < a.length;i++){
            linkedList.headInsert(a[i]);
        }

        linkedList.print();

         //删除指定节点（如：删除只为2的节点）
        /*Node tmp = linkedList.head.next;
        while( tmp.data != 2 ){
            tmp = tmp.next;
        }
        linkedList.deleteNode(tmp);*/
        //递归翻转链表
      //  Node node = invertLinkedList(linkedList.head.next);
      //linkedList.head.next = node;
        //迭代翻转链表
        //iterationInvertLinkedList(linkedList);

        //invertLinkedList(linkedList.head,2,4);
        // 每 K 个 1组进行翻转
        //invertLinkedList(linkedList,3);

        // 每k个1组进行逆序翻转
       // reverseInverseLinkedList(linkedList,3);

        //寻找中间节点
        //Node middleNode = findMiddleNode(linkedList);
        //System.out.println("中间节点："+middleNode);

        //寻找倒数第k个节点
        //Node kth= findKthToTail(linkedList,8);
        //System.out.println("倒数第3个节点："+kth);

        //向右旋转K个位置
        //reverseKthToTail(2, linkedList);
        // 删除第k个节点
        //deleteKthToTail(linkedList,2);


        //linkedList.print();

        // 两个链表是否有焦点
        Node node = isIntersecting(linkedList, linkedList);

        System.out.println("相交点："+node.data);

    }

    /**
     * 递归方式翻转链表
     * @param node
     * @return
     */
    public static Node invertLinkedList(Node node){

        if(node.next == null){
            return node;
        }
        Node  newHead = invertLinkedList(node.next);
        node.next.next= node;
        node.next = null;

        return newHead;
    }

    /**
     *翻转链表中的一段（从第fromIndex个元素到第toIndex个元素）
     * @param head
     * @param fromIndex
     * @param toIndex
     */
    private static void invertLinkedList(Node head,int fromIndex, int toIndex){

        //1.先找到fromPre(from -1),from ,to ,toNext(to+1) 节点
        Node temp = head.next;
        Node fromPre = null;
        Node from = null;
        Node to = null;
        Node toNext = null;

        int curIndex = 1;
        while(curIndex <= fromIndex-1){ // 找到fromPre
            if(curIndex == fromIndex-1){
                fromPre = temp;
            }
            curIndex++;
            temp = temp.next;
        }
        while(curIndex <= fromIndex){ //找到 from
            if(curIndex == fromIndex){
                from= temp;
            }
            curIndex++;
            temp = temp.next;
        }

        while(curIndex <= toIndex){ //找到 to
            if(curIndex == toIndex){
                to= temp;
            }
            curIndex++;
            temp = temp.next;
        }

        while(curIndex <= toIndex+1){ //找到 toNext
            if(curIndex == toIndex+1){
                toNext= temp;
            }
            curIndex++;
            temp = temp.next;
        }


        Node  pre =  from;
        Node cur = from.next;
        pre.next = toNext;

        while(cur != toNext){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        fromPre.next = pre;

    }

    /**
     * 翻转链表，每K个节点一组进行翻转
     * @param linkedList
     * @param k
     */
    private static void invertLinkedList(LinkedList linkedList,int k){
        Node startKPre = linkedList.head;
        int step = 0;
        Node startK = null;
        Node endK = null;
        Node tmp = linkedList.head.next;

        while(tmp != null){
            if(step == 0){
               startK = tmp;
            }else if(step == k-1){
                endK = tmp;

                //进行翻转
                Node endKNext = endK.next;

                Node pre =  startK;
                Node cur = startK.next;
                pre.next = endKNext;

                while(cur != endKNext){
                    Node next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                startKPre.next = pre;
                // 翻转结束

                //重置
                step = 0;
                startKPre = startK;
                tmp = endKNext;
                continue;

            }

            step++;
            tmp = tmp.next;
        }
    }

    /**
     * 每 K 个1组，逆序翻转链表
     * @param linkedList
     * @param k
     */
    private static void reverseInverseLinkedList(LinkedList linkedList , int k){
        iterationInvertLinkedList(linkedList);
        invertLinkedList(linkedList,k);
        iterationInvertLinkedList(linkedList);
    }

    /**
     * 迭代翻转链表
     * @param linkedList
     */
    private static void iterationInvertLinkedList(LinkedList linkedList){

        Node pre = linkedList.head.next;
        Node cur = pre.next;
        pre.next = null;
        while(cur != null){

            Node next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        linkedList.head.next = pre;
    }

    /**
     * 寻找中间节点
     * @param linkedList
     */
    private static Node findMiddleNode(LinkedList linkedList){
        Node fast = linkedList.head;
        Node slow = linkedList.head;

        while(fast!=null ){
            slow = slow.next;
            if(fast.next == null){
                fast = null;
            }else{
                fast = fast.next.next;
            }

        }
        return slow;
    }

    /**
     * 寻找链表的倒数第K个节点
     * @param linkedList
     * @return
     */
    private static Node findKthToTail(LinkedList linkedList,int k) throws Exception{

        Node fast = linkedList.head;
        Node slow = linkedList.head;
        int step = 0;
        while(step < k && fast!= null){
            fast = fast.next;
            step++;
        }

        if(fast == null){
           throw new Exception("K大于链表长度");
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     *给定一个单链表，设计一个算法实现链表向右旋转 K 个位置。举例：给定 head->1->2->3->4->5->NULL, K=3,右旋后即为 head->3->4->5-->1->2->NULL
     * @param k
     * @param linkedList
     */
    private static void reverseKthToTail(int k,LinkedList linkedList) throws Exception {
        //1.先找到倒数第K+1个节点
        Node kPre = findKthToTail(linkedList, k + 1);

        //2.寻找尾节点
        Node tmp = linkedList.head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        Node last = tmp;

        //3.将原来的尾节点的后继节点设为 头结点的后继节点
        Node headNext = linkedList.head.next;
        last.next = headNext;

        //4.将头节点的后继节点设为k节点
        Node kth = kPre.next;
        linkedList.head.next = kth;

        //5.将上面找到的节点的后继节点设为null
        kPre.next = null;
    }

    /**
     * 输入一个链表，删除该链表中的倒数第 k 个结点
     * @param linkedList
     */
    private static void deleteKthToTail(LinkedList linkedList,int k){
        try {
            //1.找到倒数第k+1 个节点
            Node kthToTail = findKthToTail(linkedList, k + 1);
            //2. 删除第k个节点
            kthToTail.next = kthToTail.next.next;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 链表是否相交
     * @param linkedList1
     * @param linkedList2
     * @return 相交返回相交的节点，不相交返回null
     */
    private  static Node isIntersecting(LinkedList linkedList1 , LinkedList linkedList2){


        //1.先获得链表的长度
        int length1 = 0;
        Node tmp = linkedList1.head;
        while(tmp.next!=null){
            length1++;
            tmp = tmp.next;
        }
        int length2 = 0;
        tmp = linkedList2.head;
        while(tmp.next != null){
            length2++;
            tmp = tmp.next;
        }
        
        //2.找焦点
        int diffLength = length1 - length2;
        if(diffLength > 0){
            Node p1 = linkedList1.head;
            int step = 0;
            while(step < diffLength){
               p1 = p1.next;
               step++;
            }

            Node p2 = linkedList2.head;
            while(p1.next!= null){
                p1 = p1.next;
                p2 = p2.next;
                if(p1 == p2){
                    return p1;
                }
            }
            return null;
        }else{
           diffLength = -diffLength;
           int step = 0;
           Node p2 = linkedList2.head;
           while(step < diffLength){
               p2 = p2.next;
               step++;
           }

           Node p1 = linkedList1.head;

           while(p1.next!= null){
               p1 = p1.next;
               p2 = p2.next;
               if(p1 == p2){
                   return p1;
               }
           }
           return null;
        }
    }

    /**
     * 判断链表是否成换
     * @param
     */
    private static  Node isCycling(LinkedList linkedList){

        //先判断是否成环
        Node fast = linkedList.head;
        Node slow = linkedList.head;
        Node meetNode = null;
        while(fast!= null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(fast.data == slow.data){
                meetNode = slow;
            }
        }

        //计算入口节点
        if(meetNode != null){ //说明有环

        }

        return null;
    }
}

    class LinkedList{
    int length = 0;
    Node head = new Node(0);

    public void addNode(int data){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void headInsert(int data){
        Node nodeNew = new Node(data);
        nodeNew.next = head.next;
        head.next = nodeNew;
    }

    public void print(){
        System.out.print("head");
        Node node = head.next;
        while(node != null){
            System.out.print("-->"+node.data);
            node = node.next;
        }
        System.out.println();
    }

    public void deleteNode(Node node){
        //把要删除节点的下一个节点的值赋给要删除的节点，则问题转化为“删除下一个节点”
        node.data = node.next.data;
        //删除下一个节点
        Node delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }
}

class Node{
    int data;
    Node next = null;
    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
