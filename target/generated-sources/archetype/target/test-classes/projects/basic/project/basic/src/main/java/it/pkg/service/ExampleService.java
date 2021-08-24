package it.pkg.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import it.pkg.dto.ExampleDtoRequest;
import it.pkg.dto.ExampleDtoResponse;
import it.pkg.entity.ExampleEntity;
import it.pkg.enums.ErrorCodesEnum;
import it.pkg.exception.CustomNotFoundException;
import it.pkg.interfaces.IExampleService;
import it.pkg.repository.ExampleRepository;

/**
 * Clase service de ejemplo, retornan valores estaticos.
 */
@Service
public class ExampleService implements IExampleService{

	@Autowired
	ExampleRepository exampleRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	/**
	 * Retorna la lista de los examples
	 * @param page numero de pagina
	 * @param size tamaño de la paginacion
	 * @return devuelve listado
	 */
	@Override
	public Page<ExampleDtoResponse> getList(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size, Direction.DESC, "creationDate");
		Page<ExampleDtoResponse> list = this.exampleRepository.findAll(pageable)
				.map(item -> this.modelMapper.map(item, ExampleDtoResponse.class));
		return list;
	}
	
	/**
	 * Guarda un example
	 * @param exampleDtoRequest dto request
	 * @return devuelve dto example
	 */
	@Override
	public int save(ExampleDtoRequest exampleDtoRequest) {
		ExampleEntity example = this.modelMapper.map(exampleDtoRequest, ExampleEntity.class);
		this.exampleRepository.save(example);
		return example.getId();
	}
	
	/**
	 * Elimina un example
	 * @param id numero del example
	 * return 
	 */
	@Override
	public void delete(int id) {
		Optional<ExampleEntity> example = this.exampleRepository.findById(id);
		if(!example.isPresent())
			throw new CustomNotFoundException(ErrorCodesEnum.NOT_FOUND, String.valueOf(id));
		this.exampleRepository.delete(example.get());
	}
	
	/**
	 * Modifica un example
	 * @param id numero del example a modificar
	 * @param exampleDtoRequest dto request
	 * return
	 */
	@Override
	public void put(int id, ExampleDtoRequest exampleDtoRequest) {
		Optional<ExampleEntity> example = this.exampleRepository.findById(id);
		if(!example.isPresent())
			throw new CustomNotFoundException(ErrorCodesEnum.NOT_FOUND, String.valueOf(id));
		
		this.modelMapper.map(exampleDtoRequest, example.get());
		this.exampleRepository.save(example.get());
	}

	/**
	 * Retorna la información de un example por su id
	 * @param id numero del example
	 * @return devuelve dto response
	 */
	@Override
	public ExampleDtoResponse getById(int id) {
		Optional<ExampleEntity> example = this.exampleRepository.findById(id);
		if(!example.isPresent())
			throw new CustomNotFoundException(ErrorCodesEnum.NOT_FOUND, String.valueOf(id));
		ExampleDtoResponse exDtoR = this.modelMapper.map(example.get(), ExampleDtoResponse.class);
		return exDtoR;
	}
}
