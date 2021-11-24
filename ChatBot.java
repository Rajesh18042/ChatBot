package FinalProject;

import java.awt.event.*;
import java.io.IOException;
import java.awt.Desktop;
import java.awt.Color;
import java.net.*;
import javax.swing.*;

class Chat extends JFrame {
	
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	private JButton tb = new JButton();
	private JLabel tl = new JLabel();
	int count=0;
	
	Chat() throws Exception{
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(400, 400);
		f.getContentPane().setBackground(Color.YELLOW);
		f.setTitle("Virtual HelpDesk");
		f.add(ta);
		f.add(tf);
		ta.setSize(300,310);
		ta.setLocation(2, 2);
		ta.setBackground(Color.WHITE);
		tf.setSize(300,20);
		tf.setLocation(2, 320);
		f.add(tb);
		tl.setText("Send");
		tb.add(tl);
		tb.setSize(75,20);
		tb.setLocation(305, 320);
		
		
		tb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				if(e.getSource()==tb) {
					String text=tf.getText().toLowerCase();
					String copy=text;
					ta.append("You : "+text+"\n");
					tf.setText("");
					
					if((text.contains("hi"))||(text.contains("hello"))) {
						reply("Hi there! How Can I Help You?");
					}
					else if((text.contains("how are you"))||(text.contains("how r u"))||(text.contains("hru"))) {
						reply("I am Great:) Thanks for asking.\nHow about you?");
					}
					else if((text.contains("good"))||(text.contains("fine"))||(text.contains("great"))||(text.contains("awesome"))||(text.contains("very good"))) {
						reply("Cool:) Whats Next?");
					}
					else if((text.contains("bad"))||(text.contains("worst"))||(text.contains("not good"))) {
						reply("OOPS:( Sorry. \nHope you will get better things from now!");
					}
					else if((text.contains("your name"))||(text.contains("ur name"))) {
						reply("My name is Leo");
					}
					else if(text.contains("help")) {
						reply("I am here to serve you. Tell me what to do!");
					}
					else if(text.contains("bye")) {
						reply("Too soon :( That's Ok\n STAY HOME STAY SAFE. Have a nice Day:)");
					}
					else if((text.contains("www."))||(text.contains(".com"))) {
						try {
							Desktop.getDesktop().browse(new URI ("https://google.com/search?q=ip+address+of+"+copy));
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (URISyntaxException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}
					
					else if(count>=1) {
							try {
								Desktop.getDesktop().browse(new URI ("https://google.com/search?q="+copy));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						count--;
					}
				
				
					else {
						reply("OOPS :( I'm Unable to get you\nCould You Please repeat it Clearly?");
						count=1;
					}
				}
			}
		});
		
	}
	public void reply(String r) {
		ta.append("Bot : "+r+"\n");
	}
}

public class ChatBot {

	public static void main(String[] args) throws Exception{
		new Chat();

	}

}
