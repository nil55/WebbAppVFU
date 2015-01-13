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
public class dataCollecter {

    Session session = null;

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
    
    public List getDataFromDateAndTime() {
        List<Val> dataTitles = null;
        org.hibernate.Transaction tx = null; 
        List values = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Val.class);
            cr.add(Restrictions.ilike("id", 10));
            values = cr.list();
            for (Iterator iterator = values.iterator(); iterator.hasNext();){
                Val val = (Val) iterator.next();
                System.out.println("Data: " + val.getDateInTime());
            }
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace();}
             finally {
                       session.close();
        }
        return values;
    }
    
    public dataCollecter() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
