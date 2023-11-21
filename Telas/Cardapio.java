/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package restaurant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


/**
 *
 * @author lalve
 */


public class Cardapio extends Application {

    private double totalPedido = 0.0;
    private Stage primaryStage;
    private Label totalLabel;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Cardápio");

        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("Lasanha", 18.99, 4.5),
                new MenuItem("Pizza Margherita", 15.99, 4.2),
                new MenuItem("Hambúrguer Clássico", 12.99, 4.0),
                new MenuItem("Salada Caesar", 9.99, 4.8),
                new MenuItem("Sopa de Cebola", 7.99, 4.1),
                new MenuItem("Sorvete de Chocolate", 5.99, 4.7),
                new MenuItem("Bolo de Cenoura", 4.99, 4.3),
                new MenuItem("Café", 2.99, 4.6),
                new MenuItem("Suco de Laranja", 2.99, 4.4),
                new MenuItem("Água", 1.99, 4.9)
        );

        // Layout principal
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(20));

        int col = 0;
        int row = 0;
        for (MenuItem menuItem : menuItems) {
            addToGrid(gridPane, menuItem, col, row);
            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }

        // Adicionando o GridPane a um ScrollPane
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Seção de resumo do pedido
        HBox resumoPedido = new HBox(20);
        resumoPedido.setAlignment(Pos.CENTER);
        resumoPedido.setPadding(new Insets(20));
        totalLabel = new Label("Total do Pedido: R$ " + String.format("%.2f", totalPedido));

        totalLabel.setStyle(
                "-fx-font-size: 16pt;"
                + "-fx-font-weight: bold;"
                + "-fx-text-fill: #4a90e2;"
        );

        Button criarPedidoButton = new Button("Criar Pedido");

        criarPedidoButton.setStyle(
                "-fx-background-color: #4a90e2;"
                + "-fx-text-fill: #ffffff;"
                + "-fx-font-size: 14pt;"
                + "-fx-font-weight: bold;"
        );

        criarPedidoButton.setOnAction(e -> System.out.println("Pedido criado! Total: R$" + String.format("%.2f", totalPedido)));

        resumoPedido.getChildren().addAll(totalLabel, criarPedidoButton);

        // VBox principal
        VBox contentBox = new VBox(20);
        contentBox.getChildren().addAll(scrollPane, resumoPedido);

        // Cena principal
        Scene scene = new Scene(contentBox, 800, 600);
        scene.setFill(Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToGrid(GridPane gridPane, MenuItem menuItem, int col, int row) {
        Button blueButton = new Button("Adicionar");
        Button whiteButton = new Button("Detalhes");

        blueButton.setStyle(
                "-fx-background-color: #4a90e2;"
                + "-fx-text-fill: #ffffff;"
                + "-fx-font-size: 12pt;"
        );

        whiteButton.setStyle(
                "-fx-background-color: #ffffff;"
                + "-fx-border-color: #4a90e2;"
                + "-fx-text-fill: #4a90e2;"
                + "-fx-font-size: 12pt;"
        );

        blueButton.setOnAction(e -> {
            System.out.println("Item adicionado: " + menuItem.getName());
            totalPedido += menuItem.getPrice();
            atualizarTotalPedido();
        });

        whiteButton.setOnAction(e -> System.out.println("Detalhes do item: " + menuItem.getName()));

        VBox itemBox = new VBox(10);
        itemBox.setAlignment(Pos.CENTER);
        itemBox.setStyle("-fx-border-color: #dddddd; -fx-border-width: 1px; -fx-padding: 16px;");

        // Adicionando uma imagem ao item
        Image itemImage = new Image("https://via.placeholder.com/50");
        ImageView imageView = new ImageView(itemImage);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        itemBox.getChildren().addAll(
                imageView,
                new Label(menuItem.getName()),
                new Label("Preço: R$" + String.format("%.2f", menuItem.getPrice())),
                new Label("Avaliação: " + menuItem.getRating()),
                new HBox(10, blueButton, whiteButton)
        );
                
        gridPane.add(itemBox, col, row);
    }

    private void atualizarTotalPedido() {
        primaryStage.setTitle("Cardápio - Total do Pedido: R$ " + String.format("%.2f", totalPedido));
        totalLabel.setText("Total do Pedido: R$ " + String.format("%.2f", totalPedido));
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class MenuItem {

        private String name;
        private double price;
        private double rating;

        public MenuItem(String name, double price, double rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getRating() {
            return rating;
        }
    }
}
