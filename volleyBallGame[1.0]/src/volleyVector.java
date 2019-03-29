//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseEvent;
//
//import acm.program.*;
//import acm.graphics.GImage;
//import acm.graphics.GOval;
//import acm.graphics.GRect;
//import javax.swing.Timer;
//
//public class volleyVector extends GraphicsProgram implements ActionListener{
//
//	/*STUDENT - JOSHUA OBIHA
//	 *TEACHER - MR.REA
//	 *COURSE  - COMPUTER SCIENCE (ISC4U0)
//	 *DATE    - 6/13/2016 
//	 */
//
//	private static final long serialVersionUID = 1L;
//
//
//	public static final int  SCREEN_WIDTH = 1280;
//	public static final int  SCREEN_HEIGHT = 775;
//	public static final int MAXVEL = 10;
//	public static final double BALLVEL = 2;
//	public static final double GRAVITY = 0.5;
//	private static final double SIZE = 50;
//	public static int  floor = 670;
//	private static final double DIAMETER1 = 100;
//	private static final double DIAMETER2 = 50;
//	private static final double VELOCITY1 = 5;
//	private static final double VELOCITY2 = 5;
//	
//	
//	double ball_x1 = 100;
//	double ball_y1 = 100;
//	double ball_x2 = ball_x1 + DIAMETER1;
//	double ball_y2 = ball_y1 + DIAMETER1;
//
//	// Initialize corner coordinates for second circle
//	double c2_x1 = 200;
//	double c2_y1 = 200;
//	double c2_x2 = c2_x1 + DIAMETER2;
//	double c2_y2 = c2_y1 + DIAMETER2;
//
//	// Initialize velocity values for first circle
//	double vel1X = VELOCITY1, vel1Y = -VELOCITY1;
//	double vel2X = -VELOCITY2, vel2Y = -VELOCITY2;
//	/* VolleyVector is a volleyball game involving two players 
//	 * The game allows for Background and character modification  
//	 *  
//	 */
//
//	GImage introWallpaper = new GImage ("introWallpaper.png");
//	GImage startButton = new GImage ("start_button.png");
//	GRect square = new GRect(SCREEN_WIDTH,100);
//	GRect square2 = new GRect(0,0);
//	GImage player1 = new GImage("player1.png");
//	GImage player2 = new GImage("player2.png");
//	GImage ball = new GImage ("spaceball.png");
//	GImage rightPicture = new GImage("rightPicture.gif");
//	GImage infoBar = new GImage("scoreBoard.png");
//	Sound piano = new Sound();
//
//	boolean onFloor = false; // FLOOR CHECKER FOR PLAYER1 
//	boolean onFloor2 = false; // FLOOR CHECKER FOR PLAYER2 
//	boolean onFloor3 = false; //FLOOR CHECKER FOR PLAYER 3
//
//	/// JUMPLAG(GIVES TIME FOR WHEN THE OBJECT HITS THE FLOOR 
//	int jumpLag = 0; 
//	int jumpLag2 = 0;
//	int jumpLag3 = 0;
//
//	double velX, velY;  ////    VELOCITY OF PLAYER1 
//	double velX2, velY2; ///// VELOCITY OF PLAYER2 
//
//
//
//	public void run(){
//
//
//
//		Timer t = new Timer(1, this);
//		t.start();
//
//		// LISTENERS /////////////////////
//
//		addKeyListeners();  // LISTENS TO ACTIONS PERFORMED WITH THE KEYBOARD BY THE USER
//		addMouseListeners(); // LISTENS TO ACTIONS PERFORMED WITH THE MOUSE BY THE USER
//
//		/////////////////////////////////
//
//
//
//		// WINDOW SETTINGS /////////////
//
//		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
//		setTitle("VOLLEY VECTOR");
//
//		///////////////////////////////
//
//
//
//		// INTRO WALLPAPER SETTINGS //
//
//		introWallpaper.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
//		introWallpaper.setLocation(0, 0);
//		add(introWallpaper);
//
//		///////////////////////////////
//
//		// START BUTTON SETTINGS //
//
//		startButton.setSize(100,100);
//		startButton.setLocation(SCREEN_WIDTH/3 ,SCREEN_HEIGHT/2);
//		add(startButton);
//
//		///////////////////////////////
//
//
//		// GAMEBACKGROUND SETTINGS //
//
//		rightPicture.setSize(SCREEN_WIDTH,SCREEN_HEIGHT - 90);
//		rightPicture.setLocation(0, 0);
//
//
//		/////////////////////////////
//
//		// VOLLEYBALL POLE SETTINGS //////////////////////////////////////////////////////////////////////////////////////////////
//		square2.setSize(10,140);
//		square2.setColor(Color.BLACK);
//		square2.setFilled(true);
//		square2.setLocation(SCREEN_WIDTH/2,floor -square2.getHeight());
//
//		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		//INFO BAR SETTINGS //////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		//infoBar.setSize(300, 90);
//		//infoBar.setLocation(SCREEN_WIDTH/2-infoBar.getWidth()/2, 40);
//
//		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		/////////////////////////////
//
//		// SQAURE FLOOR SETTINGS //
//
//		square.setLocation(0,floor+1);
//		square.setColor(Color.BLACK);
//		square.setFilled(true);
//		square.sendToFront();
//
//		///////////////////////////
//
//		// VOLLEY BALL SETTINGS //
//
//		
//		ball.setSize(50,50);
//		ball.setLocation(0,0);
//		
//
//		//////////////////////////
//
//
//		// PLAYER 1  & PLAYER 2 SETTINGS //
//
//		player1.setLocation(SCREEN_WIDTH/2 - 350,floor -66);
//		player1.setSize(170, 170);
//		player1.sendToFront();
//
//		player2.setLocation(SCREEN_WIDTH/2 + 200,floor -66);
//		player2.setSize(170, 170);
//		player2.sendToFront();
//
//		//////////////////////////////
//
//	}
//
//
//
//	// MOUSE EVENT (mouse clicked) : THIS MOUSE EVENT CHECKS FOR WHEN THE START BUTTON IS CLICKED
//	//	CLICKING THE START BUTTON WOULD TAKE THE USER TO THE MAIN GAME
//
//	public void mouseClicked(MouseEvent m){
//		if (m.getX() >= startButton.getX() && m.getX() <= startButton.getX() + startButton.getWidth() && m.getY() >= startButton.getY() && m.getY() <= startButton.getY() + startButton.getHeight()){
//
//			remove(startButton);                            //removes the start button after it has been clicked
//			remove(introWallpaper);                         // removes the introWallpaper
//			add(rightPicture);                              // adds the game background
//			add(infoBar);                                   // add the game information bar 
//			add(square2);                                   // adds the floor of the game
//			add(player2);                                   // adds player 2
//			add(player1);                                   // adds player 1
//			add(ball);										// adds the ball
//			add(square);									// adds the net 
//		}
//	}
//
//	// ACTION EVENT (action performed): THIS CHECKS FOR EVERY ACTION THE USER AND GIVES BACK THE OUTPUT SET 
//
//	public void actionPerformed(ActionEvent e){
//
//		// PLAYER 1'S ACTION
//
//		player1.setLocation(player1.getX()+velX, player1.getY()+velY); //SETS THE INITIAL LOCATION OF PLAYER 1
//
//		if(player1.getX() > getWidth()){
//			player1.setLocation(-player1.getWidth(), player1.getY());
//			player1.sendToFront();
//			rightWall();
//
//		}
//
//		if(player1.getX() + player1.getWidth() < 0){
//			player1.setLocation(getWidth(), player1.getY());
//
//			leftWall();
//			player1.sendToFront();
//		}
//
//		if(player1.getY() > getHeight()){
//			player1.setLocation(player1.getX(), -player1.getHeight());
//		}
//
//		if(player1.getY() + player1.getHeight() < 0){
//
//			player1.setLocation(player1.getX(), getHeight());
//		}
//
//		if(jumpLag > 0){
//			jumpLag--;
//		}
//
//		if(! onFloor){
//			velY+=GRAVITY;
//		}
//
//		if(onFloor && jumpLag <= 0){
//			velY = 0;
//		}
//
//		if(player1.getY()+player1.getHeight() >= floor){
//			onFloor = true;
//			player1.setLocation(player1.getX(), floor - player1.getHeight());
//		}
//		else{onFloor = false;
//
//
//		}
//
//		checkCollision();
//
//		rightWall();
//
//		leftWall();
//
//		roof();
//
//		player2.setLocation(player2.getX()+velX2, player2.getY()+velY2);
//
//		if(player2.getX() > getWidth()){
//			player2.setLocation(-player2.getWidth(), player2.getY());
//			player2.sendToFront();
//			rightWall();
//
//		}
//
//		if(player2.getX() + player2.getWidth() < 0){
//			player2.setLocation(getWidth(), player2.getY());
//
//			leftWall();
//			player2.sendToFront();
//		}
//
//		if(player2.getY() > getHeight()){
//			player2.setLocation(player2.getX(), -player2.getHeight());
//		}
//
//		if(player2.getY() + player2.getHeight() < 0){
//
//			player2.setLocation(player2.getX(), getHeight());
//		}
//
//		if(jumpLag2 > 0){
//			jumpLag2--;
//		}
//
//		if(! onFloor2){
//			velY2+=GRAVITY;
//		}
//
//		if(onFloor2 && jumpLag2 <= 0){
//			velY2 = 0;
//		}
//
//		if(player2.getY()+player2.getHeight() >= floor){
//			onFloor2 = true;
//			player2.setLocation(player2.getX(), floor - player2.getHeight());
//		}
//		else{
//			onFloor2 = false;
//		}
//
//		ballMovement();
//
//
//	}
//
//
//
//	public void checkCollision(){
//
//		if(player1.getX() + player1.getWidth() > square2.getX() && square2.getX() + square2.getWidth() > player1.getX() && player1.getY() + player1.getHeight() > square2.getY()  && square2.getY() + square2.getHeight() > player1.getY()){
//
//			if(player1.getX() < square2.getX()){
//				player1.setLocation(square2.getX() - player1.getWidth(), player1.getY());
//			}
//			if(player1.getX() + player1.getWidth()> square2.getX()){
//				player1.setLocation(square2.getX() + square2.getWidth(), player1.getY());
//			}
//
//
//		}
//		if(player2.getX() + player2.getWidth() > square2.getX() && square2.getX() + square2.getWidth() > player2.getX() && player2.getY() + player2.getHeight() > square2.getY()  && square2.getY() + square2.getHeight() > player2.getY()){
//
//			if(player2.getX() < square2.getX()){
//				player2.setLocation(square2.getX() - player2.getWidth(), player2.getY());
//			}
//			if(player2.getX() + player2.getWidth()> square2.getX()){
//				player2.setLocation(square2.getX() + square2.getWidth(), player2.getY());
//			}
//
//
//		}
//		if ((player1.contains(ball_x1,ball_y1) || player1.contains(ball_x2,ball_y1) 
//				 || player1.contains(ball_x1,ball_y2) || player1.contains(ball_x2,ball_y2)) ||
//				(ball.contains(c2_x1,c2_y1) || ball.contains(c2_x2,c2_y1) 
//				 || ball.contains(c2_x1,c2_y2) || ball.contains(c2_x2,c2_y2))){
//				vel1X = +vel1X;	vel1Y = -vel1Y;	
//			}
//		if ((player2.contains(ball_x1,ball_y1) || player2.contains(ball_x2,ball_y1) 
//				 || player2.contains(ball_x1,ball_y2) || player2.contains(ball_x2,ball_y2)) ||
//				(ball.contains(c2_x1,c2_y1) || ball.contains(c2_x2,c2_y1) 
//				 || ball.contains(c2_x1,c2_y2) || ball.contains(c2_x2,c2_y2))){
//				vel1X = +vel1X;	vel1Y = -vel1Y;	
//			}
//
//		}
//
//	
//
//	public void keyPressed(KeyEvent e){	///////////////////////////PLAYER1 KEYEVENT
//
//		if (e.getKeyCode()== 87 && onFloor){
//			// velY -1 takes the object up 	
//			jumpLag = 10;
//			velY = -MAXVEL;
//		}
//
//		if(e.getKeyCode() == 68){
//			//velX +1 takes the object to the right 
//			velX = +MAXVEL;
//		}
//		if (e.getKeyCode()== 65){
//			//velX -1 takes the object to the left
//			velX= -MAXVEL;
//		}
//		if (e.getKeyCode() == 83 && !onFloor){
//			velY = +MAXVEL * 2;
//		}
//		if (e.getKeyCode() == 38 && onFloor2){
//			// velY -1 takes the object up 	
//			jumpLag2 = 10;
//			velY2 = -MAXVEL;
//		}
//
//		if(e.getKeyCode() == 39){
//			//velX +1 takes the object to the right 
//			velX2 = +MAXVEL;
//		}
//		if (e.getKeyCode()== 37){
//			//velX -1 takes the object to the left
//			velX2= -MAXVEL;
//		}
//	}
//
//	// KEY EVENT (key release): CHECKS WHEN THE KEYS FOR PLAYER 1 & 2 ARE REALEASED  
//	public void keyReleased(KeyEvent e){
//		if (e.getKeyCode()==68 || e.getKeyCode() == 65){
//			velX = 0;
//		}
//		// IF THE UP (W) KEY FOR PLAYER 1 IS REALEASED, THE VELOCITY OF PLAYER 1 IS SET TO ZERO  
//		if (e.getKeyCode() ==39 || e.getKeyCode() == 37){
//			velX2 = 0;
//			// IF THE UP (ARROWUP) KEY FOR PLAYER 2 IS REALEASED, THE VELOCITY OF PLAYER 2 IS SET TO ZERO
//		}
//
//	}
//
//	// BALL MOVEMENT: IS THE MOVEMENT OF THE BALL
//
//	public void rightWall(){
//		if (player1.getLocation().getX()+ player1.getWidth()>= SCREEN_WIDTH){
//
//			velX=-10;
//
//			System.out.println("player 1 has touched the right wall");
//		}
//		if (player2.getLocation().getX()+ player2.getWidth()>= SCREEN_WIDTH){
//
//			velX2=-10;
//
//			System.out.println("player 2 has touched the right wall");
//		}
//
//	}
//
//	public void leftWall(){
//
//		if (player1.getLocation().getX()<=0){
//			velX=+10;
//			System.out.println("player 1 has touched the left wall");
//		}
//		if (player2.getLocation().getX()<=0){
//			velX2=+10;
//			System.out.println("player 2 has touched the left wall ");
//		}
//
//	}
//
//	public void roof(){
//
//		if (player1.getLocation().getY() <= 100){
//			velY= +10;
//		}
//		if (player2.getLocation().getY() <= 100){
//
//			velY2= +10;
//		}	
//
//	}
//
//	public void ballMovement(){
//		if(ball_x1 <= 0 || ball_x1 + DIAMETER1 >= SCREEN_WIDTH) 
//			vel1X = -vel1X;
//		if(ball_y1 <= 0 || ball_y1 + DIAMETER1 > floor+80) 
//			vel1Y = -vel1Y;
//	
//		
//		ball_x1 += vel1X; 
//		ball_y1 += vel1Y;
//		ball_x2 = ball_x1 + DIAMETER1;
//		ball_y2 = ball_y1 + DIAMETER1;
//		
//		ball.setLocation(ball_x1, ball_y1);
//
//		
//	}
//	}
//
//
//
//
//
//
//
//

