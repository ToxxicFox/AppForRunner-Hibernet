package lab5.api;

import lab5.models.Challenge;
import lab5.models.Runner;
import lab5.models.Training;
import lab5.utils.GenerateEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class HibernateDataProviderTest {

    private HibernateDataProvider dp = new HibernateDataProvider();
    private Logger log = LogManager.getLogger(HibernateDataProviderTest.class);

    @Test
    public void createChallenge() throws IOException {
        Challenge challenge = new Challenge();
        challenge.setChallName("Second run");
        challenge.setStartDate("21 May");
        challenge.setFinishDate("11 June");
        challenge.setChallDistance(9500L);
        challenge.setChallTime(45L);
        dp.createChallenge(challenge);
        log.info(challenge);
    }

    @Test
    public void createTraining() throws IOException {
        Training training = new Training();

        Challenge challenge = new Challenge();
        challenge.setChallName("First Run");
        training.setChallenge(challenge);

        training.setDistance(5000L);
        training.setTotalTime("45 min");
        training.setDate("3 April");
        training = dp.createTraining(training);
        log.info(training);
    }

    @Test
    public void createRunner() throws IOException {
        Runner runner = new Runner();

        List<Challenge> challenges = GenerateEntity.genChallenge(3);
        runner.setChallenges(challenges);

        List<Training> trainingList = GenerateEntity.genTraining(5);
        runner.setTrainingList(trainingList);

        runner.setFirstName("Egor");
        runner.setLastName("Creed");
        runner.setAge(34L);
        runner.setWeight(66L);
        runner.setHeight(182L);

        runner = dp.createRunner(runner);
        log.info(runner);
    }
}