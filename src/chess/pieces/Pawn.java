package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumn()];

        Position p = new Position(0,0);

        // movimentação do peão

        if (getColor() == Color.WHITE){
            // uma casa para frente
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // duas casas para frente
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // diagonal esquerda
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            //diagonal direita

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }



        } else {

            // LÓGICA DO PEÃO PRETO

            // uma casa para frente

            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // duas casas para frente
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // diagonal esquerda
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            //diagonal direita

            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }


        return mat;
    }

    @Override
    public String toString(){
        return "p";
    }
}
