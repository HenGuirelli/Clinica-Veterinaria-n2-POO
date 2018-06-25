package br.com.fatec.controller;

import br.com.fatec.DAO.UsuarioDAO;
import br.com.fatec.DAO.VeterinarioDAO;
import br.com.fatec.Enum.EnumTipoConta;
import br.com.fatec.excecoes.CampoInvalidoException;
import br.com.fatec.excecoes.ComboBoxInvalidoException;
import br.com.fatec.excecoes.DataInvalidaException;
import br.com.fatec.model.Endereco;
import br.com.fatec.model.Usuario;
import br.com.fatec.model.Veterinario;
import java.sql.SQLException;
import java.util.List;

public class ControllerVeterinario {
    public void cadastrar(Veterinario veterinario) throws ClassNotFoundException, SQLException{
        validarDadosPreenchidos(veterinario);
        //cadastra o veterinario no banco
        new VeterinarioDAO().inserir(veterinario);
        //cadastra uma conta pra ele
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        user.setLogin(veterinario.getEmail());
        user.setSenha("123");
        user.setTipoConta(EnumTipoConta.veterinario);
        dao.inserir(user);
    }
    
    /*    
    Pesquisa pelo nome ou cpf do veterinario
    */
    public List<Veterinario> pesquisar(String nomeOuCpf) throws ClassNotFoundException, SQLException{      
        VeterinarioDAO dao = new VeterinarioDAO();
        if (!nomeOuCpf.equals(""))
             return dao.listar("(nome = '" + nomeOuCpf + "' or cpf = '" + nomeOuCpf + "') and ativo = true");
        else
            return dao.listar("ativo = true");
    }    
    
    /*
    Alterar veterinario o banco
    */
    public boolean alterar(Veterinario obj) throws ClassNotFoundException, SQLException{
        VeterinarioDAO dao = new VeterinarioDAO();
        return dao.alterar(obj);
    }
    
    /*
    remove o veterinario pelo ID
    */
    public boolean remover(Veterinario obj) throws ClassNotFoundException, SQLException{
        VeterinarioDAO dao = new VeterinarioDAO();
        return dao.remover(obj);
    }
    
    /*
    Pesquisa pelo CPF
    */
    public Veterinario pesquisarPorCpf(Veterinario veterinario) throws ClassNotFoundException, SQLException{
        List<Veterinario> resp = new VeterinarioDAO().listar("cpf = '"+ veterinario.getCpf() +"' and ativo = true");
        for (Veterinario vet : resp){
            return vet;
        }
        return null;
    }
   
    private void validarDadosPreenchidos(Veterinario v){
        if (v.getContato().equals(""))
            throw new CampoInvalidoException("Contato não pode ser vazio");
        if (v.getCpf().equals(""))
            throw new CampoInvalidoException("CPF não pode ser vazio");
        if (v.getEmail().equals(""))
            throw new CampoInvalidoException("Email não pode ser vazio");
        if (v.getNascimento()==null)
            throw new DataInvalidaException("Data de nascimento não pode ser vazio");
        if (v.getNome().equals(""))
            throw new CampoInvalidoException("Nome não pode ser vazio");
        if (v.getRg().equals(""))
            throw new CampoInvalidoException("RG não pode ser vazio");
        if (v.getSexo()==null)
            throw new CampoInvalidoException("Sexo não pode ser vazio");      
        Endereco end = v.getEndereco();
        if (end.getEndereco().equals(""))
            throw new CampoInvalidoException("Endereço não pode ser vazio");  
        if (end.getCep().equals(""))
            throw new CampoInvalidoException("CEP não pode ser vazio");
        if (end.getNumero() == 0)
            throw new CampoInvalidoException("Numero não pode ser vazio");   
        if (end.getUF() == null)
            throw new ComboBoxInvalidoException("UF não pode ser vazio");   
        if (v.getNascimento() == null)
            throw new CampoInvalidoException("Data de Nascimento não pode ser vazio");   
        
        //dados especificos do veterinario
        if(v.getEspecializacao() == null)
            throw new ComboBoxInvalidoException("Especializacao não pode ser vazio");   
        if (v.getPis().equals(""))
            throw new CampoInvalidoException("PIS não pode ser vazio");   
        if (v.getTurno()==null)
            throw new ComboBoxInvalidoException("Turno não pode ser vazio");   
    }
}
