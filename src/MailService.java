import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailService 
{
	public static void main(String[] args)
	{
		sendSimpleMail();
	}

	public static void sendSimpleMail()

	{

		// The email address we wish to send to

		String mailTo = "andru183@gmail.com";


		// The email address we want to say it's from

		String mailFrom = "andru183@gmail.com";



		// Create the system properties

		Properties properties = System.getProperties();


		// Get the default Session object.

		Session session = Session.getDefaultInstance(properties);





		MimeMessage message = new MimeMessage( session );

		try{



			//Set the from field

			message.setFrom(new InternetAddress(mailFrom));


			//Set the to field

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));


			//Set the subject field

			message.setSubject("Add a subject here");


			//Set the body of the message

			message.setText("write the body of the message here");


			//Attempt to send our email

			Transport.send(message);



			//Print that we did well

			System.out.println("Message sent");

		}


		catch (MessagingException messageExp) 

		{

			/*

			 * If we get to here then a problem occured 

			 * and we need to print what went wrong

			 */

			messageExp.printStackTrace();

		}

	}
}