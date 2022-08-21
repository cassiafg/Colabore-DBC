package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.DetalheCampanhaPage;
import pages.UpdateCampanhaPage;
import util.Browser;

public class UpdateCampanhaSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    CreateCampanhaSteps createCampanhaSteps = new CreateCampanhaSteps();
    CampanhasPage campanhasPage = new CampanhasPage();
    UpdateCampanhaPage updateCampanhaPage = new UpdateCampanhaPage();
    DetalheCampanhaPage detalheCampanhaPage = new DetalheCampanhaPage();
    @Test
    public void editarCampanhaComSucesso(){
        //logar
        loginSteps.realizarLoginComSucesso();
        //criar campanha
//        createCampanhaSteps.criarCampanhaComSucesso();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhesMinhasCamp();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.preencherTitulo();
        updateCampanhaPage.preencherQntdMeta();
        updateCampanhaPage.selecionarConcl();
        updateCampanhaPage.preencherDataLimite();
        updateCampanhaPage.preencherTag();
        updateCampanhaPage.preencherDescricao();
        updateCampanhaPage.enviarFoto();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }
}
