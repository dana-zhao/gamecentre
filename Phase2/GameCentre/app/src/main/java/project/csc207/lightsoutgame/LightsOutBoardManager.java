package project.csc207.lightsoutgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Observable;

/**
 * manage the LightOutBoard, including switch light, check for a win, and managing taps
 */
public class LightsOutBoardManager extends Observable implements Serializable {

    /**
     *  the LightsOut Board to be managed
     */
    private LightsOutBoard lightsOutBoard;

    /**
     * the Stack contains all moves done by player
     */
    private Stack<Integer> gameMoves;

    /**
     * the minimum number of Moves required to solve the Game
     */
    private int min_moves;

    /**
     * statement of whether the game is solved or not
     */
    private boolean GAME_OVER = false;


    LightsOutBoard getLightsOutBoard() {
        return lightsOutBoard;
    }

    LightsOutBoardManager(){
        List<Light> lights = new ArrayList<>();
        final int numLights = LightsOutBoard.NUM_COLS * LightsOutBoard.NUM_ROWS;
        for (int lightsNum = 0; lightsNum != numLights; lightsNum++){
            Light light = new Light(lightsNum);
            lights.add(light);
        }
        gameMoves = new Stack<>();
        this.lightsOutBoard = new LightsOutBoard(lights);
        randomSetBoard();
        System.out.println(gameMoves);
        gameMoves = new Stack<>();
    }

    /**
     * Return whether all lights in Light Out Board are Off, note there are always 25 lights in
     * LightsOut Board
     *
     * @return whether all lights in Light Out Board are On
     */
    boolean allLightsOut(){
        for (int i =0; i < LightsOutBoard.NUM_ROWS * LightsOutBoard.NUM_COLS; i++){
            int row = i / LightsOutBoard.NUM_ROWS;
            int col = i % LightsOutBoard.NUM_COLS;
            Light lightToCheck = lightsOutBoard.getLight(row, col);
            if (lightToCheck.getState()){
                return false;
            }
        }
        return true;
    }

    /**
     * return a list of Lights, contains the light and lights around the given light
     * @param position the position of light to check
     * @return a list of Lights around and include the give light
     */
    List<Light> getLightsAround(int position){
        int row = position / LightsOutBoard.NUM_ROWS;
        int col = position % LightsOutBoard.NUM_COLS;
        Light lightToCheck = lightsOutBoard.getLight(row,col);
        Light above = row == 0 ? null : lightsOutBoard.getLight(row - 1, col);
        Light below = row == LightsOutBoard.NUM_ROWS - 1 ? null : lightsOutBoard.getLight(row + 1, col);
        Light left = col == 0 ? null : lightsOutBoard.getLight(row, col - 1);
        Light right = col == LightsOutBoard.NUM_COLS - 1 ? null : lightsOutBoard.getLight(row, col + 1);
        List<Light> lights = new ArrayList<>();
        lights.add(lightToCheck);
        if (above!=null){lights.add(above);}
        if (below!=null){lights.add(below);}
        if (left!=null){lights.add(left);}
        if (right!=null){lights.add(right);}
        return lights;
    }

    /**
     * Switch The light and lights around the select Light
     * @param position the position of the light
     */
    void touchToSwitch(int position){
        gameMoves.push(position);
        List<Light> lightsToSwitch = getLightsAround(position);
        for(Light light:lightsToSwitch){
            light.switchLight();
        }
        GAME_OVER = allLightsOut();
        setChanged();
        notifyObservers();
    }

    /**
     * undo the previous switch, if no previous switch do nothing
     */
    void undo(){
        if (!gameMoves.empty()){
            int position = gameMoves.pop();
            touchToSwitch(position);
            // because touchToSwitch called and position add to gameMoves again
            gameMoves.pop();
        }

    }

    /**
     * set the number of minimum Moves to solve the Board
     * @param min_moves the minimum moves required for solving the Board.
     */
    private void setMin_moves(int min_moves) {
        this.min_moves = min_moves;
    }

    /**
     * return the number of minimum moves to solve the Board.
     * @return the number of minimum moves
     */
    public int getMin_moves() {
        return min_moves;
    }

    /**
     * return the number of moves the player had
     * @return the number of moves
     */
    int getGameMoves() {
        return gameMoves.size();
    }

    /**
     * Randomly set the Board by switch any position on the board 10 to 30 times.
     * with different switch position each time.
     */
    private void randomSetBoard(){
        Random randomMoves = new Random();
        setMin_moves(randomMoves.nextInt(31));
        if (min_moves<10){
            min_moves = 10;
        }
        Random randomPosition = new Random();
        int position = 0;
        for(int i =0;i<this.min_moves;i++){
            int newPosition = randomPosition.nextInt(25);
            if (position != newPosition){
                position = newPosition;
                touchToSwitch(position);
            }
            else{
                position = position + 1 <24 ? position+1:position-1;
                touchToSwitch(position);
            }
        }
    }

    boolean isGameOver() {
        return GAME_OVER;
    }

    /**
     * count and return the score when the game is finished
     * @return the score of the game
     */
    int countScore(){
        return min_moves * 10 / getGameMoves();
    }
}
