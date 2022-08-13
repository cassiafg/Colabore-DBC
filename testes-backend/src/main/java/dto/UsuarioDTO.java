package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioDTO {
    private String nome;
    private String foto;
    private AutenticacaoDto autenticacaoDto;
    private String idUsuario;
}
