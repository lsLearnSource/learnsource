/**
 * Created by liangsheng on 2017/7/9.
 */
public class TestThread extends Thread {

    //private int i = 1;
    private volatile int i = 1;

    @Override
    public void run() {
        System.out.println("thread is run");
        while (i > 0) {

        }
        System.out.println("thread is stop");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        try {
            TestThread thread = new TestThread();
            thread.start();
            Thread.sleep(1000);
            thread.setI(0);
            System.out.println("set i =0");
            Thread.sleep(1000);
            System.out.println(thread.getI());
        } catch (Exception e) {

        }

    }

}
