package com.example.locadora;

public class Veiculo {
    private final double VALOR_DA_DIARIA = 10;
    private double PORCENTAGEM_DESCONTO_SETE_DIAS = 0.1;
    private double PORCENTAGEM_DESCONTO_MAIS_DE_SETE_DIAS = 0.15;
    private double PORCENTAGEM_ACRESCIMO_MULTA = 0.2;

    private String modelo = "Não identificado";
    private int diasAlugados;

    public double getPORCENTAGEM_DESCONTO_SETE_DIAS() {
        return PORCENTAGEM_DESCONTO_SETE_DIAS;
    }

    public double getPORCENTAGEM_DESCONTO_MAIS_DE_SETE_DIAS() {
        return PORCENTAGEM_DESCONTO_MAIS_DE_SETE_DIAS;
    }

    public double getPORCENTAGEM_ACRESCIMO_MULTA() {
        return PORCENTAGEM_ACRESCIMO_MULTA;
    }

    public int getDiasAlugados() {
        return diasAlugados;
    }

    public void setDiasAlugados(int diasAlugados) throws IllegalArgumentException {
        if (diasAlugados <= 0){
            throw new IllegalArgumentException("Não é aceito valor menores ou iguais a 0");
        }
        this.diasAlugados = diasAlugados;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getVALOR_DA_DIARIA() {
        return VALOR_DA_DIARIA;
    }

    private boolean isDescontoAplicavel(int diasDeUso) {
        return diasDeUso >= 7;
    }

    public double calcularCusto(int diasDeUso) {
        if (diasDeUso > diasAlugados) {
            return calculaValorComMulta(diasAlugados, diasDeUso);
        }
        else if (isDescontoAplicavel(diasAlugados)) {
            return desconto(diasDeUso);
        }
        return diasDeUso * VALOR_DA_DIARIA;
    }

    private double desconto(int diasAlugados) {
        if (diasAlugados == 7) {
            return ((diasAlugados * VALOR_DA_DIARIA) * (1 - PORCENTAGEM_DESCONTO_SETE_DIAS));
        }
        return ((diasAlugados * VALOR_DA_DIARIA) * (1 - PORCENTAGEM_DESCONTO_MAIS_DE_SETE_DIAS));
    }

    private double calculaValorComMulta(int diasAlugados, int diasDeUso) {
        return ((diasAlugados * diasDeUso) * (1 + PORCENTAGEM_ACRESCIMO_MULTA));
    }
}
