package br.com.fatec.controller;

import br.com.fatec.DAO.ConsultaDAO;
import br.com.fatec.model.Animal;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Consulta;
import br.com.fatec.model.Veterinario;
import java.sql.SQLException;
import java.util.List;

public class ControllerConsulta {
    
    public Consulta criarConsulta(Veterinario vet, Data data, String hora, Animal animal, Cliente cliente){
        Consulta consulta = new Consulta();
        consulta.setAnimal(animal);
        consulta.setCliente(cliente);
        consulta.setData(data);
        consulta.setDiaDaSemana(Data.getDiaDaSemana(data.toString()));
        consulta.setHorario(hora);
        consulta.setVeterinario(vet);
        return consulta;
    }
    
    public boolean cadastrarConsulta(Consulta c) throws ClassNotFoundException, SQLException{
        ConsultaDAO dao = new ConsultaDAO();
        return dao.inserir(c);
    }
    
    public List<Consulta> pesquisarPorData(Data data) throws ClassNotFoundException, SQLException{
        ConsultaDAO dao = new ConsultaDAO();
        if (data == null)
            return dao.listar("");
        return dao.listar("data = '" + data.toSqlDate() + "'");
    }
    
    public boolean finalizarConsulta(Consulta c) throws ClassNotFoundException, SQLException{
        ConsultaDAO dao = new ConsultaDAO();
        c.setRealizado(true);
        return dao.alterar(c);
    }
    
    public boolean horarioVago(Data data, String horario) throws ClassNotFoundException, SQLException{
        ConsultaDAO dao = new ConsultaDAO();
        List<Consulta> consulta = dao.listar("data = '"+data.toSqlDate()+"' and horario = '"+horario+"'");
        
        return consulta.size() == 0;
    }
    
    public boolean desmarcar(Consulta c) throws SQLException, ClassNotFoundException{
        ConsultaDAO dao = new ConsultaDAO();
        return dao.remover(c);
    }
}
