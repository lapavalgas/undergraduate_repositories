package ads.pkg2019.oop.estruturadedados.sistema;

import ads.pkg2019.oop.estruturadedados.gui.EstruturaDeDados;
import ads.pkg2019.oop.estruturadedados.gui.ListaBase;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Main {

    private static List<String> frutasLista;
    private static Queue<String> frutasFila;
    private static Stack<String> frutasPilha;

    public static void main(String[] args) {
//         Lista de frutas para o funcionamento do exercicio;
        Main.startLists();
//        System.out.println(Main.toStringFruits()); //Teste de funcionamento // passou!
        //Janela com a lista de frutas
        ListaBase listaBase = new ListaBase();
        listaBase.setVisible(true);
        //janela com as listas exemplos
        EstruturaDeDados estruturaDeDados = new EstruturaDeDados();
        estruturaDeDados.setVisible(true);
        JOptionPane.showMessageDialog(null, "Olá, "
                + "\n"
                + "\n cada uma das lista de pilha, fila e lista inicia com cinco elementos da lista de base de frutas"
                + "\n "
                + "\n cada tipo de lista tem seu próprio controle para testar suas funcionalidades."
                + "\n");
        JOptionPane.showMessageDialog(null, ""
                + "\n A pilha insere e retira os elementos no topo"
                + "\n"
                + "\n A Fila insere elementos no final e retira no topo"
                + "\n"
                + "\n A lista permite a manipulação dos elementos "
                + "\n e permite a retirada de qualquer elemento em qualquer posição"
                + "\n"
//                + "\n Lembre que um mesmo elemento não participará duas vezes da lista!"
//                + "\n"
                + "\n bom divertimento");
//        ends
    }

    public static void startLists() {
        // Lista de frutas para o funcionamento do exercicio;
        frutasLista = FruitsNinja.installFruitsList(frutasLista);
        frutasFila = FruitsNinja.installFruitsFila(frutasFila);
        frutasPilha = FruitsNinja.installFruitsPilha(frutasPilha);
    }

    public static List<String> getList() {
        return frutasLista;
    }

    public static Stack<String> getPilha() {
        return frutasPilha;
    }

    public static Queue<String> getFila() {
        return frutasFila;
    }

}
