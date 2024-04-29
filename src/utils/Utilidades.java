/*


 */
package copiarArchivos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AluDAM
 */
public class Utilidades {
    
    public static String menuConCabecera(String cabecera, String[] opciones){
        String respuesta;
        String mensaje;
        boolean haRespondido= false;
        do {
            mensaje="";
            for (int i = 0; i < opciones.length; i++) {
                mensaje+=(i+1)+". "+opciones[i]+". \n";
            }
            respuesta = pideEnteroPositivo(cabecera+"\n"+mensaje)+"";
            for (int i = 0; i < opciones.length; i++) {
                if (respuesta.equals((i+1)+"")) {
                    haRespondido = true;
                }
            }
        } while (!haRespondido);
        return respuesta;
    }
    
    public static String menu(String[] opciones){
        String respuesta;
        int[] numOps = new int[opciones.length];
        boolean haRespondido = false;
        do {
            String mensaje="";
            for (int i = 0; i < opciones.length; i++) {
                mensaje+=(i+1)+". "+opciones[i]+". \n";
                numOps[i]=i;
            }
            try{
                respuesta = pideEnteroPositivo(mensaje)+"";
            }catch(NumberFormatException ex){
                respuesta="";
            }
            for (int i = 0; i < opciones.length; i++) {
                if (respuesta.equals((i+1)+"")) {
                    haRespondido = true;
                }
            }
        } while (!haRespondido);
        return respuesta;
    }
    
    public static int[][] rodear(int[][] matriz, int centroX, int centroY){
        int[][] resultado = new int[3][3];
        int[] rodear = {-1, 0, 1};
        int[] rodearX = {rodear[0]+centroX, rodear[1]+centroX, rodear[2]+centroX};
        int[] rodearY = {rodear[0]+centroY, rodear[1]+centroY, rodear[2]+centroY};
        
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                try{
                    resultado[i][j] = matriz[rodearX[i]][rodearY[j]];
                }catch(IndexOutOfBoundsException e){}
            }
        }
        return resultado;
    }
    
    public static int pideEntero(String mensaje){
        int entero=0;
        Scanner input = new Scanner(System.in);
        boolean esCorrecto=false;
        System.out.println(mensaje);
        do {
            try{
                entero = input.nextInt();
                esCorrecto=true;
            }catch(InputMismatchException e){
                System.out.println("Incorrecto");
                input.next();
            }
        } while (!esCorrecto);
        
        return entero;
    }
    public static int pideEnteroII(String mensaje){
        int entero=0;
        Scanner input = new Scanner(System.in);
        System.out.println(mensaje);
        entero = input.nextInt();
        return entero;
    }
    
    public static int pideEnteroIII(String mensaje){
        int entero=0;
        Scanner input = new Scanner(System.in);
        int contador=0;
        boolean esCorrecto=false;
        System.out.println(mensaje);
        entero = input.nextInt();
        do {
            try{
                entero = input.nextInt();
                esCorrecto=true;
            }catch(InputMismatchException e){
                System.out.println("Incorrecto");
                input.next();
                contador++;
                if (contador>=3) {
                    throw e;
                }
            }
        } while (!esCorrecto && contador<3);
         return entero;
    }
    
    public static String ponerCeros(int numero, int cifras){
        String resultado = numero+"";
        int lon = resultado.length();
        
        if (lon<cifras) {
            for (int i = 0; i < (cifras-lon); i++) {
                resultado = "0"+resultado;
            }
        }
        return resultado;
    }
    
    public static int numDesdeHasta(int desde, int hasta){
        return (int) (Math.random()*(hasta-(desde-1))+desde);
    }
    
    public static boolean stringNoRepetido(String codCompleto, String[] codigosPuestos) {
        if (codigosPuestos!=null) {
            for (int i = 0; i < codigosPuestos.length; i++) {
                if (codCompleto.equals(codigosPuestos[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int[] numerosSinRepetir(int numeros, int hasta){
        int[] aa = new int[numeros];
        int[] dichos = new int[numeros];
        int nuevoNumero;
        for (int i = 0; i < numeros; i++) {
            do {
                nuevoNumero = (int)(Math.random()*hasta)+1;
            } while (arrayIntContiene(dichos, nuevoNumero));
            dichos[i]=nuevoNumero;
            aa[i]=nuevoNumero;
        }
        return aa;
    }
    public static boolean arrayIntContiene(int[] array, int contenido){
        for (int i = 0; i < array.length; i++) {
            return array[i]==contenido;
        }
        return false;
    }
    
     public static String muestraCabecera(){
        return String.format("%-35s %-25s %5s %5s %5s \n\n", 
                "TITULO", "AUTOR", "PRESTAMOS", "PRESTADO", 
                "PRESTABLE");
    }
    
   
    public static int pideEnteroPositivo(String cadena){
        int resultado = 0;
        boolean hecho, correcto;
        do{
            String numero = pideCadena(cadena);
            try{
                resultado = Integer.parseInt(numero);
                correcto = true;
            }catch(NumberFormatException ex){
                correcto=false;                
            }
            hecho = esNumero(numero)&& correcto;
        }while(!hecho);
        return resultado;
    }
    
    public static float pideFloat(String mensaje){
        Scanner leer = new Scanner(System.in);
        System.out.println(mensaje);
        Float res=0f;
        boolean volver;
        do {
            volver = false;
            try{
                res = leer.nextFloat();
            }catch(InputMismatchException ex){
                volver = true;
            }
        } while (volver);
        return res;
    }
    
    public static double pideDouble(String mensaje) throws InputMismatchException{
        double resultado=0;
        Scanner leer = new Scanner(System.in);
        System.out.println(mensaje);
        try{
            resultado = leer.nextDouble();
        }catch(InputMismatchException ex){
            throw new InputMismatchException();
        }
        return resultado;
    }
    
    public static void muestraMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    
    public static boolean esNumero(char letra){
        String numeros = "0123456789";       
        return numeros.contains(letra+"");
    }
    
    public static boolean esNumero(String numero){
//Comodín para verificar si cada letra del String de entrada es un número
//usando la clase esNumero que coge letras. 
        for (int i = 0; i < numero.length(); i++) {
            if(!esNumero(numero.charAt(i))){
                return false;
            }
        } return true;
    }
    public static int calcFactorial(int num){
        int n, suma = 1;
        
        num = pideEntero("Escribe un numero y te saco el factorial. ");
        n = num;
        while(n>0){
            suma *= n;
            n -=1;
        }
        return suma;
    }
    
    public static String pideCadena(String mensaje){
        Scanner leer = new Scanner(System.in);
        System.out.println(mensaje);
        return leer.nextLine();
    }
    /**
     * Devuelve un array de ints de la longitud de @lonArray, 
     * y con un número máximo de @hasta, empezando en @desde. 
     * 
     * @param lonArray
     * @param desde
     * @param hasta
     * @return 
     */    
    public static String[] numerosSinRepetirConGuiones(int lonArray, int desde, int hasta){
        String[] aa = new String[lonArray];
        String[] dichos = new String[lonArray];
        String nuevoNumero;
        int probabilidadGuion;
        hasta =- desde;
        for (int i = 0; i < lonArray; i++) {
            probabilidadGuion = (int) (Math.random() * 3);
            do {
                if (probabilidadGuion<=1) {
                    nuevoNumero="-";
                }else{
                    nuevoNumero = (int) ((Math.random()*hasta)+desde)+"";
                }
            } while (arrayStringContieneNumero(dichos, nuevoNumero));
            dichos[i]=nuevoNumero;
            aa[i]=nuevoNumero;
        }
        return aa;
    }
    
    public static boolean arrayStringContieneNumero(String[] array, String contenido){
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=null && esNumero(contenido)) {
                return array[i].equals(contenido);
            }
        }
        return false;
    }
}