/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.historico;

import br.com.fatec.historico.model.HTML;
import br.com.fatec.historico.model.TabelaConsulta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique
 */
public class TesteMain {
    public static void main(String args[]){
        TabelaConsulta tabela = new TabelaConsulta();
        List<String> linha = new ArrayList();
        linha.add("06/06/2018");
        linha.add("10h");
        linha.add("segunda");
        linha.add("vet");
        linha.add("foi pedido exame");
        tabela.addLinha(linha);
        HTML html = new HTML();
        html.addTabela(tabela);
        
        String path =  new File("").getAbsolutePath()+"/src/br/com/fatec/historico/historico.html";
        try {
            FileWriter arquivo = new FileWriter((path));
            BufferedWriter arq = new BufferedWriter(arquivo);
            
            arq.append(html.getHTML());
            arq.close();            
            java.awt.Desktop.getDesktop().open(new File (path));
           
        } catch (IOException ex) {
            Logger.getLogger(TesteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
