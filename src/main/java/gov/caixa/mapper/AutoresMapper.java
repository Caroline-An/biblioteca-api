package gov.caixa.mapper;

import gov.caixa.entity.Autores;
import gov.caixa.resource.dto.request.AutorRequest;
import gov.caixa.resource.dto.response.AutorResponse;
import lombok.Data;

@Data
public class AutoresMapper {
    public static Autores toEntity(AutorRequest dto){
        if (dto == null){
            return null;
        }

        Autores autores = new Autores();
        autores.setNome(dto.getNome());
        autores.setNacionalidade(dto.getNacionalidade());

        return autores;
    }

    public static AutorResponse toResponse(Autores autores) {
        if (autores == null){
            return null;
        }

        return AutorResponse.builder()
                .id(autores.getId())
                .nome(autores.getNome())
                .nacionalidade(autores.getNacionalidade())
                .build();
    }
}
