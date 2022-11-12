package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyServices;
import Kodlama.io.Devs.business.responses.language.GetAllLanguageResponses;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponses;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyServices {

	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	GetAllLanguageResponses getAllLanguageResponses;

	@Autowired
	public TechnologyManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository) {
		this.languageRepository = languageRepository;
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologyResponses> getAll() {

		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponses> getAllTechnologyResponses = new ArrayList<GetAllTechnologyResponses>();

		for (Technology technology : technologies) {
			
			GetAllTechnologyResponses technologyResponseItem = new GetAllTechnologyResponses();
			Language language = languageRepository.getReferenceById(technology.getLanguage().getId());
			
			technologyResponseItem.setId(technology.getId());
			technologyResponseItem.setTechnologyName(technology.getTechnologyName());
			technologyResponseItem.setLanguageId(language.getId());
			technologyResponseItem.setLanguageName(language.getLanguageName());
			getAllTechnologyResponses.add(technologyResponseItem);
		}
		return getAllTechnologyResponses;
	}

//	@Override
//	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
//
//		Language language = new Language();
//		List<Language> languages = languageRepository.findAll();
//
//		Technology technology = new Technology();
//		List<Technology> technologies = technologyRepository.findAll();
//		
//		for (Language language2 : languages) {
//			for (Technology technology2 : technologies) {
//
//				if (language2.getLanguageName().equals(languageRepository.getLanguageName())) {
//					throw new Exception("Girdiğiniz programlama dili mevcut");
//				}
//
//			}
//		}
//
//		language.setLanguageName(createLanguageRequest.getLanguageName());
//
//		languageRepository.save(language);
//	}

}
