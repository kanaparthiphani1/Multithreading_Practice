package ProducerConsumerSIngleVariable;

public class SharedResource {
    boolean isAvailable = false;

    public synchronized void addResource() {

        isAvailable=true;
        System.out.println("Item added by thread : "+ Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeResource() {
        while (!isAvailable){
            try{
                System.out.println("Thread : "+Thread.currentThread().getName() +" is waiting");
                wait();
            }catch(Exception e){

            }
        }

        isAvailable = false;
        System.out.println("Consumer consumed by : "+Thread.currentThread().getName());
    }


}
