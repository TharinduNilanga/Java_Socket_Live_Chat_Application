package Client_Side.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ClientLoginFormController {
    public static String userName;
    public static ArrayList<String> users = new ArrayList<>();
    public TextField txtName;
    public String name;
    public AnchorPane mainRoot;

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        userName = txtName.getText().trim();
        boolean flag = false;
        if (users.isEmpty()) {
            users.add(userName);
            flag = true;
        }

        for (String s : users) {
            if (!s.equalsIgnoreCase(userName)) {
                flag = true;
                System.out.println(userName);
                break;
            }
        }

        if (flag) {
            Parent root = FXMLLoader.load(this.getClass().getResource("../view/MessageForm.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) this.mainRoot.getScene().getWindow();
            primaryStage.setTitle("Room");
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();

            /*this.mainRoot.getChildren().clear();
            this.mainRoot.getChildren().add(
                    FXMLLoader.load(this.getClass().getResource("../view/MessageForm.fxml")));*/
        }
    }
}
