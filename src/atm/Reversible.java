package atm;

import exceptions.CuentaException;

public interface Reversible {

	public void revertir() throws CuentaException;
}
