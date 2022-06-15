package com.agenda.entity;

import com.agenda.dao.UserDao;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id_user;
    private String nome, email, login, pass;
    protected List<Evento> agenda;
    
    public User(){
        
    }
    
    //construtor para cadastro de novos usuário
    public void cadastroUser(String nome, String email, String login, String pass){
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.pass = pass;
    }
    
    public void carregaUser(int id_user, String nome, String email, String login, String pass) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.pass = pass;
    }    

    public void setAndLoadAgenda(int id_user) {
        UserDao userDao = new UserDao();
        this.agenda = userDao.loadAgenda(id_user);
    }
    
    public List<Evento> getAgenda(){
        return agenda;
    }
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String toString(){
        return getNome();
    }

}
