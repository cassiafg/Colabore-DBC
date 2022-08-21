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
        public static final By foto = By.cssSelector(".sc-ikZpkk > div:nth-child(5) > section:nth-child(2) > div:nth-child(1)");
        public static final By btnAtualizarCampanha = By.cssSelector("button.sc-ftvSup:nth-child(6)");

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
        public void preencherDataLimite(){
            BaseTest.sendKeys(dataLimite, "30112022");
        }
        public void preencherTag(){
            BaseTest.sendKeys(tags, "tag");
            BaseTest.sendKeys(tags, String.valueOf(Keys.ENTER));
        }

        public void preencherDescricao(){
            BaseTest.sendKeys(campoDescricao, "teste");
        }

        public void enviarFoto(){
            BaseTest.sendKeys(foto,"C:\\Colabore-DBC\\testes-frontend\\teste1.png");
        }

        public void clicarBtnAtualizar(){
            BaseTest.click(btnAtualizarCampanha);
        }
    }
