package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello App Java!" );
        String jar = "out/artifacts/Random10_jar/Random10.jar";

        ProcessBuilder pb = new ProcessBuilder(
                ("java -jar "+jar).split(" "));

        //pb.inheritIO();

        Process random10 = pb.start();

        //Leer Entrada del usuario
        Scanner userInput = new Scanner(System.in);

        //Mostramos al usuario el mensaje de bienvenida
        System.out.println("Bienvenido, he pensado en un número, prueba");


        int valor = 0;
        try {
            valor = Integer.parseInt(userInput.nextLine());
        } catch (Exception e){
            System.out.println("Prueba otra vez");
        }

        //Entrada estándar de Random10
        PrintWriter entradaRandom10 =
                new PrintWriter(random10.getOutputStream(),true);

        entradaRandom10.println(valor);

        //Salida estándar de Random10
        Scanner salidaRandom10 =
                new Scanner(random10.getInputStream());

        String respuestaRandom10 = salidaRandom10.nextLine();

        if ("true".equals(respuestaRandom10)){
            System.out.println("Has Ganado!");
        } else {
            System.out.println("Sigue intentándolo!");
        }


    }
}
