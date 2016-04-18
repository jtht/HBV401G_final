/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mogget
 */
public class HotelSearchMock {
    public List<HotelMock> findHotels(HotelSearchFilterMock filter) {
        HotelMock tmp = new HotelMock();
        List<HotelMock> res = new ArrayList<>();
        res.add(tmp);
        return res;
    }
}
