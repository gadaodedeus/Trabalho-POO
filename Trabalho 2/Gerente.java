public class Gerente extends Funcionario
{
    private int anos_exp;

    public Gerente(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int exp)
    {
        super(rg, nome, salario, dia_nasc, mes_nasc, ano_nasc, dia_admi, mes_admi, ano_admi, 3);
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
}

