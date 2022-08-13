package service;

import dto.UsuarioDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AutenticacaoService {

    String baseuri = "https://colabore-dbc-api.herokuapp.com/autenticacao";

    public UsuarioDTO registrarUsuarioComSucesso(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/registrar")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UsuarioDTO.class);
    }

    public Response registrarUsuarioSemEmailESenha(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/registrar")
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
}
