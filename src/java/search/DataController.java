/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import hibernater.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nils
 */
// @WebServlet("/face")
@ManagedBean
@SessionScoped
public class DataController {

    long counter = 1;
    int c;
    int size = 100;
    DataModel dataModel;
    List<Val> tempList = null;
    Session s = null;

    public DataController() {
        this.s = HibernateUtil.getSessionFactory().getCurrentSession();
        this.c = 0;
    }
    public DataModel getUpdateTable() {
        dataModel = null;
        try {
            org.hibernate.Transaction tx = s.beginTransaction();
            Query q1 = s.createQuery("from Val as v order by v.id desc").setMaxResults(10);
            tempList = (List<Val>) q1.list();
        } catch (Exception e) {
            // e.printStackTrace();
        }

        if (dataModel == null) {
            dataModel = new ListDataModel(tempList);
            //BELOW IS CURRENT SIZE ON TABLE
            if (c % 3 == 0) {
                System.out.println(c / 3 + " <- Started at 0 when building app");
            }
            c++;
        }
        return dataModel;
    }

    public void setSize(int s) {
        
        if (tempList != null) {
            if (s > tempList.size()) {
                size = tempList.size();
            } else {
                size = s;
            }
        }
    }
    
    
    public int getSize() {
        return size;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public Session getSession() {
        return s;
    }

}
