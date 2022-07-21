package br.com.iteris.universidade.segundaapi.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CustomerCreateRequest {
    @NotEmpty
    @Size(max = 40)
    private String FirstName;
    @NotEmpty
    @Size(max = 40)
    private String LastName;
    @Size(max = 20)
    private String City;
    @Size(max = 20)
    private String Country;
    @Size(max = 20)
    private String Phone;
}
