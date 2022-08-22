package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.DetalheCampanhaPage;
import util.Browser;

public class CampanhasSteps extends Browser {
    CreateCampanhaSteps createCampanhaSteps = new CreateCampanhaSteps();
    CampanhasPage campanhasPage = new CampanhasPage();
    CreateUserSteps createUserSteps = new CreateUserSteps();
    DetalheCampanhaPage detalheCampanhaPage = new DetalheCampanhaPage();

    @Test
    public void listarMinhasCampanhasUsuarioComCampanhas(){
        createCampanhaSteps.criarCampanhaComSucessoSemFoto();
        campanhasPage.clicarBtnMinhasCampanhas();
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void listarMinhasCampanhasUsuarioSemCampanhas(){
        createUserSteps.criarUsuarioComSucessoSemFoto();
        campanhasPage.clicarBtnMinhasCampanhas();
        Assert.assertEquals(campanhasPage.validarMsgNenhumaCampanha(), "Nenhuma campanha foi encontrada.");
    }

    @Test
    public void selecionarMinhasCampanhasMetaNaoAtingida(){
        listarMinhasCampanhasUsuarioComCampanhas();
        campanhasPage.clicarBtnMetaNaoAtingida();
        campanhasPage.clicarBtnVerDetalhes();
        Assert.assertEquals(detalheCampanhaPage.validarMsgBtnContribuicoes(), "Ver Contribuições");
    }

    @Test
    public void selecionarMinhasCampanhasMetaAtingida(){
        createCampanhaSteps.criarCampanhaComSucessoSemFoto();
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnMetaAtingida();
        campanhasPage.clicarBtnVerDetalhes();
        Assert.assertEquals(detalheCampanhaPage.validarMsgBtnContribuicoes(), "Ver Contribuições");
    }

    @Test
    public void listarCampanhasAbertas(){
        createUserSteps.criarUsuarioComSucessoSemFoto();
        campanhasPage.clicarBtnCampanhasAbertas();
        Assert.assertEquals(campanhasPage.validarMsgMinhasCampanhas(), "Campanhas Abertas");
    }

    @Test
    public void listarCampanhasMetaAtingida(){
        createUserSteps.criarUsuarioComSucessoSemFoto();
        campanhasPage.clicarBtnMetaAtingida();
        Assert.assertEquals(campanhasPage.validarMsgMetaAtingida(), "Meta Atingida");
    }

    @Test
    public void listarCampanhasMetaNaoAtingida(){
        createUserSteps.criarUsuarioComSucessoSemFoto();
        campanhasPage.clicarBtnMetaNaoAtingida();
        Assert.assertEquals(campanhasPage.validarMsgMetaNaoAtingida(), "Meta Não Atingida");
    }

    @Test
    public void listarMinhasCampanhasMetaNaoAtingida(){
        createCampanhaSteps.criarCampanhaComSucessoSemFoto();
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnMetaNaoAtingida();
        Assert.assertEquals(campanhasPage.validarMsgMetaNaoAtingida(), "Meta Não Atingida");
    }

    @Test
    public void listarMinhasCampanhasMetaAtingida(){
        createCampanhaSteps.criarCampanhaComSucessoSemFoto();
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnMetaAtingida();
        Assert.assertEquals(campanhasPage.validarMsgMetaAtingida(), "Meta Atingida");
    }

    @Test
    public void listarCampanhaPorTag(){
        createCampanhaSteps.criarCampanhaComSucessoComDuasTags();
        campanhasPage.preencherTag();
        campanhasPage.clicarBtnVerDetalhes();
        Assert.assertEquals(campanhasPage.msgTag(), "Categoria:");
    }


}
