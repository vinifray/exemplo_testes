package br.com.aula.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgilTest {

    private Agil agil;
    double horaDificeis, horasFaceis, horasNormais;

    @Before
    public void setup(){
        this.agil = new Agil();
        horaDificeis = 10;
        horasFaceis = 4;
        horasNormais = 5;
    }

    @Test
    public void testarOCalculoCorretoDePert(){
        double esperado = (horaDificeis+horasFaceis+horasNormais)/6;
        double resultado = agil.calcularPert(horaDificeis,horasNormais,horasFaceis);

        Assert.assertEquals(esperado, resultado, 0.004);
    }

    @Test
    public void testarValidacaoDeNumeroNegativosParasHorasNoCalculoDePert(){
        Exception erro = Assert.assertThrows(RuntimeException.class, () -> {
            agil.calcularPert(4,-3,1);
        } );

        Assert.assertEquals("Horas negativas não são aceitas", erro.getMessage());
    }

    @Test
    public void testarValidacaoDeNumeroPositivoCasoPositivo(){
        Assert.assertTrue(agil.validarNumerosPositivos(10));
    }

    @Test
    public void testarValidacaoDeNumeroPositivoCasoNegativo(){
        Assert.assertFalse(agil.validarNumerosPositivos(-2));
    }
}
