/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package restaurant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lalve
 */


public class Avaliacao extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Avaliação de Pratos");

        // Gerar dados aleatórios para os pratos no pedido
        List<PratoPedido> pratosNoPedido = gerarPratosNoPedido(5);

        // Layout principal
        VBox avaliacaoBox = new VBox(20);
        avaliacaoBox.setAlignment(Pos.CENTER);
        avaliacaoBox.setPadding(new Insets(20));
        avaliacaoBox.setStyle(
                "-fx-border-color: #dddddd; -fx-border-width: 1px; -fx-background-color: #f9f9f9;"
        );

        // Título
        Label tituloLabel = new Label("Avaliação de Pratos");
        tituloLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        avaliacaoBox.getChildren().add(tituloLabel);

        // Adicionando avaliação para cada prato
        for (PratoPedido pratoPedido : pratosNoPedido) {
            HBox pratoBox = new HBox(20);
            pratoBox.setAlignment(Pos.CENTER);

            Label nomeLabel = new Label(pratoPedido.getNome());
            nomeLabel.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");

            // Campo de avaliação (input inteiro de 0 a 5)
            Spinner<Integer> avaliacaoSpinner = new Spinner<>(0, 5, 0);
            avaliacaoSpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
            avaliacaoSpinner.setEditable(false);

            pratoBox.getChildren().addAll(nomeLabel, avaliacaoSpinner);
            avaliacaoBox.getChildren().add(pratoBox);
        }

        // Botão para confirmar a avaliação
        Button confirmarButton = new Button("Confirmar Avaliação");
        confirmarButton.setStyle(
                "-fx-background-color: #4a90e2;"
                        + "-fx-text-fill: #ffffff;"
                        + "-fx-font-size: 14pt;"
                        + "-fx-font-weight: bold;"
        );
        confirmarButton.setOnAction(e -> confirmarAvaliacao());

        avaliacaoBox.getChildren().addAll(new Separator(), confirmarButton);

        // Cena principal
        Scene scene = new Scene(avaliacaoBox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<PratoPedido> gerarPratosNoPedido(int quantidadePratos) {
        List<PratoPedido> pratosNoPedido = new ArrayList<>();

        List<String> nomesPratos = Arrays.asList(
                "Lasanha", "Pizza Margherita", "Hambúrguer Clássico",
                "Salada Caesar", "Sopa de Cebola", "Sorvete de Chocolate",
                "Bolo de Cenoura", "Café", "Suco de Laranja", "Água"
        );

        Random random = new Random();

        for (int i = 0; i < quantidadePratos; i++) {
            String nomePrato = nomesPratos.get(random.nextInt(nomesPratos.size()));
            pratosNoPedido.add(new PratoPedido(nomePrato));
        }

        return pratosNoPedido;
    }

    private void confirmarAvaliacao() {
        // Lógica para confirmar a avaliação (pode ser implementada conforme necessário)
        System.out.println("Avaliação confirmada!");
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class PratoPedido {
        private String nome;

        public PratoPedido(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }
}
