package top.es425.demo;

/**
 * @author eddie
 * @version 1.0
 * @date 2020/8/6 15:36
 * @description 实现Runnable接口
 */
public class ThreadDemo02 implements Runnable{
    /**
     * 线程执行的方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        // Runnable方式仍然是借用Thread来实现的多线程
        ThreadDemo02 t1 = new ThreadDemo02();
        ThreadDemo02 t2 = new ThreadDemo02();
        // Thread(Runnable target)
        Thread th1 = new Thread(t1);
        th1.setName("T1");
        Thread th2 = new Thread(t2);
        th2.setName("T2");
        // 启动线程需要使用start()方法，但是Runnable没有提供start(),如何解决？
        // Thread有start()Runnable没有start()
        // Runnable->Thread
        th1.start();
        th2.start();
    }
}
