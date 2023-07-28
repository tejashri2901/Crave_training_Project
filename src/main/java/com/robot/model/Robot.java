package com.robot.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="myrobot")
public class Robot {
	     @Id
         private int id;
         private String model;
         private float price;
         private String color;
		public Robot() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Robot(int id, String model, float price, String color) {
			super();
			this.id = id;
			this.model = model;
			this.price = price;
			this.color = color;
		}
		@Override
		public String toString() {
			return "Robot [id=" + id + ", model=" + model + ", price=" + price + ", color=" + color + "]";
		}
		public int getid() {
			return id;
		}
		public void setid(int id) {
			this.id = id;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		@Override
		public int hashCode() {
			return Objects.hash(id, color, model, price);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Robot other = (Robot) obj;
			return id == other.id && Objects.equals(color, other.color) && Objects.equals(model, other.model)
					&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
		}
         
}
