public class Cidades
{
    private String origem;
    private String parada;
    private String destino;
    
    // Construtores

    public Cidades(String o, String p, String d)
    {
        this.origem = o;
        
        if(o != p)
            this.parada = p;

        if(d != p && o != d)
           this.destino = d;
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
}
