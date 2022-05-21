import java.util.Calendar;

public class Onibus
{
    private String modelo;
    private int ano;
    private String marca;
    private double km;
    //private locAssentos;      CRIAR COM ARRAYLIST

    private static int year = Calendar.getInstance().get(Calendar.YEAR); // Ano atual
    
    // Construtores

    public Onibus(String modelo, int ano, String marca, double km)  // Adicionar assentos
    {
        this.modelo = modelo;

        if(ano > (year-20))
            this.ano = ano;
        else
            System.out.println("Este onibus nao se encaixa no artigo 22 , IX , da Constituicao Federal!");
        
        this.marca = marca;

        if(km > 0.0)
            this.km = km;
        else    
            System.out.println("Quilometragem invalida!");
    }

    public Onibus(int ano, double km)
    {
        this("", ano, "", 0.0);
    }

    public Onibus()
    {
        this("", 0, "", 0.0);
    }

    // Setters

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public void setAno(int ano)
    {
        if(ano > (year-20))
            this.ano = ano;
        else
            System.out.println("Este onibus nao se encaixa no artigo 22 , IX , da Constituicao Federal!");
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public void setKm(double km)
    {
        if(km > 0.0)
            this.km = km;
        else    
            System.out.println("Quilometragem invalida!");
    }

    // Getters

    public String getModelo()
    {
        return this.modelo;
    }

    public int getAno()
    {
        return this.ano;
    }

    public String getMarca()
    {
        return this.marca;
    }

    public double getKm()
    {
        return this.km;
    }
}