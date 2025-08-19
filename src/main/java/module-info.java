module com.beriii.astaralgoproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.base;

    opens com.beriii.astaralgoproject to javafx.fxml;
    opens com.beriii.astaralgoproject.AStar to javafx.fxml;
    opens com.beriii.astaralgoproject.Settings to javafx.fxml;
    exports com.beriii.astaralgoproject;
    exports com.beriii.astaralgoproject.AStar;
    exports com.beriii.astaralgoproject.Settings;
}