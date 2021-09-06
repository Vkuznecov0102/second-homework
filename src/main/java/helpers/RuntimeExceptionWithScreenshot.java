package helpers;

import driver.WebDriverManager;
import io.qameta.allure.Allure;

public class RuntimeExceptionWithScreenshot extends RuntimeException {
    public RuntimeExceptionWithScreenshot(String errorText) {
        Allure.attachment("Текст ошибки:", errorText);
        CustomUtils.getScreen(WebDriverManager.getCurrentDriver());
        throw new RuntimeException(errorText);
    }
}
