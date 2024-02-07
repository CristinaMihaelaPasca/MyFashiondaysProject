import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WhishlistTest {
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


    }

    @Test
    public void whislist() {

        System.out.println("Sorteaza dupa baieti");
        WebElement baietiButton = driver.findElement(By.xpath("//*[@id=\"tag-menu\"]/ul/li[4]/a"));
        baietiButton.click();
        sleep(2000);

        System.out.println("Sorteaza dupa categorie si alege pantofi sport");
        WebElement categorySportShoesButton = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[3]/div/section/div/div[1]/a[1]/h2"));
        //WebElement categorySportShoesButton = driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[4]/div/section/div/div[1]/a[1]/div"));
        categorySportShoesButton.click();
        sleep(2000);

        System.out.println("Sorteaza dupa marca adidas Sportwear");
        WebElement adidasSportswearButton = driver.findElement(By.xpath("//*[@id=\"brandOpt_1033739\"]/a/span[2]"));
        adidasSportswearButton.click();
        sleep(2000);

        System.out.println("Adauga produssul dorit la favorite apasand butonul cu inimioara");
        WebElement favorittButton = driver.findElement(By.xpath("//*[@id=\"prod-6514675\"]/a/div[1]/span[2]"));
        favorittButton.click();
        sleep(2000);

        System.out.println("Selecteaza marimea 28");
        WebElement marimeButton = driver.findElement(By.xpath("//*[@id=\"pdp-size-select-modal\"]/div[2]/ul/li[1]/div/div[1]/div/span"));
        marimeButton.click();
        sleep(2000);

        System.out.println("Click pe adauga la favorite");
        WebElement addtoFavouriteButton = driver.findElement(By.xpath("//*[@id=\"js-pdp-size-select-add\"]"));
        addtoFavouriteButton.click();
        sleep(2000);

        System.out.println("Se verifica daca produsul selectat a fost adaugat la favorite");
        WebElement messageResult = driver.findElement(By.xpath("//*[@id=\"myFirstFav\"]/div/div/div/div[1]/h4"));
        String expectedResult= "ACEST PRODUS A FOST ADAUGAT IN LISTA TA DE FAVORITE!";
        sleep(2000);

        Assert.assertTrue(messageResult.getText().contains(expectedResult));

    }

    @AfterTest
    public void tearDown() {
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





