package br.com.fatec.historico.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TabelaExame implements Tabela{
      private final String HTMLTOPO = "<table>\n" +
                                        "<tr>\n" +
                                        "<th>Exame</th>\n" +
                                        "<th>Observação</th>\n" +                                        
                                        "</tr>\n";
    
    private final String HTMLCHAO = "</table>";
    protected HashMap<String, List> data;
    
    public TabelaExame(){
        data = new HashMap();
        data.put("exame", new ArrayList());
        data.put("observacao", new ArrayList());
    }
    
    @Override
    public void addLinha(List<String> linha){
        if (linha.size() != data.size())
            throw new RuntimeException("Numero colunas não coincidem");
        
        data.get("exame").add(linha.get(0));
        data.get("observacao").add(linha.get(1));
    }
    
    @Override
    public List<String> getLinha(int i){
        List<String> linha = new ArrayList();
        linha.add((String) data.get("exame").get(i));
        linha.add((String) data.get("observacao").get(i));
       
        return linha;
    }
    
    @Override
    public String getHTML() {
        String html = "";
        html += HTMLTOPO;
        for (int i=0; i<data.get("exame").size(); i++){
            html += "<tr>\n";
            html += "<td>" + data.get("exame").get(i) + "</td>\n";
            html += "<td>" + data.get("observacao").get(i) + "</td>\n";
            html += "</tr>\n";
        }
        html += HTMLCHAO;
        return html;
    }
    
}
