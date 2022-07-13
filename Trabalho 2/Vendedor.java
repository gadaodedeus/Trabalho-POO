import java.io.*;

public class Vendedor extends Funcionario
{
    private int t_treinamento;
    private Gerente gerente_r;
    private static int acesso = 2;
    private int ind;

    //Construtores
    public Vendedor(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int t_treinamento, Gerente gr)
    {
        this.rg=rg;
        this.nome=nome;
        this.salario=salario;
        this.data_nasc= new Date(dia_nasc, mes_nasc, ano_nasc);
        this.data_admi= new Date(dia_admi, mes_admi, ano_admi);
        this.t_treinamento = t_treinamento;
        this.gerente_r = gr;
    }

    public Vendedor()
    {
        this(0, "", 0.0, 0, 0, 0, 0, 0, 0, 0, null);
    }

    //Setters
    public void setInd(int i)
    {
        this.ind = i;
    }

    public void setRg(int rg)
    {
        this.rg = rg;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setSalario(double salario)
    {
        this.salario = salario;
    }

    public void setDataNascimento(Date nasc)
    {
        this.data_nasc = nasc;
    }

    public void setDataAdmi(Date admi)
    {
        this.data_admi = admi;
    }

    public void setTempoTreino(int t)
    {
        this.t_treinamento = t;
    }

    public void setGerente(Gerente g)
    {
        this.gerente_r = g;
    }

    //Getters
    public int getInd()
    {
        return this.ind;
    }

    public int getRg()
    {
        return this.rg;
    }

    public String getNome()
    {
        return this.nome;
    }

    public double getSalario()
    {
        return this.salario;
    }

    public Date getDataNascimento()
    {
        return this.data_nasc;
    }

    public Date getDataAdmi()
    {
        return this.data_admi;
    }

    public int getTempoTreino()
    {
        return this.t_treinamento;
    }

    public Gerente getGerente()
    {
        return this.gerente_r;
    }

    public int getAcesso()
    {
        return this.acesso;
    }

    public void printInfo()
    {
        System.out.println("------------------------------\n");
        System.out.println("CPF: "+getRg());
        System.out.println("Nome: "+getNome());
        System.out.println("Salario: R$ "+getSalario());
        System.out.println("Data Nascimento: "+getDataNascimento().getDia()+"/"+getDataNascimento().getMes()+"/"+getDataNascimento().getAno());
        System.out.println("Data Admissao: "+getDataAdmi().getDia()+"/"+getDataAdmi().getMes()+"/"+getDataAdmi().getAno());
        System.out.println("Tempo de treinamento: "+getTempoTreino());
        System.out.println("Gerente: "+getGerente().getNome());
        System.out.println("------------------------------\n");
    }

    public void printArq(boolean x)
    {
        String arq = "Vendedores.txt";
        try
        {
            Date datanasc = new Date();
            Date dataad = new Date();
            Gerente ger = new Gerente();
            File arquivo = new File(arq);
            FileWriter escritor = new FileWriter(arquivo, x); 
            
            escritor.write("1\n");
            escritor.write(this.getRg()+"\n");
            escritor.write(this.getNome()+"\n");
            escritor.write(this.getSalario()+"\n");
            datanasc = getDataNascimento();
            escritor.write(datanasc.getDia()+"\n");
            escritor.write(datanasc.getMes()+"\n");
            escritor.write(datanasc.getAno()+"\n");
            dataad = getDataAdmi();
            escritor.write(dataad.getDia()+"\n");
            escritor.write(dataad.getMes()+"\n");
            escritor.write(dataad.getAno()+"\n");
            escritor.write(this.getTempoTreino()+"\n");
            ger = getGerente();
            escritor.write(getGerente().getIndice()+"\n");
            escritor.write(getInd()+"\n");
            escritor.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro!\n"+e);
        }
    }
}