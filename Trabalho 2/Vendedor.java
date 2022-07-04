public class Vendedor extends Funcionario
{
    private int t_treinamento;
    private Gerente gerente_r;
    private static int acesso = 2;

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
}