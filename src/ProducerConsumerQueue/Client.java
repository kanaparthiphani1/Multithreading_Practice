package ProducerConsumerQueue;

public class Client {
    public static void main(String[] args) {
        SharedResource s = new SharedResource(3);

        Thread t1 = new Thread(() ->{
            try{
                Thread.sleep(2000);
            }catch (Exception e){

            }
            for (int i = 0; i < 6; i++) {
                try {
                    s.addResource(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 6; i++) {
                s.consumeResource();
            }
        });

        t1.start();
        t2.start();
    }
}
