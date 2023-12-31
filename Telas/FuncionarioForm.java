/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package restaurant;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author lalve
 */



public class FuncionarioForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Formulário de Funcionário");

        // Criar um painel em grade para organizar os componentes
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Criar um texto de título e adicioná-lo ao painel
        Text scenetitle = new Text("Preencha os seus dados");
        scenetitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Criar uma seção de dados pessoais e adicioná-la ao painel
        VBox dadosPessoais = new VBox();
        dadosPessoais.setSpacing(10);
        dadosPessoais.setPadding(new Insets(10, 10, 10, 10));
        dadosPessoais.setStyle(
                "-fx-border-color: #4a90e2; -fx-border-width: 2; -fx-border-radius: 5; -fx-background-color: #f9f9f9;"
        );

        Label dadosPessoaisLabel = new Label("Dados Pessoais");
        dadosPessoaisLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        dadosPessoaisLabel.setTextFill(Color.web("#4a90e2"));

        Label cpfLabel = new Label("CPF:");
        TextField cpfField = new TextField();

        Label nomeLabel = new Label("Nome:");
        TextField nomeField = new TextField();

        Label dataNascLabel = new Label("Data de Nascimento:");
        DatePicker dataNascPicker = new DatePicker();

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        dadosPessoais.getChildren().addAll(dadosPessoaisLabel, cpfLabel, cpfField, nomeLabel, nomeField, dataNascLabel, dataNascPicker, usernameLabel, usernameField, emailLabel, emailField);

        grid.add(dadosPessoais, 0, 1);

        // Criar uma seção de endereço e adicioná-la ao painel
        VBox endereco = new VBox();
        endereco.setSpacing(10);
        endereco.setPadding(new Insets(10, 10, 10, 10));
        endereco.setStyle(
                "-fx-border-color: #4a90e2; -fx-border-width: 2; -fx-border-radius: 5; -fx-background-color: #f9f9f9;"
        );

        Label enderecoLabel = new Label("Endereço");
        enderecoLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        enderecoLabel.setTextFill(Color.web("#4a90e2"));

        Label localLabel = new Label("Local:");
        TextField localField = new TextField();

        Label cepLabel = new Label("CEP:");
        TextField cepField = new TextField();

        Label estadoLabel = new Label("Estado:");
        TextField estadoField = new TextField();

        Label bairroLabel = new Label("Bairro:");
        TextField bairroField = new TextField();

        endereco.getChildren().addAll(enderecoLabel, localLabel, localField, cepLabel, cepField, estadoLabel, estadoField, bairroLabel, bairroField);
        grid.add(endereco, 1, 1);

        // Criar um botão de enviar e adicioná-lo ao painel
        Button btn = new Button("Enviar");
        btn.setStyle(
                "-fx-background-color: #4a90e2; -fx-text-fill: #ffffff; -fx-font-size: 14pt; -fx-font-weight: bold; -fx-border-radius: 5;"
        );

        HBox hbBtn = new HBox(10);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 2, 2, 1);

        // Criar um texto de feedback e adicioná-lo ao painel
        final Text feedback = new Text();
        feedback.setStyle("-fx-font-size: 14pt;");
        grid.add(feedback, 0, 3, 2, 1);

        // Definir a ação do botão de enviar
        btn.setOnAction(e -> {
            feedback.setFill(Color.GREEN);
            feedback.setText("Formulário enviado com sucesso!");
        });

        // Criar uma cena e mostrar o palco
        Scene scene = new Scene(grid, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
