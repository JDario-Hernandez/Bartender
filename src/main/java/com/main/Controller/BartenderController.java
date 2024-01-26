package com.main.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> prueba(@RequestBody Request request) {

		Map<String, Object> response = new HashMap<>();

		List<Integer> respuesta = new ArrayList<>();

		respuesta = bartenderService.procesar(request.getId(), request.getQ());
		if (request.getId() >= 1 && request.getId() <= 5) {
		response.put("Data", respuesta);
		}else {
			response.put("Error", "debe insertar un numero entre 1 y 5");	
		}
		return response;
	}
}