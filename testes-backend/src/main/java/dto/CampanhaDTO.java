package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class CampanhaDTO {
    private Integer meta;
    private String titulo;
    private String descricao;
    private boolean encerrarAutomaticamente;
    private String dataLimite;
    private String nome;
    private List<String> tags;
    private Integer idUsuario;
    private Integer arrecadacao;
    private boolean statusMeta;
    private String fotoCampanha;
    private Integer idCampanha;
    private Integer doacoes;
    private String ultimaAlteracao;
}
