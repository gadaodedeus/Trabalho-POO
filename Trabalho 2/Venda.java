import java.io.*;
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
        this.cli = cli;
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

    public Venda()
    {
        this(0, 0, null, null, null, null, 0.0, 0, 0, 0, 0, 0);
    }

    //Setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setVend(Vendedor vend)
    {
        this.vend = vend;
    }

    public void setCli(Cliente cli)
    {
        this.cli = cli;
    }

    public void setCarro(Carro car)
    {
        this.carro  = car;
    }

    public void setMoto(Motocicleta moto)
    {
        this.moto = moto;
    }

    public void setValor(double preco)
    {
        this.valor = valor;
    }

    public void setData(Date d)
    {
        this.data = d;
    }

    //Getters
    public int getTipoVenda()
    {
        return this.tipo_venda;
    }

    public int getId()
    {
        return this.id;
    }

    public Vendedor getVend()
    {
        return this.vend;
    }

    public Cliente getCli()
    {
        return this.cli;
    }

    public Carro getCarro()
    {
        return this.carro;
    }

    public Motocicleta getMoto()
    {
        return this.moto;
    }

    public double getValor()
    {
        return this.valor;
    }

    public Date getData()
    {
        return this.data;
    }

    //Prints
    public void printInfo()
    {
        System.out.println("------------------------------\n");
        System.out.println("ID: "+getId());
        System.out.println("Vendedor: "+getVend().getNome());
        System.out.println("Cliente: "+getCli().getNome());
        if(getTipoVenda() == 1)
            System.out.println("Carro: "+getCarro().getModelo());
        else 
            System.out.println("Moto: "+getMoto().getModelo());
        System.out.println("Valor: R$ "+getValor());
        System.out.println("Data: "+getData().getDia()+"/"+getData().getMes()+"/"+getData().getAno()+"\n"+getData().getHora()+":"+getData().getMin());
        System.out.println("------------------------------\n");
    }

    public void printArq(boolean x)
    {
        String arq = "Vendas.txt";
        try
        {
            Date data = new Date();
            File arquivo = new File(arq);
            FileWriter escritor = new FileWriter(arquivo, x); 
            
            escritor.write("1\n");
            escritor.write(this.getTipoVenda()+"\n");
            escritor.write(this.getId()+"\n");
            escritor.write(this.getVend().getInd()+"\n");
            escritor.write(this.getCli().getInd()+"\n");
            if(getTipoVenda() == 1)
                escritor.write(this.getCarro().getIndice()+"\n");
            else
                escritor.write(this.getMoto().getInd()+"\n");
            escritor.write(this.getValor()+"\n");
            data = getData();
            escritor.write(data.getDia()+"\n");
            escritor.write(data.getMes()+"\n");
            escritor.write(data.getAno()+"\n");
            escritor.write(data.getHora()+"\n");
            escritor.write(data.getMin()+"\n");
            escritor.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro!\n"+e);
        }
    }
}