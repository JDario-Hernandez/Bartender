package com.main.test;

import static org.assertj.core.api.Assertions.assertThatList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.main.interfacesServicios.IBartenderServicio;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestProcesar {
	@Autowired
	private IBartenderServicio bartenderService;

	@Test
	void test() {
		List<Integer> respuesta = new ArrayList<>(Arrays.asList(10, 15, 9, 7, 11));
		assertThatList(bartenderService.procesar(5, 3)).isEqualTo(respuesta);
	}

}
