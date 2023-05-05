package com.sportradar.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Goal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4506253518914074854L;
	
	private Long id;
	private Long idTeam;
	private Long minute;
	private String scorer;
	
//	public Goal(Long id, Long idTeam, Long minute, String scorer) {
//		this.id = id;
//		this.idTeam = idTeam;
//		this.minute = minute;
//		this.scorer = scorer;
//	}

}
