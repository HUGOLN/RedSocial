package com.redSocial;

import java.util.*;

public class Post {

    private String content;
    private Date postDate;
    private List<Comentario> comentarios;



    private int postID = 0;
    private static int postCounter = 0;


    HashMap<String, String> multimedia = new HashMap<>();

    public Post(Date postDate, String content, HashMap<String, String> multimedia) {
        this.postID = postCounter++;
        this.content = content;
        this.postDate = postDate;
        this.comentarios = new ArrayList<>();
        this.multimedia = multimedia;
    }


    public void addComment(Comentario comentario) {
        comentarios.add(comentario);
    }

    public int getNumberOfComments() {
        return comentarios.size();
    }

    public String getComments() {
        StringBuilder commentsBuilder = new StringBuilder();
        for (Comentario comentario : comentarios) {
            commentsBuilder.append(comentario.getCommentText()).append("\n--> ");
        }
        // Elimina la coma y el espacio final si hay comentarios
        if (commentsBuilder.length() > 0) {
            commentsBuilder.delete(commentsBuilder.length() - 4, commentsBuilder.length());
        }
        return commentsBuilder.toString();
    }

    public List<Comentario> getListOfComments() {
        return comentarios;
    }

    public Date getPostDate() {
        return this.postDate;
    }

    public int getPostID(){return this.postID;}

    public String getContent() {

        return this.content;

    }


    public String getMultimedia() {
        StringBuilder contentBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : multimedia.entrySet()) {
            contentBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return contentBuilder.toString();
    }
}