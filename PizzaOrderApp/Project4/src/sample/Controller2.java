/**

 @author Brian Tran
 @author Allen Andrews
 */
package sample;

import com.sun.org.apache.xpath.internal.objects.XNull;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller2 implements Initializable{
    String s = "";
    int price = 0;

    public Button clearButton;
    public Button backButton;
    public TextField totPrice;
    public TextArea txtBox;
    public static ArrayList<Pizza> orders = new ArrayList<Pizza>();


    public void onClear(){
        txtBox.setText(null);
        totPrice.setText(null);
         Main.order.removeAll(Main.order);
    }

    public void onBack(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        price = 0;
        s ="";
        for (Pizza pizza : Main.order) {
            s = s + pizza.toString() + "\n";
            price = price + pizza.pizzaPrice();
        }
        txtBox.setText(s);
        totPrice.setText("$"+Integer.toString(price)+".00");
    }
}
