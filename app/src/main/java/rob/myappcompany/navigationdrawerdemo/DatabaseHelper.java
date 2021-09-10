package rob.myappcompany.navigationdrawerdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{


    public static final String SYSTEM_DB = "SYSTEM_DB.db";
    public static final int VERSION_NUM = 1;

    public static final String COLUM_ID = "ID";
    private static final String TICKET_SYSTEM_TABLE = "TICKET_SYSTEM_TABLE";
    public static final String COLUM_CREATOR_NAME = "CREATOR_NAME";
    public static final String COLUM_QUESTION_TICKET = "QUESTION_TICKET";
    public static final String COLUM_TICKET_NAME = "TICKET_NAME";
    public static final String COLUM_TITLE_CREATED = "TITLE_CREATED";
    public static final String COLUM_SITUATION_TICKET = "SITUATION_TICKET";
    public static final String COLUM_PRIORITY_TICKET = "PRIORITY_TICKET";
    public static final String COLUM_CREATED_DATE = "CREATED_DATE";
    public static final String COLUM_UPDATED_DATE = "UPDATED_DATE";


    public static final String ANSWER_TICKET_TABLE = "ANSWER_TICKET";
    public static final String COLUM_RESPONSE_TICKET = "RESPONSE_TICKET";
    public static final String COLUM_RESPONSE_NAME = "RESPONSE_NAME";
    public static final String COLUM_FOREIGN_ID = "FOREIGN_ID";
    public static final String COLUM_UPDATED_DATE_RESPONSE = "UPDATED_DATE_RESPONSE";
    private static final String ID = "ID";



    public DatabaseHelper(Context context) {
        super(context, SYSTEM_DB, null, VERSION_NUM);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTicketTableStatment = "CREATE TABLE IF NOT EXISTS  " + TICKET_SYSTEM_TABLE + " ( " + COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUM_CREATOR_NAME + " TEXT, " +
                COLUM_QUESTION_TICKET + " TEXT, " + COLUM_TICKET_NAME + " TEXT, " + COLUM_TITLE_CREATED + " TEXT, " + COLUM_SITUATION_TICKET + " BOOL, " + COLUM_PRIORITY_TICKET + " TEXT, " + COLUM_CREATED_DATE + " DATE, " + COLUM_UPDATED_DATE + " DATE)";

        String createAnswerTicketStatment = "CREATE TABLE IF NOT EXISTS " + ANSWER_TICKET_TABLE + " ( " + ID +" INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUM_FOREIGN_ID + " INT , " +
                COLUM_RESPONSE_NAME + " TEXT , " + COLUM_RESPONSE_TICKET + " TEXT , " +  COLUM_UPDATED_DATE_RESPONSE + " DATE)";

        db.execSQL(createTicketTableStatment);
        db.execSQL(createAnswerTicketStatment);


        Log.i("TAG",String.valueOf(db.isOpen()));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public String getDataTime(String choose){
        LocalDateTime localDateTime;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            localDateTime = LocalDateTime.now();

            if (choose.equals("Data")){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return localDateTime.format(formatter);
            }else if(choose == "Time"){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                return localDateTime.format(formatter);
            }else if (choose == "DataTime"){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                return localDateTime.format(formatter);
            }
        }

        return choose;
    }

    public boolean addTicket(TicketModel ticketModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insertTicket = new ContentValues();

        insertTicket.put(COLUM_CREATOR_NAME, ticketModel.getCOLUM_CREATOR_NAME());
        insertTicket.put(COLUM_QUESTION_TICKET, ticketModel.getCOLUM_QUESTION_TICKET());
        insertTicket.put(COLUM_TICKET_NAME, ticketModel.getCOLUM_TICKET_NAME());
        insertTicket.put(COLUM_TITLE_CREATED, ticketModel.getCOLUM_TITLE_CREATED());
        insertTicket.put(COLUM_SITUATION_TICKET, ticketModel.getCOLUM_SITUATION_TICKET());
        insertTicket.put(COLUM_PRIORITY_TICKET, ticketModel.getCOLUM_PRIORITY_TICKET());
        insertTicket.put(COLUM_CREATED_DATE, getDataTime("DataTime"));
        insertTicket.put(COLUM_UPDATED_DATE, "28.03.2012" );
        long d = db.insert(TICKET_SYSTEM_TABLE, null, insertTicket);
        if (d == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean addResponse(ResponseModel responseModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insertResponse = new ContentValues();

        insertResponse.put(COLUM_FOREIGN_ID, 12);
        insertResponse.put(COLUM_RESPONSE_NAME, responseModel.getCOLUM_RESPONSE_NAME());
        insertResponse.put(COLUM_RESPONSE_TICKET, responseModel.getCOLUM_RESPONSE_TICKET());
        insertResponse.put(COLUM_UPDATED_DATE_RESPONSE, getDataTime("DateTime"));

        long d = db.insert(ANSWER_TICKET_TABLE, null, insertResponse);
        if (d == -1){
            return false;
        }else {
            return true;
        }
    }




    //public List<TicketModel>getAllTicket(){
    public String getAllTicket(){

        List<TicketModel> returnTicketFromDB = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String queryReadDB = "SELECT * FROM "+ TICKET_SYSTEM_TABLE;

        Cursor cursor =db.rawQuery(queryReadDB, null);

        cursor.moveToFirst();
        Log.i("TAG",getDataTime("DataTime"));


        if (cursor.moveToNext()){
            /*insertTicket.put(COLUM_CREATOR_NAME, "MATHEO");
            insertTicket.put(COLUM_QUESTION_TICKET, "How to create Database?");
            insertTicket.put(COLUM_TICKET_NAME, "IT");
            insertTicket.put(COLUM_TITLE_CREATED, "Problem");
            insertTicket.put(COLUM_SITUATION_TICKET, (byte[]) null);
            insertTicket.put(COLUM_PRIORITY_TICKET, "High");
            insertTicket.put(COLUM_CREATED_DATE, "1.2.2001");
            insertTicket.put(COLUM_UPDATED_DATE, "28.03.2012" );*/

            do{
                String Creater_name = cursor.getString(1);
                String name = cursor.getString(2);

                //Log.i("TAG", Creater_name);
                //Log.i("TAG", name);
                return name;
            }while (cursor.moveToNext());
        }
        return "";
    }

    public List<ResponseModel>getAllResponse(){
        List<ResponseModel> returnResponseFromDB = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String queryReadResponseDB = "SELECT * FROM "+ TICKET_SYSTEM_TABLE;

        Cursor cursor =db.rawQuery(queryReadResponseDB, null);

        cursor.moveToFirst();

        if (cursor.moveToNext()){
            /*insertTicket.put(COLUM_CREATOR_NAME, "MATHEO");
            insertTicket.put(COLUM_QUESTION_TICKET, "How to create Database?");
            insertTicket.put(COLUM_TICKET_NAME, "IT");
            insertTicket.put(COLUM_TITLE_CREATED, "Problem");
            insertTicket.put(COLUM_SITUATION_TICKET, (byte[]) null);
            insertTicket.put(COLUM_PRIORITY_TICKET, "High");
            insertTicket.put(COLUM_CREATED_DATE, "1.2.2001");
            insertTicket.put(COLUM_UPDATED_DATE, "28.03.2012" );*/

            do{
                String Creater_name = cursor.getString(3);
                String name = cursor.getString(2);
                Log.i("TAG", Creater_name);
                Log.i("TAG", name);
            }while (cursor.moveToNext());
        }
        return returnResponseFromDB;
    }


}