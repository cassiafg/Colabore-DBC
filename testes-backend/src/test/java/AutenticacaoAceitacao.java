import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.RegisterRequestBody;
import service.AutenticacaoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre autenticação, realizadas pelo endpoint autenticacao-controller
 */
public class AutenticacaoAceitacao {

    AutenticacaoService authService = new AutenticacaoService();
    RegisterRequestBody registerRequestBody = new RegisterRequestBody();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    /**
     * Teste para cadastrar um usuário com sucesso, utilizando dados da biblioteca faker
     */
    @Test  //POST - registrar um usuário
    public void testCreateUser() {
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = authService.cadastrarUsuarioComSucesso(registerRequestBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para cadastrar um usuário sem sucesso, utilizando um e-mail fora do padrão
     * exigido (@dbccompany.com.br)
     */
    @Test  //POST - registrar um usuário com e-mail fora do padrão
    public void testCreateUserEmailError() {
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = authService.cadastrarUsuarioComEmailForaDoPadrao(registerRequestBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para cadastrar um usuário sem sucesso, não informando o seu nome
     */
    @Test  //POST - registrar um usuário sem nome
    public void testCreateUserSemSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/usuario-sem-nome.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = authService.cadastrarUsuarioSemNome(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para realizar um login com sucesso, informando os dados de
     * um usuário previamente cadastrado no sistema
     */
    @Test  //POST - login com sucesso
    public void testLogarComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/login-com-sucesso.json");
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = authService.logarUsuarioComSucesso(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para realizar um login sem sucesso, informando senha inválida para
     * um usuário previamente cadastrado no sistema
     */
    @Test  //POST - login com senha inválida
    public void testLogarComSenhaInvalida() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/login-senha-invalida.json");
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = authService.logarUsuarioComSenhaInvalida(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para realizar um login sem sucesso, informando e-mail inválido para
     * um usuário previamente cadastrado no sistema
     */
    @Test  //POST - login com e-mail inválido
    public void testLogarComEmailInvalido() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/login-email-invalido.json");
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = authService.logarUsuarioComEmailInvalido(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para cadastrar uma foto com sucesso para
     * um usuário previamente cadastrado e logado no sistema
     */
    @Test  //POST - cadastrar foto para um usuário logado
    public void testCreateFotoComSucesso() {
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = authService.createFotoComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * um usuário previamente cadastrado e logado no sistema
     * não enviando o arquivo
     */
    @Test  //POST - cadastrar foto para um usuário logado sem enviar o arquivo
    public void testCreateFotoSemEnviarArquivo() {
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = authService.createFotoSemEnviarArquivo();
        /* ========== Validações ========== */
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * um usuário não logado no sistema
     */
    @Test  //POST - cadastrar foto para um usuário que não está logado
    public void testCreateFotoSemAutorizacao() {
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = authService.createFotoSemAutorizacao();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
