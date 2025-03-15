package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    Gamepanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
//Debug 
    boolean checkDrawTime = false;

    public KeyHandler(Gamepanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
//key for the game

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //title state
        if (gp.gameState == gp.titleState) {

            if (gp.ui.titleScreenState == 0) {

                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 1;

                    }
                    if (gp.ui.commandNum == 1) {
                        //add later
                    }
                    if (gp.ui.commandNum == 2) {
                        System.exit(0);
                    }
                }
            } else if (gp.ui.titleScreenState == 1) {

                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 3;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        System.out.println("Level- Easy");                                   //stuff
                        gp.gameState = gp.playState;
                        gp.playMusic(0);         //to stop the music 

                    }
                    if (gp.ui.commandNum == 1) {
                        System.out.println("Leval- Hard");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);               // to stop the music
                    }
                    //add later

                    if (gp.ui.commandNum == 2) {
                        System.out.println("Leval- Meadium ");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);               //to stop the music

                    }
                    if (gp.ui.commandNum == 3) {
                        gp.ui.titleScreenState = 0;

                    }
                }
            }

        }

        //play state
        if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
//				if(gp.gameState == gp.playState ) {
//				                                                                      video 15
//				}
//				else if (gp.gameState == gp.pauseState) {
//					gp.gameState = gp.playState;
//				}
            }

            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            // Debug video 11;
            if (code == KeyEvent.VK_T) {
                if (checkDrawTime == false) {
                    checkDrawTime = true;

                } else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }
            }
        } //puase state
        else if (gp.gameState == gp.pauseState) {

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        } //dialogue state
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

    }

}
