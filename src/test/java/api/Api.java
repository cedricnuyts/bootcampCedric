package api;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Api {

    private String season = "2016";
    private String driver = "max_verstappen";

    @Test
    public void getStatusCodeOfUrlResultsMaxVerstappen(){
        given()
                .when()
                    .get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json")
                .then()
                    .statusCode(200);
    }

    @Test
    public void getResultsOfMaxVerstappen(){
        given()
                .when()
                    .get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json")
                .then()
                    .assertThat().body("MRData.RaceTable.driverId", equalTo("max_verstappen"))
                    .assertThat().body("MRData.RaceTable.Races", Matchers.not(Matchers.empty()));
    }

    @Test
    public void testUrlParamDemo(){
        given()
                .pathParam("season", "2016")
                .when()
                    .get("http://ergast.com/api/f1/{season}/drivers/max_verstappen/results.json")
                .then()
                    .statusCode(200);
    }

    @Test
    public void testUrlParamOpdracht4(){
        given()
                .pathParam("season", season)
                .pathParam("driver", driver)
                .when()
                    .get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json")
                .then()
                    .statusCode(200)
                    .assertThat().body("MRData.RaceTable.season", equalTo(season))
                    .assertThat().body("MRData.RaceTable.driverId", equalTo(driver))
                    .assertThat().body("MRData.RaceTable.Races", Matchers.not(Matchers.empty()));
    }

    @Test
    public void testUrlParamOpdracht4_2(){
        given()
                .when()
                    .get("http://ergast.com/api/f1/" + season + "/drivers/" + driver + "/results.json")
                .then()
                    .statusCode(200)
                    .assertThat().body("MRData.RaceTable.season", equalTo(season))
                    .assertThat().body("MRData.RaceTable.driverId", equalTo(driver))
                    .assertThat().body("MRData.RaceTable.Races", Matchers.not(Matchers.empty()));
    }
}
