package br.ecocoleta.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

@Entity
public class CollectionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<WasteType> acceptedTypes;

    private String hours;
    private String phone;

    public CollectionPoint() {}

    public CollectionPoint(String name, String address, Double latitude, Double longitude,
                           Set<WasteType> acceptedTypes, String hours, String phone) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.acceptedTypes = acceptedTypes;
        this.hours = hours;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Set<WasteType> getAcceptedTypes() { return acceptedTypes; }
    public void setAcceptedTypes(Set<WasteType> acceptedTypes) { this.acceptedTypes = acceptedTypes; }

    public String getHours() { return hours; }
    public void setHours(String hours) { this.hours = hours; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
