/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.Enum.EnumSexo;
import br.com.fatec.Enum.EnumUF;
import br.com.fatec.controller.ControllerCliente;
import br.com.fatec.controller.Data;
import br.com.fatec.excecoes.CampoInvalidoException;
import br.com.fatec.excecoes.ComboBoxInvalidoException;
import br.com.fatec.excecoes.DataInvalidaException;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Endereco;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nadin
 */
public class FrmCliente extends javax.swing.JFrame {
    
    private ControllerCliente control;
    private boolean editando;
    private List<Cliente> valoresTable;
    private boolean abertoPorAnimal;
    
    public FrmCliente(Cliente cliente){
        this();
        abertoPorAnimal = true;
        txtNome.setText(cliente.getNome());
        txtCPF.setText(cliente.getCpf());
        txtRG.setText(cliente.getRg());
        cmbSexo.setSelectedItem(cliente.getSexo().toString());
        txtNascimento.setText(cliente.getNascimento().toString());
        Endereco end = cliente.getEndereco();
        txtEndereco.setText(end.getEndereco());
        txtCEP.setText(end.getCep());
        txtNumero.setText(end.getNumero()+"");
        cmbUF.setSelectedItem(end.getUF().toString());
        txtContato.setText(cliente.getContato());
        txtEmail.setText(cliente.getEmail());
    }
    
    public FrmCliente() {
        abertoPorAnimal = false;
        initComponents();
        this.setLocationRelativeTo(null);
        control = new ControllerCliente();
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);
        preencheCombo();
        limparCampos();
        editando = false;
    }
    
    private void preencheCombo(){
        for (EnumSexo sexo : EnumSexo.values())
            cmbSexo.addItem(sexo.toString());
        
        for (EnumUF uf : EnumUF.values())
            cmbUF.addItem(uf.toString());
    }
    
    private void limparCampos(){
        txtNome.setText("");
        txtCPF.setText("");
        txtRG.setText("");
        txtNascimento.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtCEP.setText("");
        cmbUF.setSelectedIndex(-1);
        txtContato.setText("");
        txtEmail.setText("");
        cmbSexo.setSelectedIndex(-1);
        editando = false;
        txtNome.requestFocus();
        
    }
    private void limparTabela(){
        DefaultTableModel model =(DefaultTableModel) jTabela.getModel();
        //limpa a table
        for(int i = model.getRowCount() - 1; i >= 0; i--)
            model.removeRow(i);
    }
    private void bloquearBotoes(){
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCadastrarAnimal.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtCEP = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbUF = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNascimento = new javax.swing.JTextField();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        btnCadastrarAnimal = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel2.setText("CPF");

        jLabel3.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel4.setText("Endereço");

        jLabel5.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel5.setText("RG");

        jLabel6.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel6.setText("CEP");

        jLabel7.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel7.setText("Nº");

        txtNome.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtCPF.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtRG.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtEndereco.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtCEP.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtNumero.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel8.setText("UF");

        cmbUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel9.setText("Contato");

        jLabel10.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel10.setText("E-mail");

        jLabel12.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel12.setText("Data de Nascimento");

        txtContato.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtNascimento.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        btnDeletar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel13.setText("Sexo");

        jTabela.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "RG", "Data de Nascimento", "Endereço", "Numero", "CEP", "UF", "Contato", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jTabela.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jTabelaVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTabela);

        btnCadastrarAnimal.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnCadastrarAnimal.setText("Cadastrar Animal");
        btnCadastrarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAnimalActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel14.setText("Pesquisar Cliente");

        txtPesquisar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        btnPesquisar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrarAnimal)))
                .addGap(0, 239, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbUF, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrarAnimal)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUFActionPerformed

    private void btnCadastrarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAnimalActionPerformed
        try{
            Cliente cliente = new Cliente();
            if(!editando){            
                cliente.setNome(txtNome.getText());
                cliente.setCpf(txtCPF.getText());
                cliente.setRg(txtRG.getText());
                
               
                
                
                try{
                    cliente.setSexo(EnumSexo.toEnum(cmbSexo.getSelectedItem().toString().charAt(0)));
                }catch (NullPointerException e){
                    cliente.setSexo(null);
                }
                try{
                    cliente.setNascimento(new Data(txtNascimento.getText()));
                } catch (NullPointerException e){
                    cliente.setNascimento(null);
                }
                //cria um objeto endereço (agregado a cliente)
                Endereco endereco = new Endereco();
                endereco.setEndereco(txtEndereco.getText());
                endereco.setCep(txtCEP.getText());
                try {
                    endereco.setNumero(Integer.parseInt(txtNumero.getText()));
                }catch (NumberFormatException e){
                    endereco.setNumero(0);
                }
                try{
                    endereco.setUF(EnumUF.toEnum(cmbUF.getSelectedItem().toString()));
                }catch (NullPointerException e){
                    endereco.setUF(null);
                }
                cliente.setEndereco(endereco);
                cliente.setContato(txtContato.getText());
                cliente.setEmail(txtEmail.getText());
            }else{
                cliente = this.valoresTable.get(jTabela.getSelectedRow());
            }
            
            //não cadastra caso form foi aberto pela tela de animal
            if (!abertoPorAnimal){
                if (control.pesquisarPorCpf(cliente) != null){
                    JOptionPane.showMessageDialog(this, "cpf já cadastrado!");
                    return;
                }
                control.cadastrar(cliente);            
                for (Cliente c : control.listar(""))
                    cliente = c;     
            }
            //passa objeto cliente pra tela de animal
            FrmAnimal frame = new FrmAnimal(cliente);
            frame.setVisible(true);
            this.dispose();           
        }catch(DataInvalidaException e){
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida!");
        }catch(ComboBoxInvalidoException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (CampoInvalidoException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "erro:\n"+ex.getMessage());
        }
          
    }//GEN-LAST:event_btnCadastrarAnimalActionPerformed

    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       
        try {
            //pega o model da table
            DefaultTableModel model =(DefaultTableModel) jTabela.getModel();
            //limpa a tabela
            limparTabela();
            //preenche a table com os novos dados
            this.valoresTable = control.listar(txtPesquisar.getText());
            for (Cliente cliente : this.valoresTable){
                Endereco end = cliente.getEndereco();
                //cria um vetor com os dados
                String linha[] = {cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getNascimento().toString(),
                    end.getEndereco(), end.getNumero()+"", end.getCep(), end.getUF().toString(), cliente.getContato(), cliente.getEmail()};
                //adiciona os dados na table
                model.addRow(linha);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Um erro aconteceu:\n" + ex.getMessage());
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked
        int linha = jTabela.getSelectedRow();
        
        //usa o vetor carregado na memoria para preencher os campos
        Cliente cliente = this.valoresTable.get(linha);
        txtNome.setText(cliente.getNome());
        txtCPF.setText(cliente.getCpf());
        txtRG.setText(cliente.getRg());
        cmbSexo.setSelectedItem(cliente.getSexo().toString());
        txtNascimento.setText(cliente.getNascimento().toString());
        Endereco end = cliente.getEndereco();
        txtEndereco.setText(end.getEndereco());
        txtCEP.setText(end.getCep());
        txtNumero.setText(end.getNumero()+"");
        cmbUF.setSelectedItem(end.getUF().toString());
        txtContato.setText(cliente.getContato());
        txtEmail.setText(cliente.getEmail());
        
        editando = true;
        
        //habilita os botões do CRUD
        btnEditar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_jTabelaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        //tira a seleção da tabela
        jTabela.getSelectionModel().clearSelection();
        bloquearBotoes();
        editando = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTabelaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jTabelaVetoableChange
      
    }//GEN-LAST:event_jTabelaVetoableChange

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = jTabela.getSelectedRow();
        try {
            editando = false;
            //cria novo objeto cliente
            Cliente cliente = new Cliente();
            cliente.setId(this.valoresTable.get(linha).getId());
            cliente.setNome(txtNome.getText());
            cliente.setCpf(txtCPF.getText());
            cliente.setRg(txtRG.getText());
            cliente.setSexo(EnumSexo.toEnum(cmbSexo.getSelectedItem().toString().charAt(0)));
            cliente.setNascimento(new Data(txtNascimento.getText()));
            //cria um objeto endereço (agregado a cliente)
            Endereco endereco = new Endereco();
            endereco.setEndereco(txtEndereco.getText());
            endereco.setCep(txtCEP.getText());
            endereco.setNumero(Integer.parseInt(txtNumero.getText()));
            endereco.setUF(EnumUF.toEnum(cmbUF.getSelectedItem().toString()));
            cliente.setEndereco(endereco);
            cliente.setContato(txtContato.getText());
            cliente.setEmail(txtEmail.getText());
            //altera o objeto
            control.alterar(cliente);
            JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");
            //recarrega a tabela
            this.btnPesquisarActionPerformed(null);
            limparCampos();                    
            bloquearBotoes();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "erro:\n" + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "selecione algum cliente na tabela!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int linha = jTabela.getSelectedRow();
        try {
            editando = false;
            Cliente c = this.valoresTable.get(linha);
            //0 = sim
            //1 = não
            //2 = cancelar
            int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir '"+c.getNome()+"'");
            if (resp == 0){
                //remove o cliente do banco
                control.remover(c);
                //limpa os campos
                limparCampos();
                //recarrega a table
                this.btnPesquisarActionPerformed(null);
                bloquearBotoes();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "erro:\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarAnimal;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTabela;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtRG;
    // End of variables declaration//GEN-END:variables
}