import java.util.Calendar;
import java.util.Scanner;



public class Onibus
{
    private String modelo;
    private int ano;
    private String marca;
    private double km;
    private int assentos[][] = new int[10][4];
    private Motorista motorista = new Motorista();

    private static int year = Calendar.getInstance().get(Calendar.YEAR); // Ano atual
    
    // Construtores

    public Onibus(String modelo, int ano, String marca, double km, Motorista motorista)  // Adicionar assentos
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

        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 4; j++)
                assentos[i][j] = 0;

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
        return this.motorista
    }

    // Assentos

    public void printAssentos()
    {
        System.out.println("-Assentos disponiveis-");
        System.out.print("\t 1 2   3 4\n");
        for(int i = 0; i < 10; i++)
        {
            System.out.print((i+1)+"\t");
            for(int j = 0; j < 4; j++)
            {
                if(j == 2)
                    System.out.print("  ");
                System.out.print(" "+assentos[i][j]);
            }
            System.out.print("\n");
        }

    }

    public void addPassageiro()
    {
        Scanner sc = new Scanner(System.in);
        int x, y;
        this.printAssentos();

        System.out.println("Informe a fileira: ");
        x = sc.nextInt();
        x--;
        System.out.println("Informe a cadeira: ");
        y = sc.nextInt();
        y--;

        assentos[x][y] = 1;
    }
    
        public void retirarPassegeiro()
    {
        Scanner sc = new Scanner(System.in);
        int x,y;
        
        System.out.println("Digite a fileira: ");
        x= sc.nextInt();
        x--;
        System.out.println("Digite a cadeira: ");
        y= sc.nextInt();
        y--;
        
        assentos[x][y]=0;
    }
}
