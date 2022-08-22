package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.DetalheCampanhaPage;
import util.BaseTest;
import util.Browser;

public class DetalhesCampanhaSteps extends Browser {

    CampanhasPage campanhasPage = new CampanhasPage();
    CampanhasSteps campanhasSteps = new CampanhasSteps();
    DetalheCampanhaPage detalheCampanhaPage = new DetalheCampanhaPage();

    @Test
    public void exibirUsuariosQueContribuiram(){
        campanhasSteps.selecionarMinhasCampanhasMetaNaoAtingida();
        detalheCampanhaPage.clicarBtnVerContribuicoes();
        Assert.assertEquals(detalheCampanhaPage.validarMsgContribuidores(), "Contribuidores");
    }

    @Test
    public void selecionarEditarCampanhaComSucesso(){
        campanhasSteps.selecionarMinhasCampanhasMetaNaoAtingida();
        detalheCampanhaPage.clicarBtnEditarCampanha();
        Assert.assertEquals(detalheCampanhaPage.validarMsgTitulo(), "Atualizar campanha");
    }

    @Test
    public void selecionarEditarCampanhaSemSucesso(){
        campanhasSteps.listarCampanhasMetaAtingida();
        campanhasPage.clicarBtnVerDetalhes();
        Assert.assertEquals(detalheCampanhaPage.validarMsgBtnContribuicoes(), "Ver Contribuições");

    }

    @Test
    public void contribuirComSucesso(){
        campanhasSteps.listarCampanhasAbertas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnContribuir();
        detalheCampanhaPage.preencherValorContribuicao();
        detalheCampanhaPage.clicarBtnEnviarContribuicao();
        detalheCampanhaPage.clicarBtnConfirmarContribuicao();
        Assert.assertEquals(detalheCampanhaPage.confirmarMsgContribuicao(), "Cancelar");
    }

    @Test
    public void contribuirSemInformarValor(){
        campanhasSteps.listarCampanhasAbertas();
        BaseTest.esperarTempo();
        BaseTest.esperarTempo();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnContribuir();
        detalheCampanhaPage.clicarCampoValor();
        detalheCampanhaPage.clicarfora();
        detalheCampanhaPage.clicarBtnEnviarContribuicao();
        Assert.assertEquals(detalheCampanhaPage.validarMsgCampoObrigatorio(), "Campo obrigatório!");
    }

    @Test
    public void contribuirSemConfirmarContribuicao(){
        campanhasSteps.listarCampanhasAbertas();
        BaseTest.esperarTempo();
        BaseTest.esperarTempo();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnContribuir();
        detalheCampanhaPage.preencherValorContribuicao();
        detalheCampanhaPage.clicarBtnEnviarContribuicao();
        detalheCampanhaPage.clicarBtnCancelarContribuicao();
        Assert.assertEquals(detalheCampanhaPage.validarMsgBtnContribuicoes(), "Ver Contribuições");
    }

    @Test
    public void cancelarContribuicaoAntesDeFinalizar(){
        campanhasSteps.listarCampanhasAbertas();
        BaseTest.esperarTempo();
        BaseTest.esperarTempo();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnContribuir();
        detalheCampanhaPage.preencherValorContribuicao();
        detalheCampanhaPage.clicarBtnContribuir();
        Assert.assertEquals(detalheCampanhaPage.validarMsgBtnContribuicoes(), "Ver Contribuições");
    }

    @Test
    public void contribuirNovamenteComSucesso(){
        contribuirComSucesso();
        detalheCampanhaPage.clicarVoltarHomePage();
        detalheCampanhaPage.clicarBtnMinhasContribuicoes();
        campanhasPage.clicarBtnVerDetalhes();
        Assert.assertEquals(detalheCampanhaPage.msgBtnContribuir(), "Doar Novamente");
    }
}
