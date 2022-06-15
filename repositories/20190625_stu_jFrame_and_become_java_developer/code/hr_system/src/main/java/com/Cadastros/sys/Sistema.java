
package com.Cadastros.sys;

import com.Cadastros.gui.CadastrosGUI;
import com.Cadastros.entity.Departamento;
import com.Cadastros.entity.Funcionario;
import com.Cadastros.dao.DepDAO;
import com.Cadastros.dao.FuncDAO;
import java.util.List;

public class Sistema {
    
    
    //Listas do sistema
    public static List<Funcionario> ListaFunc;
    public static List<Departamento> ListaDep;
    
    //função carrega listas
    public static void LOADSYS(){
        FuncDAO funcDao = new FuncDAO();
        ListaFunc = funcDao.LOAD();
        DepDAO depDao = new DepDAO();
        ListaDep = depDao.LOAD();
    }
    
    //start sistema
    public static void main(String[] args) {
//        LOADSYS();
        
        CadastrosGUI cf = new CadastrosGUI();
        
        cf.setVisible(true);
    }
}
