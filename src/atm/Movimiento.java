package atm;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Movimiento {

	private static AtomicInteger count = new AtomicInteger(0);
	private Integer id;
	private Date fecha;
	private String concepto, aliasOrigen, aliasDestino;
	private Double importe;
	
	
	public Movimiento(Date fecha, String concepto, String aliasOrigen, Double importe) {
		
		this.fecha = fecha;
		this.concepto = concepto;
		this.aliasOrigen = aliasOrigen;
		this.importe = importe;
		this.id = count.incrementAndGet();
	}
	
	public Movimiento(Date fecha, String concepto, String aliasOrigen, String aliasDestino, Double importe) {
		
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
	
	
	public Date getFecha() {
		
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
	
	
	public Double getImporte() {
		
		return importe;
	}
}
