package service;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import pojo.RegisterRequestBody;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre autenticação, realizadas pelo endpoint autenticacao-controller
 */
public class AutenticacaoService {
    //declaração das variáveis utilizadas nos testes
    String baseuri = "https://colabore-dbc-api.herokuapp.com/autenticacao";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjYsImlhdCI6MTY2MTIxNjYwMywiZXhwIjoxNjYxMzAzMDAzfQ.zqpaBO-Jj1qEZ5uCdQhgHPvNkGoNXMJCef8HAKZYZZ8";

    //request body com dados da biblioteca faker
    RegisterRequestBody registerRequestBody = new RegisterRequestBody();
    Faker faker = new Faker();
    private String nome = faker.name().firstName();
    private String email = faker.name().username()+"@dbccompany.com.br";
    private String emailError = faker.internet().emailAddress();
    private String senha = "123";

    /**
     * Teste para cadastrar um usuário com sucesso, utilizando dados da biblioteca faker
     */
    public Response cadastrarUsuarioComSucesso(RegisterRequestBody registerRequestBody) {
        this.registerRequestBody.setNome(nome);
        this.registerRequestBody.setEmail(email);
        this.registerRequestBody.setSenha(senha);
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(this.registerRequestBody)
                .when()
                .post(baseuri+"/cadastrar")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para cadastrar um usuário sem sucesso, utilizando um e-mail fora do padrão
     * exigido (@dbccompany.com.br)
     */
    public Response cadastrarUsuarioComEmailForaDoPadrao(RegisterRequestBody registerRequestBody) {
        this.registerRequestBody.setNome(nome);
        this.registerRequestBody.setEmail(emailError);
        this.registerRequestBody.setSenha(senha);
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(this.registerRequestBody)
                .when()
                .post(baseuri+"/cadastrar")
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
    }

    /**
     * Teste para cadastrar um usuário sem sucesso, não informando o seu nome
     */
    public Response cadastrarUsuarioSemNome(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/cadastrar")
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
    }

    /**
     * Teste para realizar um login com sucesso, informando os dados de
     * um usuário previamente cadastrado no sistema
     */
    public Response logarUsuarioComSucesso(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para realizar um login sem sucesso, informando senha inválida para
     * um usuário previamente cadastrado no sistema
     */
    public Response logarUsuarioComSenhaInvalida(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/login")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para realizar um login sem sucesso, informando e-mail inválido para
     * um usuário previamente cadastrado no sistema
     */
    public Response logarUsuarioComEmailInvalido(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/login")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto com sucesso para
     * um usuário previamente cadastrado e logado no sistema
     */
    public Response createFotoComSucesso() {
        return given().header("Authorization", token)
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile",new File("src/test/resources/data/teste.jpg"), "image/jpeg")
                .log().all()
                .when()
                .post(baseuri+"/cadastrarFoto")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * um usuário previamente cadastrado e logado no sistema
     * não enviando o arquivo
     */
    public Response createFotoSemEnviarArquivo() {
        return given().header("Authorization", token)
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile","empty")
                .log().all()
                .when()
                .post(baseuri+"/cadastrarFoto")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * um usuário não logado no sistema
     */
    public Response createFotoSemAutorizacao() {
        return given()
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile",new File("src/test/resources/data/teste.jpg"), "image/jpeg")
                .log().all()
                .when()
                .post(baseuri+"/cadastrarFoto")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }
}
