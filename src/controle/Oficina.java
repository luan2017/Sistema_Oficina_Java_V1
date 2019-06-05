package controle; //pacote
// importando pacotes e classes
import entidade.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import entidade.Serviço;
import entidade.ManutençãoPneu;
import entidade.ManutençãoÓleo;
import entidade.ManutençãoSuspenção;
import entidade.ManutençãoSuspenção.Modelo;
import entidade.OrdemServiço;
import util.Data;
import util.PersistênciaArquivo;
import interfaces.EntradaSaída;
import static interfaces.EntradaSaída.mostrarMenu;

public class Oficina {         //classe principal
    
    
    private static final String arquivo = "Oficina.bds";
    
    public static void main(String[] args) {    //main principal
        recuperarSistema();
        mostrarMenu();        
        salvarSistema();        
    }                           
    
    //função para Filtrar ORDEM DE SERVIÇOS
    public static ArrayList<OrdemServiço> filtrarOrdemServiço (String string_inicial_mecanico, Modelo modelo,
                                    String marca, int tamanho_aro, char sexo, Data menorData){
        ArrayList<OrdemServiço> selecionados_serviços = new ArrayList();  //lista completa
        char sexofiltro = Character.toUpperCase(sexo);
        for(OrdemServiço item : OrdemServiço.listaOrdemServiço) {       //iniciando variavel itemServico
            if (string_inicial_mecanico != null //startsWith verifica se a variavel comeca com('');
                    && !item.getServiço().getMecanico().startsWith(string_inicial_mecanico)) {
                continue;
            }

            if(menorData != null && item.getServiço().getData().compareTo(menorData) < 0) {
                
                continue;
            }
            
            if(sexofiltro != 'X' && item.getCliente().getSexo() != sexofiltro) {
                continue;
            }
            
            // condicional para verificar as subclasses, se nao for do tipo pneu, verifica se e do tipo suspencao,
             // se nao for suspençao entao e do tipo oleo
            if(item.getServiço() instanceof ManutençãoPneu) {
               ManutençãoPneu itemModelo = (ManutençãoPneu) item.getServiço();
               if(tamanho_aro != -1 && tamanho_aro != itemModelo.getTamanho_aro()) {
                   continue;
               }

            }
            else if(item.getServiço() instanceof ManutençãoSuspenção) { //instanceof serve para comparar se e do tipo classe ou nao
                ManutençãoSuspenção itemModelo = (ManutençãoSuspenção) item.getServiço(); //duvida
               if(modelo != null && modelo != itemModelo.getModelo()) {
                   continue;
               }

            }
            else {
                ManutençãoÓleo itemModelo = (ManutençãoÓleo) item.getServiço();
                if(marca != null && !marca.equals(itemModelo.getMarca())) {
                   continue;
               }
            }
            // adiciona o objeto no arraylist do filtro caso seja compativel com os valores escolhidos

            selecionados_serviços.add(item);
        }
        
        return selecionados_serviços;
    }
    

        // FUNÇÃO PARA SALVAR APLICAÇÃO ORDEMSERVIÇO 
    public static void salvarSistema() {
        ArrayList aplicação_listaObject = new ArrayList();
        aplicação_listaObject.add(OrdemServiço.getOrdemServiço());
        aplicação_listaObject.add(Serviço.getServiços());
        aplicação_listaObject.add(Cliente.getClientes());
        PersistênciaArquivo.salvar(aplicação_listaObject, arquivo);
    }  
    
        // FUNÇÃO PARA RECUPERAR SISTEMA
    public static void recuperarSistema(){
        ArrayList aplicação_listaObject
                = (ArrayList) PersistênciaArquivo.recuperar(arquivo);
        if (aplicação_listaObject != null) {
            OrdemServiço.setOrdemServiço((ArrayList<OrdemServiço>) aplicação_listaObject.get(0));
            Serviço.setServiços((HashMap<Integer,Serviço>) aplicação_listaObject.get(1));
            Cliente.setClientes((HashMap<String,Cliente>) aplicação_listaObject.get(2));
        }
    }
    
}
    