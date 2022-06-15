package com.Cadastros.gui;

import com.Cadastros.entity.Departamento;
import com.Cadastros.entity.Funcionario;
import com.Cadastros.dao.DepDAO;
import com.Cadastros.dao.FuncDAO;
import com.Cadastros.sys.Sistema;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastrosGUI extends javax.swing.JFrame {

    String modoDep;
    String modoFunc;

    public void ManipulaInterfaceDep() {
        switch (modoDep) {
            case "Navegar":
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);

                c_dep_codigo.setEnabled(false);
                c_dep_nome.setEnabled(false);
                break;
            case "Novo":

                c_dep_codigo.setText("");
                c_dep_nome.setText("");

                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);

                c_dep_codigo.setEnabled(true);
                c_dep_nome.setEnabled(true);
                break;
            case "Editar":
                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);

                c_dep_codigo.setEnabled(true);
                c_dep_nome.setEnabled(true);
                break;
            case "Excluir":
                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);

                c_dep_codigo.setEnabled(true);
                c_dep_nome.setEnabled(true);
                break;
            case "Selecao":
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(true);
                btn_dep_excluir.setEnabled(true);
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);

                c_dep_codigo.setEnabled(false);
                c_dep_nome.setEnabled(false);

                break;
            default:
                System.out.println("Modo inválido.");
        }
    }
    //

    public void ManipulaInterfaceFunc() {
        switch (modoFunc) {
            case "Navegar":
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);

                cb_func_deps.setEnabled(false);

                c_func_matricula.setEnabled(false);
                c_func_nome.setEnabled(false);
                break;
            case "Novo":

                c_func_matricula.setText("");
                c_func_nome.setText("");

                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);

                cb_func_deps.setEnabled(true);

                c_func_matricula.setEnabled(true);
                c_func_nome.setEnabled(true);
                break;
            case "Editar":
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);

                cb_func_deps.setEnabled(true);

                c_func_matricula.setEnabled(true);
                c_func_nome.setEnabled(true);
                break;
            case "Excluir":
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);

                cb_func_deps.setEnabled(false);

                c_func_matricula.setEnabled(true);
                c_func_nome.setEnabled(true);
                break;
            case "Selecao":
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(true);
                btn_func_excluir.setEnabled(true);
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);

                cb_func_deps.setEnabled(false);

                c_func_matricula.setEnabled(false);
                c_func_nome.setEnabled(false);

                break;
            default:
                System.out.println("Modo inválido.");
        }
    }

    //load table
    public void LoadTableDep() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Código", "Nome"}, 0);

        for (int i = 0; i < Sistema.ListaDep.size(); i++) {
            Object linha[] = new Object[]{
                Sistema.ListaDep.get(i).getCodigo(),
                Sistema.ListaDep.get(i).getNome()};
            modelo.addRow(linha);
        }
        tbl_dep_depts.setModel(modelo);
        tbl_dep_depts.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_dep_depts.getColumnModel().getColumn(1).setPreferredWidth(200);

        LoadCBDep();
    }

    public void LoadTableFunc() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Matrícula", "Nome", "Departamento"}, 0);

        for (int i = 0; i < Sistema.ListaFunc.size(); i++) {
            Object linha[] = new Object[]{
                Sistema.ListaFunc.get(i).getMatricula(),
                Sistema.ListaFunc.get(i).getNome(),
                Sistema.ListaFunc.get(i).getDepartamento().getNome()};

            modelo.addRow(linha);
        }
        tbl_func_funcs.setModel(modelo);
        tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_func_funcs.getColumnModel().getColumn(2).setPreferredWidth(150);
    }

    //load Cb
    public void LoadCBDep() {
        cb_func_deps.removeAllItems();
        cb_func_deps.addItem("<Selecione>");
        for (int i = 0; i < Sistema.ListaDep.size(); i++) {
            cb_func_deps.addItem(Sistema.ListaDep.get(i).getNome());
        }
    }

    public CadastrosGUI() {
        initComponents();
        setLocationRelativeTo(null);

        Sistema.LOADSYS();
        LoadTableDep();
        LoadTableFunc();

        modoDep = "Navegar";
        modoFunc = "Navegar";

        ManipulaInterfaceDep();
        ManipulaInterfaceFunc();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dep_depts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_dep_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_dep_nome = new javax.swing.JTextField();
        btn_dep_salvar = new javax.swing.JButton();
        btn_dep_cancelar = new javax.swing.JButton();
        btn_dep_novo = new javax.swing.JButton();
        btn_dep_editar = new javax.swing.JButton();
        btn_dep_excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_func_funcs = new javax.swing.JTable();
        btn_func_novo = new javax.swing.JButton();
        btn_func_editar = new javax.swing.JButton();
        btn_func_excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_func_matricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_func_nome = new javax.swing.JTextField();
        btn_func_salvar = new javax.swing.JButton();
        btn_func_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_func_deps = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tbl_dep_depts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dep_depts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dep_deptsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dep_depts);
        if (tbl_dep_depts.getColumnModel().getColumnCount() > 0) {
            tbl_dep_depts.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_dep_depts.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

        jLabel1.setText("Código:");

        c_dep_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dep_codigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        btn_dep_salvar.setText("Salvar");
        btn_dep_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_salvarActionPerformed(evt);
            }
        });

        btn_dep_cancelar.setText("Cancelar");
        btn_dep_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_dep_nome)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btn_dep_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_dep_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_salvar)
                    .addComponent(btn_dep_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_dep_novo.setText("Novo");
        btn_dep_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_novoActionPerformed(evt);
            }
        });

        btn_dep_editar.setText("Editar");
        btn_dep_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_editarActionPerformed(evt);
            }
        });

        btn_dep_excluir.setText("Excluir");
        btn_dep_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btn_dep_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_dep_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_dep_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_novo)
                    .addComponent(btn_dep_editar)
                    .addComponent(btn_dep_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Departamentos", jPanel1);

        tbl_func_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_func_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_func_funcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_func_funcs);
        if (tbl_func_funcs.getColumnModel().getColumnCount() > 0) {
            tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_editar.setText("Editar");
        btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editarActionPerformed(evt);
            }
        });

        btn_func_excluir.setText("Excluir");
        btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_excluirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

        jLabel3.setText("Matrícula:");

        jLabel4.setText("Nome:");

        btn_func_salvar.setText("Salvar");
        btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_salvarActionPerformed(evt);
            }
        });

        btn_func_cancelar.setText("Cancelar");
        btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Dep:");

        cb_func_deps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_func_depsMouseClicked(evt);
            }
        });
        cb_func_deps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_func_depsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_func_nome)
                            .addComponent(c_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_func_deps, 0, 284, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btn_func_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_func_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_salvar)
                    .addComponent(btn_func_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btn_func_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_func_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_func_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_novo)
                    .addComponent(btn_func_editar)
                    .addComponent(btn_func_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionarios", jPanel2);

        getContentPane().add(jTabbedPane1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dep_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_novoActionPerformed
        modoDep = "Novo";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_novoActionPerformed

    private void btn_dep_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_cancelarActionPerformed
        c_dep_codigo.setText("");
        c_dep_nome.setText("");

        modoDep = "Navegar";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_cancelarActionPerformed

    private void btn_dep_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_salvarActionPerformed
        int cod = Integer.parseInt(c_dep_codigo.getText());
        if (modoDep.equals("Novo")) {
            Departamento D = new Departamento(Integer.parseInt(c_dep_codigo.getText()), c_dep_nome.getText());

            DepDAO depDao = new DepDAO();
            depDao.INSERT(D);

            Sistema.ListaDep.add(D);

        } else if (modoDep.equals("Editar")) {

            Departamento D = new Departamento(Integer.parseInt(c_dep_codigo.getText()), c_dep_nome.getText());
            DepDAO depDao = new DepDAO();
            depDao.UPDATE(D);
//            int index = tbl_dep_depts.getSelectedRow();
//            Sistema.ListaDep.get(index).setCodigo(cod);
//            Sistema.ListaDep.get(index).setNome(c_dep_nome.getText());
        }
        Sistema.LOADSYS();
        LoadTableDep();
        LoadTableFunc();

        modoDep = "Navegar";
        ManipulaInterfaceDep();

        c_dep_codigo.setText("");
        c_dep_nome.setText("");

    }//GEN-LAST:event_btn_dep_salvarActionPerformed

    private void btn_dep_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_editarActionPerformed
        modoDep = "Editar";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_editarActionPerformed

    private void btn_dep_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_excluirActionPerformed
        int index = tbl_dep_depts.getSelectedRow();
        if (index >= 0 && index < Sistema.ListaDep.size()) {
            Departamento D = Sistema.ListaDep.get(index);

            DepDAO depDao = new DepDAO();
            depDao.DELETE(D);

            Sistema.ListaDep.remove(index);
        }

        Sistema.LOADSYS();
        LoadTableDep();
        LoadTableFunc();

        modoDep = "Navegar";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_excluirActionPerformed

    private void tbl_dep_deptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dep_deptsMouseClicked
        int index = tbl_dep_depts.getSelectedRow();
        if (index >= 0 && index < Sistema.ListaDep.size()) {
            Departamento D = Sistema.ListaDep.get(index);
            c_dep_codigo.setText(String.valueOf(D.getCodigo()));
            c_dep_nome.setText(D.getNome());
            //ok
            modoDep = "Selecao";
            ManipulaInterfaceDep();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dep_deptsMouseClicked

    private void tbl_func_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_func_funcsMouseClicked
        int index = tbl_func_funcs.getSelectedRow();
        if (index >= 0 && index < Sistema.ListaFunc.size()) {
            Funcionario f = Sistema.ListaFunc.get(index);
            c_func_matricula.setText(String.valueOf(f.getMatricula()));
            c_func_nome.setText(f.getNome());
            c_dep_nome.setText(String.valueOf(f.getDepartamento().getCodigo()));
            cb_func_deps.setSelectedIndex(index);
            modoFunc = "Selecao";
            ManipulaInterfaceFunc();
        }
    }//GEN-LAST:event_tbl_func_funcsMouseClicked

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        modoFunc = "Novo";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
        modoFunc = "Editar";
        ManipulaInterfaceFunc();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_func_editarActionPerformed

    private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed
        int index = tbl_func_funcs.getSelectedRow();
        if (index >= 0 && index < Sistema.ListaFunc.size()) {
            Funcionario f = Sistema.ListaFunc.get(index);

            Sistema.ListaFunc.remove(index);

            FuncDAO funcDao = new FuncDAO();
            funcDao.DELETE(f);
        }

//                getSelectedIndex();
//        if (index == 0) {
//            JOptionPane.showMessageDialog(this, "Você deve selecionar uma departamento!");
//        } else {
////            Sistema.LOADSYS();
//        }
        Sistema.LOADSYS();
        LoadTableDep();
        LoadTableFunc();

        modoFunc = "Navegar";
        ManipulaInterfaceFunc();           // TODO add your handling code here:
    }//GEN-LAST:event_btn_func_excluirActionPerformed

    private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed
        int index = cb_func_deps.getSelectedIndex();
        if (modoFunc.equals("Novo")) {
            if (index == 0) {
                JOptionPane.showMessageDialog(this, "Você deve selecionar uma departamento!");
            } else {
                Funcionario f = new Funcionario();
                f.setMatricula(Integer.parseInt(c_func_matricula.getText()));
                f.setNome(c_func_nome.getText());
                f.setDepartamento(Sistema.ListaDep.get(index - 1));

                FuncDAO funcDao = new FuncDAO();
                funcDao.INSERT(f);

//                Sistema.ListaFunc.add(f);
//                Sistema.ListaDep.get(index - 1).addFunc(f);
            }
        } else if (modoFunc.equals("Editar")) {
            Funcionario f = new Funcionario();
            f.setMatricula(Integer.parseInt(c_func_matricula.getText()));
            f.setNome(c_func_nome.getText());
            f.setDepartamento(Sistema.ListaDep.get(index - 1));

            FuncDAO funcDao = new FuncDAO();
            funcDao.UPDATE(f);
//            Sistema.LOADSYS();
        }

        //talvez de erro
//            Sistema.ListaFunc.get(index);
//            
//            //esses aqui era copia
//             
//            Sistema.ListaDep.get(index).setCodigo(cod);
//            Sistema.ListaDep.get(index).setNome(c_dep_nome.getText());
//            
        Sistema.LOADSYS();
        LoadTableDep();
        LoadTableFunc();

        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_salvarActionPerformed

    private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();           // TODO add your handling code here:
    }//GEN-LAST:event_btn_func_cancelarActionPerformed

    private void cb_func_depsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_func_depsMouseClicked
        //DO add your handling code here:
    }//GEN-LAST:event_cb_func_depsMouseClicked

    private void cb_func_depsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_func_depsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_func_depsActionPerformed

    private void c_dep_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dep_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_dep_codigoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrosGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrosGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrosGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrosGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dep_cancelar;
    private javax.swing.JButton btn_dep_editar;
    private javax.swing.JButton btn_dep_excluir;
    private javax.swing.JButton btn_dep_novo;
    private javax.swing.JButton btn_dep_salvar;
    private javax.swing.JButton btn_func_cancelar;
    private javax.swing.JButton btn_func_editar;
    private javax.swing.JButton btn_func_excluir;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_func_salvar;
    private javax.swing.JTextField c_dep_codigo;
    private javax.swing.JTextField c_dep_nome;
    private javax.swing.JTextField c_func_matricula;
    private javax.swing.JTextField c_func_nome;
    private javax.swing.JComboBox<String> cb_func_deps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_dep_depts;
    private javax.swing.JTable tbl_func_funcs;
    // End of variables declaration//GEN-END:variables
}
