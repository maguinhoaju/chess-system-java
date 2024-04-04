package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)this.getBoard().piece(position);
		return p == null || p.getColor() != this.getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		p.setValues(super.position.getRow() - 1, super.position.getColumn() - 2);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(super.position.getRow() - 2, super.position.getColumn() - 1);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(super.position.getRow() - 2, super.position.getColumn() + 1);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(super.position.getRow() - 1, super.position.getColumn() + 2);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(super.position.getRow() + 1, super.position.getColumn() + 2);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(super.position.getRow() + 2, super.position.getColumn() + 1);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(super.position.getRow() + 2, super.position.getColumn() - 1);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(super.position.getRow() + 1, super.position.getColumn() - 2);
		if(super.getBoard().positionExists(p) && this.canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}

}
