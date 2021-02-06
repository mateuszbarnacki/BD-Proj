package project.Datamodel;

import project.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String CONNECTION_STRING = "jdbc:postgresql://ziggy.db.elephantsql.com:5432/cefhxaqy";
    public static final String username = "cefhxaqy";
    public static final String password = "vgtlgQPZ-bCZLJeG2t6pRd9HMeO_vr-e";

    //============= Account config ==================
    public static final String TABLE_ACCOUNT = "konto";
    public static final String TABLE_ACCOUNT_NAME = "nazwa_uzytkownika";
    public static final String TABLE_ACCOUNT_LOGIN = "login";
    public static final String TABLE_ACCOUNT_PASSWORD = "password";
    public static final int INDEX_ACCOUNT_NAME = 1;
    public static final int INDEX_ACCOUNT_LOGIN = 2;
    public static final int INDEX_ACCOUNT_PASSWORD = 3;
    // ===========================

    public static final String TABLE_WAREHOUSE = "magazyn";
    public static final String TABLE_WAREHOUSE_ID = "id_magazyn";
    public static final String TABLE_WAREHOUSE_NAME = "nazwa";
    public static final String TABLE_WAREHOUSE_STREET = "ulica";
    public static final String TABLE_WAREHOUSE_CITY = "miasto";
    public static final String TABLE_WAREHOUSE_POSTCODE = "kod_pocztowy";
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
    public static final String TABLE_MANAGER_PHONE = "numer_telefonu";
    public static final String TABLE_MANAGER_EMAIL = "adres_email";
    public static final int INDEX_MANAGER_ID = 1;
    public static final int INDEX_MANAGER_NAME = 2;
    public static final int INDEX_MANAGER_SURNAME = 3;
    public static final int INDEX_MANAGER_PHONE = 4;
    public static final int INDEX_MANAGER_EMAIL = 5;

    public static final String TABLE_WORKER = "pracownik";
    public static final String TABLE_WORKER_ID = "id_pracownik";
    public static final String TABLE_WORKER_NAME = "imie";
    public static final String TABLE_WORKER_SURNAME = "nazwisko";
    public static final String TABLE_WORKER_EMAIL = "adres_email";
    public static final int INDEX_WORKER_ID = 1;
    public static final int INDEX_WORKER_NAME = 2;
    public static final int INDEX_WORKER_SURNAME = 3;
    public static final int INDEX_WORKER_EMAIL = 4;

    public static final String TABLE_DUTIES = "obowiazek";
    public static final String TABLE_DUTIES_ID = "id_obowiazek";
    public static final String TABLE_DUTIES_DESC = "opis";
    public static final int INDEX_DUTIES_ID = 1;
    public static final int INDEX_DUTIES_DESC = 2;

    public static final String TABLE_VACATION = "plany_urlopowe";
    public static final String TABLE_VACATION_ID = "id_plany_urlopowe";
    public static final String TABLE_VACATION_BEGINNING = "data_rozpoczecia";
    public static final String TABLE_VACATION_END = "data_zakonczenia";
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

    //================= Account ======================
    public static final String CREATE_TABLE_ACCOUNT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNT + " (" + TABLE_ACCOUNT_NAME +
            " VARCHAR(50) NOT NULL," + TABLE_ACCOUNT_LOGIN + " VARCHAR(50) NOT NULL, " + TABLE_ACCOUNT_PASSWORD + " VARCHAR(50) NOT NULL)";
    //==================================

    // ===================== Insert, update, delete... =========================

    //Account
    public static final String INSERT_TABLE_ACCOUNT =
            "INSERT INTO " + TABLE_ACCOUNT + " VALUES (?, ?, ?)";

    public static final String DELETE_TABLE_ACCOUNT =
            "DELETE FROM " + TABLE_ACCOUNT + " WHERE " + TABLE_ACCOUNT_NAME + " = ?";

    public static final String UPDATE_TABLE_ACCOUNT =
            "UPDATE " + TABLE_ACCOUNT + " SET " + TABLE_ACCOUNT_LOGIN + " = ?, " + TABLE_ACCOUNT_PASSWORD + " = ? WHERE " +
                    TABLE_ACCOUNT_NAME + " = ?";

    public static final String CHECK_RECORD =
            "SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + TABLE_ACCOUNT_NAME + " = ?";

    public static final String GET_ALL_ACCOUNTS =
            "SELECT * FROM " + TABLE_ACCOUNT;

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

    //Ekspozycja
    public static final String INSERT_EXPOSITION =
            "INSERT INTO " + TABLE_EXPOSITION + " VALUES (?, ?, ?)";

    public static final String UPDATE_EXPOSITION =
            "UPDATE " + TABLE_EXPOSITION + " SET " + TABLE_EXPOSITION_NAME + " = ?, " + TABLE_EXPOSITION_PRICE + " = ? WHERE " +
                    TABLE_EXPOSITION_ID + " = ?";

    public static final String DELETE_EXPOSITION =
            "DELETE FROM " + TABLE_EXPOSITION + " WHERE " + TABLE_EXPOSITION_ID + " = ?";

    public static final String GET_ALL_EXPOSITIONS = "SELECT * FROM " + TABLE_EXPOSITION;

    //Towar
    public static final String INSERT_COMMODITY =
            "INSERT INTO " + TABLE_COMMODITY + " VALUES (?, ?, ?)";

    public static final String UPDATE_COMMODITY =
            "UPDATE " + TABLE_COMMODITY + " SET " + TABLE_COMMODITY_NAME + " = ?, " + TABLE_COMMODITY_PRICE + " = ? WHERE" +
                TABLE_COMMODITY_ID + " = ?";

    public static final String DELETE_COMMODITY =
            "DELETE FROM " + TABLE_COMMODITY + " WHERE " + TABLE_COMMODITY_ID + " = ?";

    public static final String GET_ALL_COMMODITIES = "SELECT * FROM " + TABLE_COMMODITY;

    //Projektant
    public static final String INSERT_DESIGNER =
            "INSERT INTO " + TABLE_DESIGNER + " VALUES (?, ?, ?, ?, ?)";

    public static final String UPDATE_DESIGNER =
            "UPDATE " + TABLE_DESIGNER + " SET " + TABLE_DESIGNER_NAME + " = ?, " + TABLE_DESIGNER_SURNAME + " = ?, " +
                    TABLE_DESIGNER_EMAIL + " = ?, " + TABLE_DESIGNER_PHONE + " = ? WHERE " + TABLE_DESIGNER_ID + " = ?";

    public static final String DELETE_DESIGNER =
            "DELETE FROM " + TABLE_DESIGNER + " WHERE " + TABLE_DESIGNER_ID  + " = ?";

    public static final String GET_ALL_DESIGNERS = "SELECT * FROM " + TABLE_DESIGNER;

    //Opinia
    public static final String INSERT_OPINION =
            "INSERT INTO " + TABLE_OPINION + " VALUES (?, ?)";

    public static final String DELETE_OPINION =
            "DELETE FROM " + TABLE_OPINION + " WHERE " + TABLE_OPINION_ID + " = ?";

    public static final String GET_ALL_OPINIONS = "SELECT * FROM " + TABLE_OPINION;

    //========================== Java code ========================

    private PreparedStatement queryInsertAccount;
    private PreparedStatement queryDeleteAccount;
    private PreparedStatement queryUpdateAccount;
    private PreparedStatement queryCheckUser;

    private Connection connection;
    private final static Datasource instance = new Datasource();

    private Datasource(){}

    public static Datasource getInstance(){
        return instance;
    }

    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING, username, password);

            createAccountTable();

            queryInsertAccount = connection.prepareStatement(INSERT_TABLE_ACCOUNT);
            queryDeleteAccount = connection.prepareStatement(DELETE_TABLE_ACCOUNT);
            queryUpdateAccount = connection.prepareStatement(UPDATE_TABLE_ACCOUNT);
            queryCheckUser = connection.prepareStatement(CHECK_RECORD);

            return true;
        }catch (SQLException e){
            System.out.println("Couldn't open the connection to account database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void openUserEnvironment(){
            createWarehouseTable();
            createDepartmentTable();
            createManagerTable();
            createWorkerTable();
            createDutiesTable();
            createVacationTable();
            createExpositionTable();
            createCommodityTable();
            createDesignerTable();
            createOpinionTable();

            createCommodityOpinionTable();
            createExpositionDesignerTable();
            createExpositionCommodityTable();
            createWorkerDutyTable();
            createWorkerVacationTable();
            createManagerWorkerTable();
            createDepartmentExpositionTable();
            createDepartmentManagerTable();
            createWarehouseDepartmentTable();

            //Foreign keys

            dropTableCommodityOpinionFkOpinion();
            dropTableCommodityOpinionFkCommodity();
            dropTableExpositionDesignerFkDesigner();
            dropTableExpositionDesignerFkExposition();
            dropTableExpositionCommodityFkCommodity();
            dropTableExpositionCommodityFkExposition();
            dropTableDepartmentExpositionFkExposition();
            dropTableDepartmentExpositionFkDepartment();
            dropTableWorkerDutyFkDuty();
            dropTableWorkerDutyFkWorker();
            dropTableWorkerVacationFkVacation();
            dropTableWorkerVacationFkWorker();
            dropTableManagerWorkerFkWorker();
            dropTableManagerWorkerFkManager();
            dropTableDepartmentManagerFkManager();
            dropTableDepartmentManagerFkDepartment();
            dropTableWarehouseDepartmentFkDepartment();
            dropTableWarehouseDepartmentFkWarehouse();

            alterTableCommodityOpinionFkOpinion();
            alterTableCommodityOpinionFkCommodity();
            alterTableExpositionDesignerFkDesigner();
            alterTableExpositionDesignerFkExposition();
            alterTableExpositionCommodityFkCommodity();
            alterTableExpositionCommodityFkExposition();
            alterTableDepartmentExpositionFkExposition();
            alterTableDepartmentExpositionFkDepartment();
            alterTableWorkerDutyFkDuty();
            alterTableWorkerDutyFkWorker();
            alterTableWorkerVacationFkVacation();
            alterTableWorkerVacationFkWorker();
            alterTableManagerWorkerFkWorker();
            alterTableManagerWorkerFkManager();
            alterTableDepartmentManagerFkManager();
            alterTableDepartmentManagerFkDepartment();
            alterTableWarehouseDepartmentFkDepartment();
            alterTableWarehouseDepartmentFkWarehouse();

            //Functions and triggers

            createCheckPostcodeFunction();
            dropCheckPostcodeWarehouseTrigger();
            createCheckPostcodeWarehouseTrigger();

            createCheckPhoneNumberFunction();
            dropCheckPhoneNumberManagerTrigger();
            createCheckPhoneNumberManagerTrigger();
            dropCheckPhoneNumberDesignerTrigger();
            createCheckPhoneNumberDesignerTrigger();

            createCheckEmailFunction();
            dropCheckEmailManagerTrigger();
            createCheckEmailManagerTrigger();
            dropCheckEmailWorkerTrigger();
            createCheckEmailWorkerTrigger();
            dropCheckEmailDesignerTrigger();
            createCheckEmailDesignerTrigger();

            createCheckNamesFunction();
            dropCheckNamesManagerTrigger();
            createCheckNamesManagerTrigger();
            dropCheckNamesWorkerTrigger();
            createCheckNamesWorkerTrigger();
            dropCheckNamesDesignerTrigger();
            createCheckNamesDesignerTrigger();

            createNormalizeNamesFunction();
            dropNormalizeNamesManagerTrigger();
            createNormalizeNamesManagerTrigger();
            dropNormalizeNamesWorkerTrigger();
            createNormalizeNamesWorkerTrigger();
            dropNormalizeNamesDesignerTrigger();
            createNormalizeNamesDesignerTrigger();
    }

    public boolean close(){
        try{
            if(queryCheckUser != null){
                queryCheckUser.close();
            }
            if(queryUpdateAccount != null){
                queryUpdateAccount.close();
            }
            if(queryDeleteAccount != null){
                queryDeleteAccount.close();
            }
            if(queryInsertAccount!= null){
                queryInsertAccount.close();
            }
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

    //====================== Schema =============================

    /*public void test(){
        System.out.println(CREATE_SCHEMA);
    }*/

    public boolean createSchema(){
        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE SCHEMA IF NOT EXISTS " + Session.getInstance().getToken());

            return true;
        } catch(SQLException e){
            System.out.println("Couldn't create schema for user " + Session.getInstance().getToken() + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean dropSchema(String username){
        try (Statement statement = connection.createStatement()){
            statement.execute( "DROP SCHEMA " + username + " CASCADE");

            return true;
        } catch (SQLException e){
            System.out.println("Couldn't drop schema for user " + username + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    //======================= Postgres functions and triggers ================================

    private void createCheckPostcodeFunction(){
        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE OR REPLACE FUNCTION checkPostcode()\n" +
                    "\tRETURNS TRIGGER\n" +
                    "    LANGUAGE plpgsql\n" +
                    "    AS $$\n" +
                    "    DECLARE size varchar;\n" +
                    "    BEGIN\n" +
                    "    \tsize = regexp_matches(NEW.kod_pocztowy, '^\\d{2}-\\d{3}$');\n" +
                    "        IF size IS NULL OR length(size) != 8 THEN\n" +
                    "        \tRAISE EXCEPTION 'Niepoprawny kod pocztowy!';\n" +
                    "        END IF;\n" +
                    "    RETURN NEW;\n" +
                    "    END;\n" +
                    "    $$;");
        } catch (SQLException e){
            System.out.println("Couldn't create checkPostcode function: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckPostcodeWarehouseTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_WAREHOUSE + "Postcodes\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE +
                    "    FOR EACH ROW EXECUTE PROCEDURE checkPostcode();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check postcode warehouse trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckPostcodeWarehouseTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_WAREHOUSE + "Postcodes ON " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE);
        } catch (SQLException e) {
            System.out.println("Couldn't drop check postcode warehouse trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckPhoneNumberFunction(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE OR REPLACE FUNCTION checkPhoneNumber()\n" +
                    "\tRETURNS TRIGGER\n" +
                    "    LANGUAGE plpgsql\n" +
                    "    AS $$\n" +
                    "    DECLARE res varchar;\n" +
                    "    BEGIN\n" +
                    "    \tres = regexp_matches(NEW.numer_telefonu, '^\\d{9}$');\n" +
                    "        IF res IS NULL OR length(res) != 11 THEN\n" +
                    "        \tRAISE EXCEPTION 'Niepoprawny numer telefonu!';\n" +
                    "        END IF;\n" +
                    "    \tRETURN NEW;\n" +
                    "    END;\n" +
                    "    $$;");
        } catch (SQLException e){
            System.out.println("Couldn't create checkPhoneNumber function: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckPhoneNumberManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_MANAGER + "PhoneNumber\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER +
                    "    FOR EACH ROW EXECUTE PROCEDURE checkPhoneNumber();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check manager phone number trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckPhoneNumberManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_MANAGER + "PhoneNumber ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check manager phone number trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckPhoneNumberDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_DESIGNER + "PhoneNumber\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER +
                    "    FOR EACH ROW EXECUTE PROCEDURE checkPhoneNumber();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check designer phone number trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckPhoneNumberDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_DESIGNER + "PhoneNumber ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check designer phone number trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckEmailFunction(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE OR REPLACE FUNCTION checkEmail()\n" +
                    "\tRETURNS TRIGGER\n" +
                    "    LANGUAGE plpgsql\n" +
                    "    AS $$\n" +
                    "    DECLARE res varchar;\n" +
                    "    BEGIN\n" +
                    "    \tres = regexp_matches(NEW.adres_email, '^\\S+@\\S+\\.{1}\\S+$');\n" +
                    "\t\tIF res IS NULL THEN\n" +
                    "        \tRAISE EXCEPTION 'Niepoprawny adres email!';\n" +
                    "    \tEND IF;\n" +
                    "        RETURN NEW;\n" +
                    "    END;\n" +
                    "    $$;");
        } catch (SQLException e) {
            System.out.println("Couldn't create checkEmail function: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckEmailManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_MANAGER + "Email\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER +
                    "    FOR EACH ROW EXECUTE PROCEDURE checkEmail();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check manager email trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckEmailManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_MANAGER + "Email ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check manager email trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckEmailWorkerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_WORKER + "Email\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_WORKER +
                    "    FOR EACH ROW EXECUTE PROCEDURE checkEmail();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check worker email trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckEmailWorkerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_WORKER + "Email ON " + Session.getInstance().getToken() + "." + TABLE_WORKER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check worker email trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckEmailDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_DESIGNER + "Email\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER +
                    "    FOR EACH ROW EXECUTE PROCEDURE checkEmail();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check designer email trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckEmailDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_DESIGNER + "Email ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check designer email trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckNamesFunction(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE OR REPLACE FUNCTION checkNames ()\n" +
                    "\tRETURNS TRIGGER\n" +
                    "    LANGUAGE plpgsql\n" +
                    "    AS $$\n" +
                    "    DECLARE spacePosition integer;\n" +
                    "    \t\ttabPosition integer;\n" +
                    "            newLinePosition integer;\n" +
                    "            numberRegex varchar;\n" +
                    "    BEGIN\n" +
                    "\n" +
                    "\tspacePosition = strpos(NEW.imie, chr(9));\n" +
                    "\ttabPosition = strpos(NEW.imie, chr(10));\n" +
                    "\tnewLinePosition = strpos(NEW.imie, chr(32));\n" +
                    "\tnumberRegex = regexp_matches(NEW.imie, '[0-9]');\n" +
                    "\n" +
                    "\tIF spacePosition > 0 THEN\n" +
                    "    \t RAISE EXCEPTION 'Niepoprawna wartość pola imie: wprowadzenie tabulacji.';\n" +
                    "    ELSIF tabPosition > 0  THEN\n" +
                    "    \tRAISE EXCEPTION 'Niepoprawna wartość pola imie: wprowadzenie nowej linii.';\n" +
                    "    ELSEIF newLinePosition > 0 THEN\n" +
                    "    \tRAISE EXCEPTION 'Niepoprawna wartość pola imie: wprowadzenie spacji.';\n" +
                    "    ELSEIF length(numberRegex) > 0 THEN\n" +
                    "    \tRAISE EXCEPTION 'Niepoprawna wartość pola imie: wprowadzenie cyfr.';\n" +
                    "    END IF;\n" +
                    "\n" +
                    "    spacePosition = strpos(NEW.nazwisko, chr(9));\n" +
                    "\ttabPosition = strpos(NEW.nazwisko, chr(10));\n" +
                    "\tnewLinePosition = strpos(NEW.nazwisko, chr(32));\n" +
                    "    numberRegex = regexp_matches(NEW.nazwisko, '[0-9]');\n" +
                    "\n" +
                    "   \tIF spacePosition > 0 THEN\n" +
                    "    \t RAISE EXCEPTION 'Niepoprawna wartość pola nazwisko: wprowadzenie tabulacji.';\n" +
                    "    ELSIF tabPosition > 0  THEN\n" +
                    "    \tRAISE EXCEPTION 'Niepoprawna wartość pola nazwisko: wprowadzenie nowej linii.';\n" +
                    "    ELSEIF newLinePosition > 0 THEN\n" +
                    "    \tRAISE EXCEPTION 'Niepoprawna wartość pola nazwisko: wprowadzenie spacji.';\n" +
                    "    ELSEIF length(numberRegex) > 0 THEN\n" +
                    "    \tRAISE EXCEPTION 'Niepoprawna wartość pola nazwisko: wprowadzenie cyfr.';\n" +
                    "    END IF;\n" +
                    "\n" +
                    "    RETURN NEW;\n" +
                    "    END;\n" +
                    "    $$;");
        } catch (SQLException e) {
            System.out.println("Couldn't create checkNames function: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckNamesManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_MANAGER +"NameAndSurname\n" +
                    "\t\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER +
                    "    \tFOR EACH ROW EXECUTE PROCEDURE checkNames();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check manager name and surname trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckNamesManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_MANAGER + "NameAndSurname ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check manager name and surname trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckNamesWorkerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_WORKER + "NameAndSurname\n" +
                    "\t\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_WORKER +
                    "    \tFOR EACH ROW EXECUTE PROCEDURE checkNames();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check worker name and surname trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckNamesWorkerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_WORKER + "NameAndSurname ON " + Session.getInstance().getToken() + "." + TABLE_WORKER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check worker name and surname trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckNamesDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER check" + TABLE_DESIGNER + "NameAndSurname\n" +
                    "\t\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER +
                    "    \tFOR EACH ROW EXECUTE PROCEDURE checkNames();");
        } catch (SQLException e) {
            System.out.println("Couldn't create check designer name and surname trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropCheckNamesDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS check" + TABLE_DESIGNER + "NameAndSurname ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop check designer name and surname trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createNormalizeNamesFunction() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE OR REPLACE FUNCTION normalizeNames () RETURNS TRIGGER AS $$\n" +
                    "\tDECLARE var varchar;\n" +
                    "BEGIN\n" +
                    "\tNEW.imie := upper(NEW.imie);\n" +
                    "    NEW.nazwisko := upper(NEW.nazwisko);\n" +
                    "    var := SUBSTRING(NEW.imie, 2, length(NEW.imie));\n" +
                    "    NEW.imie := SUBSTRING(NEW.imie, 1, 1) || lower(var);\n" +
                    "    var := SUBSTRING(NEW.nazwisko, 2, length(NEW.nazwisko));\n" +
                    "    NEW.nazwisko := SUBSTRING(NEW.nazwisko, 1, 1) || lower(var);\n" +
                    "    RETURN NEW;\n" +
                    "END;\n" +
                    "$$ LANGUAGE 'plpgsql';");
        } catch (SQLException e) {
            System.out.println("Couldn't create normalizeNames function: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createNormalizeNamesManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER normalize" + TABLE_MANAGER + "Name\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER +
                    "    FOR EACH ROW\n" +
                    "    EXECUTE PROCEDURE normalizeNames ();");
        } catch (SQLException e) {
            System.out.println("Couldn't create normalize manager name trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropNormalizeNamesManagerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS normalize" + TABLE_MANAGER + "Name ON " + Session.getInstance().getToken() + "." + TABLE_MANAGER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop normalize manager name trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createNormalizeNamesWorkerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER normalize" + TABLE_WORKER + "Name\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_WORKER +
                    "    FOR EACH ROW\n" +
                    "    EXECUTE PROCEDURE normalizeNames ();");
        } catch (SQLException e) {
            System.out.println("Couldn't create normalize worker name trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropNormalizeNamesWorkerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS normalize" + TABLE_WORKER + "Name ON " + Session.getInstance().getToken() + "." + TABLE_WORKER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop normalize worker name trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createNormalizeNamesDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TRIGGER normalize" + TABLE_DESIGNER + "Name\n" +
                    "\tBEFORE INSERT OR UPDATE ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER +
                    "    FOR EACH ROW\n" +
                    "    EXECUTE PROCEDURE normalizeNames ();");
        } catch (SQLException e) {
            System.out.println("Couldn't create normalize designer name trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropNormalizeNamesDesignerTrigger(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TRIGGER IF EXISTS normalize" + TABLE_DESIGNER + "Name ON " + Session.getInstance().getToken() + "." + TABLE_DESIGNER );
        } catch (SQLException e) {
            System.out.println("Couldn't drop normalize designer name trigger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //====================== Funkcje pomocnicze ===========================

    private int findLowestFreeId(String table) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id_" + table + " FROM " + Session.getInstance().getToken() + "." + table)) {
            int counter = 1;
            int temp = 0;
            while (resultSet.next()) {
                temp = resultSet.getInt(1);
                if(counter != temp){
                    break;
                } else {
                    counter++;
                }
            }
            return counter;
        } catch (SQLException e) {
            System.out.println("Couldn't find lowest id number: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    //====================== Account ============================

    private void createAccountTable(){
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_ACCOUNT);
        } catch(SQLException e) {
            System.out.println("Couldn't create table " + TABLE_ACCOUNT + ": " + e.getMessage());
        }
    }

    public boolean insertAccount(Account data){
        try{
            queryInsertAccount.setString(INDEX_ACCOUNT_NAME, data.getUsername());
            queryInsertAccount.setString(INDEX_ACCOUNT_LOGIN, data.getLogin());
            queryInsertAccount.setString(INDEX_ACCOUNT_PASSWORD, data.getPassword());
            int affectedRows = queryInsertAccount.executeUpdate();

            return affectedRows == 1;
        } catch(SQLException e) {
            System.out.println("Couldn't insert data to " + TABLE_ACCOUNT + " table: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(String... data){
        try{
            queryUpdateAccount.setString(1, data[0]);
            queryUpdateAccount.setString(2, data[1]);
            queryUpdateAccount.setString(3, data[2]);
            int affectedRows = queryUpdateAccount.executeUpdate();

            return affectedRows == 1;
        } catch(SQLException e) {
            System.out.println("Couldn't update username to " + TABLE_ACCOUNT + " table: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAccount(String username){
        try{
            queryDeleteAccount.setString(INDEX_ACCOUNT_NAME, username);
            int affectedRows = queryDeleteAccount.executeUpdate();

            return affectedRows == 1;
        } catch (SQLException e) {
            System.out.println("Couldn't delete record in " + TABLE_ACCOUNT + " table: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(GET_ALL_ACCOUNTS);
            while(resultSet.next()){
                String userName = resultSet.getString(INDEX_ACCOUNT_NAME);
                String login = resultSet.getString(INDEX_ACCOUNT_LOGIN);
                String password = resultSet.getString(INDEX_ACCOUNT_PASSWORD);

                Account temp = new Account(userName, login, password);
                accounts.add(temp);
            }
            resultSet.close();
            return accounts;
        }catch (SQLException e){
            System.out.println("Couldn't get all accounts!");
            e.printStackTrace();
            return null;
        }
    }

    public Account isRecordExists(String username){
        Account account = null;
        try{
            queryCheckUser.setString(INDEX_ACCOUNT_NAME, username);
            ResultSet resultSet = queryCheckUser.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString(INDEX_ACCOUNT_NAME);
                String login = resultSet.getString(INDEX_ACCOUNT_LOGIN);
                String password = resultSet.getString(INDEX_ACCOUNT_PASSWORD);
                Account temp = new Account(name, login, password);
                account = temp;
            }
            resultSet.close();
            return account;
        } catch(SQLException e) {
            System.out.println("Couldn't query the " + TABLE_ACCOUNT + " table: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //========================================= Warehouse methods =================================

    private void createWarehouseTable(){
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE + " (" + TABLE_WAREHOUSE_ID + " INTEGER NOT NULL, " + TABLE_WAREHOUSE_NAME +
                    " VARCHAR(25) NOT NULL, " + TABLE_WAREHOUSE_STREET + " VARCHAR(25) NOT NULL, " +
                    TABLE_WAREHOUSE_CITY + " VARCHAR(25) NOT NULL, " + TABLE_WAREHOUSE_POSTCODE + " VARCHAR(6) NOT NULL, CONSTRAINT id_magazyn PRIMARY KEY (" + TABLE_WAREHOUSE_ID + "))");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_WAREHOUSE + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean isWarehouseExists(){
        try (Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT COUNT(*) AS count FROM " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE)){
            results.next();
            int response = results.getInt("count");

            return response == 1;
        } catch (SQLException e){
            System.out.println("Couldn't get number of rows in " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE + " table: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertWarehouse(Warehouse data) throws SQLException{
        Statement statement = connection.createStatement();
        int id = findLowestFreeId(TABLE_WAREHOUSE);
        int affectedRows = statement.executeUpdate("INSERT INTO " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE +
                    " (" + TABLE_WAREHOUSE_ID + ", " + TABLE_WAREHOUSE_NAME + ", " + TABLE_WAREHOUSE_STREET + ", " + TABLE_WAREHOUSE_CITY + ", " + TABLE_WAREHOUSE_POSTCODE + ")" +
                    " VALUES (" + id + ", \'" + data.getName() + "\', \'" + data.getStreet() + "\', \'" + data.getCity() + "\', \'" + data.getPostcode() + "\')");
        statement.close();
        return affectedRows == 1;
    }

    public boolean updateWarehouse(Warehouse data) throws SQLException{
        Statement statement = connection.createStatement();
        int affectedRows = statement.executeUpdate( "UPDATE " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE + " SET " + TABLE_WAREHOUSE_NAME + " = \'" + data.getName() + "\', " +
                    TABLE_WAREHOUSE_STREET + " = \'" + data.getStreet() + "\', " + TABLE_WAREHOUSE_CITY + " = \'" + data.getCity() + "\', " +
                    TABLE_WAREHOUSE_POSTCODE + " = \'" + data.getPostcode() + "\' WHERE " + TABLE_WAREHOUSE_ID  + " = 1" );
        statement.close();
        return affectedRows == 1;
    }

    public Warehouse getWarehouseData() {
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE)) {
            Warehouse warehouse = null;
            while (resultSet.next()){
                String name = resultSet.getString(INDEX_WAREHOUSE_NAME);
                String street = resultSet.getString(INDEX_WAREHOUSE_STREET);
                String city = resultSet.getString(INDEX_WAREHOUSE_CITY);
                String postcode = resultSet.getString(INDEX_WAREHOUSE_POSTCODE);
                warehouse = new Warehouse(name, street, city, postcode);
            }

            return warehouse;
        } catch (SQLException e) {
            System.out.println("Couldn't get " + TABLE_WAREHOUSE + " data: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //================================== Department Methods ===========================

    private void createDepartmentTable(){
        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT + " (\n" +
                    TABLE_DEPARTMENT_ID +" INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_NAME + " VARCHAR(25) NOT NULL,\n" +
                    " CONSTRAINT id_dzial PRIMARY KEY (" + TABLE_DEPARTMENT_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_DEPARTMENT + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean insertDepartment(String name) {
        try (Statement statement = connection.createStatement()) {
            int id = findLowestFreeId(TABLE_DEPARTMENT);
            int affectedRows = statement.executeUpdate("INSERT INTO " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT
                                + " VALUES (" + id + ", \'" + name + "\')");

            return affectedRows == 1;
        } catch (SQLException e) {
            System.out.println("Couldn't insert to " + TABLE_DEPARTMENT + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Department> getDepartments() {
        List<Department> list = new ArrayList<>();

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT)) {

            while (resultSet.next()) {
                int id = resultSet.getInt(INDEX_DEPARTMENT_ID);
                String name = resultSet.getString(INDEX_DEPARTMENT_NAME);
                Department department = new Department(id, name);
                list.add(department);
            }
            if(list.size() == 0) list = null;

            return list;
        } catch (SQLException e) {
            System.out.println("Couldn't get departments from the database: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //================================== Manager Methods ============================

    private void createManagerTable(){
        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_MANAGER + " (\n" +
                    TABLE_MANAGER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_MANAGER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_MANAGER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_MANAGER_PHONE + " VARCHAR(9),\n" +
                    TABLE_MANAGER_EMAIL + " VARCHAR(30),\n" +
                    " CONSTRAINT id_kierownik PRIMARY KEY (" + TABLE_MANAGER_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_MANAGER + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //================================ Worker Methods ========================

    private void createWorkerTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_WORKER + " (\n" +
                    TABLE_WORKER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_WORKER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_WORKER_EMAIL + " VARCHAR(30),\n" +
                    " CONSTRAINT id_pracownik PRIMARY KEY (" + TABLE_WORKER_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_WORKER + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //=============================== Duties Methods ==========================

    private void createDutiesTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_DUTIES + " (\n" +
                    TABLE_DUTIES_ID + " INTEGER NOT NULL,\n" +
                    TABLE_DUTIES_DESC + " VARCHAR(30) NOT NULL,\n" +
                    " CONSTRAINT id_obowiazek PRIMARY KEY (" + TABLE_DUTIES_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_DUTIES + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //=============================== Vacation Methods ==========================

    private void createVacationTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_VACATION + " (\n" +
                    TABLE_VACATION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_VACATION_BEGINNING + " DATE NOT NULL,\n" +
                    TABLE_VACATION_END + " DATE NOT NULL,\n" +
                    " CONSTRAINT id_urlop PRIMARY KEY (" + TABLE_VACATION_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_VACATION + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //============================== Exposition Methods ==========================

    private void createExpositionTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION + " (\n" +
                    TABLE_EXPOSITION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_EXPOSITION_PRICE + " DOUBLE PRECISION DEFAULT 0.0 NOT NULL,\n" +
                    " CONSTRAINT id_ekspozycja PRIMARY KEY (" + TABLE_EXPOSITION_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_EXPOSITION + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //=========================== Commodity Methods =================================

    private void createCommodityTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_COMMODITY + " (\n" +
                    TABLE_COMMODITY_ID + " INTEGER NOT NULL,\n" +
                    TABLE_COMMODITY_NAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_COMMODITY_PRICE + " DOUBLE PRECISION DEFAULT 0.0 NOT NULL,\n" +
                    " CONSTRAINT id_towar PRIMARY KEY (" + TABLE_COMMODITY_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_COMMODITY + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //============================ Designer Methods ==============================

    private void createDesignerTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(  "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_DESIGNER + " (\n" +
                    TABLE_DESIGNER_ID + " INTEGER NOT NULL,\n" +
                    TABLE_DESIGNER_NAME + " VARCHAR(20) NOT NULL,\n" +
                    TABLE_DESIGNER_SURNAME + " VARCHAR(30) NOT NULL,\n" +
                    TABLE_DESIGNER_EMAIL + " VARCHAR(30),\n" +
                    TABLE_DESIGNER_PHONE + " VARCHAR(9),\n" +
                    " CONSTRAINT id_projektant PRIMARY KEY (" + TABLE_DESIGNER_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_DESIGNER + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //=========================== Opinion Methods =========================

    private void createOpinionTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(   "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_OPINION + " (\n" +
                    TABLE_OPINION_ID + " INTEGER NOT NULL,\n" +
                    TABLE_OPINION_DESC + " VARCHAR(50) NOT NULL,\n" +
                    " CONSTRAINT id_opinia PRIMARY KEY (" + TABLE_OPINION_ID + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_OPINION + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ============================== COMMODITY_OPINION_TABLE ================

    private void createCommodityOpinionTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(    "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_COMMODITY_OPINION + " (\n" +
                    TABLE_COMMODITY_OPINION_ID_COMMODITY + " INTEGER NOT NULL,\n" +
                    TABLE_COMMODITY_OPINION_ID_OPINION + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT towar_opinia_pk PRIMARY KEY (" + TABLE_COMMODITY_OPINION_ID_COMMODITY + ", " + TABLE_COMMODITY_OPINION_ID_OPINION + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_COMMODITY_OPINION + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //================================= EXPOSITION_DESIGNER_TABLE ====================

    private void createExpositionDesignerTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_DESIGNER + " (\n" +
                    TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_DESIGNER_ID_DESIGNER + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT ekspozycja_projektant_pk PRIMARY KEY (" + TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION + ", " + TABLE_EXPOSITION_DESIGNER_ID_DESIGNER + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_EXPOSITION_DESIGNER + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //================================== EXPOSITION_COMMODITY_TABLE =====================

    private void createExpositionCommodityTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_COMMODITY + " (\n" +
                    TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION + " INTEGER NOT NULL,\n" +
                    TABLE_EXPOSITION_COMMODITY_ID_COMMODITY + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT ekspozycja_towar_pk PRIMARY KEY (" + TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION + ", " + TABLE_EXPOSITION_COMMODITY_ID_COMMODITY + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_EXPOSITION_COMMODITY + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //=============================== WORKER_DUTY_TABLE =============================

    private void createWorkerDutyTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(  "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_WORKER_DUTY + " (\n" +
                    TABLE_WORKER_DUTY_ID_WORKER + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_DUTY_ID_DUTY + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT pracownik_obowiazek_pk PRIMARY KEY (" + TABLE_WORKER_DUTY_ID_WORKER + ", " + TABLE_WORKER_DUTY_ID_DUTY + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_WORKER_DUTY + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //=================================== WORKER_VACATION_TABLE ============================

    private void createWorkerVacationTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(  "CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_WORKER_VACATION + " (\n" +
                    TABLE_WORKER_VACATION_ID_WORKER + " INTEGER NOT NULL,\n" +
                    TABLE_WORKER_VACATION_ID_VACATION + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT pracownik_plan_pk PRIMARY KEY (" + TABLE_WORKER_VACATION_ID_WORKER + ", " + TABLE_WORKER_VACATION_ID_VACATION + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_WORKER_VACATION + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //======================================== MANAGER_WORKER_TABLE ================================

    private void createManagerWorkerTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(  "CREATE TABLE IF NOT EXISTS " +  Session.getInstance().getToken() + "." + TABLE_MANAGER_WORKER + " (\n" +
                    TABLE_MANAGER_WORKER_ID_MANAGER + " INTEGER NOT NULL,\n" +
                    TABLE_MANAGER_WORKER_ID_WORKER + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT kierownik_pracownik_pk PRIMARY KEY (" + TABLE_MANAGER_WORKER_ID_MANAGER + ", " + TABLE_MANAGER_WORKER_ID_WORKER + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_MANAGER_WORKER + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //====================================== DEPARTMENT_EXPOSITION_TABLE ===========================

    private void createDepartmentExpositionTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_EXPOSITION + " (\n" +
                    TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT + " INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT dzial_ekspozycja_pk PRIMARY KEY (" + TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT + ", " + TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_DEPARTMENT_EXPOSITION + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //======================================= DEPARTMENT_MANAGER_TABLE ================================

    private void createDepartmentManagerTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_MANAGER + " (\n" +
                    TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT + " INTEGER NOT NULL,\n" +
                    TABLE_DEPARTMENT_MANAGER_ID_MANAGER + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT dzial_kierownik_pk PRIMARY KEY (" + TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT + ", " + TABLE_DEPARTMENT_MANAGER_ID_MANAGER + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_DEPARTMENT_MANAGER + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //======================================== WAREHOUSE_DEPARTMENT_TABLE =====================

    private void createWarehouseDepartmentTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE_DEPARTMENT + " (\n" +
                    TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE + " INTEGER NOT NULL,\n" +
                    TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT + " INTEGER NOT NULL,\n" +
                    " CONSTRAINT magazyn_dzial_pk PRIMARY KEY (" + TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE + ", " + TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT + ")\n" +
                    ")");
        }catch(SQLException e){
            System.out.println("Couldn't create " + TABLE_WAREHOUSE_DEPARTMENT + " table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //====================================== Add foreign keys =====================

    private void alterTableCommodityOpinionFkOpinion(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_COMMODITY_OPINION + " ADD CONSTRAINT opinia_towar_opinia_fk\n" +
                    "FOREIGN KEY (" + TABLE_COMMODITY_OPINION_ID_OPINION + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_OPINION + " (" + TABLE_OPINION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table commodity-opinion fkOpinion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableCommodityOpinionFkOpinion(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_COMMODITY_OPINION + " DROP CONSTRAINT IF EXISTS opinia_towar_opinia_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table commodity-opinion fkOpinion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableCommodityOpinionFkCommodity(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_COMMODITY_OPINION + " ADD CONSTRAINT towar_towar_opinia_fk\n" +
                    "FOREIGN KEY (" + TABLE_COMMODITY_OPINION_ID_COMMODITY + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_COMMODITY + " (" + TABLE_COMMODITY_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table commodity-opinion fkCommodity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableCommodityOpinionFkCommodity(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_COMMODITY_OPINION + " DROP CONSTRAINT IF EXISTS towar_towar_opinia_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table commodity-opinion fkCommodity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableExpositionDesignerFkDesigner(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_DESIGNER + " ADD CONSTRAINT projektant_ekspozycja_projektant_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_DESIGNER_ID_DESIGNER + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_DESIGNER + " (" + TABLE_DESIGNER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-designer fkDesigner: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableExpositionDesignerFkDesigner(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_DESIGNER + " DROP CONSTRAINT IF EXISTS projektant_ekspozycja_projektant_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-designer fkDesigner: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableExpositionDesignerFkExposition(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_DESIGNER + " ADD CONSTRAINT ekspozycja_ekspozycja_projektant_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_DESIGNER_ID_EXPOSITION + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." +  TABLE_EXPOSITION + " (" + TABLE_EXPOSITION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-designer fkExposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableExpositionDesignerFkExposition(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_DESIGNER + " DROP CONSTRAINT IF EXISTS ekspozycja_ekspozycja_projektant_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-designer fkExposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableExpositionCommodityFkCommodity(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_COMMODITY + " ADD CONSTRAINT towar_ekspozycja_towar_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_COMMODITY_ID_COMMODITY + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_COMMODITY + " (" + TABLE_COMMODITY_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-commodity fkCommodity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableExpositionCommodityFkCommodity(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_COMMODITY + " DROP CONSTRAINT IF EXISTS towar_ekspozycja_towar_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-commodity fkCommodity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableExpositionCommodityFkExposition(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_COMMODITY + " ADD CONSTRAINT ekspozycja_ekspozycja_towar_fk\n" +
                    "FOREIGN KEY (" + TABLE_EXPOSITION_COMMODITY_ID_EXPOSITION + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION + " (" + TABLE_EXPOSITION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-commodity fkExposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableExpositionCommodityFkExposition(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION_COMMODITY + " DROP CONSTRAINT IF EXISTS ekspozycja_ekspozycja_towar_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table exposition-commodity fkExposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableDepartmentExpositionFkExposition(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_EXPOSITION + " ADD CONSTRAINT ekspozycja_dzial_ekspozycja_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_EXPOSITION_ID_EXPOSITION + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_EXPOSITION + " (" + TABLE_EXPOSITION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-exposition fkExposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableDepartmentExpositionFkExposition(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_EXPOSITION + " DROP CONSTRAINT IF EXISTS ekspozycja_dzial_ekspozycja_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-exposition fkExposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableDepartmentExpositionFkDepartment(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_EXPOSITION + " ADD CONSTRAINT dzial_dzial_ekspozycja_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_EXPOSITION_ID_DEPARTMENT + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT + " (" + TABLE_DEPARTMENT_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-exposition fkDepartment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableDepartmentExpositionFkDepartment(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_EXPOSITION + " DROP CONSTRAINT IF EXISTS dzial_dzial_ekspozycja_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-exposition fkDepartment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableWorkerDutyFkDuty(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_DUTY + " ADD CONSTRAINT obowiazek_pracownik_obowiazek_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_DUTY_ID_DUTY + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." +  TABLE_DUTIES + " (" + TABLE_DUTIES_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-duty fkDuty: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableWorkerDutyFkDuty(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_DUTY + " DROP CONSTRAINT IF EXISTS obowiazek_pracownik_obowiazek_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-duty fkDuty: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableWorkerDutyFkWorker(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_DUTY + " ADD CONSTRAINT pracownik_pracownik_obowiazek_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_DUTY_ID_WORKER + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." +  TABLE_WORKER + " (" + TABLE_WORKER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-duty fkWorker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableWorkerDutyFkWorker(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_DUTY + " DROP CONSTRAINT IF EXISTS pracownik_pracownik_obowiazek_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-duty fkWorker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableWorkerVacationFkVacation(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_VACATION + " ADD CONSTRAINT plany_urlopowe_pracownik_plan_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_VACATION_ID_VACATION + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_VACATION + " (" + TABLE_VACATION_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-vacation fkVacation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableWorkerVacationFkVacation(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_VACATION + " DROP CONSTRAINT IF EXISTS plany_urlopowe_pracownik_plan_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-vacation fkVacation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableWorkerVacationFkWorker(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_VACATION + " ADD CONSTRAINT pracownik_pracownik_plan_fk\n" +
                    "FOREIGN KEY (" + TABLE_WORKER_VACATION_ID_WORKER + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_WORKER + " (" + TABLE_WORKER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-vacation fkWorker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableWorkerVacationFkWorker(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WORKER_VACATION + " DROP CONSTRAINT IF EXISTS pracownik_pracownik_plan_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table worker-vacation fkWorker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableManagerWorkerFkWorker(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_MANAGER_WORKER + " ADD CONSTRAINT pracownik_kierownik_pracownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_MANAGER_WORKER_ID_WORKER + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_WORKER + " (" + TABLE_WORKER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table manager-worker fkWorker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableManagerWorkerFkWorker(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_MANAGER_WORKER + " DROP CONSTRAINT IF EXISTS pracownik_kierownik_pracownik_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table manager-worker fkWorker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableManagerWorkerFkManager(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_MANAGER_WORKER + " ADD CONSTRAINT kierownik_kierownik_pracownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_MANAGER_WORKER_ID_MANAGER + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_MANAGER + " (" + TABLE_MANAGER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table manager-worker fkManager: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableManagerWorkerFkManager(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_MANAGER_WORKER + " DROP CONSTRAINT IF EXISTS kierownik_kierownik_pracownik_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table manager-worker fkManager: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableDepartmentManagerFkManager(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_MANAGER + " ADD CONSTRAINT kierownik_dzial_kierownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_MANAGER_ID_MANAGER + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_MANAGER + " (" + TABLE_MANAGER_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-manager fkManager: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableDepartmentManagerFkManager(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_MANAGER + " DROP CONSTRAINT IF EXISTS kierownik_dzial_kierownik_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-manager fkManager: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableDepartmentManagerFkDepartment(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_MANAGER + " ADD CONSTRAINT dzial_dzial_kierownik_fk\n" +
                    "FOREIGN KEY (" + TABLE_DEPARTMENT_MANAGER_ID_DEPARTMENT + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT + " (" + TABLE_DEPARTMENT_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-manager fkDepartment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableDepartmentManagerFkDepartment(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT_MANAGER + " DROP CONSTRAINT IF EXISTS dzial_dzial_kierownik_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table department-manager fkDepartment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableWarehouseDepartmentFkDepartment(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE_DEPARTMENT + " ADD CONSTRAINT dzial_magazyn_dzial_fk\n" +
                    "FOREIGN KEY (" + TABLE_WAREHOUSE_DEPARTMENT_ID_DEPARTMENT + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_DEPARTMENT + " (" + TABLE_DEPARTMENT_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table warehouse-department fkDepartment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableWarehouseDepartmentFkDepartment(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE_DEPARTMENT + " DROP CONSTRAINT IF EXISTS dzial_magazyn_dzial_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table warehouse-department fkDepartment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void alterTableWarehouseDepartmentFkWarehouse(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE_DEPARTMENT + " ADD CONSTRAINT magazyn_magazyn_dzial_fk\n" +
                    "FOREIGN KEY (" + TABLE_WAREHOUSE_DEPARTMENT_ID_WAREHOUSE + ")\n" +
                    "REFERENCES " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE + " (" + TABLE_WAREHOUSE_ID + ")\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    "NOT DEFERRABLE");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table warehouse-department fkWarehouse: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void dropTableWarehouseDepartmentFkWarehouse(){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "ALTER TABLE " + Session.getInstance().getToken() + "." + TABLE_WAREHOUSE_DEPARTMENT + " DROP CONSTRAINT IF EXISTS magazyn_magazyn_dzial_fk");
        }catch(SQLException e){
            System.out.println("Couldn't process alter table warehouse-department fkWarehouse: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
