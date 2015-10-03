package com.shivang.secretsharing.Advices;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

import org.springframework.aop.MethodBeforeAdvice;

import com.shivang.secretsharing.SecretServiceClass;
import com.shivang.secretsharing.Exceptions.UnauthorizedException;
import com.shivang.secretsharing.pojo.Secret;
import com.shivang.secretsharing.pojo.User;

public class HijackBefore implements MethodBeforeAdvice {
	
	private Map<String, User> usersDB;
	
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		String methodName = method.getName();
		SecretServiceClass ssc = (SecretServiceClass) target;
		usersDB = ssc.getUsersDB();
		
		if(methodName.equals("readSecret")){
			UUID key = (UUID)arg1[1];
			System.out.println(arg1[0] +" reads the secret of ID "+key);
			if(!isAuth(arg1[0], key)){
				throw new UnauthorizedException(arg1[0].toString());
			}
		}
		if(methodName.equals("shareSecret")){
			UUID key = (UUID)arg1[1];
			System.out.println(arg1[0] +" shares the secret of ID "+key+" with "+ arg1[2]);
			if(!isAuth(arg1[0], key)){
				throw new UnauthorizedException(arg1[0].toString());
			}
		}
		if(methodName.equals("unshareSecret")){
			System.out.println(arg1[0] +" unshares the secret of ID "+arg1[1]+" with "+ arg1[2]);
			UUID key = (UUID)arg1[1];
			if(!isAuth (arg1[0], key)){
				throw new UnauthorizedException(arg1[0].toString());
			}
		}	
	}
	
	/*
	 * Checks if User can access Secret
	 */
	boolean isAuth(Object userID, UUID secretID){
		if(!usersDB.get(userID).getOwnSecrets().containsKey(secretID) && !usersDB.get(userID).getReceivedSecrets().containsKey(secretID)){
			return false;
		}
		return true;
	}
}
