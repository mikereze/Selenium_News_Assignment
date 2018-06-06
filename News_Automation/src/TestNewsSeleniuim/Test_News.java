package TestNewsSeleniuim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Test_News {

    public static void main(String[] args){
        method3();
    }

    public static void method3(){
        List<String> Header1 = new ArrayList<>();
        List<String> Content = new ArrayList<>();
        List<String> Time = new ArrayList<>();
        List<String> Place = new ArrayList<>();
        List<String> insidecontents = new ArrayList<>();
        List<List<String>> allcontents = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\chromedriver.exe");

        WebDriver driver  = new ChromeDriver();

        driver.get("http://www.bbc.com/news");
        List<WebElement> check = ((ChromeDriver) driver).findElementsByClassName("nw-c-top-stories__secondary-item");
        for (int i=0;i<check.size();i++){
            ArrayList<String> variable = new ArrayList<String>(
                    Arrays.asList(check.get(i).getText().split("\n")));
            ArrayList<String> variable_main = new ArrayList<String>();

            for(int j=0;j<variable.size();j++){
                variable_main.add(variable.get(j).replace("&","and"));
            }
           allcontents.add(variable_main);


        }
        System.out.println(allcontents);
        driver.navigate().to("http://localhost:3000/news?allnews=" + allcontents);
        WebElement button = ((ChromeDriver) driver).findElementById("button");
        button.click();
        try{

            Thread.sleep(10000);

        }

        catch(Exception e){

            System.out.println("It doesnt Work Dude");
        }
        
        System.out.print("Page Title"+ driver.getTitle()+"\n");
        System.out.print("Current URL: "+ driver.getCurrentUrl()+"\n");
        System.out.print("Length of Page Source"+ driver.getPageSource().toString().length());

        try{

            Thread.sleep(2000);

        }

        catch(Exception e){

            System.out.println("It doesnt Work Dude");
        }
        driver.close();

    }

}
