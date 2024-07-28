package home.hw.module15hw.sevice;

import home.hw.module15hw.model.Note;
import home.hw.module15hw.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    @Autowired
    public NoteService (NoteRepository noteRepository){
        this.noteRepository = noteRepository;

        Note note = new Note();
        note.setTitle("Note 1");
        note.setContent("Reading materials");
        noteRepository.add(note);

        Note note1 = new Note();
        note1.setTitle("HW");
        note1.setContent("Do homework");
        noteRepository.add(note1);
    }
    public List<Note> listAll(){
        return noteRepository.listAll();
    }
    public Note add(Note note){
        return noteRepository.add(note);
    }
    public void deleteById(long id){
        noteRepository.deleteById(id);
    }
    public void update(Note note){
        noteRepository.update(note);
    }
    public Note getById(long id){
        return noteRepository.getById(id);
    }
}
