package org.example.Entidades;

import java.time.LocalDate;

public class Alumnos {
    private int _id;
    private String dniAlumno;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;

    public Alumnos() {
    }

    public Alumnos(int id, String dniAlumno, String nombre, String apellidos, LocalDate fechaNac) {
        this._id = id;
        this.dniAlumno = dniAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
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
}
