package lab5.api;

import lab5.models.Challenge;
import lab5.models.Runner;
import lab5.models.Training;
import lab5.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.Constants;

import java.io.IOException;
import java.util.List;

public class HibernateDataProvider {
    private Logger log = LogManager.getLogger(HibernateDataProvider.class);
    private Session session;

    private void initSession() throws IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory.isClosed()) {
            log.error("Session is closed");
        }
        session = sessionFactory.openSession();
    }

    private void close() {
        session.close();
        session = null;
    }

    public Challenge createChallenge(Challenge challenge) throws IOException{
        initSession();
        Transaction tx = session.beginTransaction();
        challenge.setId((Long) session.save(challenge));
        tx.commit();
        log.debug(challenge);
        close();
        return challenge;
    }

    public List<Challenge> getChallenges() throws IOException {
        String query = String.format(Constants.QUERY, Challenge.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Challenge> challengeList = session.createQuery(query).list();
        tx.commit();
        log.debug(challengeList);
        close();
        return challengeList;
    }

    public Challenge getChallengeById(Long id) throws IOException {
        initSession();
        try {
            Challenge challenge = session.get(Challenge.class, id);
            log.debug(challenge);
            close();
            if (challenge == null) {
                log.error("Not found");
                challenge = new Challenge();
            }
            return challenge;
        }
        catch (Exception e) {
            close();
            return new Challenge();
        }
    }

    public Boolean deleteChallenge(Long id) throws IOException{
        initSession();
        Challenge challenge = new Challenge();
        challenge.setId(id);
        try {
            Transaction tx = session.beginTransaction();
            session.delete(challenge);
            tx.commit();
            close();
            return true;
        }
        catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }

    public Challenge updateChallenge(Challenge challenge) throws IOException{
        initSession();
        Transaction tx = session.beginTransaction();
        session.update(challenge);
        tx.commit();
        close();
        return challenge;
    }

    public Training createTraining(Training training) throws IOException{
        if (training.getChallenge().getId() == null) {
            createChallenge(training.getChallenge());
        }
        initSession();
        Transaction tx = session.beginTransaction();
        training.setId((Long) session.save(training));
        tx.commit();
        close();
        return training;
    }

    public List<Training> getTrainings() throws IOException{
        String query = String.format(Constants.QUERY, Training.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Training> trainingList = session.createQuery(query).list();
        tx.commit();
        log.debug(trainingList);
        close();
        return trainingList;
    }

    public Training getTrainingById(Long id) throws IOException{
        initSession();
        try {
            Training training = session.get(Training.class, id);
            log.debug(training);
            close();
            if (training == null) {
                log.error("Not found");
                training = new Training();
            }
            return training;
        }
        catch (Exception e) {
            close();
            return new Training();
        }
    }

    public Boolean deleteTraining(Long id) throws IOException{
        initSession();
        Training training = new Training();
        training.setId(id);
        try {
            Transaction tx = session.beginTransaction();
            session.delete(training);
            tx.commit();
            close();
            return true;
        }
        catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }



    public Runner createRunner(Runner runner) throws IOException {
        for (Training training : runner.getTrainingList()){
            if (training.getId() == null) {
                log.debug(training.getId());
                createTraining(training);
            }
        }
        for (Challenge challenge : runner.getChallenges()){
            if ((Long)challenge.getId() == null) {
                log.info(challenge.getId());
                createChallenge(challenge);
            }
        }
        initSession();
        Transaction tx = session.beginTransaction();
        runner.setId((Long) session.save(runner));
        //tx.commit();
        close();
        return runner;
    }

    public List<Runner> getRunners() throws IOException {
        String query = String.format(Constants.QUERY, Runner.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Runner> runnerList = session.createQuery(query).list();
        tx.commit();
        log.debug(runnerList);
        close();
        return runnerList;
    }

    public Runner getRunnerById(Long id) throws IOException {
        initSession();
        try {
            Runner runner = session.get(Runner.class, id);
            log.debug(runner);
            close();
            if (runner == null) {
                log.error("Not found");
                runner = new Runner();
            }
            return runner;
        }
        catch (Exception e) {
            close();
            return new Runner();
        }
    }

    public Boolean deleteRunner(Long id) throws IOException {
        initSession();
        Runner runner = new Runner();
        runner.setId(id);
        try {
            Transaction tx = session.beginTransaction();
            session.delete(runner);
            tx.commit();
            close();
            return true;
        }
        catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }

    public Runner updateRunner (Runner runner) throws IOException {
        for (Training training : runner.getTrainingList()){
            if (training.getId() == null) {
                createTraining(training);
            }
        }
        for (Challenge challenge : runner.getChallenges()){
            if ((Long)challenge.getId() == null) {
                createChallenge(challenge);
            }
        }
        initSession();
        Transaction tx = session.beginTransaction();
        session.update(runner);
        tx.commit();
        close();
        return runner;
    }
}
