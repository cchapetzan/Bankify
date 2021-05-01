/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpc.bank.bankify;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.GroupLayout.Alignment;

import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsBlockingStub;
import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import javax.swing.GroupLayout;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifyTransactionsGUIClient
* - client-side GUI implementation of gRPC service BankifyTransactions
*/
public class BankifyTransactionsGUIClient extends javax.swing.JFrame {
	
	//variables for gRPC and jmDNS
	private static ServiceInfo bankServiceInfo;
	
	private static BankTransactionsBlockingStub blockingStub;
	
	private static BankTransactionsStub asyncStub;
	
	private static ManagedChannel channel;

	private static final Logger logger2 = Logger.getLogger(BankifySocialClient.class.getName());

    /**
     * Creates new form BankifyTransactionsGUIClient
     */
    public BankifyTransactionsGUIClient() {
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

        BufferedImage img = null;
        try {
            background = ImageIO.read(new File("src/main/resources/background.png"));
        } catch (IOException e) {
        }
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new BackgroundPanel(background);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton2.setText("Create your account");

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
        
        /*
         * window closing action listener: chanel shutdown
         */
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
        jLabel2.setText("<html><center><b>Welcome back to Bankify.</b><br>Please login or create your user account!</center></html>");
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

        jButton1.setText("Login to Bankify");
        /*
         * Login to Bankify button action: call a ConfirmDialog to fill e-mail and password
         * - Validate all the fields and call gRPC method userLogin
         * - if positive starts new JFrame BankifyTransactionsGUIActions
         */
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fields for the confirm dialog
				javax.swing.JTextField emailB = new javax.swing.JTextField();
				emailB.setText("");
				javax.swing.JPasswordField passwordB = new javax.swing.JPasswordField();
				passwordB.setText("");
				final javax.swing.JComponent[] inputs = new javax.swing.JComponent[] {
				        new javax.swing.JLabel("E-mail"),
				        emailB,
				        new javax.swing.JLabel("Password"),
				        passwordB
				};
				while(emailB.getText().equals("")||String.valueOf(passwordB.getPassword()).equals("")) {//while fields are blank
					//launch confirm dialog
					int result = javax.swing.JOptionPane.showConfirmDialog(null, inputs, "Please, enter your login details", javax.swing.JOptionPane.PLAIN_MESSAGE);
					if (result == javax.swing.JOptionPane.CLOSED_OPTION) break; //close is click in the "X"
					if (result == javax.swing.JOptionPane.OK_OPTION) {
						//validate fields
						if (!emailB.getText().equals("")&&!String.valueOf(passwordB.getPassword()).equals("")) {
							//gRPC userLogin call
							LoginData request = LoginData.newBuilder().setEmail(emailB.getText()).setPassword(String.valueOf(passwordB.getPassword())).build();
							LoginReply response = blockingStub.userLogin(request);
							if(response.getLoginMessage().equals("Bank User not found")) { //warning dialog
								javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIClient.this, "Bank User not found");						
							}
							else if(response.getLoginMessage().equals("Password missmatch")) { //warning dialog
								javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIClient.this, "Password missmatch");
							}
							else { //confirmation dialog
								javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIClient.this, response.getLoginMessage()+" Welcome back "+response.getFirstName()+".");
								//new BankifyTransactionsGUIActions frame
								BankifyTransactionsGUIActions btgAc = new BankifyTransactionsGUIActions(response.getFirstName(), response.getEmail(), response.getAccountNumber(), btgc, logger2, channel, blockingStub, asyncStub, bankServiceInfo);
								//change for next frame BankifyTransactionsGUIActions
								btgAc.setVisible(true);
								btgc.setVisible(false);
							}
							break;
						} else { //if fields are blank
							javax.swing.JOptionPane.showMessageDialog(BankifyTransactionsGUIClient.this, "Fields cannot be blank");
						}
					
					}
				}
				
			}
		});

        jButton2.setText("Create your account");
        /*
         * Create your account button action: starts new JFrame BankifyTransactionsGUIAdd for user adding
         */
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new BankifyTransactionsGUIAdd frame
				BankifyTransactionsGUIAdd btgAdd = new BankifyTransactionsGUIAdd(btgc, logger2, channel, blockingStub, asyncStub, bankServiceInfo);
				//change for next frame BankifyTransactionsGUIAdd
				btgAdd.setVisible(true);
				btgc.setVisible(false);

			}
		});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(229)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        			.addContainerGap(316, Short.MAX_VALUE)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2))
        			.addGap(61))
        );
        jPanel3.setLayout(jPanel3Layout);

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

    	//jmDNS discovery
		String bankify_service_type = "_bankify._tcp.local.";
		discoverBankifyService(bankify_service_type);
		
		String host;
		int port; 
		try { //server found
			host = bankServiceInfo.getHostAddresses()[0];
			port = bankServiceInfo.getPort();
		} catch (NullPointerException e){
			logger2.info("Cannot find server");
			return;
		}
		
		System.out.println(host+" "+port);
		
		//channel creating for service
		channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		//gRPC service connection
		blockingStub = BankTransactionsGrpc.newBlockingStub(channel);
		asyncStub = BankTransactionsGrpc.newStub(channel);

		BankifyTransactionsClient client = new BankifyTransactionsClient();
		
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
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankifyTransactionsGUIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	btgc = new BankifyTransactionsGUIClient();
                btgc.setVisible(true);
            }
        });
    }
    
  //method discoverBankifyService
  	//this method uses jmDNS to find service host and port
  	private static void discoverBankifyService(String service_type) {
  		
  		
  		try {
  			// Create a JmDNS instance
  			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

  				
  			jmdns.addServiceListener(service_type, new ServiceListener() { //ServiceListener implementation
  				
  				@Override
  				public void serviceResolved(ServiceEvent event) {
  					System.out.println("Bankify Service resolved: " + event.getInfo());

  					bankServiceInfo = jmdns.getServiceInfo(service_type, "bankify_transactions"); //find service info

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
	
    // Variables declaration - do not modify
    private BufferedImage background;
	static BankifyTransactionsGUIClient btgc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private BackgroundPanel jPanel3;
    // End of variables declaration                   
}