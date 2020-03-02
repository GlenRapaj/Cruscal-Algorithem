package cruscalAlgorithem;

import java.util.ArrayList;
import java.util.List;

public class Cruscal {
	
	public boolean kontrollLidhshmerie( double[][] Grafi , int n ) { 
		
		double S = 0;
		boolean lidhur = true;
		
		for( int i = 0 ; i < n ; i++ ) {
			S = 0;
			for( int j = 0 ; j < n ; j++ ) {
				
				S = S + Grafi[i][j];
				
				if( S > 0 ) {
					// lidhur = true;
					break;
				}
			}
			
			if( S == 0 ) {
				lidhur = false;
				break;
			}
		}
		
		return lidhur;
	}
	
	
	
	
	public double[][] druPerfshiresMinimal( double[][] Grafi, int n ) {
		
		 // mban kulmet qe jane marre ne konsiderate 
		List<Integer> kulmet = new ArrayList<>(); 
		
		// mban peshat e rradhitura nga me e vogla te me e madhja ( ne rend jo zbrites )
		List<Double> peshat = new ArrayList<>();  
		
		// mban brinjet  per peshat perkatese
		List<String> brinjet = new ArrayList<>(); 
		
		String leftNode;
		String rightNode;
		
		for( int i = 0 ; i < n ; i++ ) {
		
			for( int j = i ; j < n ; j++ ) {
				
				if( Grafi[i][j] != 0 ) {
					
					peshat.add( (double) Grafi[i][j] );
					
					leftNode = Integer.toString( i ); 
					rightNode = Integer.toString( j ); 
					 
					brinjet.add( leftNode + "-" + rightNode );
				}
			
			}
		}
		
		

		
		double temp;
		String tempPoz;
		
		// rradhitja elementeve te peshave nga me e vogla te me e madhja 
		
		for( int i = 0 ; i < peshat.size() - 1 ; i++ ) {
			
			for( int j = i + 1 ; j < peshat.size() ; j++ ) {
				
				if( peshat.get(i) > peshat.get(j) ) {
					
					temp = peshat.get(j);
					peshat.set( j, peshat.get(i) );
					peshat.set( i, temp );
					
					tempPoz = brinjet.get(j);
					brinjet.set( j, brinjet.get(i) );
					brinjet.set( i, tempPoz );
				}
				
			}
		}
		

		
		double[][] dru = new double[n][n];
		
		// Do kontrolloj brinjet e peshave perkatese me rradhe per te pare nese mbyllin ciikel.
		for( int i = 0 ; i < peshat.size() ; i++ ) {
			
	
			tempPoz = brinjet.get(i);
			String[] dykulmet = tempPoz.split("-", 2 ); 
			

			if(  !kulmet.isEmpty() ) {
				
			if( kulmet.contains( Integer.parseInt( dykulmet[0] ) ) && kulmet.contains( Integer.parseInt(  dykulmet[1] ) ) ) {
				System.out.println( " Brinja  " + dykulmet[0] + "-" + dykulmet[1] + " mbyll cikel. "  );
			}else {
				
				kulmet.add(Integer.parseInt( dykulmet[0] ));
				kulmet.add(Integer.parseInt( dykulmet[1] ));
				
				dru [ Integer.parseInt( dykulmet[0] ) ][ Integer.parseInt( dykulmet[1] ) ] = peshat.get( i );
				

			}
			
		}else {
			
			kulmet.add(Integer.parseInt( dykulmet[0] ));
			kulmet.add(Integer.parseInt( dykulmet[1] ));
			
			dru [ Integer.parseInt( dykulmet[0] ) ][ Integer.parseInt( dykulmet[1] ) ] = peshat.get( i );
			

		}
			
		}
			return dru ;
		}
		
		
		


}
