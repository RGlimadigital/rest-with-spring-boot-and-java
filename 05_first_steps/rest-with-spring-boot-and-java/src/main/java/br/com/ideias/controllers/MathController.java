package br.com.ideias.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ideias.utilidades.Calculadora;


@RestController
public class MathController {
	
	private Calculadora calc = new Calculadora();

	@RequestMapping("/somar")
	public Integer somarNumeros(@RequestParam(value = "num1") Integer num1,
			@RequestParam(value = "num2") Integer num2) {

		return num1 + num2;
	}

	@RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2)
			throws Exception {

		return calc.somar(num1, num2);
	}

	@RequestMapping(value = "/sub/{num1}/{num2}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {

		return calc.subtrair(num1, num2);
	}

	@RequestMapping(value = "/mult/{num1}/{num2}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {

		return calc.multiplicacao(num1, num2);
	}

	@RequestMapping(value = "/div/{num1}/{num2}", method = RequestMethod.GET)
	public String divisao(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {

		return calc.divisao(num1, num2);
	}

	@RequestMapping(value = "/media/{num1}/{num2}", method = RequestMethod.GET)
	public Double media(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {

		return calc.media(num1, num2);
	}

	@RequestMapping(value = "/raiz/{num1}", method = RequestMethod.GET)
	public Double raizQuadrada(@PathVariable(value = "num1") String num1) {

		return calc.raiz(num1);
	}

}
