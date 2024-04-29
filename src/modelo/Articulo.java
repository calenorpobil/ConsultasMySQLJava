/*
Crear la clase alumno con los requisitos: codigo(15), nombre(30) y nota (float)
 */
package modelo;

import Excepciones.MiExcepcion;

/**
 *
 * @author AluDAM
 */
public class Articulo {

    private String cod_art;
    private String descripcion;
    private float precio;
    private int cantidad, cantidad_min;

    public Articulo(String cod_art, String descripcion, float precio,
            int cantidad, int cantidad_min) {
        setCod_art(cod_art);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCantidad(cantidad);
        setCantidad_min(cantidad_min);
    }

    public Articulo(String cod_art, String descripcion, String precio,
            String cantidad, String cantidad_min) throws MiExcepcion {
        setCod_art(cod_art);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCantidad(cantidad);
        setCantidad_min(cantidad_min);
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidad_min(int cantidad_min) {
        this.cantidad_min = cantidad_min;
    }

    public void setDescripcion(String descripcion) {
        int lon = descripcion.length();
        if (lon <= 25) {
            this.descripcion = descripcion;
        }
    }

    public void setCod_art(String codigo) {
        int lon = codigo.length();
        if (lon <= 5) {
            this.cod_art = codigo;
        }
    }

    public void setPrecio(float nota) {
        this.precio = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidad_min() {
        return cantidad_min;
    }

    public String getCod_art() {
        return cod_art;
    }

    public float getPrecio() {
        return precio;
    }

    private void setPrecio(String precio) throws MiExcepcion {
        float resultado;
        try {
            resultado = Float.parseFloat(precio);
        } catch (NumberFormatException | NullPointerException ex) {
            throw new MiExcepcion("Precio incorrecto, no es un número. ");
        }
        setPrecio(resultado);
    }

    private void setCantidad(String cantidad) throws MiExcepcion {
        int resultado;
        try {
            resultado = Integer.parseInt(cantidad);
        } catch (NumberFormatException | NullPointerException ex) {
            throw new MiExcepcion("Cantidad incorrecta, no es un número. ");
        }
        setCantidad(resultado);
    }

    private void setCantidad_min(String cantidad_min) throws MiExcepcion {
        int resultado;
        try {
            resultado = Integer.parseInt(cantidad_min);
        } catch (NumberFormatException | NullPointerException ex) {
            throw new MiExcepcion("Cantidad mínima incorrecta, no es un número. ");
        }
        setCantidad_min(resultado);
    }

}
