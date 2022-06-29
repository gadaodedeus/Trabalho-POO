public class Venda
{
    private int tipo_venda; //1- Carro //0- Moto
    private int id;
    private Vendedor vend;
    private Cliente cli; 
    private Carro carro;
    private Motocicleta moto;
    private double valor;
    private Date data;  //Ja contem o horario

    public Venda(int tipo, int id, Vendedor vend, Cliente cli, Carro car, Motocicleta moto, double valor, int dia, int mes, int ano, int hora, int min)
    {
        this.tipo_venda = tipo;
        this.id = id;
        this.vend = vend;
        if(tipo == 1)
        {
            this.carro = car;
            this.moto = null;
        }
        else
        {
            this.moto = moto;
            this.carro = null;
        }
        this.valor = valor;
        this.data = new Date(dia, mes, ano, hora, min);
    }

    public Venda(int tipo)
    {
        this(tipo, 0, null, null, null, null, 0.0, 0, 0, 0, 0, 0);
    }
}