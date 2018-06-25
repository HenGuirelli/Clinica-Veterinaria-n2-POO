package br.com.fatec.historico.controller;

import br.com.fatec.model.Animal;
import br.com.fatec.DAO.ConsultaDAO;
import br.com.fatec.DAO.ExameDAO;
import br.com.fatec.historico.model.HTML;
import br.com.fatec.historico.model.Tabela;
import br.com.fatec.historico.model.TabelaConsulta;
import br.com.fatec.historico.model.TabelaExame;
import br.com.fatec.model.Consulta;
import br.com.fatec.model.Exame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerHistorico {
    public void gerarHistorico(Animal animal) throws ClassNotFoundException, SQLException, IOException{   
        ConsultaDAO daoConsulta = new ConsultaDAO();
        
        //cria a tabela de consulta e exames
        Tabela tabelaConsulta = new TabelaConsulta();
        Tabela tabelaExame = new TabelaExame();
        
        for(Consulta consulta : daoConsulta.listar("animal = " + animal.getId())){
            //linha =  data // horario // dia da semana // veterinario // observação
            List<String> linha = new ArrayList();
            linha.add(consulta.getData().toString());
            linha.add(consulta.getHorario());
            linha.add(consulta.getDiaDaSemana());
            linha.add(consulta.getVeterinario().getNome());
            linha.add(consulta.getObservacao());
            //adiciona a linha na tabela
            tabelaConsulta.addLinha(linha);
        }
        
        //busca exame
        ExameDAO daoExame = new ExameDAO();
        for(Exame exame : daoExame.listar("animal = '" + animal.getNome() + "'")){
            List<String> linha = new ArrayList();
            linha.add(exame.getTipo().toString());
            linha.add(exame.getObservacao());
            tabelaExame.addLinha(linha);
        }
        
        
        HTML html = new HTML();
        html.setCliente(animal.getTutor().getNome());
        html.setAnimal(animal.getNome());
        html.addTabela(tabelaConsulta);
        html.addTabela(tabelaExame);
        
        //cria o path 
        String path =  new File("").getAbsolutePath()+"/src/br/com/fatec/historico/historico.html";
        
        
        FileWriter arquivo = new FileWriter((path));
        BufferedWriter arq = new BufferedWriter(arquivo);
        
        //escreve o html no arquivo
        arq.append(html.getHTML());
        arq.close();       
        //abre o arquivo
        java.awt.Desktop.getDesktop().open(new File (path));
       
    }
}
