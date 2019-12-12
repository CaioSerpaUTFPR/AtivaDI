/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.model;

/**
 *
 * @author Caio
 */
public class TurmaSingleton {
    private int id;
    private static TurmaSingleton turmaID = new TurmaSingleton();
    
    private TurmaSingleton() {
    }
    
    
    public static TurmaSingleton getInstance() {
        return turmaID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
