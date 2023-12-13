package ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.PartnerPage;
import utils.parseutil.CsvWriter;
import utils.parseutil.PartnerData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PartnerDataTest {

    @BeforeClass
    public void init() {
        try {
            Files.deleteIfExists(Paths.get("partner_data.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.testng.annotations.Test(dataProvider = "partnerData")
    public void testPartnerData(File file) {
        Path pathToHtmlFile = Paths.get(file.getPath());
        String url = pathToHtmlFile.toUri().toString();

        PartnerPage partnerPage = new PartnerPage(url);

        partnerPage.get();
        PartnerData partnerData = partnerPage.getPartnerData();
        try {
            CsvWriter.saveToCSV(partnerData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "partnerData")
    public Object[][] partnerData() {
        return new Object[][]{
                {new File("src\\test\\java\\testdata\\P1L1.mht")},
                {new File("src\\test\\java\\testdata\\P1L2.mht")},
                {new File("src\\test\\java\\testdata\\P1L3.mht")},
                {new File("src\\test\\java\\testdata\\P2L1.mht")},
                {new File("src\\test\\java\\testdata\\P2L2.mht")},
                {new File("src\\test\\java\\testdata\\P2L3.mht")}
        };
    }
}
