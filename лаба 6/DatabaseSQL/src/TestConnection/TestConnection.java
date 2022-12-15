package TestConnection;
import Person.Person;
import Person.Persons;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestConnection {
    public static final String USER_NAME="root";
    public static final String PASSWORD="C1SYjyZ5";
    public static final String URL="jdbc:mysql://localhost:3306/databaseofpersons";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables){
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try{
            statement= connection.createStatement();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner in=new Scanner(new File("input.txt"));
        Persons persons=new Persons();
        persons.read("input.txt");
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO persons (id, name, surname, email) value (?, ?, ?, ?)");
        for (Person a: persons.persons)
        {
            preparedStatement.setInt(1, a.getId());
            preparedStatement.setNString(2, a.getName());
            preparedStatement.setNString(3, a.getSurname());
            preparedStatement.setNString(4, a.getEmail());
            preparedStatement.execute();
        };
        ResultSet resultSet=statement.executeQuery("SELECT * FROM persons");
        while(resultSet.next())
        {
            System.out.println(resultSet.getString(2)+" "+
                    resultSet.getString(3)+" "+
                    resultSet.getString(4));
        }
    }
}
