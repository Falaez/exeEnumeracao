package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List <OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public Double total() {
		double sum = 0;
		for (OrderItem x : items) {
			sum += x.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Client: "+client+" \n");
		sb.append("Order items: \n");
		for (OrderItem x: items) {
			sb.append(x.getProduct()+", Quantity: "+x.getQuantity()+", Subtotal: "+x.subTotal()+" \n");
		}
		sb.append("Total price: "+ total());
		return sb.toString();
	}
}
