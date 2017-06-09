/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;

import java.util.ArrayList;

/**
 *
 * @author Annette
 */
class TimeSeries {

    String name;
    ArrayList <Observation> list; 
    
    TimeSeries(String name){
        name = name;
        list = new ArrayList();          
    }

    void addObservation(Observation observation) {
        list.add(observation);
    }
    
    double calculateMean(){
        double sum = 0;
        for (Observation o : list){
            sum += o.getValue();
        }
        return sum / list.size();
    }
    
    double calculateMean(Unit unit){
        double sum = 0;
        for (Observation o : list){
            if(null == unit)
                sum += o.getValue();
            else switch (unit) {
                case M:
                    sum += o.getValue();
                    break;
                case DM:
                    sum += o.getValue()*10;
                    break;
                case CM:
                    sum += o.getValue()*100;
                    break;
                default:
                    sum += o.getValue()*1000;
                    break;
            }
        }
        return sum / list.size();
    }
    
}
