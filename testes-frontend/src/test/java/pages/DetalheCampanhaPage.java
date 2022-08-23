package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class DetalheCampanhaPage {
    public static final By btnVerContribuicoes = By.cssSelector("#botaoContribuicoes");
    public static final By btnContribuir = By.cssSelector("#botaoContribuir");
    public static final By campoValorContribuicao = By.cssSelector("#valor");
    public static final By btnEnviarContribuicao = By.cssSelector("#enviarContribuicao");
    public static final By btnConfirmarContribuicao = By.cssSelector("#confirmarModal");
    public static final By btnCancelarConfirmacao = By.cssSelector("#cancelarModal");
    public static final By btnEditarCampanha = By.cssSelector("#botaoEditar");
    public static final By msgContribuidores = By.cssSelector(".sc-crXcEl");
    public static final By msgCampoObrigatorio = By.cssSelector(".sc-bZkfAO");
    public static final By clicarForaDoCampo = By.cssSelector("p.dGzdsh:nth-child(1)");
    public static final By titulo = By.cssSelector(".sc-gXmSlM > h2:nth-child(1)");
    public static final By voltarPgInicial = By.cssSelector(".sc-ftvSup > div:nth-child(1) > div:nth-child(1) > h2:nth-child(2)");
    public static final By btnMinhasContribuicoes = By.cssSelector("#minhasContribuições");

    public String msgBtnContribuir(){
        return BaseTest.getText(btnContribuir);
    }

    public void clicarBtnMinhasContribuicoes(){
        BaseTest.click(btnMinhasContribuicoes);
        BaseTest.esperarTempo();
    }
    public void clicarVoltarHomePage(){
        BaseTest.click(voltarPgInicial);
    }
    public void clicarBtnCancelarContribuicao(){
        BaseTest.click(btnCancelarConfirmacao);
    }

    public void clicarfora(){
        BaseTest.click(clicarForaDoCampo);
    }
    public String validarMsgBtnEditarCampanha(){
        return BaseTest.getText(btnEditarCampanha);
    }
    public String validarMsgTitulo(){
        return BaseTest.getText(titulo);
    }
    public void clicarCampoValor(){
        BaseTest.click(campoValorContribuicao);
    }
    public String validarMsgCampoObrigatorio(){
        return BaseTest.getText(msgCampoObrigatorio);
    }
    public String confirmarMsgContribuicao(){
        return BaseTest.getText(btnContribuir);
    }
    public void clicarBtnContribuir(){
        BaseTest.click(btnContribuir);
    }
    public void clicarBtnEnviarContribuicao(){
        BaseTest.click(btnEnviarContribuicao);
    }
    public void preencherValorContribuicao(){
        BaseTest.sendKeys(campoValorContribuicao, "100");
    }
    public void clicarBtnConfirmarContribuicao(){
        BaseTest.click(btnConfirmarContribuicao);
    }
    public void clicarBtnEditarCampanha(){
        BaseTest.click(btnEditarCampanha);
    }
    public void clicarBtnVerContribuicoes(){
        BaseTest.click(btnVerContribuicoes);
    }
    public String validarMsgBtnContribuicoes(){
        return BaseTest.getText(btnVerContribuicoes);
    }
    public String validarMsgContribuidores(){
        return BaseTest.getText(msgContribuidores);
    }
}