package LoveSimulation;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoveFrame extends JFrame{
	
	private Music bgm;
	
	private Graphics screenGraphics;
	private Image screenImage;
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();;
	
	
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	
	
	
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
    private int pointX , pointY;
    
    
    
   
    
    
    public LoveFrame()
	{
    	setUndecorated(true);
    	setTitle("LoveSimulation");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		//basical setting
		
		
		
		///////////////////////////////////////
		//setting exit button 
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		
		
		
		
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
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				bgm.close();
				startButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/school.jpg")).getImage();
			}
		});
		add(startButton);
		
		
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
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);//cursor가 위로 올라 갔을 때 음악 나옴
				buttonEnteredMusic.start();//cursor가 위로 올라 갔을 때 음악 나옴
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000); // exitButton을 눌렀을 때 1초 있다가 창이 종료됨.(이거 없으면 창이 바로 꺼져서 exitButton눌렀을 때 소리 안들림)
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		
		
		///////////////////////////////////////
		//setting menuBar 
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pointX = e.getX();
				pointY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - pointX, y - pointY);
			}
		});
		add(menuBar);
		
		
		
		
		///////////////////////////////////////
		//start bgm 
		bgm = new Music("bgm.mp3",true);
		bgm.start();
        
 
        
	}
	
	public void screenDraw(Graphics g)
	{
		g.drawImage(background, 0, 0, null); // 새로 추가되는 것이 아니라 단순히 이미지를 화면에 출력해주기 위해 사용
		paintComponents(g); //add() 처럼 새로 추가될 때 사용
		this.repaint();
	}
	
	
	public void paint(Graphics g)
	{
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage,0,0,null);
	}
}
