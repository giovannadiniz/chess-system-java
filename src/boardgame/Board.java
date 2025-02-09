package boardgame;

public class Board {
	
	private int rows; //Esse é o número de linhas no tabuleiro. Em um jogo de tabuleiro, as linhas são as linhas horizontais onde as peças podem se mover.//
	private int columns; //Esse é o número de colunas no tabuleiro. As colunas são as linhas verticais, de cima para baixo.//
	private Piece[][] pieces; //Aqui, o tabuleiro é representado como uma matriz (ou tabela) de peças. Cada posição dessa matriz vai guardar uma peça do jogo, se houver uma, ou vai ser "vazia" caso não tenha peça naquela posição.//
	
	public Board(int rows, int columns) { //construtor: Esse método é chamado quando você cria um novo tabuleiro. Ele vai pedir dois números: o número de linhas e colunas do tabuleiro.//
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: é necessário que haja pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public int getRows() { //Esse método serve para você saber quantas linhas o tabuleiro tem. Ele simplesmente retorna o valor de rows.//
		return rows;
	}
	
	public int getColumns() { //Esse método serve para você saber quantas colunas o tabuleiro tem. Ele retorna o valor de columns.//
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {		
		if(!positionExists(position)) {
		throw new BoardException("Posição não está no tabuleiro");
	}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("já existe uma peça em posição " + position);
			
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	} //Verifica se as coordenadas fornecidas estão dentro dos limites do tabuleiro//
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	} //Verifica se a posição, representada por um objeto Position, está dentro dos limites do tabuleiro//
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
		throw new BoardException("Posição não está no tabuleiro");
	}
		return piece(position) != null; //Verifica se existe uma peça na posição fornecida//
	}
} 