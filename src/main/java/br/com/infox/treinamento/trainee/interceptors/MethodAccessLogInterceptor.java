package br.com.infox.treinamento.trainee.interceptors;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@MethodAccessLog
@Interceptor
public class MethodAccessLogInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger("trainee.interceptor");

	@AroundInvoke
	public Object interceptarMetodo(InvocationContext context) throws Exception {
		try {
			LOG.info(String.format("ANTES DE INVOCAR %s.%s", context.getMethod().getDeclaringClass().getName(), context.getMethod().getName()));
			return context.proceed();
		} finally {
			LOG.info(String.format("APÓS DE INVOCAR %s.%s", context.getMethod().getDeclaringClass().getName(), context.getMethod().getName()));
		}
	}

}
