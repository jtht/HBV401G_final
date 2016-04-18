/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mogget
 */
public class FlightSearchMock {
    public List<FlightMock> search(int peopleCount, Date d, String aA, String dA){
        FlightMock tmp = new FlightMock();
        List<FlightMock> res = new ArrayList<>();
        res.add(tmp);
        return res;
    }
}
