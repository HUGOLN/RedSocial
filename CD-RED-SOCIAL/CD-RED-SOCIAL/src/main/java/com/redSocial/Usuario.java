package com.redSocial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Usuario {
    private String name;
    private List<Usuario> following;
    private List<Post> posts;


    public Usuario(String nombre) {
        this.name = nombre;
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void followUser(Usuario usuario) {
        following.add(usuario);
    }
    public void unFollowUser(Usuario usuario) {
        following.remove(usuario);
    }
    public void addPost(Post post) {
        posts.add(post);
    }
    public void rmPost(Post post) {
        posts.remove(post);
    }


    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Usuario> getFollowing() {
        return following;
    }

}