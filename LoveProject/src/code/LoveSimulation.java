package code;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LoveSimulation extends JPanel{
	
	//private Music bgm;
	//private JFrame frame;
	
	//private Image background = new ImageIcon("introBackground.jpg").getImage();
	private Image background = new ImageIcon(LoveFrame.class.getResource("../images/introBackground.jpg")).getImage();
	
	
	
	private TalkPan fl = new TalkPan();
	
	
	private ImageIcon quitButtonBasicImage = new ImageIcon(LoveFrame.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(LoveFrame.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(LoveFrame.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(LoveFrame.class.getResource("../images/startButtonEntered.png"));
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);

    
    
    public LoveSimulation()
	{
//    	frame = new JFrame("LoveSimulation");
//    	
//		frame.setSize(Stat.FrameWidth,Stat.FrameHeight);
//		frame.setResizable(false);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.setLayout(null);
		//basical setting
		
		
		JPanel p1 = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(background, 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
		
		p1.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
        p1.setLayout(null);
        
        p1.add(quitButton);
        p1.add(startButton);
        
        
        LoveFrame.getFrame().add(p1);
	
        p1.setVisible(true);
        
//        JPanel p2 = new JPanel(){
//            public void paintComponent(Graphics g) {
//                g.drawImage(background, 0, 0, null);
//                setOpaque(false);
//                super.paintComponent(g);
//               } 
//        };
//
//        p2.setBounds(0, 0, 1280, 720);
//        p2.setLayout(null);
//        
//        frame.add(p2);
        
        
		
		
		
		
		///////////////////////////////////////
		//setting start button 
		startButton.setBounds(800, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
//				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
//				buttonEnteredMusic.start();
				
				p1.setVisible(false);
				LoveFrame.getFrame().add(fl.getMain());
			}
		});
		
		
		
		///////////////////////////////////////
		//setting quit button 
		quitButton.setBounds(800, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);//quitButton을 quitButtonEnteredImage로 change
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//cursor를 손 모양으로 바꿈
//				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//cursor가 위로 올라 갔을 때 음악 나옴
//				buttonEnteredMusic.start();//cursor가 위로 올라 갔을 때 음악 나옴
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
//				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
//				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000); // exitButton을 눌렀을 때 1초 있다가 창이 종료됨.(이거 없으면 창이 바로 꺼져서 exitButton눌렀을 때 소리 안들림)
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		
		
		
		 
		
		///////////////////////////////////////
		//start bgm 
//		bgm = new Music("bgm.mp3",true);
//		bgm.start();
//        
		
        
	}
   
    
}
