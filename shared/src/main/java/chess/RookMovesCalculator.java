package chess;

import java.util.ArrayList;
import java.util.Collection;

public class RookMovesCalculator implements ChessPieceMovesCalculator {

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();

        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();

        // Rooks can move up
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow+i, myCol);
            ChessMove newMove = new ChessMove(myPosition, targetPosition);

            if (isInBounds(targetPosition)) {
                if (canCapture(board, myPosition, targetPosition)) {
                    possibleMoves.add(newMove);
                    break;
                }
                else if (isBlocked(board, myPosition, targetPosition)) {
                    break;
                }
                else {
                    possibleMoves.add(newMove);
                }
            }
        }

        // Rooks can move to the right
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow, myCol+i);
            ChessMove newMove = new ChessMove(myPosition, targetPosition);

            if (isInBounds(targetPosition)) {
                if (canCapture(board, myPosition, targetPosition)) {
                    possibleMoves.add(newMove);
                    break;
                }
                else if (isBlocked(board, myPosition, targetPosition)) {
                    break;
                }
                else {
                    possibleMoves.add(newMove);
                }
            }
        }

        // Rooks can move down
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow-i, myCol);
            ChessMove newMove = new ChessMove(myPosition, targetPosition);

            if (isInBounds(targetPosition)) {
                if (canCapture(board, myPosition, targetPosition)) {
                    possibleMoves.add(newMove);
                    break;
                }
                else if (isBlocked(board, myPosition, targetPosition)) {
                    break;
                }
                else {
                    possibleMoves.add(newMove);
                }
            }
        }

        // Rooks can move to the left
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow, myCol-i);
            ChessMove newMove = new ChessMove(myPosition, targetPosition);

            if (isInBounds(targetPosition)) {
                if (canCapture(board, myPosition, targetPosition)) {
                    possibleMoves.add(newMove);
                    break;
                }
                else if (isBlocked(board, myPosition, targetPosition)) {
                    break;
                }
                else {
                    possibleMoves.add(newMove);
                }
            }
        }

        return possibleMoves;
    }
}
