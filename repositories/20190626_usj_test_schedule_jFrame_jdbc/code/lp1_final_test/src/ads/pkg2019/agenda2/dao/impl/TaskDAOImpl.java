package ads.pkg2019.agenda2.dao.impl;

import ads.pkg2019.agenda2.entity.Task;
import java.util.List;

public interface TaskDAOImpl {

    public boolean CREAT(Task task);

    public List<Task> READ(int fk_schedule); // this read all tasks records, because the system

    public boolean UPDATE(Task task);

    public boolean DELET(int pk_task);
    
    public boolean DELETAll(int fk_schedule);
}
