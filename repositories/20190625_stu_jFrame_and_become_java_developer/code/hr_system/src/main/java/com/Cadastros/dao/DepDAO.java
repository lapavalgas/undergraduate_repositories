package com.Cadastros.dao;

import com.Cadastros.dao.jdbc.Conexao;
import com.Cadastros.entity.Departamento;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepDAO {

    //C
    public boolean INSERT(Departamento dep) {
        boolean insert = false;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "INSERT INTO dep (codigo, nome) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dep.getCodigo());
            statement.setString(2, dep.getNome());
            insert = statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return insert;
    }

    //R
    public List<Departamento> LOAD() {
        List<Departamento> lista = null;
        try {
            lista = new ArrayList<Departamento>();
            Connection connection = Conexao.getConnection();
            String sql = "SELECT * FROM dep";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            Departamento dep;
            while (resultset.next()) {
                dep = new Departamento();
                dep.setCodigo(resultset.getInt("codigo"));
                dep.setNome(resultset.getString("nome"));
                lista.add(dep);
            }
            resultset.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return lista;
    }

    public String LOADNome(int cod) {
        String nome = "";
        try {
            Connection connection = Conexao.getConnection();
            String sql = "SELECT * FROM dep WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cod);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                nome = (resultset.getString("nome"));
            }
            resultset.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return nome;
    }

    //U
    public boolean UPDATE(Departamento dep) {
        boolean insert = false;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "UPDATE dep SET nome = ? WHERE codigo = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dep.getNome());
            statement.setInt(2, dep.getCodigo());
            insert = statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return insert;
    }

    //D
    public boolean DELETE(Departamento dep) {
        boolean insert = false;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "DELETE FROM dep WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dep.getCodigo());
            insert = statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return insert;
    }
}
