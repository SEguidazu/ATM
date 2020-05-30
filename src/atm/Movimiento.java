package atm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Movimiento {

	private static AtomicInteger count = new AtomicInteger(0);
	private Integer id;
	private LocalDate fecha;
	private String concepto, aliasOrigen, aliasDestino;
	private BigDecimal importe;
	
	
	public Movimiento(LocalDate fecha, String concepto, String aliasOrigen, BigDecimal importe) {
		
		this.fecha = fecha;
		this.concepto = concepto;
		this.aliasOrigen = aliasOrigen;
		this.importe = importe;
		this.id = count.incrementAndGet();
	}
	
	public Movimiento(LocalDate fecha, String concepto, String aliasOrigen, String aliasDestino, BigDecimal importe) {
		
		this.fecha = fecha;
		this.concepto = concepto;
		this.aliasOrigen = aliasOrigen;
		this.aliasDestino = aliasDestino;
		this.importe = importe;
		this.id = count.incrementAndGet();
	}
	
	
	public Integer getId() {
		
		return id;
	}
	
	
	public LocalDate getFecha() {
		
		return fecha;
	}
	
	
	public String getConcepto() {
		
		return concepto;
	}
	
	
	public String getAliasOrigen() {
		
		return aliasOrigen;
	}
	
	
	public String getAliasDestino() {
		
		return aliasDestino;
	}
	
	
	public BigDecimal getImporte() {
		
		return importe;
	}
}
