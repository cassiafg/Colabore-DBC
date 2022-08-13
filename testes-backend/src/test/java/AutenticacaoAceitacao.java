import dto.UsuarioDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.AutenticacaoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AutenticacaoAceitacao {

    AutenticacaoService authService = new AutenticacaoService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test  //POST - registrar um usuário
    public void createUser() throws IOException {

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/usuario.json");

        //POST - Chamada para o serviço
        UsuarioDTO resultService = authService.registrarUsuarioComSucesso(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getNome(), "teste");
        Assert.assertEquals(resultService.getFoto(), "teste");
    }

    @Test  //POST - registrar um usuário sem senha
    public void createUserSemSucesso() throws IOException {

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/usuario-sem-senha.json");

        //POST - Chamada para o serviço
        Response resultService = authService.registrarUsuarioSemEmailESenha(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    @Test  //POST - login com sucesso
    public void logarComSucesso() throws IOException {
        //Criar usuário para o teste
        authService.registrarUsuarioComSucesso(lerJson("src/test/resources/data/usuario.json"));

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/login-com-sucesso.json");

        //POST - Chamada para o serviço
        Response resultService = authService.logarUsuarioComSucesso(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test  //POST - login com senha inválida
    public void logarComSenhaInvalida() throws IOException {

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/login-senha-invalida.json");

        //POST - Chamada para o serviço
        Response resultService = authService.logarUsuarioComSenhaInvalida(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
