package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguageResponses;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponses;

public interface LanguageServices {
	
	List<GetAllLanguageResponses> getAll();

	GetByIdLanguageResponses getById(int id) throws Exception;

	void add(CreateLanguageRequest createLanguageRequest)throws Exception;

//	void update(CreateLanguageRequest createLanguageRequest)throws Exception;
//
//	void delete(CreateLanguageRequest createLanguageRequest) throws Exception;

}
