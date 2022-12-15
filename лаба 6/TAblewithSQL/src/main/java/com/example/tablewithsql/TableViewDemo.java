package com.example.tablewithsql;

import com.example.tablewithsql.Person.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.example.tablewithsql.TestConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static com.example.tablewithsql.TestConnection.connection;
import static com.example.tablewithsql.TestConnection.statement;

public class TableViewDemo extends Application {
    private TableColumn<Person, String> userNameCol;
    private TableColumn<Person, String> SurnameCol;
    private TableColumn<Person, String> emailCol;
    private ObservableList<Person> users;

    private Persons persons;

    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {

        TableView<Person> table = new TableView<Person>();

        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        createDatabase();
        createTable(table);
        users = getUserList();
        table.setItems(users);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("Таблица");

        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void createDatabase() throws ClassNotFoundException, IOException, SQLException {
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
    }
    private ObservableList<Person> getUserList() throws IOException, SQLException {
        persons = new Persons();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM persons");
        while(resultSet.next())
        {
            Person a=new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));
            persons.Add(a);
        }
        ObservableList<Person> list = FXCollections.observableArrayList(persons.persons);
        return list;
    }

    private void createTable(TableView<Person> table) {

        userNameCol = new TableColumn<Person, String>("Имя");
        SurnameCol=new TableColumn<Person, String>("Фамилия");
        emailCol = new TableColumn<Person, String>("E-mail");

        table.getColumns().addAll(userNameCol, SurnameCol, emailCol);

        userNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        SurnameCol.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        userNameCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
        userNameCol.setSortType(TableColumn.SortType.ASCENDING);
    }

    public static void main(String[] args) {
        launch(args);
    }
}