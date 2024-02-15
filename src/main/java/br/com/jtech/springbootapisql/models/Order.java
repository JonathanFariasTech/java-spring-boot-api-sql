package br.com.jtech.springbootapisql.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import br.com.jtech.springbootapisql.models.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_tb")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
        
    }

    public Order(Instant moment, Integer orderStatus, User client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }


    public User getClient() {
        return this.client;
    }
    
    public OrderStatus getOrderStatus() {
    	return OrderStatus.valueOf(orderStatus);
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
    	if(orderStatus != null) {
    		this.orderStatus = orderStatus.getCode();
    	}
    }
    
    public Set<OrderItem> getItems() {
    	return items;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id, moment, orderStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(moment, other.moment) && orderStatus == other.orderStatus;
	}
    
    
}
