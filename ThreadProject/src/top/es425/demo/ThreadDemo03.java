package top.es425.demo;

/**
 * @author eddie
 * @version 1.0
 * @date 2020/8/6 15:36
 * @description Thread常见API以及礼让和强制执行
 */
public class ThreadDemo03 implements Runnable {
    /**
     * 线程执行的方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i==3){
                Thread.yield();
                System.out.println("线程礼让");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 线程th1:执行"Th1:数字"
        ThreadDemo03 t1 = new ThreadDemo03();
        Thread th1 = new Thread(t1, "T1");
        th1.start();
        ThreadDemo03 t2 = new ThreadDemo03();
        Thread th2 = new Thread(t2, "T2");
        th2.start();

        // 线程main:执行"main:数字"
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + ":" + i);
//            if (i == 3) {
//                // main线程正在执行时（共执行i=3），th1强制抢夺执行
////                    th1.join();
//                // 线程的礼让 :yield()，礼让仅仅是一种 尽可能事件，并不一定会100%执行
//                Thread.yield();
//            }
//        }
    }

}
