/**

 @author Brian Tran
 @author Allen Andrews
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.util.ArrayList;

public class Main extends Application {

    protected static ArrayList<Pizza> order = new ArrayList<Pizza>();

    /**
     * main method for starting the GUI Tuition Manager
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My Pizza Store");
        primaryStage.setScene(new Scene(root, 530, 520));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
