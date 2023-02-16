package com.br.vitorpadovan.run2biz.bff.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
		indexes = { @Index(name = "idx_latitude", columnList = "latitude", unique = false),
				@Index(name = "idx_longitude", columnList = "longitude", unique = false),
				@Index(name = "idx_latilong", columnList = "longitude, latitude", unique = false) }
)
public class Denuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codDenuncia;

	private String titulo;

	private String descricao;

	private double latitude;

	private double longitude;

	@ManyToOne
	@JoinColumn(name = "codDenunciante")
	private Pessoa denunciante;

	@ManyToOne
	@JoinColumn(name = "codEndereco")
	private Endereco endereco;
}
