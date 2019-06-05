package entidade;

import java.io.Serializable;
import util.Data;

// extends : estou importando as eranças da minha classe Serviço ( classe principal)
public class ManutençãoSuspenção extends Serviço implements Serializable {
   
    public enum Modelo{original, paralelo};
     
    private Modelo modelo;
    private int tempo_serviço;
    
    
    public ManutençãoSuspenção(int numero, String mecanico, Data data, int tempo_serviço, Modelo modelo){
        super(numero, mecanico, data);
        this.tempo_serviço = tempo_serviço;
        this.modelo = modelo;
    }
    
    public Modelo getModelo(){
       return modelo;
    }

    public int getTempo_serviço(){
        return tempo_serviço;
    }
    
    @Override
    public String toString(){
        String dados_suspenção = " Ordem de serviço: " + " N°: " + numero + " Mecanico: " +
            mecanico + " Data: " + data + " Tempo de Serviço:  " + tempo_serviço + " horas" + 
            " Modelo : " + modelo;
     return dados_suspenção + "\n";
    }
}
