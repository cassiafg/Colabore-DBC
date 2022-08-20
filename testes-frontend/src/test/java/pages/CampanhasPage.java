package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CampanhasPage {
    public static final By btnCriarCampanha = By.cssSelector(".hQHueP");
    public static final By btnTodasCampanhas = By.cssSelector("button.sc-ftvSup:nth-child(1)");
    public static final By btnMetaAtingida = By.cssSelector("button.iXawTx:nth-child(3)");
    public static final By btnMetaNaoAtingida = By.cssSelector("button.iXawTx:nth-child(3)");
    public static final By btnMinhasCampanhas = By.cssSelector(".sc-idiyUo > button:nth-child(1)");
    public static final By btnMinhasContribuicaoes = By.cssSelector(".sc-idiyUo > button:nth-child(2)");
    public static final By btnLogout = By.cssSelector(".gJmKvi");
    public static final By img = By.cssSelector("#root > header.sc-iBkjds.iPQPCF > div > div:nth-child(2) > img");


    public String validarBtnCriarCampanha(){
        return BaseTest.getText(btnCriarCampanha);
    }
    public String validarBtnMinhasCampanhas() { return BaseTest.getText(btnMinhasCampanhas);}
}
