package corbaClient;

import corbaConversion.IConversionRemote;
import corbaConversion.IConversionRemoteHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class ConversionClient {
    public static void main(String[] args) throws NamingException {
        // Initialisation du contexte initial pour la communication avec le serveur CORBA
        Context ctx = new InitialContext();

        // Recherche de l'objet distant en utilisant le nom "CV" dans le contexte
        Object ref = (Object) ctx.lookup("CV");

        // Conversion de la référence de l'objet en une référence à l'interface IConversionRemote
        IConversionRemote stub = IConversionRemoteHelper.narrow((org.omg.CORBA.Object) ref);

        // Initialisation d'un scanner pour lire les entrées utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de saisir un montant à convertir
        System.out.println("Veuillez entrer un montant à convertir : ");
        double montant = scanner.nextDouble();

        // Affichage du montant avant la conversion
        System.out.println("Le montant avant conversion : " + montant);

        // Appel de la méthode distante pour effectuer la conversion du montant
        double montantConverti = stub.conversionMontant(montant);

        // Affichage du montant après conversion
        System.out.println("\nLe montant après conversion : " + montantConverti);
    }
}
