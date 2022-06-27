import java.io.*;

public class Cliente
{
    private int cpf;
    private String nome;
    private Date data_nasc;
    private Endereco endereco;
    private double renda;
    private int dependentes;

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

    public void printInfo()
    {
        String arqCli = "Clientes.txt";
        try
        {
            File arquivoCli = new File(arqCli);
            FileWriter escritorCli = new FileWriter(arquivoCli, true); 
            escritorCli.write("------------------------------\n");
            escritorCli.write("CPF: "+this.getCpf()+"\n");
            escritorCli.write("Nome: "+this.getNome()+"\n");
            escritorCli.write("------------------------------\n");
            escritorCli.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro!\n"+e);
        }
    }

}