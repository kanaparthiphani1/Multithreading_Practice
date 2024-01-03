package ProducerConsumerSemaphores;

import java.util.Vector;

public class SharedResource {
    private Vector<Object> vec;
    private int maxsize;
    SharedResource(int size){
        this.vec = new Vector<>();
        this.maxsize = size;
    }

    public void addResource() {
        this.vec.add(new Object());
        System.out.println("Producer production time, current size " + this.vec.size());
    }

    public void consumeResource() {
        this.vec.remove(0);
        System.out.println("Consumer consumption time, current size " + this.vec.size());
    }


}
