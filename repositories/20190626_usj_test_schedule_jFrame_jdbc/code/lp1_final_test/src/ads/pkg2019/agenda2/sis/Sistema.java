package ads.pkg2019.agenda2.sis;

import ads.pkg2019.agenda2.dao.AuthenticationDAO;
import ads.pkg2019.agenda2.dao.ScheduleDAO;
import ads.pkg2019.agenda2.dao.TaskDAO;
import ads.pkg2019.agenda2.dao.UserDAO;
import ads.pkg2019.agenda2.entity.Authentication;
import ads.pkg2019.agenda2.entity.Schedule;
import ads.pkg2019.agenda2.entity.Task;
import ads.pkg2019.agenda2.entity.User;
import ads.pkg2019.agenda2.gui.Login;
import ads.pkg2019.agenda2.gui.models.ScheduleTM;
import ads.pkg2019.agenda2.gui.models.TaskTM;
import java.util.List;

public class Sistema {

    public static User user;
    public static List<Schedule> schedule;
    public static ScheduleTM scheduleTableModel;
    public static int scheduleCursor;
    public static TaskTM taskTableModel;
    public static int taskCursor;

    public static void main(String[] args) {
        Login loginGUI = new Login();
        loginGUI.setVisible(true);
    }

    public static boolean LOGIN(Authentication authentication) {
        boolean validity = false;
        AuthenticationDAO login = new AuthenticationDAO();
        UserDAO loadUser = new UserDAO();
        Sistema.user = loadUser.READ(login.AUTH(authentication));
        authentication = null;
        if (Sistema.user instanceof User) {
            validity = true;
        } else if (Sistema.user == null) {
            validity = false;
        } else {
            validity = false;
        }
        return validity;
    }

    public static void LOADSchedule(int fk_user) {
        Sistema.scheduleTableModel = new ScheduleTM();
        ScheduleDAO schedules = new ScheduleDAO();
        Sistema.schedule = schedules.READ(fk_user);
        if (Sistema.schedule.isEmpty()) {
            Sistema.scheduleTableModel = new ScheduleTM();
        } else if (!Sistema.schedule.isEmpty()) {
            for (Schedule schedule : Sistema.schedule) {
                Sistema.scheduleTableModel.addSchedule(schedule);
            }
        }
    }

    //in the load schedule context
    public static void LOADTasks(int selectedRow) { //agenda position
        scheduleCursor = selectedRow;
        Sistema.taskTableModel = new TaskTM();
        TaskDAO tasks = new TaskDAO();
        Sistema.schedule.get(scheduleCursor)
                .setTasks(tasks.READ(
                        Sistema.schedule.get(scheduleCursor).getPk_schedule()));
        if (Sistema.schedule.get(scheduleCursor).getTasks().isEmpty()) {
            Sistema.taskTableModel = new TaskTM();
        } else if (!Sistema.schedule.get(scheduleCursor).getTasks().isEmpty()) {
            for (Task task : Sistema.schedule.get(scheduleCursor).getTasks()) {
                Sistema.taskTableModel.addTask(task);
            }
        }
    }

    //in editng tasks context
    public static void RELOADTasks() {
        Sistema.taskTableModel = new TaskTM();
        TaskDAO tasks = new TaskDAO();
        Sistema.schedule.get(scheduleCursor)
                .setTasks(tasks.READ(
                        Sistema.schedule.get(scheduleCursor).getPk_schedule()));
        if (Sistema.schedule.get(scheduleCursor).getTasks().isEmpty()) {
            Sistema.taskTableModel = new TaskTM();
        } else if (!Sistema.schedule.get(scheduleCursor).getTasks().isEmpty()) {
            for (Task task : Sistema.schedule.get(scheduleCursor).getTasks()) {
                Sistema.taskTableModel.addTask(task);
            }
        }
    }

    public static void UPDATEScheduleIndex() {
        Sistema.scheduleCursor = -1;
    }

    public static void RELOADTaskIndex() {
        Sistema.taskCursor = -1;
    }

    public static void GETNewTaskIndex() {
        RELOADTasks();
        Sistema.taskCursor = Sistema.taskTableModel.getRowCount()-1;
    }
    
    public static void GETTaskIndex(int selectedRow){
        Sistema.taskCursor=selectedRow;
    }
}
