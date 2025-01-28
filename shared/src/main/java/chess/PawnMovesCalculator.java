package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMovesCalculator implements ChessPieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> possibleMoves = new ArrayList<>();

        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();
        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();

        // possible moves if white
        if (myColor == ChessGame.TeamColor.WHITE) {
            // make a promotion piece if you will advance to last row
            if (myRow == 7) {
                ChessPosition promotionPosition = new ChessPosition(myRow + 1, myCol);

                ChessMove bishopPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.BISHOP);
                ChessMove knightPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.KNIGHT);
                ChessMove queenPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.QUEEN);
                ChessMove rookPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.ROOK);

                if (!isBlocked(board, myPosition, promotionPosition) && !canCapture(board, myPosition, promotionPosition)) {
                    possibleMoves.add(bishopPromotionMove);
                    possibleMoves.add(knightPromotionMove);
                    possibleMoves.add(queenPromotionMove);
                    possibleMoves.add(rookPromotionMove);
                }

                // capture up and right
                ChessPosition captureUpRightPomotionPosition = new ChessPosition(myRow + 1, myCol + 1);
                if (isInBounds(captureUpRightPomotionPosition) && canCapture(board, myPosition, captureUpRightPomotionPosition)) {
                    ChessMove bishopPromotionRightCaptureMove = new ChessMove(myPosition, captureUpRightPomotionPosition, ChessPiece.PieceType.BISHOP);
                    ChessMove knightPromotionRightCaptureMove = new ChessMove(myPosition, captureUpRightPomotionPosition, ChessPiece.PieceType.KNIGHT);
                    ChessMove queenPromotionRightCaptureMove = new ChessMove(myPosition, captureUpRightPomotionPosition, ChessPiece.PieceType.QUEEN);
                    ChessMove rookPromotionRightCaptureMove = new ChessMove(myPosition, captureUpRightPomotionPosition, ChessPiece.PieceType.ROOK);

                    possibleMoves.add(bishopPromotionRightCaptureMove);
                    possibleMoves.add(knightPromotionRightCaptureMove);
                    possibleMoves.add(queenPromotionRightCaptureMove);
                    possibleMoves.add(rookPromotionRightCaptureMove);
                }

                // capture up and left
                ChessPosition captureUpLeftPomotionPosition = new ChessPosition(myRow + 1, myCol - 1);
                if (isInBounds(captureUpLeftPomotionPosition) && canCapture(board, myPosition, captureUpLeftPomotionPosition)) {
                    ChessMove bishopPromotionLeftCaptureMove = new ChessMove(myPosition, captureUpLeftPomotionPosition, ChessPiece.PieceType.BISHOP);
                    ChessMove knightPromotionLeftCaptureMove = new ChessMove(myPosition, captureUpLeftPomotionPosition, ChessPiece.PieceType.KNIGHT);
                    ChessMove queenPromotionLeftCaptureMove = new ChessMove(myPosition, captureUpLeftPomotionPosition, ChessPiece.PieceType.QUEEN);
                    ChessMove rookPromotionLeftCaptureMove = new ChessMove(myPosition, captureUpLeftPomotionPosition, ChessPiece.PieceType.ROOK);

                    possibleMoves.add(bishopPromotionLeftCaptureMove);
                    possibleMoves.add(knightPromotionLeftCaptureMove);
                    possibleMoves.add(queenPromotionLeftCaptureMove);
                    possibleMoves.add(rookPromotionLeftCaptureMove);
                }
            }
            else {
                // move forward 1
                ChessPosition targetPosition = new ChessPosition(myRow + 1, myCol);
                ChessMove newMove = new ChessMove(myPosition, targetPosition);
                if (!isBlocked(board, myPosition, targetPosition) && isInBounds(targetPosition) && !canCapture(board, myPosition, targetPosition)) {
                    possibleMoves.add(newMove);
                }

                // capture up and right
                ChessPosition captureUpRightPosition = new ChessPosition(myRow + 1, myCol + 1);
                ChessMove captureUpRightMove = new ChessMove(myPosition, captureUpRightPosition);
                if (isInBounds(captureUpRightPosition) && canCapture(board, myPosition, captureUpRightPosition)) {
                    possibleMoves.add(captureUpRightMove);
                }

                // capture up and left
                ChessPosition captureUpLeftPosition = new ChessPosition(myRow + 1, myCol - 1);
                ChessMove captureUpLeftMove = new ChessMove(myPosition, captureUpLeftPosition);
                if (isInBounds(captureUpLeftPosition) && canCapture(board, myPosition, captureUpLeftPosition)) {
                    possibleMoves.add(captureUpLeftMove);
                }

                // move forward 2 if currently on base row
                if (myRow == 2) {
                    ChessPosition enPassantPosition = new ChessPosition(myRow + 2, myCol);
                    ChessMove enPassantMove = new ChessMove(myPosition, enPassantPosition);
                    if (!isBlocked(board, myPosition, targetPosition) && !isBlocked(board, myPosition, enPassantPosition)
                            && !canCapture(board, myPosition, targetPosition) && !canCapture(board, myPosition, enPassantPosition)) {
                        possibleMoves.add(enPassantMove);
                    }
                }
            }
        }

        // possible moves if black
        if (myColor == ChessGame.TeamColor.BLACK) {
            // make a promotion piece if you will advance to last row
            if (myRow == 2) {
                ChessPosition promotionPosition = new ChessPosition(myRow - 1, myCol);

                ChessMove bishopPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.BISHOP);
                ChessMove knightPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.KNIGHT);
                ChessMove queenPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.QUEEN);
                ChessMove rookPromotionMove = new ChessMove(myPosition, promotionPosition, ChessPiece.PieceType.ROOK);

                if (!isBlocked(board, myPosition, promotionPosition) && !canCapture(board, myPosition, promotionPosition)) {
                    possibleMoves.add(bishopPromotionMove);
                    possibleMoves.add(knightPromotionMove);
                    possibleMoves.add(queenPromotionMove);
                    possibleMoves.add(rookPromotionMove);
                }

                // capture down and right
                ChessPosition captureDownRightPomotionPosition = new ChessPosition(myRow - 1, myCol + 1);
                if (isInBounds(captureDownRightPomotionPosition) && canCapture(board, myPosition, captureDownRightPomotionPosition)) {
                    ChessMove bishopPromotionRightCaptureMove = new ChessMove(myPosition, captureDownRightPomotionPosition, ChessPiece.PieceType.BISHOP);
                    ChessMove knightPromotionRightCaptureMove = new ChessMove(myPosition, captureDownRightPomotionPosition, ChessPiece.PieceType.KNIGHT);
                    ChessMove queenPromotionRightCaptureMove = new ChessMove(myPosition, captureDownRightPomotionPosition, ChessPiece.PieceType.QUEEN);
                    ChessMove rookPromotionRightCaptureMove = new ChessMove(myPosition, captureDownRightPomotionPosition, ChessPiece.PieceType.ROOK);

                    possibleMoves.add(bishopPromotionRightCaptureMove);
                    possibleMoves.add(knightPromotionRightCaptureMove);
                    possibleMoves.add(queenPromotionRightCaptureMove);
                    possibleMoves.add(rookPromotionRightCaptureMove);
                }

                // capture down and left
                ChessPosition captureDownLeftPomotionPosition = new ChessPosition(myRow - 1, myCol - 1);
                if (isInBounds(captureDownLeftPomotionPosition) && canCapture(board, myPosition, captureDownLeftPomotionPosition)) {
                    ChessMove bishopPromotionLeftCaptureMove = new ChessMove(myPosition, captureDownLeftPomotionPosition, ChessPiece.PieceType.BISHOP);
                    ChessMove knightPromotionLeftCaptureMove = new ChessMove(myPosition, captureDownLeftPomotionPosition, ChessPiece.PieceType.KNIGHT);
                    ChessMove queenPromotionLeftCaptureMove = new ChessMove(myPosition, captureDownLeftPomotionPosition, ChessPiece.PieceType.QUEEN);
                    ChessMove rookPromotionLeftCaptureMove = new ChessMove(myPosition, captureDownLeftPomotionPosition, ChessPiece.PieceType.ROOK);

                    possibleMoves.add(bishopPromotionLeftCaptureMove);
                    possibleMoves.add(knightPromotionLeftCaptureMove);
                    possibleMoves.add(queenPromotionLeftCaptureMove);
                    possibleMoves.add(rookPromotionLeftCaptureMove);
                }
            }
            else {
                // move backward 1
                ChessPosition targetPosition = new ChessPosition(myRow - 1, myCol);
                ChessMove newMove = new ChessMove(myPosition, targetPosition);
                if (!isBlocked(board, myPosition, targetPosition) && isInBounds(targetPosition) && !canCapture(board, myPosition, targetPosition)) {
                    possibleMoves.add(newMove);
                }

                // capture down and right
                ChessPosition captureDownRightPosition = new ChessPosition(myRow - 1, myCol + 1);
                ChessMove captureDownRightMove = new ChessMove(myPosition, captureDownRightPosition);
                if (isInBounds(captureDownRightPosition) && canCapture(board, myPosition, captureDownRightPosition)) {
                    possibleMoves.add(captureDownRightMove);
                }

                // capture down and left
                ChessPosition captureDownLeftPosition = new ChessPosition(myRow - 1, myCol - 1);
                ChessMove captureDownLeftMove = new ChessMove(myPosition, captureDownLeftPosition);
                if (isInBounds(captureDownLeftPosition) && canCapture(board, myPosition, captureDownLeftPosition)) {
                    possibleMoves.add(captureDownLeftMove);
                }

                // move forward 2 if currently on base row
                if (myRow == 7) {
                    ChessPosition enPassantPosition = new ChessPosition(myRow - 2, myCol);
                    ChessMove enPassantMove = new ChessMove(myPosition, enPassantPosition);
                    if (!isBlocked(board, myPosition, targetPosition) && !isBlocked(board, myPosition, enPassantPosition)
                            && !canCapture(board, myPosition, targetPosition) && !canCapture(board, myPosition, enPassantPosition)) {
                        possibleMoves.add(enPassantMove);
                    }
                }
            }
        }

        return possibleMoves;
    }
}
