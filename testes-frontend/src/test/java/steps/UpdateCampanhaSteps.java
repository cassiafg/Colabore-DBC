package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CampanhasPage;
import pages.DetalheCampanhaPage;
import pages.UpdateCampanhaPage;
import util.Browser;

public class UpdateCampanhaSteps extends Browser {
    CreateCampanhaSteps createCampanhaSteps = new CreateCampanhaSteps();
    CampanhasPage campanhasPage = new CampanhasPage();
    UpdateCampanhaPage updateCampanhaPage = new UpdateCampanhaPage();
    DetalheCampanhaPage detalheCampanhaPage = new DetalheCampanhaPage();
    CampanhasSteps campanhasSteps = new CampanhasSteps();
    @Test
    public void editarTituloDaCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.preencherTitulo();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void editarDescricaoDaCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.preencherDescricao();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void editarMetaDaCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.preencherQntdMeta();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }
    @Test
    public void editarOpcaoEncerrarCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.selecionarConcl();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void editarFotoComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.enviarFoto();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    //não é possível editar meta
    @Test
    public void editarTodosOsCamposComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.preencherTitulo();
        updateCampanhaPage.preencherQntdMeta();
        updateCampanhaPage.selecionarConcl();
        updateCampanhaPage.preencherDataLimite();
        updateCampanhaPage.enviarFoto();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void excluirCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.clicarBtnExcluir();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void excluirCampanhaSemSucesso(){
        //criar campanha
        campanhasSteps.listarCampanhasMetaAtingida();
        //preencher todos os dados
        campanhasPage.clicarBtnVerDetalhes();

        //clicar em atualizar campanha
//        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(detalheCampanhaPage.validarMsgBtnContribuicoes(), "Ver Contribuições");
    }

        @Test
        public void adicionarTagDaCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComFoto();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.preencherTag();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }

    @Test
    public void excluirTagDaCampanhaComSucesso(){
        //criar campanha
        createCampanhaSteps.criarCampanhaComSucessoComDuasTags();
        //selecionar campanha
        campanhasPage.clicarBtnMinhasCampanhas();
        campanhasPage.clicarBtnVerDetalhes();
        detalheCampanhaPage.clicarBtnEditarCampanha();;
        //preencher todos os dados
        updateCampanhaPage.clicarExcluirTag();
        //clicar em atualizar campanha
        updateCampanhaPage.clicarBtnAtualizar();
        //validações
        Assert.assertEquals(campanhasPage.validarBtnMinhasCampanhas(), "Minhas Campanhas");
    }
}
