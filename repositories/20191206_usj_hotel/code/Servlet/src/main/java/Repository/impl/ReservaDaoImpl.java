package Repository.impl;

import java.time.LocalDate;
import java.util.List;

import Model.Reserva;

public interface ReservaDaoImpl {
    
    public void createReserva (Reserva _reserva); // Persist an reserva

    public List<Reserva> readReserva (LocalDate _date); // List by day

    public void updateReserva (Reserva _reserva); // Update the finalização to true

    // public void deleteReserva (Reserva _hospede);

    public List<Reserva> listReserva (LocalDate _date1, LocalDate _date2); // List by period
}