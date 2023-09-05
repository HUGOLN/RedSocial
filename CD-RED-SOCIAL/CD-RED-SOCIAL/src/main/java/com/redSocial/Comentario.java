package com.redSocial;

import java.util.Date;

public class Comentario {
    private String commentText;
    private Date commentDate;
    private Usuario commentUser;


    public Comentario(String commentText, Usuario commentUser) {
        this.commentText = commentText;
        this.commentDate = new Date();
        this.commentUser = commentUser;
    }

    public String getCommentText() {
        String userComment = this.commentUser.getName();
        String commentContent = this.commentText;
        String completeComment = userComment + ": " + commentContent;
        return completeComment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public Usuario getCommentUser() {
        return commentUser;
    }
}
