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
import org.hibernate.validator.constraints.Range;


@Getter
@Setter
@Entity
public class Product extends GenericModel<Long> {
	@Id
	@SequenceGenerator(
			name = "product_sequence",
			sequenceName = "product_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_sequence"
	)
	private Long id;

	@NotEmpty
	private String name;

	private String description;

	@Range(min = 0, max = 10000000, message = "Price is not between $0 and $100,000!")
	private Integer priceInCents;
}
