package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMovesCalculator implements ChessPieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();

        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();

        // Queens can move up
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

        // Queens can move up and to the right
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

        // Queens can move right
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

        // Queens can move down and to the right
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

        // Queens can move down
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

        // Queens can move down and to the left
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

        // Queens can move to the left
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

        // Queens can move up and to the left
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
