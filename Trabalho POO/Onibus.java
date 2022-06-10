import java.util.Calendar;
import java.util.Scanner;



public class Onibus
{
    private String modelo;
    private int ano;
    private String marca;
    private double km;
    public Motorista motorista = new Motorista();
    public int flag=1;

    private static int year = Calendar.getInstance().get(Calendar.YEAR); // Ano atual
    
    // Construtores

    public Onibus(String modelo, int ano, String marca, double km, Motorista motorista)  // Adicionar assentos
    {
        this.modelo = modelo;

        if(ano > (year-20))
            this.ano = ano;
        else
        {
            System.out.println("Este onibus nao se encaixa no artigo 22 , IX , da Constituicao Federal!");
            flag=0;
        }
           
        
        this.marca = marca;

        if(km > 0.0)
            this.km = km;
        else  
        {
           System.out.println("Quilometragem invalida!");
           flag=0;
        }  
            

       
        this.motorista = motorista;

        
    }

    public Onibus(int ano, double km)
    {
        this("", ano, "", 0.0, null);
    }

    public Onibus()
    {
        this("", 0, "", 0.0, null);
    }

    // Setters

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public void setAno(int ano)
    {
        if(ano < (year-20))
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

    public void setMotorista(Motorista moto)
    {
        this.motorista = moto;
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

    public Motorista getMotorista()
    {
        return this.motorista;
    }

   

    public void printInfo()
    {
        System.out.println("---------------------------------");
        System.out.println("Modelo: "+this.modelo);
        System.out.println("marca: " + this.marca);
        System.out.println("Ano: "+this.ano);
        System.out.println("Nome do motorista: "+this.motorista.getNome());
        System.out.println("Km: "+this.km);
        System.out.println("---------------------------------");
    }
}
