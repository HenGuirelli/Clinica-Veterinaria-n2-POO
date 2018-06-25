package br.com.fatec.historico.model;

import java.util.List;

public interface Tabela {
    public void addLinha(List<String> linha);
    public List<String> getLinha(int i);
    public String getHTML();
}
