import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.UsuarioService;

/**
 * Classe de testes criada para garantir o funcionamento das principais operações
 * sobre usuários, realizadas pelo endpoint usuario-controller
 */
public class UsuarioAceitacao {
    UsuarioService usuarioService = new UsuarioService();

    /**
     * Teste para listar um usuário logado com sucesso
     */
    @Test  //GET - listar usuário logado com sucesso
    public void testGetUsuarioLogado(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = usuarioService.listarUsuarioLogadoComSucesso();
        /* ========== Validações ========== */
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    /**
     * Teste para listar um usuário logado sem autorização
     */
    @Test  //GET - listar usuário logado sem sucesso
    public void getUsuarioLogadoSemAutorizacao(){
        /* ========== Execução ========== */
        //GET - chamada para o serviço
        Response resultService = usuarioService.listarUsuarioLogadoSemAutorizacao();
        /* ========== Validações ========== */
        //Validação
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
