module ProjektPO {
    requires javafx.controls;
    requires javafx.fxml;

    opens projektpo to javafx.fxml;
    exports projektpo;
    exports projektpo.java;
    opens projektpo.java to javafx.fxml;
    exports projektpo.controllers;
    opens projektpo.controllers to javafx.fxml;
}