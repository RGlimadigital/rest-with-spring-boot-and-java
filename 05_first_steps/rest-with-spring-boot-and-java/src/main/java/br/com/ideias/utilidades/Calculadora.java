package br.com.ideias.utilidades;

import java.text.DecimalFormat;

import br.com.ideias.exceptions.ResourceNotFoundException;

public class Calculadora {

	public double somar(String num1, String num2) {
		if (!Conversores.isNumeric(num1) || !Conversores.isNumeric(num2)) {
			throw new ResourceNotFoundException("Inserir Apenas Numeros!");
		}

		return Conversores.convertToDouble(num1) + Conversores.convertToDouble(num2);
	}

	public double subtrair(String num1, String num2) {
		if (!Conversores.isNumeric(num1) || !Conversores.isNumeric(num2)) {
			throw new ResourceNotFoundException("Inserir Apenas Numeros!");
		}

		return Conversores.convertToDouble(num1) - Conversores.convertToDouble(num2);
	}

	public double multiplicacao(String num1, String num2) {
		if (!Conversores.isNumeric(num1) || !Conversores.isNumeric(num2)) {
			throw new ResourceNotFoundException("Inserir Apenas Numeros!");
		}

		return Conversores.convertToDouble(num1) * Conversores.convertToDouble(num2);
	}

	public String divisao(String num1, String num2) {
		if (!Conversores.isNumeric(num1) || !Conversores.isNumeric(num2) || Conversores.convertToDouble(num2) == 0) {
			throw new ResourceNotFoundException("Inserir Apenas Numeros ou num2 Diferente de Zero!");
		}

		DecimalFormat df = new DecimalFormat("#,###.00");

		return df.format(Conversores.convertToDouble(num1) / Conversores.convertToDouble(num2));
	}

	public Double media(String num1, String num2) {
		if (!Conversores.isNumeric(num1) || !Conversores.isNumeric(num2)) {
			throw new ResourceNotFoundException("Inserir Apenas Numeros!");
		}

		return (Conversores.convertToDouble(num1) + Conversores.convertToDouble(num2)) / 2;
	}

	public double raiz(String num1) {
		if (!Conversores.isNumeric(num1)) {
			throw new ResourceNotFoundException("Inserir Apenas Numeros!");
		}

		return Math.sqrt(Conversores.convertToDouble(num1));
	}

}
