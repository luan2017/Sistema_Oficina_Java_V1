package entidade;
import entidade.OrdemServiço;
import java.io.Serializable;
import java.util.ArrayList;

public class OrdemServiço implements Serializable{
    
    public static ArrayList<OrdemServiço> listaOrdemServiço = new ArrayList();

    public static void addOrdemServiço(OrdemServiço ordemserviço) {
        listaOrdemServiço.add(ordemserviço);
    }
    
    public static ArrayList<OrdemServiço> getOrdemServiço() {
        return OrdemServiço.listaOrdemServiço;
    }
    
    public static void setOrdemServiço(ArrayList<OrdemServiço> ordemserviço) {
        OrdemServiço.listaOrdemServiço = ordemserviço;
    }
    
    
    private Cliente cliente;
    private Serviço serviço;

    public OrdemServiço(Cliente cliente, Serviço serviço){
        this.cliente = cliente;
        this.serviço = serviço;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    public Serviço getServiço(){
        return serviço;
    }
    
    @Override
    public String toString() {
        return cliente.toString() + serviço.toString() + "\n";
    }
}
