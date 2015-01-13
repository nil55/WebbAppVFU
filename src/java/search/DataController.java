/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author nils
 */
@ManagedBean
@SessionScoped
public class DataController {

    int startId;
    int endId;
    int sensor;
    DataModel dataTitles;
    DataModel myModel;
    DataHelper collecter;
    private int recordCount = 10;
    private int pageSize =3;
    private Val current;
    private int selectedItemIndex;

    public DataController() {
        collecter = new DataHelper();
        startId = 1;
        endId = getPageSize();
    }

    public DataController(int startId, int endId) {
        collecter = new DataHelper();
        this.startId = startId;
        this.endId = endId;
    }

    public Val getSelected() {
        if (current == null) {
            current = new Val();
            selectedItemIndex = -1;
        }
        return current;
    }

    public DataModel getDataIdModel() {
        if (dataTitles == null) {
            System.out.println("TEST 0.1");
            dataTitles = new ListDataModel(collecter.getDataFromId(startId, endId));
            //dataTitles = new ListDataModel(collecter.getDataFromSensor1(startId, endId));
        }
        return dataTitles;

    }
    public DataModel getMyFunction(){
        if (dataTitles == null) {
            System.out.println("TEST 0.1");
            dataTitles = new ListDataModel(collecter.getDataFromId(startId, endId));
            //dataTitles = new ListDataModel(collecter.getDataFromSensor1(startId, endId));
        }
        return dataTitles;
    }
    
    void recreateModel() {
        dataTitles = null;
    }

    public boolean isHasNextPage() {
        return endId + pageSize <= recordCount;
    }

    public boolean isHasPreviousPage() {
        return startId - pageSize > 0;
    }

    public String next() {
        startId = endId + 1;
        endId = endId + pageSize;
        recreateModel();
        return "index";
    }

    public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "index";
    }

    public int getPageSize() {
        return pageSize;
    }

    public String prepareList() {
        recreateModel();
        return "index";
    }

}
