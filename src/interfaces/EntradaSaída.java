package interfaces;

import entidade.Cliente;
import entidade.ManutençãoPneu;
import entidade.ManutençãoSuspenção;
import entidade.ManutençãoSuspenção.Modelo;
import entidade.ManutençãoÓleo;
import entidade.OrdemServiço;
import entidade.Serviço;
import controle.Oficina;
import util.Data;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class EntradaSaída {
    
     public static void mostrarMenu(){
        int selecionar = 0;
        Scanner ler = new Scanner(System.in);
        while (selecionar != 8){
            System.out.println("\nEntre com a opção do Menu de 1 a 8: \n");
            System.out.println("|1|- CADASTRAR CLIENTE \n"
                             + "|2|- CADASTRAR SERVIÇO \n"
                             + "|3|- CADASTRAR ORDEM SERVIÇO \n"
                             + "|4|- IMPRIMIR CLIENTES \n"
                             + "|5|- IMPRIMIR SERVIÇOS \n"
                             + "|6|- IMPRIMIR ORDENS DE SERVIÇOS \n"
                             + "|7|- FILTRAR E IMPRIMIR ORDENS DE SERVIÇO \n"
                             + "|8|- SAIR ");
            selecionar = ler.nextInt();
        
            switch(selecionar){
                case 1: {
                    System.out.println(" ENTRANDO NO CADASTRO DE CLIENTE... ");
                        loopLeituraClientes();
                        //1imprimirCliente("",Cliente.getClientes());
                    break;
                }
                case 2: {
                    System.out.println("ENTRANDO NO CADASTRO DE SERVIÇO...");
                    loopLeituraServiços();
                    break;
                }
                 case 3: {
                    System.out.println("ENTRANDO NO CADASTRO DE ORDEM DE SERVIÇO...");
                    loopLeituraOrdemServiços();
                    break;
                }
                 case 4: {
                    System.out.println("IMPRIMINDO CLIENTES CADASTRADOS...");
                    imprimirCliente("",Cliente.getClientes());
                    break;
                }
                 case 5: {
                    System.out.println("IMPRIMINDO SERVIÇOS CADASTRADOS...");
                    imprimirServiço("",Serviço.getServiços());
                    break;
                }
                 case 6: {
                    System.out.println("IMPRIMINDO ORDENS DE SERVIÇOS...");
                    imprimirOrdemServiço("",OrdemServiço.getOrdemServiço());
                    break;
                }
                 case 7: {
                    System.out.println("FILTRANDO ORDENS DE SERVIÇO...");
                    System.out.println("\n\nESCOLHA DOS VALORES DO FILTRO:\n");
                    imprimirOrdemServiço("", selecionarOrdemServiços());
                          
                    //imprimirOrdemServiço("",OrdemServiço.getOrdemServiço());
                           
                    break;
                }            
                 case 8: {
                    System.out.println("vOCE SAIU, VOLTE MAIS VEZES!");
                    break;
                } 

                 default:
                  System.out.println("Opção Inválida");                  
            }
        }
    }  
        
        //FUNÇÃO LOOP CLIENTES
    public static void loopLeituraClientes() {
       System.out.println();
       boolean continuar = true;
       if (!continuar) {
           return;
       }
       System.out.println("\n -- Leitura de dados dos Clientes ---");
       while (continuar) {
           Cliente informadoCliente = lerCliente();
           if (informadoCliente != null) {
               Cliente.addCliente(informadoCliente);
               System.out.println("\nCliente Cadastrado : \n");
               System.out.println(informadoCliente);
           }else {
               System.out.println(" # Erro na leitura do Cliente\n");
           }
           continuar = lerBoolean("se quer continuar");
           if (!continuar) {
               break;                
           }
       }
    }
    
    //FUNÇÃO LOOP SERVIÇOS
    public static void loopLeituraServiços() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) {
            return;
        }
        System.out.println("\n -- Leitura de dados de Serviços ---");
        while (continuar) {
            Serviço informadoServiço = lerServiço();
            if (informadoServiço != null) {
                Serviço.addServiço(informadoServiço);
                System.out.println("\nServico Cadastrado : \n");
                System.out.println(informadoServiço);
            }else {
                System.out.println(" # Erro na leitura do Serviço\n");
            }
            continuar = lerBoolean("se quer continuar");
            if (!continuar) {
                break;                
            }
        }
    }
    
    //FUNÇÃO PARA O LOOP DE ORDEM DE SERVIÇOS 
    public static void loopLeituraOrdemServiços() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) {
            return;
        }
        System.out.println("\n -- Leitura de dados de Ordens de Serviços ---");
        while (continuar) {
            OrdemServiço informadoOrdemServiço = lerOrdemServiço();
            if (informadoOrdemServiço != null) {
                OrdemServiço.addOrdemServiço(informadoOrdemServiço);
                System.out.println("\n Ordem de Servico Cadastrada : \n");
                System.out.println(informadoOrdemServiço);
            }else {
                System.out.println(" # Erro na leitura da Ordem de Serviço\n");
            }
            continuar = lerBoolean("se quer continuar");
            if (!continuar) {
                break;                
            }
        }
    }
    
    
        // FUNÇÃO PARA LER OS DADOS DO CLIENTE
        private static Cliente lerCliente() {
        String nome = lerString("Nome do Cliente");
            if (nome == null) {
               return null;
        }
        
        String cpf = lerString("Cpf do Cliente");
            if (cpf == null) {
               return null;
        }
        char sexo = lerChar("Informe o Sexo do Cliente");
            if (sexo == 'X') {
               return null;
        }
        return new Cliente(nome, cpf, sexo);
    }
        
        
     //FUNÇÃO PARA LER OS SERVIÇOS
    private static Serviço lerServiço() {
        int numero = lerInteiroPositivo(" \nInforme o Número do serviço");
        if (numero == -1) {
            return null;
        }
        String mecanico = lerString("Informe o Nome do mecânico");
        if (mecanico == null) {
                
            return null;
        }
        Data data = lerData("Data do serviço");
        if (data == null) {
            return null;
        }
        String tipo_serviço = lerString ("Tipo de Serviço de manutenção [P: Pneus"
                + " - S: Suspenção - O: Óleo]");
        if (tipo_serviço == null) {
            return null;
        }
        if (tipo_serviço.equals("P")) {
            boolean novo = lerBoolean("se o Pneu e novo :"); // criar BOOleano
        
            int tamanho_aro = lerInteiroPositivo("Tamanho do Aro");
            if (tamanho_aro == -1) {
               return null;
            }
            return new ManutençãoPneu(numero, mecanico, data, novo, tamanho_aro);
        }
        if (tipo_serviço.equals("S")) {
          Modelo modelo = lerModelo();
            if (modelo == null) {
                return null;
            }
          int tempo_serviço = lerInteiroPositivo("Tempo de serviço");
            if (tempo_serviço == -1) {
                return null;
            }
            return new ManutençãoSuspenção(numero, mecanico, data, tempo_serviço, modelo );
        }
        if (tipo_serviço.equals("O")){
            String marca = lerString("Marca do Óleo");
                if (marca == null) {
                    return null;
                }
            int quantidade = lerInteiroPositivo("Quantidade de óleos");
                if (quantidade == -1) {
                   return null;
                }
            return new ManutençãoÓleo(numero, mecanico, data, marca, quantidade);
        }
        return null;
    }   
    
         //FUNÇÃO PARA O LER ORDEM DE SERVIÇOS 
        public static OrdemServiço lerOrdemServiço() {
        String cpf = lerString("o cpf do cliente da Ordem de serviço");
            if(cpf == null || Cliente.getClientes().get(cpf) == null) {
                return null;
            }

        int numero = lerInteiroPositivo("Numero do Serviço"); 
            if(numero == -1 || Serviço.getServiços().get(numero) == null) {
                return null;
            }
        
        return new OrdemServiço(Cliente.getClientes().get(cpf), Serviço.getServiços().get(numero));
    }
        
    
    // FUNÇÃO PARA LER STRING
   private static String lerString(String dado) {
        BufferedReader entradaBufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        System.out.print(" - Informe " + dado + " : ");
        try {
            string = entradaBufferedReader.readLine();
            if (string.isEmpty()) {
                return null;
            }
        } catch (IOException exceção) {
            System.out.println("\n # Erro na leitura de: " + dado);
            return null;
        }
        return string;
    }
   
   // FUNÇÃO PARA LER INTEIRO
    private static int lerInteiroPositivo(String dado) {
        String inteiro_positivo_string = lerString(dado);
        if (inteiro_positivo_string == null) {
            return -1;
        }
        int inteiro_positivo = 0;
        try {
            inteiro_positivo = Integer.valueOf(inteiro_positivo_string).intValue();
        } catch (NumberFormatException exceção) {
            System.out.println("\n # Erro na conversão para inteiro de: " + dado);
            return -1;
        }
        return inteiro_positivo;
    }
    
    // FUNÇÃO PARA LER BOOLEANO
     private static boolean lerBoolean(String dado) {
        String string_lido = lerString(dado + " [S: sim -  N: não]");
        if (string_lido == null) {
            return false;
        }
        if (string_lido.equals("S")) {
            return true;
        }
        return false;
    }
     
     // FUNÇÃO PARA LER CARACTERES
     private static char lerChar(String dado) {
        String string_lido = lerString(dado);
        if ((string_lido == null) || (string_lido.length() != 1)) {
            return 'X';
        }
        return string_lido.charAt(0);
    }
     
     // FUNÇÃO PARA LER A DATA
      private static Data lerData(String dado) {
        String data_string = lerString(dado + " [dd/mm/aaaa]");
        if (data_string == null) {
            return null;
        }
        return Data.toData(data_string);
    }
      
      
    private static Modelo lerModelo(){
        String modelo = lerString("Modelo de Suspenção [O: Original - P: Paralelo]");
        if (modelo == null) {
            return null;
        }
        if (modelo.equals("O")) {
            return Modelo.original;
        }else if (modelo.equals("P")) {
            return Modelo.paralelo;
        }else {
            return null;
        }
    }
    
    public static ArrayList<OrdemServiço> selecionarOrdemServiços() {
        System.out.println();
        if (!lerBoolean("se deseja filtrar as Ordens de Serviços")) {
            return new ArrayList();
        }
        System.out.println("\n -- Leitura de filtros de Seleção de Ordem de Serviços --");
        String string_inicial_mecanico = lerString("Inicial do mecanico");
        Modelo modelo = lerModelo();  //filtro da Suspenção
        String marca = lerString("Marca do óleo");  //filtro do Óleo
        int tamanho_aro = lerInteiroPositivo("Tamanho do Aro"); //filtro do Pneu
        char sexo = lerChar(" sexo [M: Mascilino  - F: Feminino]"); // filtro do Cliente
        Data menorData = lerData("Data minima do Servço");          // Filtro do serviço 
        System.out.println("\n Filtro de Seleção"  
                + "\n - String inicial do mecânico : " + string_inicial_mecanico
                + "\n - Modelo da Suspenção : " + modelo
                + "\n - Marca do Óleo : " + marca
                + "\n - Tamanho do Aro : " + tamanho_aro
                + "\n - Menor data do Serviço: " + menorData + "\n ");
        return Oficina.filtrarOrdemServiço(string_inicial_mecanico, modelo, marca, tamanho_aro, sexo, menorData);
    }
    
   
    
        //FUNÇÃO PARA IMPRIMIR  MINHAS ORDENS DE SERVIÇO 
    public static void imprimirOrdemServiço(String cabeçalho, ArrayList<OrdemServiço> listaOrdemServiço) {
        System.out.println(cabeçalho);
        for (OrdemServiço itemOrdemServiço : listaOrdemServiço) {
            System.out.println("\n" + itemOrdemServiço.getServiço().getNumero() + " - " + itemOrdemServiço.toString());
        }
        System.out.println();
    }
    
    //FUNÇÃO PARA IMPRIMIR OS SERVIÇO 
    public static void imprimirServiço(String cabeçalho, HashMap<Integer, Serviço> listaServiço) {
       System.out.println(cabeçalho);
           System.out.println("Lista de Serviços\n" + Serviço.getServiços());
       }
    
    //FUNÇÃO PARA IMPRIMIR  OS CLIENTES
    public static void imprimirCliente(String cabeçalho, HashMap<String,Cliente> listaCliente) {
      System.out.println(cabeçalho);
          System.out.println(" Lista de Clientes\n" + Cliente.getClientes());
    }
          
}

