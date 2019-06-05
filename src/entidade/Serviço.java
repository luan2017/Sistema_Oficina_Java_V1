package entidade;

import java.io.Serializable;
import util.Data;
import java.util.ArrayList;
import java.util.HashMap;

//ArrayList de serviços = listaServiço;

public class Serviço implements Serializable{      //classe principal
    
    private static HashMap<Integer,Serviço> listaServiço = new HashMap();

    public static void addServiço(Serviço serviço) {
        listaServiço.put(serviço.getNumero(), serviço);
    }
    
    public static HashMap<Integer, Serviço> getServiços() {
        return Serviço.listaServiço;
    }
    
    public static void setServiços(HashMap<Integer, Serviço> serviços) {
        Serviço.listaServiço= serviços;
    }
    
    protected int numero;           //protected : posso acessar pela classe e subclasse somente
    protected String mecanico;
    protected Data data;
    
    public Serviço( int numero, String mecanico, Data data){
        this.numero = numero;
        this.mecanico = mecanico;
        this.data = data;       
    }
    
    public int getNumero(){
        return numero;
    }
    public String getMecanico(){
        return mecanico;
    }
    public Data getData() {
        return data;
    }
   
    @Override
    public String toString() {
        String dadosServiço = "Numero : " + numero + "\n Mecanico : " + mecanico + 
                " Data : " + data + "\n";
        return dadosServiço + "\n";        
    }
            
}
