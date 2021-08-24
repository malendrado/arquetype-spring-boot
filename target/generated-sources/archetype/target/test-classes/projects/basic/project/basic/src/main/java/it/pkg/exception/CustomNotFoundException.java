package it.pkg.exception;

import it.pkg.enums.ErrorCodesEnum;

public class CustomNotFoundException extends BusinessException {

	private static final long serialVersionUID = 5760507686814975116L;
	public CustomNotFoundException() {
		super(ErrorCodesEnum.NOT_FOUND);
	}
	
	public CustomNotFoundException(ErrorCodesEnum code) {
		super(code);
	}
	
	public CustomNotFoundException(ErrorCodesEnum code, Object v) {
		super(code, String.valueOf(v));
	}
}