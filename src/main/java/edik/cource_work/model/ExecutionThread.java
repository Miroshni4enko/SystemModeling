package edik.cource_work.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
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
    private AtomicInteger executionQueue = new AtomicInteger(0);
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
        startArriveTimer();
        while (!stop.get()) {
            System.out.println(stop.get() + taskType.name());
            if (executionQueue.get() == 0) {
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
        for ( ; executionQueue.get() > 0; executionQueue.decrementAndGet()){
            int timeOfTask = taskType.getTaskTime();
            System.out.println("i = " + executionQueue +" taskType = "+ taskType.name() + "timeOfTask = " + timeOfTask);
            TimeUnit.SECONDS.sleep(timeOfTask);
            resultList.add(timeOfTask);
        }
        System.out.println("tttttttttt");
    }

    public void stop() {
        this.stop.set(true);
    }

    private void startArriveTimer(){
        Thread thread = new Thread(new ArriveTaskTimer());
        thread.setDaemon(true);
        thread.start();
    }

    private class ArriveTaskTimer extends TimerTask {
        public void run() {
            try {
                while (!stop.get()) {
                    if (amountOfTasks.get() == 0) {
                        Thread.currentThread().yield();
                    } else {
                        int timeArrive = taskType.getArriveTime();
                        System.out.println("i = " + amountOfTasks +" taskType = "+ taskType.name() + "timeArrive = " + timeArrive);
                        TimeUnit.SECONDS.sleep(timeArrive);
                        amountOfTasks.decrementAndGet();
                        executionQueue.incrementAndGet();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
