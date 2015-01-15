/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import hibernater.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nils
 */
@ManagedBean
@SessionScoped
public class DataController {

    long counter = 1;
    int c;
    DataModel dataModel;
    List<Val> tempList = null;
    Session s = null;

    public DataController() {
        this.s = HibernateUtil.getSessionFactory().getCurrentSession();
        c = 0;
    }

    public void funk() {
        System.out.println("Klick!");
    }

    public void getSizeOfDataBase() {
        long count = s.createQuery("from Val").list().size();
        System.out.println("Database Size -> " + count);
        if (counter <= count) {
            counter++;
        }
    }

    public DataModel getUpdateTable() {
        dataModel = null;
        try {
            org.hibernate.Transaction tx = s.beginTransaction();
            Query q1 = s.createQuery("from Val");
            //Query q1 = s.createQuery("from Val as v where v.id = "+counter);
            tempList = (List<Val>) q1.list();
        } catch (Exception e) {
            // e.printStackTrace();
        }

        //CALL FOR REARRANGEFUNCTION
        
        if (tempList.get(1) != null || tempList.get(2) != null){
            if (tempList.get(1).getId()<tempList.get(2).getId()){
                Collections.reverse(tempList);
            }
        }
            
        

        if (dataModel == null) {
            dataModel = new ListDataModel(tempList);
            //BELOW IS CURRENT SIZE ON TABLE
            if (c % 3 == 0) {
                System.out.println(c / 3 + " <- Started at 0 when building app");
            }
            c++;
        }
        getSizeOfDataBase();

        return dataModel;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public DataModel getNewDataModel() {
        dataModel = getUpdateTable();
        return dataModel;
    }

    public Session getSession() {
        return s;
    }

    /**
     * public DataModel arrangeDataModel(DataModel dm){ for (int a =
     * dm.getRowCount(); a>=0;a--){ for (int b = 0; b <= dm.getRowCount();b++){
     * dm. } } return dm; }
     */
}
//                  int count = ((Long)getSession().createQuery("from Val").uniqueResult()).intValue();
