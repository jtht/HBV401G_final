/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import java.util.Vector;

/**
 *
 * @author Mogget
 */
public class DayTourSearchMock {
    public Object[] search(String tripName, String tripType, Object[] propinfo){
        Vector<String> searchpositives = new Vector<>();
        searchpositives.add("Tilraun");
        return searchpositives.toArray();
    }
}
