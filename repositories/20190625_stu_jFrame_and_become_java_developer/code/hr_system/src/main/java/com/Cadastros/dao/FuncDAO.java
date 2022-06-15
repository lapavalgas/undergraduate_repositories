package com.Cadastros.dao;

import com.Cadastros.dao.DepDAO;
import com.Cadastros.dao.jdbc.Conexao;
import com.Cadastros.entity.Departamento;
import com.Cadastros.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncDAO {

    //C
    public boolean INSERT(Funcionario func) {
        boolean insert = false;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "INSERT INTO func (matricula, nome, departamento) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, func.getMatricula());
            statement.setString(2, func.getNome());
            statement.setInt(3, func.getDepartamento().getCodigo()); //Olha aqui: O Funcionario tem um objeto do tipo Departamento e este tem um atributo/função parao código
            insert = statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao cadastrar funcionario!" + ex);
        }
        return insert;
    }

    //R
    public List<Funcionario> LOAD() {
        List<Funcionario> lista = null;
        try {
            lista = new ArrayList<Funcionario>();
            Connection connection = Conexao.getConnection();
            String sql = "SELECT * FROM func";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            Funcionario func;
            while (resultset.next()) {
                
                func = new Funcionario();
                
                Departamento dep = new Departamento();  // como funcionário tem um objeto departamento, preciso carregar
                DepDAO depDao = new DepDAO();           // e então abre outra conexão no banco de dados; 
                dep.setCodigo(resultset.getInt("departamento"));
                dep.setNome(depDao.LOADNome(resultset.getInt("departamento")));
                
                func.setMatricula(resultset.getInt("matricula"));
                func.setNome(resultset.getString("nome"));
                
                func.setDepartamento(dep);
                
                lista.add(func);
            }
            resultset.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return lista;
    }

    //U
    public boolean UPDATE(Funcionario func) {
        boolean insert = false;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "UPDATE func SET nome = ? , departamento = ? WHERE matricula = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, func.getNome());
            statement.setInt(2, func.getDepartamento().getCodigo());
            statement.setInt(3, func.getMatricula());
            insert = statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return insert;
    }

    //D
    public boolean DELETE(Funcionario func) {
        boolean insert = false;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "DELETE FROM func WHERE matricula = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, func.getMatricula());
            insert = statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar eventos!" + ex);
        }
        return insert;
    }
}
