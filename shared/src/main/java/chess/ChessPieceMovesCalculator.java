package chess;

import java.util.Collection;

public interface ChessPieceMovesCalculator {
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

    default void evaluateMove(Collection<ChessMove> possibleMoves, ChessBoard board, ChessMove newMove) {
        // get positions
        ChessPosition startPosition = newMove.getStartPosition();
        ChessPosition endPosition = newMove.getEndPosition();

        // if endPosition is out of bounds, don't add and return
        if (!isInBounds(endPosition)) {
            return;
        }

        // if there's not a piece there, valid move
        if (board.getPiece(endPosition) == null) {
            possibleMoves.add(newMove);
        }

        // if there's a piece there, but it's the opposite team, valid move
        if (canCapture(board, startPosition, endPosition)) {
            possibleMoves.add(newMove);
        }
    }

    default boolean isInBounds(ChessPosition targetPosition) {
        int row = targetPosition.getRow();
        int col = targetPosition.getColumn();

        return (row >= 1 && row <= 8 && col >= 1 && col <= 8);
    }

    default boolean isBlocked(ChessBoard board, ChessPosition myPosition, ChessPosition targetPosition) {
        if (board.getPiece(targetPosition) == null) {
            return false;
        }

        ChessGame.TeamColor myTeam = board.getPiece(myPosition).getTeamColor();
        ChessGame.TeamColor targetTeam = board.getPiece(targetPosition).getTeamColor();

        return (myTeam == targetTeam);
    }

    default boolean canCapture(ChessBoard board, ChessPosition myPosition, ChessPosition targetPosition) {
        if (board.getPiece(targetPosition) == null) {
            return false;
        }

        ChessGame.TeamColor myTeam = board.getPiece(myPosition).getTeamColor();
        ChessGame.TeamColor targetTeam = board.getPiece(targetPosition).getTeamColor();

        return (myTeam != targetTeam);
    }
}
