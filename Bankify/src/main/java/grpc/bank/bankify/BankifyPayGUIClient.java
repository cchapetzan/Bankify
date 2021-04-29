/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpc.bank.bankify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import grpc.bank.bankify.BankPayGrpc.BankPayBlockingStub;
import grpc.bank.bankify.BankPayGrpc.BankPayStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/**
 *
 * @author Camila Chapetzan Antunes
 */
public class BankifyPayGUIClient extends javax.swing.JFrame {

	private static ServiceInfo bankServiceInfo;
	
	private static BankPayBlockingStub blockingStub;
	
	private static BankPayStub asyncStub;
	
	private static ManagedChannel channel;

	private static final Logger logger2 = Logger.getLogger(BankifySocialClient.class.getName());
	
    /**
     * Creates new form BankifySocialGUIClient
     */
    public BankifyPayGUIClient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bankify");
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon("src/main/resources/favicon.png");
        setIconImage(icon.getImage());
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        //setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            		try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
        jLabel2.setText("<html><center><b>Welcome to Bankify Pay.</b><br>Please login to start earning!</center></html>");
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

        jButton1.setText("Reset");
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField4.setText("");
				jPasswordField1.setText("");
				jLabel14.setText("Don't Forget to fill e-mail and password");
			}
		});

        jButton2.setText("Send");
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		email = jTextField4.getText();//"britney@spears.com";
	    		password = String.valueOf(jPasswordField1.getPassword());//"321654";
	    		
	    		if(email.equals("")||password.equals("")) {
	    			if(email.equals("")) jLabel14.setText("Please fill your e-mail.");
	    			if(password.equals("")) jLabel14.setText("Please fill your password.");
	    			return;
	    		}
				
		    	try {
		    	
		    		LoginData request = LoginData.newBuilder().setEmail(email).setPassword(password).build();

			    	LoginPayReply response = blockingStub.holderLogin(request);

			    	logger2.info("Login Status: " + response.getLoginMessage() + " " + response.getFirstName() + " " +  response.getAccountNumber());
			    	 
			    	holderAcc = response.getAccountNumber();
			    	firstName = response.getFirstName();

					jLabel14.setText("Login Status: " + response.getLoginMessage() + " " + response.getFirstName() + " " +  response.getAccountNumber());
					
					
					BankifyPayGUI2 bpgc2 = new BankifyPayGUI2(firstName, email, holderAcc, logger2, channel, blockingStub, asyncStub, bankServiceInfo);
					bpgc2.setVisible(true);
					bpgc.setVisible(false);
					
				
		    	} catch (StatusRuntimeException ex) {
			    	logger2.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());

			    	return;

		    	}

			}
		});

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("E-mail:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password:");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Don't Forget to fill e-mail and password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
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
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
		//String host = "localhost";
		//int port = 50053;

		String bankify_service_type = "_bankify._tcp.local.";
		discoverBankifyService(bankify_service_type);
		
		String host = bankServiceInfo.getHostAddresses()[0];
		int port = bankServiceInfo.getPort();
		
		System.out.println(host+" "+port);
		
		channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		blockingStub = BankPayGrpc.newBlockingStub(channel);
		asyncStub = BankPayGrpc.newStub(channel);

		BankifyPayClient client = new BankifyPayClient();
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
            java.util.logging.Logger.getLogger(BankifyPayGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankifyPayGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankifyPayGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankifyPayGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	bpgc = new BankifyPayGUIClient();
                bpgc.setVisible(true);
            }
        });
    }
    
	private static void discoverBankifyService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Bankify Service resolved: " + event.getInfo());

					bankServiceInfo = jmdns.getServiceInfo(service_type, "bankify_pay");

					int port = bankServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + bankServiceInfo.getNiceTextString());
					System.out.println("\t host: " + bankServiceInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Bank Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Bank Service added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private String firstName;
	private String email;
	private String password;
	private int holderAcc;
	static BankifyPayGUIClient bpgc;
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration                   
}

