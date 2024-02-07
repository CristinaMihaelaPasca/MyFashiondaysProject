import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddProductTest {

    WebDriver driver;

    String url = "https://www.fashiondays.ro/";

    @BeforeTest

    public void setUp() {
        System.out.println("Deschide pagina www.fashiondays.ro");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        System.out.println("Click pentru a accepta reclama");
        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"accept-cookie-policy\"]"));
        acceptButton.click();
        sleep(2000);

    }
    @Test
    public void sortProduct(){
        System.out.println("Sorteaza dupa baieti");
        WebElement baietiButton = driver.findElement(By.xpath("//*[@id=\"tag-menu\"]/ul/li[4]/a"));
        baietiButton.click();
        sleep(2000);

        System.out.println("Sorteaza dupa categorie si alege pantofi sport");
        WebElement categorySportShoesButton = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[3]/div/section/div/div[1]/a[1]/h2"));
        //  WebElement categorySportShoesButton = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div/section/div/div[1]/a[1]/div"));
        categorySportShoesButton.click();
        sleep(2000);

        System.out.println("Sorteaza dupa brandul adidas Performance");
        WebElement adidasPerformanceButton = driver.findElement(By.xpath("//*[@id=\"brandOpt_41653\"]/a/span[2]"));
        adidasPerformanceButton.click();
        sleep(2000);

        System.out.println("Click pe modelul de adidasi");
        WebElement adidasiDeFotbal = driver.findElement(By.xpath("//*[@id=\"prod-6599561\"]/a/h2"));
        adidasiDeFotbal.click();
        sleep(2000);

        System.out.println("Click pe butonul adauga in cos");
        WebElement adaudaInCosButton = driver.findElement(By.xpath("//*[@id=\"buy-box\"]/span"));
        adaudaInCosButton.click();
        sleep(2000);

        System.out.println("Selecteaza marimea adidasilor 36 2/3");
        WebElement marimeButton = driver.findElement(By.xpath("//*[@id=\"pdp-size-select-modal\"]/div[2]/ul/li[3]/div/div[1]/div/span"));
        marimeButton.click();
        sleep(2000);

        System.out.println("Adauga produs in cos");
        WebElement finalAdaugaInCos = driver.findElement(By.xpath("//*[@id=\"js-pdp-size-select-add\"]"));
        finalAdaugaInCos.click();
        sleep(2000);

        System.out.println("Click pe pictograma cosului de cumparaturi");
        WebElement cosButton = driver.findElement(By.xpath("//*[@id=\"customer-basket\"]/div[1]/i"));
        cosButton.click();
        sleep(2000);

        System.out.println("Verifica daca in cosul de cumparaturi apare produsul adaugat");
        WebElement resultMessage = driver.findElement(By.xpath("//*[@id=\"group-box-availability_id_3\"]/h4"));
        String expectedResult = "In stoc (1)";
        sleep(2000);

        Assert.assertTrue(resultMessage.getText().contains(expectedResult));

    }


        @AfterTest
        public void tearDown(){
            System.out.println("Inchide pagina");
            driver.close();
        }

        public static void sleep(int milisecond){
            try{
                Thread.sleep(milisecond);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }




