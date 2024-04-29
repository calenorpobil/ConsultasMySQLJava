/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author AluDAM
 */
public class Fecha {
    private int dia;
    private int mes;
    private int year;

// Crear el constructor necesario
//Crear el siguiente constructor:

    /**
     * 
     * @param dia -- dia
     * @param mes -- mes
     * @param year -- año
     */
    public Fecha(int dia, int mes, int year) {
        //no se le pasará ninguna fecha, y se le asignará la fecha del día
       //Utilizaremos la clase Calendar y la clase Gregoriancalendar
       this.dia = dia;
       this.mes = mes;
       this.year = year;
    }
    
    /**
     * Inicializa los parámetros con la fecha del día actual. 
     */
    public Fecha(){
        GregorianCalendar diaHoy = new GregorianCalendar();
        this.dia = diaHoy.get(GregorianCalendar.DAY_OF_MONTH);
        this.mes = diaHoy.get(GregorianCalendar.MONTH)+1;
        this.year = diaHoy.get(GregorianCalendar.YEAR);
    }
    
    public static Fecha pideFecha(){
        Fecha f = null;
        Scanner teclado = new Scanner(System.in);
        int n = 0;
        boolean esCorrecto = false;
        while(!esCorrecto){
            System.out.println("Introduce una fecha: ");
            String fecha = teclado.nextLine();
            String[] partes = fecha.split("[/-]");
            //Espero que haya 3 partes, y sean números
            try{
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int anyo = Integer.parseInt(partes[2]);
                f = new Fecha(dia, mes, anyo);
                if (f.esCorrecta()) {
                    esCorrecto = true;
                }
            } catch(NumberFormatException e){
                System.out.println("Hay caracteres no válidos en los números. ");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Falta una parte de la fecha. ");
            }catch(Exception e){
                System.out.println("Epa");
            }
        }
        return f;
    }

    
    private String getMesLetras(){
    //Devuelve una cadena que contiene el  mes con letras: enero, febrero ... diciembre
        String nombresMeses [] = {"", "enero", "febrero", "marzo", "abril", 
            "mayo", "junio", "julio", "agosto", "septiembre", "octubre", 
            "noviembre", "diciembre"};
        return nombresMeses[mes];
    }
    
    private static boolean isBisiesto(){
        return true;
    }
    
    public static int diasMes(int mes, int year){
        int diasMes;
        switch(mes){
            case 4, 6, 9, 11 -> {
                diasMes = 30;
            }
            case 2 -> {
                if (esBisiesto(year)) {
                    diasMes =  29;
                }
                diasMes = 28;
            }
            default -> {
                diasMes = 31;
            }
        }
        return diasMes;
    }
    public int getDiasMesII(){
        GregorianCalendar fecha = new GregorianCalendar(year, mes, dia);
        return fecha.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    }

    
    @Override
    public String toString(){
        return String.format("%02d/%02d/%d",dia,mes,year);
    }
 

    private static boolean esBisiesto(int year){
//   -   Devuelve true si el año es bisiesto y false en caso contrario
        if (year%400==0) {
            return true;
        } return year%4==0 && year%100!=0;
    }

    public boolean esCorrecta(){
//-  Devuelve true si la fecha es correcta.
        return dia<=diasMes(mes, year)&&mes<=12;
    }
 

    public String muestraFechaLarga(){
//Si la fecha es correcta,  Devuelve la fecha con el formato largo à 12 de diciembre de 2020
        if (esCorrecta()) {
            return String.format("%d de %s del año %d", dia, getMesLetras(), year);
        }
        return "Fecha incorrecta";
    }


 

    public String muestraFechaCorta(){
//Si la fecha es correcta, devuelve la fecha con el formato cortoà 12/12/2020
        if (esCorrecta()) {
            return dia+"/"+mes+"/"+year;
        }
        return "Fecha incorrecta";
    }
    
    
    public boolean esAnterior(Fecha fecha){
        if (this.year<fecha.year) {
            return true;
        }
        if (this.mes<fecha.mes) {
            return true;
        }
        return this.dia<fecha.dia;
    }

    
    
    
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getYear() {
        return year;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
