package sun.study.java.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: java-demo
 * @description: 两个队列实现一个栈
 * @author: chopin.sun
 * @create: 2019-07-18 18:09
 **/

public class StackByQueue {

    Queue q1 = new LinkedList();
    Queue q2 = new LinkedList();

    public static void main(String[] args) {
        StackByQueue stack = new StackByQueue();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("8");
        stack.push("9");
        stack.push("10");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


    public void push(Object o){
        q1.add(o);
    }

    public Object pop(){
        while(q1.size()>1){
            q2.offer(q1.poll());
        }
        Object o = q1.poll();
        while (q2.size()>0){
            q1.offer(q2.poll());
        }
        return o;
    }
}
