package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CampanhasPage {
    public static final By btnCriarCampanha = By.cssSelector("#root > section > div.sc-idiyUo.kmRLRa > button");
    public static final By btnMinhasCampanhas = By.cssSelector("#root > section > div.sc-bjUoiL.bUmMpf > button:nth-child(1)");

    public String validarBtnCriarCampanha(){
        return BaseTest.getText(btnCriarCampanha);
    }
    public String validarBtnMinhasCampanhas() { return BaseTest.getText(btnMinhasCampanhas);}
}
