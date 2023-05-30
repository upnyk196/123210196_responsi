/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.HostelryModel;
import viewresponsi.LoginPageView;
import viewresponsi.AdminPageView;
/**
 *
 * @author User
 */
public class LoginPageController {
     LoginPageView LPV;
     HostelryModel HM;
    public LoginPageController(LoginPageView LPV, HostelryModel HM) {
        this.LPV=LPV;
        this.HM=HM;
      LUV.btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(HM.loginPage(LPV.getUsername(), LPV.getPassword())){
                   Menu Mn=new Menu();
                   MenuPage MC=new MenuPage(MC,HM,LPV.getUsername());
                    mc.setVisible(true);
                    LPV.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username/password!");
                }
            }
        });
        LPV.btnadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               AdminPageView APV=new AdminPageView();
               LoginAdminController LAC=new LoginAdminController(APV,HM);
                APV.setVisible(true);
                LPV.dispose();
            }
        });
    } 



