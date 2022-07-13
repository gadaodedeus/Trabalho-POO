import java.io.*;

public class Cliente
{
    private int cpf;
    private String nome;
    private Date data_nasc;
    private Endereco endereco;
    private double renda;
    private int dependentes;
    private int ind;

    //Construtores
    public Cliente(int cpf, String nome, int dia, int mes, int ano, String rua, int num, String bairro, String cidade, double renda, int dependentes)
    {
        this.cpf = cpf;
        this.nome = nome;
        Date temp = new Date(dia, mes, ano);
        this.data_nasc = temp;
        Endereco end = new Endereco(rua, num, bairro, cidade);
        this.endereco = end;
        this.renda = renda;
        this.dependentes = dependentes;
    }

    public Cliente(int cpf, String nome)
    {
        this(cpf, nome, 0, 0, 0, "", 0, "", "", 0.0, 0);
    }

    public Cliente()
    {
        this(0, "", 0, 0, 0, "", 0, "", "", 0.0, 0);
    }

    //Setters
    public void setInd(int i)
    {
        this.ind = i;
    }

    public void setCpf(int cpf)
    {
        this.cpf = cpf;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setDataNascimento(int dia, int mes, int ano)
    {
        Date temp = new Date(dia, mes, ano);
        this.data_nasc = temp;
    }

    public void setEndereco(String rua, int num, String bairro, String cidade)
    {
        Endereco end = new Endereco(rua, num, bairro, cidade);
        this.endereco = end;
    }

    public void setRenda(double renda)
    {
        this.renda = renda;
    }

    public void setDependentes(int dep)
    {
        this.dependentes = dep;
    }

    //Getters
    public int getInd()
    {
        return this.ind;
    }

    public int getCpf()
    {
        return this.cpf;
    }

    public String getNome()
    {
        return this.nome;
    }

    public Date getDataNascimento()
    {
        return this.data_nasc;
    }

    public Endereco getEndereco()
    {
        return this.endereco;
    }

    public double getRenda()
    {
        return this.renda;
    }

    public int getDependentes()
    {
        return this.dependentes;
    }

    public void printArq(boolean x)
    {
        String arqCli = "Clientes.txt";
        try
        {
            Date dataux = new Date();
            Endereco endaux = new Endereco();
            File arquivoCli = new File(arqCli);
            FileWriter escritorCli = new FileWriter(arquivoCli, x); 
            
            escritorCli.write("1\n");
            escritorCli.write(this.getCpf()+"\n");
            escritorCli.write(this.getNome()+"\n");
            dataux = getDataNascimento();
            escritorCli.write(dataux.getDia()+"\n");
            escritorCli.write(dataux.getMes()+"\n");
            escritorCli.write(dataux.getAno()+"\n");
            endaux = getEndereco();
            escritorCli.write(endaux.getRua()+"\n");
            escritorCli.write(endaux.getNum()+"\n");
            escritorCli.write(endaux.getBairro()+"\n");
            escritorCli.write(endaux.getCidade()+"\n");
            escritorCli.write(this.getRenda()+"\n");
            escritorCli.write(this.getDependentes()+"\n");
            escritorCli.write(this.getInd()+"\n");
            escritorCli.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro!\n"+e);
        }
    }

    public void printInfo()
    {
        System.out.println("------------------------------\n");
        System.out.println("CPF: "+getCpf());
        System.out.println("Nome: "+getNome());
        System.out.println("Data Nascimento: "+getDataNascimento().getDia()+"/"+getDataNascimento().getMes()+"/"+getDataNascimento().getAno());
        System.out.println("Endereco: \n"+getEndereco().getRua()+", "+getEndereco().getNum()+"\n"+getEndereco().getBairro()+", "+getEndereco().getCidade());
        System.out.println("Renda: R$"+getRenda());
        System.out.println("Dependentes: "+getDependentes());
        System.out.println("------------------------------\n");
    }

}