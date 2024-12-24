package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes_Has_A.Order;
import Main_And_System_Class.BeverageSys;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDeleteSearchOrderFrame extends JFrame {
public AddDeleteSearchOrderFrame(MainFrame mf) {
		
		sf=mf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 86, 265, 238);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton createOrder = new JButton("Create Order");
		createOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField1.getText().isEmpty() && textField2.getText().isEmpty())
					textArea.setText("Enter a beverage and quantity id");
				
				else if(textField1.getText().isEmpty())
					textArea.setText("Enter a beverage id");
				
				else if(textField2.getText().isEmpty())
					textArea.setText("Enter quantity");
				
				if(BeverageSys.addOrder(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()))) {
					textArea.setText("Order has been added");
				}
				else
					textArea.setText("The drink you have entered couldn't be found !");
				
				
			}
		});
		createOrder.setBounds(254, 15, 130, 23);
		contentPane.add(createOrder);
		
		JLabel lblNewLabel = new JLabel("drink id : ");
		lblNewLabel.setBounds(31, 6, 66, 38);
		contentPane.add(lblNewLabel);
		
		textField1 = new JTextField();
		textField1.setBounds(98, 12, 130, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("quantity :");
		lblQuantity.setBounds(31, 38, 66, 38);
		contentPane.add(lblQuantity);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(98, 44, 130, 26);
		contentPane.add(textField2);
		
		JButton getReceipt = new JButton("Receipt");
		getReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText(BeverageSys.displayReceipt());
			}
		});
		getReceipt.setBounds(388, 15, 130, 23);
		contentPane.add(getReceipt);
		
		JButton Close = new JButton("CLOSE");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				sf.setVisible(true);
			}
		});
		Close.setBounds(31, 412, 130, 52);
		contentPane.add(Close);
		
		JButton deleteOrder = new JButton("Delete Order");
		deleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField3.getText().isEmpty())
					textArea.setText("Enter an order id");
				
				Order o = BeverageSys.searchOrder(Integer.parseInt(textField3.getText()));
				
				if(o != null)
					textArea.setText("order has been deleted" + o.toString());
				
				else
					textArea.setText("That order doesn't exist");
				
				BeverageSys.removeOrder(Integer.parseInt(textField3.getText()));
					
				
			}
		});
		deleteOrder.setBounds(530, 15, 130, 23);
		contentPane.add(deleteOrder);
		
		JLabel lblorderid = new JLabel("Enter Order ID :");
		lblorderid.setBounds(308, 88, 102, 38);
		contentPane.add(lblorderid);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(412, 94, 130, 26);
		contentPane.add(textField3);
		
		JButton btnNewButton = new JButton("Search Order");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
       
            	
                try {
                	
                    int id = Integer.parseInt(textField3.getText());
                    if (BeverageSys.getOrder(id).isEmpty()) {
                    	textArea.setText("Order is empty");
                    } else {
                    	textArea.setText(BeverageSys.getOrder(id));
                    }
                } catch (NumberFormatException ex) {
                	textArea.setText("Enter an order id");
                }
            }
        });
        
        btnNewButton.setBounds(530, 44, 127, 29);
        contentPane.add(btnNewButton);
        
        
	}
	
	MainFrame sf;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
}
