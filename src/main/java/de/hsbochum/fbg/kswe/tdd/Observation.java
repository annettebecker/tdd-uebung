/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;

import org.joda.time.DateTime;

/**
 *
 * @author Annette
 */
public class Observation {

    double value;
    DateTime time;

    Observation(double d, DateTime dateTime) {
        value = d;
        time = dateTime;
    }
    
    Observation(double d, DateTime dateTime, Unit unit) {
        time = dateTime;
        
        //Value in M speichern
        if(unit == Unit.M){
            value = d;
        }
        else if(unit == Unit.DM){
            value = d/10;
        }        
        else if(unit == Unit.CM){
            value = d/100;
        }
        else{
            value = d/1000;
        }
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public DateTime getTime() {
        return time;
    }
    
}
