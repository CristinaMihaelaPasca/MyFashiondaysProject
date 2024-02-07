import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchButtonTest {
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
    public void search(){
        System.out.println("Click pe campul cauta");
        WebElement searchBox = driver.findElement(By.id("mobile-search"));
        searchBox.click();
        sleep(2000);

        System.out.println("Introdu Adidasi Geox baieti in campul de cautare si apasa enter");
        WebElement searchButton = driver.findElement(By.id("search-input"));
        searchButton.sendKeys("Adidasi Geox baieti");
        searchButton.sendKeys(Keys.ENTER);
        sleep(2000);

        System.out.println("Verifica daca rezultatele cautarii dupa Adidasi Geox baieti sunt afisate pe pagina");
        WebElement resultMessage = driver.findElement(By.id("listinfo"));
        String expectedMessage = "Rezultatele cautarii pentru Adidasi Geox baieti";
        Assert.assertTrue(resultMessage.getText().contains(expectedMessage));
        sleep(2000);

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


