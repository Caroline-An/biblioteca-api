package gov.caixa.mapper;

import gov.caixa.entity.Autor;
import gov.caixa.resource.dto.request.AutorRequest;
import gov.caixa.resource.dto.response.AutorResponse;
import lombok.Data;

@Data
public class AutorMapper {
    public static Autor toEntity(AutorRequest dto){
        if (dto == null){
            return null;
        }

        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());

        return autor;
    }

    public static AutorResponse toResponse(Autor autor) {
        if (autor == null){
            return null;
        }

        return AutorResponse.builder()
                .id(autor.getId())
                .nome(autor.getNome())
                .nacionalidade(autor.getNacionalidade())
                .build();
    }
}
