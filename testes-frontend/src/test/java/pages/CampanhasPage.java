package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;

public class CampanhasPage {
    public static final By btnCriarCampanha = By.cssSelector("#criarCampanha");
    public static final By btnTodasCampanhas = By.id("todasCampanhas");
    public static final By btnMetaAtingida = By.id("metaAtingida");
    public static final By btnMetaNaoAtingida = By.id("metaNaoAtingida");
    public static final By btnMinhasCampanhas = By.id("minhasCampanhas");
    public static final By btnMinhasContribuicaoes = By.id("minhasContribuicoes");
    public static final By btnLogout = By.id("logout");
    public static final By btnVerDetalhes = By.cssSelector("#verDetalhes");
    public static final By msgMinhasCampanhas = By.cssSelector(".sc-bczRLJ");
    public static final By msgNenhumaCampanha = By.cssSelector(".sc-ksZaOG > h1:nth-child(2)");
    public static final By btnCampanhasAbertas = By.cssSelector("#campanhasAbertas");
    public static final By msgMetaAtingida = By.cssSelector(".sc-bczRLJ");
    public static final By msgMetaNaoAtingida = By.cssSelector(".sc-bczRLJ");
    public static final By campoPesquisarTag = By.cssSelector("#tags");
    public static final By msgTag = By.cssSelector("span.dKZeFP:nth-child(2) > span:nth-child(1)");

    public String msgTag(){
        return BaseTest.getText(msgTag);
    }
    public void preencherTag(){
        BaseTest.sendKeys(campoPesquisarTag, "tag2");
        BaseTest.sendKeys(campoPesquisarTag, String.valueOf(Keys.ENTER));
    }
    public String validarMsgMetaNaoAtingida(){
        return BaseTest.getText(msgMetaNaoAtingida);
    }
    public void clicarBtnCampanhasAbertas(){
        BaseTest.click(btnCampanhasAbertas);
        BaseTest.esperarTempo();
    }
    public void clicarBtnMetaNaoAtingida(){
        BaseTest.click(btnMetaNaoAtingida);
    }

    public String validarMsgMetaAtingida(){
        return BaseTest.getText(msgMetaAtingida);
    }
    public void clicarBtnMetaAtingida(){
        BaseTest.click(btnMetaAtingida);
        BaseTest.esperarTempo();
    }
    public String validarBtnCriarCampanha(){
        return BaseTest.getText(btnCriarCampanha);
    }
    public String validarBtnMinhasCampanhas() { return BaseTest.getText(btnMinhasCampanhas);}
    public void clicarBtnCriarCampanha(){
        BaseTest.click(btnCriarCampanha);
    }
    public void clicarBtnMinhasCampanhas(){ BaseTest.click(btnMinhasCampanhas);}
    public void clicarBtnVerDetalhes(){
        BaseTest.click(btnVerDetalhes);
    }
    public String validarMsgMinhasCampanhas(){
        return BaseTest.getText(msgMinhasCampanhas);
    }
    public String validarMsgNenhumaCampanha(){
        return BaseTest.getText(msgNenhumaCampanha);
    }

}
