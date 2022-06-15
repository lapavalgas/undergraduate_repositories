
package com.agenda.dao.impl;

import com.agenda.entity.Evento;

public interface EventoDaoImpl {
    public boolean createEvent(Evento evento, int id_user);
    public boolean editEvent(Evento evento);
    public boolean deleteEvent(int id);
}
