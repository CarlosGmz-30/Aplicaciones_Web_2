package mx.edu.utez.fx5b;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    // Zona de inicialización de los cuadros de texto :)
    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private TextField getTextField4;


    // Zona de las columnas de la tabla :)
    @FXML
    private TableView<Alumno> tableView;

    @FXML
    private TableColumn<Alumno, String> column1;

    @FXML
    private TableColumn<Alumno, String> column2;

    @FXML
    private TableColumn<Alumno, String> column3;

    @FXML
    private TableColumn<Alumno, String> column4;


    // Zona de acción para los botones :)
    @FXML
    protected void onInsertButtonClick() {
    }

    @FXML
    protected void onUpdateButtonClick() {
    }

    @FXML
    protected void onDeleteButtonClick() {
    }
}