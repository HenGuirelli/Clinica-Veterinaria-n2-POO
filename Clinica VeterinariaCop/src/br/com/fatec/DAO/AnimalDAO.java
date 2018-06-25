package br.com.fatec.DAO;

import br.com.fatec.controller.Data;
import br.com.fatec.model.Animal;
import br.com.fatec.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements DAO<Animal>{
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean inserir(Animal animal) throws ClassNotFoundException, SQLException {
        String sql = "insert into animal (cliente_id, nome, raca, especie, nascimento) values(?, ?, ?, ?, ?)";
        Banco.conectar();
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, animal.getTutor().getId());
        pst.setString(2, animal.getNome());
        pst.setString(3, animal.getRaca());
        pst.setString(4, animal.getEspecie());
        if (animal.getNascimento() != null)
            pst.setDate(5, animal.getNascimento().toSqlDate());    
        else
            pst.setDate(5, null);
        
        if(pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }        
    }

    @Override
    public boolean alterar(Animal obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "UPDATE animal set nome=?, raca=?, especie=?, nascimento=?"
                + " WHERE id = ?";
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getRaca());
        pst.setString(3, obj.getEspecie());
        pst.setDate(4, obj.getNascimento().toSqlDate());
        pst.setInt(5, obj.getId());
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }
    
    /*
    busca o animal pelo nome a tutor(cpf)    
    */
    @Override
    public Animal buscar(Animal animal) throws ClassNotFoundException, SQLException {
        Animal a;
        Banco.conectar();
        String sql = "select * from animal where id = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        
        pst.setInt(1, animal.getId()); // fk
        
        rs = pst.executeQuery();
        
        if (rs.next())
            a = popularAnimal(rs);
        else
            a = null;
        
        Banco.desconectar();
        
        return a;
    }
    
    @Override
    public List<Animal> listar(String where) throws ClassNotFoundException, SQLException {
        String sql;
        List <Animal> animais = new ArrayList();
        if (where.equals(""))
            sql = "select * from animal";
        else
            sql = "select * from animal where " + where;
        
        Banco.conectar();
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next())
            animais.add(popularAnimal(rs));
        
        Banco.desconectar();
        
        return animais;
        
    }
    
    @Override
    public boolean remover(Animal obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "update animal set ativo=false where id = ?";
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

    private Animal popularAnimal(ResultSet rs) throws SQLException, ClassNotFoundException {
        Animal animal = new Animal();        
        //popula e retorna o moel populado
        animal.setId(rs.getInt("id"));
        animal.setEspecie(rs.getString("especie"));
        animal.setNascimento(new Data(rs.getDate("nascimento")));
        animal.setNome(rs.getString("nome"));
        animal.setRaca(rs.getString("raca"));
        
        //select especial para popular o tutor
        int id = rs.getInt("cliente_id");
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente = dao.buscar(cliente);
        animal.setTutor(cliente);
        return animal;
        
    }

    
    
}
