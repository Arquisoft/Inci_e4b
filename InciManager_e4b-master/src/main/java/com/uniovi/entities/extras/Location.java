package com.uniovi.entities.extras;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
	
	protected double latitude;
	protected double longitude;
	
	/**
	 * Constructor vacio
	 */
	public Location() {}

	/**
	 * Constructor que recibe la longitud y la altitud
	 * @param latitud
	 * @param longitud
	 */
	public Location(double latitud, double longitud) {
		super();
		this.latitude = latitud;
		this.longitude = longitud;
	}

	/**
	 * Devuelve la latitud de la localizacion
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Asigna la latitud de la localizacion
	 * @param latitud
	 */
	public void setLatitude(double latitud) {
		this.latitude = latitud;
	}

	/**
	 * Devuelve la altitud de la localizacion
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Asigna la altitud de la localizacion
	 * @param latitude
	 */
	public void setLongitude(double longitud) {
		this.longitude = longitud;
	}

	@Override
	public String toString() {
		return "[latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		return Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude);
	}
	
	
}