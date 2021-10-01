package cruscalAlgorithem;

public class CruscalAlgorithem {

		public static boolean BFS( double[][] grafi, int b ) { 
			boolean lidhur = true;
			LinkedList<Integer > que = new LinkedList<Integer >();
			boolean[] visited = new boolean[grafi.length ];
			for ( int i = 0; i < visited.length ; i ++) {  visited[i ] = false; }
			visited[b] = true ;
			removeQue( visited,  que,  grafi, b );
			while(  que.size() != 0 ) {
				int t = que.poll();
				visited[t] = true;
				removeQue( visited, que, grafi, t);	
			}
			for(int j = 0 ; j < visited.length ; j++ ) {
				if( !visited[j] ) {
					lidhur = false;
					break ;
				}	
			}
			return lidhur ;
	}
		
	
	public static void main(String[] args) {
		double[][] Grafi = new double[4][4];
		
		Grafi[ 0 ][ 0 ] = 0 ;
		Grafi[ 0 ][ 1 ] = 1 ;
		Grafi[ 0 ][ 2 ] = 1 ;
		Grafi[ 0 ][ 3 ] = 4 ;
		Grafi[ 1 ][ 0 ] = 1 ;
		Grafi[ 1 ][ 1 ] = 0 ;
		Grafi[ 1 ][ 2 ] = 2 ;
		Grafi[ 1 ][ 3 ] = 3 ;
		Grafi[ 2 ][ 0 ] = 1 ;
		Grafi[ 2 ][ 1 ] = 2 ;
		Grafi[ 2 ][ 2 ] = 0 ;
		Grafi[ 2 ][ 3 ] = 0 ;
		Grafi[ 3 ][ 0 ] = 4 ;
		Grafi[ 3 ][ 1 ] = 3 ;
		Grafi[ 3 ][ 2 ] = 0 ;
		Grafi[ 3 ][ 3 ] = 0 ;
		
		double[][] druPerfshires = new double[4][4];
		Cruscal cruscalAlg = new Cruscal();
		boolean lidhshmeria = BFS(Grafi, 0 );
		
		if( lidhshmeria ){ druPerfshires = cruscalAlg.druPerfshiresMinimal( Grafi, Grafi.length ); }
		for( int i = 0 ; i < Grafi.length ; i++ ) {
			for( int j = i ; j < Grafi.length ; j++ ) {
				System.out.println( " Ne Drurin Perfshires ne pozicionin e : " + i + " - " + j + " eshte elementi  -------> " + druPerfshires[i][j]  );
			}	
		}	
	}
}
