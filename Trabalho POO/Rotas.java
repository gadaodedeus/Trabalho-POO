import java.util.Scanner;
import java.util.ArrayList;

public class Rotas
{
    private String origem;
    private String parada;
    private String destino;
    private Date saida;
    private Date chegada;
    private Onibus bus;
    private double valor;
    public int flag=1; //para add ou nao na array da main
    private int assentos[][] = new int[10][4];
    private ArrayList<Passageiro> listPass = new ArrayList<>(); //passageiros que compraram passagem
                                                                //para esta viagem
    
    // Construtores

    public Rotas(String o, String p, String d, int sDia, int sMes, int sAno, int sHora, int sMin, int cDia, int cMes, int cAno, int cHora, int cMin, Onibus bus, double valor)
    {
        this.origem = o;
        
        this.parada = p;
        
        if(o != p)
            this.destino = d;
        else
            flag=0;

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

        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 4; j++)
                assentos[i][j] = 0;

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
        if(this.bus.getMotorista() == null)
            System.out.println("Sem motorista para este onibus");
        else
            System.out.println("Motorista: "+this.bus.motorista.getNome());
        System.out.println("Valor da passagem: R$"+this.valor);
        System.out.println("---------------------------------");
    }

     // Assentos

     public void printAssentos() //Printa a situação atual dos assentos
     {
         System.out.println("-Assentos disponiveis-");
         System.out.print("\t 1 2   3 4\n");
         for(int i = 0; i < 10; i++)
         {
             System.out.print((i+1)+"\t");
             for(int j = 0; j < 4; j++)
             {
                 if(j == 2)
                     System.out.print("  ");
                 System.out.print(" "+assentos[i][j]);
             }
             System.out.print("\n");
         }
 
     }
 
     //Compra da passagem
     public void addPassageiro(Passageiro pass) //OBS: apenas um compra por documento pode ser feita
     {
         Scanner sc = new Scanner(System.in);
         int x, y;
         this.printAssentos();
 
         do
         {
             do
             {
                 System.out.println("Informe a fileira: ");
                 x = sc.nextInt();
                 x--;
             }while(x<0 || x>9);
           
         
             do
             {
                 System.out.println("Informe a coluna: ");
                 y = sc.nextInt();
                 y--;
             }while(y<0 || y>3);
 
             if(assentos[x][y] == 1)
                 System.out.println("Assento ocupado");
 
         }while(assentos[x][y] == 1);

         listPass.add(pass);    //add na array de passageiros que compraram esta viagem
         pass.setPassagem(x, y);    //add a informaçao de seu assento no obj Passageiro que 
                                    //realizou a compra
 
         assentos[x][y] = 1;
     }
     
    
    public void retirarPassegeiro() //Cancelar a compra de um passageiro
    {
        Scanner sc = new Scanner(System.in);
        int x,y,doc_pas, flag=0, i=0;

        System.out.println("Informe seu documento");
        doc_pas = sc.nextInt();

        while(i<listPass.size())
        {
            if(listPass.get(i).getDoc() == doc_pas)
            {
                flag=1;
                break;
            }

            else
                i++;
        }

        if(flag == 1) 
        {
            x= listPass.get(i).getX();
            y= listPass.get(i).getY();
            assentos[x][y]=0;
            listPass.remove(i); //remove o passageiro 
        }

        else
            System.out.println("O portador do documento nao realizou nenhuma compra para esta rota");    

    }

    //Printa todos os passageiros que irao viajar nesta rota
    public void printPass()
    {
        int i=0;
        while(i<listPass.size())
        {
            this.listPass.get(i).printPass();
            i++;
        }
        
    }

    //Informa o numero de passagens vendidas
    public int numPass()
    {
        return listPass.size();
    }

}
