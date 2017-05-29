package namori.love.code;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SetChaImg2 {

	
	
	private RenderedImage getImage() {

	    int width = 400;
	    int height = 400;

	    // Create a buffered image in which to draw
	    BufferedImage bufferedImage = new BufferedImage(width, height,
	            BufferedImage.TYPE_INT_RGB);

	    // Create a graphics contents on the buffered image
	    Graphics2D g2d = bufferedImage.createGraphics();

//	    // Draw graphics
//	    g2d.setColor(Color.WHITE);
//	    g2d.fillRect(0, 0, width, height);
//	    
	    g2d.setComposite(AlphaComposite.Clear);
	    g2d.fillRect(0, 0, width, height);

	    g2d.setComposite(AlphaComposite.Src);
	    //drawPoints(JPanel.getDefaultLocale(), g2d, Color.BLACK);
	    g2d.drawImage(bufferedImage, 0, 0, null);

	    // Graphics context no longer needed so dispose it
	    g2d.dispose();

	    return bufferedImage;
	}
	
	
}
