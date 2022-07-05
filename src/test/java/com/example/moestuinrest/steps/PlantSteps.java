package com.example.moestuinrest.steps;

import com.example.moestuinrest.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;
import java.util.logging.Logger;

public class PlantSteps {

    final static Logger log  = Logger.getLogger("PlantSteps");

    final static String GARDEN_ENDPOINT = "/garden";
    final static String PLANT_ENDPOINT = "/plant";

    @Inject
    private TestData testdata;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Given("een plant {string} wordt opgevoerd")
    public void erEenPlantWordtOpgevoerd(String naamPlant) {
        JSONObject plantJsonObject = new JSONObject();
        plantJsonObject.put("name", naamPlant);
        plantJsonObject.put("icon", "cauliflower");
        plantJsonObject.put("seedPeriod", "1,2,3");
        plantJsonObject.put("plantPeriod", "3,4");
        plantJsonObject.put("harvestPeriod", "9,10");

        ResponseEntity<JSONObject> response = testRestTemplate.postForEntity(PLANT_ENDPOINT, plantJsonObject, JSONObject.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());

        String plantId = null;
        try {
            plantId = response.getBody().get("id").toString();
            testdata.setPlantId(plantId);
            testdata.setPlantName(naamPlant);
        } catch (NullPointerException e) {
            throw new NullPointerException("Geen antwoord, want id is " + plantId);
        }
    }

    @And("er een plant {string} is")
    public void erEenPlantIs(String naamPlant) {
        JSONObject plantJsonObject = new JSONObject();
        plantJsonObject.put("name", naamPlant);
        plantJsonObject.put("icon", "cauliflower");
        plantJsonObject.put("seedPeriod", "1,2,3");
        plantJsonObject.put("plantPeriod", "3,4");
        plantJsonObject.put("harvestPeriod", "9,10");

        ResponseEntity<JSONObject> response = testRestTemplate.postForEntity(PLANT_ENDPOINT, plantJsonObject, JSONObject.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());

        String plantId = null;
        try {
            plantId = response.getBody().get("id").toString();
            testdata.setPlantId(plantId);
            testdata.setPlantName(naamPlant);
        } catch (NullPointerException e) {
            throw new NullPointerException("Geen antwoord, want id is " + plantId);
        }
    }

    @Then("is de plant opgeslagen")
    public void isDePlantOpgeslagen() {
        ResponseEntity<JSONObject> response = testRestTemplate.getForEntity(PLANT_ENDPOINT + "/" + testdata.getPlantId(), JSONObject.class);
        Assertions.assertEquals(testdata.getPlantId(), response.getBody().get("id").toString());
        Assertions.assertEquals(testdata.getPlantName(), response.getBody().get("name").toString());
    }
}
