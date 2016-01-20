package com.example.nowor_000.list3;

/**
 * Created by nowor_000 on 19/01/2016.
 */
public class Producto {

    private String titulo;
    private String descripcion;
    private int id_imagen;
    private boolean selected;


    public Producto(String titulo, String descripcion, int id_imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_imagen = id_imagen;
        this.selected = false;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
