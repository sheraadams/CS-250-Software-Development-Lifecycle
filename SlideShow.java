// Shera Adams

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;



public class SlideShow extends JFrame 
{

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException 
	{
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() 
	{
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.WHITE);  // changed blue color to white to make the text more visible
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top Detox Destinations"); 
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) 
		{
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				goPrevious();
			}
		});
		
		buttonPane.add(btnPrev);

		
		//added space before and after next to create evenly sized previous and next buttons
		btnNext.setText("    Next    "); 
		btnNext.addActionListener(new ActionListener() 
		{ 

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				goNext();
			}
		});
		
		buttonPane.add(btnNext);
		
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() 
	{
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() 
	{
		card.next(slidePane);
		cardText.next(textPane);
	}

	/* Images for all destinations. Added high resolution royalty-free images for free for commercial and noncommercial use/ Attribution is not required. 
	 * APA citation in folder containing the images for reference.
	 */
	private String getResizeIcon(int i) 
	{
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/costarica.jpg") + "'</body></html>"; 
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/sedona.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/nepal.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/egypt.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/grandcanyon.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/* Text descriptions for all destinations
	 * enlarged fonts to increase readability
	 */
	private String getTextDescription(int i) 
	{
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>1. Costa Rica</font> <br>Release toxins and find new inspiration at the beautiful Ayurveda Yoga Wellness Retreats. </body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>2. Sedona</font> <br>Visit some of the most famous detox centers in the world and experience mind-body healing in the beautiful Sedona, Arizona.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>3. Nepal</font> <br>Rejuvenate your mind and body and realign yourself with yoga and meditation in the world class retreats of Nepal.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>4. Egypt</font> <br>Immerse yourself in the history of ancient civilizations as you realign body, mind, and spirit in breathtaking landscapes.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>5. Grand Canyon</font> <br>Relax in nature and find wellness and adventure in the breathtaking views of the Grand Canyon.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}