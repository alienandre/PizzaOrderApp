/**

 @author Brian Tran
 @author Allen Andrews
 */
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {

    public ListView<String> toppingList;
    public ListView<String> selectedToppings;
    public Button addButton;
    public Button removeButton;
    public Button clearButton;
    public ComboBox<String> pizzaType;
    public ComboBox<String> pizzaSize;
    public ImageView picture;
    public Button addOrder;
    public Button showOrder;
    public TextArea txtBox;

   // public ArrayList<Pizza> order = new ArrayList<Pizza>();

    public ArrayList<String> pizzaTypes = new ArrayList<String>(Arrays.asList("Deluxe", "Hawaiian", "Build Your Own"));
    public ArrayList<String> toppings = new ArrayList<String>(Arrays.asList("Beef", "Cheese", "Chicken", "Green Pepper", "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage"));
    public ArrayList<String> pizzaSizes = new ArrayList<String>(Arrays.asList("Small", "Medium", "Large"));
    public ArrayList<String> deluxeToppings =new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom"));
    public ArrayList<String> hawaiianToppings = new ArrayList<String>(Arrays.asList("Ham", "Pineapple"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pizzaType.setItems(FXCollections.observableArrayList(pizzaTypes));
        pizzaSize.setItems(FXCollections.observableArrayList(pizzaSizes));
        toppingList.setItems(FXCollections.observableArrayList(toppings));
        pizzaSize.setValue("Medium");
        pizzaType.setValue("Build Your Own");
        String path = "https://sociorocketnewsen.files.wordpress.com/2013/10/pizza-in-japan.jpg";
        Image image = new Image(path);
        picture.setImage(image);
    }

    public void onClear() {
        toppingList.setItems(FXCollections.observableArrayList(toppings));
        selectedToppings.getItems().clear();
        pizzaSize.setValue("Medium");
        pizzaType.setValue("Build Your Own");
        String path = "https://sociorocketnewsen.files.wordpress.com/2013/10/pizza-in-japan.jpg";
        Image image = new Image(path);
        picture.setImage(image);
        txtBox.setText("");

    }

    public void toggle() {
        txtBox.setText("");
        if (pizzaType.getValue().compareTo("Hawaiian") == 0) {
            toppingList.getItems().clear();
            selectedToppings.setItems(FXCollections.observableArrayList(hawaiianToppings));
            addButton.setDisable(true);
            removeButton.setDisable(true);
            String path = "https://www.kingarthurflour.com/sites/default/files/styles/featured_image/public/recipe_legacy/1374-3-large.jpg?itok=sreY41A-";
            Image image = new Image(path);
            picture.setImage(image);

        } else if (pizzaType.getValue().compareTo("Deluxe") == 0) {
            toppingList.getItems().clear();
            selectedToppings.setItems(FXCollections.observableArrayList(deluxeToppings));
            addButton.setDisable(true);
            removeButton.setDisable(true);
            String path = "https://i2.wp.com/www.chateaudescharmes.com/wp-content/uploads/2019/05/Deluxe-Pizza-May.jpg?fit=825%2C550&ssl=1";
            Image image = new Image(path);
            picture.setImage(image);
        } else {
            toppingList.setItems(FXCollections.observableArrayList(toppings));
            selectedToppings.getItems().clear();
            addButton.setDisable(false);
            removeButton.setDisable(false);
            String path = "https://sociorocketnewsen.files.wordpress.com/2013/10/pizza-in-japan.jpg";
            Image image = new Image(path);
            picture.setImage(image);
        }
    }

    public void onAdd() {
        txtBox.setText("");
        ObservableList<String> toAdd = toppingList.getSelectionModel().getSelectedItems();
        Object[] arr = toAdd.toArray();
        for (int i = 0; i < arr.length; i++) {
            if(selectedToppings.getItems().size()<6) {
                Object s = arr[i];
                selectedToppings.getItems().add((String) s);
                toppingList.getItems().remove(s);
            }
            else{
                txtBox.setText("Number of toppings is limited to 6!");
            }
        }
    }

    public void onRemove() {
        ObservableList<String> toRemove = selectedToppings.getSelectionModel().getSelectedItems();
        Object[] arr = toRemove.toArray();
        for (int i = 0; i < arr.length; i++) {
            Object s = arr[i];
            toppingList.getItems().add((String) s);
            selectedToppings.getItems().remove(s);
        }
    }

    public void onShow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("orderDetails.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Order Summary");
            stage.setScene(new Scene(root, 360, 380));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onAddOrder() {
        ObservableList<String> addedToppings = selectedToppings.getSelectionModel().getSelectedItems();
        String size = null;
        if(pizzaSize.getValue().compareTo("Small") == 0){ size = "Small";}
        if(pizzaSize.getValue().compareTo("Medium") == 0){ size = "Medium";}
        if(pizzaSize.getValue().compareTo("Large") == 0){ size = "Large";}
        if (pizzaType.getValue().compareTo("Hawaiian") == 0) {
            Hawaiian pizza = new Hawaiian("Hawaiian", size, new ArrayList<String>(hawaiianToppings.stream().collect(Collectors.toList())));
            Main.order.add(pizza);
            onClear();
            txtBox.setText("Order added!");
        } else if (pizzaType.getValue().compareTo("Deluxe") == 0) {
            Deluxe pizza = new Deluxe("Deluxe", size, new ArrayList<String>(deluxeToppings.stream().collect(Collectors.toList())));
            Main.order.add(pizza);
            onClear();
            txtBox.setText("Order added!");
        } else if (pizzaType.getValue().compareTo("Build Your Own") == 0) {
            if(selectedToppings.getItems().size()<1){
                txtBox.setText("Order must have at least 1 topping!");
            }
            else {
                BuildYourOwn pizza = new BuildYourOwn("Build Your Own", size, new ArrayList<String>(selectedToppings.getItems().stream().collect(Collectors.toList())));
                Main.order.add(pizza);
                onClear();
                txtBox.setText("Order added!");
            }
        }
    }
}