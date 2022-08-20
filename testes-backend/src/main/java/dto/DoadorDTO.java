package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class DoadorDTO {
    private Integer idUsuario;
    private Integer valor;
    private Integer idDoador;
}
