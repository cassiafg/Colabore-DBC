package pages;

import org.openqa.selenium.By;

public class CreateCampanhaPage {
    public static final By campoTitulo = By.id("titulo");
    public static final By campoQntdMeta = By.id("meta");
    public static final By selectConcl = By.id("select");
    public static final By dataLimite = By.id("data");
    public static final By nomeTag = By.id("nomeTag");
    public static final By campoDescricao = By.id("descricao");
    public static final By foto = By.cssSelector(".sc-kLLXSd > div:nth-child(5) > section:nth-child(2) > div:nth-child(1)");
    public static final By btnCadastrarCampanha = By.cssSelector("button.sc-ftvSup:nth-child(6)");
}
