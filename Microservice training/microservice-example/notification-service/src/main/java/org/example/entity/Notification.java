package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "notifications")
@Getter
@Setter
public class Notification {
    @Id
    @Column(name = "id")
    private String notificationId;
    private String message;
    @CreatedDate
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private NotificationState state;
    private Long userId;
    private String advertisementId;


    public Notification() {
        this.notificationId = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Notification that = (Notification) o;
        return notificationId != null && Objects.equals(notificationId, that.notificationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
