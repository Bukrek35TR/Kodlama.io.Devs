package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyServices;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponses;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	
	TechnologyServices technologyServices ;
	
	@Autowired
	public TechnologyController(TechnologyServices technologyServices) {
		super();
		this.technologyServices = technologyServices;
	}

	@GetMapping("/getall")
	public List<GetAllTechnologyResponses> getAll() {
		return technologyServices.getAll();

	}
	
//	@GetMapping("/getbyid")
//	public GetByIdLanguageResponses getById(int id) throws Exception{
//		return technologyServices.getById(id);
//		
//	}
//	
//	@PostMapping("/add")
//	public void add(CreateLanguageRequest createLanguageRequest) throws Exception{
//		technologyServices.add(createLanguageRequest);
//		
//	}

}
