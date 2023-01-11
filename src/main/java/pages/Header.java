package pages;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Header extends BasePage {

    @FindBy(css = "a.level-top")
    private List<WebElement> menuCategories;

    @FindBy(css = ".submenu .category-item a")
    private List<WebElement> subMenuCategories;

    public Header() {
        super();
        PageFactory.initElements(driver, this);
    }

    public ProductDetailPage chooseMenu(String menuName, String... submenuNames) {
        WebElement menu = menuCategories.stream().filter(element -> element
                .getText().equals(menuName)).findFirst().orElseThrow(RuntimeException::new);
        hover(menu);
        WebElement targetMenu = menu;
        if (!ArrayUtils.isEmpty(submenuNames)) {
            for (String submenuName : submenuNames) {
                targetMenu = subMenuCategories.stream().filter(element -> element.getText().equals(submenuName))
                        .findFirst().orElseThrow(() -> new RuntimeException("Please check Sub Menu Category Name"));
                hover(targetMenu);
            }
        }
        targetMenu.click();
        return new ProductDetailPage();
    }
}
