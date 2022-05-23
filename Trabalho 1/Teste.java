import java.util.Scanner;

public class Teste
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        Onibus oni = new Onibus();
        int op=1;

        while(op != 0)
        {
            oni.addPassageiro();
            System.out.println("Adicionar mais?");
            op = sc.nextInt();
        }
        oni.printAssentos();
    }
}