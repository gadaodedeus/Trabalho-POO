import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.time.Year;

public class Main
{
    public static ArrayList<Login> cadastros = new ArrayList<>();
    public static ArrayList<String> users = new ArrayList<>();

    public static ArrayList<Cliente> cli = new ArrayList<>();
    public static ArrayList<Vendedor> vend = new ArrayList<>();
    public static ArrayList<Gerente> gerentes = new ArrayList<>();

    public static ArrayList<Carro> carros = new ArrayList<>();
    public static ArrayList<Motocicleta> motos = new ArrayList<>();
    public static ArrayList<Venda> venda = new ArrayList<>();

    

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int dados_arq;

        dados_arq = backupLogin();
        if(dados_arq == 1)
        {
            backupCli();
            backupGerente();
            backupVend();
            backupCarro();
            backupMoto();
            backupVenda();
        }
        
            
        if(dados_arq == 0)
        {
            try
            {
                System.out.println("\n\n\n\tBem vindo ao sistema de vendas!\n\nPara continuar faca o cadastro do gerente local");
                String arqBoot = "boot.txt";
                File arq = new File(arqBoot);

                FileWriter escritor = new FileWriter(arq, true);   
                escritor.write("1\n");

                Gerente gerente_local = new Gerente();
                gerente_local = novoGerente();
                
                Login admin = new Login("admin", "adminpass", 3);
                cadastros.add(admin);
                users.add(admin.getUser());
                gerentes.add(gerente_local);
                gerente_local.setIndice(gerentes.indexOf(gerente_local));

                escritor.write("admin\nadminpass\n3");
                escritor.close();
            }

            catch(IOException e)
            {
                System.out.println("Erro!\n"+e);
            }

        }
       
        int flag = 1;
        int acesso = fazerLogin();
        int log = 0;
        do
        {
            if(log == 1)
                acesso = fazerLogin();

            if(acesso == 2)
                flag = menuVendedor(false);

            if(acesso == 3)
                flag = menuGerente();

            
            log = 1;
        }while(acesso != 0 && flag == 1);

        printCliArq();        
        printLoginArq();
        printArqVend();
        printGerArq();
        printCarroArq();
        printMotoArq();
    }


    //Menus 

    private static int menuGerente()
    {
        Scanner input = new Scanner(System.in);
        int op;
        boolean on = true;
        while(on)
        {
            System.out.println("-----------Menu do Gerente---------");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Alterar Cliente");
            System.out.println("3- Excluir Cliente");
            System.out.println("4- Mostrar Clientes");

            System.out.println("5- Cadastrar Vendedor");
            System.out.println("6- Alterar Vendedor");
            System.out.println("7- Excluir Vendedor");
            System.out.println("8- Mostrar Vendedor");

            System.out.println("9- Cadastrar Veiculo");
            System.out.println("10- Alterar Veiculo");
            System.out.println("11- Excluir Veiculo");
            System.out.println("12- Mostrar Veiculos");

            System.out.println("13- Cadastrar Gerente");
            System.out.println("14- Alterar Gerente");
            System.out.println("15- Excluir Gerente");
            System.out.println("16- Mostrar Gerentes");

            System.out.println("17- Mais opcoes");
            System.out.println("18- Trocar Login");
            System.out.println("0- Sair");
            System.out.println("-----------------------------------");
            do
            {
                System.out.println("Selecione uma opcao!");
                op = input.nextInt();
            }while(op<0 || op>18);

            if(op ==1)  //Cadastrar cliente
            {
                Cliente temp = new Cliente();
                temp = novoCli();
                cli.add(temp);
                int i = cli.indexOf(temp);
                temp.setInd(i);
            }   

            if(op == 2) //Alterar cliente
            {
                if(cli.size() > 0)
                    alterarCli();  
                else
                    System.out.println("Nao ha clientes cadastrados");
            } 

            if(op == 3) //Excluir cliente
            {
                if(cli.size() == 0)
                    System.out.println("Nao ha clientes cadastrados");

                else if(cli.size() == 1)
                    cli.removeAll(cli);
                
                else
                {
                    int ind;
                    printCli();
                    System.out.println("Informe o indice do cliente a ser removido: ");
                    ind = input.nextInt();
                    Cliente temp = new Cliente();
                    temp = cli.remove(ind);
                }
                
            }

            if(op == 4) //Mostrar cliente
            {
                if(cli.size() > 0)
                    printCli();
                else
                    System.out.println("Nao ha clientes cadastrados");
            } 

            if(op == 5) //Cadastrar Vendedor
            {
                Vendedor temp = new Vendedor();
                temp = novoVend();
                vend.add(temp);
                int i = vend.indexOf(temp);
                temp.setInd(i);

                Login logTemp = new Login();
                logTemp = novoLogin(2);
                cadastros.add(logTemp);
                users.add(logTemp.getUser());
            }

            if(op == 6) //Alterar Vendedor
            {
                if(vend.size() > 0)
                    alterarVend();  
                else
                    System.out.println("Nao ha vendedores cadastrados");
            }

            if(op == 7) //Excluir Vendedor
            {
                if(vend.size() == 0)
                    System.out.println("Nao ha clientes cadastrados");

                else if(vend.size() == 1)
                    vend.removeAll(vend);
                
                else
                {
                    int ind;
                    printVend();
                    System.out.println("Informe o indice do vendedor a ser removido: ");
                    ind = input.nextInt();
                    Vendedor temp = new Vendedor();
                    temp = vend.remove(ind);
                }
                
            }

            if(op == 8) //Mostrar Vendedores
            {
                if(vend.size() > 0)
                    printVend();
                else
                    System.out.println("Nao ha vendedores cadastrados!");
            }

            if(op == 9) //Cadastrar Veiculo
            {
                int veic;
                do{
                    System.out.println("Cadastrar carro(1) ou moto(2)?");
                    veic = input.nextInt();
                }while(veic != 1 && veic != 2);                

                if(veic == 1)   //Carro
                {
                    Carro temp = new Carro();
                    temp = novoCarro();
                    carros.add(temp);
                    int i = carros.indexOf(temp);
                    temp.setInd(i);
                }

                else    //Moto
                {
                    Motocicleta temp = new Motocicleta();
                    temp = novoMoto();
                    motos.add(temp);
                    int i = motos.indexOf(temp);
                    temp.setInd(i);
                }

            }

            if(op == 10) //Alterar Veiculo
            {
                int veic;
                do{
                    System.out.println("Alterar carro(1) ou moto(2)?");
                    veic = input.nextInt();
                }while(veic != 1 && veic != 2);   
                
                if(veic == 1) alterarCarro();

                else alterarMoto();
            }

            if(op == 11) //Excluir Veiculo
            {
                int veic;
                do{
                    System.out.println("Excluir carro(1) ou moto(2)?");
                    veic = input.nextInt();
                }while(veic != 1 && veic != 2);   

                if(op == 1)
                {
                    if(carros.size() == 0) System.out.println("Nao ha carros para serem removidos");

                    else if(carros.size() == 1)
                        carros.removeAll(carros);
                    
                    else
                    {
                        int opCar;
                        printCarro();
                        System.out.println("Selecione um carro pelo indice");
                        opCar = input.nextInt();
                        Carro temp = new Carro();
                        temp = carros.remove(opCar);
                    }
                    

                }

                else
                {
                    if(motos.size() == 0) System.out.println("Nao ha motos para serem removidas");

                    else if(motos.size() == 1)
                        motos.removeAll(motos);
                    
                    else
                    {
                        int opMoto;
                        printMoto();
                        System.out.println("Selecione uma moto pelo indice");
                        opMoto = input.nextInt();
                        Motocicleta temp = new Motocicleta();
                        temp = motos.remove(opMoto);
                    }
                }
            }

            if(op == 12) //Mostrar Veiculos
            {
                int x;
                do
                {
                    System.out.println("Mostrar apenas carros(1), apenas motos(2) ou ambos(0)?");
                    x = input.nextInt();
                }while(x < 0 || x > 2);
                
                if(op == 1) printCarro();

                if(op == 2) printMoto();

                else
                {
                    printCarro();
                    printMoto();
                }
            }
            
            //Opcoes de gerente

            if(op == 17) //Outros (Menu do Vendedor)
            {
                int quak = menuVendedor(true);
            }

            if(op == 18) return 1;

            if(op == 0) return 0;
        }
        return 0;
    }

    ////////////////////////////////////////////////////////////////////////////

    public static int menuVendedor(boolean g)
    {
        Scanner input = new Scanner(System.in);
        int op;
        boolean on = true;
        while(on)
        {
            if(!g)
                System.out.println("----------Menu do Vendedor---------");
            else
                System.out.println("------------Mais Opcoes------------");
            System.out.println("1- Mostrar Todos os Veiculos");
            System.out.println("2- Mostrar Carros");
            System.out.println("3- Mostrar Motocicletas");
            System.out.println("4- Mostrar Veiculos Disponiveis");
            System.out.println("5- Mostrar Veiculos Vendidos");


            if(!g)
                System.out.println("6- Trocar Login");
            System.out.println("0- Sair");
            System.out.println("-----------------------------------");
            do
            {
                System.out.println("Selecione uma opcao!");
                op = input.nextInt();
            }while(op<0 || op>13);

            if(op == 1)
            {
                if(carros.size() > 0) printCarro();

                else System.out.println("Nao ha carros cadastrados");

                if(motos.size() > 0) printMoto();

                else System.out.println("Nao ha motos cadastradas");
            }

            if(op == 2)
            {
                if(carros.size() > 0) printCarro();

                else System.out.println("Nao ha carros cadastrados");
            }

            if(op == 3)
            {
                if(motos.size() > 0) printMoto();

                else System.out.println("Nao ha motos cadastradas");
            }

            if(op == 4)
            {
                if(carros.size() > 0) printCarro();

                else System.out.println("Nao ha carros cadastrados");

                if(motos.size() > 0) printMoto();

                else System.out.println("Nao ha motos cadastradas");
            }

            if(op == 5)
            {
                
            }

            if(op == 6)
            {
                Venda temp = new Venda();
                temp = novaVenda();
                venda.add(temp);
            }

            if(op == 7)
            {

            }



            if(op == 6 && !g) return 1;

            if(op == 0) return 0;
        }
        return 0;
    }








    ////////////////////////////////////////////////////////////
    //Vendedor//////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static void alterarVend()
    {
        Scanner input = new Scanner(System.in);
        int ind, opVend;
        if(vend.size() == 0)
            return;
        printVend();
        System.out.println("Informe o indice do vendedor que deseja alterar as informacoes");
        ind = input.nextInt();
        Vendedor temp = new Vendedor();
        temp = vend.get(ind);

        System.out.println("1- RG");
        System.out.println("2- Nome");
        System.out.println("3- Salario");
        System.out.println("4- Data de Nascimento");
        System.out.println("5- Data de Admissao");
        System.out.println("6- Tempo de Treinamento");
        System.out.println("7- Gerente");
        do
        {
            System.out.println("Escolha a informacao que sera alterada: ");
            opVend = input.nextInt();
        }while(opVend<1 || opVend>7);

        if(opVend == 1)
        {
            int temprg;
            do
            {
                System.out.println("Informe o novo RG:");
                temprg = input.nextInt();
            }while(temprg < 0);
                        
            temp.setRg(temprg);
        }

        if(opVend == 2)
        {
            input.nextLine();
            String nome;
            System.out.println("Informe o novo nome: ");
            nome = input.nextLine();
            temp.setNome(nome);
        }

        if(opVend == 3)
        {
            double sal;
            do
            {
                System.out.println("Informe o novo salario: ");
                sal = input.nextDouble();    
            }while(sal<0.0);
            temp.setSalario(sal);
        }

        if(opVend == 4)
        {
            int tempdia, tempmes, tempano;
            System.out.println("Informe a nova data de nascimento");
            do
            {
                System.out.println("Dia:");
                tempdia = input.nextInt();
            }while(tempdia<1 || tempdia>31);

            do
            {
                System.out.println("Mes:");
                tempmes = input.nextInt();
            }while(tempmes<1 || tempmes>12);
                    
            do
            {
                System.out.println("Ano:");
                tempano = input.nextInt();
            }while(tempano<1900);

            Date newDate = new Date(tempdia, tempmes, tempano);
            temp.setDataNascimento(newDate);
        }

        if(opVend == 5)
        {
            int tempdia, tempmes, tempano;
            System.out.println("Informe a nova data de Admicao");
            do
            {
                System.out.println("Dia:");
                tempdia = input.nextInt();
            }while(tempdia<1 || tempdia>31);

            do
            {
                System.out.println("Mes:");
                tempmes = input.nextInt();
            }while(tempmes<1 || tempmes>12);
                    
            do
            {
                System.out.println("Ano:");
                tempano = input.nextInt();
            }while(tempano<1900);
                   
            Date newDate = new Date(tempdia, tempmes, tempano);
            temp.setDataAdmi(newDate);
        }

        if(opVend == 6)
        {
            int t;
            do
            {
                System.out.println("Informe o novo tempo de treinamento: ");
                t = input.nextInt();
            }while(t<0);
            temp.setTempoTreino(t);
        }

        if(opVend == 7)
        {
            int opG;
            printGer();
            System.out.println("Informe o indice do do novo Gerente: ");
            opG = input.nextInt();
            Gerente tempg = new Gerente();
            tempg = gerentes.get(opG);
            temp.setGerente(tempg);
        }

        vend.set(ind, temp);
    }

    public static void printVend()
    {
        int i=0;
                
        while(vend.size() > i)
        {
            System.out.println(i);
            vend.get(i).printInfo();
            i++;
        }
    }

    public static void printArqVend()
    {
        int i=0;
        if(vend.size() > 0)
        {
            vend.get(i).printArq(false);    
            i++;

            while(vend.size() > i)
            {
                vend.get(i).printArq(true);
                i++;
            }
        }

        else
        {
            try
            {
                File temp = new File("Vendedores.txt");
                FileWriter writer = new FileWriter(temp, false);
                writer.close();
            }
            catch(IOException e) 
            {
                System.out.println(e);
            }
        }
        
    }










    ////////////////////////////////////////////////////////////
    //Gerente///////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static void alterarGerente(){
        Scanner input = new Scanner(System.in);
        int ind, opGerente;
        if(gerentes.size() == 0)
            return;
        printGer();
        System.out.println("informe o índice do vendedor que deseja alterar: ");
        ind = input.nextInt();
        Gerente temp = new Gerente();
        temp = gerentes.get(ind);
        
        System.out.println("1 - RG");
        System.out.println("2 - Nome");
        System.out.println("3 - Salário");
        System.out.println("3 - Data de Nascimento");
        System.out.println("4 - Data de Admissão");
        System.out.println("5 - Anos de experiência");

        do{
            System.out.println("Escolha a informacao que sera alterada: ");
            opGerente = input.nextInt();
        }while(opGerente < 1 || opGerente > 6);

        if(opGerente == 1){
            int temprg;
            do
            {
                System.out.println("Informe o novo RG:");
                temprg = input.nextInt();
            }while(temprg < 0);
                        
            temp.setRg(temprg);
        }

        if(opGerente == 2){
            input.nextLine();
            String nome;
            System.out.println("Informe o novo nome: ");
            nome = input.nextLine();
            temp.setNome(nome);
        }

        if(opGerente == 3){
            double sal;
            do
            {
                System.out.println("Informe o novo salario: ");
                sal = input.nextDouble();    
            }while(sal<0.0);
            temp.setSalario(sal);
        }

        if(opGerente == 4){
            int tempdia, tempmes, tempano;
            System.out.println("Informe a nova data de nascimento");
            do
            {
                System.out.println("Dia:");
                tempdia = input.nextInt();
            }while(tempdia<1 || tempdia>31);

            do
            {
                System.out.println("Mes:");
                tempmes = input.nextInt();
            }while(tempmes<1 || tempmes>12);
                    
            do
            {
                System.out.println("Ano:");
                tempano = input.nextInt();
            }while(tempano<1900);

            Date newDate = new Date(tempdia, tempmes, tempano);
            temp.setDataNascimento(newDate);
        }

        if(opGerente == 5){
            int tempdia, tempmes, tempano;
            System.out.println("Informe a nova data de Admicao");
            do
            {
                System.out.println("Dia:");
                tempdia = input.nextInt();
            }while(tempdia<1 || tempdia>31);

            do
            {
                System.out.println("Mes:");
                tempmes = input.nextInt();
            }while(tempmes<1 || tempmes>12);
                    
            do
            {
                System.out.println("Ano:");
                tempano = input.nextInt();
            }while(tempano<1900);
                   
            Date newDate = new Date(tempdia, tempmes, tempano);
            temp.setDataAdmi(newDate);
        }

        if(opGerente == 6){
            int opExp;
            do {
                System.out.println("Digite a nova quantidade de anos de experiencia: ");
                opExp = input.nextInt();
            } while (opExp < 1 || opExp > 100);

            temp.setAnos(opExp);
        }

    } //Fim - Alterar Gerente

    public static void printGerArq()
    {
        int i=0;

        if(gerentes.size() > 0)
        {
            gerentes.get(i).printArq(false);
            i++;
                
            while(gerentes.size() > i)
            {
                gerentes.get(i).printArq(true);
                i++;
            }
        }

        
    }

    public static void printGer()
    {
        int i=0;
                
        while(gerentes.size() > i)
        {
            System.out.println(i);
            gerentes.get(i).printInfo();
            i++;
        }
    }












    ////////////////////////////////////////////////////////////
    //Cliente///////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static void alterarCli()
    {
        Scanner input = new Scanner(System.in);
        int ind, opCli;
        if(cli.size() == 0)
            return;
        printCli();
        System.out.println("Informe o indice do cliente que deseja alterar as informacoes");
        ind = input.nextInt();
        Cliente temp = new Cliente();
        temp = cli.get(ind);
        System.out.println("1- CPF");
        System.out.println("2- Nome");
        System.out.println("3- Data de Nascimento");
        System.out.println("4- Endereco");
        System.out.println("5- Renda");
        System.out.println("6- Dependentes");
        do
        {
            System.out.println("Escolha a informacao que sera alterada: ");
            opCli = input.nextInt();
        }while(opCli<1 || opCli>7);

        if(opCli == 1)
        {
            int tempcpf;
            do
            {
                System.out.println("Informe o novo CPF:");
                tempcpf = input.nextInt();
            }while(tempcpf < 0);
                        
            temp.setCpf(tempcpf);
        }

        if(opCli == 2)
        {
            String tempnome;
            input.nextLine();
            System.out.println("Informe o novo nome:");
            tempnome = input.nextLine();
            temp.setNome(tempnome);
        }

        if(opCli == 3)
        {
            int tempdia, tempmes, tempano;
            System.out.println("Informe a nova data de nascimento");
            do
            {
                System.out.println("Dia:");
                tempdia = input.nextInt();
            }while(tempdia<1 || tempdia>31);

            do
            {
                System.out.println("Mes:");
                tempmes = input.nextInt();
            }while(tempmes<1 || tempmes>12);
                    
            do
            {
                System.out.println("Ano:");
                tempano = input.nextInt();
            }while(tempano<1900);
                   
            temp.setDataNascimento(tempdia, tempmes, tempano);
        }

        if(opCli == 4)
        {
            String temprua, tempbairro, tempcid;
            int tempnum;

            System.out.println("Informe o novo endereco");

            input.nextLine();
            System.out.println("Rua: ");
            temprua = input.nextLine();

            do
            {
                System.out.println("Numero: ");
                tempnum = input.nextInt();
            }while(tempnum<0);

            input.nextLine();
            System.out.println("Bairro: ");
            tempbairro = input.nextLine();

            System.out.println("Cidade: ");
            tempcid = input.nextLine();

            temp.setEndereco(temprua, tempnum, tempbairro, tempcid);
        }

        if(opCli == 5)
        {
            double temprenda;
            do
            {
                System.out.println("Informe a nova renda: ");
                temprenda = input.nextDouble();
            }while(temprenda<0.0);
            temp.setRenda(temprenda);
        }

        if(opCli == 6)
        {
            int tempdep;
            do
            {
                System.out.println("Informe o novo numero de dependentes: ");
                tempdep = input.nextInt();
            }while(tempdep<0);
            temp.setDependentes(tempdep);
        }

        cli.set(ind, temp);
    }

    public static void printCliArq()
    {
        int i=0;

        if(cli.size() > 0)
        {
            cli.get(i).printArq(false);
            i++;
                
            while(cli.size() > i)
            {
                cli.get(i).printArq(true);
                i++;
            }
        }

        else
        {
            try
            {
                File temp = new File("Clientes.txt");
                FileWriter writer = new FileWriter(temp, false);
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
            
        }

        
    }

    public static void printCli()
    {
        int i=0;
                
        while(cli.size() > i)
        {
            System.out.println(i);
            cli.get(i).printInfo();
            i++;
        }
    }








    ////////////////////////////////////////////////////////////
    //Carro/////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static void printCarroArq()
    {
        int i=0;
        if(carros.size() > 0)
        {
            carros.get(i).printArq(false);
            i++;
                
            while(carros.size() > i)
            {
                carros.get(i).printArq(true);
                i++;
            }
        }
        else
        {
            try
            {
                File temp = new File("Carros.txt");
                FileWriter writer = new FileWriter(temp, false);
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
        
    }

    
    public static void printCarro()
    {
        int i=0;
                
        System.out.println("Carros: ");
        while(carros.size() > i)
        {
            System.out.println(i);
            carros.get(i).printInfo();
            i++;
        }
    }

    public static void alterarCarro()
    {
        Scanner input = new Scanner(System.in);
        if(carros.size() == 0)
            return;
        printCarro();
        System.out.println("Informe o indice do carro que deseja alterar as informacoes");
        int ind = input.nextInt();
        Carro temp = new Carro();
        temp = carros.get(ind);
         
        int op;

        System.out.println("1- Numero do chassi");
        System.out.println("2- Marca");
        System.out.println("3- Modelo");
        System.out.println("4- Ano");
        System.out.println("5- Quilometragem");
        System.out.println("6- Tipo do combustivel");
        System.out.println("7- Peso");
        System.out.println("8- Status");
        System.out.println("9- Potencia");
        System.out.println("10- Numero de cilindros");
        System.out.println("11- Numero de ocupantes");
        System.out.println("12- Tipo");
        System.out.println("13- Altura");
        System.out.println("14- Largura");
        System.out.println("15- Comprimento");
        do{
            System.out.println("Escolha a Informacao que deseja alterar: ");
            op = input.nextInt();
        }while(op<1 || op>15);

        if(op == 1)
        {
            int num_chassi;
            do{
                System.out.println("Informe o novo numero do chassi");
                num_chassi = input.nextInt();
            }while(num_chassi < 0.0);
           
            temp.setChassi(num_chassi);
        }

        if(op == 2)
        {
            input.nextLine();
            System.out.println("Informe a nova marca");
            String marca = input.nextLine();
            temp.setMarca(marca);
        }

        if(op == 3)
        {
            input.nextLine();
            System.out.println("Informe o novo modelo");
            String modelo = input.nextLine();
            temp.setModelo(modelo);
        }

        if(op == 4)
        {
            int ano;
            do{
                System.out.println("Informe o novo ano");
                ano = input.nextInt();
            }while(ano < 1900);
            
            temp.setAno(ano);
        }

        if(op == 5)
        {   
            double km;
            do{
                System.out.println("Informe a nova quilometragem");
                km = input.nextDouble();
            }while(km < 0.0);
            
            temp.setKm(km);
        }

        if(op == 6)
        {
            input.nextLine();
            System.out.println("Informe o novo tipo de combustivel");
            String tipo_comb = input.nextLine();
            temp.setComb(tipo_comb);
        }

        if(op == 7)
        {
            double peso;
            do{
                System.out.println("Informe o novo peso");
                peso = input.nextDouble();
            }while(peso < 0.0);
            temp.setPeso(peso);
        }

        if(op == 8)
        {
            if(temp.getStatus())
                temp.setStatus(false);
            else   
                temp.setStatus(true);
        }

        if(op == 9)
        {
            double potencia;
            do{
                System.out.println("Informe a nova potencia");
                potencia = input.nextDouble();
            }while(potencia < 0.0);
            temp.setPotencia(potencia);
        }
        
        if(op == 10)
        {
            int numCilindros;
            do{
                System.out.println("Informe o novo numero de cilindros");
                numCilindros = input.nextInt();
            }while(numCilindros < 1);
            temp.setNumCilindros(numCilindros);
        }
        
        if(op == 11)
        {
            int numOcupantes;
            do{
                System.out.println("Informe o novo numero de ocupantes");
                numOcupantes = input.nextInt();
            }while(numOcupantes < 3);
            temp.setNumOcupantes(numOcupantes);
        }

        if(op == 12)
        {
            input.nextLine();
            System.out.println("Informe o novo tipo do carro");
            String tipo = input.nextLine();
            temp.setTipo(tipo);
        }

        if(op == 13)
        {
            double altura;
            do{
                System.out.println("Informe a nova altura");
                altura = input.nextDouble();
            }while(altura < 0.0);
            temp.setAltura(altura);
        }

        if(op == 14)
        {
            double largura;
            do{
                System.out.println("Informe a nova largura");
                largura = input.nextDouble();
            }while(largura < 0.0);
            temp.setLargura(largura);
        }

        if(op == 15)
        {
            double comprimento;
            do{
                System.out.println("Informe o novo comprimento");
                comprimento = input.nextDouble();
            }while(comprimento < 0.0);
            temp.setComprimento(comprimento);
        }

        carros.set(ind, temp);
    }












    ////////////////////////////////////////////////////////////
    //Moto//////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static void printMotoArq()
    {
        int i=0;

        if(motos.size() > 0)
        {
            motos.get(i).printArq(false);
            i++;
                
            while(motos.size() > i)
            {
                motos.get(i).printArq(true);
                i++;
            }
        }
        else
        {
            try
            {
                File temp = new File("Motos.txt");
                FileWriter writer = new FileWriter(temp, false);
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
        
    }   
    
    public static void printMoto()
    {
        int i=0;
                
        System.out.println("Motos: ");
        while(motos.size() > i)
        {
            System.out.println(i);
            motos.get(i).printInfo();
            i++;
        }
    }

    public static void alterarMoto()
    {
        Scanner input = new Scanner(System.in);
        if(motos.size() == 0)
            return;
        printMoto();
        System.out.println("Informe o indice da moto que deseja alterar as informacoes");
        int ind = input.nextInt();
        Motocicleta temp = new Motocicleta();
        temp = motos.get(ind);
         
        int op;

        System.out.println("1- Numero do chassi");
        System.out.println("2- Marca");
        System.out.println("3- Modelo");
        System.out.println("4- Ano");
        System.out.println("5- Quilometragem");
        System.out.println("6- Tipo do combustivel");
        System.out.println("7- Peso");
        System.out.println("8- Status");
        System.out.println("9- Cilindradas");
        System.out.println("10- Tipo");
        do{
            System.out.println("Escolha a Informacao que deseja alterar: ");
            op = input.nextInt();
        }while(op<1 || op>10);

        if(op == 1)
        {
            int num_chassi;
            do{
                System.out.println("Informe o novo numero do chassi");
                num_chassi = input.nextInt();
            }while(num_chassi < 0.0);
           
            temp.setChassi(num_chassi);
        }

        if(op == 2)
        {
            input.nextLine();
            System.out.println("Informe a nova marca");
            String marca = input.nextLine();
            temp.setMarca(marca);
        }

        if(op == 3)
        {
            System.out.println("Informe o novo modelo");
            String modelo = input.nextLine();
            temp.setModelo(modelo);
        }

        if(op == 4)
        {
            int ano;
            do{
                System.out.println("Informe o novo ano");
                ano = input.nextInt();
            }while(ano < 1900);
            
            temp.setAno(ano);
        }

        if(op == 5)
        {   
            double km;
            do{
                System.out.println("Informe a nova quilometragem");
                km = input.nextDouble();
            }while(km < 0.0);
            
            temp.setKm(km);
        }

        if(op == 6)
        {
            input.nextLine();
            System.out.println("Informe o novo tipo de combustivel");
            String tipo_comb = input.nextLine();
            temp.setComb(tipo_comb);
        }

        if(op == 7)
        {
            double peso;
            do{
                System.out.println("Informe o novo peso");
                peso = input.nextDouble();
            }while(peso < 0.0);
            temp.setPeso(peso);
        }

        if(op == 8)
        {
            if(temp.getStatus())
                temp.setStatus(false);
            else   
                temp.setStatus(true);
        }

        if(op == 9)
        {
            int cilindradas;
            do{
                System.out.println("Informe a nova cilindrada");
                cilindradas = input.nextInt();
            }while(cilindradas < 1);
            temp.setCilindradas(cilindradas);
        }
        
        if(op == 10)
        {
            input.nextLine();
            System.out.println("Informe o novo tipo");
            String tipo = input.nextLine();
            temp.setTipo(tipo);
        }

        motos.set(ind, temp);
    }









    ////////////////////////////////////////////////////////////
    //Backup////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static void backupVenda()
    {
        String arq = "Carros.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                int tipoV = Integer.parseInt(leitor.readLine());
                int id = Integer.parseInt(leitor.readLine());
                int iVend = Integer.parseInt(leitor.readLine());
                int iCli = Integer.parseInt(leitor.readLine());
                int iVeic = Integer.parseInt(leitor.readLine());
                double valor = Double.parseDouble(leitor.readLine());
                int dia = Integer.parseInt(leitor.readLine());
                int mes = Integer.parseInt(leitor.readLine());
                int ano = Integer.parseInt(leitor.readLine());
                int hora = Integer.parseInt(leitor.readLine());
                int min = Integer.parseInt(leitor.readLine());
                Venda temp;
                if(tipoV == 1)
                    temp = Venda(tipoV, id, vend.get(iVend), cli.get(iCli), carros.get(iVeic), null, valor, dia, mes, ano, hora, min);
                else
                    temp = Venda(tipoV, id, vend.get(iVend), cli.get(iCli), null, motos.get(iVeic), valor, dia, mes, ano, hora, min);
                venda.add(temp);
            }
            leitor.close();
        }
        catch(IOException e)
        {
          System.out.println(e);
        }
    }

    public static void backupCarro()
    {
        String arq = "Carros.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                int num_chassi = Integer.parseInt(leitor.readLine());
                String marca = leitor.readLine();
                String modelo = leitor.readLine();
                int ano = Integer.parseInt(leitor.readLine());
                double km = Double.parseDouble(leitor.readLine());
                String tipo_comb = leitor.readLine();
                double peso = Double.parseDouble(leitor.readLine());
                boolean status = Boolean.getBoolean(leitor.readLine());
                double potencia = Double.parseDouble(leitor.readLine());
                int numCilindros = Integer.parseInt(leitor.readLine());
                int numOcupantes = Integer.parseInt(leitor.readLine());
                String tipo = leitor.readLine();
                double altura = Double.parseDouble(leitor.readLine());
                double largura = Double.parseDouble(leitor.readLine());
                double comprimento = Double.parseDouble(leitor.readLine());
                int i = Integer.parseInt(leitor.readLine());

                Carro temp = new Carro(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status, potencia, numCilindros, numOcupantes, tipo, altura, largura, comprimento);
                temp.setInd(i);
                carros.add(temp);
            }
            leitor.close();
        }
        catch(IOException e)
        {
          System.out.println(e);
        }
    }

    public static void backupMoto()
    {
        String arq = "Motos.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                int num_chassi = Integer.parseInt(leitor.readLine());
                String marca = leitor.readLine();
                String modelo = leitor.readLine();
                int ano = Integer.parseInt(leitor.readLine());
                double km = Double.parseDouble(leitor.readLine());
                String tipo_comb = leitor.readLine();
                double peso = Double.parseDouble(leitor.readLine());
                boolean status = Boolean.getBoolean(leitor.readLine());
                int cilindradas = Integer.parseInt(leitor.readLine());
                String tipo = leitor.readLine();
                int i = Integer.parseInt(leitor.readLine());
                
                Motocicleta temp = new Motocicleta(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status, cilindradas, tipo);
                temp.setInd(i);
                motos.add(temp);
            }
            leitor.close();
        }
        catch(IOException e)
        {
          System.out.println(e);
        }
    }

    public static void backupVend()
    {
        String arq = "Vendedores.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                int cpf;
                String nome;
                double salario;
                int dian, mesn, anon, diaa, mesa, anoa, treinamento, i;

                cpf = Integer.parseInt(leitor.readLine());
                nome = leitor.readLine();
                salario = Double.parseDouble(leitor.readLine());
                dian = Integer.parseInt(leitor.readLine());
                mesn = Integer.parseInt(leitor.readLine());
                anon = Integer.parseInt(leitor.readLine());
                diaa = Integer.parseInt(leitor.readLine());
                mesa = Integer.parseInt(leitor.readLine());
                anoa = Integer.parseInt(leitor.readLine());
                treinamento = Integer.parseInt(leitor.readLine());
                i = Integer.parseInt(leitor.readLine());        //Indice do gerente
                int ind = Integer.parseInt(leitor.readLine());  //Indice do vendedor

                Vendedor temp = new Vendedor(cpf, nome, salario, dian, mesn, anon, diaa, mesa, anoa, treinamento, gerentes.get(i));
                temp.setInd(ind);
                vend.add(temp);
            }
            leitor.close();
        }
        catch(IOException e)
        {
            System.out.println("ERRO!\n"+e);
        }
    }

    public static void backupGerente()
    {
        String arq = "Gerentes.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                int cpf;
                String nome;
                double salario;
                int dian, mesn, anon, diaa, mesa, anoa, num, ind;

                cpf = Integer.parseInt(leitor.readLine());
                nome = leitor.readLine();
                salario = Double.parseDouble(leitor.readLine());
                dian = Integer.parseInt(leitor.readLine());
                mesn = Integer.parseInt(leitor.readLine());
                anon = Integer.parseInt(leitor.readLine());
                diaa = Integer.parseInt(leitor.readLine());
                mesa = Integer.parseInt(leitor.readLine());
                anoa = Integer.parseInt(leitor.readLine());
                num = Integer.parseInt(leitor.readLine());
                ind = Integer.parseInt(leitor.readLine());

                Gerente temp = new Gerente(cpf, nome, salario, dian, mesn, anon, diaa, mesa, anoa, num, ind);
                gerentes.add(temp);

                
            }
            leitor.close();
        }
        catch(IOException e)
        {
            System.out.println("ERRO!\n"+e);
        }
    }

    public static int backupLogin()
    {
        String arqVend = "boot.txt";
        
        try
        {
            FileReader arqLeitura = new FileReader(arqVend);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                String user, pass;
                int acesso;
                
                user = leitor.readLine();
                pass = leitor.readLine();
                acesso = Integer.parseInt(leitor.readLine());

                Login temp = new Login(user, pass, acesso);
                cadastros.add(temp);
                users.add(temp.getUser());
            }
            leitor.close();
            return 1;
        }
        catch(IOException e)
        {
            System.out.println("ERRO!\n"+e);
            return 0;
        }


    }


    public static void backupCli()
    {
        String arqCli = "Clientes.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arqCli);
            BufferedReader leitor = new BufferedReader(arqLeitura);

            while(leitor.readLine() != null)
            {
                int cpf;
                String nome;
                int dia, mes, ano, num;
                String rua, bairro, cidade;
                double renda;
                int dependentes;

                cpf = Integer.parseInt(leitor.readLine());
                nome = leitor.readLine();
                dia = Integer.parseInt(leitor.readLine());
                mes = Integer.parseInt(leitor.readLine());
                ano = Integer.parseInt(leitor.readLine());
                rua = leitor.readLine();
                num = Integer.parseInt(leitor.readLine());
                bairro = leitor.readLine();
                cidade = leitor.readLine();
                renda = Double.parseDouble(leitor.readLine());
                dependentes = Integer.parseInt(leitor.readLine());
                int i = Integer.parseInt(leitor.readLine());

                Cliente temp = new Cliente(cpf, nome, dia, mes, ano, rua, num, bairro, cidade, renda, dependentes);
                temp.setInd(i);
                cli.add(temp);
            }
            leitor.close();
        }
        catch(IOException e)
        {
            System.out.println("ERRO!\n"+e);
        }
    }

    //Vendas

    public static void printVenda()
    {
        int i=0;
                
        System.out.println("Vendas: ");
        while(venda.size() > i)
        {
            System.out.println(i);
            venda.get(i).printInfo();
            i++;
        }
    }

    public static void printVendaArq()
    {
        int i=0;

        if(venda.size() > 0)
        {
            venda.get(i).printArq(false);
            i++;
                
            while(venda.size() > i)
            {
                venda.get(i).printArq(true);
                i++;
            }
        }
        else
        {
            try
            {
                File temp = new File("Vendas.txt");
                FileWriter writer = new FileWriter(temp, false);
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
        
    }   









    ////////////////////////////////////////////////////////////
    //Criacao de Objetos////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public static Venda novaVenda()
    {
        
        Scanner input = new Scanner(System.in);

        int tipo_venda;
        int id;
        Vendedor tempvend = new Vendedor();
        Cliente tempcli = new Cliente(); 
        Carro tempcarro = new Carro() ;
        Motocicleta tempmoto = new Motocicleta();
        double valor;
        int dia, mes, ano, hora, min;  //Ja contem o horario

        do
        {
            System.out.println("Digite o tipo da venda: ");
            tipo_venda = input.nextInt();
        }while(tipo_venda != 1 || tipo_venda != 0);

        do
        {
            System.out.println("digite o id da venda: ");
            id = input.nextInt();
        }while(id < 0);
    
        do
        {
            System.out.println("Digite o valor da venda: ");
            valor = input.nextDouble();
        }while(valor < 0.0);

        do
        {
            System.out.println("Digite o dia da venda: ");
            dia = input.nextInt();
        }while(dia<1 || dia>31);

        do
        {
            System.out.println("Digite o mes da venda:");
            mes = input.nextInt(); 
        }while(mes < 1 || mes > 12);

        do
        {
            System.out.println("Digite o ano da venda:");
            ano = input.nextInt(); 
        }while(ano > 2022);

        do
        {
            System.out.println("Digite a hora da venda:");
            hora = input.nextInt(); 
        }while(hora < 0 || hora > 23);

        do
        {
            System.out.println("Digite o minuto da venda:");
            min = input.nextInt(); 
        }while(min < 0 || min > 59);

        Venda temp = new Venda(tipo_venda, id, tempvend, tempcli, tempcarro, tempmoto, valor, dia, mes, ano, hora, min);
        
        return temp;
    }


    public static Carro novoCarro()
    {
        Scanner input = new Scanner(System.in);

        int num_chassi;
        String marca;
        String modelo;
        int ano;
        double km;
        String tipo_comb;
        double peso;
        boolean status;
        double potencia;
        int numCilindros;
        int numOcupantes;
        String tipo;
        double altura;
        double largura;
        double comprimento;

        do{
            System.out.println("Numero do chassi: ");
            num_chassi = input.nextInt();
        }while(num_chassi < 0);

        input.nextLine();
        System.out.println("Marca: ");
        marca = input.nextLine();

        System.out.println("Modelo: ");
        modelo = input.nextLine();

        do{
            System.out.println("Ano: ");
            ano = input.nextInt();
        }while(ano < 1900);

        do{
            System.out.println("Km: ");
            km = input.nextDouble();
        }while(km < 0.0);

        input.nextLine();
        System.out.println("Tipo de combustivel: ");
        tipo_comb = input.nextLine();

        do{
            System.out.println("Peso: ");
            peso = input.nextDouble();
        }while(peso < 0.0);

        status = true;

        do{
            System.out.println("Potencia: ");
            potencia = input.nextDouble();
        }while(potencia < 0.0);

        do{
            System.out.println("Numero de cilindradas: ");
            numCilindros = input.nextInt();
        }while(numCilindros < 0);

        do{
            System.out.println("Numero de ocupantes: ");
            numOcupantes = input.nextInt();
        }while(numOcupantes < 3);

        input.nextLine();
        System.out.println("Tipo: ");
        tipo = input.nextLine();

        do{
            System.out.println("Altura: ");
            altura = input.nextDouble();
        }while(altura < 0.0);

        do{
            System.out.println("Largura: ");
            largura = input.nextDouble();
        }while(largura < 0.0);

        do{
            System.out.println("Comprimento: ");
            comprimento = input.nextDouble();
        }while(comprimento < 0.0);

        Carro temp = new Carro(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status, potencia, numCilindros, numOcupantes, tipo, altura, largura, comprimento);
        return temp;
    }

    public static Motocicleta novoMoto()
    {
        Scanner input = new Scanner(System.in);

        int num_chassi;
        String marca;
        String modelo;
        int ano;
        double km;
        String tipo_comb;
        double peso;
        boolean status;
        int cilindradas;
        String tipo;

        do{
            System.out.println("Numero do chassi: ");
            num_chassi = input.nextInt();
        }while(num_chassi < 0);

        input.nextLine();
        System.out.println("Marca: ");
        marca = input.nextLine();

        System.out.println("Modelo: ");
        modelo = input.nextLine();

        do{
            System.out.println("Ano: ");
            ano = input.nextInt();
        }while(ano < 1900);

        do{
            System.out.println("Km: ");
            km = input.nextDouble();
        }while(km < 0.0);

        input.nextLine();
        System.out.println("Tipo de combustivel: ");
        tipo_comb = input.nextLine();

        do{
            System.out.println("Peso: ");
            peso = input.nextDouble();
        }while(peso < 0.0);

        status = true;

        do{
            System.out.println("Cilindradas: ");
            cilindradas = input.nextInt();
        }while(cilindradas < 0);

        input.nextLine();
        System.out.println("Tipo: ");
        tipo = input.nextLine();

        Motocicleta temp = new Motocicleta(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status, cilindradas, tipo);
        return temp;
    }

    private static Vendedor novoVend()
    {
        Scanner input = new Scanner(System.in);
        int rg;
        String nome;
        double salario;
        int dia_nasc, mes_nasc, ano_nasc;
        int dia_admi, mes_admi, ano_admi;
        int t_treinamento;
        Gerente tempG = new Gerente();
        int indice;

        do{
        System.out.println("Rg: ");
        rg = input.nextInt();
        }while(rg<0);

        input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();

        do{
            System.out.println("Salario: ");
            salario = input.nextDouble();
        }while(salario<0.0);

        do{
        System.out.println("Dia do nascimento: ");
        dia_nasc = input.nextInt();
        }while(dia_nasc < 1 || dia_nasc > 31);
        do{
        System.out.println("Mes do nascimento: ");
        mes_nasc = input.nextInt();
        }while(mes_nasc < 1 || mes_nasc > 12);
        do{
        System.out.println("Ano do nascimento: ");
        ano_nasc = input.nextInt();
        }while(ano_nasc < 1900 || ano_nasc > 2006);

        do{
        System.out.println("Dia da admissao: ");
        dia_admi = input.nextInt();
        }while(dia_admi < 1 || dia_admi >31);
        do{
        System.out.println("Mes da admissao: ");
        mes_admi = input.nextInt();
        }while(mes_admi < 1 || mes_admi > 12);
        do{
        System.out.println("Ano da admissao: ");
        ano_admi = input.nextInt();
        }while(ano_admi < ano_nasc || ano_admi < 1900);

        do{
        System.out.println("Tempo de treinamento: ");
        t_treinamento = input.nextInt();
        }while(t_treinamento < 1);

        input.nextLine();
        System.out.println("Gerente responsavel: ");
        printGer();
        System.out.println("Informe o indice do gerente: ");
        indice = input.nextInt();

        tempG = gerentes.get(indice);
        
        Vendedor temp = new Vendedor(rg, nome, salario, dia_nasc, mes_nasc, ano_nasc, dia_admi, mes_admi, ano_admi, t_treinamento, tempG);

        return temp;
    }

    private static Cliente novoCli()
    {
        Scanner input = new Scanner(System.in);
        int cpf;
        String nome;
        int dia, mes, ano, num;
        String rua, bairro, cidade;
        double renda;
        int dependentes;

        do
        {
            System.out.println("CPF: ");
            cpf = input.nextInt();
        }while(cpf < 1);
       

        input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();

        do
        {
            System.out.println("Dia: ");
            dia = input.nextInt();
        }while(dia<1 || dia>31);
        
        do
        {
            System.out.println("Mes: ");
            mes = input.nextInt();
        }while(mes<1 || mes>12);
        
        do
        {
            System.out.println("Ano: ");
            ano = input.nextInt();
        }while(ano<1900);
        

        input.nextLine();
        System.out.println("Rua: ");
        rua = input.nextLine();
        do
        {
            System.out.println("Numero: ");
            num = input.nextInt();
        }while(num<1);
        
        input.nextLine();
        System.out.println("Bairro: ");
        bairro = input.nextLine();
        System.out.println("Cidade: ");
        cidade = input.nextLine();

        do
        {
            System.out.println("Renda: ");
            renda = input.nextDouble();
        }while(renda<0.0);        

        do
        {
            System.out.println("Dependentes: ");
            dependentes = input.nextInt();
        }while(dependentes<0);

        Cliente temp = new Cliente(cpf, nome, dia, mes, ano, rua, num, bairro, cidade, renda, dependentes);
        return temp;
    }
    
    private static Login novoLogin(int ac)
    {
        Scanner input = new Scanner(System.in);
        String user, password;
        System.out.println("\n\tCrie seu login!");
        do
        {
            System.out.println("User: ");
            user = input.nextLine();
        }while(users.contains(user));
        
        System.out.println("Senha: ");
        password = input.nextLine();

        Login temp = new Login(user, password, ac);

        return temp;
    }

    private static Gerente novoGerente()
    {
        Scanner input = new Scanner(System.in);
        int rg, anos_exp;
        String nome;
        double salario;
        int dia_nasc, dia_admi, mes_nasc, mes_admi, ano_nasc, ano_admi;
        
        do
        {
            System.out.println("RG: ");
            rg = input.nextInt();
        }while(rg<1);

        input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();

        do
        {
            System.out.println("Salario: ");
            salario = input.nextDouble();
        }while(salario<1.0);

        do
        {
            System.out.println("Dia Nascimento: ");
            dia_nasc = input.nextInt();
        }while(dia_nasc<1 || dia_nasc>31);

        do
        {
            System.out.println("Mes Nascimento: ");
            mes_nasc = input.nextInt();
        }while(mes_nasc<1 || mes_nasc>12);

        do
        {
            System.out.println("Ano Nascimento: ");
            ano_nasc = input.nextInt();
        }while(ano_nasc<1900 || ano_nasc>2022);

        do
        {
            System.out.println("Dia Admissao: ");
            dia_admi = input.nextInt();
        }while(dia_admi<1 || dia_admi>31);

        do
        {
            System.out.println("Mes Admissao: ");
            mes_admi = input.nextInt();
        }while(mes_admi<1 || mes_admi>12);

        do
        {
            System.out.println("Ano Admissao: ");
            ano_admi = input.nextInt();
        }while(ano_admi<1900 || ano_admi>2022);

        do
        {
            System.out.println("Anos de Experiencia: ");
            anos_exp = input.nextInt();
        }while(anos_exp<1);

        Gerente temp = new Gerente(rg, nome, salario, dia_nasc, mes_nasc, ano_nasc, dia_admi, mes_admi, ano_admi, anos_exp);
        
        return temp;
    }








    ////////////////////////////////////////////////////////////
    //Login/////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    private static int fazerLogin()
    {
        Scanner input = new Scanner(System.in);
        String user, password;
        int tentativas = 0;
        boolean flag = false;

        System.out.println("User: ");
        user = input.nextLine();
        while(!users.contains(user))
        {
            System.out.println("Usuario invalido!\nUser: ");
            user = input.nextLine();
        }
        
        int i = users.indexOf(user);
        
        Login temp = cadastros.get(i);
        
        System.out.println("Senha: ");
        password = input.nextLine();
        
        while(tentativas<3)
        {
            if(temp.getPassword().equals(password))
            {
                flag = true;
                break;
            }
            tentativas++;
            System.out.println("Senha: ");
            password = input.nextLine();

        }

        if(flag)
            return temp.getAcesso();

        System.out.println("Suas tentativas acabaram!");
        return 0;
    }

    public static void printLoginArq()
    {
        int i=0;

        cadastros.get(i).printArq(false);
        i++;
                
        while(cadastros.size() > i)
        {
            cadastros.get(i).printArq(true);
            i++;
        }
    }
}



