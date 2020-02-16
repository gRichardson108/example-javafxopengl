package org.grichardson108.javafxopengl;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("JOGL Test");

        StackPane root = new StackPane();
        SwingNode swingNode = new SwingNode();
        root.getChildren().add(swingNode);

        SwingGLJPanel joglExamplePanel = new SwingGLJPanel();
        joglExamplePanel.setup();
        swingNode.setContent(joglExamplePanel);

        Scene scene = new Scene(root, 800, 600);
        
        scene.setOnKeyPressed((javafx.scene.input.KeyEvent event) -> {
            System.out.println(event.toString());
            switch(event.getCode()) {
                case ESCAPE:
                    SwingGLJPanel.animator.remove(joglExamplePanel);
                    joglExamplePanel.destroy();
            }
        });

        
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}