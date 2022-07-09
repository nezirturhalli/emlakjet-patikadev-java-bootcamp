package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "advertisements")
@Getter
@Setter

public class Advertisement {
    @Id
    @Column(name = "id")
    private String advertisementId;
    private String title;
    private BigDecimal price;
    private String detailMessage;
    @CreatedDate
    private LocalDateTime createdAt;
    private Long userId;

    public Advertisement() {
        this.advertisementId = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Advertisement that = (Advertisement) o;
        return advertisementId != null && Objects.equals(advertisementId, that.advertisementId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
