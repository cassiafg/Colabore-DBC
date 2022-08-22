package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoginPage {
    public static final By campoEmail = By.id("email");
    public static final By campoSenha = By.id("senha");
    public static final By btnEntrar = By.cssSelector("#entrar");
    public static final By btnNaoPossuoCadastro = By.id("signup");
    public static final By msgErrorEmail = By.cssSelector(".sc-cTQhss");
    public static final By msgErrorPassword = By.cssSelector(".sc-efBctP > div:nth-child(2) > p:nth-child(3)");



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
