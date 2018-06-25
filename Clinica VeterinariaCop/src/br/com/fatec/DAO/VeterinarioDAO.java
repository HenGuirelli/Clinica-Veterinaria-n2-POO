package br.com.fatec.DAO;

import br.com.fatec.Enum.EnumEspecializacao;
import br.com.fatec.Enum.EnumSexo;
import br.com.fatec.Enum.EnumTurno;
import br.com.fatec.Enum.EnumUF;
import br.com.fatec.controller.Data;
import br.com.fatec.model.Endereco;
import br.com.fatec.model.Veterinario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO implements DAO<Veterinario>{
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Veterinario obj) throws ClassNotFoundException, SQLException {
       String sql = "insert into veterinario( "
               + "nome, cpf, rg, sexo, nascimento, contato ,email,endereco,cep ,"
               + "numero, uf, especializacao, pis, turno, plantao, atendimento, cirurgiao) values("
               + "?, ?, ? ,? ,?,? ,?,?,? ,"
               + "?,? ,?,? ,? , ? ,?, ?)"; 
       Banco.conectar();
       pst = Banco.getConexao().prepareStatement(sql);
       pst.setString(1, obj.getNome());
       pst.setString(2, obj.getCpf());
       pst.setString(3, obj.getRg());
       pst.setString(4, obj.getSexo() + "");
       pst.setDate(5, obj.getNascimento().toSqlDate());
       pst.setString(6, obj.getContato());
       pst.setString(7, obj.getEmail());
       pst.setString(8, obj.getEndereco().getEndereco());
       pst.setString(9, obj.getEndereco().getCep());
       pst.setInt(10, obj.getEndereco().getNumero());
       pst.setString(11, obj.getEndereco().getUF().toString());
       pst.setString(12, obj.getEspecializacao().toString());
       pst.setString(13, obj.getPis());
       pst.setString(14, obj.getTurno().toString());
       pst.setBoolean(15, obj.isPlantao());
       pst.setString(16, obj.getAtendimento());
       pst.setBoolean(17, obj.isCirurgiao());
       
       if (pst.executeUpdate() == 0){
           Banco.desconectar();
           return false;
       }else{
           Banco.desconectar();
           return true;
       }
       
    }

    @Override
    public boolean alterar(Veterinario obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "UPDATE veterinario set "
               + "nome, cpf, rg, sexo, nascimento, contato, email, endereco, cep,"
               + "numero, uf, especializacao, pis, turno, plantao, atendimento, cirurgiao=?"
               + " WHERE id = ?";
        sql = sql.replaceAll(",", "=?,");
        
        pst = Banco.getConexao().prepareStatement(sql);
        Endereco end = obj.getEndereco();
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getSexo().toString());
        pst.setDate(5, obj.getNascimento().toSqlDate());
        pst.setString(6, obj.getContato());
        pst.setString(7, obj.getEmail());
        pst.setString(8, end.getEndereco());
        pst.setString(9, end.getCep());
        pst.setInt(10, end.getNumero());
        pst.setString(11, end.getUF().toString());
        pst.setString(12, obj.getEspecializacao().toString());
        pst.setString(13, obj.getPis());
        pst.setString(14, obj.getTurno().toString());
        pst.setBoolean(15, obj.isPlantao());
        pst.setString(16, obj.getAtendimento());
        pst.setBoolean(17, obj.isCirurgiao());
        pst.setInt(18, obj.getId());
        
        if(pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }        
    }

    @Override
    public Veterinario buscar(Veterinario obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "select * from veterinario where id = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        
        rs = pst.executeQuery();
        Veterinario vet = null;
        
        if (rs.next())
            vet = popularVet(rs);            
        Banco.desconectar();
        return vet;
    }

    @Override
    public List<Veterinario> listar(String where) throws ClassNotFoundException, SQLException {
        List<Veterinario> lista = new ArrayList();
        
        Banco.conectar();
        String sql;
        if (!where.equals(""))
            sql = "select * from veterinario where " + where;
        else
            sql = "select * from veterinario";
        
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()){
            Veterinario vet = popularVet(rs);
            //popula a lista
            lista.add(vet);            
        }
        
        Banco.desconectar();
        return lista;
    }

    @Override
    public boolean remover(Veterinario obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "update veterinario set ativo = false where id = ?";
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
    
    private Veterinario popularVet(ResultSet rs) throws SQLException{
        Veterinario vet = new Veterinario();
        Endereco endereco = new Endereco();
        endereco.setCep(rs.getString("cep"));
        endereco.setEndereco(rs.getString("endereco"));
        endereco.setNumero(rs.getInt("numero"));
        endereco.setUF(EnumUF.toEnum(rs.getString("uf")));

        vet.setEndereco(endereco);
        vet.setId(rs.getInt("id"));
        vet.setAtendimento(rs.getString("atendimento"));
        vet.setCirurgiao(rs.getBoolean("cirurgiao"));
        vet.setContato(rs.getString("contato"));
        vet.setCpf(rs.getString("cpf"));
        vet.setEmail(rs.getString("email"));
        vet.setEspecializacao(EnumEspecializacao.toEnum(rs.getString("especializacao")));
        vet.setNascimento(new Data(rs.getDate("nascimento")));
        vet.setNome(rs.getString("nome"));
        vet.setPis(rs.getString("pis"));
        vet.setPlantao(rs.getBoolean("plantao"));
        vet.setRg(rs.getString("rg"));
        vet.setSexo(EnumSexo.toEnum(rs.getString("sexo").charAt(0)));
        vet.setTurno(EnumTurno.toEnum(rs.getString("turno")));
        return vet;
    }
}
