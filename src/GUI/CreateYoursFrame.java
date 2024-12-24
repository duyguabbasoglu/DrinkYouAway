package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes_Has_A.CreateYours;
import Classes_Is_A.Cocktail;
import Main_And_System_Class.BeverageSys;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class CreateYoursFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDec;
	private JTextField textFieldSyrup;
	private JTextField textFieldJuice;
	
	
	
	private JTextField textFieldAlcoholRate;
	private JTextField textFieldContainer;
	private JTextField textFieldAlcoholType;
	private JTextField textFieldBeverageID;
	private JTextField textFieldName;
	private JTextField textFieldColor;
	private JTextField textFieldVolume;
	private JTextField textFieldTaste;


	MainFrame mf;
	/**
	 * Create the frame.
	 */
	public CreateYoursFrame(MainFrame frame) {
		
		mf = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 50, 125, 233);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Create Yours");
		lblNewLabel.setBounds(169, 11, 114, 33);
		contentPane.add(lblNewLabel);
		
		textFieldDec = new JTextField();
		
		textFieldDec.setBounds(195, 93, 96, 20);
		contentPane.add(textFieldDec);
		textFieldDec.setColumns(10);
		
		JLabel lblEnterDecoration = new JLabel("Enter Decoration");
		lblEnterDecoration.setBounds(197, 42, 114, 33);
		contentPane.add(lblEnterDecoration);
		
		JLabel lblEnterSyrup = new JLabel("Enter Syrup");
		lblEnterSyrup.setBounds(197, 124, 114, 33);
		contentPane.add(lblEnterSyrup);
		
		textFieldSyrup = new JTextField();
		textFieldSyrup.setColumns(10);
		textFieldSyrup.setBounds(197, 168, 96, 20);
		contentPane.add(textFieldSyrup);
		
		JLabel lblEnter = new JLabel("Enter Juice");
		lblEnter.setBounds(197, 199, 114, 33);
		contentPane.add(lblEnter);
		
		textFieldJuice = new JTextField();
		
		textFieldJuice.setColumns(10);
		textFieldJuice.setBounds(197, 232, 96, 20);
		contentPane.add(textFieldJuice);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Kullanıcı girdilerini al
		            int BID = Integer.parseInt(textFieldBeverageID.getText());
		            double ALCRT = Double.parseDouble(textFieldAlcoholRate.getText());
		            double VOL = Double.parseDouble(textFieldVolume.getText());
		            
		            // Diğer metin alanlarını al
		            String DEC = textFieldDec.getText();
		            String SYR = textFieldSyrup.getText();
		            String JUI = textFieldJuice.getText();
		            String CON = textFieldContainer.getText();
		            String ALCTP = textFieldAlcoholType.getText();
		            String TAS = textFieldTaste.getText();
		            String NAM = textFieldName.getText();
		            String COL = textFieldColor.getText();
		            
		            // Değerlerin doğru formatta olduğunu kontrol et
		            if (ALCRT < 0 || VOL < 0) {
		                textArea.setText("Alcohol Rate and Volume must be positive numbers.");
		                return;
		            }

		            // CreateYours ve Cocktail nesnelerini oluştur
		            CreateYours cy = new CreateYours(JUI, SYR, DEC);
		            double PRI = cy.calcPrice();
		            Cocktail cocktail = new Cocktail(BID, NAM, COL, VOL, PRI, TAS, ALCRT, CON, ALCTP, cy);
		            
		            // Menüye ekle ve sonucu göster
		            BeverageSys.addMenu(cocktail);
		            textArea.setText("Cocktail created successfully:\n" + cocktail.toString());
		        } catch (NumberFormatException ex) {
		            // Hatalı format girildiğinde kullanıcıya uyarı göster
		            textArea.setText("Invalid input: Please enter numeric values for Beverage ID, Alcohol Rate, and Volume.");
		        } catch (Exception ex) {
		            // Diğer beklenmedik hatalar için genel bir uyarı
		            textArea.setText("An unexpected error occurred: " + ex.getMessage());
		        }
		    }
		});

		btnNewButton.setBounds(440, 283, 89, 23);
		contentPane.add(btnNewButton);
		
		textFieldAlcoholRate = new JTextField();
		
			
		
		textFieldAlcoholRate.setColumns(10);
		textFieldAlcoholRate.setBounds(321, 95, 96, 20);
		contentPane.add(textFieldAlcoholRate);
		
		JLabel lblEnterAlcoholRate = new JLabel("Enter Alcohol Rate");
		lblEnterAlcoholRate.setBounds(320, 42, 114, 33);
		contentPane.add(lblEnterAlcoholRate);
		
		textFieldContainer = new JTextField();
		
			
		
		textFieldContainer.setColumns(10);
		textFieldContainer.setBounds(321, 168, 96, 20);
		contentPane.add(textFieldContainer);
		
		JLabel lblEnterContainer = new JLabel("Enter Container");
		lblEnterContainer.setBounds(321, 124, 114, 33);
		contentPane.add(lblEnterContainer);
		
		JLabel lblEnterAlcoholType = new JLabel("Enter Alcohol Type");
		lblEnterAlcoholType.setBounds(321, 199, 114, 33);
		contentPane.add(lblEnterAlcoholType);
		
		textFieldAlcoholType = new JTextField();
		
			
		textFieldAlcoholType.setColumns(10);
		textFieldAlcoholType.setBounds(321, 232, 96, 20);
		contentPane.add(textFieldAlcoholType);
		
		textFieldBeverageID = new JTextField();
		
		textFieldBeverageID.setColumns(10);
		textFieldBeverageID.setBounds(440, 95, 96, 20);
		contentPane.add(textFieldBeverageID);
		
		JLabel lblEnterBeverageId = new JLabel("Enter Beverage ID");
		lblEnterBeverageId.setBounds(444, 42, 114, 33);
		contentPane.add(lblEnterBeverageId);
		
		textFieldName = new JTextField();
		
		textFieldName.setColumns(10);
		textFieldName.setBounds(440, 168, 96, 20);
		contentPane.add(textFieldName);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setBounds(440, 124, 114, 33);
		contentPane.add(lblEnterName);
		
		textFieldColor = new JTextField();
		
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(440, 232, 96, 20);
		contentPane.add(textFieldColor);
		
		JLabel lblEnterColor = new JLabel("Enter Color");
		lblEnterColor.setBounds(440, 199, 114, 33);
		contentPane.add(lblEnterColor);
		
		JLabel lblEnterPrice_1 = new JLabel("Enter Volume");
		lblEnterPrice_1.setBounds(320, 254, 114, 33);
		contentPane.add(lblEnterPrice_1);
		
		textFieldVolume = new JTextField();
		
		textFieldVolume.setColumns(10);
		textFieldVolume.setBounds(321, 284, 96, 20);
		contentPane.add(textFieldVolume);
		
		textFieldTaste = new JTextField();
		
		textFieldTaste.setColumns(10);
		textFieldTaste.setBounds(195, 284, 96, 20);
		contentPane.add(textFieldTaste);
		
		JLabel lblEnterPrice_1_1 = new JLabel("Enter Taste");
		lblEnterPrice_1_1.setBounds(195, 254, 114, 33);
		contentPane.add(lblEnterPrice_1_1);
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				mf.setVisible(true);
			}
		});
		exitButton.setBounds(28, 311, 89, 23);
		contentPane.add(exitButton);
	}
}