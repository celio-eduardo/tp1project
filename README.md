# Projeto de Técnicas de Programação 1

Este repositório contém o código-fonte e recursos para o projeto da disciplina de Técnicas de Programação 1. O objetivo deste projeto é aprender e aplicar conceitos de programação orientada a objetos em Java, além de criar uma interface gráfica de usuário (GUI) utilizando um dos frameworks Java, Swing ou JavaFX.

## Visão Geral

O projeto consiste na implementação de um sistema de gestão para um estabelecimento, como um restaurante. Ele incluirá funcionalidades como atendimento ao público, processamento de pagamentos, registro de pedidos e liberação de entregas. O sistema será desenvolvido em Java e utilizará princípios de programação orientada a objetos para criar uma estrutura robusta e modular.

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Framework GUI:** Swing ou JavaFX (ainda a ser decidido)

## Funcionalidades Principais

O sistema terá as seguintes funcionalidades principais:

1. **Atendimento ao Público:** Registro de clientes, atendimento de pedidos e acompanhamento das mesas ocupadas.

2. **Processamento de Pagamentos:** Cálculo de contas, aceitação de pagamentos em dinheiro ou cartão, geração de recibos.

3. **Registro de Pedidos:** Anotação de pedidos dos clientes, inclusão de itens no pedido, modificações e cancelamentos.

4. **Liberação de Entregas:** Preparação e liberação de pedidos para entrega em domicílio.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

- **`src/`**: Contém o código-fonte do projeto.
  - **`model/`**: Classes que representam os objetos do domínio, como Cliente, Pedido, ItemPedido, etc.
  - **`view/`**: Classes que lidam com a interface gráfica do usuário, como janelas, botões e painéis.
  - **`controller/`**: Controladores que fazem a ponte entre a interface gráfica e a lógica de negócios.
  - **`database/`**: Classes para interação com um possível banco de dados ou armazenamento persistente (caso necessário).
- **`resources/`**: Recursos como imagens, ícones e arquivos de configuração.
- **`lib/`**: Bibliotecas externas (caso necessário).
- **`README.md`**: Este arquivo que você está lendo.

## Configuração e Execução

Para configurar e executar o projeto em sua máquina, siga estas etapas:

1. **Pré-requisitos**: Certifique-se de ter o Java instalado em sua máquina.

2. **Clone este repositório**: Use o seguinte comando para clonar o repositório em seu computador:

   ```
   git clone https://github.com/celio-eduardo/tp1project.git
   ```

3. **Abra o projeto em seu ambiente de desenvolvimento**: Utilize uma IDE Java, como o Eclipse ou o IntelliJ IDEA, para abrir o projeto.

4. **Configure as dependências**: Caso esteja usando um framework GUI, configure as bibliotecas necessárias no seu ambiente de desenvolvimento.

5. **Execute o programa**: Inicie a aplicação a partir da classe principal. Dependendo do framework escolhido (Swing ou JavaFX), a classe de entrada pode variar.

## Contribuição

Se você deseja contribuir para este projeto, sinta-se à vontade para fazer um fork deste repositório e enviar pull requests com suas melhorias. Se tiver dúvidas ou sugestões, abra uma issue para discutirmos.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE). Sinta-se à vontade para usá-lo e modificá-lo conforme necessário.

## Contato

Para qualquer dúvida ou contato relacionado a este projeto, você pode entrar em contato com os desenvolvedores por meio dos seguintes meios:

- Nome: Célio Eduardo e Lucas Alves Rodrigues
- Email: celiofeduardo@gmail.com e lalves547@gmail.com

Obrigado por contribuir para o projeto de Técnicas de Programação 1!
