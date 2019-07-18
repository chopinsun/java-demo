package sun.study.java.other;

import java.util.Stack;

/**
 * @program: java-demo
 * @description: 两个栈实现一个队列
 * @author: chopin.sun
 * @create: 2019-07-18 17:33
 **/

public class QueueByStack {

    private Stack s1 = new Stack();
    private Stack s2 = new Stack();
    private int position=1;
    public static void main(String[] args) {
        QueueByStack queue = new QueueByStack();
        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.put("4");
        queue.put("5");
        queue.put("6");

        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        queue.put("7");
        queue.put("8");
        queue.put("9");
        queue.put("10");
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }

    public void put(Object o){
        if(position ==2){
            System.out.println("倒入s1");
            position =1;
            while(!s2.empty()){
                s1.push(s2.pop());
            }
        }
        s1.push(o);
    }
    public Object get(){
        if(position==1){
            System.out.println("倒入s2");
            position =2;
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        Object o = s2.pop();

        return o;

    }
}
