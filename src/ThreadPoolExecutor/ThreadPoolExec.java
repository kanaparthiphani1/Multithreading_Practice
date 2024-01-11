package ThreadPoolExecutor;

import java.util.concurrent.*;

public class ThreadPoolExec {

    public static void main(String[] args) {
        ThreadPoolExecutor tpe =
                new ThreadPoolExecutor(2,
                        4,3, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),
                        new CustomThreadfactory(), new CustomRejectedExecutionHandler());

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            tpe.submit(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                System.out.println("Task"+ (finalI + 1) +" Completed by : "+ Thread.currentThread().getName());
            });
        }
    }


}

class CustomThreadfactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setDaemon(false);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setName("Cust_Fact_Thread");
        return th;
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected by ThreadPool ");
    }
}