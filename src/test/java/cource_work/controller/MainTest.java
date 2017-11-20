package cource_work.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Слава on 19.11.2017.
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        for (int i = atomicInteger.get(); i > 0; atomicInteger.getAndDecrement()){
            System.out.println(i +" i");
            System.out.println(atomicInteger.get());
            //System.out.println(taskType.name());
            //int timeOfTask = taskType.getTime();
            //System.out.println(timeOfTask);
         //   TimeUnit.SECONDS.sleep(atomicInteger.get());
          //  resultList.add(timeOfTask);
        }
        System.out.println("tttttttttt");
    }
}
