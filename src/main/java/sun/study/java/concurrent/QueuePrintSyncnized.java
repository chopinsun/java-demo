package sun.study.java.concurrent;

/**
 * @program: java-demo
 * @description: 顺序打印ABC
 * @author: chopin.sun
 * @create: 2019-07-16 11:02
 **/

public class QueuePrintSyncnized {

    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object self;
        private Object next;
        private ThreadPrinter(String name, Object self, Object next) {
            this.name = name;
            this.next = next;
            this.self = self;
        }
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (self) { // 先获取 prev 锁
                    synchronized (next) {// 再获取 self 锁
                        System.out.print(name);// 打印
                        count--;
                        next.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                    }
                    // 此时执行完self的同步块，这时self锁才释放。
                    try {
                        if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            self.notifyAll();
                        } else {
                            self.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", a, b);
        ThreadPrinter pb = new ThreadPrinter("B", b, c);
        ThreadPrinter pc = new ThreadPrinter("C", c, a);

        new Thread(pa).start();
//        Thread.sleep(100);// 保证初始ABC的启动顺序
        new Thread(pb).start();
//        Thread.sleep(100);
        new Thread(pc).start();
//        Thread.sleep(100);
    }
}
