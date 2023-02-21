package org.example.Entidades;

public class Matricula {
    private  int _id;
    private String codigoMatricula;
    private String asignatura;
    private int curso;

    public Matricula(int _id, String codigoMatricula, String asignatura, int curso) {
        this._id = _id;
        this.codigoMatricula = codigoMatricula;
        this.asignatura = asignatura;
        this.curso = curso;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }
    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }
}
