public class Endereco
{
    private String rua;
    private int num;
    private String bairro;
    private String cidade;

    //Construtores
    public Endereco(String rua, int num, String bairro, String cidade)
    {
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco()
    {
        this("", 0, "", "");
    }

    //Setters
    public void setRua(String rua)
    {
        this.rua = rua;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    //Getters
    public String getRua()
    {
        return this.rua;
    }

    public int getNum()
    {
        return this.num;
    }

    public String getBairro()
    {
        return this.bairro;
    }

    public String getCidade()
    {
        return this.cidade;
    }

}