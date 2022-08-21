package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import util.BaseTest;

public class CreateUserPage {
    public static final By campoNome = By.id("nome");
    public static final By campoEmail = By.id("email");
    public static final By campoSenha = By.id("senha");
    public static final By campoConfirmarSenha = By.cssSelector("#confirmarSenha");
    public static final By btnCadastrar = By.id("cadastrar");
    public static final By campoFoto = By.id("foto");
    public static final By msgErrorEmail = By.cssSelector("#root > div.sc-hHLeRK.emTNlk > div:nth-child(1) > form > div > div:nth-child(1) > div:nth-child(2) > p");
    public static final By msgSenhaFraca = By.cssSelector("#root > div.sc-hHLeRK.emTNlk > div:nth-child(1) > form > div > div:nth-child(2) > div:nth-child(1) > div.password-strength-meter > p > p");
    public static final By msgSenhasIguais = By.cssSelector("#root > div.sc-hHLeRK.emTNlk > div:nth-child(1) > form > div > div:nth-child(2) > div:nth-child(2) > p");

    Faker faker = new Faker();

    private String nome = faker.name().name();
    private String email = faker.name().username()+"@dbccompany.com.br";
    private String senha = "Testeteste5*";

    public void preencherNomeValido(){
        BaseTest.sendKeys(campoNome, nome);
    }
    public void preencherEmailValido(){
        BaseTest.sendKeys(campoEmail, email);
    }
    public void preencherEmailInvalido(){
        BaseTest.sendKeys(campoEmail, "email@mail.com");
    }
    public void preencherSenhaValida(){
        BaseTest.sendKeys(campoSenha, senha);
    }
    public void preencherSenhaFraca(){
        BaseTest.sendKeys(campoSenha, "123");
    }
    public void confirmarSenhaFraca(){
        BaseTest.sendKeys(campoConfirmarSenha, "123");
    }
    public void confirmarSenhaValida(){
        BaseTest.sendKeys(campoConfirmarSenha, senha);
    }
    public void confirmarSenhaDiferente(){BaseTest.sendKeys(campoConfirmarSenha, "12345678");}
    public void clicarBtnCadastrar(){
        BaseTest.click(btnCadastrar);
    }
    public void clicarCampoFoto() { BaseTest.click(campoFoto);}
    public void enviarFoto(){ BaseTest.sendKeys(campoFoto,"C:\\Users\\cassia.guimaraes\\Documents\\teste1.png");}
    public String validarMsgErrorEmail(){
        return BaseTest.getText(msgErrorEmail);
    }
    public String validarMsgSenhaFraca(){
        return BaseTest.getText(msgSenhaFraca);
    }
    public String validarMsgSenhasIguais(){ return BaseTest.getText(msgSenhasIguais);}
}
