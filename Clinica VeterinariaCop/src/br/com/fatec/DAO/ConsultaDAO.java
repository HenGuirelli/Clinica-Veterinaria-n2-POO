package br.com.fatec.DAO;

import br.com.fatec.controller.Data;
import br.com.fatec.model.Animal;
import br.com.fatec.model.Consulta;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Veterinario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO implements DAO<Consulta>{
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Consulta obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "insert into consulta(data, horario, diaDaSemana, cliente, animal, realizado, veterinario)"
                + "values (?, ?, ?, ?, ?, ?, ?)";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setDate(1, obj.getData().toSqlDate());
        pst.setString(2, obj.getHorario());
        pst.setString(3, obj.getDiaDaSemana());
        pst.setInt(4, obj.getCliente().getId());
        pst.setInt(5, obj.getAnimal().getId());
        pst.setBoolean(6, obj.isRealizado());
        pst.setInt(7, obj.getVeterinario().getId());
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }

    @Override
    public boolean alterar(Consulta obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "UPDATE consulta SET data = ?, horario = ?, diaDaSemana = ?, cliente = ?, animal = ?, realizado = ?, observacao = ?"
                + " WHERE id = ?";
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setDate(1, obj.getData().toSqlDate());
        pst.setString(2, obj.getHorario());
        pst.setString(3, obj.getDiaDaSemana());
        pst.setInt(4, obj.getCliente().getId());
        pst.setInt(5, obj.getAnimal().getId());
        pst.setBoolean(6, obj.isRealizado());    
        pst.setString(7, obj.getObservacao());
        pst.setInt(8, obj.getId());
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }

    @Override
    public Consulta buscar(Consulta obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> listar(String where) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql;
        List<Consulta> lista = new ArrayList();
        
        if (where.equals(""))
            sql = "select * from consulta";
        else
            sql = "select * from consulta where " + where;
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()){
            System.out.println("entrou while");
            Consulta consulta = new Consulta();
            //falta preencher uns dados
            consulta.setData(new Data(rs.getDate("data")));
            consulta.setDiaDaSemana(rs.getString("diaDaSemana"));
            consulta.setHorario(rs.getString("horario"));
            consulta.setRealizado(rs.getBoolean("realizado"));
            consulta.setId(rs.getInt("id"));
            consulta.setObservacao(rs.getString("observacao"));
            //cria o cliente
            Cliente obj = new Cliente();
            obj.setId(rs.getInt("cliente"));
            //busca e adiciona o cliente no model
            consulta.setCliente(new ClienteDAO().buscar(obj));
            //cria o animal
            Animal animal = new Animal();
            animal.setId(rs.getInt("animal"));
            animal.setTutor(obj);
            consulta.setAnimal(new AnimalDAO().buscar(animal));
            //cria o veterinario
            Veterinario veterinario = new Veterinario();
            veterinario.setId(rs.getInt("veterinario"));
            consulta.setVeterinario(new VeterinarioDAO().buscar(veterinario));
            lista.add(consulta);
        }
        return lista;
    }

    @Override
    public boolean remover(Consulta obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "delete from consulta where id = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }
    
}
