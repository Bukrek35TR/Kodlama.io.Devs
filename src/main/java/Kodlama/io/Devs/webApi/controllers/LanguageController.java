package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageServices;
import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguageResponses;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponses;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	LanguageServices languageServices;

	@Autowired
	public LanguageController(LanguageServices languageServices) {
		this.languageServices = languageServices;
	}

	@GetMapping("/getall")
	public List<GetAllLanguageResponses> getAll() {
		return languageServices.getAll();

	}
	
	@GetMapping("/getbyid")
	public GetByIdLanguageResponses getById(int id) throws Exception{
		return languageServices.getById(id);
		
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception{
		languageServices.add(createLanguageRequest);
		
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest ) throws Exception{
		languageServices.update(updateLanguageRequest);
		
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest ) throws Exception{
		languageServices.delete(deleteLanguageRequest);
		
	}

}
