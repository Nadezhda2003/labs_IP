package com.example.kr1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class HelloController {
    @FXML
    private Label Text;

    @FXML
    private TextField text1;

    @FXML
    protected void onHelloButtonClick() throws FileNotFoundException {
        String var = text1.getText();
        String[] mas=var.split(" ");
        String res="";
        english eng=new english();
        eng.file("english.txt");
        eng.sort();
        franc fr=new franc();
        fr.file("franc.txt");
        fr.sort();
        for (int i=0; i< mas.length; i++)
        {
                int id=eng.search(mas[i].toLowerCase());
                res+=fr.search(id)+" ";
        }
        this.Text.setText(res.strip());
    }
}