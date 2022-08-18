import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.UsuarioService;

public class UsuarioAceitacao {
    UsuarioService usuarioService = new UsuarioService();

    @Test
    public void getUsuarioLogado(){
        //GET - chamada para o serviço
        Response resultService = usuarioService.listarUsuarioLogadoComSucesso();
        //Validação
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test
    public void getUsuarioLogadoSemAutorizacao(){
        //GET - chamada para o serviço
        Response resultService = usuarioService.listarUsuarioLogadoSemAutorizacao();
        //Validação
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
