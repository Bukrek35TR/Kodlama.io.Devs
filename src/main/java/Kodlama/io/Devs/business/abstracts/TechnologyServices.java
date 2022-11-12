package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponses;

public interface TechnologyServices {
	
	List<GetAllTechnologyResponses> getAll();
	
//	void add(CreateTechnologyRequest createTechnologyRequest)throws Exception;

}
