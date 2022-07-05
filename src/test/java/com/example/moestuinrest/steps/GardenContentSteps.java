package com.example.moestuinrest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.moestuinrest.TestData;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GardenContentSteps {

    final static String GARDENCONTENT_ENDPOINT = "/gardencontent";

    final static Logger log  = Logger.getLogger("GardenSteps");

    @Inject
    public TestData testdata;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @When("de plant aan de tuin wordt toegevoegd op kolom {int} en rij {int}")
    public void dePlantAanDeTuinWordtToegevoegdOpRijEnKolom(int locatieX, int locatieY) {

        JSONObject plantJsonObject = new JSONObject();
        plantJsonObject.put("id", testdata.getPlantId());

        JSONObject gardenJsonObject = new JSONObject();
        gardenJsonObject.put("id", testdata.getGardenId());

        JSONObject gardenContentJsonObject = new JSONObject();
        gardenContentJsonObject.put("positionX", locatieX);
        gardenContentJsonObject.put("positionY", locatieY);
        gardenContentJsonObject.put("garden", gardenJsonObject);
        gardenContentJsonObject.put("plant", plantJsonObject);

        ResponseEntity<JSONObject> response = testRestTemplate.postForEntity(GARDENCONTENT_ENDPOINT, gardenContentJsonObject, JSONObject.class);

        Assertions.assertEquals(200,response.getStatusCodeValue());

    }

    @Then("is de plant opgeslagen op kolom {int} en rij {int} op de tuin")
    public void isDePlantOpgeslagenOpKolomEnRijOpDeTuin(int locatieX, int locatieY) {

        ResponseEntity<JSONObject> response = testRestTemplate.getForEntity(GARDENCONTENT_ENDPOINT + "/garden/" + testdata.getGardenId() + "/" + locatieX + "/" + locatieY, JSONObject.class);
        Assertions.assertEquals(200,response.getStatusCodeValue());

        Assertions.assertEquals(Integer.toString(locatieX), response.getBody().get("positionX").toString());
        Assertions.assertEquals(Integer.toString(locatieY), response.getBody().get("positionY").toString());
    }

}
