package cl.coopeuch.tarea.repositories;

import cl.coopeuch.tarea.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository  extends CrudRepository<Tarea, Long> {
}


