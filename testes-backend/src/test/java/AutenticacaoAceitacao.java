import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.RegisterRequestBody;
import service.AutenticacaoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AutenticacaoAceitacao {

    AutenticacaoService authService = new AutenticacaoService();

    RegisterRequestBody registerRequestBody = new RegisterRequestBody();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }


    @Test  //POST - login com sucesso
    public void logarComSucesso() throws IOException {

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

    @Test  //POST - login com e-mail inválido
    public void logarComEmailInvalido() throws IOException {

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/login-email-invalido.json");

        //POST - Chamada para o serviço
        Response resultService = authService.logarUsuarioComSenhaInvalida(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    @Test  //POST - registrar um usuário
    public void createUser() {

        //POST - Chamada para o serviço
        Response resultService = authService.registrarUsuarioComSucesso(registerRequestBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test  //POST - registrar um usuário com e-mail fora do padrão
    public void createUserEmailError() {

        //POST - Chamada para o serviço
        Response resultService = authService.registrarUsuarioComEmailForaDoPadrao(registerRequestBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    @Test  //POST - registrar um usuário sem nome
    public void createUserSemSucesso() throws IOException {

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/usuario-sem-nome.json");

        //POST - Chamada para o serviço
        Response resultService = authService.registrarUsuarioSemNome(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    @Test  //POST - cadastrar foto para um usuário logado
    public void createFotoComSucesso() {

        //POST - Chamada para o serviço
        Response resultService = authService.createFotoComSucesso();

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test  //POST - cadastrar foto para um usuário logado sem enviar o arquivo
    public void createFotoSemEnviarArquivo() {

        //POST - Chamada para o serviço
        Response resultService = authService.createFotoSemEnviarArquivo();

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    @Test  //POST - cadastrar foto para um usuário que não está logado
    public void createFotoSemAutorizacao() {

        //POST - Chamada para o serviço
        Response resultService = authService.createFotoSemAutorizacao();

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
