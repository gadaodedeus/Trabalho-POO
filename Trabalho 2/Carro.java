import java.io.*;

public class Carro extends Veiculo{
    private double potencia;   
    private int numCilindros;
    private int numOcupantes;
    private String tipo;
    private double altura;
    private double largura;
    private double comprimento;
    private int ind;

    //Constructors---------------
    public Carro(int num_chassi, String marca, String modelo, int ano, double km, String tipo_comb, double peso,
            boolean status, double potencia, int numCilindros, int numOcupantes, String tipo, double altura,
            double largura, double comprimento) 
    {
        this.num_chassi = num_chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = km; 
        this.tipo_comb = tipo_comb;
        this.peso = peso;
        this.status = status;
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
    public int getIndice()
    {
        return this.ind;
    }

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
    public void setInd(int i)
    {
        this.ind = i;
    }

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
            
            
            escritorCarro.write("1\n");
            escritorCarro.write(this.getChassi()+"\n");
            escritorCarro.write(this.getMarca()+"\n");
            escritorCarro.write(this.getModelo()+"\n");
            escritorCarro.write(this.getAno()+"\n");
            escritorCarro.write(this.getKm()+"\n");
            escritorCarro.write(this.getComb()+"\n");
            escritorCarro.write(this.getPeso()+"\n");
            escritorCarro.write(this.getStatus()+"\n");
            escritorCarro.write(this.getPotencia()+"\n");
            escritorCarro.write(this.getNumCilindros()+"\n");
            escritorCarro.write(this.getNumOcupantes()+"\n");
            escritorCarro.write(this.getTipo()+"\n");
            escritorCarro.write(this.getAltura()+"\n");
            escritorCarro.write(this.getLargura()+"\n");
            escritorCarro.write(this.getComprimento()+"\n");
            escritorCarro.write(this.getIndice()+"\n");

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
        System.out.println("Numero do chassi: "+getChassi()); 
        System.out.println("Marca: "+getMarca());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Ano: "+getAno());
        System.out.println("Quilometragem: "+getKm());
        System.out.println("Tipo de combustivel: "+getComb());
        System.out.println("Peso: "+getPeso());
        System.out.print("Status: ");
        if(getStatus() == true)
            System.out.println("A venda");
        else
            System.out.println("Vendido");
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
