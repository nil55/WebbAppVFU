/*
 * This Program was made by - Nils -
 * with insperation from nb
 */
package search;

import hibernater.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nils
 */
public class DataHelper {

    Session session = null;
    
    // blablabla
    public List getDataFromId(int startID, int endID) {
        List<Val> dataTitles = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Val as val where val.id between " + startID + " and " + endID);
            
            dataTitles = (List<Val>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTitles;
    }
    
    public List getDataFromSensor1(int startID, int endID) {
        List<Val> dataTitles = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("SELECT v.dateInTime, v.timeOfMesure, v.sensor1 FROM Val AS v WHERE v.id between " + startID + " and " + endID);
            dataTitles = (List<Val>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTitles;
    }    
    public DataHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
