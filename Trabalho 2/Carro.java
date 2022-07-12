import java.io.*;
public class Carro extends Veiculo{
    private double potencia;   
    private int numCilindros;
    private int numOcupantes;
    private String tipo;
    private double altura;
    private double largura;
    private double comprimento;

    //Constructors---------------
    public Carro(int num_chassi, String marca, String modelo, int ano, double km, String tipo_comb, double peso,
            boolean status, double potencia, int numCilindros, int numOcupantes, String tipo, double altura,
            double largura, double comprimento) {
        super(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status);
        this.potencia = potencia;
        this.numCilindros = numCilindros;
        this.numOcupantes = numOcupantes;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Carro(double potencia, int numCilindros, int numOcupantes, String tipo, double altura, double largura,
            double comprimento) {
        this.potencia = potencia;
        this.numCilindros = numCilindros;
        this.numOcupantes = numOcupantes;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Carro(){
        this(0.0, 0, 0, "", 0.0, 0.0, 0.0);
    }

    //Getters--------------------
    public double getPotencia() {
        return potencia;
    }
    
    public int getNumCilindros() {
        return numCilindros;
    }

    public int getNumOcupantes() {
        return numOcupantes;
    }
    
    public String getTipo() {
        return tipo;
    }

    public double getAltura() {
        return altura;
    }
    
    public double getLargura() {
        return largura;
    }
    
    public double getComprimento() {
        return comprimento;
    }

    //Setters--------------------
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }
   
    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }
   
    public void setNumOcupantes(int numOcupantes) {
        this.numOcupantes = numOcupantes;
    }
   
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
    public void setAltura(double altura) {
        this.altura = altura;
    }
   
    public void setLargura(double largura) {
        this.largura = largura;
    }
   
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

     public void printArq(boolean x)
    {
        String arqCarros = "Carros.txt";
        try
        {
            File arquivoCarro = new File(arqCarros);
            FileWriter escritorCarro = new FileWriter(arquivoCarro, x); 
            
            //escritorCli.write("------------------------------\n");
            escritorCarro.write("1\n");
            escritorCarro.write(this.getPotencia()+"\n");
            escritorCarro.write(this.getNumCilindros()+"\n");
            escritorCarro.write(this.getNumOcupantes()+"\n");
            escritorCarro.write(this.getTipo()+"\n");
            escritorCarro.write(this.getAltura()+"\n");
            escritorCarro.write(this.getLargura()+"\n");
            escritorCarro.write(this.getComprimento()+"\n");
            //escritorCli.write("------------------------------\n");
            escritorCarro.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro!\n"+e);
        }
    }

    public void printInfo()
    {
        System.out.println("------------------------------\n");
        System.out.println("Potencia: "+getPotencia());
        System.out.println("Numero de cilindros: "+ getNumCilindros());
        System.out.println("Numero de ocupantes: "+ getNumOcupantes());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Altura: "+getAltura());
        System.out.println("Largura: "+getLargura());
        System.out.println("Comprimento: " + getComprimento());
        System.out.println("------------------------------\n");
    }

}
