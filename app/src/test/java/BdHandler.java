/**
 * Created by ernesto on 11/05/16.
 */
import android.content.Context;
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

        String crearTabla = "CREATE TABLE Prestamo " +
                "(idPrestamo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NombrePersona TEXT," +
                "NombreObjeto TEXT," +
                "DescripcionObjeto TEXT" +
                "FechaP DATE," +
                "FechaD DATE," +
                "Status)";

        db.execSQL(crearTabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + "Prestamo.TABLE");

        // Create tables again
        onCreate(db);
    }

    public void insertar(SQLiteDatabase db, String[] data){
        String insert = ("INSERT INTO Prestamo (NombrePersona, NombreObjeto, DescripcionObjeto, FechaP, FechaD, Status)" +
                "VALUES ("+data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+");");

        db.execSQL(insert);
    }

    public void eliminar(SQLiteDatabase db, int id){
        String delete = "DELETE FROM Prestamo WHERE id="+id;

        db.execSQL(delete);
    }

    public void actualizarStatus(SQLiteDatabase db, int id,String status){
        String updateStatus= ("UPDATE Prestamo SET status = "+status + "WHERE id = "+id);

        db.execSQL(updateStatus);
    }

    public void actualizarDatos(SQLiteDatabase db, int id, String[] data){
        String updateData = ("UPDATE Prestamo SET NombrePersona= "+data[0]+
                ", Nombre Objeto = "+data[1]+
        ", DescripcionObjeto = "+data[2]+
        ", FechaP = "+data[3]+
        ", FechaD = "+data[4]+
        ", status = "+data[5]+");");

        db.execSQL(updateData);
    }

}

