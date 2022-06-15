package ads.pkg2019.agenda2.gui;

import ads.pkg2019.agenda2.dao.ScheduleDAO;
import ads.pkg2019.agenda2.dao.TaskDAO;
import ads.pkg2019.agenda2.dao.UserDAO;
import ads.pkg2019.agenda2.entity.Task;
import ads.pkg2019.agenda2.gui.models.TaskTM;
import ads.pkg2019.agenda2.sis.Sistema;

import java.text.SimpleDateFormat;

import java.sql.Date;

import java.time.LocalDate;

import javax.swing.JOptionPane;

/*
    App here
 */
public class Agenda extends javax.swing.JFrame {
    
    private String stateUser, stateScheduleTask; // start, select, edit, delet, new;
    private boolean emailc, passc; //USER : email-change, pass-change, the button edit controller
    private boolean taskc, taskEditClose; //SCHEDULE : task-change, the button edit controller
    private Task editedTask;
    private LocalDate date;
    
    public void ChangeStateUser(String state) {
        switch (state) {
            case "start":
                //USER START
                taskEditClose = false;
                txt_user_name.setText(Sistema.user.getName());
                txt_user_login.setText(Sistema.user.getLogin());
                txt_user_email.setText(Sistema.user.getEmail());
                txt_user_pass.setText("*****");
                //SCHEDULE START
                btn_agenda_new.setEnabled(false);
                btn_agenda_new.setText("Novo");
                btn_agenda_edit.setEnabled(false);
                btn_agenda_edit.setText("Editar");
                btn_agenda_delet.setEnabled(false);
                txt_agenda_data.setEnabled(false);
                txt_agenda_data.setText("  dd/MM/yyyy");
                tbl_agenda_tasks.setEnabled(false);
                txtArea_agenda_resume.setEnabled(false);
                tbl_agenda_tasks.setModel(new TaskTM());
                taskc = false;
                ChangeStateUser("nav");
                break;
            case "nav":
                //user-nav-schedule
                txt_user_email.setEnabled(false);
                txt_user_pass.setEnabled(false);
                btn_user_delet.setEnabled(false);
                btn_user_editScheduleName.setEnabled(false);
                btn_user_editEmail.setText("Editar");
                emailc = false;
                btn_user_editPass.setText("Editar");
                passc = false;
                //Schedule list
                tbl_user_agendas.setEnabled(true);
                tbl_user_agendas.setModel(Sistema.scheduleTableModel);
                break;
            case "select-schedule":
                //user-select-schedule
                txt_user_email.setEnabled(false);
                txt_user_pass.setEnabled(false);
                btn_user_editEmail.setText("Editar");
                emailc = false;
                btn_user_editPass.setText("Editar");
                passc = false;
                btn_user_delet.setEnabled(true);
                btn_user_editScheduleName.setEnabled(true);
                //Lista agendas
                tbl_user_agendas.setEnabled(true);
                tbl_user_agendas.setModel(Sistema.scheduleTableModel);
//                ChangeStateUser("nav");
                break;
            case "close-task":
                txt_user_name.setEnabled(false);
                txt_user_login.setEnabled(false);
                txt_user_email.setEnabled(false);
                txt_user_pass.setEnabled(false);
                btn_user_new.setEnabled(false);
                btn_user_editEmail.setEnabled(false);
                btn_user_editPass.setEnabled(false);
                btn_user_editScheduleName.setEnabled(false);
                btn_user_delet.setEnabled(false);
                tbl_user_agendas.setEnabled(false);
                break;
            case "open-task":
                txt_user_name.setEnabled(false);
                txt_user_login.setEnabled(false);
                txt_user_email.setEnabled(false);
                txt_user_pass.setEnabled(false);
                btn_user_new.setEnabled(true);
                btn_user_editEmail.setEnabled(true);
                btn_user_editPass.setEnabled(true);
                btn_user_editScheduleName.setEnabled(true);
                btn_user_delet.setEnabled(true);
                tbl_user_agendas.setEnabled(true);
                ChangeStateUser("select-schedule");
                break;
        }
    }
    
    public void ChangeStateScheduleTask(String state) {
        switch (state) {
            case "nav":
                btn_agenda_new.setEnabled(true);
                btn_agenda_edit.setEnabled(false);
                btn_agenda_edit.setText("Editar");
                btn_agenda_delet.setEnabled(false);
                btn_agenda_delet.setText("Deletar");
                txt_agenda_data.setText("");
                txt_agenda_data.setEnabled(false);
                txt_agenda_data.setText("  dd/MM/yyyy");
                tbl_agenda_tasks.setEnabled(true);
                txtArea_agenda_resume.setText("");
                txtArea_agenda_resume.setEnabled(false);
                break;
            case "select-task":
                btn_agenda_new.setEnabled(true);
                btn_agenda_edit.setEnabled(true);
                btn_agenda_delet.setEnabled(true);
                txt_agenda_data.setEnabled(false);
                
                String formatDate = "" + Sistema.taskTableModel.getTask(Sistema.taskCursor).getAlert();
                String formatedDate[] = formatDate.split("-");
                
                txt_agenda_data.setText(formatedDate[2] + "" + formatedDate[1] + "" + formatedDate[0]);
                txtArea_agenda_resume.setText(Sistema.taskTableModel.getTask(Sistema.taskCursor).getResume());
                tbl_agenda_tasks.setEnabled(true);
                txtArea_agenda_resume.setEnabled(false);
                break;
            case "edit-task":
                
                SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");
                Date date = Sistema.taskTableModel.getTask(Sistema.taskCursor).getAlert();
                
                btn_agenda_new.setEnabled(false);
                btn_agenda_edit.setEnabled(true);
                btn_agenda_edit.setText("OK");
                btn_agenda_delet.setEnabled(true);
                btn_agenda_delet.setText("Título");
                txt_agenda_data.setEnabled(true);
                if (date != null) {
                    txt_agenda_data.setText(parseDate.format(date));
                }
                tbl_agenda_tasks.setEnabled(false);
                tbl_agenda_tasks.setModel(Sistema.taskTableModel);
                txtArea_agenda_resume.setEnabled(true);
                break;
        }
    }

    //USER
    public void BTNChangeEmail() {
        if (!emailc) {
            ChangeStateUser("start");
            emailc = !emailc;
            btn_user_editEmail.setText("OK");
            txt_user_email.setEnabled(emailc);
        } else {
            ChangeEmail();
            emailc = !emailc;
            btn_user_editEmail.setText("Editar");
            txt_user_email.setEnabled(emailc);
        }
    }
    
    public void ChangeEmail() {
        Sistema.user.setEmail(txt_user_email.getText());
        UserDAO updateEmail = new UserDAO();
        updateEmail.UPDATEEmail(Sistema.user);
    }
    
    public void BTNChangePass() {
        if (!passc) {
            ChangeStateUser("start");
            passc = !passc;
            btn_user_editPass.setText("OK");
            txt_user_pass.setText("");
            txt_user_pass.setEnabled(passc);
        } else {
            if (txt_user_pass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você deve fornecer uma senha de 4 digitos!");
            } else {
                if (txt_user_pass.getText().length() >= 4) {
                    ChangePass();
                    txt_user_pass.setText("*****");
                    Sistema.user.setPass("*****");
                    passc = !passc;
                    btn_user_editPass.setText("Editar");
                    txt_user_pass.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        }
    }
    
    public void ChangePass() {
        UserDAO updatePass = new UserDAO();
        updatePass.UPDATEPass(
                Sistema.user.getPk_user(),
                txt_user_pass.getText());
    }
    
    public void NEWSchedule() {
        String scheduleName = JOptionPane.showInputDialog(null, "Digite um nome para sua nova agenda!");
        ScheduleDAO schedule = new ScheduleDAO();
        schedule.CREAT(Sistema.user.getPk_user(), scheduleName);
        Sistema.LOADSchedule(Sistema.user.getPk_user());
        tbl_user_agendas.setModel(Sistema.scheduleTableModel);
        ChangeStateUser("start");
    }
    
    public void SELECTSchedule() {
        if (!taskEditClose) {
            Sistema.LOADTasks(tbl_user_agendas.getSelectedRow());
            tbl_agenda_tasks.setModel(Sistema.taskTableModel);
            ChangeStateUser("select-schedule");
            ChangeStateScheduleTask("nav");
        }
    }
    
    public void UPDATEScheduleName() {
        ScheduleDAO update = new ScheduleDAO();
        String newName = JOptionPane.showInputDialog(null, "Digite um novo nome para a agenda!");
        Sistema.schedule.get(tbl_user_agendas.getSelectedRow()).setName(newName);
        update.UPDATE(Sistema.schedule.get(tbl_user_agendas.getSelectedRow()));
        Sistema.LOADSchedule(Sistema.user.getPk_user());
        tbl_user_agendas.setModel(Sistema.scheduleTableModel);
    }
    
    public void DELETSchedule() {
        ScheduleDAO schedule = new ScheduleDAO();
        schedule.DELET(Sistema.schedule.get(tbl_user_agendas.getSelectedRow()).getPk_schedule());
        Sistema.schedule.remove(tbl_user_agendas.getSelectedRow());
        Sistema.LOADSchedule(Sistema.user.getPk_user());
        Sistema.taskTableModel = new TaskTM();
        Sistema.UPDATEScheduleIndex();
        tbl_user_agendas.setModel(Sistema.scheduleTableModel);
        ChangeStateUser("start");
    }

    /*
    
        SCHEDULE
    
     */
    //AGENDA
    public void NEWTask() {
//        Sistema.schedule.size() <= 0 && 
//        ChangeStateScheduleTask("nav");
        if (Sistema.scheduleCursor == -1) {
            JOptionPane.showMessageDialog(null, "Você precisa selecionar uma agenda!");
        } else {
            String title = JOptionPane.showInputDialog(null, "Digite o nome da tarefa... \n\n");
            TaskDAO newTask = new TaskDAO();
            Task task = new Task(title);
            newTask.CREAT(task);
            Sistema.GETNewTaskIndex();
            ChangeStateUser("close");
            taskEditClose = true;
            JOptionPane.showMessageDialog(null, "Edite a tarefa conforme a necessidade!"
                    + "\n"
                    + "\n Por fim finalize no botão: OK! "
                    + "\n");
            EDITTask();
        }
    }
    
    public void SELECTask() {
        if (!taskEditClose) {
            Sistema.GETTaskIndex(tbl_agenda_tasks.getSelectedRow());
            tbl_agenda_tasks.setModel(Sistema.taskTableModel);
            ChangeStateScheduleTask("select-task");
        }
    }
    
    public void FinishEDITTask() {
        if (date != null) {
            Sistema.taskTableModel.getTask(Sistema.taskCursor).setAlert(Date.valueOf(date));
        }
        Sistema.taskTableModel.getTask(Sistema.taskCursor).setResume(txtArea_agenda_resume.getText());
        TaskDAO task = new TaskDAO();
        task.UPDATE(Sistema.taskTableModel.getTask(Sistema.taskCursor));
    }
    
    public void EDITTaskDate() {
        System.out.println(txt_agenda_data.getText());
        String data[] = txt_agenda_data.getText().split("/");
        date = LocalDate.of(
                Integer.parseInt(data[2]),
                Integer.parseInt(data[1]),
                Integer.parseInt(data[0]));
    }
    
    public void EDITTask() {
        if (!taskc) {
            ChangeStateUser("close-task");
            ChangeStateScheduleTask("edit-task");
            taskEditClose = true;
            taskc = !taskc;
        } else {
            FinishEDITTask();
            ChangeStateUser("open-task");
            ChangeStateScheduleTask("nav");
            taskEditClose = false;
            taskc = !taskc;
        }
    }
    
    public void DELETTaskTitle() {
        if (btn_agenda_delet.getText().equals("Título")) {
            String newTitle = JOptionPane.showInputDialog(null, "Digite o título desejado... \n\n");
            Sistema.taskTableModel.getTask(Sistema.taskCursor).setTitle(newTitle);
            tbl_agenda_tasks.updateUI();
        } else if ((btn_agenda_delet.getText().equals("Deletar"))) {
            TaskDAO task = new TaskDAO();
            task.DELET(Sistema.taskTableModel.getTask(Sistema.taskCursor).getPk_task());
            Sistema.RELOADTasks();
            tbl_agenda_tasks.setModel(Sistema.taskTableModel);
            
        }
    }
    
    public Agenda() {
        initComponents();

        //System
        Sistema.LOADSchedule(Sistema.user.getPk_user());
        Sistema.taskTableModel = new TaskTM();

        //Agenda App
        ChangeStateUser("start");
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btn_user_editEmail = new javax.swing.JButton();
        txt_user_name = new javax.swing.JTextField();
        txt_user_login = new javax.swing.JTextField();
        txt_user_email = new javax.swing.JTextField();
        btn_user_editPass = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_user_agendas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btn_user_new = new javax.swing.JButton();
        btn_user_delet = new javax.swing.JButton();
        txt_user_pass = new javax.swing.JPasswordField();
        btn_user_editScheduleName = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btn_agenda_delet = new javax.swing.JButton();
        btn_agenda_edit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_agenda_tasks = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtArea_agenda_resume = new javax.swing.JTextArea();
        btn_agenda_new = new javax.swing.JButton();
        txt_agenda_data = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        btn_user_editEmail.setText("Editar");
        btn_user_editEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_editEmailActionPerformed(evt);
            }
        });

        txt_user_name.setText("Nome ");

        txt_user_login.setText("Login");

        txt_user_email.setText("E-mail");

        btn_user_editPass.setText("Editar");
        btn_user_editPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_editPassActionPerformed(evt);
            }
        });

        tbl_user_agendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Título"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_user_agendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_user_agendasMouseClicked(evt);
            }
        });
        tbl_user_agendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_user_agendasKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_user_agendas);

        jLabel1.setText("Agendas");

        btn_user_new.setText("Nova agenda");
        btn_user_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_newActionPerformed(evt);
            }
        });

        btn_user_delet.setText("Deletar");
        btn_user_delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_deletActionPerformed(evt);
            }
        });

        txt_user_pass.setText("jPasswordField1");

        btn_user_editScheduleName.setText("Editar");
        btn_user_editScheduleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_editScheduleNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(txt_user_name)
                    .addComponent(txt_user_login)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_user_email)
                            .addComponent(txt_user_pass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_user_editEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_user_editPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(btn_user_new))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_user_editScheduleName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_user_delet, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_user_login, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_user_email, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_user_editEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_user_editPass)
                    .addComponent(txt_user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_user_new))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_user_delet)
                    .addComponent(btn_user_editScheduleName))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuário", jPanel1);

        btn_agenda_delet.setText("Deletar");
        btn_agenda_delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda_deletActionPerformed(evt);
            }
        });

        btn_agenda_edit.setText("Editar");
        btn_agenda_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda_editActionPerformed(evt);
            }
        });

        tbl_agenda_tasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tarefas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_agenda_tasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_agenda_tasksMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_agenda_tasks);

        txtArea_agenda_resume.setColumns(20);
        txtArea_agenda_resume.setRows(5);
        jScrollPane4.setViewportView(txtArea_agenda_resume);

        btn_agenda_new.setText("Novo");
        btn_agenda_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda_newActionPerformed(evt);
            }
        });

        try {
            txt_agenda_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_agenda_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_agenda_dataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_agenda_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_agenda_delet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_agenda_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_agenda_data, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_agenda_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_agenda_delet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_agenda_new, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_agenda_data, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Agenda", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2)
                    .addComponent(jTabbedPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agenda_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda_newActionPerformed
        NEWTask();
    }//GEN-LAST:event_btn_agenda_newActionPerformed

    private void tbl_agenda_tasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_agenda_tasksMouseClicked
        SELECTask();
    }//GEN-LAST:event_tbl_agenda_tasksMouseClicked

    private void btn_agenda_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda_editActionPerformed
        EDITTask();
    }//GEN-LAST:event_btn_agenda_editActionPerformed

    private void btn_agenda_deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda_deletActionPerformed
        DELETTaskTitle();
    }//GEN-LAST:event_btn_agenda_deletActionPerformed

    private void tbl_user_agendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_agendasMouseClicked
        SELECTSchedule();
    }//GEN-LAST:event_tbl_user_agendasMouseClicked

    private void btn_user_editEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_editEmailActionPerformed
        BTNChangeEmail();
    }//GEN-LAST:event_btn_user_editEmailActionPerformed

    private void btn_user_editPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_editPassActionPerformed
        BTNChangePass();
    }//GEN-LAST:event_btn_user_editPassActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        ChangeStateUser("start");
    }//GEN-LAST:event_formMouseClicked

    private void tbl_user_agendasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_user_agendasKeyReleased
        SELECTSchedule();
    }//GEN-LAST:event_tbl_user_agendasKeyReleased

    private void btn_user_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_newActionPerformed
        NEWSchedule();
    }//GEN-LAST:event_btn_user_newActionPerformed

    private void btn_user_deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_deletActionPerformed
        DELETSchedule();
    }//GEN-LAST:event_btn_user_deletActionPerformed

    private void btn_user_editScheduleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_editScheduleNameActionPerformed
        UPDATEScheduleName();
    }//GEN-LAST:event_btn_user_editScheduleNameActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        ChangeStateUser("start");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void txt_agenda_dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_agenda_dataKeyReleased
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (txt_agenda_data.getText().trim().length() == 10) {
            String data[] = txt_agenda_data.getText().split("/");
            if (Integer.parseInt(data[0]) <= 31) {
                if (Integer.parseInt(data[1]) <= 12) {
                    if (Integer.parseInt(data[2]) >= 2019 && Integer.parseInt(data[1]) <= 2021) {
                        EDITTaskDate();
                    }
                }
            }
        }
    }//GEN-LAST:event_txt_agenda_dataKeyReleased
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda_delet;
    private javax.swing.JButton btn_agenda_edit;
    private javax.swing.JButton btn_agenda_new;
    private javax.swing.JButton btn_user_delet;
    private javax.swing.JButton btn_user_editEmail;
    private javax.swing.JButton btn_user_editPass;
    private javax.swing.JButton btn_user_editScheduleName;
    private javax.swing.JButton btn_user_new;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tbl_agenda_tasks;
    private javax.swing.JTable tbl_user_agendas;
    private javax.swing.JTextArea txtArea_agenda_resume;
    private javax.swing.JFormattedTextField txt_agenda_data;
    private javax.swing.JTextField txt_user_email;
    private javax.swing.JTextField txt_user_login;
    private javax.swing.JTextField txt_user_name;
    private javax.swing.JPasswordField txt_user_pass;
    // End of variables declaration//GEN-END:variables
}
