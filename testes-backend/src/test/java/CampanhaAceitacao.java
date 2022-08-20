import dto.CampanhaDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.CampanhaService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre campanha, realizadas pelo endpoint campanha-controller
 */
public class CampanhaAceitacao {

    CampanhaService campanhaService = new CampanhaService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    /**
     * Teste para cadastrar uma campanha com sucesso
     */
    @Test //POST - cadastrar uma campanha com sucesso
    public void testCreateCampanhaComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        CampanhaDTO resultService = campanhaService.cadastrarCampanhaComSucesso(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getTitulo(), "tituloTeste");
        Assert.assertEquals(resultService.getDescricao(), "descricaoTeste");
    }

    /**
     * Teste para cadastrar uma campanha sem título
     */
    @Test //POST - cadastrar uma campanha sem título
    public void testCreateCampanhaSemTitulo() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha-sem-titulo.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = campanhaService.cadastrarCampanhaSemTitulo(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para cadastrar uma campanha sem autorização
     */
    @Test //POST - cadastrar uma campanha sem autorização
    public void testCreateCampanhaSemAutorizacao() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha-sem-titulo.json");
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = campanhaService.cadastrarCampanhaSemAutorizacao(jsonBody);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para cadastrar uma foto para uma campanha com sucesso
     * informando o idCampanha
     */
    @Test //POST - cadastrar uma foto para uma campanha com sucesso
    public void testCreateFotoCampanhaComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criando campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = campanhaService.cadastrarFotoComSucesso(campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * uma campanha previamente cadastrada
     * não enviando o arquivo
     */
    @Test //POST - cadastrar uma foto para uma campanha sem enviar o arquivo
    public void testCreateFotoCampanhaSemEnviarArquivo() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criando campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = campanhaService.createFotoCampanhaSemEnviarArquivo(campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * uma campanha não cadastrada
     */
    @Test //POST - cadastrar uma foto para uma campanha não cadastrada
    public void testCreateFotoCampanhaNaoCadastrda() {
        /* ========== Montagem do cenário ========== */
        Integer idCampanha = 5000;
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = campanhaService.createFotoCampanhaNaoCadastrada(idCampanha);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    /**
     * Teste para cadastrar uma foto sem sucesso para
     * uma campanha com um usuário não logado
     */
    @Test //POST - cadastrar uma foto para uma campanha sem enviar o arquivo
    public void testCreateFotoCampanhaUsuarioNaoAutorizado() throws IOException {
        /* ========== Montagem do cenário ========== */
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        /* ========== Execução ========== */
        //POST - chamada para o serviço
        Response resultService = campanhaService.createFotoCampanhaUsuarioNaoAutorizado(campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para atualizar uma campanha com sucesso
     * informando o idCampanha
     */
    @Test  //PUT - editar uma campanha com sucesso
    public void testUpdateCampanhaComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha-edit.json");
        /* ========== Execução ========== */
        //PUT - Chamada para o serviço
        CampanhaDTO resultService = campanhaService.editarCampanhaComSucesso(jsonBody, campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getTitulo(), "campanha-edit");
        Assert.assertEquals(resultService.getDescricao(), "campanha-edit");
    }

    /**
     * Teste para atualizar uma campanha sem sucesso
     * informando um idCampanha inexistente
     */
    @Test  //PUT - editar uma campanha inexistente no banco
    public void testUpdateCampanhaComIdInexistente() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha-edit.json");
        /* ========== Execução ========== */
        //PUT - Chamada para o serviço
        Response resultService = campanhaService.editarCampanhaComIdInexistente(jsonBody, 5000);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    /**
     * Teste para atualizar uma campanha sem sucesso
     * informando um idCampanha válido
     * e não informando o título da campanha
     */
    @Test  //PUT - editar uma campanha sem informar título
    public void testUpdateCampanhaSemInformarTitulo() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha-edit-sem-titulo.json");
        /* ========== Execução ========== */
        //PUT - Chamada para o serviço
        Response resultService = campanhaService.editarCampanhaSemInformarTitulo(jsonBody, campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 400);
    }

    /**
     * Teste para atualizar uma campanha sem sucesso
     * informando um idCampanha válido
     * mas com o usuário não logado
     */
    @Test  //PUT - editar uma campanha sem autorização
    public void updateCampanhaSemAutorizacao() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/campanha-edit.json");
        /* ========== Execução ========== */
        //PUT - Chamada para o serviço
        Response resultService = campanhaService.editarCampanhaSemAutorizacao(jsonBody, campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para listar com sucesso as campanhas criadas
     * por um usuário logado
     */
    @Test
    public void testGetCampanhasDoUsuarioComSucesso(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhasDoUsuarioComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar sem sucesso as campanhas criadas
     * por um usuário logado
     */
    @Test
    public void testGetCampanhasDoUsuarioSemAutorizacao(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhasDoUsuarioSemAutorizacao();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para listar com sucesso uma campanha
     * buscando pelo idCampanha
     */
    @Test
    public void testGetCampanhaPorIdComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhaPorIdComSucesso(campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar sem sucesso uma campanha
     * buscando por um idCampanha não existente
     */
    @Test
    public void testGetCampanhaPorIdSemSucessoIdInexistente() {
        /* ========== Montagem do cenário ========== */
        Integer idCampanha = 5000;
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhaPorIdNaoValido(idCampanha);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    /**
     * Teste para listar sem sucesso uma campanha
     * buscando por um idCampanha existente
     * com usuário não logado
     */
    @Test
    public void testGetCampanhaPorIdSemAutorizacao() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhaPorIdSemAutorizacao(campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para deletar com sucesso uma campanha
     * buscando por um idCampanha existente
     * e com um usuário logado
     */
    @Test
    public void testDeleteCampanhaPorIdComSucesso() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        Integer idCampanha = campanhaDTO.getIdCampanha();
        /* ========== Execução ========== */
        //DELETE - chamada para o serviço
        Response resultService = campanhaService.deletarCampanhaPeloId(idCampanha);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 204);
    }

    /**
     * Teste para deletar sem sucesso uma campanha
     * buscando por um idCampanha não existente
     * e com um usuário logado
     */
    @Test
    public void testDeleteCampanhaPorIdInexistente(){
        /* ========== Montagem do cenário ========== */
        Integer idCampanha = 5000;
        /* ========== Execução ========== */
        //DELETE - chamada para o serviço
        Response resultService = campanhaService.deletarCampanhaPeloIdInexistente(idCampanha);
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    /**
     * Teste para deletar sem sucesso uma campanha
     * buscando por um idCampanha existente
     * e com um usuário não logado
     */
    @Test
    public void testDeleteCampanhaPorIdSemAutorizacao() throws IOException {
        /* ========== Montagem do cenário ========== */
        //Criar uma campanha para o teste
        CampanhaDTO campanhaDTO = campanhaService.cadastrarCampanhaComSucesso(lerJson("src/test/resources/data/campanha.json"));
        /* ========== Execução ========== */
        //DELETE - chamada para o serviço
        Response resultService = campanhaService.deletarCampanhaSemAutorizacao(campanhaDTO.getIdCampanha());
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    /**
     * Teste para listar campanhas com sucesso
     * filtrando por meta atingida, sem contribuições do usuário
     * e não criadas pelo usuário
     * não informando idTags
     */
    @Test
    public void testGetCampanhasMetaAtingidaComSucesso(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhasMetaAtingidaComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar campanhas com sucesso
     * sem filtro por meta atingida, com contribuições do usuário
     * e não criadas pelo usuário
     * não informando idTags
     */
    @Test
    public void testGetCampanhasSemFiltroMetaComSucesso(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhasSemFiltroMetaComContribuicoesUsuarioComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar campanhas com sucesso
     * filtrando por meta não atingida, sem contribuições do usuário
     * e com filtro criadas pelo usuário
     * não informando idTags
     */
    @Test
    public void testGetCampanhasMetaNaoAtingidaComSucesso(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhasMetaNaoAtingidaCriadasPeloUsuarioComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar campanhas sem sucesso
     * sem filtro por meta, sem contribuições do usuário
     * e não criadas pelo usuário
     * não informando idTags
     * sem autorização
     */
    @Test
    public void testGetCampanhasSemAutorizacao(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = campanhaService.listarCampanhasSemAutorizacao();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

}
