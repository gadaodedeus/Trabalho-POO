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
}
