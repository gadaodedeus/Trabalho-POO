import java.util.Scanner;
import java.util.Calendar;
Scanner input = new Scanner(System.in);

// Criar ArrayLists de Motorista, Onibus, Rotas e Passageiros

private static int year = Calendar.getInstance().get(Calendar.YEAR); // Ano atual

public class Main{

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
            System.out.println("8- Mostrar moristas");
            System.out.println("9- Mostrar rotas");
            System.out.println("10- Buscar rota");
            System.out.println("11- Comprar passagem");
            System.out.println("0- Sair");
            System.out.println("----------------------------------");
            op = input.nextInt();
            if(op<0 || op>11)
                System.out.println("Opcao invalida!!");

            if(op == 1)
            {
                Onibus temp = new Obibus();
                temp = this.CriarOnibus();
                // Add arraylist
            }

            if(op == 2)
            {
                Motorista temp = new Motorista();
                temp = this.CriarMoto();
                // Add arraylist
            }




            if(op == 10)
            {
                int i;
                String orig, dest;

                System.out.println("Informe sua cidade de partida");
                orig = input.nextString();
                System.out.println("Informe sua cidade de destino");
                dest = input.nextString();

                while(i < /*Array.length*/)
                {
                    if(/*rota.origem == orig && rota.destino == dest*/)
                        /*rota.printInfo;*/
                    i++;
                }
            }

        }while(op);
        
    }

    private static void programaCli(){
        System.out.println("Olá, você está executando como cliente!");

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
        private String modelo;
        private int ano;
        private String marca;
        private double km;

        System.out.println("Informe o modelo do onibus");
        modelo = input.nextString();

        do
        {
            System.out.println("Informe o ano do onibus");
            ano = input.nextInt();
        }while(ano < (year-20);
        )
        System.out.println("Informe a marca do onibus");
        marca = input.nextString();

        do 
        {
            System.out.println("Informe a quilometragem do onibus");
            km = input.nextDouble();
        }while(km < 0.0);

        // Motorista
        
        Onibus temp = new Obibus(modelo, ano, marca, km);

        return temp;
    }

    private static Motorista CriarMoto()
    {
        private String nome;
        private int numero_cnh;
        private int dia;
        private int mes;
        private int ano;

        System.out.println("Informe o nome do motorista");
        nome = input.nextString();

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

    
}
