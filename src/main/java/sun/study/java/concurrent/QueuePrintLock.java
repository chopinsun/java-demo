package sun.study.java.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java-demo
 * @description:
 * @author: chopin.sun
 * @create: 2019-07-17 10:36
 **/

public class QueuePrintLock {
    static class MyRunner implements Runnable{
        private Lock lock;
        private Condition prev;
        private Condition current;
        private String name;
        public MyRunner(String name, Lock lock, Condition prev, Condition current){
            this.name = name;
            this.lock = lock;
            this.prev = prev;
            this.current = current;
        }
        @Override
        public void run() {
            lock.lock();
            int count=10;
            while(count>0){
                System.out.print(name);
                count--;
                current.signalAll();
                try {
                    if (count == 0) {
                        prev.signalAll();
                    } else {
                        prev.await();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        new Thread(new MyRunner("A",lock,c3,c1)).start();
        new Thread(new MyRunner("B",lock,c1,c2)).start();
        new Thread(new MyRunner("C",lock,c2,c3)).start();
    }
}
