package MergeSortThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    ExecutorService es;
    List<Integer> nums;
    Sorter(List<Integer> nums, ExecutorService es){
        this.nums = nums;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(nums.size() <= 1){
            return nums;
        }
        int size = nums.size();

        int mid = size/ 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i =0 ; i < mid; ++i){
            left.add(nums.get(i));
        }

        for(int i = mid ; i < size; ++i){
            right.add(nums.get(i));
        }

        Future<List<Integer>> sortedLeft = es.submit(new Sorter(left,es));
        Future<List<Integer>> sortedRight = es.submit(new Sorter(right,es));

        List<Integer> sortedLeftArray = sortedLeft.get();
        List<Integer> sortedRightArray = sortedRight.get();

        int i= 0;
        int j = 0;

        List<Integer> sortedArray = new ArrayList<>();

        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i += 1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }

        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }

        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }

        return sortedArray;
    }
}
