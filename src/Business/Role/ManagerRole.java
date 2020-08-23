/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.EmployeeOrganization;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.EmployeeRole.EmployeeWorkAreaJPanel;
import userinterface.ManagerRole.ManagerWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class ManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new HrWorkAreaJPanel(userProcessContainer, account, (HrOrganization)organization, enterprise);
        return new ManagerWorkAreaJPanel(userProcessContainer, account, (ManagerOrganization)organization, business);
    }
    
    
}
