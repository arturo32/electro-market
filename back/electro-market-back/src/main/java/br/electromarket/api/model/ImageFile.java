package br.electromarket.api.model;

import br.electromarket.base.model.GenericModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ImageFile extends GenericModel<Long> {
	@Id
	@SequenceGenerator(
			name = "image_file_sequence",
			sequenceName = "image_file_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "image_file_sequence"
	)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String path;
}
