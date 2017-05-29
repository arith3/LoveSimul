package namori.love.code;

import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SetChaImg extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image img;
	
	public SetChaImg(String filename) throws IOException
	{
		img = ImageIO.read(new File(filename));
		//getImage(img);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		
	}
	
//	public RenderedImage getImage(Image img)
//	{
//		BufferedImage bufferedImage = new BufferedImage(img.getWidth(null),
//				img.getHeight(null), BufferedImage.TYPE_INT_RGB);
//		
//		final Graphics2D g2 = bufferedImage.createGraphics();  
//	      g2.drawImage(img, 0, 0, null);  
//	      g2.dispose();  
//	      return bufferedImage;
//	}
	
	public Image getImg()
	{
		return img;
	}
}
