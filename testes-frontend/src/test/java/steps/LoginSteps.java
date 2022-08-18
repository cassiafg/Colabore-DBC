package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.LoginPage;
import util.Browser;

public class LoginSteps extends Browser {
    LoginPage loginPage = new LoginPage();
    CampanhasPage campanhasPage = new CampanhasPage();

    @Test
    public void realizarLoginComSucesso(){
        //Preencher dados de login
        loginPage.preencherEmailValido();
        loginPage.preencherSenhaValida();
        loginPage.clicarBtnEntrar();
        //Validações
        Assert.assertEquals(campanhasPage.validarBtnCriarCampanha(), "Criar campanha");
    }

    @Test
    public void realizarLoginSenhaInvalida(){
        //Preencher dados de login
        loginPage.preencherEmailValido();
        loginPage.preencherSenhaInvalida();
        loginPage.clicarBtnEntrar();
        //Validações
        Assert.assertEquals(loginPage.validarMsgErrorPassword(), "Mínimo de 2 caractéres");
    }

    @Test
    public void realizarLoginEmailInvalido(){
        //Preencher dados de login
        loginPage.preencherEmailInvalido();
        loginPage.preencherSenhaValida();
        loginPage.clicarBtnEntrar();
        //Validações
        Assert.assertEquals(loginPage.validarMsgErrorEmail(), "Mínimo de 2 caractéres");
    }
}
