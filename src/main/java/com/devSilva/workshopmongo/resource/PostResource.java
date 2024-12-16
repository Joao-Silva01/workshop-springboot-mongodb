package com.devSilva.workshopmongo.resource;

import com.devSilva.workshopmongo.domain.Post;
import com.devSilva.workshopmongo.domain.User;
import com.devSilva.workshopmongo.dto.UserDTO;
import com.devSilva.workshopmongo.resource.util.URL;
import com.devSilva.workshopmongo.services.PostService;
import com.devSilva.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @RequestMapping(value = "/titleSearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> obj = service.findByTitle(text);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findTitle(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate,new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> obj = service.fullSearch(text,min,max);
        return ResponseEntity.ok().body(obj);
    }
}
