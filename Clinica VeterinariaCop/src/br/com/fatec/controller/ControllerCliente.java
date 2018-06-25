package br.com.fatec.controller;

import br.com.fatec.DAO.AnimalDAO;
import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.excecoes.CampoInvalidoException;
import br.com.fatec.excecoes.ComboBoxInvalidoException;
import br.com.fatec.model.Animal;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Endereco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerCliente  {    
    
    
    public Cliente procurarAnimais(Cliente cliente) throws ClassNotFoundException, SQLException{       
        AnimalDAO dao = new AnimalDAO();
        List<Animal> animais = dao.listar("cliente_id = " + cliente.getId() + " and ativo=true");
        for (Animal animal : animais){            
            animal.setTutor(cliente);
            cliente.addAnimal(animal);
        }        
        return cliente;
    }
    
    /*
    
    * Cadastra o cliente no banco
    */
    public boolean cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException{
        //valida se todos os dados foram preenchidos
        validarDadosPreenchidos(cliente);
        return new ClienteDAO().inserir(cliente);
    }
    
    /*
    * procura cliente com nome ou cpf passado
    */
    public List<Cliente> listar(String nomeOuCpf) throws ClassNotFoundException, SQLException{
        List<Cliente> lista = new ArrayList();
        ClienteDAO dao = new ClienteDAO();
        
        if (nomeOuCpf.equals("")) //busca todos os dados            
            return dao.listar("ativo = true");
        else
          return dao.listar("(nome = '" + nomeOuCpf + "' or cpf = '"+nomeOuCpf+"') and ativo = true");              
    }
    
    /*
    * altera o objeto no banco pela PK (id)
    */
    public boolean alterar(Cliente obj) throws ClassNotFoundException, SQLException{
        //valida se todos os dados foram preenchidos
        validarDadosPreenchidos(obj);
        ClienteDAO dao = new ClienteDAO();
        return dao.alterar(obj);
    }
    
    /*
    * remove o cliente
    */
    public boolean remover(Cliente obj) throws ClassNotFoundException, SQLException{
        ClienteDAO dao = new ClienteDAO();
        return dao.remover(obj);
    }
    
    /*
    procura pelo cpf
    */
    
    public Cliente pesquisarPorCpf(Cliente cliente) throws ClassNotFoundException, SQLException{
        ClienteDAO dao = new ClienteDAO();
        for (Cliente c : dao.listar("cpf = '"+cliente.getCpf()+"' and ativo = true"))
            return c;
        return null;       
    }
    
    private void validarDadosPreenchidos(Cliente c){   
        if (c.getContato().equals(""))
            throw new CampoInvalidoException("Contato não pode ser vazio");
        if (c.getCpf().equals(""))
            throw new CampoInvalidoException("CPF não pode ser vazio");
        if (c.getEmail().equals(""))
            throw new CampoInvalidoException("Email não pode ser vazio");
        if (c.getNascimento()==null)
            throw new CampoInvalidoException("Nascimento não pode ser vazio");
        if (c.getNome().equals(""))
            throw new CampoInvalidoException("Nome não pode ser vazio");
        if (c.getRg().equals(""))
            throw new CampoInvalidoException("RG não pode ser vazio");
        if (c.getSexo()==null)
            throw new CampoInvalidoException("Sexo não pode ser vazio");      
        Endereco end = c.getEndereco();
        if (end.getEndereco().equals(""))
            throw new CampoInvalidoException("Endereço não pode ser vazio");  
        if (end.getCep().equals(""))
            throw new CampoInvalidoException("CEP não pode ser vazio");
        if (end.getNumero() == 0)
            throw new CampoInvalidoException("Numero não pode ser vazio");   
        if (end.getUF() == null)
            throw new ComboBoxInvalidoException("UF não pode ser vazio");   
        if (c.getNascimento() == null)
            throw new CampoInvalidoException("Data de Nascimento não pode ser vazio");   
    }
   
}
