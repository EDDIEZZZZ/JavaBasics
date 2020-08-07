package top.es425.demo;

/**
 * @author eddie
 * @version 1.0
 * @date 2020/8/6 21:05
 * @description 线程练习：驾校练车
 */
public class ThreadDemo04 {
    public static void main(String[] args) {
        Thread vip = new Thread(new VipStudent());
        vip.setPriority(Thread.MAX_PRIORITY);
        vip.start();

        Thread normal = new Thread(new NormalStudent(vip));
        normal.setPriority(Thread.NORM_PRIORITY);
        normal.start();

    }
}

/**
 * 模拟VIP学员的线程
 */
class VipStudent implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":VIP学员在练车");
            // 模拟练车时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * 模拟普通学员的线程
 */
class NormalStudent implements Runnable {

    private Thread vip;

    public NormalStudent(Thread vip) {
        this.vip = vip;
    }

    ;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            // 判断是否是最后一个普通学员
            if (i == 19) {
                // 让给VIP先执行（在实现时：需要join()强制让VIP插队，保证概率问题）
                try {
                    vip.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i + ":普通学员在练车");
            // 模拟练车时间
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}