/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.Enum.EnumTipoExame;
import br.com.fatec.model.Exame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrique
 */
public class ExameDAO implements DAO<Exame>{
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Exame obj) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        String sql = "insert into exame(tutor, animal, exame, observacao) values (?, ?, ?, ?)";
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setString(1, obj.getTutor().getCpf());
        pst.setString(2, obj.getAnimal().getNome());
        pst.setString(3, obj.getTipo().toString());
        pst.setString(4, obj.getObservacao());
        
        if (pst.executeUpdate() == 0){
            Banco.desconectar();
            return false;
        }else{
            Banco.desconectar();
            return true;
        }
    }

    @Override
    public boolean alterar(Exame obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Exame buscar(Exame obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exame> listar(String where) throws ClassNotFoundException, SQLException {
        Banco.conectar();
        List<Exame> exames = new ArrayList();
        String sql = "";
        if (where.equals(""))
            sql = "select * from exame";
        else
            sql = "select * from exame where " + where;
        
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()){
            Exame exame = new Exame();
            exame.setTipo(EnumTipoExame.toEnum(rs.getString("exame")));
            exame.setObservacao(rs.getString("observacao"));
            exames.add(exame);
        }
        
        Banco.desconectar();
        return exames;
    }

    @Override
    public boolean remover(Exame obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
