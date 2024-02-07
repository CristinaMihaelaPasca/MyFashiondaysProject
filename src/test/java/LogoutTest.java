import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoutTest {
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
    public void login(){
        System.out.println("Click pe Intra in cont");
        WebElement authentificationButton = driver.findElement(By.id("customer-account"));
        authentificationButton.click();
        sleep(2000);

        System.out.println("Completeaza campul Adresa de e-mail");
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("crysam87@yahoo.com");
        sleep(2000);

        System.out.println("Completeaza campul parola");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Cristina87.");
        sleep(2000);

        System.out.println("Click intra in cont");
        WebElement loginButton = driver.findElement(By.id("pizokel_customer_submit"));
        loginButton.click();
        sleep(2000);

        System.out.println("Se tine cursurorul mouse-ului pe pictograma utilizatorului");
        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"customer-account\"]/div[1]/i"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuButton).perform();
        sleep(2000);

        System.out.println("Click logout");
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"my-account-dropdown\"]/ul/li[13]/a"));
        logoutButton.click();
        sleep(2000);

        System.out.println("Click pe pictograma utilizatorului");
        WebElement loggedOutMenuButton = driver.findElement(By.xpath("//*[@id=\"customer-account\"]/div[1]/i"));
        actions.moveToElement(loggedOutMenuButton).perform();
        sleep(2000);

        System.out.println("Se verifica ca dupa ce s-a dat logout apare mesajul Intra in cont cu email");
        WebElement loggedOutMenuMessage = driver.findElement(By.xpath("//*[@id=\"login-dropdown\"]/div/div[1]/span"));
        String expectedMessage = "Intra in cont cu email";
        sleep(2000);

        Assert.assertEquals(loggedOutMenuMessage.getText(), expectedMessage);

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




