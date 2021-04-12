package br.com.aula.junit;

import org.junit.Assert;
import org.junit.Test;

public class AgilTest {

    @Test
    public void testarOCalculoCorretoDePiert(){
        double horaDificeis = 10, horasFaceis = 4, horasNormais = 5;
        double esperado = (horaDificeis+horasFaceis+horasNormais)/6;

        Agil agil = new Agil();
        double resultado = agil.calcularPert(horaDificeis,horasNormais,horasFaceis);

        Assert.assertEquals(esperado, resultado, 0.004);
    }

    @Test
    public void testarValidacaoDeNumeroNegativosParasHorasNoCalculoDePert(){
        Agil agil = new Agil();

        Exception erro = Assert.assertThrows(RuntimeException.class, () -> {
            agil.calcularPert(4,-3,1);
        } );

        Assert.assertEquals("Horas negativas não são aceitas", erro.getMessage());
    }

    @Test
    public void testarValidacaoDeNumeroPositivoCasoPositivo(){
        Agil agil = new Agil();

        Assert.assertTrue(agil.validarNumerosPositivos(10));
    }

    @Test
    public void testarValidacaoDeNumeroPositivoCasoNegativo(){
        Agil agil = new Agil();

        Assert.assertFalse(agil.validarNumerosPositivos(-2));
    }
}
