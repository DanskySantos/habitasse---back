package com.project.habitasse.security.person.entities.response;

import com.project.habitasse.security.person.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaResponse {

	private Long id;
	private String name;
	private Date birthday;
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;

	public static PessoaResponse mapEntityToResponse(Person person) {
		return PessoaResponse.builder()
				.id(person.getId())
				.name(person.getName())
				.birthday(person.getBirthday())
				.creationDate(person.getCreationDate())
				.updateDate(person.getUpdateDate())
				.build();
	}
}
