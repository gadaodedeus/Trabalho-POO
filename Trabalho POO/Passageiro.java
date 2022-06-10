public class Passageiro
{
    private int doc;
    private String nome;
    private Date dataNascimento;
    private String end;
    private int x,y; //coordenadas da passagem
    
    // Construtores

    public Passageiro(int doc, String nome, int diaNasc, int mesNasc, int anoNasc, String end)
    {
        if(doc > 0)
            this.doc = doc;
        else
            System.out.println("Documento invalido!");

        this.nome = nome;

        this.dataNascimento = new Date(diaNasc, mesNasc, anoNasc);

        this.end = end;
    }

    /*public Passageiro(int doc, String nome)
    {
        if(doc > 0)
            this(doc, nome, 0, 0, 0, "");
        else   
            System.out.println("Dados inalidos!");
    }*/

    // Setters

    public void setPassagem(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setData(int diaNasc, int mesNasc, int anoNasc)
    {
        this.dataNascimento = new Date(diaNasc, mesNasc, anoNasc);
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setDoc(int doc)
    {
        if(doc>0)
            this.doc = doc;
        else
            System.out.println("Documento invalido!");
    }

    public void setEnd(String end)
    {
        this.end = end;
    }

    // Getters

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getDoc()
    {
        return this.doc;
    }

    public String getNome()
    {
        return this.nome;
    }

    public Date getDataNascimento()
    {
        return this.dataNascimento;
    }

    public String getEnd()
    {
        return this.end;
    }
}