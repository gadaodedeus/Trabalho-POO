import java.util.Scanner;
import java.util.Calendar;

public class Main{

    private static void programaAdm(){
        System.out.println("Olá, você está executando como administrador!");
        
    }

    private static void programaCli(){
        System.out.println("Olá, você está executando como cliente!");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Bem vindo ao sistema de viagem de ônibus, por favor informe seu tipo de acesso (Administrador[1]/ Cliente[2]): ");
        int tipoAcess = input.nextInt();
        
        if(tipoAcess == 1){
            //Codigo administrador:
            Main.programaAdm();
            
        }else if(tipoAcess == 2){
            //Codigo cliente:
            Main.programaCli();

        }

    }
}
