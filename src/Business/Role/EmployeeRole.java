/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.EmployeeOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.EmployeeRole.EmployeeWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class EmployeeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new HrWorkAreaJPanel(userProcessContainer, account, (HrOrganization)organization, enterprise);
        return new EmployeeWorkAreaJPanel(userProcessContainer, account, (EmployeeOrganization)organization, business, enterprise);
    }
    
    
}
