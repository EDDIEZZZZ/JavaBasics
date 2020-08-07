package top.es425.demo;

/**
 * @author eddie
 * @version 1.0
 * @date 2020/8/6 15:20
 * @description 线程demo01
 */
public class ThreadDemo01 extends Thread {
    /**
     * 线程的执行方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo01 t1 = new ThreadDemo01();
        t1.setName("t1");
        ThreadDemo01 t2 = new ThreadDemo01();
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
