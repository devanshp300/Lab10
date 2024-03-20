 

import java.util.*;

public class TicTacToeEvent extends EventObject {

    TicTacToeModel.Status status;
    private int x,y;
    public TicTacToeEvent(TicTacToeModel ttt, int x, int y, TicTacToeModel.Status ttts) {
        super(ttt);
        this.status = ttts;
        this.x = x;
        this.y = y;

    }

    public int getX(){

        return this.x;
    }

    public int getY(){

        return this.y;
    }

    public TicTacToeModel getModel(){

        return(TicTacToeModel)source;
    }
}

