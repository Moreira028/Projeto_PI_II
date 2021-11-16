module senac.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens senac.javafxproject to javafx.fxml;
    exports senac.javafxproject;
}
