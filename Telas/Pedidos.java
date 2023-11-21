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


public class Pedidos extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lista de Pedidos");

        // Layout principal
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(20));

        // Gerar dados aleatórios para preencher a lista de pedidos
        List<Pedido> pedidos = gerarPedidos(15);

        int col = 0;
        int row = 0;
        for (Pedido pedido : pedidos) {
            adicionarPedidoAoGrid(gridPane, pedido, col, row);
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

        // Cena principal
        Scene scene = new Scene(scrollPane, 800, 600);
        scene.setFill(Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarPedidoAoGrid(GridPane gridPane, Pedido pedido, int col, int row) {
        VBox pedidoBox = new VBox(10);
        pedidoBox.setAlignment(Pos.CENTER);
        pedidoBox.setStyle("-fx-border-color: #dddddd; -fx-border-width: 1px; -fx-padding: 16px;");

        // Botão para concluir o pedido
        Button concluirButton = new Button("Concluir Pedido");
        concluirButton.setStyle(
                "-fx-background-color: #4a90e2;"
                        + "-fx-text-fill: #ffffff;"
                        + "-fx-font-size: 12pt;"
        );

        // Adicionando dados do pedido
        pedidoBox.getChildren().addAll(
                new Label("Número do Pedido: " + pedido.getNumeroPedido()),
                new Label("Pratos:"),
                criarListaPratos(pedido.getPratos()),
                new Label("Hora do Pedido: " + pedido.getHoraPedido()),
                concluirButton
        );

        gridPane.add(pedidoBox, col, row);
    }

    private VBox criarListaPratos(List<String> pratos) {
        VBox listaPratos = new VBox();
        for (String prato : pratos) {
            listaPratos.getChildren().add(new Label("  - " + prato));
        }
        return listaPratos;
    }

    private List<Pedido> gerarPedidos(int quantidadePedidos) {
        List<Pedido> pedidos = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= quantidadePedidos; i++) {
            int numeroPedido = i;
            List<String> pratos = gerarPratosAleatorios();
            String horaPedido = gerarHoraAleatoria();

            pedidos.add(new Pedido(numeroPedido, pratos, horaPedido));
        }

        return pedidos;
    }

    private List<String> gerarPratosAleatorios() {
        List<String> pratos = Arrays.asList(
                "Lasanha", "Pizza Margherita", "Hambúrguer Clássico",
                "Salada Caesar", "Sopa de Cebola", "Sorvete de Chocolate",
                "Bolo de Cenoura", "Café", "Suco de Laranja", "Água"
        );

        Random random = new Random();
        int quantidadePratos = random.nextInt(5) + 1; // Entre 1 e 5 pratos por pedido

        List<String> pratosSelecionados = new ArrayList<>();
        for (int i = 0; i < quantidadePratos; i++) {
            int indicePrato = random.nextInt(pratos.size());
            pratosSelecionados.add(pratos.get(indicePrato));
        }

        return pratosSelecionados;
    }

    private String gerarHoraAleatoria() {
        Random random = new Random();
        int hora = random.nextInt(24);
        int minuto = random.nextInt(60);

        return String.format("%02d:%02d", hora, minuto);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Pedido {
        private int numeroPedido;
        private List<String> pratos;
        private String horaPedido;

        public Pedido(int numeroPedido, List<String> pratos, String horaPedido) {
            this.numeroPedido = numeroPedido;
            this.pratos = pratos;
            this.horaPedido = horaPedido;
        }

        public int getNumeroPedido() {
            return numeroPedido;
        }

        public List<String> getPratos() {
            return pratos;
        }

        public String getHoraPedido() {
            return horaPedido;
        }
    }
}
