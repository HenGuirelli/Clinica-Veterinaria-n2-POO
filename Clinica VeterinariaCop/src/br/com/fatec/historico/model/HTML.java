package br.com.fatec.historico.model;

import java.util.ArrayList;

public class HTML extends BaseHTML{
    private ArrayList<Tabela> tabelas = new ArrayList();
    private String cliente="";
    private String animal="";
    
    public void addTabela(Tabela tabela){       
        if (tabelas.size() == 2)
            throw new RuntimeException("HTML cheio. Maximo de 2 Tabelas");
        
        tabelas.add(tabela);
    }
    
    public String getHTML(){
        String html = "";
        html += this.getHTMLTOPO().replaceAll("%cliente%", cliente).replaceAll("%animal%", animal);
        html += tabelas.get(0).getHTML();
        html += "<h1>Exames:</h1>";
        if (tabelas.size() == 2)
            html += tabelas.get(1).getHTML();
        html += this.getHTMLCHAO();
        
        return html;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    
}
