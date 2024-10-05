package api.tests;

import api.endpoints.Resources;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userPayload;

    public Logger logger;

    @BeforeClass
    public void userPayLoad()
    {
        faker = new Faker();
        userPayload= new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());


        logger= LogManager.getLogger(this.getClass());

    }

    @Test(priority=1)
    public void createUser()
    {
        logger.info("************* Creating User **********************");
        Response res= Resources.createUser(userPayload);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
        logger.info("************* User is created *******************");

    }


    @Test(priority=2)
    public void getUser()
    {
        logger.info("******************* Retrieving user details********************");
        Response res= Resources.getUser(this.userPayload.getUsername());
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
        logger.info("******************* User details are retrieved ********************");

    }

    @Test(priority=3)
    public void updateUser()
    {
        logger.info("******************* Updating user details********************");
        Response res= Resources.updateUser(userPayload,this.userPayload.getUsername());
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
        logger.info("******************* Updated user details********************"+this.userPayload.getUsername());
    }

    @Test(priority =4)
    public void deleteUser()
    {  logger.info("******************* Retrieving user details********************");
        String userName = this.userPayload.getUsername();
        Response res= Resources.deleteUser(this.userPayload.getUsername());
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
        logger.info("******************* Deleted user ********************"+userName);
    }





}
