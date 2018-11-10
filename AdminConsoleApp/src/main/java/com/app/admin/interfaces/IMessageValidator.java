package com.app.admin.interfaces;

import com.app.admin.request.GenericRequestType;
import com.app.admin.response.GenericResponse;


public interface IMessageValidator {

	public GenericResponse validateMessage(GenericRequestType request);
}
