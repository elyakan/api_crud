package cl.coopeuch.tarea.services;

import cl.coopeuch.tarea.model.BooleanToStringConverter;
import cl.coopeuch.tarea.model.Tarea;
import cl.coopeuch.tarea.repositories.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaServiceImpl  implements TareaService {
    TareaRepository tareaRepository;
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public List<Tarea> getTareas() {
        List<Tarea> tarea = new ArrayList<>();
        tareaRepository.findAll().forEach(tarea::add);
        return tarea;
    }

    @Override
    public Tarea getTareaById(Long identificador) {
        return tareaRepository.findById(identificador).get();
    }

    @Override
    public Tarea insert(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void updateTarea(Long identificador, Tarea tarea) {
        Tarea tareaFromDb = tareaRepository.findById(identificador).get();
        System.out.println(tareaFromDb.toString());
        tareaFromDb.setDescripcion(tarea.getDescripcion());
        tareaFromDb.setFechaCreacion(tarea.getFechaCreacion());
        tareaFromDb.setVigente(tarea.getVigente());

        tareaRepository.save(tareaFromDb);
    }

    @Override
    public void deleteTarea(Long identificador) {
        tareaRepository.deleteById(identificador);
    }
}
