import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortProductTest {
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
        //WebElement categorySportShoesButton = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div/section/div/div[1]/a[1]/div"));
        categorySportShoesButton.click();
        sleep(2000);

        System.out.println("Sorteaza dupa brandul adidas Performance");
        WebElement adidasPerformanceButton = driver.findElement(By.xpath("//*[@id=\"brandOpt_41653\"]/a/span[2]"));
        adidasPerformanceButton.click();
        sleep(2000);

        System.out.println("Verifica daca rezultatele cautarii dupa brandul adidas Performance sunt afisate pe pagina");
        WebElement resultMessage = driver.findElement(By.xpath("//div[@id='campaign-informations']//h1[@class='campaign-info-headline']"));
        String expectedResult = "PANTOFI ADIDAS PERFORMANCE BAIETI";
        sleep(2000);
        System.out.println(resultMessage.getText());
        System.out.println(expectedResult);
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


