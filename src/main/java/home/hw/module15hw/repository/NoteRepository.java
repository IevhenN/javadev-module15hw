package home.hw.module15hw.repository;

import home.hw.module15hw.model.Note;

import java.util.List;

public interface NoteRepository {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}
