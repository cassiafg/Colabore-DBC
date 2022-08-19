package service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre usuários, realizadas pelo endpoint usuario-controller
 */
public class UsuarioService {
    //declaração das variáveis utilizadas nos testes
    String baseuri = "https://colabore-dbc-api.herokuapp.com/usuario";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjYsImlhdCI6MTY2MDg0MDM3NywiZXhwIjoxNjYwOTI2Nzc3fQ.Bc7X4HAsOcscppwnb2kn6tG5th3JZtJoadjYR4vjvlQ";


    /**
     * Teste para listar um usuário logado com sucesso
     */
    public Response listarUsuarioLogadoComSucesso(){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/dadosUsuario")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar um usuário logado sem autorização
     */
    public Response listarUsuarioLogadoSemAutorizacao(){
        return given()
                .log().all()
                .when()
                .get(baseuri + "/dadosUsuario")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }
}
