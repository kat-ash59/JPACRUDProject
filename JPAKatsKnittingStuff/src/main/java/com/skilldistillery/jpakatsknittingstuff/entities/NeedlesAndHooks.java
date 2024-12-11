package com.skilldistillery.jpakatsknittingstuff.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="needlesandhooks")
public class NeedlesAndHooks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String material;
	
	private String type;
	
	private double length;
	
	@Column(name="US_size")
	private String usSize;
	
	@Column(name="Metric_size")
	private String metricSize;
	
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getUsSize() {
		return usSize;
	}

	public void setUsSize(String usSize) {
		this.usSize = usSize;
	}

	public String getMetricSize() {
		return metricSize;
	}

	public void setMetricSize(String metricSize) {
		this.metricSize = metricSize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "JPAKnit [id = " + id + ", material = " + material + ", type = " + type + ", length = " + length + ", usSize = "
				+ usSize + ", metricSize = " + metricSize + ", quantity = " + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, length, material, metricSize, quantity, type, usSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NeedlesAndHooks other = (NeedlesAndHooks) obj;
		return id == other.id && Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Objects.equals(material, other.material) && Objects.equals(metricSize, other.metricSize)
				&& quantity == other.quantity && Objects.equals(type, other.type)
				&& Objects.equals(usSize, other.usSize);
	}	
		
}
