package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class OrderItem extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="ODER_ID")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item itemId;

    int orderPrice;

    int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItemId() {

        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
