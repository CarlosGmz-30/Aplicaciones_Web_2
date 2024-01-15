module mx.edu.utez.fx5b {
    requires javafx.controls;
    requires javafx.fxml;


    opens mx.edu.utez.fx5b to javafx.fxml;
    exports mx.edu.utez.fx5b;
}