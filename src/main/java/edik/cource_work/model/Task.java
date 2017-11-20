package edik.cource_work.model;

/**
 * Created by Слава on 18.11.2017.
 */
public class Task {
    private String name;
    private int time;

    public Task(String name, int time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time, int diff) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }
}
