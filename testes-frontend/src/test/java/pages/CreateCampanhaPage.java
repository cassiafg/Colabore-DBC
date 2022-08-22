package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;

public class CreateCampanhaPage {
    public static final By campoTitulo = By.id("titulo");
    public static final By campoQntdMeta = By.id("meta");
    public static final By selectConcl = By.id("select");
    public static final By dataLimite = By.cssSelector("#dataLimite");
    public static final By tags = By.cssSelector("#tags");
    public static final By campoDescricao = By.cssSelector("#descricao");
    public static final By foto = By.cssSelector(".sc-cCsOjp > div:nth-child(5) > section:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
    public static final By btnCadastrarCampanha = By.cssSelector("button.sc-papXJ:nth-child(6)");
    public static final By msgCampoObrigatorioDescricao = By.cssSelector(".sc-bZkfAO");
    public static final By msgCampoObrSelecConcl = By.cssSelector(".sc-cCsOjp > div:nth-child(2) > div:nth-child(1) > p:nth-child(3)");
    public static final By msgTitulo = By.cssSelector(".sc-cCsOjp > div:nth-child(1) > div:nth-child(1) > p:nth-child(3)");
    public static final By msgFora = By.cssSelector(".sc-cCsOjp > div:nth-child(5) > label:nth-child(1)");
    public static final By msgDataLimite = By.cssSelector(".sc-cCsOjp > div:nth-child(2) > div:nth-child(2) > p:nth-child(3)");
    public static final By msgErroMeta = By.cssSelector(".sc-cCsOjp > div:nth-child(1) > div:nth-child(2) > p:nth-child(3)");

    public String validarMsgMeta(){
        return BaseTest.getText(msgErroMeta);
    }
    public void clicarMeta(){
        BaseTest.click(campoQntdMeta);
    }
    public void clicarData(){
        BaseTest.click(dataLimite);
    }
    public String validarMsgDataLimite(){
        return BaseTest.getText(msgDataLimite);
    }
    public void preencherTitulo(){
        BaseTest.sendKeys(campoTitulo, "titulo teste");
    }
    public void preencherQntdMeta(){
        BaseTest.sendKeys(campoQntdMeta, "10000");
    }
    public void selecionarConcl(){
        BaseTest.click(selectConcl);
        BaseTest.sendKeys(selectConcl, "s");
        BaseTest.click(selectConcl);
    }
    public void clicarFora(){
        BaseTest.click(msgFora);
    }
    public void preencherDataLimite(){
        BaseTest.sendKeys(dataLimite, "30112022");
    }
    public void preencherTag(){
        BaseTest.sendKeys(tags, "tag");
        BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
    }
    public void preencherTag2(){
        BaseTest.sendKeys(tags, "tag2");
        BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
    }
    public void preencherTag3(){
        BaseTest.sendKeys(tags, "tag3");
        BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
    }
    public void preencherTag4(){
        BaseTest.sendKeys(tags, "tag4");
        BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
    }
    public void preencherTag5(){
        BaseTest.sendKeys(tags, "tag5");
        BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
    }
    public void preencherDescricao(){
        BaseTest.sendKeys(campoDescricao, "teste");
    }
    public void enviarFoto(){
        BaseTest.sendKeys(foto,"C:\\Colabore-DBC\\testes-frontend\\image\\image.jpg");
    }
    public void clicarBtnCadastrar(){
        BaseTest.click(btnCadastrarCampanha);
    }
    public void clicarDescricao(){ BaseTest.click(campoDescricao);}
    public String validarMsgCampoObrigatorio(){
        return BaseTest.getText(msgCampoObrigatorioDescricao);
    }
    public String validarMsgSelecionarConcluir(){
        return BaseTest.getText(msgCampoObrSelecConcl);
    }
    public void clicarSelecionar(){
        BaseTest.click(selectConcl);
    }
    public String validarMsgTitulo(){
        return BaseTest.getText(msgTitulo);
    }
    public void clicarTitulo(){
        BaseTest.click(campoTitulo);
    }
    public void clicarTag() { BaseTest.click(tags); }
}
