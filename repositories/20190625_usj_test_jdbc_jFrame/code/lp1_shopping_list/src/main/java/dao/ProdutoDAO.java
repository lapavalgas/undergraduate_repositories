package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.jdbc.Conexao;
import entity.Produto;

public class ProdutoDAO {
    //cadastro
    public void CADASTRAR(Produto produto) {
        try {
            Connection connection = Conexao.getConnection();
            String sql = "INSERT INTO lista_3 (nome) values (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.execute();
            
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //load_lista
    public List<Produto> CARREGAR() {
        List<Produto> lista = null;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "SELECT * FROM lista_3";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            lista = new ArrayList();
            while (resultset.next()) {
                Produto produto = new Produto(
                        resultset.getInt("id"),
                        resultset.getString("nome"));
                lista.add(produto);
            }
            statement.close();
            resultset.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
