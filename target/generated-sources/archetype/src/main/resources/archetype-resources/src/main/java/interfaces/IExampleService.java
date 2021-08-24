#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.interfaces;

import ${package}.dto.ExampleDtoRequest;
import ${package}.dto.ExampleDtoResponse;
import org.springframework.data.domain.Page;

public interface IExampleService {
    Page<ExampleDtoResponse> getList(int page, int size);
    int save(ExampleDtoRequest exampleDtoRequest);
    void delete(int id);
    void put(int id, ExampleDtoRequest exampleDtoRequest);
    ExampleDtoResponse getById(int id);
}
