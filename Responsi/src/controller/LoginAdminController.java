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
public class LoginAdminController {
    AdminPageView APV;
    HostelryModel HM;
    public LoginAdminController(AdminPageView APV,HostelryModel HM) {
        this.APV=APV;
        this.HM=HM;
        APV.btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(HM.loginAdmin(APV.getUsername(), APV.getPassword())){
                    MenuAdmin MA=new MenuAdmin();
                    MenuAdmin MAC=new MenuAdmin(MA,HM);
                    MMAV.setVisible(true);
                    APV.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username/password!");
                }
            }
        });
        APV.btnuser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginPageView LPV=new LoginPageView();
                LoginPageController LPC=new LoginPageController(LPV,HM);
                LPV.setVisible(true);
                APV.dispose();
            }
        });
    } 
}
