package fiap.com.br;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class PrimaryController {
    @FXML TextArea textArea;
    private File file;

    

public void save(){
    FileChooser open = new FileChooser();
    File file = open.showSaveDialog(null);

    try {
        PrintWriter out = new PrintWriter(file);
        out.write(textArea.getText());
        out.close();
    } catch (FileNotFoundException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText("Arquivo não encontrado");
        alert.show();
    }

}

public void open(){
    var open = new FileChooser();
    var file = open.showOpenDialog(null);

    try {
        String texto = Files.readString(file.toPath());
        textArea.setText(texto);

    } catch (IOException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText("Erro ao abrir");
        alert.show();
    }
}
}

    