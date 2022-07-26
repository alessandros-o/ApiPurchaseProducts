package br.com.iteris.universidade.segundaapi.domain.dto;

import br.com.iteris.universidade.segundaapi.domain.entity.Customer;
import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;

    public CustomerResponse(Customer customer){
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }
}
