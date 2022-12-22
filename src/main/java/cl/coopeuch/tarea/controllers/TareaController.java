package cl.coopeuch.tarea.controllers;

import cl.coopeuch.tarea.model.Tarea;
import cl.coopeuch.tarea.services.TareaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarea")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH})
public class TareaController {
    TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    //The function receives a GET request, processes it and gives back a list of Todo as a response.
    @GetMapping
    public ResponseEntity<List<Tarea>> getAllTareas() {
        List<Tarea> tareas = tareaService.getTareas();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }
    //The function receives a GET request with id in the url path, processes it and returns a Tarea with the specified Id
    @GetMapping({"/{idIdentificador}"})
    public ResponseEntity<Tarea> getTarea(@PathVariable Long idIdentificador) {
        return new ResponseEntity<>(tareaService.getTareaById(idIdentificador), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Tarea and saves it to the database and returns a resource link to the created Tarea.
    @PostMapping
    public ResponseEntity<Tarea> saveTarea(@RequestBody Tarea tarea) {
        System.out.println("*******************************");

        Tarea tarea1 = tareaService.insert(tarea);
        System.out.println(tarea1.getIdIdentificador().toString());
        System.out.println("*******************************");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("tarea", "/api/v1/tarea/" + tarea1.getIdIdentificador().toString());

        return new ResponseEntity<>(tarea1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Tarea with the specified Id and returns the updated Tarea
    @PutMapping({"/{idIdentificador}"})
    public ResponseEntity<Tarea> updateTarea(@PathVariable("idIdentificador") Long idIdentificador, @RequestBody Tarea tarea) {
        tareaService.updateTarea(idIdentificador, tarea);
        return new ResponseEntity<>(tareaService.getTareaById(idIdentificador), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Tarea with the specified Id.
    @DeleteMapping({"/{idIdentificador}"})
    public ResponseEntity<Tarea> deleteTarea(@PathVariable("idIdentificador") Long idIdentificador) {
        tareaService.deleteTarea(idIdentificador);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
