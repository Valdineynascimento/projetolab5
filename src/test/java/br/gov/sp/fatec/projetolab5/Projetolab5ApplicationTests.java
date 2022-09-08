package br.gov.sp.fatec.projetolab5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.projetolab5.entity.Usuario;
import br.gov.sp.fatec.projetolab5.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class Projetolab5ApplicationTests {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testaInsercao() {
		Usuario usuario = new Usuario();
		usuario.setNome("Valdiney");
		usuario.setSenha("SenhaF0rte");
		usuarioRepo.save(usuario);
		assertNotNull(usuario.getId());
		
	}

}
