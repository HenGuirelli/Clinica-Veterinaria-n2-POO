package br.com.fatec.controller;

import br.com.fatec.DAO.ExameDAO;
import br.com.fatec.Enum.EnumTipoExame;
import br.com.fatec.model.Animal;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Exame;
import java.sql.SQLException;

public class ControllerExame {
    
    public Exame criarExame(Animal animal, Cliente tutor, EnumTipoExame tipoExame, String observacao){
        Exame exame = new Exame();
        exame.setAnimal(animal);
        exame.setObservacao(observacao);
        exame.setTipo(tipoExame);
        exame.setTutor(tutor);
        return exame;
    }
    
    public boolean cadastrarExame(Exame exame) throws ClassNotFoundException, SQLException{
        ExameDAO dao = new ExameDAO();
        return dao.inserir(exame);
    }
}
