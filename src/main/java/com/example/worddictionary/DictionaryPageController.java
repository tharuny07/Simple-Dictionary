package com.example.worddictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {
    private DictionarySaver db;
    @FXML
    TextField search;
    @FXML
    TextField newword;
    @FXML
    TextField meaning;
    @FXML
    TextField findword;

    @FXML
    public void SearchButton(MouseEvent event) throws IOException, ClassNotFoundException {
        db= new DictionarySaver();
       //db.serializeHashMap();
        db.deserializeHashMap();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(search.getText().equals("")){
            alert.setContentText("Please enter a word to search");
            alert.showAndWait();
        }
        else if(db.dictionaryList.containsKey(search.getText().toLowerCase())) {
            alert.setContentText("Word is available in the dictionary");
            alert.showAndWait();
        }else{
            alert.setContentText("Word is not Available in the Dictionary");
            alert.showAndWait();
        }
    }
    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Add");

        if (newword.getText().equals("") || meaning.getText().equals("")) {
            alert.setContentText("please enter word/meaning to add to the dictionary");
            alert.showAndWait();
        } else if (db.dictionaryList.containsKey(newword.getText().toLowerCase())) {
            alert.setContentText("the word is already available in the dictionary");
            alert.showAndWait();

        } else {
            db.dictionaryList.put(newword.getText().toLowerCase(), meaning.getText());
            db.serializeHashMap();
            alert.setContentText("New Word is added to the dictionary");
            alert.showAndWait();
        }
    }
    @FXML
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        //System.out.println(search.getText());
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");

        if (findword.getText().equals("")) {
            alert.setContentText("Please enter a word to find meaning");
            alert.showAndWait();
        } else if (db.dictionaryList.containsKey(findword.getText().toLowerCase())) {
//            System.out.println(db.getDictionaryList().get(findword.getText()));
            alert.setContentText(db.dictionaryList.get(findword.getText().toLowerCase()));
            alert.showAndWait();
        } else {
            alert.setContentText("the word is not available in the dictionary");
            alert.showAndWait();
        }

    }
}
