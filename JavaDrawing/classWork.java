//Name:Anastassiya Neznanova
//MAC190: Introduction into Object-Oriented Programming
//Date:10/03/2014
//Department of Computer Science
//This Program draws cat, lights, caterpillar, and message on canvas.
//@All Rights Reserved
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Object;

      public class classWork extends JApplet {
      public static final int FACE_DIAMETER = 40;
      public static final int X_FACE0 = 120;
      public static final int Y_FACE0 = 610;
      
      public static final int EYE_WIDTH = 5;
      public static final int EYE_HEIGHT = 10;
      public static final int X_RIGHT_EYE0 = 155;
      public static final int Y_RIGHT_EYE0 = 615;
      public static final int X_LEFT_EYE0 = 160;
      public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;
      
      public static final int CATERP_LEGS_X1 = 168;
      public static final int CATERP_LEGS_Y1 = 649;
      public static final int CATERP_LEGS_X2 = 168;
      public static final int CATERP_LEGS_Y2 = 655;
      public static final int CATERP_LEGS_X1R = 161;
      public static final int CATERP_LEGS_Y1R = 649;
      public static final int CATERP_LEGS_X2R = 161;
      public static final int CATERP_LEGS_Y2R = 655;
      
      public static final int NOSE_DIAMETER = 6;
      public static final int X_NOSE0 = 156;
      public static final int Y_NOSE0 = 625;
      
      public static final int CIRCLE = 15;
      public static final int X_CIRCLE = 169;
      public static final int Y_CIRCLE = 620;
      
      public static final int MOUTH_WIDTH = 13;
      public static final int MOUTH_HEIGHT0 = 0;
      public static final int X_MOUTH0 = 152;
      public static final int Y_MOUTH0 = 635;
      public static final int MOUTH_START_ANGLE = 180;
      public static final int MOUTH_EXTENT_ANGLE = 180;
      
      public static final int CATERPI_X1=157;
      public static final int CATERPI_Y1=605;
      public static final int CATERPI_X2=157;
      public static final int CATERPI_Y2=615;
      
      public static final int CATERPI_XX1=160;
      public static final int CATERPI_YY1=605;
      public static final int CATERPI_XX2=160;
      public static final int CATERPI_YY2=613;
      
      public void init() {  
          setSize(1100,800);  
      }  
      public void paint(Graphics canvas)
      {
	  canvas.setColor(Color.cyan);//background
	  canvas.drawRect(0, 0, 2000, 2000);
	  canvas.fillRect(0, 0, 2000, 2000);
	   
	  int i, xOffset, yOffset; 
	  for (i = 0; i <= 4; i++){
	  xOffset = 15 * i;
	  yOffset = 10 * i;
          
               if (i % 2 == 0) {
               canvas.setColor(Color.green);//draws three circles that are parts of caterpillar
               canvas.fillOval(X_FACE0 + xOffset+30, Y_FACE0 + yOffset,FACE_DIAMETER, FACE_DIAMETER);
               
                canvas.setColor(Color.BLACK);//frame of each circle of caterpillar
                canvas.drawOval(X_FACE0 + xOffset+30, Y_FACE0 + yOffset,FACE_DIAMETER, FACE_DIAMETER);
                
                canvas.setColor(Color.black);//draws caterpillar legs
                canvas.drawLine(CATERP_LEGS_X1+xOffset, CATERP_LEGS_Y1+yOffset,CATERP_LEGS_X2+xOffset , CATERP_LEGS_Y2+yOffset);
                canvas.drawLine(CATERP_LEGS_X1R+xOffset, CATERP_LEGS_Y1R+yOffset,CATERP_LEGS_X2R+xOffset , CATERP_LEGS_Y2R+yOffset);
                
                canvas.setColor(Color.magenta); canvas.fillOval(X_CIRCLE + xOffset, Y_CIRCLE + yOffset,CIRCLE, CIRCLE);//little circles on the body of caterpillar
               }    
                    }
          
                canvas.setColor(Color.BLUE); canvas.fillOval(X_RIGHT_EYE0 , Y_RIGHT_EYE0 , EYE_WIDTH, EYE_HEIGHT);//draws eyes of caterpillar
                canvas.fillOval(X_LEFT_EYE0, Y_LEFT_EYE0, EYE_WIDTH, EYE_HEIGHT);  
                canvas.setColor(Color.BLACK);//draws nose
                canvas.fillOval(X_NOSE0, Y_NOSE0, NOSE_DIAMETER, NOSE_DIAMETER);
   
                canvas.setColor(Color.RED);//draws mouth
                canvas.drawArc(X_MOUTH0, Y_MOUTH0, MOUTH_WIDTH, MOUTH_HEIGHT0, MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE);	 
    
                canvas.setColor(Color.black);//draws two little antennas on caterpillar head
                canvas.drawLine(CATERPI_X1, CATERPI_Y1,CATERPI_X2, CATERPI_Y2);
                canvas.drawLine(CATERPI_XX1, CATERPI_YY1,CATERPI_XX2, CATERPI_YY2);
   
	            for (i = 0; i <= 7; i++){//draws little yellow circles on top
	    	      int x=150*i;
	    	      int y=10*i;
	              canvas.setColor(Color.yellow);
	    	      canvas.fillOval(100+x, 100+y, 20, 20);
	    	      canvas.setColor(Color.BLACK);
	    	      canvas.drawOval(100+x,100+y,20,20);
            }
                for (i = 0; i <= 7; i++){//draws little red circles on top
		          int x=140*i;
		          int y=13*i;
		          canvas.setColor(Color.red);
		          canvas.fillOval(120+x, 50+y, 20, 20);
		          canvas.setColor(Color.BLACK);
		          canvas.drawOval(120+x,50+y,20,20);
		    }
    
          int []x = {220,300,240};//ears of cat
          int []y = {244,200,150};
		  canvas.setColor(Color.BLUE);
		  canvas.drawPolygon(x,y,3);
		  canvas.fillPolygon(x,y,3);
		 
		  int []xx = {300,420,380};//ears of cat
		  int []yy = {244,260,150};
		  canvas.setColor(Color.BLUE);
		  canvas.drawPolygon(xx,yy,3);
		  canvas.fillPolygon(xx,yy,3);
		   
		  int []xxx = {340,420,380};// pink part of ear
		  int []yyy = {244,260,150};
		  canvas.setColor(Color.PINK);
		  canvas.fillPolygon(xxx,yyy,3);
		  canvas.setColor(Color.BLACK);
		  canvas.drawPolygon(xxx,yyy,3);
		 
		  int []xxxx = {220,280,240};//pink part of ear
		  int []yyyy = {244,210,150};
		  canvas.setColor(Color.PINK);
		  canvas.fillPolygon(xxxx,yyyy,3);
		  canvas.setColor(Color.BLACK);
		  canvas.drawPolygon(xxxx,yyyy,3);
		 
		  canvas.setColor(Color.BLUE);//cat's neck
		  canvas.fillRect(280,370,70,200);
		  canvas.drawRect(280,370,70,200);
		 
		  canvas.setColor(Color.BLUE);// left back paw
		          canvas.fillOval(253, 567, 33, 23);
		          canvas.setColor(Color.black);
		  canvas.drawOval(253, 567, 33, 23);
		   
		  canvas.setColor(Color.BLUE);// right back paw
		          canvas.fillOval(352, 567, 33, 23);
		          canvas.setColor(Color.black);
		  canvas.drawOval(352, 567, 33, 23);
		 
		  canvas.setColor(Color.blue);//tail
		  canvas.drawArc(360, 385, 200, 230, 20, 150);
		  canvas.drawArc(361, 386, 200, 230, 20, 150);
		  canvas.drawArc(362, 387, 200, 230, 20, 150);
		  canvas.drawArc(363, 388, 200, 230, 20, 150);
		  canvas.drawArc(364, 389, 200, 230, 20, 150);
		  canvas.drawArc(365, 390, 200, 230, 20, 150);
		  canvas.drawArc(366, 391, 200, 230, 20, 150);
		  canvas.drawArc(367, 392, 200, 230, 20, 150);
		  canvas.drawArc(368, 393, 200, 230, 20, 150);
		  canvas.drawArc(369, 394, 200, 230, 20, 150);
		  canvas.drawArc(370, 395, 200, 230, 20, 150);
		  canvas.drawArc(371, 396, 200, 230, 20, 150);
		  canvas.drawArc(372, 397, 200, 230, 20, 150);
		  canvas.drawArc(373, 398, 200, 230, 20, 150);
		   
		  canvas.setColor(Color.BLUE);//body part
		           canvas.fillOval(200, 200, 230, 200);
		           canvas.setColor(Color.black);
		  canvas.drawOval(200, 200, 230, 200);
		 
		  canvas.setColor(Color.white);//white eye
		  canvas.fillOval(240,250,60,70);
		  canvas.setColor(Color.black);
		  canvas.drawOval(240,250,60,70);
		   
		  canvas.setColor(Color.white);//second white eye
		  canvas.fillOval(330,250,60,70);
		  canvas.setColor(Color.black);
		  canvas.drawOval(330,250,60,70);
		
		  canvas.setColor(Color.ORANGE);//second oval in the eye
		  canvas.fillOval(255,255,40,50);
		  canvas.setColor(Color.black);
		  canvas.drawOval(255,255,40,50);
		   
		  canvas.setColor(Color.ORANGE);//second oval in the eye
		  canvas.fillOval(335,255,40,50);
		  canvas.setColor(Color.black);
		  canvas.drawOval(335,255,40,50);
		   
		  canvas.setColor(Color.white);  //the smallest oval in the eye
		  canvas.fillOval(272,260,20,30);
		  canvas.setColor(Color.black);
		  canvas.drawOval(272,260,20,30);
		   
		  canvas.setColor(Color.white);//second smallest oval in the eye
		  canvas.fillOval(339,260,20,30);
		  canvas.setColor(Color.black);
		  canvas.drawOval(339,260,20,30);
		   
		   
		  canvas.drawArc(220, 240, 95,85, 60,50);//eyebrow
		  canvas.drawArc(310, 242, 95,85, 60,50);//eyebrow
		 
		  canvas.setColor(Color.pink);//nose
		  canvas.fillOval(305,310,20,10);
		  canvas.setColor(Color.black);
		  canvas.drawOval(305,310,20,10);
		   
		  canvas.drawArc(176, 200, 95,85, -70,-30);//eyelashes
		  canvas.drawArc(170, 208, 95,85, -60,-30);//eyelashes
		   
		  canvas.drawLine(265, 323, 262, 333);//line below eye
		  canvas.drawLine(270, 323, 267, 330);//line below eye
		   
		  canvas.drawArc(349, 200, 95,85, -70,-30);//eyelashes
		  canvas.drawArc(341, 208, 95,85, -60,-30);//eyelashes
		   
		  canvas.drawLine(365, 323, 368, 333);//line below eye
		  canvas.drawLine(370, 323, 373, 330);//line below eye
		   
		 
		  canvas.drawArc(265, 270, 95,85, -70,-30);//mouth
		   
		  canvas.drawLine(150,  318,  240, 325);//mustache
		  canvas.drawLine(155,  333,  237, 335);
		  canvas.drawLine(150,  346,  240, 342);
		   
		  canvas.drawLine(390,  325,  470, 318);//mustache
		  canvas.drawLine(395,  333,  475, 335);
		  canvas.drawLine(390,  342,  470, 346);
		   
		  canvas.setColor(Color.YELLOW);//half moon on forehead
		  canvas.drawArc(285, 180, 55,55, -50, -80);
		  canvas.fillArc(285, 180, 55,0, -50, -80);
		   
		  canvas.setColor(Color.YELLOW); //filling the haalf moon
		  canvas.drawOval(297, 228, 31, 6);
		  canvas.fillOval(297, 228, 31, 6);
		   
		  canvas.setColor(Color.BLUE);//body
		  canvas.drawOval(245,390,140,130);
		  canvas.fillOval(245,390,140,130);
		   
		  canvas.setColor(Color.BLUE);//body
		  canvas.drawOval(225,440,180,140);
		  canvas.fillOval(225,440,180,140);
		   
		  canvas.setColor(Color.black);//paws
		  canvas.drawLine(248, 440, 300, 570);
		   
		  canvas.setColor(Color.black);//paws
		  canvas.drawLine(282, 460, 320, 572);
		  canvas.setColor(Color.black);//paws
		  canvas.drawLine(380, 440, 340, 570);
		   
		  canvas.setColor(Color.black);//paws
		  canvas.drawLine(350, 460, 322, 570);
		   
		  canvas.setColor(Color.BLUE);//right paw
		           canvas.fillOval(319, 567, 30, 23);
		           canvas.setColor(Color.black);
		  canvas.drawOval(319, 567, 30, 23);
		   
		  canvas.setColor(Color.BLUE);//left paw
		           canvas.fillOval(290, 567, 30, 23);
		           canvas.setColor(Color.black);
		  canvas.drawOval(290, 567, 30, 23);
		   
		  canvas.setColor(Color.black);//left paw's claws
		  canvas.drawLine(300, 568, 302, 589);
		   
		  canvas.setColor(Color.black);//left paw's claws
		  canvas.drawLine(310, 568, 312, 589);
		  canvas.setColor(Color.black);//right paw's claws
		  canvas.drawLine(328, 568, 326, 588);
		   
		  canvas.setColor(Color.black);//right paw's claws
		  canvas.drawLine(338, 568, 336, 589);
		   
		  canvas.setColor(Color.black);//right back paw's claws
		  canvas.drawLine(364, 568, 363, 586);
		   
		  canvas.setColor(Color.black);//right back paw's claws
		  canvas.drawLine(374, 568, 375, 589);
		  canvas.setColor(Color.black);//left back paw's claws
		  canvas.drawLine(273, 568, 274, 589);
		   
		  canvas.setColor(Color.black);//left back paw's claws
		  canvas.drawLine(264, 568, 262, 589);
		  canvas.setColor(Color.black);//fur
		  canvas.drawLine(282, 460, 288, 472);
		   
		  canvas.setColor(Color.black);//fur
		  canvas.drawLine(288, 472, 293, 462);
		   
		  canvas.setColor(Color.black);//fur
		  canvas.drawLine(293, 462, 296, 476);
		   
		  canvas.setColor(Color.black);//fur
		  canvas.drawLine(296, 476, 300, 468);
		   
		  canvas.setColor(Color.black);//fur
		  canvas.drawLine(300, 468, 303, 481);
		   
		  canvas.setColor(Color.black);//fur
		  canvas.drawLine(303, 481, 304, 473);
		   
           canvas.setColor(Color.DARK_GRAY);//tree
           canvas.drawRect(710, 500, 40, 200);
           canvas.fillRect(710, 500, 40, 200);
 
           canvas.setColor(Color.green);
           canvas.drawOval(600, 250, 270, 330);//tree
           canvas.fillOval(600, 250, 270, 330);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(670, 280, 50, 50);
           canvas.fillOval(670, 280, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(750, 280, 50, 50);
           canvas.fillOval(750, 280, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(790, 350, 50, 50);
           canvas.fillOval(790, 350, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(710, 350, 50, 50);
           canvas.fillOval(710, 350, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(630, 350, 50, 50);
           canvas.fillOval(630, 350, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(660, 430, 50, 50);
           canvas.fillOval(660, 430, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(770, 430, 50, 50);
           canvas.fillOval(770, 430, 50, 50);
          
           canvas.setColor(Color.red);//apple
           canvas.drawOval(710, 490, 50, 50);
           canvas.fillOval(710, 490, 50, 50);
           
           canvas.drawOval(430,244,200,66);//message bubble
           canvas.drawString("This is cat Luna and", 450, 270);//message
           canvas.drawString("her friend Super Caterpillar", 450, 290);
       } 

}
