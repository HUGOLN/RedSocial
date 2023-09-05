package com.redSocial;

import java.util.*;

public class Post {

    private String content;
    private Date postDate;
    private List<Comentario> comentarios;

    HashMap<String, String> multimedia = new HashMap<>();

    public Post(Date postDate, String content, HashMap<String, String> multimedia) {
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
            commentsBuilder.append(comentario.getCommentText()).append(", ");
        }
        // Elimina la coma y el espacio final si hay comentarios
        if (commentsBuilder.length() > 0) {
            commentsBuilder.delete(commentsBuilder.length() - 2, commentsBuilder.length());
        }
        return commentsBuilder.toString();
    }

    public List<Comentario> getListOfComments() {
        return comentarios;
    }

    public Date getPostDate() {
        return this.postDate;
    }

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