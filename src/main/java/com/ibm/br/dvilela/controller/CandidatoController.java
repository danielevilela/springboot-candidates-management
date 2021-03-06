package com.ibm.br.dvilela.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.br.dvilela.model.Candidato;
import com.ibm.br.dvilela.repository.CandidatoRepository;

@Controller
public class CandidatoController {

	@Autowired
	private CandidatoRepository iCandidato;

	
	@GetMapping("/candidatos")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Candidato> candidatos = seedCandidato();
		modelAndView.addObject("candidatos", iCandidato.findAll());
		modelAndView.addObject("novoCandidato",new Candidato());
		modelAndView.addObject(new Candidato());
		return modelAndView;
	}

	@PostMapping("/save")
	public String salvar(Candidato candidato) {
		this.iCandidato.save(candidato);
		return "redirect:/candidatos";
	}

	@GetMapping("/delete")
	public String delete(Integer id) {
		this.iCandidato.deleteById(id);
		return "redirect:/candidatos";
	}

	@GetMapping("/findOne")
	public Candidato findOne(Integer id) {
		return iCandidato.findById(id).get();
	}
	
	@GetMapping("/gerarPDF")
	public String gerarPDF(Integer id) {
		Candidato candidato = iCandidato.findById(id).get();
		byte[] cv = candidato.getCv();
		return "sucesso" ;
		
			

			/*response.setContentType("application/pdf");
			OutputStream outStream = response.getOutputStream();
			outStream.write(cv);
			outStream.close();*/
		

	}

	public List<Candidato> seedCandidato() {
		List<Candidato> c = new ArrayList<Candidato>();
		for (int i = 0; i < 10; i++) {
			Candidato candidato = new Candidato();
			candidato.setNome("Daniele Souza");
			candidato.setEmail("danipg88@gmail.com");
			c.add(candidato);
		}
		return c;
	}
}
