package Kodlama.io.Devs.business.responses.technology;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologyResponses {

	private int id;
	private String languageName;
	List<Technology> technologies;

}