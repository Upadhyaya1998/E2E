package com.qa.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

import java.io.FileReader;

public class LocatorUtils{

    String fileName = new String();

    public LocatorUtils(String fileName){
        this.fileName = fileName;
    }

    /**
     * Get Locator Details
     * @return All Locators for the page
     */
    public JSONObject getLocatorDetails(){
        FileReader reader = null;
        Object obj = null;

        JSONParser jsonParser = new JSONParser();

        try{
            reader = new FileReader(System.getProperty("user.dir")+ "/"+"src/main/resources/locatorFile/"+fileName+".json");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            obj = jsonParser.parse(reader);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        JSONObject object = (JSONObject) obj;

        return object;
    }


    /**
     * Get Locator
     * @param locator Name of the locator
     * @return By locator
     */
    public By getLocator(String locator){
        JSONObject locatorObjects = getLocatorDetails();
        JSONObject locatorDetails = (JSONObject) locatorObjects.get(locator);

        String type = locatorDetails.get("type").toString();
        String value = locatorDetails.get("value").toString();

        switch (type){
            case "xpath":
                return By.xpath(value);
            case "id":
                return By.id(value);
            case "partialLinkText":
                return By.partialLinkText(value);
            case "name":
                return By.name(value);
            default:
                return null;
        }
    }
}
