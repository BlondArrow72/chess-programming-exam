package chess;

import java.util.Collection;
import java.util.ArrayList;

public interface ChessPieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);
}
