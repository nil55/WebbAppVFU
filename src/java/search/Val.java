package search;

public class Val  implements java.io.Serializable {


     private Integer id;
     private String fileName;
     private String dateInTime;
     private String timeOfMesure;
     private Double sensor0;
     private Double sensor1;
     private Double sensor2;
     private Double sensor3;
     private Double sensor4;
     private Double sensor5;
     private Double sensor6;
     private Double sensor7;

    public Val() {
    }

    public Val(String fileName, String dateInTime, String timeOfMesure, Double sensor0, Double sensor1, Double sensor2, Double sensor3, Double sensor4, Double sensor5, Double sensor6, Double sensor7) {
       this.fileName = fileName;
       this.dateInTime = dateInTime;
       this.timeOfMesure = timeOfMesure;
       this.sensor0 = sensor0;
       this.sensor1 = sensor1;
       this.sensor2 = sensor2;
       this.sensor3 = sensor3;
       this.sensor4 = sensor4;
       this.sensor5 = sensor5;
       this.sensor6 = sensor6;
       this.sensor7 = sensor7;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getDateInTime() {
        return this.dateInTime;
    }
    
    public void setDateInTime(String dateInTime) {
        this.dateInTime = dateInTime;
    }
    public String getTimeOfMesure() {
        return this.timeOfMesure;
    }
    
    public void setTimeOfMesure(String timeOfMesure) {
        this.timeOfMesure = timeOfMesure;
    }
    public Double getSensor0() {
        return this.sensor0;
    }
    
    public void setSensor0(Double sensor0) {
        this.sensor0 = sensor0;
    }
    public Double getSensor1() {
        return this.sensor1;
    }
    
    public void setSensor1(Double sensor1) {
        this.sensor1 = sensor1;
    }
    public Double getSensor2() {
        return this.sensor2;
    }
    
    public void setSensor2(Double sensor2) {
        this.sensor2 = sensor2;
    }
    public Double getSensor3() {
        return this.sensor3;
    }
    
    public void setSensor3(Double sensor3) {
        this.sensor3 = sensor3;
    }
    public Double getSensor4() {
        return this.sensor4;
    }
    
    public void setSensor4(Double sensor4) {
        this.sensor4 = sensor4;
    }
    public Double getSensor5() {
        return this.sensor5;
    }
    
    public void setSensor5(Double sensor5) {
        this.sensor5 = sensor5;
    }
    public Double getSensor6() {
        return this.sensor6;
    }
    
    public void setSensor6(Double sensor6) {
        this.sensor6 = sensor6;
    }
    public Double getSensor7() {
        return this.sensor7;
    }
    
    public void setSensor7(Double sensor7) {
        this.sensor7 = sensor7;
    }




}


