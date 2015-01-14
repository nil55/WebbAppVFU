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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nils
 */
@ManagedBean
@SessionScoped
public class DataController {

    DataModel dataModel;
    List<Val> tempList = null;
    Session s = null;

    public DataController() {
        this.s = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public DataModel getUpdateTable() {
        try {
            org.hibernate.Transaction tx = s.beginTransaction();
            Query q1 = s.createQuery("from Val as v where v.id = 1");
            tempList = (List<Val>) q1.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dataModel == null) {
            dataModel = new ListDataModel(tempList);
        }
        return dataModel;
    }
}
