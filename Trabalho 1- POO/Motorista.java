public class Motorista
{
  private String nome;
  private int numero_cnh;
  private Date dataAdmissao;

  //construtores

  public Motorista (String nome, int numero_cnh, int diaAdmissao, int mesAdmissao, int anoAdmissao)
  {
    this.nome = nome;
    this.numero_cnh = numero_cnh;
    this dataAdmissao = new Date(diaAdmissao, mesAdmissao, anoAdmissao);
  }
  
  public Motorista(String nome, int numero_cnh)
  {
    this(nome, numero_cnh, 0, 0, 0);
  }
  public Motorista ()
  {
    this ("", 0, 0)
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

  //getters

  public String getNome ()
  {
    return this.nome;
  }
  public int getNumero_cnh ()
  {
    return this.numero_cnh;
  }
  public Date getAdmissao ()
  {
    return this.admissao;
  }
}
