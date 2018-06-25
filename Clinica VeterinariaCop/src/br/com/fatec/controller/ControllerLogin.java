package br.com.fatec.controller;

import br.com.fatec.DAO.UsuarioDAO;
import br.com.fatec.excecoes.LoginInvalidoException;
import br.com.fatec.model.Usuario;
import br.com.fatec.view.FrmMenu;
import br.com.fatec.view.FrmPrimeiroAcesso;
import java.sql.SQLException;
import java.util.List;

public class ControllerLogin {
    private static Usuario user;
    
    public void logar(String login, String senha) 
            throws ClassNotFoundException, SQLException, LoginInvalidoException{
        
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        user.setLogin(login);
        user.setSenha(senha);
        user = dao.buscar(user);
        if (user != null){
            if (user.isPrimeiroAcesso()){
                this.user = user; //salva na estrutura
                //abre o primeiro acesso caso seja primeiro acesso
                FrmPrimeiroAcesso primeiroAcesso = new FrmPrimeiroAcesso();
                primeiroAcesso.setVisible(true);                
            }else{
                FrmMenu menu = new FrmMenu(user.getTipoConta());
                menu.setVisible(true);
            }
        }else
            throw new LoginInvalidoException();
    }
    
    public void redefinirLogin(String login, String senha) throws ClassNotFoundException, SQLException{
        Usuario novoLogin = new Usuario();
        //pega a pk do antigo
        novoLogin.setId(user.getId());
        novoLogin.setTipoConta(user.getTipoConta());
        novoLogin.setPrimeiroAcesso(false);
        novoLogin.setLogin(login);
        novoLogin.setSenha(senha);
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.alterar(novoLogin);
    }
    
    public List<Usuario> listarContasPorNome(String email) throws ClassNotFoundException, SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        if (!email.equals(""))
            return dao.listar("user like '%"+email+"%'");
        else
            return dao.listar("");
    }
    
    public void remover(Usuario usuario) throws ClassNotFoundException, SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        dao.remover(usuario);
    }
}
