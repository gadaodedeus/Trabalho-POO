public class Motocicleta extends Veiculo{
    private int cilindradas;
    private String tipo;

    //Constructors--------------------
    public Motocicleta(int num_chassi, String marca, String modelo, int ano, double km, String tipo_comb, double peso,
            boolean status, int cilindradas, String tipo) {
        super(num_chassi, marca, modelo, ano, km, tipo_comb, peso, status);
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

    //Setters-------------------------
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void printArq(boolean x)
    {
        String arqMotos = "Motos.txt";
        try
        {
            File arquivoMotos = new File(arqMotos);
            FileWriter escritorMoto = new FileWriter(arquivoMotos, x); 
            
            //escritorCli.write("------------------------------\n");
            escritorMoto.write("1\n");
            escritorMoto.write(this.getCilindradas()+"\n");
            escritorMoto.write(this.getTipo()+"\n");
            //escritorCli.write("------------------------------\n");
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
        System.out.println("Cilindradas: "+ getCilindradas());
        System.out.println("Tipo: " + getTipo());
        System.out.println("------------------------------\n");
    }
}
