package be.vdmr.accounting.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractBaseObject implements Comparable<Object> {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "CREATED_ON_TIMESTAMP")
    private LocalDateTime createdOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY_ID")
    private User createdBy;

    @Column(name = "LAST_MODIFIED_ON_TIMESTAMP")
    private LocalDateTime lastModifiedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAST_MODIFIED_BY_ID")
    private User lastModifiedBy;

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastModifiedOn() {
        return lastModifiedOn;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @PrePersist
    public void onCreate() {
        this.createdOn = LocalDateTime.now();
        this.lastModifiedOn = createdOn;
    }

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedOn = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " - id : " + getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractBaseObject that = (AbstractBaseObject) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public int compareTo(Object o) {
        return getCreatedOn().compareTo(((AbstractBaseObject) o).getCreatedOn());
    }
}
