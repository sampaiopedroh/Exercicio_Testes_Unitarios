package com.example;

import com.example.locadora.Veiculo;

public class App {
    public static void main( String[] args ) throws IllegalAccessException {
        try {
            Veiculo veiculo = new Veiculo();
            veiculo.setModelo("Sedan");
            veiculo.setDiasAlugados(5);
            System.out.println("Custo 5 dias: " + veiculo.calcularCusto(5));

            veiculo.setDiasAlugados(7);
            System.out.println("Custo 7 dias: " + veiculo.calcularCusto(7));

            veiculo.setDiasAlugados(10);
            System.out.println("Custo 10 dias: " + veiculo.calcularCusto(10));

            veiculo.setDiasAlugados(5);
            System.out.println("Custo 5 dias com atraso (8 dias de uso): " + veiculo.calcularCusto(8));

            veiculo.setDiasAlugados(-2);


        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
