package com.nickcanfield;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    private static String topLeft = "1";
    private static String topMiddle = "2";
    private static String topRight = "3";
    private static String MidLeft = "4";
    private static String MidMiddle = "5";
    private static String MidRight = "6";
    private static String bottomLeft = "7";
    private static String bottomMiddle = "8";
    private static String bottomRight = "9";


    public static void main(String[] args) {



        //Initializes variables
        int gameCount = 1;
        int XGamesWon = 0;
        int OGamesWon = 0;
        int turn = 0;
        boolean exitGame = false;

        //Starts the Game
        System.out.println("Let's Play Tic Tac Toe!");
        while (!exitGame) {
            printBoard();
            playTurn(turn);
            if(checkIfWon()) {
                printBoard();

                //checks if X won
                if(turn%2==0) {
                    System.out.println("X Won!");
                    XGamesWon++;
                    System.out.println("Games Won: ");
                    System.out.println("X: "+XGamesWon);
                    System.out.println("O: "+OGamesWon);
                }
                //checks if O won
                if (turn%2!=0) {
                    System.out.println("O Won!");
                    OGamesWon++;
                    System.out.println("Games Won: ");
                    System.out.println("X: "+XGamesWon);
                    System.out.println("O: "+OGamesWon);
                }
                System.out.println();
                System.out.print("Another game? 0 = NO. 1 = YES.");
                int anotherGame = scanner.nextInt();
                scanner.nextLine();

                if(anotherGame==0) {
                    System.out.println("# of Games Played: "+gameCount);
                    System.out.println("Thanks for Playing!");
                    exitGame = true;
                } else {
                    clearBoard();
                    gameCount++;
                }
            }

            //If game isn't won, it checks if it's a catscratch
            if (checkIfCatScratch()) {
                System.out.println("It's a catscratch!");
                System.out.println();
                System.out.print("Another game? 0 = NO. 1 = YES.");
                int anotherGame = scanner.nextInt();
                scanner.nextLine();
                if(anotherGame==0) {
                    System.out.println("# of Games Played: "+gameCount);
                    System.out.println("Thanks for Playing!");
                    exitGame = true;
                } else {
                    clearBoard();
                    gameCount++;
                }
            }
            //Flips the turn to the opposite player
            turn++;
        }
    }

    //checkIfWon checks to see if someone won the game
    public static boolean checkIfWon() {
        if(((getTopLeft()==getTopMiddle())&&getTopMiddle()==getTopRight()) ||
                ((getMidLeft()==getMidMiddle())&&getMidMiddle()==getMidRight()) ||
                ((getBottomLeft()==getBottomMiddle())&&getBottomMiddle()==getBottomRight()) ||
                ((getTopLeft()==getMidLeft())&&getMidLeft()==getBottomLeft()) ||
                ((getTopMiddle()==getMidMiddle())&&getMidMiddle()==getBottomMiddle()) ||
                ((getTopRight()==getMidRight())&&getMidRight()==getBottomRight()) ||
                ((getTopLeft()==getMidMiddle())&&getMidMiddle()==getBottomRight()) ||
                ((getTopRight()==getMidMiddle())&&getMidMiddle()==getBottomLeft())) {
            return true;
        } else {
            return false;
        }

    }

    // checkIfCatchScratch does exactly as it says
    public static boolean checkIfCatScratch(){
        if(getTopLeft()!="1" && getTopMiddle()!="2" && getTopRight()!="3" && getMidLeft()!="4" && getMidMiddle()!="5" && getMidRight()!="6" && getBottomLeft()!="7"&&getBottomMiddle()!="8"&& getBottomRight()!="9" && checkIfWon()==false) {
            return true;
        } else {
            return false;
        }

    }

    //Clears the playing board
    public static void clearBoard() {
        setTopLeft("1");
        setTopMiddle("2");
        setTopRight("3");
        setMidLeft("4");
        setMidMiddle("5");
        setMidRight("6");
        setBottomLeft("7");
        setBottomMiddle("8");
        setBottomRight("9");
    }

    //printBoard prints the current game board
    public static void printBoard() {
        System.out.println();
        System.out.println(getTopLeft()+" | "+getTopMiddle()+" | "+getTopRight());
        System.out.println("_________");
        System.out.println(getMidLeft()+" | "+getMidMiddle()+" | "+getMidRight());
        System.out.println("_________");
        System.out.println(getBottomLeft()+" | "+getBottomMiddle()+" | "+getBottomRight());
        System.out.println();
    }

    //playTurn asks X and O to choose their placements
    public static void playTurn (int turn) {

        boolean correct = false;
        while (!correct) {
            int position = 0;
            boolean correctInput = false;
            if (turn%2==0) {
                System.out.print("X, pick your position");
                position = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.print("O, pick your position");
                position = scanner.nextInt();
                scanner.nextLine();
            }

            if(alreadyUsed(position)) {
                System.out.println("Already used. Choose another spot");
            } else if (position>9 || position <1) {
                System.out.println("Incorrect Position");
            } else {
                switch(position) {
                    case 1:
                        if(turn%2==0) {
                            setTopLeft("X");
                        } else {
                            setTopLeft("O");
                        }
                        break;
                        case 2:
                        if(turn%2==0) {
                            setTopMiddle("X");
                        } else {
                            setTopMiddle("O");
                        }
                        break;
                    case 3:
                        if(turn%2==0) {
                            setTopRight("X");
                        } else {
                            setTopRight("O");
                        }
                        break;
                    case 4:
                        if(turn%2==0) {
                            setMidLeft("X");
                        } else {
                            setMidLeft("O");
                        }
                        break;
                    case 5:
                        if(turn%2==0) {
                            setMidMiddle("X");
                        } else {
                            setMidMiddle("O");
                        }
                        break;
                    case 6:
                        if(turn%2==0) {
                            setMidRight("X");
                        } else {
                            setMidRight("O");
                        }
                        break;
                    case 7:
                        if(turn%2==0) {
                            setBottomLeft("X");
                        } else {
                            setBottomLeft("O");
                        }
                        break;
                    case 8:
                        if(turn%2==0) {
                            setBottomMiddle("X");
                        } else {
                            setBottomMiddle("O");
                        }
                        break;
                    case 9:
                        if(turn%2==0) {
                            setBottomRight("X");
                        } else {
                            setBottomRight("O");
                        }
                        break;
                        default: break;
                }
                correct=true;
            }
        }
    }


        //alreadyUsed checks to see if the position a player chooses has already been used
        public static boolean alreadyUsed (int position) {
                switch(position) {
                    case 1:
                        if (getTopLeft()!="1") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 2:
                        if (getTopMiddle()!="2") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 3:
                        if (getTopRight()!="3") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 4:
                        if (getMidLeft()!="4") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 5:
                        if (getMidMiddle()!="5") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 6:
                        if (getMidRight()!="6") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 7:
                        if (getBottomLeft()!="7") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 8:
                        if (getBottomMiddle()!="8") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                    case 9:
                        if (getBottomRight()!="9") {
                            System.out.println("Can't go there! Pick another spot");
                            return true;
                        } else {
                            return false;
                        }
                        default: return false;
                }

    }

    //All the necessary getters and setters for the class variables
    // Getters and Setters
    public static String getTopLeft() {
        return topLeft;
    }

    public static void setTopLeft(String topLeft) {
        Main.topLeft = topLeft;
    }

    public static String getTopMiddle() {
        return topMiddle;
    }

    public static void setTopMiddle(String topMiddle) {
        Main.topMiddle = topMiddle;
    }

    public static String getTopRight() {
        return topRight;
    }

    public static void setTopRight(String topRight) {
        Main.topRight = topRight;
    }

    public static String getMidLeft() {
        return MidLeft;
    }

    public static void setMidLeft(String midLeft) {
        MidLeft = midLeft;
    }

    public static String getMidMiddle() {
        return MidMiddle;
    }

    public static void setMidMiddle(String midMiddle) {
        MidMiddle = midMiddle;
    }

    public static String getMidRight() {
        return MidRight;
    }

    public static void setMidRight(String midRight) {
        MidRight = midRight;
    }

    public static String getBottomLeft() {
        return bottomLeft;
    }

    public static void setBottomLeft(String bottomLeft) {
        Main.bottomLeft = bottomLeft;
    }

    public static String getBottomMiddle() {
        return bottomMiddle;
    }

    public static void setBottomMiddle(String bottomMiddle) {
        Main.bottomMiddle = bottomMiddle;
    }

    public static String getBottomRight() {
        return bottomRight;
    }

    public static void setBottomRight(String bottomRight) {
        Main.bottomRight = bottomRight;
    }

}
