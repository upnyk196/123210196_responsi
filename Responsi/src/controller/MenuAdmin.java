/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viewresponsi.MenuPage;
import viewresponsi.MenuAdmin; 
import model.HostelryModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author User
 */
public class MenuAdmin {
    MenuAdmin MA;
    HostelryModel HM;
    public MA(MenuAdmin MA, HostelryModel HM) {
        this.MA = MA;
        this.HM = HM;
        MA.btnroomlist.addActionListener(new ActionListenerActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               RoomListView RLV=new RoomListView();
                RoomListController RLC=new RoomListController(RLV,HM);
                RLV.setVisible(true);
                MA.dispose();
            }
        });
        MA.btnrenterlist.addActionListener(new ActionListenerActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                RenterDataView RDV=new RenterDataView();
                RoomListController RLC=new RoomListController(HM,RDV);
                RDV.setVisible(true);
                MA.dispose();
            }
        });
        MA.btnlogout.addActionListener(new ActionListenerActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AdminPageView APV=new AdminPageView();
                LoginAdminController LAC=new LoginAdminController(APV,HM);
                APV.setVisible(true);
                MA.dispose();
            }
        });
    }
    
}
