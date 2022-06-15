package ads.pkg2019.agenda2.entity;

import ads.pkg2019.agenda2.sis.Sistema;
import java.sql.Date;

public class Task {

    int pk_task, fk_schedule;
    String title, resume;
    Date creat_time, alert;

    public Task(String title) {
        this.title = title;
        this.fk_schedule = Sistema.schedule.get(Sistema.scheduleCursor).getPk_schedule();
    }

    public Task(int pk_task, int fk_schedule, String title, String resume, Date alert) {
        this.pk_task = pk_task;
        this.fk_schedule = fk_schedule;
        this.title = title;
        this.resume = resume;
        this.alert = alert;
    }

    public Task(int pk_task, int fk_schedule, String title, String resume, Date alert, Date creat_time) {
        this.pk_task = pk_task;
        this.fk_schedule = fk_schedule;
        this.title = title;
        this.resume = resume;
        this.alert = alert;
        this.creat_time = creat_time;
    }

    public int getPk_task() {
        return pk_task;
    }

    public void setPk_task(int pk_task) {
        this.pk_task = pk_task;
    }

    public int getFk_schedule() {
        return fk_schedule;
    }

    public void setFk_schedule(int fk_schedule) {
        this.fk_schedule = fk_schedule;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getAlert() {
        return alert;
    }

    public void setAlert(Date alert) {
        this.alert = alert;
    }

    public Date getCreatTime() {
        return creat_time;
    }

    public void setCreatTime(Date creatTime) {
        this.creat_time = creatTime;
    }

}
