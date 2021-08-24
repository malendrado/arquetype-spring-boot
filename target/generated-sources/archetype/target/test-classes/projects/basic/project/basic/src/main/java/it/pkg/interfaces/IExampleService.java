package it.pkg.interfaces;

import it.pkg.dto.ExampleDtoRequest;
import it.pkg.dto.ExampleDtoResponse;
import org.springframework.data.domain.Page;

public interface IExampleService {
    Page<ExampleDtoResponse> getList(int page, int size);
    int save(ExampleDtoRequest exampleDtoRequest);
    void delete(int id);
    void put(int id, ExampleDtoRequest exampleDtoRequest);
    ExampleDtoResponse getById(int id);
}
