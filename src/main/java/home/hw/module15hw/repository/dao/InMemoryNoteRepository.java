package home.hw.module15hw.repository.dao;

import home.hw.module15hw.model.Note;
import home.hw.module15hw.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class InMemoryNoteRepository implements NoteRepository {
   Map<Long, Note> notes = new HashMap<>();
    @Override
    public List<Note> listAll() {
        return List.copyOf(notes.values());
    }

    @Override
    public synchronized Note add(Note note) {
        long maxId = notes.keySet().stream().max(Long::compareTo).orElse(0L);
        note.setId(maxId+1);
        notes.put(maxId+1,note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        notes.remove(id);
    }

    @Override
    public void update(Note note) {
        if (note.getId()==0L) {add(note); return;}
        notes.put(note.getId(),note);
    }

    @Override
    public Note getById(long id) {
        return notes.get(id);
    }
}
