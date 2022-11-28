package programmierPflicht;

/** Map mit Schluessel vom Typ Integer und Werten vom Typ String */
public interface IntStringMap {
	/**
	 * fuegt ein Schluessel-Wert-Paar in die Map ein
	 * 
	 * @param key   der Schluessel
	 * @param value der Wert
	 * @return falls es schon einen Wert mit Schluessel key in der Map gab,
	 *         wird der alte Wert entfernt und zurueckgegeben; sonst wird null
	 *         zurueckgegeben
	 */
	String put(Integer key, String value);

	/**
	 * bestimmt den Wert zu einem Schluessel in der Map
	 * 
	 * @param key der Schluessel
	 * @return den Wert zum Schluessel key, falls ein entsprechendes
	 *         Schluessel-Wert-Paar vorhanden ist;
	 *         null sonst
	 */
	String get(Integer key);

	/**
	 * entfernt ein Schluessel-Wert-Paar aus der Map
	 * 
	 * @param key der Schluessel
	 * @return der Wert zu dem Schluessel, falls ein entsprechendes
	 *         Schluessel-Wert-Paar vorhanden ist;
	 *         null sonst
	 */
	String remove(Integer key);
}