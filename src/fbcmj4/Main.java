package fbcmj4;

//Importamos librer�as de java
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//Importamos librer�as de Logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Importamos librer�as de Facebook
import facebook4j.FacebookException;

public class Main {
	
	//Asignamos a Logger
	static final Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws FacebookException, IOException, GenericError {
		// TODO Auto-generated method stub
		FBAdapter fb = new FBAdapter();
		Scanner input = new Scanner(System.in);
		boolean next = true;

		//Creamos las opciones a proyectar como men�
		while (next) {
			System.out.println("Cliente de FB v1.0");
			System.out.println("Menu:");
			System.out.println("\t1 - Configurar usuario");
			System.out.println("\t2 - Ver usuario");
			System.out.println("\t3 - Ver newsfeed");
			System.out.println("\t4 - Ver wall");
			System.out.println("\t5 - Publicar Estado");
			System.out.println("\t6 - Publicar link");
			System.out.println("\t7 - Salir");
			String menu = input.nextLine();

			//Creamos el Switch para manejar el men�
			switch (menu) {
			case "1":
				String newToken = SettingsManager.LoginProccess(input);
				fb = new FBAdapter(newToken);
				break;
			case "2":
				System.out.println("Hola " + fb.conn.getMe().getName());
				break;
			case "3":
				fb.verNewsFeed();
				break;
			case "4":
				fb.verWall();
				break;
			case "5":
				System.out.println("Nuevo estado:");
				String mensaje = input.nextLine();
				fb.publicar(mensaje);
				break;
			case "6":
				System.out.println("Nuevo estado:");
				String urlString = input.nextLine();
				try {
					URL url = new URL(urlString);
					fb.publicarLink(url);					
				} catch(MalformedURLException e) {
					log.error("La url introducida no es valida");
				} catch(Exception e) {
					log.error("Error de conectividad");
				}
				
				break;
			case "7":
				next = false;
				break;
			//Creamos una opci�n para manejar las opciones fuera de los n�meros anteriores
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
	}

}
