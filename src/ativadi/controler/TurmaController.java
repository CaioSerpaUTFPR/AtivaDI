/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.controler;

import Banco.BancoSingleton;
import ativadi.AtivaDI;
import ativadi.model.TurmaPrototype;
import ativadi.model.TurmaPre;
import ativadi.model.TurmaSingleton;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class TurmaController implements Initializable {

    List<TurmaPrototype> list = new ArrayList<>();
    TurmaPre turma = new TurmaPre();
    ObservableList<TurmaPrototype> clientes = FXCollections.observableArrayList();
    
    @FXML
    private Button btNovaTurma;
    @FXML
    private TableView<TurmaPrototype> tableview;
    @FXML
    private TableColumn<TurmaPrototype, String> col_codigo;
    @FXML
    private TableColumn<String, String> col_professor;
    @FXML
    private TableColumn<TurmaPrototype, String> col_ano;
    @FXML
    private TableColumn<TurmaPrototype, String> col_semestre;
    @FXML
    private TableColumn<TurmaPrototype, String> col_escolaridade;
    @FXML
    private Button btAttTabela;
    @FXML
    private Button btEditarTurma;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        col_codigo.setCellValueFactory(
                new PropertyValueFactory<>("codTurma"));
        col_professor.setCellValueFactory(
                new PropertyValueFactory<>("nomeProfessor"));
        col_ano.setCellValueFactory(
                new PropertyValueFactory<>("ano"));
        col_semestre.setCellValueFactory(
                new PropertyValueFactory<>("semestre"));
        col_escolaridade.setCellValueFactory(
                new PropertyValueFactory<>("escolaridade"));
        
        list = turma.getAllClientes();
        tableview.setItems(FXCollections.observableArrayList(list));
    }    

    @FXML
    private void cadastrarTurma(ActionEvent event) {
        AtivaDI.mudaTela("criarTurma");   
    }

    @FXML
    private void atualizarTabela(ActionEvent event) {
        list.clear();
        list = turma.getAllClientes();
        tableview.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    private void editarTurma(ActionEvent event) {
        if(tableview.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione uma turma antes de continuar!");
        }
        else{
            TurmaSingleton.getInstance().setId(tableview.getSelectionModel().getSelectedItem().getId());
            //DadosCompletos.getInstance().setNomeCliente(tableview.getSelectionModel().getSelectedItem().getNomeCliente());
            AtivaDI.mudaTela("editarTurma");
        }
    }
    
}
