package com.main.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.interfacesServicios.IBartenderServicio;
import com.main.model.Request;

@RestController
public class BartenderController {

	@Autowired
	IBartenderServicio bartenderService;

	@PostMapping("/prueba")
	public List<Integer> prueba(@RequestBody Request request) {

		List<Integer> respuesta = new ArrayList<>();

		respuesta = bartenderService.procesar(request.getId(), request.getQ());

		return respuesta;
	}
}