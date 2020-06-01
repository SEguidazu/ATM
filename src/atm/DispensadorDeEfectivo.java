package atm;

import java.math.BigDecimal;

public class DispensadorDeEfectivo {

	private Integer billetes100 = 500;
	private Integer billetes500 = 500;
	private Integer billetes1000 = 500;
	
	public void EntregarDinero(BigDecimal total){
		
		int mil = 0;
		int quini = 0;
		int cien = 0;
		
		if(total.compareTo( BigDecimal.valueOf( 1000 ) ) > 0 ){
			
			while( total.compareTo( BigDecimal.valueOf( 1000 ) ) >= 0 ){
				mil++;
				total.subtract(BigDecimal.valueOf( 1000 ));
				this.billetes1000--;
			}
			
		}
		
		if(total.compareTo( BigDecimal.valueOf( 500 ) ) > 0 ){
			
			while( total.compareTo( BigDecimal.valueOf( 500 ) ) >= 0 ){
				quini++;
				total.subtract(BigDecimal.valueOf( 500 ));
				this.billetes500--;
			}
			
		}
		
		if(total.compareTo( BigDecimal.valueOf( 100 ) ) > 0 ){
			
			while( total.compareTo( BigDecimal.valueOf( 100 ) ) >= 0 ){
				cien++;
				total.subtract(BigDecimal.valueOf( 100 ));
				this.billetes100--;
			}
			
		}
		
		System.out.println("Se entregaron: "+mil+" billetes de mil. "+quini+" billetes de 500. "+cien+" billetes de 100.");

	}
	
	public boolean puedeOperar(BigDecimal total){
		
		int mil = this.billetes1000 * 1000;
		int quini = this.billetes500 * 500;
		int cien = this.billetes100 * 100;
		int sum = mil + quini + cien; 
		
		return total.compareTo( BigDecimal.valueOf( sum ) ) <= 0;
	}
}
