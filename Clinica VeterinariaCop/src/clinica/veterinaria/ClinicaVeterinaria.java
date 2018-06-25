package clinica.veterinaria;

import br.com.fatec.DAO.AnimalDAO;
import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.Enum.EnumSexo;
import br.com.fatec.Enum.EnumUF;
import br.com.fatec.controller.Data;
import br.com.fatec.excecoes.DataInvalidaException;
import br.com.fatec.model.Animal;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Endereco;
import br.com.fatec.view.FrmLogin;
import br.com.fatec.view.FrmMenu;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClinicaVeterinaria {

    /**
     * @param args the command line arguments
     */
    public static void clienteDAOInserir(){
        try{
            //Banco.conectar();
            Cliente cliente = new Cliente();
            cliente.setContato("contato");
            cliente.setCpf("81273921");
            cliente.setEmail("email");
            cliente.setNascimento(new Data("08/06/2018"));
            cliente.setNome("nome");
            cliente.setRg("21739712");
            cliente.setSexo(EnumSexo.M);
            
            Endereco endereco = new Endereco();
            endereco.setCep("827310293");
            endereco.setNumero(481);
            endereco.setUF(EnumUF.DF);
            endereco.setEndereco("endereço po");
            cliente.setEndereco(endereco);
            
            ClienteDAO c = new ClienteDAO();
            c.inserir(cliente);
            
            //Banco.desconectar();
        }catch(ClassNotFoundException e){
            System.out.println("erro " + e.getMessage());
        }catch(SQLException e){
            System.out.println("erro2\n" + e.getMessage());
        }catch(DataInvalidaException e){
            System.out.println("data");
        }
    }
    
    private static void clienteDAOBuscar(){
        try{
            Cliente cliente = new Cliente();
            cliente.setCpf("81273921");
            
            ClienteDAO c = new ClienteDAO();
            cliente= c.buscar(cliente);
            System.out.println(cliente.getEndereco().getCep());
            
            //Banco.desconectar();
        }catch(ClassNotFoundException e){
            System.out.println("erro " + e.getMessage());
        }catch(SQLException e){
            System.out.println("erro2\n" + e.getMessage());
        }catch(DataInvalidaException e){
            System.out.println("data");
        }
    }
    
    private static void clienteDAOListar(){
        try {
            List<Cliente> lista = new ClienteDAO().listar("1=1");
            for(Cliente c : lista){
                System.out.println(c.getNome());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClinicaVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private static void AnimalDAOInserir(){
        try {
            AnimalDAO animaldao = new AnimalDAO();
            Animal animal = new Animal();
            animal.setEspecie("especie");
            animal.setNascimento(new Data("09/06/2018"));
            animal.setNome("nome animal");
            animal.setRaca("raça");
            Cliente c = new Cliente();
            c.setCpf("81273921");
            animal.setTutor(c);
            
            animaldao.inserir(animal);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClinicaVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void abrirSistema(){
        FrmLogin frame = new FrmLogin();
        frame.main(new String[0]);
    }
    public static void main(String[] args) {
        //clienteDAOTest();
        //clienteDAOBuscar();
        //clienteDAOListar();
        //Data data = new Data("08/06/2018");
        //System.out.println(data.toDate());
        //System.out.println(data);
        //AnimalDAOInserir();
       //abrirSistema();
       //String dataAtual = new Data(new Date(System.currentTimeMillis())).toString();
       // System.out.println(dataAtual);
        //Calendar cal = Calendar.getInstance();
        //pega data atual
        //cal.setTime(new Date(System.currentTimeMillis()));
        //System.out.println(cal.getTime());
        //FrmMenu.main(new String[0]);
        FrmLogin.main(new String[0]);
        //System.out.println(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir "));
        
    }
    
}
