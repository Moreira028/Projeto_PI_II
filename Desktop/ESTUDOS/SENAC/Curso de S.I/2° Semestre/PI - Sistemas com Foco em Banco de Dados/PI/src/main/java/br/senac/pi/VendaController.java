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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class VendaController implements Initializable {
    
    InnerShadow is = new InnerShadow();
    DropShadow ds = new DropShadow();
    @FXML
    private Pane clientButton;
    @FXML
    private Pane packageButton;
    @FXML
    private Pane shopButton;
    @FXML
    private Pane reportButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void voltaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
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
    @FXML
    private void select(MouseEvent event) {
        
        shopButton.setEffect(is);
    }

    @FXML
    private void selectClient(MouseEvent event) {
        clientButton.setEffect(is);
    }

    @FXML
    private void selectPackage(MouseEvent event) {
        packageButton.setEffect(is);
    }

    @FXML
    private void selectShop(MouseEvent event) {
        shopButton.setEffect(is);
    }

    @FXML
    private void selectReport(MouseEvent event) {
        reportButton.setEffect(is);
    }

    @FXML
    private void exitClient(MouseEvent event) {
        clientButton.setEffect(ds);
    }

    @FXML
    private void exitPackage(MouseEvent event) {
        packageButton.setEffect(ds);
    }

    @FXML
    private void exitShop(MouseEvent event) {
        shopButton.setEffect(ds);
    }

    @FXML
    private void exitReport(MouseEvent event) {
        reportButton.setEffect(ds);
    }

    @FXML
    private void exit(MouseEvent event) {
        shopButton.setEffect(is);
    }

    @FXML
    private void emitirRelatorio(MouseEvent event) throws IOException {
        App.setRoot("telarelatorio");
    }

    
}
