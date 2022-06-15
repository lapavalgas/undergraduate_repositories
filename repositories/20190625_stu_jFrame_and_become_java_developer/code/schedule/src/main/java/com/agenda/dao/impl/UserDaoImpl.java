
package com.agenda.dao.impl;

import com.agenda.entity.User;
import com.agenda.entity.Evento;
import java.util.List;

public interface UserDaoImpl {
    //cadastro
    public boolean verificarLogin(String login);
    public boolean verificarPass(String pass);
    public boolean cadastrarUser(User user);
    //alterar #futuro
    public boolean atualizarUser(String login); //nome, email, login, senha
    public boolean deletarUser(String login);
    //carregar agenda/eventos
    public User loadUser(String login);
    public List<Evento> loadAgenda(int id_user);
    //
}
