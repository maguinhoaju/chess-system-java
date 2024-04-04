package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if (this.getColor() == Color.WHITE) {
			p.setValues(super.position.getRow() - 1, super.position.getColumn());
			if (this.getBoard().positionExists(p) && (!this.getBoard().thereIsAPiece(p))) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(super.position.getRow() - 2, super.position.getColumn());
			Position p2 = new Position(super.position.getRow() - 1, super.position.getColumn());
			if (this.getBoard().positionExists(p) && (!this.getBoard().thereIsAPiece(p)) && this.getBoard().positionExists(p2) && (!this.getBoard().thereIsAPiece(p2)) && this.getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() - 1, super.position.getColumn() - 1);
			if (this.getBoard().positionExists(p) && (this.isThereOpponentPiece(p))) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(super.position.getRow() - 1, super.position.getColumn() + 1);
			if (this.getBoard().positionExists(p) && (this.isThereOpponentPiece(p))) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #special move enPassant white
			if (super.position.getRow() == 3) {
				Position left = new Position(super.position.getRow(), super.position.getColumn() - 1);
				if (super.getBoard().positionExists(left) && this.isThereOpponentPiece(left) && super.getBoard().piece(left) == this.chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(super.position.getRow(), super.position.getColumn() + 1);
				if (super.getBoard().positionExists(right) && this.isThereOpponentPiece(right) && super.getBoard().piece(right) == this.chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else {
			if (this.getColor() == Color.BLACK) {
				p.setValues(super.position.getRow() + 1, super.position.getColumn());
				if (this.getBoard().positionExists(p) && (!this.getBoard().thereIsAPiece(p))) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				p.setValues(super.position.getRow() + 2, super.position.getColumn());
				Position p2 = new Position(super.position.getRow() + 1, super.position.getColumn());
				if (this.getBoard().positionExists(p) && (!this.getBoard().thereIsAPiece(p)) && this.getBoard().positionExists(p2) && (!this.getBoard().thereIsAPiece(p2)) && this.getMoveCount() == 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				p.setValues(super.position.getRow() + 1, super.position.getColumn() - 1);
				if (this.getBoard().positionExists(p) && (this.isThereOpponentPiece(p))) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				p.setValues(super.position.getRow() + 1, super.position.getColumn() + 1);
				if (this.getBoard().positionExists(p) && (this.isThereOpponentPiece(p))) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				// #special move enPassant black
				if (super.position.getRow() == 4) {
					Position left = new Position(super.position.getRow(), super.position.getColumn() - 1);
					if (super.getBoard().positionExists(left) && this.isThereOpponentPiece(left) && super.getBoard().piece(left) == this.chessMatch.getEnPassantVulnerable()) {
						mat[left.getRow() + 1][left.getColumn()] = true;
					}
					Position right = new Position(super.position.getRow(), super.position.getColumn() + 1);
					if (super.getBoard().positionExists(right) && this.isThereOpponentPiece(right) && super.getBoard().piece(right) == this.chessMatch.getEnPassantVulnerable()) {
						mat[right.getRow() + 1][right.getColumn()] = true;
					}
				}
			}
		}
		return mat;
	}
}
