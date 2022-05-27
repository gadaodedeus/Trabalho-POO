public class Cidades
{
    private String origem;
    private String parada;
    private String destino;
    private Date saida;
    private Date chegada;
    private Onibus bus;
    
    // Construtores

    public Cidades(String o, String p, String d, int sDia, int sMes, int sAno, int sHora, int cMin, int cDia, int cMes, int cAno, int cHora, int cMin, Onibus bus)
    {
        this.origem = o;
        
        if(o != p)
            this.parada = p;

        if(d != p && o != d)
           this.destino = d;

        this.saida = new Date(sDia, sMes, sAno, sHora, sMin);

        this.chegada = new Date(cDia, cMes, cAno, cHora, cMin);

        this.bus = bus;
    }
    
    public Cidades()
    {
        this("","","");
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

    public void setSaida(int sDia, int sMes, int sAno, int sHora)
    {
        this.saida = new Date(sDia, sMes, sAno, sHora);
    }

    public void setChegada(int cDia, int cMes, int cAno, int cHora)
    {
        this.chegada = new Date(cDia, cMes, cAno, cHora);
    }

    public void setOnibus(Onibus bus)
    {
        this.bus = bus;
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

}