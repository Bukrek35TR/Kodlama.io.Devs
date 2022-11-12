package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageServices;
import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguageResponses;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponses;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageServices {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageResponses> getAll() {

		List<Language> languages = languageRepository.findAll();

		List<GetAllLanguageResponses> getAllLanguageResponses = new ArrayList<GetAllLanguageResponses>();

		for (Language language : languages) {
			GetAllLanguageResponses languageResponseItem = new GetAllLanguageResponses();
			languageResponseItem.setId(language.getId());
			languageResponseItem.setLanguageName(language.getLanguageName());
			getAllLanguageResponses.add(languageResponseItem);
		}
		return getAllLanguageResponses;
	}

	@Override
	public GetByIdLanguageResponses getById(int id) throws Exception {

		List<Language> languages = languageRepository.findAll();

		GetByIdLanguageResponses getByIdLanguageResponses = new GetByIdLanguageResponses();
		for (Language language : languages) {
			if (language.getId() == id) {

				getByIdLanguageResponses.setLanguageName(language.getLanguageName());
			}
		}

		return getByIdLanguageResponses;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

		Language language = new Language();
		
		List<Language> languages = languageRepository.findAll();
		
		for (Language language2 : languages) {
			
			if(language2.getLanguageName().equalsIgnoreCase(createLanguageRequest.getLanguageName())) {
				throw new Exception("Girdiğiniz programlama dili mevcut");
			}

		}
		
		language.setLanguageName(createLanguageRequest.getLanguageName());

		languageRepository.save(language);
	}

//	@Override
//	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
//		languageRepository.sa;
//
//	}
//
//	@Override
//	public void delete(CreateLanguageRequest createLanguageRequest) throws Exception {
//		languageRepository.deleteById(createLanguageRequest.get);
//
//	}

}

