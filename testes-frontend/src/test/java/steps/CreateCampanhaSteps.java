package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.CreateCampanhaPage;
import util.Browser;

public class CreateCampanhaSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    CampanhasPage campanhasPage = new CampanhasPage();
    CreateCampanhaPage createCampanhaPage = new CreateCampanhaPage();
    CreateUserSteps createUserSteps = new CreateUserSteps();

    @Test
    public void criarCampanhaComSucessoComFoto(){
        //criar usuário e logar com sucesso
        createUserSteps.criarUsuarioComSucessoComFoto();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void criarCampanhaComSucessoSemFoto(){
        //login com sucesso
        createUserSteps.criarUsuarioComSucessoComFoto();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherDescricao();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void criarCampanhaComSucessoComDuasTags(){
        //criar usuário e logar com sucesso
        createUserSteps.criarUsuarioComSucessoComFoto();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherTag2();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void criarCampanhaComSucessoComCincoTags(){
        //criar usuário e logar com sucesso
        createUserSteps.criarUsuarioComSucessoComFoto();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherTag2();
        createCampanhaPage.preencherTag3();
        createCampanhaPage.preencherTag4();
        createCampanhaPage.preencherTag5();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }
    @Test
    public void criarCampanhaSemMeta(){
        //criar usuário e logar com sucesso
        createUserSteps.criarUsuarioComSucessoComFoto();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.clicarMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgMeta(), "Campo obrigatório!");
    }
    @Test
    public void criarCampanhaSemDataLimite(){
        //login com sucesso
        createUserSteps.criarUsuarioComSucessoComFoto();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.clicarData();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherDescricao();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgDataLimite(), "Campo obrigatório");
    }

    @Test
    public void criarCampanhaSemDescricao(){
        //login com sucesso
        loginSteps.realizarLoginComSucesso();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.clicarDescricao();
        createCampanhaPage.clicarFora();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgCampoObrigatorio(), "Campo obrigatório!");
    }

    @Test
    public void criarCampanhaSemTag(){
        //login com sucesso
        loginSteps.realizarLoginComSucesso();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.clicarTag();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgCampoObrigatorio(), "Campo obrigatório!");
    }

    @Test
    public void criarCampanhaSemSelecionarOpcaoConcluir(){
        //login com sucesso
        loginSteps.realizarLoginComSucesso();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.preencherTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.clicarSelecionar();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgSelecionarConcluir(), "Escolha uma opção válida!");
    }

    @Test
    public void criarCampanhaSemPreencherNenhumCampo(){
        //login com sucesso
        loginSteps.realizarLoginComSucesso();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.clicarSelecionar();
        createCampanhaPage.clicarDescricao();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgSelecionarConcluir(), "Escolha uma opção válida!");
    }

    @Test
    public void criarCampanhaSemTitulo(){
        //login com sucesso
        loginSteps.realizarLoginComSucesso();
        //clicar em criar campanha
        campanhasPage.clicarBtnCriarCampanha();
        //preencher todos os dados
        createCampanhaPage.clicarTitulo();
        createCampanhaPage.preencherQntdMeta();
        createCampanhaPage.selecionarConcl();
        createCampanhaPage.preencherDataLimite();
        createCampanhaPage.preencherTag();
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(createCampanhaPage.validarMsgTitulo(), "Campo obrigatório!");
    }
}
