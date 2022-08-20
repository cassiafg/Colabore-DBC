package service;

import com.github.javafaker.Faker;
import dto.TagDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.TagRequestBody;

import static io.restassured.RestAssured.given;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre Tag, realizadas pelo endpoint tag-controller
 */
public class TagService {
    //declaração das variáveis utilizadas nos testes
    String baseuri = "https://colabore-dbc-api.herokuapp.com/tag";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjU5LCJpYXQiOjE2NjA5MjQ2MzgsImV4cCI6MTY2MTAxMTAzOH0.nNAkGBVIYNSv49jodWRwBYaLVn2X9BWU84YgJuCUMHc";

    //request body com dados da biblioteca faker
    TagRequestBody tagRequestBody = new TagRequestBody();
    Faker faker = new Faker();
    private String nomeTag = faker.color().name();

    /**
     * Teste para listar todas as tags cadastradas com sucesso
     */
    public Response listarTagsComSucesso(){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar todas as tags cadastradas sem autorização
     */
    public Response listarTagsSemAutorizacao(){
        return given()
                .log().all()
                .when()
                .get(baseuri)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para criar uma tag com sucesso, utilizando request body
     * e a biblioteca faker
     */
    public TagDTO criarTagComSucesso(TagRequestBody tagRequestBody) {
        this.tagRequestBody.setNomeTag(nomeTag);
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(this.tagRequestBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(TagDTO.class);
    }

    /**
     * Teste para criar uma tag com um nome já cadastrado previamente
     */
    public Response criarTagJaExistente(String jsonBody){
        return given().header("Authorization", token)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(415)
                .extract().response();
    }

    /**
     * Teste para criar uma tag sem nome
     */
    public Response criarTagSemNome(String jsonBody){
        return given().header("Authorization", token)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(415)
                .extract().response();
    }

    /**
     * Teste para criar uma tag sem autorização
     */
    public Response criarTagSemAutorizacao(TagRequestBody tagRequestBody) {
        this.tagRequestBody.setNomeTag(nomeTag);
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(this.tagRequestBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para deletar uma tag com sucesso
     */
    public Response deletarTagComSucesso(Integer idTag){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .delete(baseuri+"/"+idTag)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para deletar uma tag sem autorização
     */
    public Response deletarTagSemAutorizacao(Integer idTag){
        return given()
                .log().all()
                .when()
                .delete(baseuri+"/"+idTag)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }
}
