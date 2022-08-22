package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.CreateUserPage;
import pages.LoginPage;
import util.Browser;

public class CreateUserSteps extends Browser {
    LoginPage loginPage = new LoginPage();
    CreateUserPage createUserPage = new CreateUserPage();
    CampanhasPage campanhasPage = new CampanhasPage();


    @Test
    public void criarUsuarioComSucessoSemFoto(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.preencherEmailValido();
        createUserPage.preencherSenhaValida();
        createUserPage.confirmarSenhaValida();
        //Clicar botão cadastrar
        createUserPage.clicarBtnCadastrar();
        //Validação
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void criarUsuarioComSucessoComFoto(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.preencherEmailValido();
        createUserPage.preencherSenhaValida();
        createUserPage.confirmarSenhaValida();
        createUserPage.enviarFoto();
        //Clicar botão cadastrar
        createUserPage.clicarBtnCadastrar();
        //Validação
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void criarUsuarioEmailInvalido(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.preencherEmailInvalido();
        createUserPage.preencherSenhaValida();
        createUserPage.confirmarSenhaValida();
        //Clicar botão cadastrar
        createUserPage.clicarBtnCadastrar();
        //Validação
        Assert.assertEquals(createUserPage.validarMsgErrorEmail(), "O email deve conter: @dbccompany.com.br");
    }

    @Test
    public void criarUsuarioSemInformarEmail(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.clicarCampoEmail();
        createUserPage.preencherSenhaValida();
        createUserPage.confirmarSenhaValida();
        //Clicar botão cadastrar
        createUserPage.clicarBtnCadastrar();
        //Validação
        Assert.assertEquals(createUserPage.validarMsgErrorEmail(), "Campo obrigatório!");
    }

    @Test
    public void criarUsuarioSenhaFraca(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.preencherEmailValido();
        createUserPage.preencherSenhaFraca();
        createUserPage.confirmarSenhaFraca();
        //Clicar botão cadastrar
        createUserPage.clicarBtnCadastrar();
        //Validação
        Assert.assertEquals(createUserPage.validarMsgSenhaFraca(), "FORÇA DA SENHA: FRACA");
    }

    @Test
    public void criarUsuarioConfirmandoSenhaDiferente(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.preencherEmailValido();
        createUserPage.preencherSenhaValida();
        createUserPage.confirmarSenhaDiferente();
        createUserPage.clicarFora();
        //Validação
        Assert.assertEquals(createUserPage.validarMsgSenhasIguais(), "As senhas precisam ser iguais.");
    }

    @Test
    public void criarUsuarioSemConfirmarSenha(){
        //Clicar em não possuo cadastro
        loginPage.clicarBtnNaoPossuoCadastro();
        //Preencher dados
        createUserPage.preencherNomeValido();
        createUserPage.preencherEmailValido();
        createUserPage.preencherSenhaValida();
        createUserPage.clicarConfirmarSenha();
        createUserPage.clicarFora();
        //Clicar botão cadastrar
        createUserPage.clicarBtnCadastrar();
        //Validação
        Assert.assertEquals(createUserPage.validarMsgErrorEmail(), "Campo obrigatório!");
    }
}
