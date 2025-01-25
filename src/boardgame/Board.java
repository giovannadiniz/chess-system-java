package boardgame;

public class Board {
	
	private int rows; //Esse é o número de linhas no tabuleiro. Em um jogo de tabuleiro, as linhas são as linhas horizontais onde as peças podem se mover.//
	private int columns; //Esse é o número de colunas no tabuleiro. As colunas são as linhas verticais, de cima para baixo.//
	private Piece[][] pieces; //Aqui, o tabuleiro é representado como uma matriz (ou tabela) de peças. Cada posição dessa matriz vai guardar uma peça do jogo, se houver uma, ou vai ser "vazia" caso não tenha peça naquela posição.//
	
	public Board(int rows, int columns) { //construtor: Esse método é chamado quando você cria um novo tabuleiro. Ele vai pedir dois números: o número de linhas e colunas do tabuleiro.//
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public int getRows() { //Esse método serve para você saber quantas linhas o tabuleiro tem. Ele simplesmente retorna o valor de rows.//
		return rows;
	}
	
	public void setRows(int rows) { //Esse método permite mudar o número de linhas do tabuleiro. Se você quiser, pode atualizar a quantidade de linhas passando um novo valor para esse método.//
		this.rows = rows;
	}
	
	public int getColumns() { //Esse método serve para você saber quantas colunas o tabuleiro tem. Ele retorna o valor de columns.//
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
} 