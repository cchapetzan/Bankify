/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpc.bank.bankify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsBlockingStub;
import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsStub;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifyTransactionsGUIActions
* - client-side GUI implementation of gRPC service BankifyTransactions
* - Frame that manage all account transactions via gRPC
*/
public class BankifyTransactionsGUIActions extends javax.swing.JFrame {
	
	//variables for gRPC and jmDNS
	private static ServiceInfo bankServiceInfo;
	
	private static BankTransactionsBlockingStub blockingStub;
	
	private static BankTransactionsStub asyncStub;
	
	private static ManagedChannel channel;

	private static Logger logger2;
	
	private static BankifyTransactionsGUIClient parent;

    /**
     * Creates new form BankifySocialGUIClient
     * special constructor for receiving data from BankifyTransactionsGUIClient
     */
    public BankifyTransactionsGUIActions(String firstName, String email, int accNumber, BankifyTransactionsGUIClient parent, Logger logger2, ManagedChannel channel, BankTransactionsBlockingStub blockingStub2, BankTransactionsStub asyncStub2, ServiceInfo bankServiceInfo) {
    	this.logger2 = logger2;
    	this.channel = channel;
    	this.blockingStub = blockingStub2;
    	this.asyncStub = asyncStub2;
    	this.bankServiceInfo = bankServiceInfo;
    	this.parent = parent; //parent frame for returning if needed
    	this.firstName = firstName;
    	this.email = email;
    	this.accNumber = accNumber;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bankify");
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon("src/main/resources/favicon.png");
        setIconImage(icon.getImage());
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        //setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        
        /*
         * window closing action listener: call userLogout gRPC method
         * - if successfull returns to BankifyTransactionsGUIClient frame
         */
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	
            	//gRPC userLogout method
				LogoutData request = LogoutData.newBuilder().setEmail(email).build(); 
   	    	 	BankReply response = blockingStub.userLogout(request);
   	    	 	logger2.info("Logout Status: " + response.getMessage());
   	    	 	//returning to previous screen
            	BankifyTransactionsGUIActions.this.setVisible(false);
            	parent.setVisible(true);
            	//JFrame dispose
            	BankifyTransactionsGUIActions.this.dispose();
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/resources/bf_logo_test.png")); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 80));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 80));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 80));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><center><b>Welcome to Bankify Pay, "+firstName+".</b><br>Manage your account here.</center></html>");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setInheritsPopupMenu(false);
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 400));

        jLabel7.setText("What woukd you like to do, "+firstName+"?");

        buttonGroup1.add(jRadioButton3); //Radio button for action choose
        jRadioButton3.setText("Check Balance");
        /*
         * Check Balance action listener: set necessary fields visible for method
         */
        jRadioButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        jLabel4.setVisible(true);
		        jPasswordField1.setVisible(true);
		        jLabel6.setVisible(false);
		        jTextField3.setVisible(false);
		        jLabel8.setVisible(false);
		        jTextField4.setVisible(false);
		        jButton1.setVisible(true);
		        jButton2.setVisible(true);
		        jTextArea1.setText("");

			}
		});

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Account Movement");
        /*
         * Account Movement action listener: set necessary fields visible for method
         */
        jRadioButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        jLabel4.setVisible(true);
		        jPasswordField1.setVisible(true);
		        jLabel6.setVisible(false);
		        jTextField3.setVisible(false);
		        jLabel8.setVisible(false);
		        jTextField4.setVisible(false);
		        jButton1.setVisible(true);
		        jButton2.setVisible(true);
		        jTextArea1.setText("");

			}
		});

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Transfer to another Bankify account");
        /*
         * Transfer to another Bankify account action listener: set necessary fields visible for method
         */
        jRadioButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        jLabel4.setVisible(true);
		        jPasswordField1.setVisible(true);
		        jLabel6.setVisible(true);
		        jTextField3.setVisible(true);
		        jLabel8.setVisible(true);
		        jTextField4.setVisible(true);
		        jButton1.setVisible(true);
		        jButton2.setVisible(true);
		        jTextArea1.setText("");

			}
		});

        jLabel3.setText("Account Number:");
        jTextField1.setText(String.valueOf(accNumber));
        jTextField1.setEditable(false);

        jLabel4.setText("Pin:");
        jLabel4.setVisible(false);
        jPasswordField1.setVisible(false);

        jLabel5.setText("Account Movement:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setText("Transfer to Acc:");
        jLabel6.setVisible(false);
        jTextField3.setVisible(false);

        jLabel8.setText("Value:");
        jLabel8.setVisible(false);
        jTextField4.setVisible(false);
        
        jButton1.setVisible(false);
        jButton2.setVisible(false);

        jButton1.setText("Reset");
        /*
         * Reset button action: clear all fields
         */
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPasswordField1.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
			}
		});

        jButton2.setText("Send");
        /*
         * Send button action: Validate all the fields and call gRPC method according to the selected RadioButton
         * - if successfull shows result on the correct fields
         */
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jRadioButton3.isSelected()) { // get balance is selected
						//validate fields
	    				if(!String.valueOf(jPasswordField1.getPassword()).matches("[0-9]{4}")) { //non valid pin
	    					javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, "Pin must be a 4 digit number");
	    				} else {
	    					//gRPC method getBalance
	    					pin = Integer.valueOf(String.valueOf(jPasswordField1.getPassword()));
	    					AccountData request = AccountData.newBuilder().setAccountNumber(accNumber).setPin(pin).build();
	    					FloatReply response = blockingStub.getBalance(request);
	    					if(response.getBalance() == -1) { //MessageDialog error
	    		    		 javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, response.getMessage());
	    		    	 	} else { //if successfull, shows balance on screen
	    		    		 	jLabel9.setText("Balance: \u20ac"+response.getBalance());
	    		    		 	javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, response.getMessage()+" "+response.getBalance());
	    		    		}
	    				}
	    			}
	    			if(jRadioButton4.isSelected()) { // account movement is selected
	    				//validate fields
	    				if (!String.valueOf(jPasswordField1.getPassword()).matches("[0-9]{4}")) {
	    					javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, "Pin must be a 4 digit number");
	    				} else {
	    					//gRPC method accountMovement
	    					pin = Integer.valueOf(String.valueOf(jPasswordField1.getPassword()));
	    					AccountData request = AccountData.newBuilder().setAccountNumber(accNumber).setPin(pin).build();
	    					Iterator<MovementData> responseMov = blockingStub.accountMovement(request);
	    					if(responseMov.hasNext()) { //has an answer
	    						String temp = responseMov.next().getMovement();
	    						if(temp.equals("Bank User not found")||temp.equals("User not logged in ")||temp.equals("Invalid pin")) //MessageDialog error
	    							javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, temp);
	    						else { //if successfull, shows movement on screen TextArea
	    							temp+="\n";
	    							while(responseMov.hasNext()) {
	    								temp += responseMov.next().getMovement() + "\n";
	    							}
	    							jTextArea1.setText(temp);
	    						}
	    					} else {
	    						javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, "Invalid pi");
	    					}
	    				}
		    		
	    			}
	    			if(jRadioButton5.isSelected()) { // transfer to other account is selected
	    				//validate fields
	    				if(!String.valueOf(jPasswordField1.getPassword()).matches("[0-9]{4}")) {
	    					javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, "Pin must be a 4 digit number");
	    					return;
	    				}
	    				if(!jTextField3.getText().matches("[0-9]{6}")) {
	    					javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, "Destination account must be a 6 digit number");
	    					return;
	    				}
	    				if(!jTextField4.getText().matches("[0-9]+")) {
	    					javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, "Value must be an exact number");
	    					return;
	    				}
	    				//gRPC method transferBalance
    					pin = Integer.valueOf(String.valueOf(jPasswordField1.getPassword()));
    					int toAccNumber = Integer.valueOf(jTextField3.getText());
    					float value = Float.valueOf(jTextField4.getText());
    					AccountTransfer request = AccountTransfer.newBuilder().setAccountNumber(accNumber).setPin(pin).setToAccountNumber(toAccNumber).setValue(value).build();
    		    		FloatReply response = blockingStub.transferBalance(request);
    		    		if(response.getBalance() == -1) { //MessageDialog error
    		    			javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, response.getMessage());
    		    		} else { //if successfull, shows balance on screen
    		    			jLabel9.setText("Balance: \u20ac"+response.getBalance());
    		    			javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIActions.this, response.getMessage()+" "+response.getBalance());
    		    		}
    		    	
	    			}
	    			//reset fields
	    			jPasswordField1.setText("");
	    			jTextField3.setText("");
					jTextField4.setText("");
		    	} catch (StatusRuntimeException ex) {
			    	logger2.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());

			    	return;

		    	}

			}
		});

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Balance:");

        jButton3.setText("Logout");
        /*
         * Logout button listener: call userLogout gRPC method
         * - if successfull returns to BankifyTransactionsGUIClient frame
         */
        jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gRPC userLogout method
				LogoutData request = LogoutData.newBuilder().setEmail(email).build(); 
   	    	 	BankReply response = blockingStub.userLogout(request);
   	    	 	logger2.info("Logout Status: " + response.getMessage());
   	    	 	//returning to previous screen
            	BankifyTransactionsGUIActions.this.setVisible(false);
            	parent.setVisible(true);
            	//JFrame dispose
            	BankifyTransactionsGUIActions.this.dispose(); 		
			}
		});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField1)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(22, 22, 22))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankifyTransactionsGUIActions(firstName, email, accNumber, parent, logger2, channel, blockingStub, asyncStub, bankServiceInfo).setVisible(true);
            }
        });
    }

    //BankifyTransactions data
    private static String firstName;
    private static String email;
    private static int accNumber;
    private static String password;
    private static int pin = 0;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
