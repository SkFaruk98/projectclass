package edu.jsp.dto;

import edu.jsp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	private long id;
	private String name;
	private String email;
	private long phnNo;
	private Role role;
}
