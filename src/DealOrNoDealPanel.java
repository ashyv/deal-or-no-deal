import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DealOrNoDealPanel extends JPanel {
	JLabel displayLabel;
	JLabel instructionsLabel;
	boolean isGoodChoice;
	boolean isGameOver = true;
	boolean doesAcceptDeal;
	int yourCaseValue = 0;
	Color color;
	JButton[] cases = new JButton[26];
	JLabel[] values = new JLabel[26];
	JLabel messageCasesToOpen = new JLabel("Cases to open: ");
	JLabel messageYourCase = new JLabel("Your case: ");
	JLabel messageLastCase = new JLabel("");
	JLabel messageLastOffer = new JLabel("Last offer: ");

	private int casesToOpen;
	private int yourCase;
	private String lastCase;
	private int lastOffer;
	private int currentOffer;
	
	int round;
	int unopenedCases;
	int caseValue = 0;
	
	boolean continueGame;
	
	Color bColor = new Color(216, 243, 255);
	

	public DealOrNoDealPanel() {
		
		displayLabel = new JLabel("Welcome to Deal or No Deal!");
		instructionsLabel = new JLabel("Pick your case. Will your's contain the million dollars?");
		
		ButtonListener listener = new ButtonListener();
		for (int i = 0; i < 26; i++) {
			cases[i] = new JButton("" + (i + 1));
			cases[i].setPreferredSize(new Dimension(75, 50));
			cases[i].setFont(new Font("Serif", Font.BOLD, 18));
			cases[i].addActionListener(listener);
		}

		values[0] = new JLabel("$ .01");
		values[1] = new JLabel("$ 1");
		values[2] = new JLabel("$ 5");
		values[3] = new JLabel("$ 10");
		values[4] = new JLabel("$ 25");
		values[5] = new JLabel("$ 50");
		values[6] = new JLabel("$ 75");
		values[7] = new JLabel("$ 100");
		values[8] = new JLabel("$ 200");
		values[9] = new JLabel("$ 300");
		values[10] = new JLabel("$ 400");
		values[11] = new JLabel("$ 500");
		values[12] = new JLabel("  $ 750   ");
		values[13] = new JLabel("$ 1000");
		values[14] = new JLabel("$ 5000");
		values[15] = new JLabel("$ 10,000");
		values[16] = new JLabel("$ 25,000");
		values[17] = new JLabel("$ 50,000");
		values[18] = new JLabel("$ 75,000");
		values[19] = new JLabel("$ 100,000");
		values[20] = new JLabel("$ 200,000");
		values[21] = new JLabel("$ 300,000");
		values[22] = new JLabel("$ 400,000");
		values[23] = new JLabel("$ 500,000");
		values[24] = new JLabel("$ 750,000");
		values[25] = new JLabel("$ 1,000,000");

		 color = new Color(255, 229, 55);
		for (int j = 0; j < 26; j++) {
			values[j].setBackground(color);
			values[j].setOpaque(true);
			values[j].setFont(new Font("Serif", Font.BOLD, 16));
			values[j].setHorizontalAlignment(SwingConstants.CENTER);
			values[j].setBorder(BorderFactory.createEtchedBorder(Color.BLACK,
					Color.DARK_GRAY));
		}

		JPanel panel = new JPanel();
		panel.setBackground(bColor);
		panel.setLayout(new BorderLayout());

		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(bColor);
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		instructionsLabel.setFont(new Font("San Seriff", Font.BOLD, 18));
		optionsPanel.add(instructionsLabel);
		
		JPanel yourCasePanel = new JPanel();
		yourCasePanel.setBackground(bColor);
		messageYourCase.setFont(new Font ("San Seriff", Font.BOLD, 14));
		yourCasePanel.add(messageYourCase);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(bColor);
		topPanel.setLayout(new GridLayout(2, 1));
		topPanel.add(optionsPanel);
		topPanel.add(yourCasePanel);

		JPanel casePanel = new JPanel();
		casePanel.setBackground(bColor);
		
		JPanel casePanelRow5 = new JPanel();
		casePanelRow5.setBackground(bColor);
		for (int i = 20; i < 26; i++){
			casePanelRow5.add(cases[i]);
		}

		JPanel casePanelRow4 = new JPanel();
		casePanelRow4.setBackground(bColor);
		for (int i = 15; i < 20; i++) {
			casePanelRow4.add(cases[i]);
		}

		JPanel casePanelRow3 = new JPanel();
		casePanelRow3.setBackground(bColor);
		for (int i = 10; i < 15; i++) {
			casePanelRow3.add(cases[i]);
		}

		JPanel casePanelRow2 = new JPanel();
		casePanelRow2.setBackground(bColor);
		for (int i = 5; i < 10; i++) {
			casePanelRow2.add(cases[i]);
		}

		JPanel casePanelRow1 = new JPanel();
		casePanelRow1.setBackground(bColor);
		for (int i = 0; i < 5; i++) {
			casePanelRow1.add(cases[i]);
		}

		casePanel.setLayout(new GridLayout(5, 1, 3, 15));
		casePanel.add(casePanelRow5);
		casePanel.add(casePanelRow4);
		casePanel.add(casePanelRow3);
		casePanel.add(casePanelRow2);
		casePanel.add(casePanelRow1);

		JPanel leftValuesPanel = new JPanel();
		leftValuesPanel.setBackground(bColor);
		leftValuesPanel.setLayout(new GridLayout(13, 1, 0, 5));
		for (int i = 0; i < 13; i++) {
			leftValuesPanel.add(values[i]);
		}

		JPanel rightValuesPanel = new JPanel();
		rightValuesPanel.setBackground(bColor);
		rightValuesPanel.setLayout(new GridLayout(13, 1, 0, 5));
		for (int i = 13; i < 26; i++) {
			rightValuesPanel.add(values[i]);
		}

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(bColor);
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		messageLastCase.setFont(new Font("San Seriff", Font.BOLD, 18));
		infoPanel.add(messageLastCase);
		
		JPanel commentsPanel = new JPanel();
		commentsPanel.setBackground(bColor);
		commentsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		displayLabel.setFont(new Font ("San Seriff", Font.CENTER_BASELINE, 16));
		commentsPanel.add(displayLabel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(bColor);
		bottomPanel.setLayout(new GridLayout(2,1));
		bottomPanel.add(infoPanel);
		bottomPanel.add(commentsPanel);
		

		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		panel.add(leftValuesPanel, BorderLayout.WEST);
		panel.add(rightValuesPanel, BorderLayout.EAST);
		panel.add(casePanel, BorderLayout.CENTER);

		this.add(panel);
		
		if (isGameOver){
			
		}
	}
	
	
	
	public class ButtonListener implements ActionListener {
		int rand = 0;
		boolean isFirstCase;
		
		int prevCasesToOpen;
		int response;

		public void actionPerformed(ActionEvent evt) {
			int count = 0;
			isFirstCase = true;
			unopenedCases = 0;
			color = new Color(214, 215, 212);
			for (int j = 0; j < 26; j++) {
				if (!cases[j].isEnabled()){
					isFirstCase = false;
				} else
					unopenedCases++;
			}
			
			casesToOpen = howManyCasesToOpen(unopenedCases);
			instructionsLabel.setText("Open " + casesToOpen + " case(s). Try to eliminate the low values.");
			
			if (isFirstCase) {
				yourCase = Integer.parseInt(evt.getActionCommand());
				cases[Integer.parseInt(evt.getActionCommand()) - 1].setEnabled(false);
				messageYourCase.setText("Your case: " + yourCase);
			} else {
				for (int i = 0; i < 26; i++) {

					if (cases[i].getText().equals(evt.getActionCommand())) {
						cases[i].setEnabled(false);

						while (true) {

							rand = (int) (Math.random() * 26);
							if (values[rand].isEnabled()) {
								values[rand].setBackground(color);
								values[rand].setEnabled(false);
								lastCase = "Case " + evt.getActionCommand()
										+ " (" + values[rand].getText() + ")";
								if (rand <= 12){
									isGoodChoice = true;
								}
								else{
									isGoodChoice = false;
								}
								formulateDisplayLabel(isGoodChoice);
								break;
							}
						}
						messageLastCase
						.setText("Last case opened: " + lastCase);
						
						count = 0;
						for (int j = 0; j < 26; j++){
							if (cases [j].isEnabled()){
								count++;
							}
						}
						if (count == 0){
							endGame();
						}
						
						if (prevCasesToOpen == 1){
							round++;
							currentOffer = calculateOffer();
							response = JOptionPane.showConfirmDialog(null, "Last Offer: $" +
							lastOffer + "\n\nCurrent Offer: $" + calculateOffer() + "\nDeal or No Deal?",
									"", JOptionPane.YES_NO_OPTION );
							switch (response){
							case JOptionPane.YES_OPTION: 
								doesAcceptDeal = true;
								endGame();
								break;
							case JOptionPane.NO_OPTION:
								lastOffer = calculateOffer();
								break;
							default:
								lastOffer = calculateOffer();
								break;
							}
							
							
						}
						prevCasesToOpen = casesToOpen;
					}
				}
				
			}
		}
	}

	public int howManyCasesToOpen (int unopenedCases){
		if (unopenedCases > 20){
			return unopenedCases - 20;
		}
		else if (unopenedCases > 15){
			return unopenedCases - 15;
		}
		else if (unopenedCases > 11){
			return unopenedCases - 11;
		}
		else if (unopenedCases > 8){
			return unopenedCases - 8;
		}
		else if(unopenedCases > 6){
			return unopenedCases - 6;
		}
		else
			return 1;
	}
	
	public int calculateOffer(){
		int averageValue = 0;
		for (int i = 0; i < 26; i++){
			if (values[i].isEnabled()){
				averageValue += (Integer.parseInt((values[i].getText()).replaceAll("\\D", "")));
			}
		}
		return (averageValue * round) / (unopenedCases * 10);
	}
	
	public void formulateDisplayLabel(boolean isGoodChoice){
		int randNumber = (int)(Math.random() * 5);
		if (isGoodChoice){
			switch (randNumber){
			case 0: displayLabel.setText("Great Pick!"); break;
			case 1: displayLabel.setText("Fantastic Choice!"); break;
			case 2: displayLabel.setText("You're Amazing!"); break;
			case 3: displayLabel.setText("Wow! Nice Decision!"); break;
			case 4: displayLabel.setText("What Skill!"); break;
			}
		}
		else{
			switch (randNumber){
			case 0: displayLabel.setText("Bad choice."); break;
			case 1: displayLabel.setText("Disappointing decision."); break;
			case 2: displayLabel.setText("Remember, you want low values."); break;
			case 3: displayLabel.setText("You suck."); break;
			case 4: displayLabel.setText("Unlucky."); break;
			}
		}
	}
	
	public String isGoodDeal(){
		if (currentOffer > yourCaseValue){
			return "You made a great deal!";
		}
		else{
			return "You made a bad deal.";
		}
	}
	
	public String isGoodDeal2(){
		if (caseValue > lastOffer){
			return "You made a great deal!";
		}
		else{
			return "You made a bad deal.";
		}
	}
	
	public void endGame (){
		int count = 0;
		
		for (int i = 0; i < 26; i++){
			cases[i].setEnabled(false);
		}
		cases[yourCase - 1].setEnabled(true);
		
		color = new Color(214, 215, 212);
		do {
			int rand = (int)(Math.random() * 26);
			count = 0;
			values[rand].setEnabled(false);
			values[rand].setBackground(color);
			for (int j = 0; j < 26; j++){
				if (values[j].isEnabled()){
					count++;
					yourCaseValue = (Integer.parseInt((values[j].getText()).replaceAll("\\D", "")));
				}
			}
			
		} while (count > 1);
		if (doesAcceptDeal){
			int response = JOptionPane.showConfirmDialog(null, "You won $" + currentOffer + "!\nYour case had $" 
				+ yourCaseValue + ".\n" + isGoodDeal() + "\n\nPlay again?", "", JOptionPane.YES_NO_OPTION);
		
			if (response == JOptionPane.YES_OPTION){
				DealOrNoDealApp.main(null);
			}
			else{
				//end game
			}
		}else {
			for (int j = 0; j < 26; j++){
				if (values[j].isEnabled()){
					caseValue = (Integer.parseInt((values[j].getText()).replaceAll("\\D", ""))); 
				}
			}
			int response2 = JOptionPane.showConfirmDialog(null, "Your won $" + caseValue
					+ ".\nIf you had accepted the last offer, you would have won $" + lastOffer
					+ ".\n" + isGoodDeal2() + "\n\nPlay again?");
			if (response2 == JOptionPane.YES_OPTION){
				DealOrNoDealApp.main(null);
			}
			else{
				//end game
			}
		}
	}	
}
