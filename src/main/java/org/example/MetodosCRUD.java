package org.example;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;

public class MetodosCRUD {


    //Metodos listar

    public static void listar(String coleccion){
        MongoCollection<Document> collection = Conexion.database.getCollection(coleccion);
        try (MongoCursor<Document> result = collection.find().iterator()) {
            while (result.hasNext()) {
                System.out.println(result.next());
            }
        }
    }

    //metodos buscar

    public static void buscarAlumno(String dniAlumno){
        MongoCollection<Document> collection = Conexion.database.getCollection("Alumnos");
        Document doc = collection.find(eq("dniAlumno", dniAlumno)).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No existen alumnos que coincidan.");
        }
    }

    public static void buscarProfesor (String dniProfesor){
        MongoCollection<Document> collection = Conexion.database.getCollection("Profesores");
        Document doc = collection.find(eq("dniAlumno", dniProfesor)).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No existen profesores que coincidan.");
        }
    }

    public static void buscarMatricula (String codigoMatricula){
        MongoCollection<Document> collection = Conexion.database.getCollection("Matricula");
        Document doc = collection.find(eq("codigoMatricula", codigoMatricula)).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No existen matriculas que coincidan.");
        }
    }

    public static void buscarDepartamento (String codigoDepartamento){
        MongoCollection<Document> collection = Conexion.database.getCollection("Departamento");
        Document doc = collection.find(eq("codigoDepartamento", codigoDepartamento)).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No existen departamentos que coincidan.");
        }
    }

    //Metodos insertar

    public static void insertarAlumnos (String dniAlumno, String nombre, String apellidos, LocalDate fechaNac){
        Conexion.database.getCollection("Alumnos").insertOne(new Document()
                .append("dniAlumno", dniAlumno)
                .append("nombre", nombre)
                .append("apellidos", apellidos)
                .append("fechaNac", fechaNac));
    }

    public static void insertarProfesores (String dniProfesores, String nombre, String apellidos, LocalDate fechaNac, int antiguedad){
        Conexion.database.getCollection("Profeosres").insertOne(new Document()
                .append("dniAlumno", dniProfesores)
                .append("nombre", nombre)
                .append("apellidos", apellidos)
                .append("fechaNac", fechaNac)
                .append("antiguedad", antiguedad));
    }

    public static void insertarMatricula (String codigoMatricula, String asignatura, int curso){
        Conexion.database.getCollection("Matricula").insertOne(new Document()
                .append("dniAlumno", codigoMatricula)
                .append("asignatura", asignatura)
                .append("curso", curso));

    }

    public static void insertarDepartamento (String codigoDepartamento, String nombre){
        Conexion.database.getCollection("Matricula").insertOne(new Document()
                .append("dniAlumno", codigoDepartamento)
                .append("asignatura", nombre));

    }

    //metodos actualizar

    public static void actualizar (String coleccion,String antes, String despues, String campoModificado){
        Document query = new Document().append(campoModificado, antes);
        Bson updates = Updates.combine(
                Updates.set(campoModificado, despues),
                Updates.currentTimestamp("lastUpdated"));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = Conexion.database.getCollection(coleccion).updateOne(query, updates, options);
            System.out.println("Cantidad de documentos modificados: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }

    //metodos borrar

    public static void borrarAlumno (String dniAlumno){
        try {
            Document doc = new Document("dniAlumno", dniAlumno);
            MongoCollection<Document> collection = Conexion.database.getCollection("Alumnos");
            collection.deleteOne(doc);
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }

    public static void borrarProfesores (String dniProfesor){
        try {
            Document doc = new Document("dniProfesor", dniProfesor);
            MongoCollection<Document> collection = Conexion.database.getCollection("Profesores");
            collection.deleteOne(doc);
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }

    public static void borrarMatricula (String codigoMatricula){
        try {
            Document doc = new Document("codigoMatricula", codigoMatricula);
            MongoCollection<Document> collection = Conexion.database.getCollection("Matricula");
            collection.deleteOne(doc);
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }

    public static void borrarDepartamento (String codigoDepartamento){
        try {
            Document doc = new Document("codigoDepartamento", codigoDepartamento);
            MongoCollection<Document> collection = Conexion.database.getCollection("Departamento");
            collection.deleteOne(doc);
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }
}
