package cl.coopeuch.tarea.services;
import cl.coopeuch.tarea.model.Tarea;
import java.util.List;

public interface TareaService {
    List<Tarea> getTareas();

    Tarea getTareaById(Long identifocador);

    Tarea insert(Tarea tarea);

    void updateTarea(Long identifocador, Tarea tarea);

    void deleteTarea(Long identifocador);
}
