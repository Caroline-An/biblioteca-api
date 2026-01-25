
package gov.caixa.mapper;

import gov.caixa.entity.Editora;
import gov.caixa.resource.dto.request.EditoraRequest;
import gov.caixa.resource.dto.response.EditoraResponse;
import lombok.Data;

@Data
public class EditoraMapper {

    public static Editora toEntity(EditoraRequest dto) {
        if (dto == null) {
            return null;
        }

        Editora editora = new Editora();
        editora.setNome(dto.getNome());
        editora.setCnpj(dto.getCnpj());
        editora.setEndereco(dto.getEndereco());
        editora.setTelefone(dto.getTelefone());
        editora.setEmail(dto.getEmail());

        return editora;
    }

    public static EditoraResponse toResponse(Editora editora) {
        if (editora == null) {
            return null;
        }

        return EditoraResponse.builder()
                .id(editora.getId())
                .nome(editora.getNome())
                .cnpj(editora.getCnpj())
                .endereco(editora.getEndereco())
                .telefone(editora.getTelefone())
                .email(editora.getEmail())
                .build();
    }
}
