# Locadora de Veículos
Este projeto simples demonstra a lógica de cálculo de aluguel de um veículo, considerando dias de uso, descontos e multas por atraso.

- Descrição
O projeto consiste em duas classes principais:
  - Veiculo.java: Representa um veículo alugado, contendo informações como modelo, dias alugados e métodos para calcular o custo do aluguel.
  - VeiculoTest.java: Contém os testes unitários para garantir o funcionamento correto da classe Veiculo.

- Funcionalidades
  - Cálculo do custo do aluguel: Calcula o valor total do aluguel com base nos dias de uso e no valor da diária.
  - Descontos: Aplica descontos progressivos para aluguéis de 7 ou mais dias.
    + 10% de desconto para 7 dias de aluguel.
    + 15% de desconto para mais de 7 dias de aluguel.
  - Multa por atraso: Aplica multa de 20% sobre o valor total do aluguel em caso de atraso na devolução do veículo (dias de uso maior que dias alugados).

- Executando os Testes
Os testes unitários foram escritos utilizando JUnit 5. Você precisará de um ambiente de desenvolvimento Java e uma biblioteca JUnit 5 configurada para executá-los. A maioria das IDEs Java (IntelliJ, Eclipse, NetBeans) possuem integração com JUnit e facilitam a execução dos testes.

Alternativamente, você pode usar Maven ou Gradle para gerenciar as dependências e executar os testes via linha de comando.

- Exemplo de Uso
Veiculo veiculo = new Veiculo();
veiculo.setModelo("Sedan");

// Aluguel de 5 dias
veiculo.setDiasAlugados(5);
double custo = veiculo.calcularCusto(5); // Custo sem desconto ou multa
System.out.println("Custo do aluguel: " + custo);


// Aluguel de 7 dias com desconto
veiculo.setDiasAlugados(7);
custo = veiculo.calcularCusto(7); // Custo com desconto de 10%
System.out.println("Custo do aluguel: " + custo);

// Aluguel de 10 dias com desconto
veiculo.setDiasAlugados(10);
custo = veiculo.calcularCusto(10); // Custo com desconto de 15%
System.out.println("Custo do aluguel: " + custo);


// Aluguel de 5 dias com devolução atrasada (8 dias de uso)
veiculo.setDiasAlugados(5);
custo = veiculo.calcularCusto(8); // Custo com multa de 20%
System.out.println("Custo do aluguel: " + custo);
