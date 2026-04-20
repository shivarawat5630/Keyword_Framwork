package testcase;

import base.BaseTest;
import keywords.Keywords;
import utils.ExcelUtils;
import org.testng.annotations.*;

public class LandingPageTest extends BaseTest {

    Keywords key = new Keywords();

    @BeforeClass
    public void init() {
        setup();
        ExcelUtils.loadExcel("src/test/resources/testdata.xlsx", "Sheet1");
    }

    @Test
    public void executeKeywords() {

        int rows = ExcelUtils.getRowCount();

        for (int i = 1; i <= rows; i++) {

            //String keyword = ExcelUtils.getCellData(i, 1);
            //String keyword = ExcelUtils.getCellData(i, 1).trim();
            String keyword = ExcelUtils.getCellData(i, 1).trim();
            String locatorType = ExcelUtils.getCellData(i, 2).trim();
            String locatorValue = ExcelUtils.getCellData(i, 3).trim();
            String data = ExcelUtils.getCellData(i, 4).trim();
            
            //String locatorType = ExcelUtils.getCellData(i, 2);
            //String locatorValue = ExcelUtils.getCellData(i, 3);
            //String data = ExcelUtils.getCellData(i, 4);

            switch (keyword.toLowerCase()) {

                case "click":
                    key.click(locatorType, locatorValue);
                    break;

                case "type":
                    key.type(locatorType, locatorValue, data);
                    break;

                case "verifytext":
                    String actual = key.getText(locatorType, locatorValue);
                    System.out.println("Text: " + actual);
                    break;

                default:
                    System.out.println("Invalid keyword");
            }
        }
    }

    @AfterClass
    public void close() throws InterruptedException {
        tearDown();
    }
}