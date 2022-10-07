package br.gov.sp.fatec.projetolab5.repositoy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.projetolab5.entity.Autorizacao;
import br.gov.sp.fatec.projetolab5.entity.Usuario;
import br.gov.sp.fatec.projetolab5.repository.AutorizacaoRepository;
import br.gov.sp.fatec.projetolab5.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioReporitoryTest {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private AutorizacaoRepository autRepo;


	@Test
	void contextLoads() {
	}
	
	@Test
	public void testaInsercao() {
		Usuario usuario = new Usuario();
		usuario.setNome("Valdiney2");
		usuario.setSenha("SenhaF0rte");
		usuarioRepo.save(usuario);
		assertNotNull(usuario.getId());
		
	}
	
	@Test
	public void testaAutorizacao() {
		Usuario usuario = usuarioRepo.findById(1L).get();
		assertEquals("ROLE_ADMIN", usuario.getAutorizacoes().iterator().next().getNome());
		
	}
	
	@Test
	public void testaUsuario() {
		Autorizacao aut = autRepo.findById(1L).get();
		assertEquals("Valdiney", aut.getUsuarios().iterator().next().getNome());
		
	}

}
