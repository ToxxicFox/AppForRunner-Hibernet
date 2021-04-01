package lab3.Mapped.api;

import lab3.JoinedTable.api.HibernateEntityProvider;
import lab3.JoinedTable.models.SprinterTraining;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class HibernateEntityProviderTest {
    private lab3.JoinedTable.api.HibernateEntityProvider dp = new HibernateEntityProvider();
    private Logger log = LogManager.getLogger(lab3.JoinedTable.api.HibernateEntityProviderTest.class);

    @Test
    public void createSprTraining() throws IOException {
        SprinterTraining sprinterTraining = new SprinterTraining();
        sprinterTraining.setAvgLap(1234);
        sprinterTraining.setNumSegments(5);
        sprinterTraining.setTotalDistance(4500);
        sprinterTraining.setBestSigment(4);
        dp.createSprTraining(sprinterTraining);
        log.info(sprinterTraining);
    }

    @Test
    public void getSprTrainings() throws IOException {
        List<SprinterTraining> sprinterTrainings = dp.getSprTrainings();
        log.info(sprinterTrainings.toString());
        Assert.assertNotNull(sprinterTrainings);
    }

    @Test
    public void getSprTrainingById() throws IOException {
        long id = 11;
        SprinterTraining sprinterTraining = dp.getSprTrainingById(id);
        log.info(sprinterTraining);
        Assert.assertTrue(sprinterTraining.getId() == id);
    }

    @Test
    public void updateSprTraining() throws IOException {
        SprinterTraining sprinterTraining = new SprinterTraining();
        sprinterTraining.setId(11);
        sprinterTraining.setDistance(6700);
        Assert.assertTrue(sprinterTraining.equals(dp.updateSprTraining(sprinterTraining)));
    }

    @Test
    public void deleteSprTrainings() throws IOException {
        List<SprinterTraining> sprinterTrainingList = dp.getSprTrainings();
        long id = sprinterTrainingList.get(0).getId();
        Boolean hasDeleted = dp.deleteSprTrainings(id);
        log.info(hasDeleted);
    }
}