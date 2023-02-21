package org.example.Entidades;

public class Departamento {
    private int _id;
    private String codigoDepartamento;
    private String nombre;

    public Departamento(int _id, String codigoDepartamento, String nombre) {
        this._id = _id;
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
