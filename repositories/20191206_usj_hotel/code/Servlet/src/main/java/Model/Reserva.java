package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.*;

@Data
public class Reserva {

    private int id_Reserva;
    private String hospede_cpf;
    private int quarto;
    private LocalDate dataDia;
    private Double preco;
    private boolean finalizacao;
    private Hospede hospede;

    public Reserva(int id_Reserva, String hospede_cpf, int quarto, LocalDate dataDia, Double preco, boolean finalizacao) {
        this.id_Reserva = id_Reserva;
        this.hospede_cpf = hospede_cpf;
        this.quarto = quarto;
        this.dataDia = dataDia;
        this.preco = preco;
        this.finalizacao = finalizacao;
    }

    public Reserva(String hospede_cpf, String quarto, String dataDia, String preco) {
        System.out.println(hospede_cpf +" | "+ quarto +" | "+ dataDia +" | "+ preco);
        this.hospede_cpf = hospede_cpf;
        this.quarto = Integer.parseInt(quarto);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dataDia = LocalDate.parse(dataDia, format);
        this.preco = Double.parseDouble(preco);
    }

}