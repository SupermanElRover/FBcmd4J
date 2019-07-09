package fbcmj4;
/* Como la aplicación se conecta con una aplicación creada en Facebook Developer, de esta pádina es donde vamos a tomar:
 * App Secret
 * AccesToken
 * AppID
 * Como se conecta directamente con esta aplicación, no es necesario pedirlos y podemos tener los datos estaticos
 */
import java.util.Scanner;

public class SettingsManager {

	
	public static String getAppSecret() {
		return "7c7b34c925680a4f83b2b974a89b59c6";
	}
	
	public static String getAccessToken() {
		return "EAAD9rYyZCFKYBAOpVLHINQNg38OE2zSpcwDC3uNDl0YwStZAbf06JZBi4gE4ey15f0GueWkRytwVRui4z62zQigfKgLOp5R2pVdLNSr5XZAHn85tSEcV5423rv3HPaVKQAkNkCNaox20ygWCxXtIG1KE1yMwDLz2WG2ip7IsZCwZDZD";
	}
	
	public static String getPermissions() {
		return "public_profile,user_actions.news,user_posts,publish_actions";
	}
	
	public static String getAppId() {
		return "278921832502438";
	}
	
	public static String getUrlForToken() {
		//https://www.facebook.com/v2.10/dialog/oauth?client_id=132509980725145&redirect_uri=https://www.facebook.com/connect/login_success.html&scope=public_profile,user_actions.news,user_posts,publish_actions
		return "https://www.facebook.com/v2.10/dialog/oauth?client_id="+getAppId()+"&redirect_uri=https://www.facebook.com/connect/login_success.html&scope=" + getPermissions();
	}
	
	public static String LoginProccess(Scanner scan) {
		System.out.println("Hola!, para acceder debes entrar a la siguiente liga y a continuacion copiar el parametro code aqui (" + getUrlForToken() + "):");
		String code = scan.nextLine();
		String urlToken = "https://graph.facebook.com/oauth/access_token?client_id=" + getAppId() + "&redirect_uri=https://www.facebook.com/connect/login_success.html" + "&client_secret=" + getAppSecret() + "&code=" + code;
		System.out.println("Ahora accede a la url y del JSON pega el dato de acces_token (" + urlToken + "):" );
		String newToken = scan.nextLine();
		setAppSecret(newToken);
		return newToken;
		
	}
	
	public static void setAppSecret(String newValue) {
		//
	}
	
	public static void setAccessToken(String newValue) {
		//
	}
	
	public static void setPermissions(String newValue) {
		// 
	}
	
	public static void setAppId(String newValue) {
		//
	}
}
