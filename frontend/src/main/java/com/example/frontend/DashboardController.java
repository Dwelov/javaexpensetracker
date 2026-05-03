package com.example.frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController {

    @FXML
    private LineChart<String, Number> trendChart;

    @FXML
    private PieChart categoryChart;

    @FXML
    private ComboBox<String> timeRangeCombo;

    @FXML
    private TableView<Transaction> transactionsTable;

    @FXML
    private TableColumn<Transaction, String> dateCol;

    @FXML
    private TableColumn<Transaction, String> descCol;

    @FXML
    private TableColumn<Transaction, String> categoryCol;

    @FXML
    private TableColumn<Transaction, String> amountCol;

    @FXML
    public void initialize() {
        // Initialize ComboBox
        timeRangeCombo.setItems(FXCollections.observableArrayList(
            "Last 7 days", "Last 30 days", "Last 90 days"
        ));
        timeRangeCombo.getSelectionModel().select(1);

        // Initialize Line Chart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Daily spending");
        series.getData().add(new XYChart.Data<>("Apr 4", 45));
        series.getData().add(new XYChart.Data<>("Apr 7", 78));
        series.getData().add(new XYChart.Data<>("Apr 10", 123));
        series.getData().add(new XYChart.Data<>("Apr 13", 56));
        series.getData().add(new XYChart.Data<>("Apr 16", 89));
        series.getData().add(new XYChart.Data<>("Apr 19", 145));
        series.getData().add(new XYChart.Data<>("Apr 22", 67));
        series.getData().add(new XYChart.Data<>("Apr 25", 92));
        series.getData().add(new XYChart.Data<>("Apr 28", 108));
        series.getData().add(new XYChart.Data<>("May 1", 156));
        trendChart.getData().add(series);

        // Initialize Pie Chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Food", 586),
            new PieChart.Data("Transport", 440),
            new PieChart.Data("Shopping", 330),
            new PieChart.Data("Bills", 293),
            new PieChart.Data("Other", 183)
        );
        categoryChart.setData(pieChartData);

        // Initialize Table
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        ObservableList<Transaction> transactions = FXCollections.observableArrayList(
            new Transaction("May 3", "Grocery store", "Food", "-$87.45"),
            new Transaction("May 2", "Uber ride", "Transport", "-$24.50"),
            new Transaction("May 2", "Coffee shop", "Food", "-$6.75"),
            new Transaction("May 1", "Online shopping", "Shopping", "-$156.00"),
            new Transaction("May 1", "Salary deposit", "Income", "+$5,200.00"),
            new Transaction("Apr 30", "Electric bill", "Bills", "-$142.30"),
            new Transaction("Apr 29", "Restaurant dinner", "Food", "-$68.90")
        );
        transactionsTable.setItems(transactions);
    }

    public static class Transaction {
        private final String date;
        private final String description;
        private final String category;
        private final String amount;

        public Transaction(String date, String description, String category, String amount) {
            this.date = date;
            this.description = description;
            this.category = category;
            this.amount = amount;
        }

        public String getDate() { return date; }
        public String getDescription() { return description; }
        public String getCategory() { return category; }
        public String getAmount() { return amount; }
    }
}
