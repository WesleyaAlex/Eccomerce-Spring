package eccomerce.spring.admin.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eccomerce.spring.admin.models.Usuario;

public class SenhasIguaisValidation implements ConstraintValidator<SenhasIguais, Usuario> {

	@Override
	public boolean isValid(Usuario usuario, ConstraintValidatorContext context) {
		boolean resultado = usuario.getSenha().equals(usuario.getConfirmSenha());
		
		return resultado;
	}
}