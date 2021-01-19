package project.Datamodel;

import java.sql.*;

public class Register {
    public static final String CONNECTION_STRING = "jdbc:postgresql://ziggy.db.elephantsql.com:5432/cefhxaqy";
    public static final String username = "cefhxaqy";
    public static final String password = "vgtlgQPZ-bCZLJeG2t6pRd9HMeO_vr-e";

    public static final String TABLE_ACCOUNT = "konto";
    public static final String TABLE_ACCOUNT_NAME = "nazwa_uzytkownika";
    public static final String TABLE_ACCOUNT_LOGIN = "login";
    public static final String TABLE_ACCOUNT_PASSWORD = "password";
    public static final int INDEX_ACCOUNT_NAME = 1;
    public static final int INDEX_ACCOUNT_LOGIN = 2;
    public static final int INDEX_ACCOUNT_PASSWORD = 3;

    public static final String CREATE_TABLE_ACCOUNT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNT + " (" + TABLE_ACCOUNT_NAME +
            " VARCHAR(50) NOT NULL," + TABLE_ACCOUNT_LOGIN + " VARCHAR(50) NOT NULL, " + TABLE_ACCOUNT_PASSWORD + " VARCHAR(50) NOT NULL)";

    public static final String INSERT_TABLE_ACCOUNT =
            "INSERT INTO " + TABLE_ACCOUNT + " VALUES (?, ?, ?)";

    public static final String DELETE_TABLE_ACCOUNT =
            "DELETE FROM " + TABLE_ACCOUNT + " WHERE " + TABLE_ACCOUNT_NAME + " = ?";

    public static final String UPDATE_TABLE_ACCOUNT =
            "UPDATE " + TABLE_ACCOUNT + " SET " + TABLE_ACCOUNT_NAME + " = ?, " + TABLE_ACCOUNT_LOGIN + " = ?, " + TABLE_ACCOUNT_PASSWORD + " = ? WHERE " +
                    TABLE_ACCOUNT_NAME + " = ?";

    public static final String CHECK_RECORD =
            "SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + TABLE_ACCOUNT_NAME + " = ?";

    private PreparedStatement queryInsertAccount;
    private PreparedStatement queryDeleteAccount;
    private PreparedStatement queryUpdateAccount;
    private PreparedStatement queryCheckUser;

    private Connection connection;
    private final static Register instance = new Register();

    private Register(){}

    private static Register getInstance(){
        return instance;
    }

    public boolean open(){
        try{
            this.connection = DriverManager.getConnection(CONNECTION_STRING);

            createAccountTable();

            queryInsertAccount = connection.prepareStatement(INSERT_TABLE_ACCOUNT);
            queryDeleteAccount = connection.prepareStatement(DELETE_TABLE_ACCOUNT);
            queryUpdateAccount = connection.prepareStatement(UPDATE_TABLE_ACCOUNT);
            queryCheckUser = connection.prepareStatement(CHECK_RECORD);

            return true;
        } catch(SQLException e){
            System.out.println("Couldn't open the connection to register database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
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
        } catch(SQLException e){
            System.out.println("Couldn't close the connection to register database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private void createAccountTable(){
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_ACCOUNT);
        } catch(SQLException e) {
            System.out.println("Couldn't create table " + TABLE_ACCOUNT + ": " + e.getMessage());
        }
    }

    public boolean insertAccount(String... data){
        try{
            queryInsertAccount.setString(INDEX_ACCOUNT_NAME, data[0]);
            queryInsertAccount.setString(INDEX_ACCOUNT_LOGIN, data[1]);
            queryInsertAccount.setString(INDEX_ACCOUNT_PASSWORD, data[2]);
            int affectedRows = queryInsertAccount.executeUpdate();

            return affectedRows == 1;
        } catch(SQLException e) {
            System.out.println("Couldn't insert data to " + TABLE_ACCOUNT + " table: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(String username){
        try{
            queryUpdateAccount.setString(INDEX_ACCOUNT_NAME, username);
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
}
