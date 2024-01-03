package MergeSortThreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Integer> ls = List.of(4,7,2,3,9,8);
        Future<List<Integer>> solF =  es.submit(new Sorter(ls,es));
        List<Integer> lis =solF.get();
        lis.stream().forEach((Integer e)-> System.out.println(e));

    }
}
