/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.Enum.EnumEspecializacao;
import br.com.fatec.Enum.EnumSexo;
import br.com.fatec.Enum.EnumTurno;
import br.com.fatec.Enum.EnumUF;
import br.com.fatec.controller.ControllerVeterinario;
import br.com.fatec.controller.Data;
import br.com.fatec.excecoes.CampoInvalidoException;
import br.com.fatec.excecoes.ComboBoxInvalidoException;
import br.com.fatec.excecoes.DataInvalidaException;
import br.com.fatec.model.Endereco;
import br.com.fatec.model.Veterinario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nadin
 */
public class FrmCadastroVet extends javax.swing.JFrame {
    private ControllerVeterinario control;
    private List<Veterinario> valoresTabela;
    /**
     * Creates new form FrmCadastroVet
     */
    public FrmCadastroVet() {
        control = new ControllerVeterinario();
        initComponents();
        preencheCombo();
        this.setLocationRelativeTo(null);
        limparCampos();
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    private void limparCampos(){
        chkDomingo.setSelected(false);
        chkSegunda.setSelected(false);
        chkTerca.setSelected(false);
        chkQuarta.setSelected(false);
        chkQuinta.setSelected(false);
        chkSexta.setSelected(false);
        chkSabado.setSelected(false);
        
        cmbUf.setSelectedIndex(-1);
        cmbEspecializacao.setSelectedIndex(-1);
        cmbTurno.setSelectedIndex(-1); 
        cmbSexo.setSelectedIndex(-1);
        
        //dados do veterinario
        rdbCirurgiaoS.setSelected(false);
        rdbPlantaoS.setSelected(false);
        txtPis.setText("");       
        
        //dados gerais
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNascimento.setText("");
        txtEndereco.setText("");
        txtCep.setText("");
        txtNumero.setText("");
        txtContato.setText("");
        txtEmail.setText("");
        txtNome.requestFocus();
        
        //radio buttons
        rdbPlantaoS.setSelected(false);
        rdbPlantaoN.setSelected(false);
        
        rdbCirurgiaoS.setSelected(false);
        rdbCirurgiaoN.setSelected(false);
    }
    private void limparTabela(){
         //pega o model da table
        DefaultTableModel model =(DefaultTableModel) jTabela.getModel();
        //limpa a table
        for(int i = model.getRowCount() - 1; i >= 0; i--)
            model.removeRow(i);
    }
    public void preencheCombo(){
        //todos os combos represetam um enum
        //preenche o sexo
        for (EnumSexo sexo : EnumSexo.values())
            cmbSexo.addItem(sexo.toString());
        
        //preenche o UF
        for (EnumUF uf : EnumUF.values())
            cmbUf.addItem(uf.toString());
        
        //preenche  a especialização
        for (EnumEspecializacao espec : EnumEspecializacao.values())
            cmbEspecializacao.addItem(espec.toString());
        
        //preenche o turno
        for (EnumTurno turno : EnumTurno.values())
            cmbTurno.addItem(turno.toString());
    }
    
    private Veterinario popularModel(){
        Veterinario vet = new Veterinario();
        
        String atendimento = "";
        //salva 1 para os valores true e 0 para false
        atendimento += chkDomingo.isSelected()  ? "1" : "0";
        atendimento += chkSegunda.isSelected()  ? "1" : "0";
        atendimento += chkTerca.isSelected()    ? "1" : "0";
        atendimento += chkQuarta.isSelected()   ? "1" : "0";
        atendimento += chkQuinta.isSelected()   ? "1" : "0";
        atendimento += chkSexta.isSelected()    ? "1" : "0";
        atendimento += chkSabado.isSelected()   ? "1" : "0";
        vet.setAtendimento(atendimento);
        
        //dados do veterinario
        vet.setCirurgiao(rdbCirurgiaoS.isSelected());
        vet.setPlantao(rdbPlantaoS.isSelected());
        try{
            vet.setEspecializacao(EnumEspecializacao.toEnum(
                    cmbEspecializacao.getItemAt(cmbEspecializacao.getSelectedIndex())));
        }catch (Exception e){
            vet.setEspecializacao(null);
        }
        vet.setPis(txtPis.getText());
        try{
            vet.setTurno(EnumTurno.toEnum(cmbTurno.getItemAt(cmbTurno.getSelectedIndex())));        
        }catch (Exception e){
            vet.setTurno(null);
        }
        //dados gerais
        vet.setNome(txtNome.getText());
        vet.setCpf(txtCpf.getText());
        vet.setRg(txtRg.getText());
        try {
            vet.setSexo(EnumSexo.toEnum(cmbSexo.getItemAt(cmbSexo.getSelectedIndex()).charAt(0)));
        }catch (Exception e){
            vet.setSexo(null);
        }
        
        try {
            vet.setNascimento(new Data(txtNascimento.getText()));
        }catch (Exception e){
            vet.setNascimento(null);
        }
        //cria o endereço
        Endereco end = new Endereco();
        end.setEndereco(txtEndereco.getText());
        end.setCep(txtCep.getText());
        try {
            end.setNumero(Integer.parseInt(txtNumero.getText()));
        }catch (Exception e){
            end.setNumero(0);
        }
        try {
            end.setUF(EnumUF.toEnum(cmbUf.getItemAt(cmbUf.getSelectedIndex())));
        }catch (Exception e){
            end.setUF(null);
        }
        vet.setEndereco(end);
        
        vet.setContato(txtContato.getText());
        vet.setEmail(txtEmail.getText());
        return vet;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtContato = new javax.swing.JTextField();
        txtNascimento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox<>();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbUf = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        cmbEspecializacao = new javax.swing.JComboBox<>();
        txtPis = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        rdbPlantaoS = new javax.swing.JRadioButton();
        rdbPlantaoN = new javax.swing.JRadioButton();
        chkSegunda = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        chkTerca = new javax.swing.JCheckBox();
        chkQuarta = new javax.swing.JCheckBox();
        chkQuinta = new javax.swing.JCheckBox();
        chkSexta = new javax.swing.JCheckBox();
        chkSabado = new javax.swing.JCheckBox();
        chkDomingo = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        rdbCirurgiaoS = new javax.swing.JRadioButton();
        rdbCirurgiaoN = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Veterinario");

        txtEmail.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtContato.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtNascimento.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel13.setText("Sexo");

        txtNome.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtCpf.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtRg.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtEndereco.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtCep.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        txtNumero.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel8.setText("UF");

        cmbUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUfActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel10.setText("E-mail");

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

        jLabel11.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel11.setText("Contato");

        jLabel12.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel12.setText("Data de Nascimento");

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

        btnCadastrar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "RG", "Sexo", "DataNascimento", "Endereço", "CEP", "N", "UF", "Contato", "Email", "Especialização", "PIS", "Turno", "Plantão", "Cirurgião"
            }
        ));
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabela);

        jLabel14.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel14.setText("Especialização");

        txtPis.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel9.setText("PIS");

        jLabel15.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel15.setText("Turno");

        jLabel16.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel16.setText("Plantão");

        rdbPlantaoS.setText("Sim");

        rdbPlantaoN.setText("Não");

        chkSegunda.setText("Segunda-Feira");

        jLabel17.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel17.setText("Dias de Atendimento");

        chkTerca.setText("Terça-Feira");

        chkQuarta.setText("Quarta-Feira");

        chkQuinta.setText("Quinta-Feira");

        chkSexta.setText("Sexta-Feira");

        chkSabado.setText("Sábado");

        chkDomingo.setText("Domingo");

        jLabel18.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel18.setText("Cirurgião");

        rdbCirurgiaoS.setText("Sim");

        rdbCirurgiaoN.setText("Não");

        jLabel19.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel19.setText("Pesquisar Veterinario");

        txtPesquisa.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N

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
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbEspecializacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPis, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbPlantaoS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbPlantaoN))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkDomingo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkSegunda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkTerca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkQuarta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkQuinta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkSexta)
                                        .addGap(40, 40, 40)
                                        .addComponent(chkSabado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeletar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCadastrar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(367, 367, 367)
                                            .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(22, 22, 22)
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel13))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel7)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(149, 149, 149))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbCirurgiaoS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbCirurgiaoN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbEspecializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(rdbPlantaoS)
                    .addComponent(rdbPlantaoN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkSegunda)
                    .addComponent(chkTerca)
                    .addComponent(chkQuarta)
                    .addComponent(chkQuinta)
                    .addComponent(chkSexta)
                    .addComponent(chkSabado)
                    .addComponent(chkDomingo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(rdbCirurgiaoS)
                    .addComponent(rdbCirurgiaoN))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar)
                    .addComponent(btnCancelar))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUfActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Veterinario vet = popularModel();
        try {
           
            if (control.pesquisarPorCpf(vet) == null){
                control.cadastrar(vet);
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso");
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(this, "Cpf já cadastrado");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "erro:\n" + ex.getMessage());
        } catch(CampoInvalidoException | DataInvalidaException | ComboBoxInvalidoException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
       
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String pesquisa = txtPesquisa.getText();
        limparTabela();
        try {
            valoresTabela = control.pesquisar(pesquisa);
            DefaultTableModel table = (DefaultTableModel) jTabela.getModel();
            for (Veterinario vet : valoresTabela){
                //vetor dados da linha
                Endereco end = vet.getEndereco();
                String[] valores = {vet.getNome(), vet.getCpf(),
                vet.getRg(), vet.getSexo().toString(), vet.getNascimento().toString(),
                end.getEndereco(), end.getCep(), end.getNumero()+"",
                end.getUF().toString(), vet.getContato(), vet.getEmail(),
                vet.getEspecializacao().toString(), vet.getPis(), vet.getTurno().toString(),
                vet.isPlantao()+"", vet.isCirurgiao()+""};
                table.addRow(valores);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro geral:\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked
        int linha = jTabela.getSelectedRow();
        Veterinario vet = valoresTabela.get(linha);
        txtNome.setText(vet.getNome());
        txtCpf.setText(vet.getCpf());
        txtRg.setText(vet.getRg());
        cmbSexo.setSelectedItem(vet.getSexo().toString());
        txtNascimento.setText(vet.getNascimento().toString());
        Endereco end = vet.getEndereco();
        
        txtEndereco.setText(end.getEndereco());
        txtCep.setText(end.getCep());
        txtNumero.setText(end.getNumero()+"");
        cmbUf.setSelectedItem(end.getUF().toString());
        txtContato.setText(vet.getContato());
        txtEmail.setText(vet.getEmail());
        cmbEspecializacao.setSelectedItem(vet.getEspecializacao().toString());
        txtPis.setText(vet.getPis());
        cmbTurno.setSelectedItem(vet.getTurno().toString());
        
        //seta os radio button
        rdbPlantaoS.setSelected(vet.isPlantao());
        rdbPlantaoN.setSelected(!vet.isPlantao());
        
        rdbCirurgiaoS.setSelected(vet.isCirurgiao());
        rdbCirurgiaoN.setSelected(!vet.isCirurgiao());
        
        String atend = vet.getAtendimento();
        
        this.chkDomingo.setSelected(atend.charAt(0) == '1');
        this.chkSegunda.setSelected(atend.charAt(1) == '1');
        this.chkTerca.setSelected(  atend.charAt(2) == '1');
        this.chkQuarta.setSelected( atend.charAt(3) == '1');
        this.chkQuinta.setSelected( atend.charAt(4) == '1');
        this.chkSexta.setSelected(  atend.charAt(5) == '1');
        this.chkSabado.setSelected( atend.charAt(6) == '1');
        
        //arruma os botões
        btnCadastrar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    }//GEN-LAST:event_jTabelaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = jTabela.getSelectedRow();
        Veterinario vet = popularModel();
        vet.setId(valoresTabela.get(linha).getId());
        try {            
            control.alterar(vet);
            JOptionPane.showMessageDialog(this, "Ateração realizada");
            this.btnPesquisarActionPerformed(null);
            limparCampos();
            
            btnEditar.setEnabled(false);
            btnDeletar.setEnabled(false);
            btnCadastrar.setEnabled(true);
            btnCancelar.setEnabled(false);
        } catch (ClassNotFoundException | SQLException ex) {
             JOptionPane.showMessageDialog(this, "Erro geral:\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int linha = jTabela.getSelectedRow();
        Veterinario vet = valoresTabela.get(linha);
        try {            
            control.remover(vet);
            JOptionPane.showMessageDialog(this, "Veterinario Excluido");
            this.btnPesquisarActionPerformed(null);
            limparCampos();
            
            btnEditar.setEnabled(false);
            btnDeletar.setEnabled(false);
            btnCadastrar.setEnabled(true);
            btnCancelar.setEnabled(false);
        } catch (ClassNotFoundException | SQLException ex) {
             JOptionPane.showMessageDialog(this, "Erro geral:\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroVet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroVet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox chkDomingo;
    private javax.swing.JCheckBox chkQuarta;
    private javax.swing.JCheckBox chkQuinta;
    private javax.swing.JCheckBox chkSabado;
    private javax.swing.JCheckBox chkSegunda;
    private javax.swing.JCheckBox chkSexta;
    private javax.swing.JCheckBox chkTerca;
    private javax.swing.JComboBox<String> cmbEspecializacao;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JComboBox<String> cmbUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JRadioButton rdbCirurgiaoN;
    private javax.swing.JRadioButton rdbCirurgiaoS;
    private javax.swing.JRadioButton rdbPlantaoN;
    private javax.swing.JRadioButton rdbPlantaoS;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPis;
    private javax.swing.JTextField txtRg;
    // End of variables declaration//GEN-END:variables
}
