/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.controler;

import ativadi.model.TurmaSingleton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class EditarTumaController implements Initializable {

    @FXML
    private Label lbId;
    @FXML
    private Button btMostraDados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarDados(ActionEvent event) {
        lbId.setText(Integer.toString(TurmaSingleton.getInstance().getId()));
    }
    
}
