package com.agenda.sistema;

import com.agenda.dao.UserDao;
import com.agenda.entity.Evento;
import com.agenda.entity.User;
import com.agenda.gui.AgendaApp;
import com.agenda.gui.Login;
import java.util.List;

public class Sistema {

    private static User user;

    public static void main(String[] args) {

        Login login = new Login();
        login.setVisible(true);
    }

    //load user
    public static void setUser(String login) {
        UserDao userDao = new UserDao();
        User loadUser = new User();
        loadUser = userDao.loadUser(login);
        Sistema.user = loadUser; 
        Sistema.setAgenda();
        if (Sistema.user != null) {
            enter();
        }
    }
    
    //open app
    public static void enter() {
        AgendaApp agendaApp = new AgendaApp();
        agendaApp.setVisible(true);
    }
    
    //set agenda
    public static void setAgenda(){
        Sistema.user.setAndLoadAgenda(Sistema.user.getId_user()); 
    }

    //get user ID
    public static int getId() {
        return Sistema.user.getId_user();
    }
    
    //get user Login
    public static String getLogin() {
        return Sistema.user.getLogin();
    }
    
    //get user name
    public static String getName(){
        return Sistema.user.getNome();
    }
    
    //get user Agenda
    public static List<Evento> getAgenda(){
        return Sistema.user.getAgenda();
    }

}