import dto.TagDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.TagRequestBody;
import service.TagService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre Tag, realizadas pelo endpoint tag-controller
 */
public class TagAceitacao {
    TagService tagService = new TagService();
    TagRequestBody tagRequestBody = new TagRequestBody();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    /**
     * Teste para listar todas as tags cadastradas com sucesso
     */
    @Test //Listar todas as tags com sucesso
    public void testGetAllTagsComSucesso(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = tagService.listarTagsComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar todas as tags cadastradas sem autorização
     */
    @Test //Listar todas as tags sem autorização
    public void testGetAllTagsSemAutorizacao(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = tagService.listarTagsSemAutorizacao();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

//    @Test //Listar tags por idCampanha com sucesso
//    public void getTagPorIdCampanhaComSucesso(){
//        Integer idCampanha = 22;
//        //GET - chamada para o serviço
//        Response resultService = tagService.listarTagsPorIdCampanhaComSucesso(idCampanha);
//        //Validação
//        Assert.assertEquals(resultService.getStatusCode(), 200);
//    }
//
//    @Test //Listar tags por idCampanha sem autorização
//    public void getTagPorIdCampanhaSemAutorizacao(){
//        Integer idCampanha = 22;
//        //GET - chamada para o serviço
//        Response resultService = tagService.listarTagsPorIdCampanhaSemAutorizacao(idCampanha);
//        //Validação
//        Assert.assertEquals(resultService.getStatusCode(), 403);
//    }

    /**
     * Teste para criar uma tag com sucesso, utilizando request body
     * e a biblioteca faker
     */
    @Test  //POST - cadastrar uma tag com sucesso
    public void testCreateTagComSucesso() {
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        TagDTO resultService = tagService.criarTagComSucesso(tagRequestBody);
        /* ========== Validações ========== */
        Assert.assertNotNull(resultService.getIdTag());
        Assert.assertNotNull(resultService.getNomeTag());
        //Deleta tag criada
        tagService.deletarTagComSucesso(Integer.valueOf(resultService.getIdTag()));
    }

    /**
     * Teste para criar uma tag com um nome já cadastrado previamente
     */
    @Test //POST - cadastrar uma tag já existente
    public void testCreateTagJaExistente() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/tag.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = tagService.criarTagJaExistente(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 415);
    }

    /**
     * Teste para criar uma tag sem nome
     */
    @Test //POST - cadastrar uma tag sem nome
    public void testCreateTagSemNome() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/tag-sem-nome.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = tagService.criarTagSemNome(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 415);
    }

    /**
     * Teste para criar uma tag sem autorização
     */
    @Test  //POST - cadastrar uma tag sem autorizacao
    public void testCreateTagSemAutorizacao() {
        /* ========== Execução ========== */
        //POST - Chamada para o serviço
        Response resultService = tagService.criarTagSemAutorizacao(tagRequestBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(),403);
    }

    /**
     * Teste para deletar uma tag com sucesso
     */
    @Test //Deletar tag com sucesso
    public void testDeleteTagComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        TagDTO tagDTO = tagService.criarTagComSucesso(tagRequestBody);
        /* ========== Execução ========== */
        //DELETE - chamada para o serviço
        Response resultService = tagService.deletarTagComSucesso(Integer.valueOf(tagDTO.getIdTag()));
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para deletar uma tag sem autorização
     */
    @Test //Deletar tag sem autorizacao
    public void testDeleteTagSemAutorizacao(){
        /* ========== Montagem do cenário ========== */
        TagDTO tagDTO = tagService.criarTagComSucesso(tagRequestBody);
        /* ========== Execução ========== */
        //DELETE - chamada para o serviço
        Response resultService = tagService.deletarTagSemAutorizacao(Integer.valueOf(tagDTO.getIdTag()));
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    private TagDTO criaUmaTagParaTeste() throws IOException {
        return tagService.criarTagParaTeste(lerJson("src/test/resources/data/tag.json"));
    }
}
