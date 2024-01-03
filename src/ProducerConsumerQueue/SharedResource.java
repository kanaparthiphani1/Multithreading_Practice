package ProducerConsumerQueue;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    Queue<Integer> qu;
    int maxsize;
    SharedResource(int size){
        this.qu = new LinkedList<>();
        this.maxsize = size;
    }

    public synchronized void addResource(int i) throws InterruptedException {

        while (this.qu.size() == this.maxsize){
            System.out.println("Buffer is full, Producer is waiting");
            wait();
        }
        System.out.println("Produced : "+ i);
        qu.offer(i);
        notifyAll();
    }

    public synchronized void consumeResource() {
        while (qu.isEmpty()){
            try{
                System.out.println("Thread : "+Thread.currentThread().getName() +" is waiting");
                wait();
            }catch(Exception e){

            }
        }

        int i = qu.poll();
        System.out.println("Consumed : "+i);
        notifyAll();
    }


}
