import java.io.*;

public class Gerente extends Funcionario
{
    private int anos_exp;
    private static int acesso = 3;
    private int indice;

    public Gerente(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int exp)
    {
        this.rg=rg;
        this.nome=nome;
        this.salario=salario;
        this.data_nasc= new Date(dia_nasc, mes_nasc, ano_nasc);
        this.data_admi= new Date(dia_admi, mes_admi, ano_admi);
        this.anos_exp = exp;
    }

    public Gerente(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int exp, int i)
    {
        this.rg=rg;
        this.nome=nome;
        this.salario=salario;
        this.data_nasc= new Date(dia_nasc, mes_nasc, ano_nasc);
        this.data_admi= new Date(dia_admi, mes_admi, ano_admi);
        this.anos_exp = exp;
        this.indice = i;
    }

    public Gerente()
    {
        this(0,"",0.0,0,0,0,0,0,0,0);
    }

    public void setAnos(int anos)
    {
        this.anos_exp = anos;
    }

    public void setIndice(int i)
    {
        this.indice = i;
    }

    public int getAnos()
    {
        return this.anos_exp;
    }

    public int getAcesso()
    {
        return this.acesso;
    }

    public int getIndice()
    {
        return this.indice;
    }

    public void printInfo()
    {
        System.out.println("------------------------------\n");
        System.out.println("CPF: "+getRg());
        System.out.println("Nome: "+getNome());
        System.out.println("Salario: R$ "+getSalario());
        System.out.println("Data Nascimento: "+getDia_nasc()+"/"+getMes_nasc()+"/"+getAno_nasc());
        System.out.println("Data Admissao: "+getDia_admi()+"/"+getMes_admi()+"/"+getAno_admi());
        System.out.println("Anos de Experiencia: "+getAnos());
        System.out.println("------------------------------\n");
    }

    public void printArq(boolean x)
    {
        
        try
        {
            String arq = "Gerentes.txt";
            Date datanasc = new Date();
            Date dataad = new Date();
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
            escritor.write(this.getAnos()+"\n");
            escritor.write(this.getIndice()+"\n");
            escritor.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro!\n"+e);
        }
    }

    public void setDataNascimento(Date nasc){
        this.data_nasc = nasc;
    }

    public void setDataAdmi(Date admi)
    {
        this.data_admi = admi;
    }
}

