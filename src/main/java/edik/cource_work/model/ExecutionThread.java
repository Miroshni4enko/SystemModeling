package edik.cource_work.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Слава on 18.11.2017.
 */
public class ExecutionThread implements Callable<List<Integer>> {
    private AtomicInteger amountOfTasks = new AtomicInteger();
    private AtomicBoolean stop = new AtomicBoolean();
    private final int amountOfNeededPermit;
    private Semaphore semaphore;
    private TaskType taskType;

    public ExecutionThread(Semaphore semaphore, int amountOfNeededPermit, int amountOfTasks, TaskType taskType) {
        this.semaphore = semaphore;
        this.amountOfNeededPermit = amountOfNeededPermit;
        this.amountOfTasks.set(amountOfTasks);
        this.taskType = taskType;
    }

    public void addTasksToQueue(int amountOfTasks) {
        this.amountOfTasks.addAndGet(amountOfTasks);
    }

    public List<Integer> call() throws InterruptedException {

        List<Integer> resultList = new ArrayList<Integer>();
            while (!stop.get()) {
                System.out.println(stop.get() + taskType.name());
                if (amountOfTasks.get() == 0) {
                    Thread.currentThread().yield();
                } else {
                    semaphore.acquire(amountOfNeededPermit);
                    executeTasks(resultList);
                    semaphore.release(amountOfNeededPermit);
                }
            }

            return resultList;

    }

    private void executeTasks(List<Integer> resultList) throws InterruptedException {
        for ( ; amountOfTasks.get() > 0; amountOfTasks.decrementAndGet()){
            int timeOfTask = taskType.getTime();
            System.out.println("i = " + amountOfTasks +" taskType = "+ taskType.name() + "timeOfTask = " + timeOfTask);
            TimeUnit.SECONDS.sleep(timeOfTask);
            resultList.add(timeOfTask);
        }
        System.out.println("tttttttttt");
    }

    public void stop() {
        this.stop.set(true);
    }
}
