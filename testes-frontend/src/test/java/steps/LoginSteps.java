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
        Assert.assertEquals(loginPage.validarMsgErrorPassword(), "Mínimo de 8 caractéres");
    }

    @Test
    public void realizarLoginEmailInvalido(){
        //Preencher dados de login
        loginPage.preencherEmailInvalido();
        loginPage.preencherSenhaValida();
        loginPage.clicarBtnEntrar();
        //Validações
        Assert.assertEquals(loginPage.validarMsgErrorEmail(), "O email deve conter: @dbccompany.com.br");
    }

    @Test
    public void realizarLoginCamposEmBranco(){
        //Não preencher dados de login
        loginPage.clicarBtnEntrar();
        //Validações
        Assert.assertEquals(loginPage.validarMsgErrorPassword(), "Campo obrigatório!");
        Assert.assertEquals(loginPage.validarMsgErrorEmail(), "Campo obrigatório!");
    }

    @Test
    public void realizarLoginMetaAtingida(){
        loginPage.preencherEmailMetaAtingida();
        loginPage.preencherSenhaMetaAtingida();
        loginPage.clicarBtnEntrar();
    }
}
