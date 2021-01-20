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
    public static final String TABLE_WORKER_VACATION_ID_VACATION = "id_urlop";
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

    public static final String TABLE_WAREHOUSE_DEPARTMENT = "magazyn_dzial";
    public static final String TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE = "id_magazyn";
    public static final String TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT = "id_dzial";
    public static final int INDEX_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE = 1;
    public static final int INDEX_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT = 2;

    // ================== Creation of the tables ===================

    public static final String CREATE_WAREHOUSE_TABLE =
        "CREATE TABLE " + TABLE_WAREHOUSE + " (" + TABLE_WAREHOUSE_ID + " INTEGER NOT NULL, " + TABLE_WAREHOUSE_NAME +
                " VARCHAR(25) NOT NULL, " + TABLE_WAREHOUSE_STREET + " VARCHAR(25) NOT NULL, " +
                TABLE_WAREHOUSE_CITY + " VARCHAR(25) NOT NULL, " + TABLE_WAREHOUSE_POSTCODE + " VARCHAR(6) NOT NULL, " +
                "CONSTRAINT id_magazyn PRIMARY KEY (" + TABLE_WAREHOUSE_ID + ")";

    public static final String CREATE_DEPARTMENT_TABLE =
            "CREATE TABLE " + TABLE_DEPARTMENT + " (\n" +
                    TABLE_DEPARTMENT_ID +" INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_NAME + " VARCHAR(25) NOT NULL,\n" +
                    " CONSTRAINT id_dzial PRIMARY KEY (" + TABLE_DEPARTMENT_ID + ")\n" +
                    ")";

    public static final String CREATE_MANAGER_TABLE =
            "CREATE TABLE " + TABLE_MANAGER + " (\n" +
                   TABLE_MANAGER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_MANAGER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_MANAGER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_MANAGER_PHONE + " VARCHAR(9),\n" +
                    TABLE_MANAGER_EMAIL + " VARCHAR(30),\n" +
                    " CONSTRAINT id_kierownik PRIMARY KEY (" + TABLE_MANAGER_ID + ")\n" +
                    ")";

    public static final String CREATE_WORKER_TABLE =
            "CREATE TABLE " + TABLE_WORKER + " (\n" +
                    TABLE_WORKER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_WORKER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_WORKER_EMAIL + " VARCHAR(30),\n" +
                    " CONSTRAINT id_pracownik PRIMARY KEY (" + TABLE_WORKER_ID + ")\n" +
                    ")";

    public static final String CREATE_DUTIES_TABLE =
            "CREATE TABLE " + TABLE_DUTIES + " (\n" +
                    TABLE_DUTIES_ID + " INTEGER NOT NULL,\n" +
                    TABLE_DUTIES_DESC + " VARCHAR(30) NOT NULL,\n" +
                    " CONSTRAINT id_obowiazek PRIMARY KEY (" + TABLE_DUTIES_ID + ")\n" +
                    ")";

    public static final String CREATE_VACATION_TABLE =
            "CREATE TABLE " + TABLE_VACATION + " (\n" +
                    TABLE_VACATION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_VACATION_BEGINNING + " DATE NOT NULL,\n" +
                    TABLE_VACATION_END + " DATE NOT NULL,\n" +
                    " CONSTRAINT id_urlop PRIMARY KEY (" + TABLE_VACATION_ID + ")\n" +
                    ")";

    public static final String CREATE_EXPOSITION_TABLE =
            "CREATE TABLE " + TABLE_EXPOSITION + " (\n" +
                    TABLE_EXPOSITION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_EXPOSITION_PRICE + " DOUBLE PRECISION DEFAULT 0.0 NOT NULL,\n" +
                    " CONSTRAINT id_ekspozycja PRIMARY KEY (" + TABLE_EXPOSITION_ID + ")\n" +
                    ")";

    public static final String CREATE_COMMODITY_TABLE =
            "CREATE TABLE " + TABLE_COMMODITY + " (\n" +
                    TABLE_COMMODITY_ID + " INTEGER NOT NULL,\n" +
                    TABLE_COMMODITY_NAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_COMMODITY_PRICE + " DOUBLE PRECISION DEFAULT 0.0 NOT NULL,\n" +
                    " CONSTRAINT id_towar PRIMARY KEY (" + TABLE_COMMODITY_ID + ")\n" +
                    ")";

    public static final String CREATE_DESIGNER_TABLE =
            "CREATE TABLE " + TABLE_DESIGNER + " (\n" +
                    TABLE_DESIGNER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_DESIGNER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_DESIGNER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_DESIGNER_EMAIL + " VARCHAR(30),\n" +
                    TABLE_DESIGNER_PHONE + " VARCHAR(9),\n" +
                    " CONSTRAINT id_projektant PRIMARY KEY (" + TABLE_DESIGNER_ID + ")\n" +
                    ")";

    public static final String CREATE_OPINION_TABLE =
            "CREATE TABLE " + TABLE_OPINION + " (\n" +
                    TABLE_OPINION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_OPINION_DESC + " VARCHAR(50) NOT NULL,\n" +
                    " CONSTRAINT id_opinia PRIMARY KEY (" + TABLE_OPINION_ID + ")\n" +
                    ");";

    public static final String CREATE_COMMODITY_OPINION_TABLE =
            "CREATE TABLE " + TABLE_COMMODITY_OPINION + " (\n" +
                    TABLE_COMMODITY_OPINION_ID_COMMODITY + " INTEGER NOT NULL,\n" +
                    TABLE_COMMODITY_OPINION_ID_OPINION + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT towar_opinia_pk PRIMARY KEY (" + TABLE_COMMODITY_OPINION_ID_COMMODITY + ", " + TABLE_COMMODITY_OPINION_ID_OPINION + ")\n" +
                    ")";

    public static final String CREATE_EXPOSITION_DESIGNER_TABLE =
            "CREATE TABLE " + TABLE_EXPOSITION_DESIGNER + " (\n" +
                    TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_DESIGNER_ID_DESIGNER + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT ekspozycja_projektant_pk PRIMARY KEY (" + TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION + ", " + TABLE_EXPOSITION_DESIGNER_ID_DESIGNER + ")\n" +
                    ")";

    public static final String CREATE_EXPOSITION_COMMODITY_TABLE =
            "CREATE TABLE " + TABLE_EXPOSITION_COMMODITY + " (\n" +
                    TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_COMMODITY_ID_COMMODITY + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT ekspozycja_towar_pk PRIMARY KEY (" + TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION + ", " + TABLE_EXPOSITION_COMMODITY_ID_COMMODITY + ")\n" +
                    ")";

    public static final String CREATE_WORKER_DUTY_TABLE =
            "CREATE TABLE " + TABLE_WORKER_DUTY + " (\n" +
                    TABLE_WORKER_DUTY_ID_WORKER + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_DUTY_ID_DUTY + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT pracownik_obowiazek_pk PRIMARY KEY (" + TABLE_WORKER_DUTY_ID_WORKER + ", " + TABLE_WORKER_DUTY_ID_DUTY + ")\n" +
                    ")";

    public static final String CREATE_WORKER_VACATION_TABLE =
            "CREATE TABLE " + TABLE_WORKER_VACATION + " (\n" +
                    TABLE_WORKER_VACATION_ID_WORKER + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_VACATION_ID_VACATION + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT pracownik_plan_pk PRIMARY KEY (" + TABLE_WORKER_VACATION_ID_WORKER + ", " + TABLE_WORKER_VACATION_ID_VACATION + ")\n" +
                    ")";

    public static final String CREATE_MANAGER_WORKER_TABLE =
            "CREATE TABLE " + TABLE_MANAGER_WORKER + " (\n" +
                    TABLE_MANAGER_WORKER_ID_MANAGER + " INTEGER NOT NULL,\n" +
                    TABLE_MANAGER_WORKER_ID_WORKER + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT kierownik_pracownik_pk PRIMARY KEY (" + TABLE_MANAGER_WORKER_ID_MANAGER + ", " + TABLE_MANAGER_WORKER_ID_WORKER + ")\n" +
                    ")";

    public static final String CREATE_DEPARTMENT_EXPOSITION_TABLE =
            "CREATE TABLE " + TABLE_DEPARTMENT_EXPOSITION + " (\n" +
                    TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT + " INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT dzial_ekspozycja_pk PRIMARY KEY (" + TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT + ", " + TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION + ")\n" +
                    ")";

    public static final String CREATE_DEPARTMENT_MANAGER_TABLE =
            "CREATE TABLE " + TABLE_DEPARTMENT_MANAGER + " (\n" +
                    TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT + " INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_MANAGER_ID_MANAGER + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT dzial_kierownik_pk PRIMARY KEY (" + TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT + ", " + TABLE_DEPARTMENT_MANAGER_ID_MANAGER + ")\n" +
                    ")";

    public static final String CREATE_WAREHOUSE_DEPARTMENT_TABLE =
            "CREATE TABLE " + TABLE_WAREHOUSE_DEPARTMENT + " (\n" +
                    TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE + " INTEGER NOT NULL,\n" +
                    TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT magazyn_dzial_pk PRIMARY KEY (" + TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE + ", " + TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT + ")\n" +
                    ")";

    // =================== Add foreign keys ===================

    public static final String ALTER_TABLE_COMMODITY_OPINION_FK_OPINION =
          "ALTER TABLE " + TABLE_COMMODITY_OPINION + " ADD CONSTRAINT opinia_towar_opinia_fk\n" +
                  "FOREIGN KEY (" + TABLE_COMMODITY_OPINION_ID_OPINION + ")\n" +
                  "REFERENCES " + TABLE_OPINION + " (" + TABLE_OPINION_ID + ")\n" +
                  "ON DELETE NO ACTION\n" +
                  "ON UPDATE NO ACTION\n" +
                  "NOT DEFERRABLE";

    public static final String ALTER_TABLE_COMMODITY_OPINION_FK_COMMODITY =
            "ALTER TABLE " + TABLE_COMMODITY_OPINION + " ADD CONSTRAINT towar_towar_opinia_fk\n" +
                    "FOREIGN KEY (" + TABLE_COMMODITY_OPINION_ID_COMMODITY + ")\n" +
                    "REFERENCES " + TABLE_COMMODITY + " (" + TABLE_COMMODITY_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_EXPOSITION_DESIGNER_FK_DESIGNER =
            "ALTER TABLE " + TABLE_EXPOSITION_DESIGNER + " ADD CONSTRAINT projektant_ekspozycja_projektant_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_DESIGNER_ID_DESIGNER + ")\n" +
                    "REFERENCES " + TABLE_DESIGNER + " (" + TABLE_DESIGNER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_EXPOSITION_DESIGNER_FK_EXPOSITION =
            "ALTER TABLE " + TABLE_EXPOSITION_DESIGNER + " ADD CONSTRAINT ekspozycja_ekspozycja_projektant_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION + ")\n" +
                    "REFERENCES " + TABLE_EXPOSITION + " (" + TABLE_EXPOSITION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_EXPOSITION_COMMODITY_FK_COMMODITY =
            "ALTER TABLE " + TABLE_EXPOSITION_COMMODITY + " ADD CONSTRAINT towar_ekspozycja_towar_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_COMMODITY_ID_COMMODITY + ")\n" +
                    "REFERENCES " + TABLE_COMMODITY + " (" + TABLE_COMMODITY_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_EXPOSITION_COMMODITY_FK_EXPOSITION =
            "ALTER TABLE " + TABLE_EXPOSITION_COMMODITY + " ADD CONSTRAINT ekspozycja_ekspozycja_towar_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION + ")\n" +
                    "REFERENCES " + TABLE_EXPOSITION + " (" + TABLE_EXPOSITION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_DEPARTMENT_EXPOSITION_FK_EXPOSITION =
            "ALTER TABLE " + TABLE_DEPARTMENT_EXPOSITION + " ADD CONSTRAINT ekspozycja_dzial_ekspozycja_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION + ")\n" +
                    "REFERENCES " + TABLE_EXPOSITION + " (" + TABLE_EXPOSITION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_DEPARTMENT_EXPOSITION_FK_DEPARTMENT =
            "ALTER TABLE " + TABLE_DEPARTMENT_EXPOSITION + " ADD CONSTRAINT dzial_dzial_ekspozycja_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT + ")\n" +
                    "REFERENCES " + TABLE_DEPARTMENT + " (" + TABLE_DEPARTMENT_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_WORKER_DUTY_FK_DUTY =
            "ALTER TABLE " + TABLE_WORKER_DUTY + " ADD CONSTRAINT obowiazek_pracownik_obowiazek_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_DUTY_ID_DUTY + ")\n" +
                    "REFERENCES " + TABLE_DUTIES + " (" + TABLE_DUTIES_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_WORKER_DUTY_FK_WORKER =
            "ALTER TABLE " + TABLE_WORKER_DUTY + " ADD CONSTRAINT pracownik_pracownik_obowiazek_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_DUTY_ID_WORKER + ")\n" +
                    "REFERENCES " + TABLE_WORKER + " (" + TABLE_WORKER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_WORKER_VACATION_FK_VACATION =
            "ALTER TABLE " + TABLE_WORKER_VACATION + " ADD CONSTRAINT plany_urlopowe_pracownik_plan_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_VACATION_ID_VACATION + ")\n" +
                    "REFERENCES " + TABLE_VACATION + " (" + TABLE_VACATION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_WORKER_VACATION_FK_WORKER =
            "ALTER TABLE " + TABLE_WORKER_VACATION + " ADD CONSTRAINT pracownik_pracownik_plan_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_VACATION_ID_WORKER + ")\n" +
                    "REFERENCES " + TABLE_WORKER + " (" + TABLE_WORKER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_MANAGER_WORKER_FK_WORKER =
            "ALTER TABLE " + TABLE_MANAGER_WORKER + " ADD CONSTRAINT pracownik_kierownik_pracownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_MANAGER_WORKER_ID_WORKER + ")\n" +
                    "REFERENCES " + TABLE_WORKER + " (" + TABLE_WORKER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_MANAGER_WORKER_FK_MANAGER =
            "ALTER TABLE " + TABLE_MANAGER_WORKER + " ADD CONSTRAINT kierownik_kierownik_pracownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_MANAGER_WORKER_ID_MANAGER + ")\n" +
                    "REFERENCES " + TABLE_MANAGER + " (" + TABLE_MANAGER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_DEPARTMENT_MANAGER_FK_MANAGER =
            "ALTER TABLE " + TABLE_DEPARTMENT_MANAGER + " ADD CONSTRAINT kierownik_dzial_kierownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_MANAGER_ID_MANAGER + ")\n" +
                    "REFERENCES " + TABLE_MANAGER + " (" + TABLE_MANAGER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_DEPARTMENT_MANAGER_FK_DEPARTMENT =
            "ALTER TABLE " + TABLE_DEPARTMENT_MANAGER + " ADD CONSTRAINT dzial_dzial_kierownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT + ")\n" +
                    "REFERENCES " + TABLE_DEPARTMENT + " (" + TABLE_DEPARTMENT_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_WAREHOUSE_DEPARTMENT_FK_DEPARTMENT =
            "ALTER TABLE " + TABLE_WAREHOUSE_DEPARTMENT + " ADD CONSTRAINT dzial_magazyn_dzial_fk\n" +
                    "FOREIGN KEY (" + TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT + ")\n" +
                    "REFERENCES " + TABLE_DEPARTMENT + " (" + TABLE_DEPARTMENT_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    public static final String ALTER_TABLE_WAREHOUSE_DEPARTMENT_FK_WAREHOUSE =
            "ALTER TABLE " + TABLE_WAREHOUSE_DEPARTMENT + " ADD CONSTRAINT magazyn_magazyn_dzial_fk\n" +
                    "FOREIGN KEY (" + TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE + ")\n" +
                    "REFERENCES " + TABLE_WAREHOUSE + " (" + TABLE_WAREHOUSE_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE";

    // ===================== Insert, update, delete... =========================


    // Magazyn
    public static final String INSERT_WAREHOUSE =
            "INSERT INTO " + TABLE_WAREHOUSE + " VALUES (?, ?, ?, ?, ?)";

    public static final String UPDATE_WAREHOUSE =
            "UPDATE " + TABLE_WAREHOUSE + " SET " + TABLE_WAREHOUSE_NAME + " = ?, " + TABLE_WAREHOUSE_STREET + " = ?, " +
            TABLE_WAREHOUSE_CITY + " = ?, " + TABLE_WAREHOUSE_POSTCODE + " = ? WHERE " + TABLE_WAREHOUSE_ID  + " = ?";

    public static final String DELETE_WAREHOUSE =
            "DELETE FROM " + TABLE_WAREHOUSE + " WHERE " + TABLE_WAREHOUSE_ID + " = ?";

    public static final String GET_ALL_WAREHOUSES = "SELECT * FROM " + TABLE_WAREHOUSE;

    //Dzial
    public static final String INSERT_DEPARTMENT =
            "INSERT INTO " + TABLE_DEPARTMENT + " VALUES (?, ?)";

    public static final String DELETE_DEPARTMENT =
            "DELETE FROM " + TABLE_DEPARTMENT + " WHERE " + TABLE_DEPARTMENT_NAME + " LIKE ?";

    public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM " + TABLE_DEPARTMENT;

    //Kierownik
    public static final String INSERT_MANAGER =
            "INSERT INTO " + TABLE_MANAGER + " VALUES (?, ?, ?, ?, ?)";

    public static final String UPDATE_MANAGER =
            "UPDATE " + TABLE_MANAGER + " SET " + TABLE_MANAGER_NAME + " = ?, " + TABLE_MANAGER_SURNAME + " = ?, " +
            TABLE_MANAGER_PHONE + " = ?, " + TABLE_MANAGER_EMAIL + " = ? WHERE " + TABLE_MANAGER_ID + " = ?";

    public static final String DELETE_MANAGER =
            "DELETE FROM " + TABLE_MANAGER + " WHERE " + TABLE_MANAGER_ID + " = ?";

    public static final String GET_ALL_MANAGERS = "SELECT * FROM " + TABLE_MANAGER;

    //Pracownik
    public static final String INSERT_WORKER =
            "INSERT INTO " + TABLE_WORKER + " VALUES (?, ?, ?, ?)";

    public static final String UPDATE_WORKER =
            "UPDATE " + TABLE_WORKER + " SET " + TABLE_WORKER_NAME + " = ?, " + TABLE_WORKER_SURNAME + " = ?, " +
                    TABLE_WORKER_EMAIL + " = ? WHERE " + TABLE_WORKER_ID + " = ?";

    public static final String DELETE_WORKER =
            "DELETE FROM " + TABLE_WORKER + " WHERE " + TABLE_WORKER_ID + " = ?";

    public static final String GET_ALL_WORKERS = "SELECT * FROM " + TABLE_WORKER;

    //Obowiazek
    public static final String INSERT_DUTY =
            "INSERT INTO " + TABLE_DUTIES + " VALUES (?, ?)";

    public static final String DELETE_DUTY =
            "DELETE FROM " + TABLE_DUTIES + " WHERE " + TABLE_DUTIES_ID + " = ?";

    public static final String GET_ALL_DUTIES = "SELECT * FROM " + TABLE_DUTIES;

    //Plany urlopowe
    public static final String INSERT_VACATION =
            "INSERT INTO " + TABLE_VACATION + " VALUES (?, ?, ?)";

    public static final String UPDATE_VACATION =
            "UPDATE " + TABLE_VACATION + " SET " + TABLE_VACATION_BEGINNING + " = ?, " + TABLE_VACATION_END + " = ? WHERE " +
                    TABLE_VACATION_ID + " = ?";

    public static final String DELETE_VACATION =
            "DELETE FROM " + TABLE_VACATION + " WHERE " + TABLE_VACATION_ID + " = ?";

    public static final String GET_ALL_VACATIONS = "SELECT * FROM " + TABLE_VACATION;

    


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
