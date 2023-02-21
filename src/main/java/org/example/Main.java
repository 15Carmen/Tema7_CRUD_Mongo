package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Conexion.conexionRemota();

        /**
         * Todos los metodos CRUD me funcionan A o(*≧▽≦)ツ︵ ┻━┻
         */
        MetodosCRUD.buscarAlumno("78451232L");
        //MetodosCRUD.listar("Alumnos");
        //MetodosCRUD.insertarAlumnos("78451232L", "Carmen", "Martín", LocalDate.ofEpochDay(2003- 3 -15));
        //MetodosCRUD.actualizar("Alumnos", "Carmen", "Laura", "nombre");
        //MetodosCRUD.borrarAlumno("98765432L");
        //Conexion.setDepartamento("12345678C", "DEP_INF");
        //Conexion.setAlumno("78451232L", "PROG_3_LCastillo1");
        //Conexion.setProfesor("12345678C", "PROG_3_LCastillo1");
    }
}