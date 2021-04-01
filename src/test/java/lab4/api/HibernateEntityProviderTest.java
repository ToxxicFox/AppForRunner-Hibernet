package lab4.api;

import lab4.models.Challenge;
import lab4.models.Training;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class HibernateEntityProviderTest {

    private Logger log = LogManager.getLogger(HibernateEntityProviderTest.class);
    private HibernateEntityProvider dp = new HibernateEntityProvider();

    @Test
    public void createTraining() throws IOException {
        Map<String, String> weather = new HashMap<>();
        weather.put("Sunny", "Good");
        weather.put("Storm", "Bad");

        List<String> challenges = new ArrayList<>();
        challenges.add("Hard");
        challenges.add("Intensive");

        Set<String> tags = new HashSet<>();
        tags.add("Never give up");
        tags.add("Higher Faster Stronger");

        Set<Challenge> challengeSet = new HashSet<>();
        Challenge challenge = new Challenge();
        challenge.setChId(5L);
        challenge.setChallName("Weekend Trn");
        challengeSet.add(challenge);

        Training training = new Training();
        training.setDistance(5000L);
        training.setTotalTime("30 min");
        training.setDate("31 March");

        training.setTags(tags);
        training.setChallenges(challenges);
        training.setWeather(weather);
        training.setChallengeSet(challengeSet);
        dp.createTraining(training);
    }

    @Test
    public void getTrainings() throws IOException {
        List<Training> trainingList = dp.getTrainings();
        log.info(trainingList);
    }

    @Test
    public void getTrainingById() throws IOException {
        Long id = 1L;
        Training training = dp.getTrainingById(id);
        log.info(training);
    }

    @Test
    public void deleteTraining() throws IOException {
        Long id = 2L;
        Boolean isDeleted = dp.deleteTraining(id);
        log.info(isDeleted);
    }

    @Test
    public void updateTraining() throws IOException {
        Long id = 5L;
        Training training = dp.getTrainingById(id);
        training.setDate("1 April");
        training = dp.updateTraining(training);
        log.info(training);
    }
}