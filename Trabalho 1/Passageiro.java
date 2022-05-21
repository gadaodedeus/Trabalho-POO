public class Passageiro
{
    private int doc;
    private String nome;
    private int dataNascimento;
    private String end;

    // Construtores

    public Passageiro(int doc, String nome, int dataNascimento, String end)
    {
        if(doc > 0)
            this.doc = doc;
        else
            System.out.println("Documento invalido!");

        this.nome = nome;

        if(dataNascimento/100000 >= 1)
            this.dataNascimento = dataNascimento
        else
            System.out.println("Data invalida!");

        this.end = end;
    }

    public Passageiro(int doc, String nome)
    {
        if(doc > 0)
            this(doc, nome, 0, "");
        else   
            System.out.println("Dados inalidos!");
    }

    public Passageiro(int doc, String nome)
    {
        this(0, "", 0, "");
    }

    // Setters

    public void setData(int dataNascimento)
    {
        if(dataNascimento/100000 >= 1)
            this.dataNascimento = dataNascimento;
        else
            System.out.println("Data invalida!");
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

    public int getDataNascimento(int dataNascimento)
    {
        return this.dataNascimento;
    }

    public String getEnd(String end)
    {
        return this.end;
    }
}