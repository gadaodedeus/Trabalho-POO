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
            System.out.println("4- Cadastrar Funcionario");
            System.out.println("5- Alterar Funcionario");
            System.out.println("6- Excluir Funcionario");
            System.out.println("7- Cadastrar Veiculo");
            System.out.println("8- Alterar Veiculo");
            System.out.println("9- Excluir Veiculo");
            System.out.println("10- Trocar Login");
            System.out.println("0- Sair");
            System.out.println("-----------------------------------");
            do
            {
                System.out.println("Selecione uma opcao!");
                op = input.nextInt();
            }while(op<0 || op>10);

            if(op ==1)
            {
                Cliente temp = new Cliente();
                temp = novoCli();
                cli.add(temp);
                temp.printInfo();
            }   

            
            if(op == 10) return 1;

            if(op == 0) return 0;
        }
        return 0;
    }

    private static Cliente novoCli()
    {
        Scanner input = new Scanner(System.in);
        int cpf;
        String nome;
        System.out.println("CPF: ");
        cpf = input.nextInt();
        input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();
        Cliente temp = new Cliente(cpf, nome);


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

