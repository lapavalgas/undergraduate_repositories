package ads.pkg2019.agenda2.entity;

import java.util.List;

public class Schedule {
    
    int pk_schedule, fk_user;
    String name;
    List<Task> tasks;
    
    public Schedule(int fk_user, String name){
        this.fk_user=fk_user;
        this.name=name;
    }

    public Schedule(int pk_schedule, int fk_user, String name) {
        this.pk_schedule=pk_schedule;
        this.fk_user=fk_user;
        this.name=name;  
    }

    public int getPk_schedule() {
        return pk_schedule;
    }

    public void setPk_schedule(int pk_schedule) {
        this.pk_schedule = pk_schedule;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
}
