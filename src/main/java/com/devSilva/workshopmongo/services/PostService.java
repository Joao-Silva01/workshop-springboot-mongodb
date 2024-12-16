package com.devSilva.workshopmongo.services;

import com.devSilva.workshopmongo.domain.Post;
import com.devSilva.workshopmongo.domain.User;
import com.devSilva.workshopmongo.dto.UserDTO;
import com.devSilva.workshopmongo.repository.PostRepository;
import com.devSilva.workshopmongo.repository.UserRepository;
import com.devSilva.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+ 24 * 60 * 60 * 1000);
        return repo.fullSearch(text,minDate,maxDate);
    }
}
