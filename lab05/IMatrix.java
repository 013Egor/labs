public interface IMatrix {

  public IMatrix sum(IMatrix t);

  public IMatrix product(IMatrix t);

  public void set ( int row, int column, int value );

	public int get ( int row, int column );

  public int getRows();

  public int getColumns();

	public String toString ();
}
