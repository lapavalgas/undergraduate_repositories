package ads.pkg2019.agenda2.dao.impl;

import ads.pkg2019.agenda2.entity.Schedule;

import java.util.List;

public interface ScheduleDAOImpl {

    public boolean CREAT(int fk_user, String name);

    public List<Schedule> READ(int pk_user);

    public boolean UPDATE(Schedule schedule);

    public boolean DELET(int pk_schedule);
}
