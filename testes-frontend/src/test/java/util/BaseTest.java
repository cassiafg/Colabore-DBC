package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Elements {

    // Método de clicar
    public static void click (By by) {
        waitElement(by);
        element(by).click();
    }

    // Método de pegar um texto na tela
    public static String getText(By by){
        waitElement(by);
        return element(by).getText();
    }

    // Método de escrever em campo
    public static void sendKeys(By by, String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }

    //Método limpar campo
    public static void clear(By by){
        waitElement(by);
        element(by).clear();
    }

    public static void backspace(By by){
        waitElement(by);
        element(by).sendKeys(Keys.BACK_SPACE);
    }



    public static void esperarTempo(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }
}
