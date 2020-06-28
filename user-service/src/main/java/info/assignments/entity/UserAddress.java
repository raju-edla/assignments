package info.assignments.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "user_address")
public class UserAddress{
	
		@Column(name = "address_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Id
	    private Integer addressId;
	 	private String street1;
	 	private String street2;
	    private String city;
	    private String state;
	    private String country;
	    private long pin;
	    private String mobile;
	    private String email;
	    @Column(name = "address_type")
	    private String addressType;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "FK_USER_ADDRESS_USER_ID"))
	    @JsonBackReference
	    @ToString.Exclude
	    @EqualsAndHashCode.Exclude
	    private AppUser appUser;
	    
	    

}
