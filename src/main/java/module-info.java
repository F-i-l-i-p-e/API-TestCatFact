module com.example.callcatapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    opens com.example.callcatapi to com.google.gson, javafx.fxml;
    exports com.example.callcatapi;
}
