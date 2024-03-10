package com.parking.controllers.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.SpaceService;
import com.parking.services.spaces.exception.SpaceException;
import com.parking.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/spaces")
public class SpacesController {
    private SpaceService service;

    @Autowired
    public void SpacesController(SpaceService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spaces> getSpaceByIdController(@PathVariable String id) throws SpaceException {
        try {
            Spaces space = this.service.getSpace(id);
            return ResponseEntity.ok().body(space);
        }catch (SpaceException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping()
    public ResponseEntity<Spaces> createSpaceController(@RequestBody SpacesDTO spaceDTO){
            Spaces space = this.service.Create(spaceDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(space);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpaceController(@PathVariable String id) throws  EmptyResultDataAccessException{
        try {
            this.service.deleteSpace(id);
            return ResponseEntity.ok().build();
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Spaces>> getAllSpacesByUser(@PathVariable String id) {
        try {
            List<Spaces> spaces = service.getAllSpaceByUser(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(spaces);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
