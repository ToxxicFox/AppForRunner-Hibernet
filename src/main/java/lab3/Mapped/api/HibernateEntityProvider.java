package lab3.Mapped.api;

import lab3.Mapped.models.SprinterTraining;
import lab3.Mapped.utils.HibernateUtil;
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

    public SprinterTraining createSprTraining(SprinterTraining sprinterTraining) throws IOException {
        initSession();
        Transaction tx = session.beginTransaction();
        sprinterTraining.setId((long) session.save(sprinterTraining));
        tx.commit();
        close();
        return sprinterTraining;
    }

    public List<SprinterTraining> getSprTrainings() throws IOException {
        initSession();
        try {
            String query = String.format(Constants.QUERY, SprinterTraining.class.getSimpleName());
            session.getTransaction().begin();
            List<SprinterTraining> sprinterTrainings = session.createQuery(query).list();
            session.getTransaction().commit();
            close();
            return sprinterTrainings;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public SprinterTraining getSprTrainingById(long id) throws IOException {
        initSession();
        try {
            SprinterTraining sprinterTraining = session.get(SprinterTraining.class, id);
            close();
            return sprinterTraining;
        } catch (Exception e) {
            log.error("Not found");
            close();
            return new SprinterTraining();
        }
    }

    public Boolean deleteSprTrainings(long id) throws IOException {
        initSession();
        SprinterTraining sprinterTraining = new SprinterTraining();
        sprinterTraining.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(sprinterTraining);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }

    public SprinterTraining updateSprTraining(SprinterTraining sprinterTraining) throws IOException {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(sprinterTraining);
        tr.commit();
        close();
        return sprinterTraining;
    }
}

