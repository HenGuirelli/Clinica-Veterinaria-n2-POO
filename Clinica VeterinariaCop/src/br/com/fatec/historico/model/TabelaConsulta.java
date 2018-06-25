package br.com.fatec.historico.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TabelaConsulta implements Tabela{
    private final String HTMLTOPO = "<table>\n" +
                                    "<tr>\n" +
                                    "<th>Data</th>\n" +
                                    "<th>Horario</th>\n" +
                                    "<th>Dia da semana</th>\n" +
                                    "<th>Veterinario</th>\n" +
                                    "<th>Observação</th>\n" +
                                    "</tr>";
    
    private final String HTMLCHAO = "</table>";
    private HashMap<String, List> data;

    public TabelaConsulta(){
        data = new HashMap();
        data.put("data", new ArrayList());
        data.put("hora", new ArrayList());
        data.put("dia", new ArrayList());
        data.put("veterinario", new ArrayList());
        data.put("observacao", new ArrayList());
        
    }
    
    @Override
    public void addLinha(List<String> linha){
        if (linha.size() != data.size())
            throw new RuntimeException("Numero colunas não coincidem");
        
        data.get("data").add(linha.get(0));
        data.get("hora").add(linha.get(1));
        data.get("dia").add(linha.get(2));
        data.get("veterinario").add(linha.get(3));
        data.get("observacao").add(linha.get(4));
    }
    
    @Override
    public List<String> getLinha(int i){
        List<String> linha = new ArrayList();
        linha.add((String) data.get("data").get(i));
        linha.add((String) data.get("hora").get(i));
        linha.add((String) data.get("dia").get(i));
        linha.add((String) data.get("veterinario").get(i));
        linha.add((String) data.get("observacao").get(i));
        return linha;
    }

    @Override
    public String getHTML() {
        String html = "";
        html += HTMLTOPO;
        for (int i=0; i<data.get("data").size(); i++){
            html += "<tr>\n";
            html += "<td>" + data.get("data").get(i) + "</td>\n";
            html += "<td>" + data.get("hora").get(i) + "</td>\n";
            html += "<td>" + data.get("dia").get(i) + "</td>\n";
            html += "<td>" + data.get("veterinario").get(i) + "</td>\n";
            html += "<td>" + data.get("observacao").get(i) + "</td>\n";
            html += "</tr>\n";
        }
        html += HTMLCHAO;
        return html;
    }
}
