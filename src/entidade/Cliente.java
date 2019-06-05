package entidade;

import java.io.Serializable;
import java.util.HashMap;


public class Cliente implements Serializable {
    
    private static HashMap<String,Cliente> listaCliente = new HashMap();

    public static void addCliente(Cliente cliente) {
        listaCliente.put(cliente.getCpf(), cliente);
    }
    
    public static HashMap<String, Cliente> getClientes() {
        return Cliente.listaCliente;
    }
    
    public static void setClientes(HashMap<String, Cliente> clientes) {
        Cliente.listaCliente = clientes;
    }
    
    private String nome;
    private String cpf;
    private char sexo;
    
    
    public Cliente ( String nome, String cpf, char sexo){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public char getSexo(){
        return sexo;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    public String toStringSexo(){
            if (sexo == 'M' || sexo == 'm')
                return "Masculino";
            if (sexo == 'F' || sexo == 'f')
                return "Feminino";
            
        return "indefinido";
    }
    
    @Override
    public String toString(){
        return "Nome Cliente : " + nome + " CPF : " + cpf + " Sexo : " + toStringSexo() + "\n" ;
    }      
}
