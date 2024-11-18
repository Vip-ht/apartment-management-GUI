import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

// Ví dụ sử dụng dialog
    public class Main extends Application {

        private double x = 0;
        private double y = 0;

        @Override
        public void start(Stage primaryStage) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("View/StartPage.fxml"));
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) ->{
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) ->{
                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);
                primaryStage.setOpacity(.8);
            });

            root.setOnMouseReleased((MouseEvent event) ->{
                primaryStage.setOpacity(1);
            });

            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();

        }


        public static void main(String[] args) {
            launch(args);
        }
    }
