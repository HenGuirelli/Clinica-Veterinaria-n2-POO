
package br.com.fatec.view;

import br.com.fatec.Enum.EnumTurno;
import br.com.fatec.controller.ControllerConsulta;
import br.com.fatec.controller.ControllerVeterinario;
import br.com.fatec.controller.Data;
import br.com.fatec.model.Consulta;
import br.com.fatec.model.Veterinario;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nadin
 */
public class FrmAgendamento extends javax.swing.JFrame {
    private ControllerVeterinario control;
    private ControllerConsulta controlConsulta;
    private boolean preenchimentoAutomatico = true;
    
    public FrmAgendamento() {
        initComponents();
        this.setLocationRelativeTo(null);
        control = new ControllerVeterinario();
        controlConsulta = new ControllerConsulta();
        cmbTurno.setEnabled(false);
        preencheCombo();       
    }
    
    private void preencheCombo(){
        preenchimentoAutomatico = true;
        try {
             
            for (Veterinario veterinario : control.pesquisar("")){
                //adiciona o veterinario na combo          
                cmbVeterinario.addItem(veterinario);
            }          
            cmbDia.setEnabled(false);
            cmbTurno.setSelectedIndex(-1);
            cmbVeterinario.setSelectedIndex(-1);
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro geral:\n" + ex.getMessage());
        }finally{
             preenchimentoAutomatico = false;
        }
        
    }
    
    private void limparTable(){
        DefaultTableModel model = (DefaultTableModel) jTabela.getModel();
        //limpa a table
        for(int i = model.getRowCount() - 1; i >= 0; i--)
            model.removeRow(i);
    }
    
    private void preencherTable(){
        limparTable();
        //verifica se todos os componentes foram selecionados
        if (cmbDia.getSelectedIndex() != -1 && 
                cmbVeterinario.getSelectedIndex() != -1 &&
                cmbTurno.getSelectedIndex() != -1){
            String vet = cmbVeterinario.getItemAt(cmbVeterinario.getSelectedIndex()).getNome();
            String diaSelecionado = cmbDia.getItemAt(cmbDia.getSelectedIndex());
            String turno = cmbTurno.getItemAt(cmbTurno.getSelectedIndex());
            Veterinario vete = cmbVeterinario.getItemAt(cmbVeterinario.getSelectedIndex());            
            //pesquisa o proximo dia da semana
            Calendar cal = Calendar.getInstance();
            //pega data atual
            cal.setTime(new Date(System.currentTimeMillis()));
            int diasEncontrados = 0;
            //procura 3 datas proximas
            while (diasEncontrados < 3){
                if (Data.getDiaDaSemana(new Data(cal.getTime()).toString()).equals(diaSelecionado)){
                    diasEncontrados++;
                    DefaultTableModel tabela = (DefaultTableModel) jTabela.getModel();
                    String linha[] = new String[3];
                    linha[0] = new Data(cal.getTime()).toString();
                    linha[2] = vet;
                    
                    if (turno.equals("MANHA")){                        
                        linha[1] = "8h";
                        tabela.addRow(linha);                        
                        linha[1] = "8h30";                        
                        tabela.addRow(linha);
                        linha[1] = "9h";                        
                        tabela.addRow(linha); 
                        linha[1] = "9h30";                        
                        tabela.addRow(linha); 
                        linha[1] = "10h";                        
                        tabela.addRow(linha); 
                        linha[1] = "10h30";                        
                        tabela.addRow(linha);
                        linha[1] = "11h";                        
                        tabela.addRow(linha);
                        linha[1] = "11h30";                        
                        tabela.addRow(linha);
                        linha[1] = "12h";                        
                        tabela.addRow(linha);
                    }else if (turno.equals("TARDE")){                    
                        linha[1] = "12h30";                        
                        tabela.addRow(linha);
                        linha[1] = "13h";                        
                        tabela.addRow(linha); 
                        linha[1] = "13h30";                        
                        tabela.addRow(linha); 
                        linha[1] = "14h";                        
                        tabela.addRow(linha); 
                        linha[1] = "14h30";                        
                        tabela.addRow(linha);
                        linha[1] = "15h";                        
                        tabela.addRow(linha);
                        linha[1] = "15h30";                        
                        tabela.addRow(linha);
                        linha[1] = "16h";                        
                        tabela.addRow(linha);
                        linha[1] = "16h30";                        
                        tabela.addRow(linha);
                        linha[1] = "17h";                        
                        tabela.addRow(linha);
                    }else if (turno.equals("NOITE")){                    
                        linha[1] = "17h30";                        
                        tabela.addRow(linha);
                        linha[1] = "18h";                        
                        tabela.addRow(linha); 
                        linha[1] = "19h30";                        
                        tabela.addRow(linha); 
                        linha[1] = "20h";                        
                        tabela.addRow(linha); 
                        linha[1] = "21h30";                        
                        tabela.addRow(linha);
                    }
                    
                    
                }   
                cal.add(Calendar.DATE, 1);
            }
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbVeterinario = new javax.swing.JComboBox<>();
        cmbTurno = new javax.swing.JComboBox<>();
        cmbDia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        btnAgendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Turno");

        jLabel2.setText("Veterinario");

        jLabel3.setText("Dia da Semana");

        cmbVeterinario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVeterinarioItemStateChanged(evt);
            }
        });
        cmbVeterinario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbVeterinarioPropertyChange(evt);
            }
        });

        cmbTurno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTurnoItemStateChanged(evt);
            }
        });
        cmbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTurnoActionPerformed(evt);
            }
        });

        cmbDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDiaItemStateChanged(evt);
            }
        });

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Horario", "Veterinario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTabela);

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbVeterinario, 0, 96, Short.MAX_VALUE)
                                    .addComponent(cmbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(btnAgendar)))
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgendar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVeterinarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbVeterinarioPropertyChange
        
    }//GEN-LAST:event_cmbVeterinarioPropertyChange

    private void cmbVeterinarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVeterinarioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
            if (cmbVeterinario.getSelectedIndex() != -1 && !preenchimentoAutomatico){
               cmbTurno.setEnabled(true);
               cmbDia.removeAllItems();
               cmbDia.setEnabled(true);
               Veterinario vet = cmbVeterinario.getItemAt(cmbVeterinario.getSelectedIndex());

               if ((vet.getAtendimento().charAt(0) + "").equals("1"))
                   cmbDia.addItem("Domingo");

               if ((vet.getAtendimento().charAt(1) + "").equals("1"))
                   cmbDia.addItem("Segunda");

               if ((vet.getAtendimento().charAt(2) + "").equals("1"))
                   cmbDia.addItem("Terça");

               if ((vet.getAtendimento().charAt(3) + "").equals("1"))
                   cmbDia.addItem("Quarta");

               if ((vet.getAtendimento().charAt(4) + "").equals("1"))
                   cmbDia.addItem("Quinta");

               if ((vet.getAtendimento().charAt(5) + "").equals("1"))
                   cmbDia.addItem("Sexta");

               if ((vet.getAtendimento().charAt(6) + "").equals("1"))
                   cmbDia.addItem("Sabado");
               preencherTable();
           }
           cmbDia.setSelectedIndex(-1);
           
           //preenche o turno
           preenchimentoAutomatico = true;
           cmbTurno.removeAllItems();
           cmbTurno.addItem(((Veterinario) cmbVeterinario.getSelectedItem()).getTurno().toString());
           cmbTurno.setSelectedIndex(-1);
           preenchimentoAutomatico = false;
        }
    }//GEN-LAST:event_cmbVeterinarioItemStateChanged

    private void cmbTurnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTurnoItemStateChanged
        preencherTable();
    }//GEN-LAST:event_cmbTurnoItemStateChanged

    private void cmbDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDiaItemStateChanged
        preencherTable();
    }//GEN-LAST:event_cmbDiaItemStateChanged

    private void jTabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabelaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabelaKeyPressed

    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked

    }//GEN-LAST:event_jTabelaMouseClicked

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        if (cmbVeterinario.getSelectedIndex() != -1 &&
            cmbTurno.getSelectedIndex() != -1 &&
            cmbDia.getSelectedIndex() != -1 &&
            jTabela.getSelectedRow() != -1)
        {
            Veterinario veterinario = cmbVeterinario.getItemAt(cmbVeterinario.getSelectedIndex());
            String dia = jTabela.getValueAt(jTabela.getSelectedRow(), 0).toString();
            String hora = jTabela.getValueAt(jTabela.getSelectedRow(), 1).toString();
            //cria a consulta
            Consulta consulta = controlConsulta.criarConsulta(veterinario, new Data(dia), hora, null, null);
            
             
            try {
                //verifica se o horario está vago
                if (controlConsulta.horarioVago(consulta.getData(), consulta.getHorario())){
                    //abre a outra tela
                    FrmAgendarConsulta frame = new FrmAgendarConsulta(consulta);
                    frame.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Horario já está reservado");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "erro:\n" + ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(this, "selecione todos os componentes");
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void cmbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JComboBox<Veterinario> cmbVeterinario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    // End of variables declaration//GEN-END:variables
}
