import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liangsheng on 2017/7/12.
 */
public class MyQuery<E> {
    private List<E> list = new LinkedList<E>();

    private AtomicInteger queryCount = new AtomicInteger(0);

    private final Object lock = new Object();

    private int minSize = 0;

    private int maxSize;



    public MyQuery(int maxSize) {
        this.maxSize = maxSize;
    }

    public int size(){
        return queryCount.get();
    }
    public void put(E element){
        synchronized(lock){
        if(queryCount.get()==maxSize){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(element);
        System.out.println("add Element :" +element);
        queryCount.incrementAndGet();
        lock.notify();
        }
    }

    public E tack(){
        E element =null;
        synchronized(lock){
        if (queryCount.get()==minSize){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        element=list.remove(0);
            System.out.println("tack element :"+element);
        queryCount.decrementAndGet();
        lock.notify();
    }
    return element;
    }

    public static void main(String[] args) throws InterruptedException {
        final MyQuery<String> mq=new MyQuery<String>(15);
        mq.put("a");
        mq.put("b");
        mq.put("c");
        mq.put("d");
        mq.put("e");
        mq.put("f");
        mq.put("g");
        mq.put("h");
        mq.put("i");
        mq.put("g");
        mq.put("k");
        mq.put("l");
        mq.put("m");
        mq.put("n");
        mq.put("o");

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                mq.put("p");
                mq.put("q");
            }
        },"t1");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                mq.tack();
                mq.tack();
            }
        },"t2");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
