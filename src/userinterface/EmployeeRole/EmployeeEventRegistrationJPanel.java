/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EmployeeRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EmployeeOrganization;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationEventWorkRequest;
import Business.WorkQueue.ManagerApprovalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Anish Gupta
 */
public class EmployeeEventRegistrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeEventRegistrationJPanel
     */
    private JPanel userProcessContainer;
    EducationEventWorkRequest request;
    UserAccount account;
    Organization organization;
    EcoSystem business;

    public EmployeeEventRegistrationJPanel(JPanel userProcessContainer, EducationEventWorkRequest request, UserAccount account,Organization organization, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.account=account;
        this.organization=(EmployeeOrganization)organization;
        this.business = business;
        instructorsRequiredTextBox.setText(request.getInstructorRequired());
        dateTextBox.setText(request.getDate());
        venueTextBox.setText(request.getDate());
        ngoTextBox.setText(request.getNgoName());
        workshopNameTextBox.setText(request.getWorkshopName());
        subjectTextBox.setText(request.getTopics());
        eventTextBox.setText(request.getDuration());
        commentsTextBox.setText(request.getComments());
        registerEnabled();
    }
    
    public void registerEnabled(){
        try{
        for(WorkRequest req: organization.getWorkQueue().getWorkRequestList()){
            if(req instanceof ManagerApprovalWorkRequest){
                ManagerApprovalWorkRequest managerReq = (ManagerApprovalWorkRequest)req;
                if(managerReq.getNgoEventReq()==request){
                if(!(managerReq.getSender()==account)){
                    Register.setEnabled(true);
                }
                else
                    Register.setEnabled(false);
            }
        }
        }}
        catch(Exception e){
            Register.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        eventTextBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        commentsTextBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Register = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ngoTextBox = new javax.swing.JTextField();
        instructorsRequiredTextBox = new javax.swing.JTextField();
        dateTextBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        venueTextBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        subjectTextBox = new javax.swing.JTextField();
        workshopNameTextBox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        backJButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Instructors Required :");

        eventTextBox.setEditable(false);
        eventTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Date :");

        commentsTextBox.setEditable(false);
        commentsTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentsTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentsTextBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Venue:");

        Register.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/register.png"))); // NOI18N
        Register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Subject to be taught:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Event duration:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("HR Comments :");

        ngoTextBox.setEditable(false);
        ngoTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        instructorsRequiredTextBox.setEditable(false);
        instructorsRequiredTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        instructorsRequiredTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorsRequiredTextBoxActionPerformed(evt);
            }
        });

        dateTextBox.setEditable(false);
        dateTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Education Workshop Details");

        venueTextBox.setEditable(false);
        venueTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("NGO :");

        subjectTextBox.setEditable(false);
        subjectTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        workshopNameTextBox.setEditable(false);
        workshopNameTextBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Workshop Name :");

        backJButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/back.png"))); // NOI18N
        backJButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backJButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(commentsTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(eventTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Register, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(subjectTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(venueTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(dateTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(instructorsRequiredTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(workshopNameTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ngoTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ngoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(workshopNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(instructorsRequiredTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(venueTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(subjectTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(eventTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(commentsTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register)
                    .addComponent(backJButton4))
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void commentsTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentsTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentsTextBoxActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        
        
        String date = dateTextBox.getText();
        
        ManagerApprovalWorkRequest managerRequest = new ManagerApprovalWorkRequest();
        
        managerRequest.setDate(date);
        managerRequest.setSender(account);
        managerRequest.setStatus("Pending with Manager");
        managerRequest.setNgoEventReq(request);
        for(Network network : business.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(organization instanceof ManagerOrganization)
                        managerRequest.setReceiver(organization.getUserAccountDirectory().getUserAccount(account.getEmployee().getManagerId()));
                }
            }
        }        
        
        organization.getWorkQueue().getWorkRequestList().add(managerRequest);
        account.getWorkQueue().getWorkRequestList().add(managerRequest);
        
        JOptionPane.showMessageDialog(null, "Registration Approval Request Sent to Manager");
        Register.setEnabled(false);
//            System.out.println(organization.getWorkQueue().getWorkRequestList());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterActionPerformed

    private void instructorsRequiredTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorsRequiredTextBoxActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_instructorsRequiredTextBoxActionPerformed

    private void backJButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton4ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        Component[] comps = userProcessContainer.getComponents();
        for(Component c: comps) {
            if(c instanceof EmployeeWorkAreaJPanel) {
                EmployeeWorkAreaJPanel panel = (EmployeeWorkAreaJPanel) c;
                panel.populateTable();
                panel.populateEventRegistrationStatusTable();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_backJButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Register;
    private javax.swing.JButton backJButton4;
    private javax.swing.JTextField commentsTextBox;
    private javax.swing.JTextField dateTextBox;
    private javax.swing.JTextField eventTextBox;
    private javax.swing.JTextField instructorsRequiredTextBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField ngoTextBox;
    private javax.swing.JTextField subjectTextBox;
    private javax.swing.JTextField venueTextBox;
    private javax.swing.JTextField workshopNameTextBox;
    // End of variables declaration//GEN-END:variables
}
