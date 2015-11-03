package com.shivang.secretsharing;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivang.secretsharing.Interfaces.SecretService;
import com.shivang.secretsharing.pojo.Secret;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml" });

        SecretService ssc = (SecretService) appContext.getBean("secretservice");
        Secret aliceS = new Secret();
        UUID iAlice  = ssc.storeSecret("Alice", aliceS);
        ssc.shareSecret("Alice", iAlice, "Alice");
        ssc.unshareSecret("Alice", iAlice, "Alice");
        ssc.unshareSecret("Alice", iAlice, "Alice");
        ssc.readSecret("Alice", iAlice);
    }
}
