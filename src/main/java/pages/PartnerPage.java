package pages;

import com.codeborne.selenide.*;
import utils.LoadableComponent;
import utils.parseutil.PartnerData;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class PartnerPage extends LoadableComponent<PartnerPage> {
    private final String url;

    private final ElementsCollection comparingPeriods = $$("[class*='comparing-period']");
    private final SelenideElement partnerName = $("img[alt*='Logo']");
    private final SelenideElement locationName = $(".location-information__title");
    private final SelenideElement earnedMoney = $x("//span[contains(text(), \"Money received\")]" +
            "//parent::div/following-sibling::div[@class='animated-digits']//*[@class='unit-price']");
    private final SelenideElement usedKW = $x("//span[contains(text(), \"Electricity consumed\")]" +
            "//parent::div/following-sibling::div[@class='animated-digits']//*[@class='unit-price']");

    public PartnerPage(String url) {
        this.url = url;
    }

    public PartnerData getPartnerData() {
        LocalDateTime parsingDateTime = LocalDateTime.now();
        String comparingPeriodsString = comparingPeriods.texts().stream()
                .collect(Collectors.joining(" "));

        return new PartnerData(
                comparingPeriodsString,
                partnerName.getAttribute("alt").replaceAll("Logo", "").trim(),
                locationName.text(),
                earnedMoney.text(),
                usedKW.text(),
                parsingDateTime.toString()
        );
    }

    protected void isLoaded() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains(url));
        comparingPeriods.forEach(x -> x.shouldBe(Condition.visible, Duration.ofSeconds(4)));
        partnerName.shouldBe(Condition.visible, Duration.ofSeconds(4));
        locationName.shouldBe(Condition.visible, Duration.ofSeconds(4));
        earnedMoney.shouldBe(Condition.visible, Duration.ofSeconds(4));
        usedKW.shouldBe(Condition.visible, Duration.ofSeconds(4));
    }

    @Override
    protected void load() {
        Selenide.open(url);
    }
}
