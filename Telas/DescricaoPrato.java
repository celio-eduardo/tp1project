/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package restaurant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lalve
 */


public class DescricaoPrato extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Descrição do Prato");

        // Gerar dados aleatórios para o prato
        Prato prato = gerarPratoAleatorio();

        // Layout principal
        VBox pratoBox = new VBox(20);
        pratoBox.setAlignment(Pos.CENTER);
        pratoBox.setPadding(new Insets(20));
        pratoBox.setStyle(
                "-fx-border-color: #dddddd; -fx-border-width: 1px; -fx-background-color: #f9f9f9;"
        );

        // Adicionando dados do prato
        ImageView imageView = new ImageView(new Image(prato.getUrlImagem()));
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);

        Label nomeLabel = new Label(prato.getNome());
        nomeLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");

        Label precoLabel = new Label("Preço: R$" + String.format("%.2f", prato.getPreco()));
        precoLabel.setStyle("-fx-font-size: 14pt;");

        double avaliacaoArredondada = Math.round(prato.getAvaliacao() * 100.0) / 100.0;
        HBox avaliacaoBox = new HBox(5);
        avaliacaoBox.setAlignment(Pos.CENTER);
        Label avaliacaoLabel = new Label("Avaliação: " + avaliacaoArredondada);
        avaliacaoLabel.setStyle("-fx-font-size: 14pt;");
        Label estrelaLabel = new Label("★");
        estrelaLabel.setStyle("-fx-font-size: 16pt; -fx-fill: gold;");
        avaliacaoBox.getChildren().addAll(avaliacaoLabel, estrelaLabel);

        Label descricaoLabel = new Label("Descrição: " + prato.getDescricao());
        descricaoLabel.setStyle("-fx-font-size: 14pt; -fx-font-style: italic;");

        Label ingredientesLabel = new Label("Ingredientes: " + String.join(", ", prato.getIngredientes()));
        ingredientesLabel.setStyle("-fx-font-size: 14pt;");

        pratoBox.getChildren().addAll(
                imageView,
                nomeLabel,
                precoLabel,
                avaliacaoBox,
                descricaoLabel,
                ingredientesLabel
        );

        // Cena principal
        Scene scene = new Scene(pratoBox, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Prato gerarPratoAleatorio() {
        List<String> nomes = Arrays.asList(
                "Lasanha", "Pizza Margherita", "Hambúrguer Clássico",
                "Salada Caesar", "Sopa de Cebola", "Sorvete de Chocolate",
                "Bolo de Cenoura", "Café", "Suco de Laranja", "Água"
        );

        Random random = new Random();
        String nome = nomes.get(random.nextInt(nomes.size()));
        double preco = random.nextDouble() * 20 + 5; // Entre R$5 e R$25
        double avaliacao = random.nextDouble() * 5; // Entre 0 e 5
        String descricao = "Descrição do prato " + nome;
        List<String> ingredientes = Arrays.asList("Ingrediente1", "Ingrediente2", "Ingrediente3");

        // URL de imagem aleatória (substitua pela lógica real de obtenção de imagens)
        String urlImagem = "https://via.placeholder.com/300";

        return new Prato(nome, preco, avaliacao, descricao, ingredientes, urlImagem);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Prato {
        private String nome;
        private double preco;
        private double avaliacao;
        private String descricao;
        private List<String> ingredientes;
        private String urlImagem;

        public Prato(String nome, double preco, double avaliacao, String descricao, List<String> ingredientes, String urlImagem) {
            this.nome = nome;
            this.preco = preco;
            this.avaliacao = avaliacao;
            this.descricao = descricao;
            this.ingredientes = ingredientes;
            this.urlImagem = urlImagem;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public double getAvaliacao() {
            return avaliacao;
        }

        public String getDescricao() {
            return descricao;
        }

        public List<String> getIngredientes() {
            return ingredientes;
        }

        public String getUrlImagem() {
            return urlImagem;
        }
    }
}
