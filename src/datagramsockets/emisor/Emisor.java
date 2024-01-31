package datagramsockets.emisor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Emisor {
    public static void main(String[] args) {
        try{
            System.out.println("Creando Socket Datagram");
            //Con esto creamos el datagram socket que se va a encargar de enviar el mensaje
            DatagramSocket datagramSocketEmisor = new DatagramSocket();
            //En esta parte vamos a empezar a mandar el mensaje
            System.out.println("Enviando mensaje");
            //Declaramos e instanciamos el mensaje que se va a enviar
            String mensaje = "Este mensaje se manda desde el emisor";
            //InetAdress permite trabajar con direcciones ip y nombres de host y proporciona
            //metodos para obtener informacion relacionada con ellas
            //Con la sigueinte linea de codigo se optiene la direccion ip asociada con el
            //nombre localhost
            InetAddress direccionIP = InetAddress.getByName("localhost");
            DatagramPacket datagrama = new DatagramPacket(
                    mensaje.getBytes(),        // Datos a enviar (en forma de arreglo de bytes)
                    mensaje.getBytes().length,  // Longitud de los datos a enviar
                    direccionIP,                // Dirección IP del destinatario
                    55555                      // Puerto del destinatario
            );
            datagramSocketEmisor.send(datagrama);//El emisor envia el datagrama
            System.out.println("Mensaje enviado");
            System.out.println("Cerrando el socket");
            datagramSocketEmisor.close();
            System.out.println("Terminado");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
