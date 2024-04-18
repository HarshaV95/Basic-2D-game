package charactersPkg;

import main.GamePanel;

import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
public Player (GamePanel gp, KeyHandler keyH){
    this.gp = gp;
    this.keyH = keyH;
    
    screenX = gp.screenWidth/2 - (gp.tileSize/2);
    screenY = gp.screenHeight/2 - (gp.tileSize/2);
    
    solidArea = new Rectangle();
    solidArea.x = 8;
    solidArea.y = 16;
    solidArea.width = 24;
    solidArea.height = 28;
    
    setDefaultValues();
    getPlayerImage();
}
    public void setDefaultValues() {

    worldX=gp.tileSize *29;
    worldY=gp.tileSize *29;
    Speed = 3;
    direction = "down";
    }

    public void getPlayerImage() {

    try {
        
    	 up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up1.png"));
         up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up2.png"));
         down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down1.png"));
         down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down2.png"));
         left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left1.png"));
         left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left2.png"));
         right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right1.png"));
         right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right2.png"));

    


    }
    catch(IOException e) {

        e.printStackTrace();

        }
    }

    public  void update() {
    	
    	if( keyH.upPressed == true || keyH.downPressed == true || 
    			
    			keyH.leftPressed == true|| keyH.rightPressed == true   ) {
    		
    		 if(keyH.upPressed == true){
    	            direction = "up";
    	 
    	        }
    	        else if(keyH.downPressed == true) {
    	            direction = "down";
    	       
    	        }
    	        else if(keyH.leftPressed==true){
    	            direction = "left";
    	          

    	        }
    	        else if(keyH.rightPressed==true) {
    	            direction = "right";
    	        
    	        }
    	
    		 collisionOn = false;
    		gp.cChecker.checkTile(this);
    	        
    		if(collisionOn == false) {
    			switch(direction) {
    			case "up":
    		         worldY -= Speed; //Y = Y - Speed
    			  break;
    			case "down":
    				   worldY += Speed;
  			  break;
    			case "left":
    				   worldX -= Speed;
  			  break;
  			  
    			case "right":
    			      worldX += Speed;
  			  break;
    			
    			}
    		}
    	        spriteCounter++;
    	        if(spriteCounter > 12) {
    	        	if(spriteNum == 1) {
    	        		spriteNum =2;
    	        	}
    	        	else if(spriteNum == 2) {
    	        		spriteNum =1;
    	        	}
    	        	
    	        	spriteCounter = 0;
    	        }
    		
    	}

       
        

    }

    public void drew(Graphics2D g2) {
//    g2.setColor(Color.white);
//         g2.fillRect(X,Y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "up":
            	if(spriteNum == 1) {
                image = up1;
            	}
            	if(spriteNum == 2) {
                    image = up2;
            	}
                break;
            case "down":
            	if(spriteNum == 1) {
                    image = down1;
                	}
                	if(spriteNum == 2) {
                        image = down2;
                	}
                break;
            case "left":
            	if(spriteNum == 1) {
                    image = left1;
                	}
                	if(spriteNum == 2) {
                        image = left2;
                	}
                break;
            case "right":
            	if(spriteNum == 1) {
                    image = right1;
                	}
                	if(spriteNum == 2) {
                        image = right2;
                	}
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }


    public void paintComponent(Graphics g) {




    }

}
