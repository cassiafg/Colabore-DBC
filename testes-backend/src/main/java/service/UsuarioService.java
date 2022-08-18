package service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsuarioService {

    String baseuri = "https://colabore-dbc-api.herokuapp.com/usuario";

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjYsImlhdCI6MTY2MDg0MDM3NywiZXhwIjoxNjYwOTI2Nzc3fQ.Bc7X4HAsOcscppwnb2kn6tG5th3JZtJoadjYR4vjvlQ";

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
