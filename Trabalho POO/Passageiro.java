public class Passageiro
{
    private int doc;
    private String nome;
    private Date dataNascimento;
    private String end;

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

    public int getDoc(int doc)
    {
        return this.doc;
    }

    public String getNome(String nome)
    {
        return this.nome;
    }

    public Date getDataNascimento(int dataNascimento)
    {
        return this.dataNascimento;
    }

    public String getEnd(String end)
    {
        return this.end;
    }
}