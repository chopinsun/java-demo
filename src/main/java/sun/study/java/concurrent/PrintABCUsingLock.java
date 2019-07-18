package sun.study.java.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java-demo
 * @description:
 * @author: chopin.sun
 * @create: 2019-07-17 11:38
 **/

public class PrintABCUsingLock {
    private  static volatile int state = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        new Thread(new MyRunner("A",lock,c1,c2,0)).start();
        new Thread(new MyRunner("B",lock,c2,c3,1)).start();
        new Thread(new MyRunner("C",lock,c3,c1,2)).start();
    }

    static class MyRunner implements Runnable{
        private String name;
        private Lock lock;
        private Condition current;
        private Condition next;
        private int targetState;
        public MyRunner(String name,Lock lock, Condition current, Condition next,int targetState){
            this.lock = lock;
            this.name = name;
            this.current = current;
            this.next = next;
            this.targetState = targetState;
        }

        @Override
        public void run() {
            lock.lock();
            int i=10;
            try {
                while (i > 0) {

                    if (state % 3 == targetState) {
                        state++;
                        i--;
                        System.out.print(name);
                        next.signal();
                    } else {
                        try {
                            current.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }


}
