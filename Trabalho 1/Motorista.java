public class Motorista
{
  private String nome;
  private int numero_cnh;
  private Date admissao;

  //construtores

  public Motorista (String nome, int numero_cnh, Date admissao)
  {
    this.nome = nome;
    this.numero_cnh = numero_cnh;
    this admissao = admissao;
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
  public void setAdmissao (Date admissao)
  {
    this.admissao = admissao;
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
