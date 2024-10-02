package com.hamitmizrak.springboot_ecommerce.data.entity;

import com.hamitmizrak.springboot_ecommerce.data.embedded.EmbeddableCustomerEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;

// LOMBOK
@Data // Getter,Setter,Equals, hashCode
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor //parametresiz constructor
@AllArgsConstructor //parametresiz constructor
@Builder
@Log4j2

/*
Customer  ------  Address
   1    @OneToOne    1

Customer  ------<    Order
   1     @ManyToOne    *

Order  >------<  Product
   *  @ManyToMany    *
 */
@Entity(name = "Customers")
@Table(name = "customer")
public class CustomerEntity extends BaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // Field
    // Embedded
    @Embedded
    EmbeddableCustomerEntity embeddableCustomerEntity = new EmbeddableCustomerEntity();

    // Parametreli Constructor içinde çağırmamız lazım
    public CustomerEntity(EmbeddableCustomerEntity embeddableCustomerEntity) {
        this.embeddableCustomerEntity = embeddableCustomerEntity;
    }
} //end class CustomerDto
