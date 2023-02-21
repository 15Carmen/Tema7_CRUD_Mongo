package org.example.Entidades;

import java.time.LocalDate;

public class Profesores {
    private int _id;
    private String dniProfesor;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;
    private int antiguedad;

    public Profesores() {
    }

    public Profesores(int id, String dniProfesor, String nombre, String apellidos, LocalDate fechaNac, int antiguedad) {
        this._id = id;
        this.dniProfesor = dniProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.antiguedad = antiguedad;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDniProfesor() {
        return dniProfesor;
    }
    public void setDniProfesor(String dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
