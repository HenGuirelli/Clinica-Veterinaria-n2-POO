package br.com.fatec.DAO;

import br.com.fatec.Enum.EnumTipoConta;
import br.com.fatec.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Usuario obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "insert into usuario(user, senha, tipoConta, primeiroAcesso) values (?, ?, ?, ?)";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setString(1, obj.getLogin());
        pst.setString(2, obj.getSenha());
        pst.setString(3, obj.getTipoConta().toString());
        pst.setBoolean(4, true);
        
        if(pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }

    @Override
    public boolean alterar(Usuario user) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "update usuario set primeiroAcesso = ?, tipoConta = ?,"
                + "user = ?, senha = ? where id = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setBoolean(1, user.isPrimeiroAcesso());
        pst.setString(2, user.getTipoConta().toString());
        pst.setString(3, user.getLogin());
        pst.setString(4, user.getSenha());
        pst.setInt(5, user.getId());
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }

    @Override
    public Usuario buscar(Usuario user) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "select * from usuario where user = ? and senha = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setString(1, user.getLogin());
        pst.setString(2, user.getSenha());
        rs = pst.executeQuery();
        Usuario usuario = new Usuario();
        if (rs.next()){
            usuario.setLogin(rs.getString("user"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPrimeiroAcesso(rs.getBoolean("primeiroAcesso"));    
            usuario.setTipoConta(EnumTipoConta.toEnum(rs.getString("tipoConta")));
            usuario.setId(rs.getInt("id"));
        }else
            usuario = null;
        
        Banco.desconectar();
        return usuario;
    }

    @Override
    public List<Usuario> listar(String where) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql;
        List<Usuario> lista = new ArrayList();
        if (where.equals(""))
            sql = "select * from usuario";
        else
            sql = "select * from usuario where " + where;
        
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()){
            Usuario user = new Usuario();
            user.setLogin(rs.getString("user"));
            user.setSenha(rs.getString("senha"));
            lista.add(user);
        }
        return lista;
    }

    @Override
    public boolean remover(Usuario obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "delete from usuario where user = '"+obj.getLogin()+"' and senha = '"+obj.getSenha()+"'";
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }
    
}
