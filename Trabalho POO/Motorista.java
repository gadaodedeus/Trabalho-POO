import java.util.ArrayList;
import java.util.Scanner;

public class Motorista
{
  private String nome;
  private int numero_cnh;
  private Date dataAdmissao;
  public ArrayList<Onibus> bus = new ArrayList<>(); //Onibus que este motorista dirige

  static Scanner input = new Scanner(System.in);

  //construtores

  public Motorista (String nome, int numero_cnh, int diaAdmissao, int mesAdmissao, int anoAdmissao)
  {
    this.nome = nome;
    this.numero_cnh = numero_cnh;
    this.dataAdmissao = new Date(diaAdmissao, mesAdmissao, anoAdmissao);

  }
  
  public Motorista(String nome, int numero_cnh)
  {
    this(nome, numero_cnh, 1, 1, 1);
  }
  public Motorista ()
  {
    this("", 0, 1, 1, 1);
  }
  

  //setters

  public void setNome (String nome)
  {
    this.nome = nome;
  }
  public void setNumero_cnh (int numero_cnh)
  {
    this.numero_cnh = numero_cnh;
  }
  public void setdataAdmissao (int diaAdmissao, int mesAdmissao, int anoAdmissao)
  {
    this.dataAdmissao = new Date(diaAdmissao, mesAdmissao, anoAdmissao);
  }

  public void setBus(Onibus b)
  {
    bus.add(b);
  }

  //getters

  public String getNome ()
  {
    return this.nome;
  }
  public int getNumero_cnh ()
  {
    return this.numero_cnh;
  }
  public int getdiaAdmissao ()
  {
    return this.dataAdmissao.getDia();
  }
  public int getmesAdmissao ()
  {
    return this.dataAdmissao.getMes();
  }
  public int getanoAdmissao ()
  {
    return this.dataAdmissao.getAno();
  }

  //prints

  public void printBus()
  {
    for(int i=0;i<bus.size(); i++)
      bus.get(i).printInfo();

  }

  public void printInfo()
  {
    System.out.println("---------------------------------");
    System.out.println("Nome: "+this.nome);
    System.out.println("CNH: "+this.numero_cnh);
    System.out.println("Data de admissão: "+this.getdiaAdmissao()+"/"+this.getmesAdmissao()+"/"+this.getanoAdmissao());
    System.out.println("---------------------------------");
  }
}
