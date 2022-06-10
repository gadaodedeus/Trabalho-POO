import java.util.Scanner;

import javax.swing.ListSelectionModel;

import java.util.Calendar;
import java.util.ArrayList;


// Criar ArrayLists de Passageiros



public class Main{
    
    private static int year = Calendar.getInstance().get(Calendar.YEAR); // Ano atual
    static Scanner input = new Scanner(System.in);
    static ArrayList<Motorista> listMoto = new ArrayList<>();
    static ArrayList<Onibus> listBus = new ArrayList<>();
    static ArrayList<Rotas> listRotas = new ArrayList<>();
    static ArrayList<Passageiro> listPass = new ArrayList<>();

    private static void programaAdm(){
        System.out.println("Ola, voce esta executando como administrador!");
        int op;
        do
        {

            System.out.println("------------------------------------------------");
            System.out.println("----------------MENU DE OPCOES------------------");
            System.out.println("------------------------------------------------");
            System.out.println("1- Adicionar onibus");
            System.out.println("2- Adicionar motorista");
            System.out.println("3- Adicionar rota");
            System.out.println("4- Remover onibus");
            System.out.println("5- Remover motorista");
            System.out.println("6- Remover rota");
            System.out.println("7- Mostrar onibus");
            System.out.println("8- Mostrar motoristas");
            System.out.println("9- Mostrar rotas");
            System.out.println("10- Mostrar os onibus que um motorista dirige");
            System.out.println("11- Realocar motorista em um onibus");
            System.out.println("12- Realocar onibus em uma rota");
            System.out.println("0- Sair");
            System.out.println("------------------------------------------------");
            op = input.nextInt();
            if(op<0 || op>11)
                System.out.println("Opcao invalida!!");

            if(op == 1)
            {
                if(listMoto.size()>0)
                {
                    Onibus temp = new Onibus("", 2022, "", 0.1, null);
                    temp = CriarOnibus();
                    if(temp.flag != 0)
                        listBus.add(temp);
                }
                else System.out.println("Nao ha motoristas disponiveis!");
            }

            if(op == 2)
            {
                Motorista temp = new Motorista("", 1, 1, 1, 2022);
                temp = CriarMoto();
                listMoto.add(temp);
            }

            if(op == 3)
            {
                if(listBus.size()>0)
                {
                    Rotas temp = new Rotas("", "", "", 1, 1, 2022, 1, 1, 1, 1, 2022, 1, 1, null, 0.1);
                    temp = CriarRota();
                    if(temp.flag != 0)
                        listRotas.add(temp);
                }
                else System.out.println("Nao ha onibus disponiveis!");
            }

            if(op == 4)
            {
                int i;
                System.out.println("Informe o indice do onibus a ser removido: [0-"+(listBus.size()-1)+"]");
                i = input.nextInt();

                // Remoçao do onibus das classes que ele participa (nao funciionou)

                /*int j=0;
                for(j=0;j<listRotas.size();j++)
                {
                    if(listRotas.get(j).getBus().getModelo() == listBus.get(i).getModelo())
                        {
                            listRotas.get(j).setOnibus(null);
                            break;
                        }
                    j++;
                }*/
                
                listBus.remove(i);
            }

            if(op == 5)
            {
                int i;
                System.out.println("Informe o indice do motorista a ser removido: [0-"+(listMoto.size()-1)+"]");
                i = input.nextInt();

                // Remoçao do motorista das classes que ele participa (nao funciionou)

                /*int j;
                for(j=0;j<listBus.size();j++)
                {
                    if(listBus.get(j).getMotorista().getNumero_cnh() == listMoto.get(i).getNumero_cnh())
                        {
                            listBus.get(j).setMotorista(null);
                            break;
                        }
                    j++;
                }*/

                listMoto.remove(i);
            }

            if(op == 6)
            {
                int i;
                System.out.println("Informe o indice da rota a ser removida: [0-"+(listRotas.size()-1)+"]");
                i = input.nextInt();
                listRotas.remove(i);
            }

            if(op == 7)
            {
                for(int i = 0; i<listBus.size(); i++)
                    {
                        System.out.println("Numero do onibus: "+i);
                        listBus.get(i).printInfo();
                    }
                    
            }

            if(op == 8)
            {
                for(int i = 0; i<listMoto.size(); i++)
                {
                    System.out.println("Numero do motorista: "+i);
                    listMoto.get(i).printInfo();
                }
                    
            }

            if(op == 9)
            {
                for(int i = 0; i<listRotas.size(); i++)
                {
                    System.out.println("Numero da rota: "+i);
                    listRotas.get(i).printInfo();
                }
                    
            }

            if(op == 10)
            {
                int aux, i;
                for(i = 0; i<listMoto.size(); i++)
                    System.out.println(i+"- "+listMoto.get(i).getNome());
                System.out.println("Escolha um motorista pelo numero: ");
                aux = input.nextInt();

                listMoto.get(aux).printBus();
                    
            }

            if(op == 11)
            {
                int i, j;
                System.out.println("Insira o indice do onibus que deseja trocar de motorista [0-"+listBus.size()+"]");
                j = input.nextInt();
                System.out.println("Insira o indice do novo motorista [0-"+listMoto.size()+"]");
                i = input.nextInt();

                listBus.get(j).setMotorista(listMoto.get(i));
            }

            if(op == 12)
            {
                int i, j;
                System.out.println("Insira o indice da rota que deseja trocar de onibus [0-"+listRotas.size()+"]");
                j = input.nextInt();
                System.out.println("Insira o indice do novo onibus [0-"+listBus.size()+"]");
                i = input.nextInt();

                listRotas.get(j).setOnibus(listBus.get(i));
            }
          
        }while(op != 0);
        
    }

    private static void programaCli(){
        System.out.println("Olá, você está executando como cliente!");  
        
        int op;
            
        do{
            System.out.println("------------------------------------------------");
            System.out.println("----------------MENU DE OPCOES------------------");
            System.out.println("------------------------------------------------");
            System.out.println("1- Comprar sua passagem");
            System.out.println("2- Fazer cadastro");
            System.out.println("0- Sair");
            System.out.println("------------------------------------------------");
            op = input.nextInt();
            if(op<0 || op>2)
                System.out.println("Opcao invalida!!");
        
            if(op == 1){
                
                int i;
                String orig, dest;

                System.out.println("Informe sua cidade de partida");
                orig = input.nextLine();
                input.nextLine();
                System.out.println("Informe sua cidade de destino");
                dest = input.nextLine();
                input.nextLine();

                for(i = 0; i<listRotas.size(); i++)
                {
                    if(listRotas.get(i).getOrigem() == orig && listRotas.get(i).getDestino() == dest)
                    {
                        System.out.println("Numero da rota: "+i);
                        listRotas.get(i).printInfo(); // Nao ta printando
                    }
                }
                
                System.out.println("Escolha sua rota");
                int aux = input.nextInt();

                listRotas.get(aux).getBus().addPassageiro();
            }
            
            if(op == 2) // Cadastro nao serve para nada em relacao a comprar passagem
            {
                Passageiro temp = new Passageiro(0, "", 0, 0, 0, "");
                temp = criarPass();
                listPass.add(temp);
            }
            
        }while(op != 0);
            

        
        
      
        


    }

    public static void main(String[] args) {
        
        int tipoAcess;

        do
        {
            System.out.println("Bem vindo ao sistema de viagem de ônibus, por favor informe seu tipo de acesso (Administrador[1]/ Cliente[2]): ");
            tipoAcess = input.nextInt();

            if(tipoAcess == 1){
                //Codigo administrador:
                Main.programaAdm();
                
            }else if(tipoAcess == 2){
                //Codigo cliente:
                Main.programaCli();

        }
        }while(tipoAcess != 0);
        

    }

    private static Onibus CriarOnibus()
    {
        String modelo;
        int ano;
        String marca;
        double km;

        input.nextLine();
        System.out.println("Informe o modelo do onibus");
        modelo = input.nextLine();

        do
        {
            System.out.println("Informe o ano do onibus");
            ano = input.nextInt();
        }while(ano < (year-20));
        
        input.nextLine();
        System.out.println("Informe a marca do onibus");
        marca = input.nextLine();

        do 
        {
            System.out.println("Informe a quilometragem do onibus");
            km = input.nextDouble();
        }while(km < 0.0);

        int numMoto;
        do
        {
            System.out.println("Informe o numero do motorista entre 0-"+(listMoto.size()-1));
            numMoto = input.nextInt();
        }while(numMoto < 0 || numMoto>listMoto.size());
        

        Onibus temp = new Onibus(modelo, ano, marca, km, listMoto.get(numMoto));

        listMoto.get(numMoto).setBus(temp);

        return temp;
    }

    private static Motorista CriarMoto()
    {
        String nome;
        int numero_cnh;
        int dia;
        int mes;
        int ano;

        input.nextLine();
        System.out.println("Informe o nome do motorista");
        nome = input.nextLine();

        do
        {
            System.out.println("Informe o numero da CNH do motorista");
            numero_cnh = input.nextInt();
        }while(numero_cnh <= 0);

        do
        {
            System.out.println("Informe o dia da admissao do motorista");
            dia = input.nextInt();
        }while(dia<1 || dia>31);

        do
        {
            System.out.println("Informe o mes da admissao do motorista");
            mes = input.nextInt();
        }while(mes<1 || mes>12);

        do
        {
            System.out.println("Informe o ano da admissao do motorista");
            ano = input.nextInt();
        }while(ano<1900);

        Motorista temp = new Motorista(nome, numero_cnh, dia, mes, ano);
        return temp;
    }

    private static Rotas CriarRota()
    {
        String origem;
        String parada;
        String destino;
        double valor;
        int diaS;
        int diaC;
        int mes;
        int ano;
        int hora_chegada;
        int min_chegada;
        int hora_saida;
        int min_saida;

        input.nextLine();
        System.out.println("Digite a cidade de origem");
        origem=input.nextLine();
        //input.nextLine();

       
        System.out.println("Digite a cidade de parada");
        parada=input.nextLine();
        //input.nextLine();

        
        System.out.println("Digite a cidade de destino");
        destino=input.nextLine();
        //input.nextLine();

        do{
            System.out.println("Digite a hora de saida: ");
            hora_saida=input.nextInt();
        }while(hora_saida<0 || hora_saida>23);

        do{
            System.out.println("Digite o minuto de saida: ");
            min_saida=input.nextInt();
        }while(min_saida<0 || min_saida>60);

        do{
            System.out.println("Digite a hora de chegada: ");
            hora_chegada=input.nextInt();
        }while(hora_chegada<0 || hora_chegada>23);

        do{
            System.out.println("Digite o minuto de chegada: ");
            min_chegada=input.nextInt();
        }while(min_chegada<0 || min_chegada>60);

        do{
            System.out.println("Digite o dia de saida: ");
            diaS=input.nextInt();
        }while(diaS<1 || diaS>31);

        do{
            System.out.println("Digite o dia de chegada: ");
            diaC=input.nextInt();
        }while(diaC<1 || diaC>31 && diaC<diaS);

        do{
            System.out.println("Digite o mes da viagem: ");
            mes=input.nextInt();
        }while(mes<1 || mes>12);

        do{
            System.out.println("Digite o ano da viagem: ");
            ano=input.nextInt();
        }while(ano<year);

        int numBus;
        do
        {
            System.out.println("Informe o numero do onibus entre 0-"+(listBus.size()-1));
            numBus = input.nextInt();
        }while(numBus < 0 || numBus>listBus.size());

        do{
            System.out.println("Digite o valor da passagem: ");
            valor=input.nextDouble();
        }while(valor<=0.0);

        Rotas temp = new Rotas(origem, parada, destino, diaS, mes, ano, hora_saida, min_saida, diaC, mes, ano, hora_chegada, min_chegada, listBus.get(numBus), valor);
        return temp;

    }
    
    public static Passageiro criarPass()
    {
        int doc, dia, mes, ano;
        String nome, end;

        do
        {
            System.out.println("Informe o seu documento: ");
            doc = input.nextInt();
        }while(doc<=0);

        System.out.println("Informe seu nome: ");
        nome = input.nextLine();

        do
        {
            System.out.println("Insira o dia de seu nascimento: ");
            dia = input.nextInt();
        }while(dia<1 || dia>31);

        do
        {
            System.out.println("Insira o mes de seu nascimento: ");
            mes = input.nextInt();
        }while(mes<1 || mes>12);

        do
        {
            System.out.println("Insira o ano que nasceu: ");
            ano = input.nextInt();
        }while(ano<1900);

        System.out.println("Informe seu endereco: ");
        end = input.nextLine();
        
        Passageiro temp = new Passageiro(doc, nome, dia, mes, ano, end);

        return temp;

    }
    
}
