package obus.test.springmvcrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import obus.test.springmvcrest.model.Obus;
import obus.test.springmvcrest.service.ObusService;

@RestController
@RequestMapping("/api")
public class ObusController {

	@Autowired
	@Qualifier("obusService")
	private ObusService obusService;

	@GetMapping("/obus")
	public ResponseEntity<List<Obus>> getObuses() {
		List<Obus> obus = obusService.getObuses();

		return ResponseEntity.ok().body(obus);
	}
}
