import java.io.*;

public class Motocicleta extends Veiculo{
    private int cilindradas;
    private String tipo;
    private int ind;

    //Constructors--------------------
    public Motocicleta(int num_chassi, String marca, String modelo, int ano, double km, String tipo_comb, double peso,
            boolean status, int cilindradas, String tipo) 
    {
        this.num_chassi = num_chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = km; 
        this.tipo_comb = tipo_comb;
        this.peso = peso;
        this.status = status;
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }

    public Motocicleta(int cilindradas, String tipo) {
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }

    public Motocicleta() {
        this(0, "");
    }

    //Getters-------------------------
    public int getCilindradas() {
        return cilindradas;
    }
    
    public String getTipo() {
        return tipo;
    }

    public int getInd()
    {
        return ind;
    }

    //Setters-------------------------
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setInd(int i)
    {
        this.ind = i;
    }

    public void printArq(boolean x)
    {
        String arqMotos = "Motos.txt";
        try
        {
            File arquivoMotos = new File(arqMotos);
            FileWriter escritorMoto = new FileWriter(arquivoMotos, x); 
           
            escritorMoto.write("1\n");
            escritorMoto.write(this.getChassi()+"\n");
            escritorMoto.write(this.getMarca()+"\n");
            escritorMoto.write(this.getModelo()+"\n");
            escritorMoto.write(this.getAno()+"\n");
            escritorMoto.write(this.getKm()+"\n");
            escritorMoto.write(this.getComb()+"\n");
            escritorMoto.write(this.getPeso()+"\n");
            escritorMoto.write(this.getStatus()+"\n");
            escritorMoto.write(this.getCilindradas()+"\n");
            escritorMoto.write(this.getTipo()+"\n");
            escritorMoto.write(this.getInd()+"\n");

            escritorMoto.close();
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
        System.out.println("Cilindradas: "+ getCilindradas());
        System.out.println("Tipo: " + getTipo());
        System.out.println("------------------------------\n");
    }
}
