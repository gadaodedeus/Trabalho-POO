public class Gerente extends Funcionario
{
    private int anos_exp;
    private static int acesso = 3;

    public Gerente(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int exp)
    {
        this.rg=rg;
        this.nome=nome;
        this.salario=salario;
        this.data_nasc= new Date(dia_nasc, mes_nasc, ano_nasc);
        this.data_admi= new Date(dia_admi, mes_admi, ano_admi);
        this.anos_exp = exp;
    }

    public Gerente()
    {
        this(0,"",0.0,0,0,0,0,0,0,0);
    }

    public void setAnos(int anos)
    {
        this.anos_exp = anos;
    }

    public int getAnos()
    {
        return this.anos_exp;
    }

    public int getAcesso()
    {
        return this.acesso;
    }
}

