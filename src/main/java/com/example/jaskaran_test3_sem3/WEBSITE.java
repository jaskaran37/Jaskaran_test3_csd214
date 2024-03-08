package com.example.jaskaran_test3_sem3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class WEBSITE {

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private CheckBox pickUpCheckbox;

    @FXML
    private CheckBox deliveryCheckbox;

    @FXML
    private CheckBox sizeSmallCheckbox;

    @FXML
    private CheckBox sizeMediumCheckbox;

    @FXML
    private CheckBox sizeLargeCheckbox;

    @FXML
    private CheckBox sizeExtraLargeCheckbox;

    @FXML
    private Spinner<Integer> toppingsSpinner;

    @FXML
    private TableView<storeorder> pizzaTableView;

    private final String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
    private final String dbUser = "jkrn";
    private final String dbPassword = "j,@";

    @FXML
    protected void addPizzaOrder() {
        String customerName = nameField.getText();
        String mobileNumber = phoneNumberField.getText();
        String pizzaSize = getPizzaSize();
        int numToppings = toppingsSpinner.getValue();
        double totalBill = calculateTotalBill(pizzaSize, numToppings);

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO Storeorders (CustomerName, MobileNumber, PizzaSize, NumToppings, TotalBill) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customerName);
            statement.setString(2, mobileNumber);
            statement.setString(3, pizzaSize);
            statement.setInt(4, numToppings);
            statement.setDouble(5, totalBill);
            statement.executeUpdate();
            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double calculateTotalBill(String pizzaSize, int numToppings) {

        return 0;
    }

    private String getPizzaSize() {

        return "";
    }

    @FXML
    protected void refreshTable() {
        fetchPizzaOrders();
    }

    @FXML
    protected void deletePizzaOrder() {

    }

    private void fetchPizzaOrders() {
        ObservableList<storeorder> orders = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM Storeorders";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderId");
                String customerName = resultSet.getString("CustomerName");
                String mobileNumber = resultSet.getString("MobileNumber");
                String pizzaSize = resultSet.getString("PizzaSize");
                int numToppings = resultSet.getInt("NumToppings");
                double totalBill = resultSet.getDouble("TotalBill");

                storeorder order = new storeorder(orderId, customerName, mobileNumber, pizzaSize, numToppings, totalBill);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pizzaTableView.setItems(orders);
    }

    public void clearFields(ActionEvent actionEvent) {
    }
}
