package service;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import pojo.RegisterRequestBody;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AutenticacaoService {

    String baseuri = "https://colabore-dbc-api.herokuapp.com/autenticacao";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjYsImlhdCI6MTY2MDc3NDA0NCwiZXhwIjoxNjYwODYwNDQ0fQ.1jFmXaBCHyNQWM4CvJ233-1ZVYxEpI-IoNuKwiM3vTY";

    RegisterRequestBody registerRequestBody = new RegisterRequestBody();
    Faker faker = new Faker();
    private String nome = faker.name().firstName();
    private String email = faker.name().username()+"@dbccompany.com.br";
    private String emailError = faker.internet().emailAddress();
    private String senha = "123";
//    private java.io.File file = new java.io.File("src/test/resources/data/teste.jpg");


    public Response registrarUsuarioComSucesso(RegisterRequestBody registerRequestBody) {
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

    public Response registrarUsuarioComEmailForaDoPadrao(RegisterRequestBody registerRequestBody) {
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

    public Response registrarUsuarioSemNome(String jsonBody) {
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

    public Response createFotoSemEnviarArquivo() {
        return given().header("Authorization", token)
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile","empty")
                .log().all()
                .when()
                .post(baseuri+"/cadastrarFoto")
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
    }

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
