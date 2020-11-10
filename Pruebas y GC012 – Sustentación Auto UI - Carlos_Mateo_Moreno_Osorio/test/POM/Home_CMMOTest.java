/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author DiamondStalker
 */
public class Home_CMMOTest {

    private static WebDriver driver = null;
    Home_CMMO Home;
    Loggin_CMMO Loggin;
    Create_CMMO create;
    Random rnd = new Random();

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public String password() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public Home_CMMOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        Home = new Home_CMMO(driver);
        Loggin = new Loggin_CMMO(driver);
        create = new Create_CMMO(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test of click_btnlogin method, of class Home_CMMO.
     */
    @Test
    public void testClick_btnlogin() {
        Home.click_btnlogin();
        sleep();

        /*
         *Insertamos el correo y le damos al boton crear
         */
        String Correo = "DiamondStalker";
        int numero = rnd.nextInt(100) + 0;
        Correo += numero + "@hotmail.com";
        Loggin.setEmail(Correo);
        Loggin.Click_Create();

        // if(msg.equalsIgnoreCase("Invalid email address.")) Loggin.Click_Singin();
        sleep();

        /*
         * Terminamos de llenar los datos para la creacion de usuario
         * Pero dejamos el campo Codigo postal vacio
         * Para validar que el campo sea requerido
         * le damos al botno registrar y capturamos el mensaje de error de requerido
         */
        
        String Fname = "Diamond";
        create.setFnameC(Fname);
        
        
        String Lname = "Diamond";
        create.setLNameC(Lname);
        
        String pass = password();
        create.setPassw(pass);
        
        numero = rnd.nextInt((200 - 100) + 1) + 100;
        String Address = "Diamonds" + numero + "S.A";
        create.setAddress(Address);
        
        numero = rnd.nextInt((200 - 100) + 1) + 100;
        String City = "DiamondStalker" + numero;
        create.setACity(Address);
        
        numero = rnd.nextInt(50) + 1;
        int State = numero;
        create.setselectstate(numero);
        // COuntry United States
        
        String Telefono = Integer.toString(rnd.nextInt((999999999-000000000)+1) + 000000000);
        create.setphone_mobile(Telefono);
        sleep();
        create.clickBtnsubmitAccount();
        sleep();sleep();sleep();sleep();
        String error = create.getError_MSG();
        assertEquals("Codigo postal requerido","",error);
        sleep();sleep();sleep();sleep();
        sleep();sleep();sleep();sleep();
    }

}
