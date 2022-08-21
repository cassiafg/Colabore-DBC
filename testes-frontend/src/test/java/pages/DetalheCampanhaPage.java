package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class DetalheCampanhaPage {
    public static final By btnVerContribuidores = By.cssSelector("#botaoContribuicoes");
    public static final By btnContribuir = By.cssSelector("#botaoContribuir");
    public static final By btnCancelarContribuicao = By.cssSelector("#botaoContribuir");
    public static final By campoValorContribuicao = By.cssSelector(".sc-kgflAQ > div:nth-child(2) > input:nth-child(1)");
    public static final By btnEnviarContribuicao = By.cssSelector("#enviarContribuicao");
    public static final By btnConfirmarContribuicao = By.cssSelector("#confirmarModal");
    public static final By btnCancelarConfirmacao = By.cssSelector("#cancelarModal");
    public static final By toastMsg = By.cssSelector("div.Toastify:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)");
    public static final By btnEditarCampanha = By.cssSelector("#botaoEditar");

    public void clicarBtnEditarCampanha(){
        BaseTest.click(btnEditarCampanha);
    }
}