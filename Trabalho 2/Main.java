import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main
{
    public static ArrayList<Login> cadastros = new ArrayList<>();
    public static ArrayList<String> users = new ArrayList<>();
    public static ArrayList<Cliente> cli = new ArrayList<>();
    public static ArrayList<Vendedor> vend = new ArrayList<>();
    public static ArrayList<Carro> carros = new ArrayList<>();
    public static ArrayList<Motocicleta> motos = new ArrayList<>();

    

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String arqBoot = "boot.txt";
        String arqCli = "Clientes.txt";

        int dados_arq;
        try
        {
            FileReader arqLeitura = new FileReader(arqBoot);
            BufferedReader leitor = new BufferedReader(arqLeitura);
            dados_arq = Integer.parseInt(leitor.readLine());
            
            if(dados_arq != 0)
            {
                String user = leitor.readLine();
                String pass = leitor.readLine();
                int acss= Integer.parseInt(leitor.readLine());
                
                Login admin = new Login(user, pass, acss);
                cadastros.add(admin);
                users.add(admin.getUser());

                backupCli();
            }
        }
        catch(IOException e)
        {
            dados_arq=0;
        }
            
        if(dados_arq == 0)
        {
            try
            {
                System.out.println("\n\n\n\tBem vindo ao sistema de vendas!\n\nPara continuar faca o cadastro do gerente local");

                File arq = new File(arqBoot);
                FileWriter escritor = new FileWriter(arq, true);   
                escritor.write("1\n");

                Gerente gerente_local = new Gerente();
                gerente_local = novoGerente();
                Login admin = new Login("admin", "adminpass", 3);
                cadastros.add(admin);
                users.add(admin.getUser());
                escritor.write("admin\nadminpass\n3");
                escritor.close();

                //File arquivoCli = new File(arqCli);
                //FileWriter escritor = new FileWriter(arquivoCli, true);      
                //escritor.write("1\n");
                //escritor.close();
            }
            catch(IOException e)
            {
                System.out.println("Erro!\n"+e);
            }

        }
            
        //else
        //Recuperar dados nos arquivos e reconstruir os ArrayList
        

        
        int flag = 1;
        int acesso = fazerLogin();
        int log = 0;
        do
        {
            if(log == 1)
                acesso = fazerLogin();

            System.out.println(acesso);

            if(acesso == 2)
                flag = menuVendedor(false);

            if(acesso == 3)
                flag = menuGerente();

            
            log = 1;
        }while(acesso != 0 && flag == 1);

        printCliArq();        
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

            System.out.println("13- Mais opcoes");
            System.out.println("14- Trocar Login");
            System.out.println("0- Sair");
            System.out.println("-----------------------------------");
            do
            {
                System.out.println("Selecione uma opcao!");
                op = input.nextInt();
            }while(op<0 || op>14);

            if(op ==1)  //Cadastrar cliente
            {
                Cliente temp = new Cliente();
                temp = novoCli();
                cli.add(temp);
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

            if(op == 5)
            {
                //novoVend();
            }

            

            if(op == 13) 
            {
                int quak = menuVendedor(true);
            }

            if(op == 14) return 1;

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


            if(op == 6 && !g) return 1;

            if(op == 0) return 0;
        }
        return 0;
    }

    //Vendedor
    
    public static void alterarVend()
    {
        Scanner input = new Scanner(System.in);
        int ind, opVend;

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
            opCli = input.nextInt();
        }while(opCli<1 || opCli>7);

        if(opCli == 1)
        {
            int temprg;
            do
            {
                System.out.println("Informe o novo RG:");
                temprg = input.nextInt();
            }while(temprg < 0);
                        
            temp.setRg(temprg);
        }

        if(op == 2)
        {
            String nome;
            System.out.println("Informe o novo nome: ");
            nome = input.nextLine();
            temp.setNome(nome);
        }

        if(op == 3)
        {
            double sal;
            do
            {
                System.out.println("Informe o novo salario: ");
                sal = input.nextDouble;    
            }while(sal<0.0);
            temp.setSalario(sal);
        }

        if(op == 4)
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

        if(op == 5)
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
                   
            temp.setDataAdmi(tempdia, tempmes, tempano);
        }

        if(op == 6)
        {
            int t;
            do
            {
                System.out.println("Informe o novo tempo de treinamento: ");
                t = input.nextInt();
            }while(t<0);
            temp.setTempoTreino(t);
        }

        if(op == 7)
        {
            int opG
            //printGerente();
            System.out.println("Informe o indice do do novo Gerente: ");
            opG = input.nextInt();
            //Gerente tempg = new Gerente();
            //tempg = ArrayGerentes.get(opG);
            //temp.setGerente(tempg);
        }

    }

    //Cliente

    public static void alterarCli()
    {
        Scanner input = new Scanner(System.in);
        int ind, opCli;
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
        }while(opCli<1 || opCli>6);

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

    /////////////////////////////////////////////

    public static void printCliArq()
    {
        int i=0;

        cli.get(i).printArq(false);
        i++;
                
        while(cli.size() > i)
        {
            cli.get(i).printArq(true);
            i++;
        }
    }

    /////////////////////////////////////////////

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
     ////////////////////////////////////////////
    public static void printCarroArq()
    {
        int i=0;

        carros.get(i).printArq(false);
        i++;
                
        while(carros.size() > i)
        {
            carros.get(i).printArq(true);
            i++;
        }
    }

    ////////////////////////////////////////////
    public static void printCarro()
    {
        int i=0;
                
        while(carros.size() > i)
        {
            System.out.println(i);
            carros.get(i).printInfo();
            i++;
        }
    }
    ///////////////////////////////////////////
    public static void printMotoArq()
    {
        int i=0;

        motos.get(i).printArq(false);
        i++;
                
        while(motos.size() > i)
        {
            motos.get(i).printArq(true);
            i++;
        }
    }    
    ///////////////////////////////////////////
    public static void printMoto()
    {
        int i=0;
                
        while(motos.size() > i)
        {
            System.out.println(i);
            motos.get(i).printInfo();
            i++;
        }
    }


    //Backup

    public static void backupCli()
    {
        int on;
        String arqCli = "Clientes.txt";

        try
        {
            FileReader arqLeitura = new FileReader(arqCli);
            BufferedReader leitor = new BufferedReader(arqLeitura);
            String lin;

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

                Cliente temp = new Cliente(cpf, nome, dia, mes, ano, rua, num, bairro, cidade, renda, dependentes);
                cli.add(temp);

                
            }
        }
        catch(IOException e)
        {
            System.out.println("ERRO!\n"+e);
        }
    }

    //Criacao de Objetos

     private static Veiculo novoVeiculo(){
        Scanner input = new Scanner(System.in);
        int num_chassi;
        String marca;
        String modelo;
        int ano;
        double km;
        String tipo_comb;
        double peso;
        boolean status;

        System.out.println("Numero do chassi: ");
        num_chassi = input.nextInt();

        System.out.println("Marca: ");
        marca = input.nextLine();

        System.out.println("Modelo: ");
        modelo = input.nextLine();

        System.out.println("Ano: ");
        ano = input.nextInt();

        System.out.println("Km: ");
        km = input.nextDouble();

        System.out.println("Tipo de combustivel: ");
        tipo_comb = input.nextLine();

        System.out.println("Peso: ");
        peso = input.nextDouble();
        
        System.out.println("Status: ");
        status = input.nextBoolean();

        Veiculo temp = new Veiculo(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status);

        return temp;
    }

    private static Vendedor novoVend()
    {
        scanner input = new Scanner(system.in);
        int rg;
        String nome;
        double salario;
        int dia_nasc, mes_nasc, ano_nasc;
        int dia_admi, mes_admi, ano_admi;
        int t_treinamento;
        Gerente temp;
        int indice;

        do{
        System.out.println("Rg: ");
        rg = input.nextInt();
        }while(rg<0);

        input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();

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
        }while(ano_admi < ano<nasc || ano_admi < 1900);

        do{
        System.out.println("Tempo de treinamento: ");
        t_treinamento = input.nextInt();
        }while(t_treinamento < 1);

        input.nextLine();
        System.out.println("Gerente responsavel: ");
        //printGerente()
        System.out.println("Informe o indice do gerente: ");
        indice = input.nextInt();

        Gerente temp = new Gerente();
        //temp = ArrayGerente.get(indice);

        //menuzinho dos gerentes
        
        
        
        Vendedor temp = new Vendedor(rg, nome, salario, dia_nasc, mes_nasc, ano_nasc, dia_admi, mes_admi, ano_admi, t_treinamento, temp);

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

    ////////////////////////////////////////////////////////////

    
    private static Login novoLogin()
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

        Login temp = new Login(user, password);

        return temp;
    }

    /////////////////////////////////////////////////////////////////////

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

    //Login

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


}

