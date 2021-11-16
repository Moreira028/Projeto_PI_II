package br.senac.pi;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CadastroProdutoController implements Initializable {

    @FXML
    private Pane packageButton;
    @FXML
    private Pane clientButton;
    @FXML
    private Pane shopButton;
    @FXML
    private Pane reportButton;
    
    InnerShadow is = new InnerShadow();
    DropShadow ds = new DropShadow();
    @FXML
    private TableView<LinhaTabelaProdutos> TableProduto;
    @FXML
    private TableColumn<LinhaTabelaProdutos, Integer> ColunaID;
    @FXML
    private TableColumn<LinhaTabelaProdutos, String> ColunaNome;
    @FXML
    private TableColumn<LinhaTabelaProdutos, Double> ColunaPreco;
    @FXML
    private TableColumn<LinhaTabelaProdutos, String> ColunaFabricante;
    @FXML
    private TextField namepTextField;
    @FXML
    private TextField precoTextField;
    @FXML
    private TextField fabTextField;
    @FXML
    private TextField idTextField;
    
    Integer IdEdicao = null;
    @FXML
    private TextField catTextField;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColunaID.setCellValueFactory(new PropertyValueFactory("id"));
        ColunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        ColunaPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        ColunaFabricante.setCellValueFactory(new PropertyValueFactory("fabricante"));
//        LinhaTabelaProdutos linha = new LinhaTabelaProdutos(1, "Far cry 6", 5.2, "Ubisoft");
//        TableProduto.getItems().add(linha);
    }
    
//    @FXML
//    private void termino(ActionEvent event) throws IOException {
//        App.setRoot("menu");
//    }
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
        
        packageButton.setEffect(is);
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
        packageButton.setEffect(is);
    }

    @FXML
    private void emitirRelatorio(MouseEvent event) throws IOException {
        App.setRoot("telarelatorio");
    }

    @FXML
    private void cadastrar(ActionEvent event) {
        String sql = "INSERT INTO produto (nome, preco, fabricante, categoria) VALUES (?,?,?,?)";
        
        try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
            ps.setString(1, namepTextField.getText() );
            ps.setDouble(2, Double.parseDouble(precoTextField.getText()) );
            ps.setString(3, fabTextField.getText() );
            ps.setString(4, catTextField.getText());
            
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        if(idTextField.getText().isBlank()){
            atualizarTabela();
        }
        else{
            buscar();
        }
        
    }

    @FXML
    private void deletar(ActionEvent event) {
        LinhaTabelaProdutos linha = TableProduto.getSelectionModel().getSelectedItem();
        
        if(linha != null){
            int id = linha.getId();
            
            String sql = "DELETE FROM produto WHERE Id_produto = ?";
            
            try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
                ps.setInt(1, id);
                
                ps.execute();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void atualizarTabela(){
        TableProduto.getItems().clear();
        
        String sql = "SELECT * FROM produto";
        
        try(PreparedStatement ps = DB.connect().prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("Id_produto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String fabricante = rs.getString("fabricante");
                String categoria = rs.getString("categoria");
                
                LinhaTabelaProdutos linha = new LinhaTabelaProdutos(id, nome, preco, fabricante, categoria);
                TableProduto.getItems().add(linha);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void editar(ActionEvent event) {
        LinhaTabelaProdutos linha = TableProduto.getSelectionModel().getSelectedItem();
        if(linha != null){
            int id = linha.getId();
            
            String sql = "SELECT * FROM produto WHERE Id_produto = ?";
            
            try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
                ps.setInt(1, id);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    namepTextField.setText(rs.getString("nome"));
                    precoTextField.setText(String.valueOf(rs.getDouble("preco")));
                    fabTextField.setText(rs.getString("fabricante"));
                    catTextField.setText(rs.getString("categoria"));
                    IdEdicao = id;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void salvar(ActionEvent event) {
        String sql = "UPDATE produto SET nome = ?, preco = ?, fabricante = ?, categoria = ? WHERE Id_produto = ?";
        try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
              ps.setString(1, namepTextField.getText());
              ps.setDouble(2, Double.parseDouble(precoTextField.getText()));
              ps.setString(3, fabTextField.getText());
              ps.setString(4, catTextField.getText());
              ps.setInt(5, IdEdicao);
              
              ps.execute();
                
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        
    }
    
    private void buscar(){
        TableProduto.getItems().clear();
        
        String sql = "SELECT * FROM produto WHERE Id_produto like ?";
        
        try(PreparedStatement ps = DB.connect().prepareCall(sql)) {
                ps.setInt(1, Integer.parseInt(idTextField.getText()));
                
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()) {
                    int id = rs.getInt("Id_produto");
                    String nome = rs.getString("nome");
                    String fabricante = rs.getString("fabricante");
                    String categoria = rs.getString("categoria");
                
                    LinhaTabelaProdutos linha = new LinhaTabelaProdutos(id, nome, rs.getDouble("preco"), fabricante, categoria);
                    TableProduto.getItems().add(linha);
                }
                
                
                
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }



    
    
}
