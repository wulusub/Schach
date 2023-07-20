/*

@author Nick

@version 1007

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Datenbank {
    int zug = 0;
    Connection connection = null;
    private void datenbankErstellen() {
        System.out.println("datenbank erstellt");
        try {
            String dbFile = "datenbank.db";

            // Verbindung zur Datenbank herstellen
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }

    Statement statement = null;
    ResultSet resultSet = null;
    private void tabelleErstellen(){
        try {
            statement = connection.createStatement();

            // Tabelle erstellen
            String createTableQuery = "CREATE TABLE IF NOT EXISTS zuege (Zugnummer INT, Zug TEXT)";
            statement.executeUpdate(createTableQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void datenEinfuegen(String text){
        
        try{
        // SQL-Abfrage zum Einfügen von Daten
        String insertQuery = "INSERT INTO zuege (Zugnummer, Zug) VALUES (?, ?)";

        // Prepared Statement vorbereiten
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        
        zug++;
        // Werte für die Parameter festlegen
        statement.setInt(1, zug);
        statement.setString(2, text);

        // Einfügen der Daten ausführen
        statement.executeUpdate();
        
        // Prepared Statement schließen
        statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
    }

    public void tabelleLeeren(){
        
        try{
        //leert die komplette Tabelle
        String deleteQuery = "DELETE FROM zuege";
        Statement statement = connection.createStatement();
        statement.executeUpdate(deleteQuery);
        statement.close();
        
        //Züge auf 0 setzen 
        zug = 0;
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int letzterZug(Connection connection){
        
        try{
        //abfragen des Wertes des letzten Eintrags der Spalte "Zug"
        String selectQuery = "SELECT MAX(Zug) FROM zuege";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        int letzterZug = resultSet.getInt(1);
        resultSet.close();
        statement.close();
        return letzterZug;
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public Datenbank(){
        datenbankErstellen();
        tabelleErstellen();
    }
}
