package Academia.bancoDeDados;

import java.sql.*;

public abstract class Database {
    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String user = "root";
    static final String password = "001133";
    static final String database = "projeto";

    static final String url = "jdbc:mysql://localhost:3306/" + database;
    public boolean check = false;

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Coneccao feita com sucesso: " + connection);
        } catch (SQLException e) {
            System.out.println("Erro na coneccao ");
        }
    }
}
