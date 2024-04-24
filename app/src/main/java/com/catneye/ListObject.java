/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catneye;

import java.time.LocalDateTime;

/**
 *
 * @author plintus
 */
public class ListObject {

    private static int maxId;
    private int id;
    private String label;
    private String text;
    private LocalDateTime date;

    public ListObject(int id, String label, String text, LocalDateTime date) {
        this.id = id;
        this.label = label;
        this.text = text;
        this.date = date;

        if (this.id > maxId) {
            maxId = this.id;
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * @return the maxId
     */
    public static int getMaxId() {
        return maxId;
    }

}
