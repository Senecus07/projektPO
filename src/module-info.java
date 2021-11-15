module ProjektPO {
    requires javafx.controls;
    requires javafx.fxml;

    opens projektpo to javafx.fxml;
    exports projektpo;
}