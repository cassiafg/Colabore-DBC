import dto.CampanhaDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.CampanhaService;
import service.DoadorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre doador, realizadas pelo endpoint doador-controller
 */
public class DoadorAceitacao {
    DoadorService doadorService = new DoadorService();
    CampanhaService campanhaService = new CampanhaService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    /**
     * Teste para criar uma doação com sucesso
     * para campanha válida não criada pelo usuário
     */
    @Test //POST - doação com sucesso
    public void testCreateDoacaoComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Campanha existente não criada pelo usuário
        Integer idCampanha = 5;
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/doacao.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = doadorService.criarDoacaoComSucesso(idCampanha, jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para criar uma doação sem sucesso
     * para uma campanha inexistente
     */
    @Test //POST - doação para campanha inexistente
    public void testCreateDoacaoCampanhaInexistente() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Campanha inexistente
        Integer idCampanha = 5000;
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/doacao.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = doadorService.criarDoacaoCampanhaInexistente(idCampanha, jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    /**
     * Teste para criar uma doação sem sucesso
     * para uma campanha criada pelo usuário
     */
    @Test //POST - doação para campanha criada pelo usuário
    public void testCreateDoacaoCampanhaUsuario() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Cria campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/doacao.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = doadorService.criarDoacaoCampanhaDoUsuario(campanhaDTO.getIdCampanha(), jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para criar uma doação sem sucesso
     * usuário sem autorização
     */
    @Test //POST - doação com sucesso
    public void testCreateDoacaoSemAutorizacao() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Campanha existente não criada pelo usuário
        Integer idCampanha = 5;
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/doacao.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = doadorService.criarDoacaoSemAutorizacao(idCampanha, jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
