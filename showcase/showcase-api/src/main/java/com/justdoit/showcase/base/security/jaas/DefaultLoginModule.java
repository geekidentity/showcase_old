package com.justdoit.showcase.base.security.jaas;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class DefaultLoginModule implements LoginModule {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private Subject subject;
	private CallbackHandler callbackHandler;
	private String name;
	private String password;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		NameCallback nameCallback = new NameCallback("prompt");
		PasswordCallback passwordCallback = new PasswordCallback("prompt", false);
		try {
			this.callbackHandler.handle(new Callback[]{nameCallback, passwordCallback});
			name = nameCallback.getName();
			password = new String(passwordCallback.getPassword());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean login() throws LoginException {
		logger.debug("user login: name:" + name + "\t password:" + password);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(name, password);
		subject.getPrincipals().add(authenticationToken);
		return true;
	}

	@Override
	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

}
