package com.uniovi.incidenceManager.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Operario;

/**
 * Implementación del servicio de detalles de usuario, dado un dni, que se usa como
 * identificador del usuario, se le asignan las autorizaciones dadas bajo el rol operario y 
 * después de esto se retorna un objeto User del módulo de seguridad de spring con el dni,
 * la contraseña y las autorizaciones dadas.
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{

	/**
	 * El servicio de operarios se usará para recuperar información del usuario
	 * en cuestión.
	 */
	@Autowired
	private OperarioService operarioService;

	/**
	 * Se carga al usuario en sesión a través de su dni, identificador usado para cada
	 * usuario, y después de esto se le darán permisos de operario y se creará un objeto
	 * usuario de spring security con los permisos, el dni y la contraseña del usuario.
	 */
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException{
		Operario user = operarioService.findByDni(dni);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_OPERARIO"));

		return new org.springframework.security.core.userdetails.User(
				user.getDni(), user.getPassword(), grantedAuthorities);
	}

}
