/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class MenuController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void vendasButton(MouseEvent event) throws IOException {
        App.setRoot("Venda");
    }

    @FXML
    private void cadastroProduto(MouseEvent event) throws IOException {
        App.setRoot("cadastroProduto");
    }
    @FXML
    private void cadastroCliente(MouseEvent event) throws IOException {
        App.setRoot("telacadastrocliente");
    }
    


    
    
}
