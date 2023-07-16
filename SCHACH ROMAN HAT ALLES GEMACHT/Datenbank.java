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

        try {
            // Pfad zur SQLite-Datenbankdatei angeben
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
    
    private void datenEinfuegen(Connection connection, String text){
        
        try{
        // SQL-Abfrage zum Einfügen von Daten
        String insertQuery = "INSERT INTO zuege (Zugnummer, Zug) VALUES (?, ?)";

        // Prepared Statement vorbereiten
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        // Werte für die Parameter festlegen
        statement.setInt(1, zug+1);
        statement.setString(2, text);

        // Einfügen der Daten ausführen
        statement.executeUpdate();
        
        // Prepared Statement schließen
        statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
    }

    private void tabelleLeeren(Connection connection){
        
        try{
        //leert die komplette Tabelle
        String deleteQuery = "DELETE FROM zuege";
        Statement statement = connection.createStatement();
        statement.executeUpdate(deleteQuery);
        statement.close();
        
        //Züge auf 0 setzen und die Standart Board-Position einfügen
        zug = 0;
        datenEinfuegen(connection, "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private int letzterZug(Connection connection){
        
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

    private Datenbank(){
        datenbankErstellen();
        tabelleErstellen();
        zug = letzterZug(connection);
    }
}
