package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
		private TextField numeroText;
		private Label comprobarLabel;
		private Button comprobarButton;
		private VBox root;
		private int numeroAleatorio = (int) (Math.random() * (100 + 1));
		private int intentos = 1;

	@Override
	public void start(Stage primaryStage) throws Exception {
				
				numeroText = new TextField();
				numeroText.setPrefColumnCount(5);
				numeroText.setMaxWidth(150);
				numeroText.setAlignment(Pos.CENTER);

				comprobarLabel = new Label();
				comprobarLabel.setText("Introduce un número del 1 al 100");

				comprobarButton = new Button();
				comprobarButton.setText("Comprobar");
				comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
				comprobarButton.setDefaultButton(true);

				root = new VBox();
				root.setSpacing(5);
				root.setAlignment(Pos.CENTER);
				root.getChildren().addAll(comprobarLabel, numeroText, comprobarButton);

				Scene escena = new Scene(root, 320, 200);

				primaryStage.setScene(escena);
				primaryStage.setTitle("AdivinApp");
				primaryStage.show();
			}


	private void onComprobarButtonAction(ActionEvent e) {
		int numero = Integer.parseInt(numeroText.getText());
		try {
			if (numero>numeroAleatorio) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es menor que " + numero + "." + "\n\nVuelve a intentarlo.");
				alert.showAndWait();
				intentos++;
			} else if (numero<numeroAleatorio) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es mayor que " + numero + "." + "\n\nVuelve a intentarlo.");
				alert.showAndWait();
				intentos++;
			} else if (numero==numeroAleatorio){
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Sólo has necesitado " + intentos + " intentos." + "\n\nVuelve a jugar y hazlo mejor");
				alert.showAndWait();
			}	
		} catch (NumberFormatException exception) {
			Alert alert = new Alert(Alert.AlertType.ERROR); //por si no escribe un numero
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");
			alert.showAndWait();
			intentos++;
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
