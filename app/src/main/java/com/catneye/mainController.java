/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catneye;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDateTime;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author plintus
 */
public class mainController {

    @FXML
    VBox cardItem;
    @FXML
    TextArea tContentEdit;
    @FXML
    TextField hContentEdit;
    @FXML
    TextField dtContentEdit;
    @FXML
    TextField idContentEdit;
    @FXML
    TextField iContentEdit;
    @FXML
    ListView<ListObject> itemsList;

    @FXML
    protected void addButtonAction(ActionEvent event) {
        //tContentEdit
        //hContentEdit
        //dtContentEdit
        //idContentEdit
        //ListObject lo=itemsList.getSelectionModel().getSelectedItem();
        idContentEdit.setText("0");
        hContentEdit.setText("Header");
        tContentEdit.setText("Long text as is: ");
        dtContentEdit.setText(LocalDateTime.now().toString());
        cardItem.setVisible(true);
    }

    @FXML
    protected void delButtonAction(ActionEvent event) {
        ListObject sel = itemsList.getSelectionModel().getSelectedItem();
        if (sel != null) {
            itemsList.getItems().remove(sel);
        }
        this.closeCardItem();
    }

    @FXML
    protected void okContentEditButtonAction(ActionEvent event) {

        ObservableList<ListObject> objList = itemsList.getItems();

        System.out.println(idContentEdit.getText());
        if (org.apache.commons.lang3.math.NumberUtils.toInt(idContentEdit.getText()) == 0) {
            ListObject obj = new ListObject(ListObject.getMaxId() + 1,
                    hContentEdit.getText(),
                    tContentEdit.getText(),
                    LocalDateTime.parse(dtContentEdit.getText()));
            //insert to list
            objList.add(obj);
        } else {
            int i = org.apache.commons.lang3.math.NumberUtils.toInt(iContentEdit.getText());
            int id = org.apache.commons.lang3.math.NumberUtils.toInt(idContentEdit.getText());
            System.out.println("save id: " + id);
            System.out.println("save i: " + i);

            for (ListObject obj : objList) {
                if (obj.getId() == id) {
                    obj.setLabel(hContentEdit.getText());
                    obj.setText(tContentEdit.getText());
                    //update list
                    System.out.println("update list: " + i);
                    objList.set(i, obj);
                    break;
                }
                //i++;
            }
        }
        this.closeCardItem();
    }

    @FXML
    protected void cContentEditdelButtonAction(ActionEvent event) {
        this.closeCardItem();
    }

    @FXML
    protected void onListViewAction(MouseEvent event) {
        //System.out.println("onListViewAction");
        ListObject sel = itemsList.getSelectionModel().getSelectedItem();
        Integer i = itemsList.getSelectionModel().getSelectedIndex();
        if (sel != null) {
            iContentEdit.setText(i.toString());
            idContentEdit.setText(Integer.toString(sel.getId()));
            hContentEdit.setText(sel.getLabel());
            tContentEdit.setText(sel.getText());
            dtContentEdit.setText(sel.getDate().toString());
            cardItem.setVisible(true);
        }
    }

    protected void closeCardItem() {
        hContentEdit.setText(null);
        tContentEdit.setText(null);
        dtContentEdit.setText(null);
        cardItem.setVisible(false);
    }
}
