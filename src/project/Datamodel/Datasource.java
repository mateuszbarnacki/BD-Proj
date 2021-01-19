package project.Datamodel;

import java.sql.*;

public class Datasource {
    public static final String CONNECTION_STRING = "jdbc:postgresql://ziggy.db.elephantsql.com:5432/cefhxaqy";
    public static final String username = "cefhxaqy";
    public static final String password = "vgtlgQPZ-bCZLJeG2t6pRd9HMeO_vr-e";

    public static final String TABLE_WAREHOUSE = "magazyn";
    public static final String TABLE_WAREHOUSE_ID = "id_magazyn";
    public static final String TABLE_WAREHOUSE_NAME = "nazwa";
    public static final String TABLE_WAREHOUSE_STREET = "ulica";
    public static final String TABLE_WAREHOUSE_CITY = "miasto";
    public static final String TABLE_WAREHOUSE_POSTCODE = "kod pocztowy";
    public static final int INDEX_WAREHOUSE_ID = 1;
    public static final int INDEX_WAREHOUSE_NAME = 2;
    public static final int INDEX_WAREHOUSE_STREET = 3;
    public static final int INDEX_WAREHOUSE_CITY = 4;
    public static final int INDEX_WAREHOUSE_POSTCODE = 5;

    public static final String TABLE_DEPARTMENT = "dzial";
    public static final String TABLE_DEPARTMENT_ID = "id_dzial";
    public static final String TABLE_DEPARTMENT_NAME = "nazwa";
    public static final int INDEX_DEPARTMENT_ID = 1;
    public static final int INDEX_DEPARTMENT_NAME = 2;

    public static final String TABLE_MANAGER = "kierownik";
    public static final String TABLE_MANAGER_ID = "id_kierownik";
    public static final String TABLE_MANAGER_NAME = "imie";
    public static final String TABLE_MANAGER_SURNAME = "nazwisko";
    public static final String TABLE_MANAGER_PHONE = "numer telefonu";
    public static final String TABLE_MANAGER_EMAIL = "adres email";
    public static final int INDEX_MANAGER_ID = 1;
    public static final int INDEX_MANAGER_NAME = 2;
    public static final int INDEX_MANAGER_SURNAME = 3;
    public static final int INDEX_MANAGER_PHONE = 4;
    public static final int INDEX_MANAGER_EMAIL = 5;

    public static final String TABLE_WORKER = "pracownik";
    public static final String TABLE_WORKER_ID = "id_pracownik";
    public static final String TABLE_WORKER_NAME = "imie";
    public static final String TABLE_WORKER_SURNAME = "nazwisko";
    public static final String TABLE_WORKER_EMAIL = "adres email";
    public static final int INDEX_WORKER_ID = 1;
    public static final int INDEX_WORKER_NAME = 2;
    public static final int INDEX_WORKER_SURNAME = 3;
    public static final int INDEX_WORKER_EMAIL = 4;

    public static final String TABLE_DUTIES = "obowiazek";
    public static final String TABLE_DUTIES_ID = "id_obowiazek";
    public static final String TABLE_DUTIES_DESC = "opis";
    public static final int INDEX_DUTIES_ID = 1;
    public static final int INDEX_DUTIES_DESC = 2;

    public static final String TABLE_VACATION = "plany urlopowe";
    public static final String TABLE_VACATION_ID = "id_urlop";
    public static final String TABLE_VACATION_BEGINNING = "data rozpoczecia";
    public static final String TABLE_VACATION_END = "data zakonczenia";
    public static final int INDEX_VACATION_ID = 1;
    public static final int INDEX_VACATION_BEGINNING = 2;
    public static final int INDEX_VACATION_END = 3;

    public static final String TABLE_EXPOSITION = "ekspozycja";
    public static final String TABLE_EXPOSITION_ID = "id_ekspozycja";
    public static final String TABLE_EXPOSITION_NAME = "nazwa";
    public static final String TABLE_EXPOSITION_PRICE = "cena";
    public static final int INDEX_EXPOSITION_ID = 1;
    public static final int INDEX_EXPOSITION_NAME = 2;
    public static final int INDEX_EXPOSITION_PRICE = 3;

    public static final String TABLE_COMMODITY = "towar";
    public static final String TABLE_COMMODITY_ID = "id_towar";
    public static final String TABLE_COMMODITY_NAME = "nazwa";
    public static final String TABLE_COMMODITY_PRICE = "cena";
    public static final int INDEX_COMMODITY_ID = 1;
    public static final int INDEX_COMMODITY_NAME = 2;
    public static final int INDEX_COMMODITY_PRICE = 3;

    public static final String TABLE_DESIGNER = "projektant";
    public static final String TABLE_DESIGNER_ID = "id_projektant";
    public static final String TABLE_DESIGNER_NAME = "imie";
    public static final String TABLE_DESIGNER_SURNAME = "nazwisko";
    public static final String TABLE_DESIGNER_EMAIL = "adres_email";
    public static final String TABLE_DESIGNER_PHONE = "nr_telefonu";
    public static final int INDEX_DESIGNER_ID = 1;
    public static final int INDEX_DESIGNER_NAME = 2;
    public static final int INDEX_DESIGNER_SURNAME = 3;
    public static final int INDEX_DESIGNER_EMAIL = 4;
    public static final int INDEX_DESIGNER_PHONE = 5;

    public static final String TABLE_OPINION = "opinia";
    public static final String TABLE_OPINION_ID = "id_opinia";
    public static final String TABLE_OPINION_DESC = "opis";
    public static final int INDEX_OPINION_ID = 1;
    public static final int INDEX_OPINION_DESC = 2;

    // ============ Encje asocjacyjne =========================

    public static final String TABLE_COMMODITY_OPINION = "towar_opinia";
    public static final String TABLE_COMMODITY_OPINION_ID_COMMODITY = "id_towar";
    public static final String TABLE_COMMODITY_OPINION_ID_OPINION = "id_opinia";
    public static final int INDEX_COMMODITY_OPINION_ID_COMMODITY = 1;
    public static final int INDEX_COMMODITY_OPINION_ID_OPINION = 2;

    public static final String TABLE_EXPOSITION_DESIGNER = "ekspozycja_projektant";
    public static final String TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION = "id_ekspozycja";
    public static final String TABLE_EXPOSITION_DESIGNER_ID_DESIGNER = "id_projektant";
    public static final int INDEX_EXPOSITION_DESIGNER_ID_EXPOSITION = 1;
    public static final int INDEX_EXPOSITION_DESIGNER_ID_DESIGNER = 2;

    public static final String TABLE_EXPOSITION_COMMODITY = "ekspozycja_towar";
    public static final String TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION = "id_ekspozycja";
    public static final String TABLE_EXPOSITION_COMMODITY_ID_COMMODITY = "id_towar";
    public static final int INDEX_EXPOSITION_COMMODITY_ID_EXPOSITION = 1;
    public static final int INDEX_EXPOSITION_COMMODITY_ID_COMMODITY = 2;

    public static final String TABLE_WORKER_DUTY = "pracownik_obowiazek";
    public static final String TABLE_WORKER_DUTY_ID_WORKER = "id_pracownik";
    public static final String TABLE_WORKER_DUTY_ID_DUTY = "id_obowiazek";
    public static final int INDEX_WORKER_DUTY_ID_WORKER = 1;
    public static final int INDEX_WORKER_DUTY_ID_DUTY = 2;

    public static final String TABLE_WORKER_VACATION = "pracownik_plan";
    public static final String TABLE_WORKER_VACATION_ID_WORKER = "id_pracownik";
    public static final String TABLE_WORKER_VACATION_ID_VACATION = "id_plan";
    public static final int INDEX_WORKER_VACATION_ID_WORKER = 1;
    public static final int INDEX_WORKER_VACATION_ID_VACATION = 2;

    public static final String TABLE_MANAGER_WORKER = "kierownik_pracownik";
    public static final String TABLE_MANAGER_WORKER_ID_MANAGER = "id_kierownik";
    public static final String TABLE_MANAGER_WORKER_ID_WORKER = "id_pracownik";
    public static final int INDEX_MANAGER_WORKER_ID_MANAGER = 1;
    public static final int INDEX_MANAGER_WORKER_ID_WORKER = 2;

    public static final String TABLE_DEPARTMENT_EXPOSITION = "dzial_ekspozycja";
    public static final String TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT = "id_dzial";
    public static final String TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION = "id_ekspozycja";
    public static final int INDEX_DEPARTMENT_EXPOSITION_ID_DEPARTMENT = 1;
    public static final int INDEX_DEPARTMENT_EXPOSITION_ID_EXPOSITION = 2;

    public static final String TABLE_DEPARTMENT_MANAGER = "dzial_kierownik";
    public static final String TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT = "id_dzial";
    public static final String TABLE_DEPARTMENT_MANAGER_ID_MANAGER = "id_kierownik";
    public static final int INDEX_DEPARTMENT_MANAGER_ID_DEPARTMENT = 1;
    public static final int INDEX_DEPARTMENT_MANAGER_ID_MANAGER = 2;

    public static final String TABLE_WAREHOUSE_EXPOSITION = "magazyn_dzial";
    public static final String TABLE_WAREHOUSE_EXPOSITION_ID_WAREHOUSE = "id_magazyn";
    public static final String TABLE_WAREHOUSE_EXPOSITION_ID_EXPOSITION = "id_dzial";
    public static final int INDEX_WAREHOUSE_EXPOSITION_ID_WAREHOUSE = 1;
    public static final int INDEX_WAREHOUSE_EXPOSITION_ID_EXPOSITION = 2;

    // ================== Creation of the tables ===================

    public static final String CREATE_WAREHOUSE_TABLE =
        "CREATE TABLE " + TABLE_WAREHOUSE + " (" + TABLE_WAREHOUSE_ID + " INTEGER NOT NULL, " + TABLE_WAREHOUSE_NAME +
                " VARCHAR(25) NOT NULL, " + TABLE_WAREHOUSE_STREET + " VARCHAR(25) NOT NULL, " +
                TABLE_WAREHOUSE_CITY + " VARCHAR(25) NOT NULL, " + TABLE_WAREHOUSE_POSTCODE + " VARCHAR(6) NOT NULL, " +
                "CONSTRAINT " + TABLE_WAREHOUSE_ID + " PRIMARY KEY (" + TABLE_WAREHOUSE_ID + ")";

    public static final String CREATE_DEPARTMENT_TABLE =
            "CREATE TABLE " + TABLE_DEPARTMENT + " (\n" +
                    TABLE_DEPARTMENT_ID +" INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_NAME + " VARCHAR(25) NOT NULL,\n" +
                    " CONSTRAINT " + TABLE_DEPARTMENT_ID + " PRIMARY KEY (" + TABLE_DEPARTMENT_ID + ")\n" +
                    ")";

    public static final String CREATE_MANAGER_TABLE =
            "CREATE TABLE " + TABLE_MANAGER + " (\n" +
                   TABLE_MANAGER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_MANAGER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_MANAGER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_MANAGER_PHONE + " VARCHAR(9),\n" +
                    TABLE_MANAGER_EMAIL + " VARCHAR(30),\n" +
                    " CONSTRAINT " + TABLE_MANAGER_ID + " PRIMARY KEY (" + TABLE_MANAGER_ID + ")\n" +
                    ")";

    public static final String CREATE_WORKER_TABLE =
            "CREATE TABLE " + TABLE_WORKER + " (\n" +
                    TABLE_WORKER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_WORKER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_WORKER_EMAIL + " VARCHAR(30),\n" +
                    " CONSTRAINT " + TABLE_WORKER_ID + " PRIMARY KEY (" + TABLE_WORKER_ID + ")\n" +
                    ")";

    public static final String CREATE_DUTIES_TABLE =
            "CREATE TABLE " + TABLE_DUTIES + " (\n" +
                    TABLE_DUTIES_ID + " INTEGER NOT NULL,\n" +
                    TABLE_DUTIES_DESC + " VARCHAR(30) NOT NULL,\n" +
                    " CONSTRAINT " + TABLE_DUTIES_ID + " PRIMARY KEY (" + TABLE_DUTIES_ID + ")\n" +
                    ")";

    public static final String CREATE_VACATION_TABLE =
            "CREATE TABLE " + TABLE_VACATION + " (\n" +
                    TABLE_VACATION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_VACATION_BEGINNING + " DATE NOT NULL,\n" +
                    TABLE_VACATION_END + " DATE NOT NULL,\n" +
                    " CONSTRAINT " + TABLE_VACATION_ID + " PRIMARY KEY (" + TABLE_VACATION_ID + ")\n" +
                    ")";

    public static final String CREATE_EXPOSITION_TABLE =
            "CREATE TABLE " + TABLE_EXPOSITION + " (\n" +
                    TABLE_EXPOSITION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_EXPOSITION_PRICE + " DOUBLE PRECISION DEFAULT 0.0 NOT NULL,\n" +
                    " CONSTRAINT " + TABLE_EXPOSITION_ID + " PRIMARY KEY (" + TABLE_EXPOSITION_ID + ")\n" +
                    ")";

    public static final String CREATE_COMMODITY_TABLE =
            "CREATE TABLE " + TABLE_COMMODITY + " (\n" +
                    TABLE_COMMODITY_ID + " INTEGER NOT NULL,\n" +
                    TABLE_COMMODITY_NAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_COMMODITY_PRICE + " DOUBLE PRECISION DEFAULT 0.0 NOT NULL,\n" +
                    " CONSTRAINT " + TABLE_COMMODITY_ID + " PRIMARY KEY (" + TABLE_COMMODITY_ID + ")\n" +
                    ")";

    public static final String CREATE_DESIGNER_TABLE =
            "CREATE TABLE " + TABLE_DESIGNER + " (\n" +
                    TABLE_DESIGNER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_DESIGNER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_DESIGNER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_DESIGNER_EMAIL + " VARCHAR(30),\n" +
                    TABLE_DESIGNER_PHONE + " VARCHAR(9),\n" +
                    " CONSTRAINT " + TABLE_DESIGNER_ID + " PRIMARY KEY (" + TABLE_DESIGNER_ID + ")\n" +
                    ")";

    public static final String CREATE_OPINION_TABLE =
            "CREATE TABLE " + TABLE_OPINION + " (\n" +
                    TABLE_OPINION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_OPINION_DESC + " VARCHAR(50) NOT NULL,\n" +
                    " CONSTRAINT " + TABLE_OPINION_ID + " PRIMARY KEY (" + TABLE_OPINION_ID + ")\n" +
                    ");";

    private PreparedStatement insertPerson;

    private Connection connection;
    private final static Datasource instance = new Datasource();

    private Datasource(){}

    public static Datasource getInstance(){
        return instance;
    }

    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING, username, password);

            //createPersonTable();

            //insertPerson = connection.prepareStatement(INSERT_PERSON);

            return true;
        }catch (SQLException e){
            System.out.println("Couldn't open the connection to main database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean close(){
        try{
            /*if(insertOsoba != null){
                insertOsoba.close();
            }*/
            if(connection != null){
                connection.close();
            }
            return true;
        }catch (SQLException e){
            System.out.println("Couldn't close the connection: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private void createPersonTable(){
        try {
            Statement statement = connection.createStatement();
            //statement.execute(CREATE_PERSON_TABLE);
        }catch(SQLException e){
            //System.out.println("Couldn't create " + TABLE_PERSON + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
