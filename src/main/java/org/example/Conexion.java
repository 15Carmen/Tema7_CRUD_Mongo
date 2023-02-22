package org.example;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class Conexion {

    public static MongoDatabase database;

    public static void conexionRemotaInstituto(){

        ConnectionString connectionString = new ConnectionString("mongodb+srv://cmartin:Marnu@cluster1.j1rulfz.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("Instituto");

    }

    //Métodos para relacionar las tablas entre sí
    public static void setDepartamento(String dniProfesor,String codigoDepartamento){
        MongoCollection<Document> profesores = database.getCollection("Profesores");
        MongoCollection<Document> departamento = database.getCollection("Departamento");

        Document doc=new Document("dniProfesor",dniProfesor); // Criterio de búsqueda
        Document a = new Document("codigoDepartamento",codigoDepartamento); // Criterio de búsqueda

        Document asigno = new Document("Departamento", departamento.find(a).first().getObjectId("_id"));
        Document update = new Document("$set",asigno );

        profesores.findOneAndUpdate(doc, update);
    }

    public static void setAlumno(String dniAlumno,String codigoMatricula){
        MongoCollection<Document> alumnos = database.getCollection("Alumnos");
        MongoCollection<Document> matricula = database.getCollection("Matricula");

        Document doc = new Document("codigoMatricula", codigoMatricula); // Criterio de búsqueda
        Document a=new Document("dniAlumno", dniAlumno); // Criterio de búsqueda

        Document asigno = new Document("Alumno", alumnos.find(a).first().getObjectId("_id"));
        Document update = new Document("$set",asigno );

        matricula.findOneAndUpdate(doc, update);
    }

    public static void setProfesor(String dniProfesor,String codigoMatricula){
        MongoCollection<Document> profesores = database.getCollection("Profesores");
        MongoCollection<Document> matricula = database.getCollection("Matricula");

        Document doc = new Document("codigoMatricula", codigoMatricula); // Criterio de búsqueda
        Document a=new Document("dniProfesor", dniProfesor); // Criterio de búsqueda

        Document asigno = new Document("Profesor", profesores.find(a).first().getObjectId("_id"));
        Document update = new Document("$set",asigno );

        matricula.findOneAndUpdate(doc, update);
    }

}
