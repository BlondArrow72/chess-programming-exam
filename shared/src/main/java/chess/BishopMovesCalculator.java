package chess;

import java.util.Collection;
import java.util.ArrayList;

public class BishopMovesCalculator implements ChessPieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();

        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();

        // Bishops can move up and to the right
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow+i, myCol+i);
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

        // Bishops can move down and to the right
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow-i, myCol+i);
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

        // Bishops can move down and to the left
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow-i, myCol-i);
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

        // Bishops can move up and to the left
        for(int i = 1; i <= 7; i++) {
            ChessPosition targetPosition = new ChessPosition(myRow+i, myCol-i);
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
