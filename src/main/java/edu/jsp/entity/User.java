package edu.jsp.entity;

import java.util.List;

import edu.jsp.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @NotNull
	@NotBlank
	@NotEmpty(message = "Name can't be empty")
	private String name;
	@Column(unique = true)
	@NotNull
	@NotBlank
	@Email(message = "Invaid Email id")
	private String email;
	@Column(unique = true)
	@NotNull
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phnNo;
	@NotNull
	@NotBlank
	private String password;
	private Role role;
	@OneToMany
	private List<FoodOrder> foodorder;
}
