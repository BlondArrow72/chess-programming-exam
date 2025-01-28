package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMovesCalculator implements ChessPieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();

        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();

        int[][] directions = {
                          { 2, -1}, { 2, 1},
                { 1, -2},                    { 1, 2},
                {-1, -2},                    {-1, 2},
                          {-2, -1}, {-2, 1}
        };

        for (int i = 0; i < 8; i++) {
            int[] newDirection = directions[i];
            int newRow = myRow + newDirection[0];
            int newCol = myCol + newDirection[1];
            ChessPosition newPosition = new ChessPosition(newRow, newCol);
            ChessMove newMove = new ChessMove(myPosition, newPosition);

            if (isInBounds(newPosition)) {
                evaluateMove(possibleMoves, board, newMove);
            }
        }

        return possibleMoves;
    }
}
