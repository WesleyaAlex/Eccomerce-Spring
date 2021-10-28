package eccomerce.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import eccomerce.spring.web.models.Cliente;

public class SenhasIguaisValidation implements ConstraintValidator<SenhasIguais, Cliente> {

	@Override
	public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
		boolean resultado = cliente.getSenha().equals(cliente.getConfirmSenha());
		
		return resultado;
	}
}