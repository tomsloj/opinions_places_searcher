import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DataBaseService
{
    final static private String dbName = "scraping.db";

    static void addOpinion( String id, String opinion, double rating )
    {
        String url = "jdbc:sqlite:H:/projekty/scraping/databases/" + dbName;

        opinion = opinion.replace("'", "''");

        String query = "INSERT INTO opinion" +
                "(id, text, rating)\n" +
                "VALUES ('" + id + "', '" + opinion +"'," + rating + ")";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement())
        {
            stmt.execute(query);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage() + " nr2 ");
        }
    }

    static void addPlace( String id, String name, String address, double rating )
    {
        String url = "jdbc:sqlite:H:/projekty/scraping/databases/" + dbName;

        name = name.replace("'", "''");
        address = address.replace("'", "''");

        String query = "INSERT INTO place" +
                "(id, name, adress, rating)\n" +
                "VALUES ('" + id + "', '" + name + "', '" + address + "', " + rating + ")";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement())
        {
            stmt.execute(query);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage() + " nr1 ");
        }
    }
}
