package service;

import dto.DoadorDTO;
import dto.TagDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.TagRequestBody;

import static io.restassured.RestAssured.given;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre doador, realizadas pelo endpoint doador-controller
 */
public class DoadorService {
    //declaração das variáveis utilizadas nos testes
    String baseuri = "https://colabore-dbc-api.herokuapp.com/doador";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjYsImlhdCI6MTY2MTIxNjYwMywiZXhwIjoxNjYxMzAzMDAzfQ.zqpaBO-Jj1qEZ5uCdQhgHPvNkGoNXMJCef8HAKZYZZ8";

    /**
     * Teste para criar uma doação com sucesso
     * para campanha válida não criada pelo usuário
     */
    public Response criarDoacaoComSucesso(Integer idCampanha, String jsonBody) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para criar uma doação sem sucesso
     * para uma campanha inexistente
     */
    public Response criarDoacaoCampanhaInexistente(Integer idCampanha, String jsonBody) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
    }

    /**
     * Teste para criar uma doação sem sucesso
     * para uma campanha criada pelo usuário
     */
    public Response criarDoacaoCampanhaDoUsuario(Integer idCampanha, String jsonBody) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
    }

    /**
     * Teste para criar uma doação sem sucesso
     * usuário sem autorização
     */
    public Response criarDoacaoSemAutorizacao(Integer idCampanha, String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }
}
