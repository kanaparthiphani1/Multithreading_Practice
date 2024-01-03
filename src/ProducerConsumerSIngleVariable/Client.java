package ProducerConsumerSIngleVariable;

public class Client {
    public static void main(String[] args) {
        SharedResource s = new SharedResource();

        Thread t1 = new Thread(() ->{
            try{
                Thread.sleep(2000);
            }catch (Exception e){

            }
            s.addResource();
        });

        Thread t2 = new Thread(()->{
            s.consumeResource();
        });

        t1.start();
        t2.start();
    }
}
