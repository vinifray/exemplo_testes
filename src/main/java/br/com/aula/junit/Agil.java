package br.com.aula.junit;

public class Agil {

    public double calcularPert(double horasDificeis, double horasNormais, double horasFaceis){
        if(validarNumerosPositivos(horasDificeis) && validarNumerosPositivos(horasNormais) &&
                validarNumerosPositivos(horasFaceis)){

            double resultado = (horasDificeis + horasNormais + horasFaceis)/6;
            return resultado;
        }
        throw new RuntimeException("Horas negativas não são aceitas");
    }

    public boolean validarNumerosPositivos(double numero){
        if (numero >= 0){
            return true;
        }
        return false;
    }
}
