package lab4.api;

import lab4.models.Training;
import lab4.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.Constants;

import java.io.IOException;
import java.util.List;

public class HibernateEntityProvider {
    private Logger log = LogManager.getLogger(HibernateEntityProvider.class);
    private Session session;

    private void initSession() throws IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    private void close() {session.close();}

    public Training createTraining(Training training) throws IOException {
        initSession();
        Transaction tx = session.beginTransaction();
        training.setId((Long) session.save(training));
        tx.commit();
        return training;
    }

    public List<Training> getTrainings() throws IOException {
        initSession();
        try {
            String query = String.format(Constants.QUERY, Training.class.getSimpleName());
            Transaction tx = session.beginTransaction();
            List<Training> trainingList = session.createQuery(query).list();
            tx.commit();
            log.debug(trainingList);
            close();
            return trainingList;
        } catch (Exception e) {
            log.error(e);
            close();
            return null;
        }
    }

    public Training getTrainingById(Long id) throws IOException{
        initSession();
        try {
            Training training = session.get(Training.class, id);
            log.debug(training);
            close();
            if (training == null) {
                training = new Training();
                log.error("Not found");
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
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }

    public Training updateTraining(Training training) throws IOException {
        initSession();
        Transaction tx = session.beginTransaction();
        session.update(training);
        tx.commit();
        close();
        return training;
    }
}
