/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.HrOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HrRole.EducationalEventCorporateDashboardJPanel;

/**
 *
 * @author raunak
 */
public class HrRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new HrWorkAreaJPanel(userProcessContainer, account, (HrOrganization)organization, enterprise);
        return new EducationalEventCorporateDashboardJPanel(userProcessContainer, account, (HrOrganization)organization, business, enterprise);
    }
    
    
}
