package com.example.moestuinrest.steps;

import com.example.moestuinrest.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GardenSteps {

    final static String PLANT_ENDPOINT = "/plant";
    final static String GARDEN_ENDPOINT = "/garden";
    final static String GARDENCONTENT_ENDPOINT = "/gardencontent";

    final static Logger log  = Logger.getLogger("GardenSteps");

    @Inject
    public TestData testdata;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Given("er is een moestuin REST service")
    public void erIsEenMoestuinRestService() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(GARDEN_ENDPOINT, String.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    @And("testdata is geschoond")
    public void tuindataIsGeschoond() {
        testRestTemplate.delete(GARDENCONTENT_ENDPOINT + "/garden/1/1/2");
        testRestTemplate.delete(GARDENCONTENT_ENDPOINT + "/garden/2/1/2");
        testRestTemplate.delete(GARDEN_ENDPOINT + "/1");
        testRestTemplate.delete(GARDEN_ENDPOINT + "/2");
        testRestTemplate.delete(PLANT_ENDPOINT + "/1");
        testRestTemplate.delete(PLANT_ENDPOINT + "/2");

    }

    @Given("er is geen tuin")
    public void erIsGeenTuin() {

        ResponseEntity<String> response = testRestTemplate.getForEntity(GARDEN_ENDPOINT, String.class);
        Assertions.assertEquals("[]", response.getBody());
    }

    @When("een tuin wordt opgevoerd met naam {string} van {int} breed en {int} hoog")
    public void eenTuinWordtOpgevoerdMetNaamVanBreedEnHoog(String naamTuin, int breedte, int hoogte) {
        JSONObject gardenJsonObject = new JSONObject();
        gardenJsonObject.put("name", naamTuin);
        gardenJsonObject.put("dimensionX", breedte);
        gardenJsonObject.put("dimensionY", hoogte);

        ResponseEntity<JSONObject> response = testRestTemplate.postForEntity(GARDEN_ENDPOINT, gardenJsonObject, JSONObject.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());

        String gardenId = null;
        try {
            gardenId = response.getBody().get("id").toString();
            testdata.setGardenId(gardenId);
        } catch (NullPointerException e) {
            throw new NullPointerException("Geen antwoord, want id is " + gardenId);
        }
    }

    @Then("bestaat de tuin {string}")
    public void bestaatDeTuinDiverdoatsie(String naamTuin) {
        ResponseEntity<String> response = testRestTemplate.getForEntity(GARDEN_ENDPOINT, String.class);
        assertThat(response.getBody(), containsString(naamTuin));
    }

}
