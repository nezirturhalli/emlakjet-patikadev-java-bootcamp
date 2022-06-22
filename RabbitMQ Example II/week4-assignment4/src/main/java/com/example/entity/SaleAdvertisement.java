package com.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sale_advertisements")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SaleAdvertisement {
    @Id
    @GeneratedValue(generator = "saleAdvertisementPk_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "saleAdvertisementPk_sequence", sequenceName = "saleAdvertisementPk_sequence", allocationSize = 1)
    @Column(name = "saleAdvertisement_pk")
    private Long saleAdvertisementPk;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonIgnore
    private User user;
    @Column(name = "user_pk")
    private Long userPk;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleAdvertisement that = (SaleAdvertisement) o;
        return saleAdvertisementPk != null && Objects.equals(saleAdvertisementPk, that.saleAdvertisementPk);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
