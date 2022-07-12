import java.util.ArrayList;
import java.util.Scanner;

public abstract class Funcionario{
  protected int rg;
  protected String nome;
  protected double salario;
  protected Date data_nasc;
  protected Date data_admi;

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

  public Date getDataNascimento()
  {
    return this.data_nasc;
  }
  public Date getDataAdmi()
  {
    return this.data_admi;
  }
  
}