/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EmployeeRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EmployeeOrganization;
import Business.Organization.NgoAdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationEventWorkRequest;
import Business.WorkQueue.ManagerApprovalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anish Gupta
 */
public class EmployeeWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private EmployeeOrganization employeeOrganization;
    private Enterprise employeeEnterprise;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public EmployeeWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.employeeOrganization = (EmployeeOrganization)organization;
        this.employeeEnterprise = enterprise;
        
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
                            if(request instanceof EducationEventWorkRequest){
                                EducationEventWorkRequest req = (EducationEventWorkRequest) request;
                                if(req.getEnterpriseList().size()>0){
                                for(String enterpriseName : req.getEnterpriseList()){
                                    if(enterpriseName == employeeEnterprise.getName() ){                                  

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
                }
            }
        }
    
    
    public void populateEventRegistrationStatusTable(){
        DefaultTableModel model = (DefaultTableModel)eventRegistrationStatusJTable.getModel();        
        model.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(organization instanceof EmployeeOrganization){
                        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
                            if(request.getSender() == userAccount){
                                ManagerApprovalWorkRequest req = (ManagerApprovalWorkRequest) request;
                                Object[] row = new Object[4];
                    //            row[0] = request;
                    //            row[1] = request.getSender().getEmployee().getName();
                    //            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                    //            row[3] = request.getStatus();

                                row[0] = req;
                                row[1] = req.getNgoEventReq();
                                row[2] = req.getNgoEventReq().getNgoName();
                                row[3] = req.getStatus();
//                                row[3] = request.getVenue();
                                        
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        detailsJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventRegistrationStatusJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        refreshJButton2 = new javax.swing.JButton();
        unregisterJButton = new javax.swing.JButton();
        createQuizJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Employee Volunteer Portal");

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Workshop Name", "NGO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        detailsJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        detailsJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/view details.png"))); // NOI18N
        detailsJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detailsJButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        detailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/refresh.png"))); // NOI18N
        refreshJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refreshJButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        eventRegistrationStatusJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eventRegistrationStatusJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Workshop Name", "NGO", "Registration Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Event Registrations :");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NGO Event Table :");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        refreshJButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/refresh.png"))); // NOI18N
        refreshJButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refreshJButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refreshJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton2ActionPerformed(evt);
            }
        });

        unregisterJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unregisterJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/unregister.png"))); // NOI18N
        unregisterJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        unregisterJButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        unregisterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unregisterJButtonActionPerformed(evt);
            }
        });

        createQuizJButton.setBackground(new java.awt.Color(255, 255, 255));
        createQuizJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createQuizJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/create quiz for event.png"))); // NOI18N
        createQuizJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        createQuizJButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        createQuizJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createQuizJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailsJButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(unregisterJButton))
                        .addComponent(createQuizJButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unregisterJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(createQuizJButton)
                .addGap(196, 196, 196))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select row from table");
            return;
        }

        EducationEventWorkRequest request = (EducationEventWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);

        //        request.setStatus("Processing");

        EmployeeEventRegistrationJPanel empEventRegistrationJPanel = new EmployeeEventRegistrationJPanel(userProcessContainer, request, userAccount, employeeOrganization, business);
        userProcessContainer.add("empEventRegistrationJPanel", empEventRegistrationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_detailsJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();        //        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void refreshJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton2ActionPerformed
        populateEventRegistrationStatusTable();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshJButton2ActionPerformed

    private void unregisterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregisterJButtonActionPerformed
        int selectedRow = eventRegistrationStatusJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select row from table");
            return;
        }

        ManagerApprovalWorkRequest approvalRequest = (ManagerApprovalWorkRequest)eventRegistrationStatusJTable.getValueAt(selectedRow, 0);
        EducationEventWorkRequest ngoEvtReq = approvalRequest.getNgoEventReq();
        
        if(!(approvalRequest.getStatus().equals("Event Cancelled"))){
        ngoEvtReq.getEmployeeList().remove(userAccount.getEmployee());
        if(ngoEvtReq.getEmployeeWaitList().size() > 0)
        {
            Employee waitlistedEmp = ngoEvtReq.getEmployeeWaitList().get(0);
            ngoEvtReq.getEmployeeList().add(waitlistedEmp);
            for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(organization instanceof EmployeeOrganization){
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

    private void createQuizJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createQuizJButtonActionPerformed
        int selectedRow = eventRegistrationStatusJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select row from table");
            return;
        }

        ManagerApprovalWorkRequest request = (ManagerApprovalWorkRequest)eventRegistrationStatusJTable.getValueAt(selectedRow, 0);
        EducationEventWorkRequest ngoEvtReq = request.getNgoEventReq();
//        if(ngoEvtReq)
        if(!(request.getStatus().equals("Event Cancelled"))){
        if(request.getStatus()=="Registered"){
            EmployeeInstructorQuizCreationJPanel eventQuizCreationJPanel = new EmployeeInstructorQuizCreationJPanel(userProcessContainer, ngoEvtReq);
            userProcessContainer.add("eventQuizCreationJPanel", eventQuizCreationJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Event Cancelled!");
        }
        //        request.setStatus("Processing");

           
        // TODO add your handling code here:
    }//GEN-LAST:event_createQuizJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createQuizJButton;
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
