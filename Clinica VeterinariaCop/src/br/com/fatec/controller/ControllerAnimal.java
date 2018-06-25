package br.com.fatec.controller;

import br.com.fatec.DAO.AnimalDAO;
import br.com.fatec.excecoes.CampoInvalidoException;
import br.com.fatec.model.Animal;
import java.sql.SQLException;
import java.util.List;

public class ControllerAnimal {
    
    public boolean cadastrar(Animal animal) throws ClassNotFoundException, SQLException{
        AnimalDAO dao = new AnimalDAO();
        if (!animal.getNome().equals(""))
            return dao.inserir(animal);
        else
            throw new CampoInvalidoException("nome do animal não pode ser vazio");
    }
    
    public boolean remover(Animal animal) throws ClassNotFoundException, SQLException{
        AnimalDAO dao = new AnimalDAO();
        return dao.remover(animal);
    }
    public List<Animal> pesquisar(String nome) throws ClassNotFoundException, SQLException{
        AnimalDAO dao = new AnimalDAO();
        
        if (nome.equals("")) //select geral para pesquisa vazia            
           return dao.listar("ativo = true");            
        else
            return dao.listar("nome = '" + nome + "' and ativo = true");
        
    }
    
     public boolean alterar(Animal animal) throws ClassNotFoundException, SQLException {
        AnimalDAO dao = new AnimalDAO();
        return dao.alterar(animal);
     }
    
  
    
}
