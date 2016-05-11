/**
 * Created by ernesto on 11/05/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; //Version de la base de datos

    private static final String DATABASE_NAME = "Bd.db"; //Nombre de la base de datos

    public DbHandler(Context context ) {
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
                "FechaD DATE)"                ;

        db.execSQL(crearTabla);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + "Student.TABLE");

        // Create tables again
        onCreate(db);

    }
