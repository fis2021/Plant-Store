module org.FIS2021 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.FIS2021 to javafx.fxml;
    exports org.FIS2021;
}