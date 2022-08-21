package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CampanhasPage {
    public static final By btnCriarCampanha = By.cssSelector("#criarCampanha");
    public static final By btnTodasCampanhas = By.id("todasCampanhas");
    public static final By btnMetaAtingida = By.id("metaAtingida");
    public static final By btnMetaNaoAtingida = By.id("metaNaoAtingida");
    public static final By btnMinhasCampanhas = By.id("minhasCampanhas");
    public static final By btnMinhasContribuicaoes = By.id("minhasContribuicoes");
    public static final By btnLogout = By.id("logout");
    public static final By img = By.cssSelector("#root > header.sc-iBkjds.iPQPCF > div > div:nth-child(2) > img");
    public static final By btnVerDetalhesMinhasCamp = By.cssSelector("#verDetalhes");
    public static final By btnVerDetalhesCampAbertas = By.cssSelector("div.sc-evZas:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)");
    public static final By msgCampanhaCadastrada = By.cssSelector("div.Toastify:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)");

    public String validarBtnCriarCampanha(){
        return BaseTest.getText(btnCriarCampanha);
    }
    public String validarBtnMinhasCampanhas() { return BaseTest.getText(btnMinhasCampanhas);}
    public void clicarBtnCriarCampanha(){
        BaseTest.click(btnCriarCampanha);
    }
    public void clicarBtnMinhasCampanhas(){ BaseTest.click(btnMinhasCampanhas);}
    public void clicarBtnVerDetalhesMinhasCamp(){
        BaseTest.click(btnVerDetalhesMinhasCamp);
    }
    public String validarMsgCampanhaCadastrada(){
        return BaseTest.getText(msgCampanhaCadastrada);
    }

}
