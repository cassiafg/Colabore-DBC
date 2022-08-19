package service;

import dto.CampanhaDTO;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre campanha, realizadas pelo endpoint campanha-controller
 */
public class CampanhaService {
    String baseuri = "https://colabore-dbc-api.herokuapp.com/campanha";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb2xhYm9yZS1hcGkiLCJqdGkiOjU5LCJpYXQiOjE2NjA5MjQ2MzgsImV4cCI6MTY2MTAxMTAzOH0.nNAkGBVIYNSv49jodWRwBYaLVn2X9BWU84YgJuCUMHc";

    /**
     * Teste para cadastrar uma campanha com sucesso
     */
    public CampanhaDTO cadastrarCampanhaComSucesso(String jsonBody) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/cadastrar")
                .then()
                .log().all()
                .statusCode(201)
                .extract().as(CampanhaDTO.class);
    }

    /**
     * Teste para cadastrar uma campanha sem título
     */
    public Response cadastrarCampanhaSemTitulo(String jsonBody) {
        return given().header("Authorization", token)
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
     * Teste para cadastrar uma campanha sem autorização
     */
    public Response cadastrarCampanhaSemAutorizacao(String jsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/cadastrar")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto para uma campanha com sucesso
     * informando o idCampanha
     */
    public Response cadastrarFotoComSucesso(Integer idCampanha) {
        return given().header("Authorization", token)
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile",new File("src/test/resources/data/teste.jpg"), "image/jpeg")
                .log().all()
                .formParam("idCamapanha", idCampanha)
                .when()
                .post(baseuri+"/cadastrarFoto?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * uma campanha previamente cadastrada
     * não enviando o arquivo
     */
    public Response createFotoCampanhaSemEnviarArquivo(Integer idCampanha) {
        return given().header("Authorization", token)
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile","empty")
                .log().all()
                .formParam("idCamapanha", idCampanha)
                .when()
                .post(baseuri+"/cadastrarFoto?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * uma campanha não cadastrada
     */
    public Response createFotoCampanhaNaoCadastrada(Integer idCampanha) {
        return given().header("Authorization", token)
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile",new File("src/test/resources/data/teste.jpg"), "image/jpeg")
                .log().all()
                .formParam("idCamapanha", idCampanha)
                .when()
                .post(baseuri+"/cadastrarFoto?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * uma campanha com um usuário não logado
     */
    public Response createFotoCampanhaUsuarioNaoAutorizado(Integer idCampanha) {
        return given()
                .header(new Header("content-type", "multipart/form-data" ))
                .multiPart("multipartFile",new File("src/test/resources/data/teste.jpg"), "image/jpeg")
                .log().all()
                .formParam("idCamapanha", idCampanha)
                .when()
                .post(baseuri+"/cadastrarFoto?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para atualizar uma campanha com sucesso
     * informando o idCampanha
     */
    public CampanhaDTO editarCampanhaComSucesso(String jsonBody, Integer idCampanha) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(CampanhaDTO.class);
    }

    /**
     * Teste para atualizar uma campanha sem sucesso
     * informando um idCampanha inexistente
     */
    public Response editarCampanhaComIdInexistente(String jsonBody, Integer idCampanha) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
    }

    /**
     * Teste para atualizar uma campanha sem sucesso
     * informando um idCampanha válido
     * e não informando o título da campanha
     */
    public Response editarCampanhaSemInformarTitulo(String jsonBody, Integer idCampanha) {
        return given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
    }

    /**
     * Teste para atualizar uma campanha sem sucesso
     * informando um idCampanha válido
     * mas com o usuário não logado
     */
    public Response editarCampanhaSemAutorizacao(String jsonBody, Integer idCampanha) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri+"/"+idCampanha)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para listar com sucesso as campanhas criadas
     * por um usuário logado
     */
    public Response listarCampanhasDoUsuarioComSucesso(){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/listarCampanhasDoUsuario")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar sem sucesso as campanhas criadas
     * por um usuário logado
     */
    public Response listarCampanhasDoUsuarioSemAutorizacao(){
        return given()
                .log().all()
                .when()
                .get(baseuri + "/listarCampanhasDoUsuario")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para listar com sucesso uma campanha
     * buscando pelo idCampanha
     */
    public Response listarCampanhaPorIdComSucesso(Integer idCampanha){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/campanhaPeloId?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar sem sucesso uma campanha
     * buscando por um idCampanha não existente
     */
    public Response listarCampanhaPorIdNaoValido(Integer idCampanha){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/campanhaPeloId?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
    }

    /**
     * Teste para listar sem sucesso uma campanha
     * buscando por um idCampanha existente
     * com usuário não logado
     */
    public Response listarCampanhaPorIdSemAutorizacao(Integer idCampanha){
        return given()
                .log().all()
                .when()
                .get(baseuri + "/campanhaPeloId?idCampanha="+idCampanha)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para deletar com sucesso uma campanha
     * buscando por um idCampanha existente
     * e com um usuário logado
     */
    public Response deletarCampanhaPeloId(Integer idCampanha){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .delete(baseuri + "/delete?id="+idCampanha)
                .then()
                .log().all()
                .statusCode(204)
                .extract().response();
    }

    /**
     * Teste para deletar sem sucesso uma campanha
     * buscando por um idCampanha não existente
     * e com um usuário logado
     */
    public Response deletarCampanhaPeloIdInexistente(Integer idCampanha){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .delete(baseuri + "/delete?id="+idCampanha)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
    }

    /**
     * Teste para deletar sem sucesso uma campanha
     * buscando por um idCampanha existente
     * e com um usuário não logado
     */
    public Response deletarCampanhaSemAutorizacao(Integer idCampanha){
        return given()
                .log().all()
                .when()
                .delete(baseuri + "/delete?id="+idCampanha)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }

    /**
     * Teste para listar campanhas com sucesso
     * filtrando por meta atingida, sem contribuições do usuário
     * e não criadas pelo usuário
     * não informando idTags
     */
    public Response listarCampanhasMetaAtingidaComSucesso(){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/listarCampanhas?tipoFiltro=META_ATINGIDA&minhasContribuicoes=false&minhasCampanhas=false")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar campanhas com sucesso
     * sem filtro por meta atingida, com contribuições do usuário
     * e não criadas pelo usuário
     * não informando idTags
     */
    public Response listarCampanhasSemFiltroMetaComContribuicoesUsuarioComSucesso(){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/listarCampanhas?tipoFiltro=TODAS&minhasContribuicoes=true&minhasCampanhas=false")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar campanhas com sucesso
     * filtrando por meta não atingida, sem contribuições do usuário
     * e com filtro criadas pelo usuário
     * não informando idTags
     */
    public Response listarCampanhasMetaNaoAtingidaCriadasPeloUsuarioComSucesso(){
        return given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/listarCampanhas?tipoFiltro=META_NAO_ATINGIDA&minhasContribuicoes=false&minhasCampanhas=true")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Teste para listar campanhas sem sucesso
     * sem filtro por meta, sem contribuições do usuário
     * e não criadas pelo usuário
     * não informando idTags
     * sem autorização
     */
    public Response listarCampanhasSemAutorizacao(){
        return given()
                .log().all()
                .when()
                .get(baseuri + "/listar")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
    }
}
