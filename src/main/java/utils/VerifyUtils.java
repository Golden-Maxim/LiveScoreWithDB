package utils;

import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VerifyUtils {

    public static boolean verifyElementAttribute(SelenideElement element) {
        String elementAttribute = element.getAttribute("class");
        return elementAttribute != null && elementAttribute.contains("isActive");
    }
}
