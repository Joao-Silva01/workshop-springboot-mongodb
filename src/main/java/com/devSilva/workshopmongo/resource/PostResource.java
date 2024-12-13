package com.devSilva.workshopmongo.resource;

import com.devSilva.workshopmongo.domain.Post;
import com.devSilva.workshopmongo.domain.User;
import com.devSilva.workshopmongo.dto.UserDTO;
import com.devSilva.workshopmongo.services.PostService;
import com.devSilva.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value ="/posts")
public class PostResource {

    @Autowired
    private PostService service;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
