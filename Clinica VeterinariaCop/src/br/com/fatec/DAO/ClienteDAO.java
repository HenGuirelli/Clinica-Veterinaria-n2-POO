package br.com.fatec.DAO;

import br.com.fatec.Enum.EnumSexo;
import br.com.fatec.Enum.EnumUF;
import br.com.fatec.controller.Data;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente>{

    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Cliente cliente) 
            throws ClassNotFoundException, SQLException {
      
        String sql = "insert into cliente(nome, cpf, rg, sexo, nascimento, contato, email, endereco, cep, numero, uf) values( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
        Banco.conectar();
        
        pst = Banco.getConexao().prepareStatement(sql);
        //preencher os parametros do SQL
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getCpf());
        pst.setString(3, cliente.getRg());
        pst.setString(4, cliente.getSexo().toString());
        pst.setDate(5, cliente.getNascimento().toSqlDate());
        pst.setString(6, cliente.getContato());
        pst.setString(7, cliente.getEmail());
        pst.setString(8, cliente.getEndereco().getEndereco());
        pst.setString(9, cliente.getEndereco().getCep());
        pst.setInt(10, cliente.getEndereco().getNumero());    
        pst.setString(11, cliente.getEndereco().getUF().toString());
        
        //executar comando SQL
        if (pst.executeUpdate() == 0) { //não alterou
            Banco.desconectar();
            return false;
        } else {
            Banco.desconectar();
            return true;
        }
        
        
    }

    @Override
    public boolean alterar(Cliente obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "UPDATE cliente SET nome=?, cpf=?, rg=?, sexo=?, nascimento=?, contato=?, email=?, endereco=?, cep=?, numero=?, uf=?"
                + " WHERE id = ?";
        
        pst = Banco.getConexao().prepareStatement(sql);
        //preencher os parametros do SQL
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getSexo().toString());
        pst.setDate(5, obj.getNascimento().toSqlDate());
        pst.setString(6, obj.getContato());
        pst.setString(7, obj.getEmail());
        pst.setString(8, obj.getEndereco().getEndereco());
        pst.setString(9, obj.getEndereco().getCep());
        pst.setInt(10, obj.getEndereco().getNumero());    
        pst.setString(11, obj.getEndereco().getUF().toString());
        pst.setInt(12, obj.getId());
       
        if(pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }

    @Override
    public Cliente buscar(Cliente obj) throws ClassNotFoundException, SQLException {
        Cliente c;        
        Banco.conectar();        
        String sql = "select * from cliente where id = ?";        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        
        rs = pst.executeQuery();
        
        if (rs.next())
            //usa o metodo privado para popular o model
            c = popular(rs); 
        else
            c = null;
        
        Banco.desconectar();
        return c;
    }
    
    @Override
    public List<Cliente> listar(String criterio) throws ClassNotFoundException, SQLException{
        List<Cliente> lista = new ArrayList();
        
        Banco.conectar();    
        String sql;
        if (!criterio.equals(""))
             sql = "select * from cliente where " + criterio;   
        else
            sql = "select * from cliente";
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while (rs.next())
            //usa o metodo privado para popular o model
            lista.add(popular(rs));
        
        Banco.desconectar();
        return lista;
        
    }
    
    @Override
    public boolean remover(Cliente obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "update cliente set ativo = false where id  = ?";
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
    
    //metodos privados
    private Cliente popular(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        
        c.setId(rs.getInt("id"));
        c.setCpf(rs.getString("cpf"));
        c.setContato(rs.getString("contato"));
        c.setEmail(rs.getString("email"));
        c.setNascimento(new Data(rs.getDate("nascimento")));
        c.setNome(rs.getString("nome"));
        c.setRg(rs.getString("rg"));
        c.setSexo(EnumSexo.toEnum(rs.getString("sexo").charAt(0)));
        Endereco end = new Endereco();
        end.setCep(rs.getString("cep"));
        end.setEndereco(rs.getString("endereco"));
        end.setNumero(rs.getInt("numero"));
        end.setUF(EnumUF.toEnum(rs.getString("uf")));
        c.setEndereco(end);
        
        return c;
    }

    
    
    
}
