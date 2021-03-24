package com.redeSocial.compartilhagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redeSocial.compartilhagram.model.Mensagem;
import com.redeSocial.compartilhagram.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagem")
@CrossOrigin("*")
public class MensagemController {
	
	@Autowired
	private MensagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Mensagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mensagem> GetById(@PathVariable long id)
	{
			return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Mensagem> post (@RequestBody Mensagem mensagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(mensagem));
	}
	
	@PutMapping
	public ResponseEntity<Mensagem> put (@RequestBody Mensagem mensagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(mensagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id); 
	}

}
