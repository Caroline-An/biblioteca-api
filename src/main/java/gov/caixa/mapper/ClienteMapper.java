package gov.caixa.mapper;

import gov.caixa.entity.Autor;
import gov.caixa.entity.Cliente;
import gov.caixa.resource.dto.request.AutorRequest;
import gov.caixa.resource.dto.request.ClienteRequest;
import gov.caixa.resource.dto.response.AutorResponse;
import gov.caixa.resource.dto.response.ClienteResponse;
import jakarta.ws.rs.client.Client;
import lombok.Data;

@Data
public class ClienteMapper {
    public static Cliente toEntity(ClienteRequest dto){
        if (dto == null){
            return null;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        return cliente;
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        if (cliente == null){
            return null;
        }

        return ClienteResponse.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build();
    }

}
