package com.redSocial;

import com.redSocial.util.input;

import javax.xml.stream.events.Comment;
import java.io.Console;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



public class RedSocial {


//Actualizar la red social
public static void updateSocialNetwork(Usuario[] usuarios) {
    for (Usuario usuario : usuarios) {
        List<Post> userPosts = usuario.getPosts();
        for (Post post : userPosts) {
            System.out.println();
            System.out.println("Post from " + usuario.getName() + ":");
            System.out.println("Post date: " + post.getPostDate());
            System.out.println("Content: " + post.getContent());
            System.out.println("Multimedia: \n" + post.getMultimedia());
            System.out.println("Comments: " + post.getNumberOfComments());
            System.out.println("--> " + post.getComments());

            System.out.println("------------------------------");
        }
    }
}








    public static <string> void main(String[] args) {

        String yourUserName = input.string("Write your username: ");


        //Datos de relleno

        //Usuarios
        Usuario tuUsuario = new Usuario(yourUserName);
        Usuario user1 = new Usuario("User1");
        Usuario user2 = new Usuario("User2");

        //Actividad
        user1.followUser(user2);

        Date postUser1Date = new Date();
        HashMap<String, String> multimediaPost1 = new HashMap<>();
        multimediaPost1.put("type", "video");
        multimediaPost1.put("quality", "1920 x 1080");
        multimediaPost1.put("duration", "120 s");

        Post postUser1 = new Post(postUser1Date, "Buenos días!", multimediaPost1);

        Date postUser2Date = new Date();
        HashMap<String, String> multimediaPost2 = new HashMap<>();
        multimediaPost2.put("type", "image");
        multimediaPost2.put("quality", "1920 x 1080");
        multimediaPost2.put("duration", "0 s");

        Post postUser2 = new Post(postUser2Date, "Buenas tardes! Como va todo por ahi gente", multimediaPost2);


        user1.addPost(postUser1);
        user2.addPost(postUser2);


        Comentario comentario1 = new Comentario("¡Gran post!", user2);
        Comentario comentario2 = new Comentario("Pero como que buenas tardes, si es por la mañana!", user1);

        postUser1.addComment(comentario1);
        postUser2.addComment(comentario2);



        //Funcionamiento de la red social

        System.out.println("\nWelcome " + yourUserName + ", showing latest posts..." );

        Usuario[] usuarios = new Usuario[]{tuUsuario, user1, user2};
        updateSocialNetwork(usuarios);



        while (true) {
            System.out.println("\nCommand list: ");
            System.out.println("Create a new post: postadd");
            System.out.println("Follow a user: follow [username]");
            System.out.println("Unfollow a user: unfollow [username]");
            System.out.println("Add a new user: useradd [new username]");

            //En construccion
            System.out.println("Change account: login [existing username]");

            //Funcionando
            System.out.println("List all posts from a user: postlist [username]");

            //En construccion
            System.out.println("List all comments from a user: commentlist [username]");


            System.out.println("Return to network: home");
            System.out.println("Exit: exit\n");

            //para el futuro
            //System.out.println("Change account: login [existing username]");
            //System.out.println("Remove a post: rmpost [post contente]");




            String command = input.string(tuUsuario.getName() + " --> ");

            if (command.startsWith("follow ")) {
                String usernameToFollow = command.substring(7);

                Usuario userToFollow = null;
                for (Usuario usuario : usuarios) {
                    if (usuario.getName().equals(usernameToFollow)) {
                        userToFollow = usuario;
                        break; // Salir del bucle una vez que se encuentra el usuario
                    }
                }

                if (userToFollow != null) {
                    // Verificar si el usuario actual ya está siguiendo al usuario objetivo
                    if (!tuUsuario.getFollowing().contains(userToFollow)) {
                        // Seguir al usuario objetivo
                        tuUsuario.followUser(userToFollow);
                        System.out.println("Now you follow " + usernameToFollow);
                    } else {
                        System.out.println("You are already following " + usernameToFollow);
                    }
                } else {
                    System.out.println("User " + usernameToFollow + " not exist.");
                }

                List<Usuario> usuariosQueSigues = tuUsuario.getFollowing();

                System.out.println("\nYour following list:");

                for (Usuario usuario : usuariosQueSigues) {
                    System.out.println(usuario.getName());
                }

            } else if (command.startsWith("unfollow ")) {
                String usernameToUnfollow = command.substring(9);

                for (Usuario usuario : usuarios) {
                    if (usuario.getName().equals(usernameToUnfollow)) {
                        tuUsuario.unFollowUser(usuario); // Deja de seguir al usuario
                        System.out.println("You have stopped following " + usernameToUnfollow);
                        break; // Sal del bucle una vez que encuentres al usuario
                    }
                }

                System.out.println("\nYour following list:");

                List<Usuario> usuariosQueSigues = tuUsuario.getFollowing();
                for (Usuario usuario : usuariosQueSigues) {
                    System.out.println(usuario.getName());
                }

            } else if (command.startsWith("useradd ")) {
                String newUsername = command.substring(8);

                // Verificar si el nombre de usuario ya existe
                boolean userExists = false;
                for (Usuario existingUser : usuarios) {
                    if (existingUser.getName().equals(newUsername)) {
                        userExists = true;
                        break;
                    }
                }

                if (!userExists) {
                    // Si el nombre de usuario no existe, crea un nuevo usuario y agrégalo a la matriz
                    Usuario newUser = new Usuario(newUsername);
                    usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
                    usuarios[usuarios.length - 1] = newUser;
                    System.out.println("User '" + newUsername + "' created successfully.");
                } else {
                    System.out.println("The username '" + newUsername + "' already exists, please choose another one.");
                }

            } else if (command.equals("postadd")) {
                // Solicitar al usuario que ingrese el contenido del nuevo post
                String content = input.string("What do you want to tell the world? --> ");

                // Solicitar al usuario que ingrese detalles multimedia (tipo, calidad, duración)

                String putMedia = input.string("Do you want to add multimedia content to the new post? --> ");

                String type = "Nothing";
                String quality = "Nothing";
                String duration = "Nothing";

                if (putMedia.equals("yes") || putMedia.equals("y") || putMedia.equals("si")) {

                    System.out.println("Enter media details:");
                    type = input.string("Type (image, video, GIF...): ");
                    quality = input.string("Quality (1920 x 1080 ...): ");
                    duration = input.string("Duration (120s ...): ");
                }
                // Crear un HashMap para almacenar los detalles multimedia
                HashMap<String, String> multimedia = new HashMap<>();
                multimedia.put("type", type);
                multimedia.put("quality", quality);
                multimedia.put("duration", duration);

                Date postDate = new Date();

                // Crear un nuevo post y avisar por consola
                Post newPost = new Post(postDate, content, multimedia);
                tuUsuario.addPost(newPost);
                System.out.println("New post created successfully!");
            } else if (command.startsWith("postlist ")) {
                String usernameToList = command.substring(9);

                Usuario userToDisplay = null;
                for (Usuario usuario : usuarios) {
                    if (usuario.getName().equals(usernameToList)) {
                        userToDisplay = usuario;
                        break;  // Sal del bucle una vez que se encuentre el usuario
                    }
                }

                // Verificar si se encontró el usuario
                if (userToDisplay != null) {
                    // Obtener la lista de publicaciones del usuario y mostrarlas
                    List<Post> userPosts = userToDisplay.getPosts();
                    System.out.println("Posts from " + usernameToList + ":");
                    for (Post post : userPosts) {
                        System.out.println("Post date: " + post.getPostDate());
                        System.out.println("Content: " + post.getContent());
                        System.out.println("Multimedia: \n" + post.getMultimedia());
                        System.out.println("Comments: " + post.getNumberOfComments());
                        System.out.println("--> " + post.getComments());
                        System.out.println("------------------------------");
                    }
                } else {
                    System.out.println("User not found: " + usernameToList);
                }













            //Todavia no funciona, pendiente de corregir

            } else if (command.startsWith("commentlist ")) {
                String usernameToCommentList = command.substring(12);

                // Busca el usuario correspondiente en la matriz de usuarios
                Usuario userToCheck = null;
                for (Usuario usuario : usuarios) {
                    if (usuario.getName().equals(usernameToCommentList)) {
                        userToCheck = usuario;
                        break;
                    }
                }

                if (userToCheck != null) {
                    // Obtiene la lista de publicaciones del usuario
                    List<Post> userPosts = userToCheck.getPosts();

                    System.out.println("Comments by " + usernameToCommentList + ":");

                    // Recorre todos los posts
                    for (Post post : userPosts) {
                        List<Comentario> comentarios = post.getListOfComments();

                        // Filtra los comentarios hechos por el usuario en cada publicación
                        for (Comentario comentario : comentarios) {
                            if (comentario.getCommentUser() == userToCheck) {
                                System.out.println("Post date: " + post.getPostDate());
                                System.out.println("Content: " + post.getContent());
                                System.out.println("Comment: " + comentario.getCommentText());
                                System.out.println("--");
                            }
                        }
                    }
                } else {
                    System.out.println("User not found.");
                }













            }else if (command.startsWith("login ")){
                String usernameToLogin = command.substring(6);

                boolean usrChanged = false;

                // Buscar el usuario correspondiente en la matriz de usuarios
                for (Usuario usuario : usuarios) {
                    if (usuario.getName().equals(usernameToLogin)) {
                        tuUsuario = usuario;
                        usrChanged = true;
                        System.out.println("Logged in as " + usernameToLogin);
                        break; // Salir del bucle una vez que se encuentra el usuario
                    }
                }

                if (usrChanged == false) {
                    System.out.println("User not found: " + usernameToLogin);
                }











            }else if (command.equals("home")){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    updateSocialNetwork(usuarios);
            } else if (command.equals("exit")) {
                // Salir del bucle y finalizar el programa
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }


    }

