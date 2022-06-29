public class Vendedor extends Funcionario
{
    private int t_treinamento;
    private Gerente gerente_r;

    //Construtores
    public Vendedor(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int acesso ,int t_treinamento, Gerente gr)
    {
        super(rg, nome, salario, dia_nasc, mes_nasc, ano_nasc, dia_admi, mes_admi, ano_admi, 2);
        this.t_treinamento = t_treinamento;
        this.gerente_r = gr;
    }

    public Vendedor()
    {
        this(0, "", 0.0, 0, 0, 0, 0, 0, 0, 0, 0, null);
    }

    //Setters
    public void setTempoTreino(int t)
    {
        this.t_treinamento = t;
    }

    public void setGerente(Gerente g)
    {
        this.gerente_r = g;
    }

    //Getters
    public int getTempoTreino()
    {
        return this.t_treinamento;
    }

    public Gerente getGerente()
    {
        return this.gerente_r;
    }
}