package com.example.ernesto.remembrall; /**
 * Created by ernesto on 11/05/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; //Version de la base de datos

    private static final String DATABASE_NAME = "Bd.db"; //Nombre de la base de datos

    public BdHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creacion de las tablas que vamos a utilizar

        String crearTablaP = "CREATE TABLE Prestamo " +
                "(idPrestamo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NombrePersona TEXT," +
                "NombreObjeto TEXT," +
                "DescripcionObjeto TEXT" +
                "FechaP DATE," +
                "FechaD DATE," +
                "Status)";

        String crearTablaU = "CREATE TABLE Usuario "+
                "(idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NombreUsuario TEXT, "+
                "Pass TEXT);";

        String crearTablaPU = "CREATE TABLE Prestamo_Usuario "+
                "(FOREIGN KEY(id_Usuario) REFERENCES Usuario(idUsuario),+" +
                "FOREIGN KEY(id_Prestamo) REFERENCES Prestamo(idPrestamo);";

        db.execSQL(crearTablaP);
        db.execSQL(crearTablaU);
        db.execSQL(crearTablaPU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + "Prestamo.TABLE");

        // Create tables again
        onCreate(db);
    }

    //************OPERACIONES EN LA BD***********************

    public void insertarP(SQLiteDatabase db,int usuario, String[] data){
        String insertP = ("INSERT INTO Prestamo (NombrePersona, NombreObjeto, DescripcionObjeto, FechaP, FechaD, Status)" +
                "VALUES ("+data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+");");
        String insertPU =("INSERT INTO Prestamo_Usuario (idPrestamo, idUsuario)" +
                "VALUES ("+"el idPrestamo"+","+usuario+");"); ///Falta poner que Prestamo le va a agregar

        db.execSQL(insertP);
        db.execSQL(insertPU);
    }

    public void insertarU(SQLiteDatabase db, String[] data){
        String insert = ("INSERT INTO Usuario (NombreUsuario, Pass)" +
                "VALUES ("+data[0]+","+data[1]+");");

        db.execSQL(insert);
    }

    public void eliminar(SQLiteDatabase db, int id){
        String deleteP = "DELETE FROM Prestamo WHERE idPrestamo="+id+");";
        String deletePU = "DELETE FROM Prestamo_Usuario WHERE idPrestamo="+id+");";

        db.execSQL(deleteP);
        db.execSQL(deletePU);
    }

    public void actualizarStatus(SQLiteDatabase db, int id,String status){
        String updateStatus= "UPDATE Prestamo SET status = "+status + "WHERE id = "+id+");";

        db.execSQL(updateStatus);
    }

    public void actualizarDatosPrestamo(SQLiteDatabase db, int id, String[] data){
        String updateData = ("UPDATE Prestamo SET NombrePersona= "+data[0]+
                ", Nombre Objeto = "+data[1]+
        ", DescripcionObjeto = "+data[2]+
        ", FechaP = "+data[3]+
        ", FechaD = "+data[4]+
        ", status = "+data[5]+");");

        db.execSQL(updateData);
    }

    //*******************CONSULTAS EN LA BD**************

    private Cursor getPrestamos(SQLiteDatabase db){
        String tabla="Usuario";
        String[] columnas = new String[] {"NombrePersona", "NombreObjeto", "DescripcionObjeto", "FechaP", "FechaD", "Status"};
        String where = null;
        String[] args =null;
        String groupBy = null;
        String having=null;
        String orderBy= null;
        String limit= "100";

        return db.query(tabla, columnas, where, args, groupBy, having, orderBy, limit);
    }


}

