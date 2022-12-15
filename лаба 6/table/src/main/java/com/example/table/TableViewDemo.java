package com.example.table;
import com.example.table.model.PersonList;
import com.google.gson.Gson;
import com.example.table.model.Person;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TableViewDemo extends Application {
    private TableColumn<Person, String> userNameCol;
    private TableColumn<Person, String> emailCol;
    private ObservableList<Person> users;

    private PersonList persons;

    @Override
    public void start(Stage stage) throws IOException {

        TableView<Person> table = new TableView<Person>();

        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

    private ObservableList<Person> getUserList() throws IOException {
        persons = new PersonList();
        persons.readJson("persons.json");
        ObservableList<Person> list = FXCollections.observableArrayList(persons.persons);
        return list;
    }

    private void createTable(TableView<Person> table) {

        userNameCol = new TableColumn<Person, String>("Имя");
        emailCol = new TableColumn<Person, String>("E-mail");

        table.getColumns().addAll(userNameCol, emailCol);

        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));


        userNameCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());

        userNameCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> event) -> {

            TablePosition<Person, String> pos = event.getTablePosition();
            String newUserName = event.getNewValue();
            int row = pos.getRow();
            Person person = event.getTableView().getItems().get(row);
            person.setUserName(newUserName);
            try {
                persons.writeJson("persons.json");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        userNameCol.setSortType(TableColumn.SortType.ASCENDING);
    }

    public static void main(String[] args) {
        launch(args);
    }
}