/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import controller.AdalVidmot;
import controller.SkodaPakka;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.TripPackage;

/**
 *
 * @author johannesthorkell
 */
public class StyringListi implements ListSelectionListener {
    private final AdalVidmot adalGluggi;
    SearchListiModel slm;

    public StyringListi (AdalVidmot adalGluggi) {
        this.adalGluggi = adalGluggi;
        slm = adalGluggi.searchListiModel;
    }

    @Override
    public void valueChanged (ListSelectionEvent evt) {  
        ListSelectionModel lsm = (ListSelectionModel)evt.getSource();
        int i = lsm.getMinSelectionIndex();
        if (i == -1 || !slm.isTripPackagesSet) return;
        
        skodaFerdaPakka(i);
    }
    
    private void skodaFerdaPakka(int i) {
        TripPackage pakki = slm.tripPackages[i];
        SkodaPakka skodaPakka = new SkodaPakka(adalGluggi, true);
        skodaPakka.setLabels(pakki);
        skodaPakka.setVisible(true);
    }
}
