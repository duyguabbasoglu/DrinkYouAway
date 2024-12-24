package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Main_And_System_Class.BeverageSys;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	
	AddDeleteSearchOrderFrame sf = new AddDeleteSearchOrderFrame(this);
	CreateYoursFrame cf = new CreateYoursFrame(this);
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImage;
	
	ImageIcon beverageID = new ImageIcon("images/beverageID.png");
    ImageIcon color = new ImageIcon("images/color.png");
    ImageIcon name = new ImageIcon("images/name.png");
    ImageIcon price = new ImageIcon("images/price.png");
    ImageIcon taste = new ImageIcon("images/taste.png");
    ImageIcon volume = new ImageIcon("images/volume.png");
    ImageIcon cat = new ImageIcon("images/istockphoto-1226643570-612x612.jpg");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 67, 533, 396);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		contentPane.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            textArea.setText(BeverageSys.displayBeverages());
		        }
		    }
		});

		
		contentPane.setFocusable(true);

		
		contentPane.requestFocusInWindow();

		JButton btnNewButton = new JButton("Display Beverages");
		btnNewButton.setBounds(24, 6, 171, 49);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(BeverageSys.displayBeverages());
				
				contentPane.requestFocusInWindow();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add/Delete Order");
		btnNewButton_1.setBounds(207, 6, 171, 49);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				sf.setVisible(true);
				
				contentPane.requestFocusInWindow();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JComboBox<String> displayby = new JComboBox<>(new String[] {
			    "beverageID", "name", "color", "volume", "price", "taste"
			});
		displayby.setBounds(581, 6, 152, 49);
		
		
		displayby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String select = displayby.getSelectedItem().toString();
				
				textArea.setText(BeverageSys.displayBy(select));
				
				contentPane.requestFocusInWindow();
				
				if (displayby.getSelectedItem().equals("beverageID")) {
					lblImage.setIcon(cat);
					
		        } if (displayby.getSelectedItem().equals("name")) {
		        	lblImage.setIcon(cat);
		        } else if (displayby.getSelectedItem().equals("color")) {
		        	lblImage.setIcon(cat);  
		        } else if (displayby.getSelectedItem().equals("volume")) {
		        	lblImage.setIcon(cat);  
		        } else if (displayby.getSelectedItem().equals("price")) {
		        	lblImage.setIcon(cat);  
		        	
		        }else{
		        	lblImage.setIcon(cat);
		        	
		        }  
			}
		});
		//displayby.setModel(new DefaultComboBoxModel(new String[] {"beverageID", "name", "color", "volume", "price", "taste"}));
		contentPane.add(displayby);
		
		JButton createYours = new JButton("Create Yours");
		createYours.setBounds(390, 6, 171, 49);
		createYours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				cf.setVisible(true);
				contentPane.requestFocusInWindow();
			}
		});
		contentPane.add(createYours);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(cat);
		lblImage.setBounds(569, 67, 519, 505);
		contentPane.add(lblImage);
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				
				contentPane.requestFocusInWindow();
			}
		});
		Clear.setBounds(736, 20, 171, 20);
		contentPane.add(Clear);
		
	}
}
