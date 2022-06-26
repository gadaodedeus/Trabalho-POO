public class Veiculo
{
    protected int num_chassi;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double km;
    protected String tipo_comb;
    protected double peso;
    protected boolean status; //1: A venda, 0: Vendido

    //Construtores
    public Veiculo(int num_chassi, String marca, String modelo, int ano, double km, String tipo_comb, double peso, boolean status)
    {
        this.num_chassi = num_chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = km; 
        this.tipo_comb = tipo_comb;
        this.peso = peso;
        this.status = status;
    }

    public Veiculo()
    {
        this(0, "", "", 0, 0.0, "", 0.0, 0);
    }

    //Setters
    public void setChassi(int n)
    {
        this.num_chassi = n;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }

    public void setKm(double km)
    {
        this.km = km;
    }

    public void setComb(String comb)
    {
        this.tipo_comb = comb;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    //Getters
    public int getChassi()
    {
        return this.num_chassi;
    }

    public String getMarca()
    {
        return this.marca;
    }

    public String getModelo()
    {
        return this.modelo;
    }

    public int getAno()
    {
        return this.ano;
    }

    public double getKm()
    {
        return this.km;
    }

    public String getComb()
    {
        return this.tipo_comb;
    }

    public double getPeso()
    {
        return this.peso;
    }

    public boolean getStatus()
    {
        return this.status;
    }
}