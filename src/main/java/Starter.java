import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/login_form.fxml"))));
//        Scene scene = new Scene(FXMLLoader.load(), 320, 480);
//        scene.getStylesheets().add(getClass().getResource("view/style.css").toExternalForm());
//        stage.show();

        Parent root = FXMLLoader.load(
                getClass().getResource("view/login_form.fxml")
        );

        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("view/style.css").toExternalForm()
        );

        stage.setScene(scene);
        stage.show();

    }
}
