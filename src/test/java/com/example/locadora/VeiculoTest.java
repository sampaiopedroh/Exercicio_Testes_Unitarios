package com.example.locadora;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste da locadora de veículos")
public class VeiculoTest {
    @Nested
    class iserirDiasAlugados {
        @Test
        @DisplayName("Deve inserir diasAlugados quando valor for maior que 0")
        void deveInserirDiasAlugaodQuandoValorMaiorZero() throws IllegalArgumentException {
            int diaValido = 2;

            Veiculo veiculo = new Veiculo();
            veiculo.setDiasAlugados(diaValido);

            assertEquals(diaValido, veiculo.getDiasAlugados(), "Quantidade de dias alugados válido");
        }

        @Test
        @DisplayName("Deve lançar exception quando diasAlugados não for válido")
        void deveLancarExceptionQuandoDiasAlugadosNaoValido() throws IllegalArgumentException {
            int diaInvalido = 0;

            Veiculo veiculo = new Veiculo();
            Executable executable = () -> veiculo.setDiasAlugados(diaInvalido);

            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, executable);

            assertEquals("Não é aceito valor menores ou iguais a 0", illegalArgumentException.getMessage());
        }
    }

    @Nested
    class multa {
        @Test
        @DisplayName("Deve aplicar multa quando diasAlugados for menor que diasDeUso")
        void deveAplicarMultaQuandoDiasAlugadosMenorDiasDeUso() throws IllegalArgumentException {
            int diasAlugados = 7;
            int diasDeUsoMaiorDiaAlugado = 8;

            Veiculo veiculo = new Veiculo();
            veiculo.setDiasAlugados(diasAlugados);
            double retorno =  veiculo.calcularCusto(diasDeUsoMaiorDiaAlugado);

            double calculoValorMulta = ((diasAlugados * diasDeUsoMaiorDiaAlugado) * (1 + veiculo.getPORCENTAGEM_ACRESCIMO_MULTA()));

            assertEquals(calculoValorMulta, retorno, "Multa aplicada com sucesso");
        }
    }

    @Nested
    class descontos {
        @Test
        @DisplayName("Deve aplicar desconto normal para diasAlugados igual a 7")
        void deveAplicarDescontoNormalParaDiasDeUsoIgualSete() throws IllegalArgumentException {
            int diasAlugados = 7;
            int diasDeUso = 7;

            Veiculo veiculo = new Veiculo();
            veiculo.setDiasAlugados(diasAlugados);
            double retorno = veiculo.calcularCusto(diasAlugados);

            double calculoValorMulta = ((diasDeUso * veiculo.getVALOR_DA_DIARIA()) * (1 - veiculo.getPORCENTAGEM_DESCONTO_SETE_DIAS()));

            assertEquals(calculoValorMulta, retorno, "Desconto normal aplicado com sucesso");
        }

        @Test
        @DisplayName("Deve aplicar desconto maior para diasAlugados maior a 7")
        void deveAplicarDescontoMaiorParaDiasDeUsoMaiorSete() throws IllegalArgumentException {
            int diasAlugados = 8;
            int diasDeUso = 8;

            Veiculo veiculo = new Veiculo();
            veiculo.setDiasAlugados(diasAlugados);
            double retorno = veiculo.calcularCusto(diasAlugados);

            double calculoValorMulta = ((diasDeUso * veiculo.getVALOR_DA_DIARIA()) * (1 - veiculo.getPORCENTAGEM_DESCONTO_MAIS_DE_SETE_DIAS()));

            assertEquals(calculoValorMulta, retorno, "Desconto maior aplicado com sucesso");
        }
    }
    @Nested
    class casoNormal {
        @Test
        @DisplayName("Deve retornar valor sem descontos ou multa")
        void deveRetornarValorSemDescontosOuMulta() throws IllegalArgumentException {
            int diasAlugados = 6;
            int diasDeUso = 6;

            Veiculo veiculo = new Veiculo();
            veiculo.setDiasAlugados(diasAlugados);
            double retorno = veiculo.calcularCusto(diasAlugados);

            double calculoValorMulta = (diasDeUso * veiculo.getVALOR_DA_DIARIA());

            assertEquals(calculoValorMulta, retorno, "Valor de aluguel normal");
        }
    }
}
