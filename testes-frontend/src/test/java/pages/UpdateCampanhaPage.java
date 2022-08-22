package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;
public class UpdateCampanhaPage {
        public static final By campoTitulo = By.id("titulo");
        public static final By campoQntdMeta = By.id("meta");
        public static final By selectConcl = By.id("select");
        public static final By dataLimite = By.cssSelector("#dataLimite");
        public static final By tags = By.cssSelector("#tags");
        public static final By campoDescricao = By.cssSelector("#descricao");
        public static final By foto = By.cssSelector(".sc-cCsOjp > div:nth-child(5) > section:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
        public static final By btnAtualizarCampanha = By.cssSelector("button.sc-papXJ:nth-child(6)");
        public static final By btnExcluir = By.cssSelector("button.sc-papXJ:nth-child(7)");
        public static final By msgCampanhaConcluida = By.cssSelector(".finished > div:nth-child(1) > h3:nth-child(1)");
        public static final By excluirTag = By.cssSelector(".sc-ciZhAO > div:nth-child(3) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1)");

        public void clicarExcluirTag(){
            BaseTest.click(excluirTag);
        }
        public String validarMsgConcluida(){
            return BaseTest.getText(msgCampanhaConcluida);
        }
        public void clearTitulo(){
            for(int i =0; i<20;i++){
            BaseTest.backspace(campoTitulo);
        }}

        public void clearQntMeta(){
        for(int i =0; i<20;i++){
            BaseTest.backspace(campoQntdMeta);
        }}
    public void clearDescricao(){
        for(int i =0; i<20;i++){
            BaseTest.backspace(campoDescricao);
        }}
    public void clicarBtnExcluir(){
            BaseTest.click(btnExcluir);
    }
        public void preencherTitulo(){
            BaseTest.click(campoTitulo);
            clearTitulo();
            BaseTest.sendKeys(campoTitulo, "titulo editado");
        }
        public void clearMeta(){
            BaseTest.clear(campoQntdMeta);
        }
        public void preencherQntdMeta(){
            BaseTest.click(campoQntdMeta);
            clearQntMeta();
            BaseTest.sendKeys(campoQntdMeta, "5000");
        }
        public void selecionarConcl(){
            BaseTest.click(selectConcl);
            BaseTest.sendKeys(selectConcl, "n");
            BaseTest.click(selectConcl);
        }
        public void clearDataLimite(){
            BaseTest.clear(dataLimite);
        }
        public void preencherDataLimite(){
            BaseTest.sendKeys(dataLimite, "01012023");
        }
        public void preencherTag(){
            BaseTest.sendKeys(tags, "tagEdit");
            BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
            BaseTest.esperarTempo();
        }

        public void preencherDescricao(){
            BaseTest.click(campoDescricao);
            clearDescricao();
            BaseTest.sendKeys(campoDescricao, "editado");
        }

        public void enviarFoto(){
            BaseTest.sendKeys(foto,"C:\\Colabore-DBC\\testes-frontend\\image\\image.jpg");
        }

        public void clicarBtnAtualizar(){
            BaseTest.click(btnAtualizarCampanha);
        }
    }
