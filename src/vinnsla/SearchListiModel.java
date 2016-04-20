/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import javax.swing.DefaultListModel;
import model.TripPackage;

/**
 *
 * @author johannesthorkell
 */
public class SearchListiModel extends DefaultListModel {
    public TripPackage[] tripPackages;
    public boolean isTripPackagesSet = false;
    
    public void addTripPackages(TripPackage[] tripPackages) {
        this.tripPackages = tripPackages;
        isTripPackagesSet = true;
        
        for (TripPackage tPack: tripPackages) {
            addElement(makeExcerpt(tPack));
        }
    }
    
    private String makeExcerpt(TripPackage tripPackage) {
        String msg2 = tripPackage.getFlight().getArrivalAirport();
        String msg1 = tripPackage.getReturnFlight().getArrivalAirport();
        String msg3 = tripPackage.getHotel().name;
        String msg = "From " + msg1 + " to " + msg2 + ", accommodations: " + msg3;
        return msg;
    }
}
