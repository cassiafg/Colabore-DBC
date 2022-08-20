package pojo;

import lombok.Data;

@Data
public class RegisterRequestBody {
    private String nome;
    private String email;
    private String senha;
}
