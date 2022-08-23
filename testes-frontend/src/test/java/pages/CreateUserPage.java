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
    public static final By campoFoto = By.cssSelector("#foto > input:nth-child(1)");
    public static final By msgErrorEmail = By.cssSelector(".sc-bZkfAO");
    public static final By msgSenhaFraca = By.cssSelector(".password__label");
    public static final By msgSenhasIguais = By.cssSelector("#erro-confirmarSenha");

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
    public void clicarCampoEmail(){
        BaseTest.click(campoEmail);
    }
    public void clicarConfirmarSenha(){
        BaseTest.click(campoConfirmarSenha);
    }
    public void clicarFora() { BaseTest.click(msgSenhaFraca);}
    public void enviarFoto(){ BaseTest.sendKeys(campoFoto,"C:\\Colabore-DBC\\testes-frontend\\image\\image.jpg");}
    public String validarMsgErrorEmail(){
        return BaseTest.getText(msgErrorEmail);
    }
    public String validarMsgSenhaFraca(){
        return BaseTest.getText(msgSenhaFraca);
    }
    public String validarMsgSenhasIguais(){ return BaseTest.getText(msgSenhasIguais);}
}
