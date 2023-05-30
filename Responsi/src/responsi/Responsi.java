/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import controller.LoginPageController;
import model.HostelryModel;
import viewresponsi.LoginPageView;
/**
 *
 * @author User
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginPageView LPV=new LoginPageView();
        HostelryModel HM=new HostelryModel();
        LoginPageController LPC=new LoginPageController(LPV,HM);
        LPV.setVisible(true);
    }
    
}

