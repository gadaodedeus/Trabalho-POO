import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main
{
    public static ArrayList<Login> cadastros = new ArrayList<>();
    public static ArrayList<String> users = new ArrayList<>();
    public static ArrayList<Cliente> cli = new ArrayList<>();

    

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

            if(acesso == 3)
                flag = menuGerente();

            
            log = 1;
        }while(acesso != 0 && flag == 1);

        
    }

    private static int menuGerente()
    {
        Scanner input = new Scanner(System.in);
        int op;
        boolean on = true;
        while(on)
        {
            System.out.println("-----------------------------------");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Alterar Cliente");
            System.out.println("3- Excluir Cliente");
            System.out.println("4- Mostrar Clientes");

            System.out.println("5- Cadastrar Funcionario");
            System.out.println("6- Alterar Funcionario");
            System.out.println("7- Excluir Funcionario");
            System.out.println("8- Mostrar Funcionarios");

            System.out.println("9- Cadastrar Veiculo");
            System.out.println("10- Alterar Veiculo");
            System.out.println("11- Excluir Veiculo");
            System.out.println("12- Mostrar Veiculos");

            System.out.println("13- Trocar Login");
            System.out.println("0- Sair");
            System.out.println("-----------------------------------");
            do
            {
                System.out.println("Selecione uma opcao!");
                op = input.nextInt();
            }while(op<0 || op>13);

            if(op ==1)
            {
                Cliente temp = new Cliente();
                temp = novoCli();
                cli.add(temp);
                temp.printArq(true);
            }   

            if(op == 2)
            {
                if(cli.size() > 0)
                    alterarCli();  
                else
                    System.out.println("Nao ha clientes cadastrados");
            } 

            if(op == 3)
            {
                if(cli.size() == 0)
                    System.out.println("Nao ha clientes cadastrados");

                else if(cli.size() == 1)
                {
                    String arqCli = "Clientes.txt";
                    cli.removeAll(cli);
                    try
                    {
                        File arquivoCli = new File(arqCli);
                        FileWriter escritorCli = new FileWriter(arquivoCli, false); 
                    }
                    catch(IOException e)
                    {
                        System.out.println(e);
                    }
                }
                else
                {
                    int ind;
                    printCli();
                    System.out.println("Informe o indice do cliente a ser removido: ");
                    ind = input.nextInt();
                    Cliente temp = new Cliente();
                    temp = cli.remove(ind);
                    printCliArq();
                }
                
            }

            if(op == 4)
            {
                if(cli.size() > 0)
                    printCli();
                else
                    System.out.println("Nao ha clientes cadastrados");
            } 


            
            if(op == 13) return 1;

            if(op == 0) return 0;
        }
        return 0;
    }

    public static void alterarCli()
    {
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
            op = input.nextInt();
        }while(op<1 || op>6);

        if(op == 1)
        {
            int tempcpf;
            do
            {
                System.out.println("Informe o novo CPF:");
                tempcpf = input.nextInt();
            }while(tempcpf < 0);
                        
            temp.setCpf(tempcpf);
        }

        if(op == 2)
        {
            String tempnome;
            input.nextLine();
            System.out.println("Informe o novo nome:");
            tempnome = input.nextLine();
            temp.setNome(tempnome);
        }

        if(op == 3)
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

        if(op == 4)
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

        if(op == 5)
        {
            double temprenda;
            do
            {
                System.out.println("Informe a nova renda: ");
                temprenda = input.nextDouble();
            }while(temprenda<0.0);
            temp.setRenda(temprenda);
        }

        if(op == 6)
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
        printCliArq();
    }

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

    private static Cliente novoCli()
    {
        Scanner input = new Scanner(System.in);
        int cpf;
        String nome;
        int dia, mes, ano, num;
        String rua, bairro, cidade;
        double renda;
        int dependentes;

        System.out.println("CPF: ");
        cpf = input.nextInt();

        input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("Dia: ");
        dia = input.nextInt();
        System.out.println("Mes: ");
        mes = input.nextInt();
        System.out.println("Ano: ");
        ano = input.nextInt();

        input.nextLine();
        System.out.println("Rua: ");
        rua = input.nextLine();
        System.out.println("Numero: ");
        num = input.nextInt();
        input.nextLine();
        System.out.println("Bairro: ");
        bairro = input.nextLine();
        System.out.println("Cidade: ");
        cidade = input.nextLine();

        System.out.println("Renda: ");
        renda = input.nextDouble();

        System.out.println("Dependentes: ");
        dependentes = input.nextInt();



        Cliente temp = new Cliente(cpf, nome, dia, mes, ano, rua, num, bairro, cidade, renda, dependentes);


        return temp;
    }

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

    

}

