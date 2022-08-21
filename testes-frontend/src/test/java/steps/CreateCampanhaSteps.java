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

    @Test
    public void criarCampanhaComSucesso(){
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
        createCampanhaPage.preencherDescricao();
        createCampanhaPage.enviarFoto();
        //clicar em cadastrar
        createCampanhaPage.clicarBtnCadastrar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }
}
