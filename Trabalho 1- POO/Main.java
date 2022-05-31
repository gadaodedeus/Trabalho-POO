import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;


// Criar ArrayLists de Motorista, Onibus, Rotas e Passageiros



public class Main{
    
    private static int year = Calendar.getInstance().get(Calendar.YEAR); // Ano atual
    static Scanner input = new Scanner(System.in);
    static ArrayList<Motorista> listMoto = new ArrayList<>();
    static ArrayList<Onibus> listBus = new ArrayList<>();
    static ArrayList<Rotas> listRotas = new ArrayList<>();
    ArrayList<Passageiro> listPass = new ArrayList<>();

    private static void programaAdm(){
        System.out.println("Olá, você está executando como administrador!");
        int op;
        do
        {

            System.out.println("----------------------------------");
            System.out.println("-----------MENU DE OPCOES---------");
            System.out.println("----------------------------------");
            System.out.println("1- Adicionar onibus");
            System.out.println("2- Adicionar motorista");
            System.out.println("3- Adicionar rota");
            System.out.println("4- Remover onibus");
            System.out.println("5- Remover motorista");
            System.out.println("6- Remover rota");
            System.out.println("7- Mostrar onibus");
            System.out.println("8- Mostrar motoristas");
            System.out.println("9- Mostrar rotas");
            System.out.println("0- Sair");
            System.out.println("----------------------------------");
            op = input.nextInt();
            if(op<0 || op>11)
                System.out.println("Opcao invalida!!");

            if(op == 1)
            {
                Onibus temp = new Onibus();
                temp = CriarOnibus();
                listBus.add(temp);
            }

            if(op == 2)
            {
                Motorista temp = new Motorista();
                temp = CriarMoto();
                listMoto.add(temp);
            }

            if(op == 3)
            {
                Rotas temp = new Rotas();
                temp = CriarRota();
                listRotas.add(temp);
            }



          
        }while(op != 0);
        
    }

    private static void programaCli(){
        System.out.println("Olá, você está executando como cliente!");  
        
        
            /*if(op == 10)
            {
                int i;
                String orig, dest;

                System.out.println("Informe sua cidade de partida");
                orig = input.nextString();
                System.out.println("Informe sua cidade de destino");
                dest = input.nextString();

                while(i < Array.length)
                {
                    if(/*rota.origem == orig && rota.destino == dest)
                        /*rota.printInfo;
                    i++;
                }
            }*/


    }

    public static void main(String[] args) {
       
        
        System.out.println("Bem vindo ao sistema de viagem de ônibus, por favor informe seu tipo de acesso (Administrador[1]/ Cliente[2]): ");
        int tipoAcess = input.nextInt();
        
        if(tipoAcess == 1){
            //Codigo administrador:
            Main.programaAdm();
            
        }else if(tipoAcess == 2){
            //Codigo cliente:
            Main.programaCli();

        }

    }

    private static Onibus CriarOnibus()
    {
        String modelo;
        int ano;
        String marca;
        double km;

        input.nextLine();
        System.out.println("Informe o modelo do onibus");
        modelo = input.toString();
        input.nextLine();

        do
        {
            System.out.println("Informe o ano do onibus");
            ano = input.nextInt();
        }while(ano < (year-20));
        
        input.nextLine();
        System.out.println("Informe a marca do onibus");
        marca = input.toString();
        input.nextLine();

        do 
        {
            System.out.println("Informe a quilometragem do onibus");
            km = input.nextDouble();
        }while(km < 0.0);

        // Motorista
        
        Onibus temp = new Onibus(modelo, ano, marca, km, null);

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
        nome = input.toString();
        input.nextLine();

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
        origem=input.toString();
        input.nextLine();

       
        System.out.println("Digite a cidade de parada");
        parada=input.toString();
        input.nextLine();

        
        System.out.println("Digite a cidade de destino");
        destino=input.toString();
        input.nextLine();

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

        do{
            System.out.println("Digite o valor da passagem: ");
            valor=input.nextDouble();
        }while(valor<=0.0);

        Rotas temp = new Rotas(origem, parada, destino, diaS, mes, ano, hora_saida, min_saida, diaC, mes, ano, hora_chegada, min_chegada, null, valor);
        return temp;

    }

    
}
