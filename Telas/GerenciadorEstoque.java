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

public class GerenciadorEstoque extends Application {

    private Stage primaryStage;
    private Label totalLabel;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Gerenciador de Estoque");

        List<Ingrediente> ingredientes = Arrays.asList(
                new Ingrediente("Farinha", 10),
                new Ingrediente("Ovo", 20),
                new Ingrediente("Açúcar", 15),
                new Ingrediente("Leite", 25),
                new Ingrediente("Chocolate", 12)
        );

        // Layout principal
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(20));

        int col = 0;
        int row = 0;
        for (Ingrediente ingrediente : ingredientes) {
            addToGrid(gridPane, ingrediente, col, row);
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

        // Seção de resumo do estoque
        HBox resumoEstoque = new HBox(20);
        resumoEstoque.setAlignment(Pos.CENTER);
        resumoEstoque.setPadding(new Insets(20));

        Button adicionarIngredienteButton = new Button("Adicionar Ingrediente");

        adicionarIngredienteButton.setStyle(
                "-fx-background-color: #4a90e2;"
                        + "-fx-text-fill: #ffffff;"
                        + "-fx-font-size: 14pt;"
                        + "-fx-font-weight: bold;"
        );

        adicionarIngredienteButton.setOnAction(e -> {
            // Adicionar a lógica para adicionar um novo ingrediente ao estoque
            System.out.println("Novo ingrediente adicionado!");
        });

        resumoEstoque.getChildren().addAll(adicionarIngredienteButton);

        // VBox principal
        VBox contentBox = new VBox(20);
        contentBox.getChildren().addAll(scrollPane, resumoEstoque);

        // Cena principal
        Scene scene = new Scene(contentBox, 800, 600);
        scene.setFill(Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToGrid(GridPane gridPane, Ingrediente ingrediente, int col, int row) {
        Button reabastecerButton = new Button("Reabastecer");

        reabastecerButton.setStyle(
                "-fx-background-color: #4a90e2;"
                        + "-fx-text-fill: #ffffff;"
                        + "-fx-font-size: 12pt;"
        );

        reabastecerButton.setOnAction(e -> {
            // Adicionar a lógica para reabastecer o ingrediente
            System.out.println("Reabastecendo " + ingrediente.getNome());
            ingrediente.reabastecer();
            atualizarEstoque(gridPane, ingrediente, col, row);
        });

        VBox ingredienteBox = new VBox(10);
        ingredienteBox.setAlignment(Pos.CENTER);
        ingredienteBox.setStyle("-fx-border-color: #dddddd; -fx-border-width: 1px; -fx-padding: 16px;");

        // Adicionando uma imagem ao ingrediente
        Image ingredienteImage = new Image("https://via.placeholder.com/50");
        ImageView imageView = new ImageView(ingredienteImage);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        ingredienteBox.getChildren().addAll(
                imageView,
                new Label(ingrediente.getNome()),
                new Label("Quantidade: " + ingrediente.getQuantidade()),
                new HBox(10, reabastecerButton)
        );

        gridPane.add(ingredienteBox, col, row);
    }

    private void atualizarEstoque(GridPane gridPane, Ingrediente ingrediente, int col, int row) {
        // Limpar a célula do GridPane
        gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row);
        // Adicionar o ingrediente atualizado
        addToGrid(gridPane, ingrediente, col, row);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Ingrediente {

        private String nome;
        private int quantidade;

        public Ingrediente(String nome, int quantidade) {
            this.nome = nome;
            this.quantidade = quantidade;
        }

        public String getNome() {
            return nome;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void reabastecer() {
            quantidade += 10; // Adiciona 10 unidades ao estoque ao reabastecer
        }
    }
}
