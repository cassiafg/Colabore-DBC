package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoginPage {
    public static final By campoEmail = By.cssSelector("#root > div.sc-gicCDI.eeGsbF > div:nth-child(2) > form > div > div:nth-child(1) > input");
    public static final By campoSenha = By.cssSelector("#root > div.sc-gicCDI.eeGsbF > div:nth-child(2) > form > div > div:nth-child(2) > input[type=password]");
    public static final By btnEntrar = By.cssSelector("#root > div.sc-gicCDI.eeGsbF > div:nth-child(2) > form > div > button");
    public static final By btnNaoPossuoCadastro = By.cssSelector("#root > div.sc-gicCDI.eeGsbF > div:nth-child(2) > small");
    public static final By msgErrorEmail = By.cssSelector("#root > div.sc-gicCDI.eeGsbF > div:nth-child(2) > form > div > div:nth-child(1) > p");
    public static final By msgErrorPassword = By.cssSelector("#root > div.sc-gicCDI.eeGsbF > div:nth-child(2) > form > div > div:nth-child(2) > p");


    public void preencherEmailValido(){
        BaseTest.sendKeys(campoEmail,"testeteste5@dbccompany.com.br");
    }
    public void preencherEmailInvalido(){
        BaseTest.sendKeys(campoEmail, "@");
    }
    public void preencherSenhaInvalida(){
        BaseTest.sendKeys(campoSenha, "1");
    }
    public void preencherSenhaValida(){
        BaseTest.sendKeys(campoSenha, "TesteTeste5*");
    }
    public void clicarBtnEntrar(){
        BaseTest.click(btnEntrar);
    }
    public void clicarBtnNaoPossuoCadastro(){
        BaseTest.click(btnNaoPossuoCadastro);
    }
    public String validarMsgErrorEmail(){
        return BaseTest.getText(msgErrorEmail);
    }
    public String validarMsgErrorPassword(){
        return BaseTest.getText(msgErrorPassword);
    }

}
