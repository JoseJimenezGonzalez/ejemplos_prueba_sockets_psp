package datagramsockets.receptor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Receptor {
    public static void main(String[] args) {
        try{
            System.out.println("Creando socket");
            //Esta es la direccion que combina una ip con un puerto
            InetSocketAddress direccion = new InetSocketAddress("localhost", 55555);
            //Creamos el datagram socket receptor con la direccion anterior
            DatagramSocket datagramSocketReceptor = new DatagramSocket(direccion);
            System.out.println("Recibiendo mensaje");
            byte[] mensaje = new byte[50];
            DatagramPacket datagrama = new DatagramPacket(mensaje, mensaje.length);
            datagramSocketReceptor.receive(datagrama);
            System.out.println("Se ha recibido el mensaje");
            //Con el new String(mensaje) se crea un objeto de tipo String con los datos que habia en mensaje
            System.out.println("Mensaje: " + new String(mensaje).trim());
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
