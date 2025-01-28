package chess;

import java.util.Collection;
import java.util.ArrayList;

public class KingMovesCalculator implements ChessPieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();

        int[][] directions = {
                { 1, -1}, { 1, 0}, { 1, 1},
                { 0, -1},          { 0, 1},
                {-1, -1}, {-1, 0}, {-1, 1}
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
