import java.util.Calendar;
public class Date
{
  private int dia;
  private int mes;
  private int ano;
  private int hora;
  private int min;

  private static int year = Calendar.getInstance().get(Calendar.YEAR);
  
  //Construtores
  public Date(int dia, int mes, int ano, int hora, int min)
  {
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
      this.hora = hora;
      this.min = min;
  }
   public Date(){
        this(0, 0, 0, 0, 0);
    }

    public Date(int dia, int mes, int ano)
    {
        this(dia, mes, ano, 0, 0);
    }

    //Setters
    public void setDia(int dia) {
        if(dia < 1 || dia > 31){
            //System.out.println("Dia inválido, digite novamente!");
        }else{
            this.dia = dia;
        }
    }
    public void setMes(int mes) {
        if(mes < 1 || mes > 12){
            //System.out.println("Mês inválido, digite novamente!");
        }else{
            this.mes = mes;
        }
    }
    public void setAno(int ano) {
        if(ano < year){
            //System.out.println("Ano inválido, digite novamente!");
        }else{
            this.ano = ano;
        }
    }
    public void setHora(int hora) {
        if(hora < 0 || hora > 23){
            //System.out.println("Hora inválida, digite novamente!");
        }else{
            this.hora = hora;
        }
    }
    public void setMin(int min) {
        if(min < 0 || min > 59){
            //System.out.println("Minuto inválido, digite novamente!");
        }else{
            this.min = min;
        }
    }

    //Getters
    public int getDia() {
        return this.dia;
    }
    public int getMin() {
        return this.min;
    }
    public int getHora() {
        return this.hora;
    }
    public int getAno() {
        return this.ano;
    }
    public int getMes() {
        return this.mes;
    }
}
  
