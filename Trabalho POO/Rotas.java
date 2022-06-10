public class Rotas
{
    private String origem;
    private String parada;
    private String destino;
    private Date saida;
    private Date chegada;
    private Onibus bus;
    private double valor;
    public int flag=1;
    
    // Construtores

    public Rotas(String o, String p, String d, int sDia, int sMes, int sAno, int sHora, int sMin, int cDia, int cMes, int cAno, int cHora, int cMin, Onibus bus, double valor)
    {
        this.origem = o;
        
        if(o != p)
            this.parada = p;
        else
        {
            System.out.println("ERRO: origem e parada sao a mesma cidade");
            flag=0;
        }

        if(d != p && o != d)
           this.destino = d;
        else
        {
            System.out.println("ERRO: cidades repetidas");
            flag=0;
        }

        this.saida = new Date(sDia, sMes, sAno, sHora, sMin);

        this.chegada = new Date(cDia, cMes, cAno, cHora, cMin);

        this.bus = bus;

        if(valor > 0)
            this.valor = valor;
        else
        {
            System.out.println("Valor invalido!");
            flag=0;
        }
    }
    
    public Rotas()
    {
        this("","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0.0);
    }
    
    // Setters
    
    public void setOrigem(String o)
    {
        this.origem = o;
    }
    
    public void setParada(String p)
    {
        this.parada = p;
    }
    
    public void setDestino(String d)
    {
        this.destino = d;
    }

    public void setSaida(int sDia, int sMes, int sAno, int sHora, int sMin)
    {
        this.saida = new Date(sDia, sMes, sAno, sHora, sMin);
    }

    public void setChegada(int cDia, int cMes, int cAno, int cHora, int cMin)
    {
        this.chegada = new Date(cDia, cMes, cAno, cHora, cMin);
    }

    public void setOnibus(Onibus bus)
    {
        this.bus = bus;
    }

    public void setValor(double valor)
    {
        if(valor > 0)
            this.valor = valor;
    }

    // Getters
    
    public String getOrigem()
    {
        return this.origem;
    }
    
    public String getParada()
    {
        return this.parada;
    }
    
    public String getDestino()
    {
        return this.destino;
    }

    public Date getSaida()
    {
        return this.saida;
    }

    public Date getChegada()
    {
        return this.chegada;
    }

    public Onibus getBus()
    {
        return this.bus;
    }

    public double getValor()
    {
        return this.valor;
    }

    // Print Informações

    public void printInfo()
    {
        System.out.println("---------------------------------");
        System.out.println("Rota: "+this.origem+" -> "+this.parada+" -> "+this.destino);
        System.out.println("Saida: "+this.saida.getHora()+":"+this.saida.getMin()+"\tChegada: "+this.chegada.getHora()+":"+this.chegada.getMin());
        System.out.println("Motorista: "+this.bus.motorista.getNome());
        System.out.println("Valor da passagem: R$"+this.valor);
        System.out.println("---------------------------------");
    }

}