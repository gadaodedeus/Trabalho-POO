import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario{
  protected int rg;
  protected String nome;
  protected double salario;
  protected Date data_nasc;
  protected Date data_admi;
  protected int acesso;       //1: Cliente //2: Vendedor //3: Gerente
  protected Login log;

  //construtores
  public Funcionario(int rg, String nome, double salario, int dia_nasc, int mes_nasc, int ano_nasc, int dia_admi, int mes_admi, int ano_admi, int acesso)
  {
    this.rg=rg;
    this.nome=nome;
    this.salario=salario;
    this.data_nasc= new Date(dia_nasc, mes_nasc, ano_nasc);
    this.data_admi= new Date(dia_admi, mes_admi, ano_admi);
    this.acesso = acesso;
  }

  public Funcionario(int rg,String nome, double salario)
  {
    this(rg, nome, salario, 1, 1, 1, 1, 1, 1,1);
  }

  public Funcionario()
  {
    this(0,"", 0.0,1,1,1,1,1,1,1);
  }

  //setters
  public void setLogin(Login x)
  {
    this.log = x;
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
  public void setData_nasc(int dia_nasc, int mes_nasc, int ano_nasc)
  {
    this.data_nasc= new Date(dia_nasc, mes_nasc, ano_nasc);
  }
  public void setData_admi(int dia_admi, int mes_admi, int ano_admi)
  {
    this.data_nasc= new Date(dia_admi, mes_admi, ano_admi);
  }

  //getters
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
  public int getDia_nasc()
  {
    return this.data_nasc.getDia();
  }
  public int getMes_nasc()
  {
    return this.data_nasc.getMes();
  }
   public int getAno_nasc()
  {
    return this.data_nasc.getAno();
  }
   public int getDia_admi()
  {
    return this.data_admi.getDia();
  }
   public int getMes_admi()
  {
    return this.data_admi.getMes();
  }
   public int getAno_admi()
  {
    return this.data_admi.getAno();
  }
  
}