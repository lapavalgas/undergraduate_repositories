package sistema;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import dao.ProdutoDAO;
import entity.Produto;
import gui.ListaDeCompras;

public class Sistema {

    public static List<Produto> listaDeCompras;

    public static void main(String[] args) {

        LOAD();
        ListaDeCompras gui = new ListaDeCompras();
        gui.setVisible(true);
    }

    public static void LOAD() {
        ProdutoDAO load = new ProdutoDAO();
        List<Produto> listaDeCompras;
        Sistema.listaDeCompras = load.CARREGAR();
    }
}