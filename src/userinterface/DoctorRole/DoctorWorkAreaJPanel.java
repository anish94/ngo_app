/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.NgoAdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HealthEventWorkRequest;
import Business.WorkQueue.HodApprovalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private DoctorOrganization doctorOrganization;
    private Enterprise doctorEnterprise;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.doctorOrganization = (DoctorOrganization)organization;
        this.doctorEnterprise = enterprise;
        
        populateTable();
        populateEventRegistrationStatusTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(organization instanceof NgoAdminOrganization){
                        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
                            if(request instanceof HealthEventWorkRequest){
                                HealthEventWorkRequest req = (HealthEventWorkRequest) request;
                                if(req.getEnterpriseList().size()>0){
                                for(String enterpriseName : req.getEnterpriseList()){
                                    if(enterpriseName == doctorEnterprise.getName() ){                                  

                                        Object[] row = new Object[2];
                            //            row[0] = request;
                            //            row[1] = request.getSender().getEmployee().getName();
                            //            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                            //            row[3] = request.getStatus();
                                        row[0] = req;
                                        row[1] = req.getNgoName();

                                        model.addRow(row);
                                }
                            }
                        }
                    }
                }
            }
        }
            }}}
    
    
    public void populateEventRegistrationStatusTable(){
        DefaultTableModel model = (DefaultTableModel)eventRegistrationStatusJTable.getModel();        
        model.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(organization instanceof DoctorOrganization){
                        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
                            if(request.getSender() == userAccount){
                                
                                HodApprovalWorkRequest req = (HodApprovalWorkRequest) request;
                                
                                Object[] row = new Object[4];
                    //            row[0] = request;
                    //            row[1] = request.getSender().getEmployee().getName();
                    //            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                    //            row[3] = request.getStatus();

                                row[0] = req;
                                row[1] = req.getNgoEventReq();
                                row[2] = req.getNgoEventReq().getNgoName();
                                row[3] = req.getStatus();
                                        
                                model.addRow(row);
                                }
                            }
                        }
                    }
                }
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

        detailsJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventRegistrationStatusJTable = new javax.swing.JTable();
        createPrescriptionJButton = new javax.swing.JButton();
        unregisterJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        refreshJButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        detailsJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        detailsJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/view details.png"))); // NOI18N
        detailsJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/refresh.png"))); // NOI18N
        refreshJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NGO Event Table :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Doctor Volunteer Portal");

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Camp Name", "NGO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        eventRegistrationStatusJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eventRegistrationStatusJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Camp Name", "NGO", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(eventRegistrationStatusJTable);

        createPrescriptionJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createPrescriptionJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/create prescription for camp.png"))); // NOI18N
        createPrescriptionJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        createPrescriptionJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPrescriptionJButtonActionPerformed(evt);
            }
        });

        unregisterJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unregisterJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/unregister.png"))); // NOI18N
        unregisterJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        unregisterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unregisterJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Event Registrations :");

        refreshJButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/refresh.png"))); // NOI18N
        refreshJButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refreshJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createPrescriptionJButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(unregisterJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(detailsJButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unregisterJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createPrescriptionJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select row from table");
            return;
        }

        HealthEventWorkRequest request = (HealthEventWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);

        //        request.setStatus("Processing");

        DoctorEventRegistrationJPanel doctorEventRegistrationJPanel = new DoctorEventRegistrationJPanel(userProcessContainer, request, userAccount, doctorOrganization, business);
        userProcessContainer.add("doctorEventRegistrationJPanel", doctorEventRegistrationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_detailsJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void createPrescriptionJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPrescriptionJButtonActionPerformed
        int selectedRow = eventRegistrationStatusJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select row from table");
            return;
        }

        HodApprovalWorkRequest request = (HodApprovalWorkRequest)eventRegistrationStatusJTable.getValueAt(selectedRow, 0);
        HealthEventWorkRequest ngoEvtReq = request.getNgoEventReq();
        //        if(ngoEvtReq)
        if(!(request.getStatus().equals("Event Cancelled"))){
        if(request.getStatus().equals("Registered")){
            DoctorPrescriptionJPanel presCreationJPanel = new DoctorPrescriptionJPanel(userProcessContainer, ngoEvtReq, doctorOrganization, doctorEnterprise, business);
            userProcessContainer.add("presCreationJPanel", presCreationJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
                request.setStatus("Processing");
        }
        else{
            JOptionPane.showMessageDialog(null, "Event Cancelled!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_createPrescriptionJButtonActionPerformed

    private void unregisterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregisterJButtonActionPerformed
        int selectedRow = eventRegistrationStatusJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select row from table");
            return;
        }

        HodApprovalWorkRequest approvalRequest = (HodApprovalWorkRequest)eventRegistrationStatusJTable.getValueAt(selectedRow, 0);
        HealthEventWorkRequest ngoEvtReq = approvalRequest.getNgoEventReq();
        
        if(!(approvalRequest.getStatus().equals("Event Cancelled"))){
        ngoEvtReq.getDoctorList().remove(userAccount.getEmployee());
        if(ngoEvtReq.getDoctorWaitList().size() > 0)
        {
            Employee waitlistedEmp = ngoEvtReq.getDoctorWaitList().get(0);
            ngoEvtReq.getDoctorList().add(waitlistedEmp);
            for (Network network : business.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if(organization instanceof DoctorOrganization){
                            for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
                                if(request.getSender().getEmployee() == waitlistedEmp){

                                    request.setStatus("Registered");

                                }
                            }
                        }
                    }
                }
            }
        }
        approvalRequest.setStatus("Unregistered");
        populateEventRegistrationStatusTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Event Cancelled!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_unregisterJButtonActionPerformed

    private void refreshJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton2ActionPerformed
        populateEventRegistrationStatusTable();        
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshJButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createPrescriptionJButton;
    private javax.swing.JButton detailsJButton;
    private javax.swing.JTable eventRegistrationStatusJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton refreshJButton2;
    private javax.swing.JButton unregisterJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
