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
    DataModel dataModel;
    List<Val> tempList = null;
    Session s = null;

    public DataController() {
        this.s = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void funk(){
        System.out.println("Klick!");
    }
    
    public void getSizeOfDataBase(){
        long count = s.createQuery("from Val").list().size();
        System.out.println("B  "+count+"  XXXXXXXXXXXX");
        if (counter <= count){                    
            counter++;
        }
    }
    
    public DataModel getUpdateTable() {
        try {
            org.hibernate.Transaction tx = s.beginTransaction();
            Query q1 = s.createQuery("from Val as v where v.id = "+counter);
            tempList = (List<Val>) q1.list();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dataModel == null) {
            dataModel = new ListDataModel(tempList);
            System.out.println("A  "+ dataModel.getRowCount() +"  XXXXXXXXXXXX");
        }
        else{
            if (dataModel.getRowCount() != 0){
                getSizeOfDataBase();
            }
        }
        return dataModel;
    }
    public Session getSession(){
        return s;
    }
}
//                  int count = ((Long)getSession().createQuery("from Val").uniqueResult()).intValue();
